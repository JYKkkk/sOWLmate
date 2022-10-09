import axios from 'axios';
import router from '@/router';
import sowl from '@/api/sowl';

export const rooms = {
  state: {
    room: {},
    roomInterests: [],
    roomAll: [],
    roomByInterest: [],
    roomByLanguage: [],
    roomByInterestLanguage: [],
    toUserNickname: '',
    fromUserNickname: '',
    preFriendsRoomList: [],
    friendsRoomList: [],
    sowlmateRoomList: [],
  },
  getters: {
    room: (state) => state.room,
    roomInterests: (state) => state.roomInterests,
    roomAll: (state) => state.roomAll,
    roomByInterest: (state) => state.roomByInterest,
    roomByLanguage: (state) => state.roomByLanguage,
    roomByInterestLanguage: (state) => state.roomByInterestLanguage,
    toUserNickname: (state) => state.toUserNickname,
    fromUserNickname: (state) => state.fromUserNickname,
    preFriendsRoomList: (state) => state.preFriendsRoomList,
    friendsRoomList: (state) => state.friendsRoomList,
    sowlmateRoomList: (state) => state.sowlmateRoomList,
  },
  mutations: {
    SET_ROOM: (state, room) => (state.room = room),
    ROOM_INTERESTS: (state, checked) => (state.roomInterests = checked),
    ROOM_ALL_LIST: (state, list) => (state.roomAll = list),
    ROOM_BY_INTEREST: (state, list) => (state.roomByInterest = list),
    ROOM_BY_LANGUAGE: (state, list) => (state.roomByLanguage = list),
    ROOM_BY_INTEREST_LANGUAGE: (state, list) =>
      (state.roomByInterestLanguage = list),
    TO_USER_NICKNAME: (state, data) => (state.toUserNickname = data),
    FROM_USER_NICKNAME: (state, data) => (state.fromUserNickname = data),
    ROOM_PRE: (state, list) => (state.preFriendsRoomList = list),
    ROOM_FRIENDS: (state, list) => (state.friendsRoomList = list),
    ROOM_SOWLMATE: (state, list) => (state.sowlmateRoomList = list),
  },
  actions: {
    createRoom({ commit, getters }, newRoom) {
      axios({
        url: sowl.conference.conferenceCreate(),
        method: 'post',
        data: newRoom,
      })
        .then((response) => {
          commit('SET_ROOM', response.data);
          // TODO : 노드 서버에게 데이터 전송
          location.replace(
            sowl.webRTC.conferenceSend(getters.fromUserNickname),
          );
          router.push({
            name: 'RoomMainListView',
          });
        })
        .catch((err) => {
          console.log(err);
        });
    },
    joinRoom({ commit, getters }, userData) {
      axios({
        url: sowl.conference.conferenceEnter(),
        method: 'put',
        data: userData,
      })
        .then((response) => {
          commit('SET_ROOM', response.data);
          // TODO : 노드 서버에게 데이터 전송
          location.replace(
            sowl.webRTC.conferenceReceive(
              getters.fromUserNickname,
              getters.toUserNickname,
            ),
          );
        })
        .catch((err) => {
          console.log(err);
        });
    },
    getAllRoomList({ commit }) {
      axios({
        url: sowl.conference.conferenceList(),
        method: 'get',
      })
        .then((response) => {
          console.log('방방방', response.data);
          commit('ROOM_ALL_LIST', response.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    getRoomList({ commit }, userData) {
      axios({
        url: sowl.conference.conferenceInterestLanguageList(
          userData.interest,
          userData.language,
        ),
        method: 'get',
      })
        .then((response) => {
          // console.log('여기', response.data);
          commit('ROOM_BY_INTEREST_LANGUAGE', response.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    getRoomListByInterest({ commit }, userData) {
      axios
        .get(sowl.conference.conferenceInsterestList(userData.interest))
        .then((response) => {
          // console.log(response.data);
          commit('ROOM_BY_INTEREST', response.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    getRoomListByLanguage({ commit }, userData) {
      axios
        .get(sowl.conference.conferenceLanguageList(userData.language))
        .then((response) => {
          // console.log(response.data);
          commit('ROOM_BY_LANGUAGE', response.data);
        });
    },
  },
};
