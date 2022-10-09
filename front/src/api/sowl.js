// const HOST = 'https://i7b308.p.ssafy.io:8080/api/v1/';
const HOST = 'https://i7b308.p.ssafy.io/api/v1/';
// const HOST = 'https://localhost:8080/api/v1/';
const NODE = 'https://i7b308.p.ssafy.io/meet/';
// const NODE = 'https://localhost:8443/';
const FRONT = 'https://i7b308.p.ssafy.io/';
// const FRONT = 'http://localhost:80/';

const ACCOUNTS = 'auth/';
const USERS = 'users/';
const INTEREST = 'interest/';
const CATEGORIS = 'categories/';
const CONFERENCE = 'conference/';
const PHOTOBOOTH = 'photo-booth/';
const INTIMACY = 'intimacy/';
const LETTER = 'letter/';

export default {
  front: {
    googleRequest: () => FRONT,
  },
  users: {
    login: () => HOST + ACCOUNTS + 'login/',
    logout: () => HOST + ACCOUNTS + 'logout/',
    info: () => HOST + ACCOUNTS + 'info/',
    googleLogin: () => HOST + ACCOUNTS + 'google/' + 'info/',
    users: () => HOST + USERS,
    loginType: () => HOST + USERS + 'login-type',

    userList: () => HOST + USERS + 'list/',

    profile: () => HOST + USERS + 'profile/',
    changePassword: () => HOST + USERS + 'modifypw/', // 비밀번호 알고있을 때

    idCheck: () => HOST + USERS + 'exist/' + 'id/',
    nicknameCheck: () => HOST + USERS + 'exist/' + 'nickname/',
    idUsernameCheck: () => HOST + ACCOUNTS + 'findpw/',
    idEmailCheck: () => HOST + ACCOUNTS + 'exist/' + 'id/' + 'sendemail/',
    resetPassword: () => HOST + ACCOUNTS + 'findpw/' + 'sendemail/',
  },
  interests: {
    interestList: () => HOST + INTEREST + 'list/',
    userInterest: () => HOST + INTEREST,
  },
  categories: {
    language: () => HOST + CATEGORIS + 'language/',
    region: () => HOST + CATEGORIS + 'region/',
    interest: () => HOST + CATEGORIS + 'interest/',
  },
  conference: {
    conferenceList: () => HOST + CONFERENCE + 'list/',
    conferenceInsterestList: (interest) =>
      HOST + CONFERENCE + 'list/' + `${interest}`,
    conferenceLanguageList: (language) =>
      HOST + CONFERENCE + 'list/' + `${language}`,
    conferenceInterestLanguageList: (interest, language) =>
      HOST +
      CONFERENCE +
      'list/' +
      'both?interest=' +
      `${interest}` +
      '&language=' +
      `${language}`,
    conferenceCreate: () => HOST + CONFERENCE + 'create/',
    conferenceEnter: () => HOST + CONFERENCE + 'enter/',
    conferenceDelete: () => HOST + CONFERENCE + 'exit/',
  },
  webRTC: {
    conferenceSend: (user1) => NODE + '?from=' + `${user1}` + '&to=',
    conferenceReceive: (user1, user2) =>
      NODE + '?from=' + `${user1}` + '&to=' + `${user2}`,
  },
  photoBooth: {
    userPhotos: () => HOST + PHOTOBOOTH + 'list/' + 'user',
  },
  friend: {
    friendList: () => HOST + 'penpal/list/user/',
  },
  intimacy: {
    intimacy: () => HOST + INTIMACY + 'positive/',
  },
  letter: {
    letterList: () => HOST + LETTER + 'list/',
    singleLetterList: () => HOST + LETTER + 'single/',
    letteCreate: () => HOST + LETTER,
    letterFavorite: () => HOST + LETTER + 'favorite/' + 'on/',
    letterFavoriteOff: () => HOST + LETTER + 'favorite/' + 'off',
  },
};
