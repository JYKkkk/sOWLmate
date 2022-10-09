const HOST = 'https://3.38.245.51:8080/api/v1/';

const ACCOUNTS = 'auth/';

export default {
  users: {
    login: () => HOST + ACCOUNTS + 'login',
    logout: () => HOST + ACCOUNTS + 'logout/',
  },
};
