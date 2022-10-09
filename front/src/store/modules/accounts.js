// import { createStore } from 'vuex'
import axios from 'axios';
import router from '@/router';
import sowl from '@/api/sowl';

export const accounts = {
  state: {
    token: sessionStorage.getItem('token') || '',
    currentUser: '',
    loginFail: 'success',
    idCheck: false,
    idChecked: false,
    emailValidCheck: false,
    idUsernameCheck: false,
    passwordDoubleCheck: false,
    passwordDoubleChecked: false,
    nicknameCheck: false,
    idEmailCheck: '',
    languageList: [],
    interestList: [],
    regionList: [],
    userInterests: [],
    userInfo: {},
    userList: [],
  },
  getters: {
    isLoggedIn: (state) => !!state.token,
    authHeader: (state) => state.token,
    currentUser: (state) => state.currentUser,
    isLoginFail: (state) => state.loginFail,
    isIdCheck: (state) => state.idCheck,
    isIdChecked: (state) => state.idChecked,
    isEmailValidCheck: (state) => state.emailValidCheck,
    isIdUsernameCheck: (state) => state.idUsernameCheck,
    isPasswordDoubleCheck: (state) => state.passwordDoubleCheck,
    isPasswordDoubleChecked: (state) => state.passwordDoubleChecked,
    isIdEmailCheck: (state) => state.idEmailCheck,
    isNicknameCheck: (state) => state.nicknameCheck,
    languageList: (state) => state.languageList,
    regionList: (state) => state.regionList,
    InterestList: (state) => state.interestList,
    userInfo: (state) => state.userInfo,
    userList: (state) => state.userList,
  },
  mutations: {
    SET_TOKEN: (state, newToken) => (state.token = newToken),
    REMOVE_TOKEN: (state) => (state.token = ''),
    SET_CURRENT_USER: (state, user) => (state.currentUser = user),
    LOGIN_FAIL: (state, checked) => (state.loginFail = checked),
    ID_CHECK: (state, checked) => (state.idCheck = checked),
    ID_CHECKED: (state, checked) => (state.idChecked = checked),
    EMAIL_VALID_CHECK: (state, checked) => (state.emailValidCheck = checked),
    ID_USERNAME_CHECK: (state, checked) => (state.idUsernameCheck = checked),
    PASSWORD_DOUBLE_CHECK: (state, checked) =>
      (state.passwordDoubleCheck = checked),
    PASSWORD_DOUBLE_CHECKED: (state, checked) =>
      (state.passwordDoubleChecked = checked),
    NICKNAME_CHECK: (state, checked) => (state.nicknameCheck = checked),
    ID_EMAIL_CHECK: (state, checked) => (state.idEmailCheck = checked),
    GET_LANGUAGE_LIST: (state, list) => (state.languageList = list),
    GET_REGION_LIST: (state, list) => (state.regionList = list),
    GET_INTEREST_LIST: (state, list) => (state.interestList = list),
    SET_USER_INTEREST: (state, interestName) =>
      state.userInterests.push(interestName),
    GET_USER_INFO: (state, data) => (state.userInfo = data),
    GET_USER_LIST: (state, data) => (state.userList = data),
  },
  actions: {
    removeToken({ commit }) {
      commit('SET_TOKEN', '');
      sessionStorage.setItem('token', '');
    },
    login({ commit, dispatch }, userData) {
      axios({
        url: sowl.users.login(),
        method: 'post',
        data: userData,
      })
        .then((response) => {
          if (response.data['message'] === 'fail') {
            commit('LOGIN_FAIL', 'fail');
          } else {
            commit('SET_TOKEN', response.data['access-token']);
            commit('SET_CURRENT_USER', userData.id);
            dispatch('getInterestList');
            dispatch('getUserInfo');

            sessionStorage.setItem('token', response.data['access-token']);
            if (userData.justsingup) {
              router.push({ name: 'MypageEditInterestView' });
            } else {
              router.push({ name: 'HomeView' });
            }
          }
        })
        .catch((error) => {
          console.error(error);
        });
    },
    gooleLogin({ commit, dispatch }, userData) {
      axios({
        url: sowl.users.googleLogin(),
        method: 'post',
        data: userData,
      })
        .then((response) => {
          if (response.data['message'] === 'fail') {
            commit('LOGIN_FAIL', 'fail');
          } else {
            commit('SET_TOKEN', userData.token);
            commit('SET_CURRENT_USER', userData.id);
            dispatch('getInterestList');
            commit('GET_USER_INFO', response.data.userInfo);
            sessionStorage.setItem('token', userData.token);
            router.push({ name: 'HomeView' });
            alert('성공적으로 login 되었습니다.');
          }
        })
        .catch((error) => {
          console.error(error);
        });
    },
    logout({ dispatch, commit }) {
      dispatch('removeToken');
      commit('SET_CURRENT_USER', '');
      alert('성공적으로 logout되었습니다.');
      router.push({ name: 'HomeView' });
    },
    signup({ dispatch }, userData) {
      axios({
        url: sowl.users.users(),
        method: 'post',
        data: userData,
      })
        .then(() => {
          const loginData = {
            id: userData.id,
            password: userData.password,
            justsingup: 1,
          };
          dispatch('login', loginData);
        })
        .catch((error) => {
          console.error(error);
        });
    },
    // Check
    idCheck({ commit }, id) {
      const userId = {
        userId: id,
      };
      axios({
        url: sowl.users.idCheck(),
        method: 'get',
        headers: userId,
      })
        .then((response) => {
          if (response.data != 'exist') {
            commit('ID_CHECK', true);
          } else {
            commit('ID_CHECK', false);
          }
          commit('ID_CHECKED', true);
        })
        .catch((error) => {
          console.error(error);
        });
    },
    emailValidCheck({ commit }, id) {
      const validateEmail =
        /^[A-Za-z0-9_\\.\\-]+@[A-Za-z0-9\\-]+\.[A-Za-z0-9\\-]+/;
      if (!validateEmail.test(id) || !id) {
        commit('EMAIL_VALID_CHECK', false);
        commit('ID_CHECK', false);
      } else {
        commit('EMAIL_VALID_CHECK', true);
      }
    },
    passwordDoubleCheck({ commit }, payload) {
      let checked = false;
      if (payload.password != '' && payload.password2 != '') {
        commit('PASSWORD_DOUBLE_CHECKED', true);
        if (payload.password === payload.password2) {
          checked = true;
        }
      }
      commit('PASSWORD_DOUBLE_CHECK', checked);
    },
    nicknameCheck({ commit }, nickname) {
      axios({
        url: sowl.users.nicknameCheck(),
        method: 'post',
        data: {
          userNickname: nickname,
        },
      })
        .then((response) => {
          if (response.data != 'exist' && nickname != '') {
            commit('NICKNAME_CHECK', true);
          } else {
            commit('NICKNAME_CHECK', false);
          }
        })
        .catch((error) => {
          console.error(error);
        });
    },
    idEmailCheck({ commit }, userId) {
      const Id = {
        id: userId,
      };
      axios({
        url: sowl.users.idEmailCheck(),
        method: 'post',
        data: Id,
      })
        .then((response) => {
          commit('ID_EMAIL_CHECK', String(response.data));
        })
        .catch((error) => {
          console.error(error);
        });
    },
    // Get List
    getLanguageList({ commit }) {
      axios({
        url: sowl.categories.language(),
      })
        .then((response) => {
          commit('GET_LANGUAGE_LIST', response.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    getRegionList({ commit }) {
      axios({
        url: sowl.categories.region(),
      })
        .then((response) => {
          commit('GET_REGION_LIST', response.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    getInterestList({ commit }) {
      axios({
        url: sowl.categories.interest(),
      })
        .then((response) => {
          commit('GET_INTEREST_LIST', response.data);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    // Save
    async userInterestSave({ state }, interestindexs) {
      // 기존에 저장된 관심사 뺴고 axios 요청
      try {
        let current = [];
        let now = [];
        for (const currentInterest of state.userInfo.interests) {
          current.push(currentInterest['title']);
        }
        for (const index of interestindexs) {
          const interestName = state.interestList[index];
          now.push(interestName);
          if (!current.includes(interestName)) {
            await axios({
              url: sowl.interests.userInterest(),
              data: {
                userId: state.currentUser,
                interest: {
                  title: interestName,
                },
              },
              method: 'post',
            });
            // console.log('관심사등록', interestName);
            // commit('SET_CURRENT_USER', interestName);
          }
        }
        // 기존에는 있는데 넘겨준 interestindexs에 없다면 삭제 요청
        for (const currentInterest of current) {
          if (!now.includes(currentInterest)) {
            axios({
              url: sowl.interests.userInterest(),
              data: {
                userId: state.currentUser,
                interest: {
                  title: currentInterest,
                },
              },
              method: 'delete',
            });
            // console.log('삭제', currentInterest);
          }
        }
      } catch (err) {
        console.log('err', err);
      }
      // dispatch('getUserInfo');
      alert('관심사 변경 완료');
    },
    getUserInfo({ state, commit }) {
      const data = {
        id: state.currentUser,
      };
      axios({
        url: sowl.users.info(),
        method: 'post',
        headers: {
          'access-token': state.token,
        },
        data,
      })
        .then((response) => {
          commit('GET_USER_INFO', response.data.userInfo);
        })
        .catch((error) => {
          console.error(error);
        });
    },
    getUserList({ commit }) {
      axios({
        url: sowl.users.userList(),
        method: 'get',
      }).then((response) => {
        commit('GET_USER_LIST', response.data);
      });
    },
    // Modify
    modifyUserInfo({ state, commit }, payload) {
      // 페이로드에 { 'nickname' : 'user1' } 이런 식으로 넘어옴
      const sub = Object.keys(payload)[0];
      let data = {
        userId: state.userInfo['id'],
        user: {
          nickname: state.userInfo['nickname'],
          region: state.userInfo['region'],
          language: state.userInfo['language'],
          preferenceLanguage: state.userInfo['preferenceLanguage'],
          name: state.userInfo['nickname'],
        },
      };
      data.user[sub] = payload[sub];
      axios({
        url: sowl.users.users(),
        method: 'put',
        data,
      })
        .then((response) => {
          commit('GET_USER_INFO', response.data);
          alert(`${sub}가 성공적으로 변경되었습니다.`);
        })
        .catch((error) => {
          console.error(error);
        });
    },
    resetPassword({ commit }, userData) {
      axios({
        url: sowl.users.idUsernameCheck(),
        method: 'post',
        data: userData,
      })
        .then((response) => {
          // 아이디와 닉네임이 일치할 때
          if (response.data['check']) {
            commit('ID_USERNAME_CHECK', true);
            axios({
              url: sowl.users.resetPassword(),
              method: 'post',
              data: userData,
            })
              .then(() => {
                commit('ID_USERNAME_CHECK', true);
              })
              .catch((error) => {
                console.error(error);
              });
          }
        })
        .catch((error) => {
          console.error(error);
        });
    },
  },
};
