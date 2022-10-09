import axios from 'axios';
import sowl from '@/api/sowl';
import router from '@/router';

export const friends = {
  state: {
    preFriendsList: [],
    friendsList: [],
    sowlmateList: [],
    letterList: [],
    singleLetter: null,
    penpalList: [],
  },
  getters: {
    preFriendsList: (state) => state.preFriendsList,
    friendsList: (state) => state.friendsList,
    sowlmateList: (state) => state.sowlmateList,
    letterList: (state) => state.letterList,
    singleLetter: (state) => state.singleLetter,
    penpalList: (state) => state.penpalList,
  },
  mutations: {
    SET_PRE_FRIENDS_LIST: (state, friend) => state.preFriendsList.push(friend),
    SET_FRIENDS_LIST: (state, friend) => state.friendsList.push(friend),
    SET_SOWLMATE_LIST: (state, friend) => state.sowlmateList.push(friend),
    SET_LETTER_LIST: (state, list) => (state.letterList = list),
    SET_SINGLE_LETTER: (state, list) => (state.singleLetter = list),
    Get_PENPAL_LIST: (state, list) => (state.penpalList = list),
  },
  actions: {
    totalFriendList({ commit, rootState, state }) {
      const user = rootState.accounts.currentUser;
      state.preFriendsList = [];
      state.friends = [];
      state.sowlmateList = [];
      axios({
        url: sowl.friend.friendList(),
        method: 'get',
        headers: {
          fromUserId: user,
        },
      })
        .then((response) => {
          commit('Get_PENPAL_LIST', response.data);
          for (const friend of response.data) {
            if (friend.intimacyEval < 50) {
              commit('SET_PRE_FRIENDS_LIST', friend);
            } else if (friend.intimacyEval >= 50 && friend.intimacyEval < 100) {
              commit('SET_FRIENDS_LIST', friend);
            } else if (friend.intimacyEval === 100) {
              commit('SET_SOWLMATE_LIST', friend);
            }
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
    totalLetterList({ commit, rootState }) {
      const user = rootState.accounts.currentUser;
      axios({
        url: sowl.letter.letterList(),
        method: 'get',
        headers: {
          toUserId: user,
        },
      })
        .then((response) => {
          commit('SET_LETTER_LIST', response.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    goDetail({ commit }, letterNo) {
      axios({
        url: sowl.letter.singleLetterList(),
        method: 'get',
        headers: {
          letterNo: letterNo,
        },
      })
        .then((response) => {
          commit('SET_SINGLE_LETTER', response.data);
          router.push({ name: 'LetterDetailView', params: { pk: letterNo } });
        })
        .catch((err) => {
          console.log(err);
        });
    },
    sendMail({ dispatch }, myData) {
      console.log('데타', myData);
      const letterdata = {
        content: myData.content,
        fromUserId: myData.fromUserId,
        toUserId: myData.toUserId,
        title: myData.title,
        writingPad: myData.writingPad,
        writingFont: myData.writingFont,
      };
      console.log(sowl.letter.letteCreate());
      console.log(letterdata);
      axios({
        url: sowl.letter.letteCreate(),
        method: 'post',
        data: letterdata,
      })
        .then(() => {
          alert('편지를 보냈습니다');
          dispatch('totalLetterList');
          router.push({ name: 'HomeView' });
        })
        .catch((err) => console.log(err));
    },
  },
};
