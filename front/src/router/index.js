import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '@/views/HomeView.vue';
import LoginView from '@/views/Account/LoginView.vue';
import LogoutView from '@/views/Account/LogoutView.vue';
import SignUpView from '@/views/Account/SignUpView.vue';
import PasswordResetView from '@/views/Account/PasswordResetView.vue';
import MyPageBasicView from '@/views/Account/MyPageBasicView.vue';
import MyPageEditPasswordView from '@/views/Account/MyPageEditPasswordView.vue';
import MyPageEditInterestView from '@/views/Account/MyPageEditInterestView.vue';
import MyPageEditLanguageView from '@/views/Account/MyPageEditLanguageView.vue';
import MyPageEditPreferenceLanguageView from '@/views/Account/MyPageEditPreferenceLanguageView.vue';
import MyPageBasicInfoView from '@/views/Account/MyPageBasicInfoView.vue';
import RoomMainView from '@/views/Room/RoomMainView.vue';
import RoomCreateView from '@/views/Room/RoomCreateView.vue';
import RoomMainListView from '@/views/Room/List/RoomMainListView.vue';
import RoomFriendsListView from '@/views/Room/List/RoomFriendsListView.vue';
import GoogleRegisterView from '@/views/Account/GoogleRegisterView.vue';
import friendsView from '@/views/Friends/friendsView.vue';
import MettingRateView from '@/views/Friends/MettingRateView.vue';
import PhotoBoothView from '@/views/Profile/PhotoBoothView.vue';
import LetterCreateView from '@/views/Friends/LetterCreateView.vue';
import LetterListView from '@/views/Friends/LetterListView.vue';
import LetterDetailView from '@/views/Friends/LetterDetailView.vue';

const routes = [
  { path: '/', name: 'HomeView', component: HomeView },
  { path: '/auth/login/', name: 'LoginView', component: LoginView },
  { path: '/auth/logout/', name: 'LogoutView', component: LogoutView },
  { path: '/auth/sign-up/', name: 'SignUpView', component: SignUpView },
  {
    path: '/auth/google/sign-up',
    name: 'GoogleRegisterView',
    component: GoogleRegisterView,
  },
  {
    path: '/auth/password-reset/',
    name: 'PasswordResetView',
    component: PasswordResetView,
  },
  {
    path: '/auth/mypage/',
    name: 'MyPageBasicView',
    component: MyPageBasicView,
    children: [
      {
        path: 'basic-info/',
        name: 'MyPageBasicInfoView',
        component: MyPageBasicInfoView,
      },
      {
        path: 'change-password/',
        name: 'MyPageEditPasswordView',
        component: MyPageEditPasswordView,
      },
      {
        path: 'change-interest/',
        name: 'MypageEditInterestView',
        component: MyPageEditInterestView,
      },
      {
        path: 'change-language/',
        name: 'MyPageEditLanguageView',
        component: MyPageEditLanguageView,
      },
      {
        path: 'change-preferlanguage/',
        name: 'MyPageEditPreferenceLanguageView',
        component: MyPageEditPreferenceLanguageView,
      },
      {
        path: 'photo-booth/',
        name: 'PhotoBoothView',
        component: PhotoBoothView,
      },
    ],
  },
  {
    path: '/portal/rooms/',
    name: 'RoomMainView',
    component: RoomMainView,
    children: [
      {
        path: 'main/',
        name: 'RoomMainListView',
        component: RoomMainListView,
      },
      {
        path: 'friend/',
        name: 'RoomFriendsListView',
        component: RoomFriendsListView,
      },
    ],
  },
  {
    path: '/portal/rooms/new/',
    name: 'RoomCreateView',
    component: RoomCreateView,
  },
  {
    path: '/friends/',
    name: 'friendsView',
    component: friendsView,
  },
  {
    path: '/meeting/after/',
    name: 'MettingRateView',
    component: MettingRateView,
  },
  {
    path: '/letter/new/',
    name: 'LetterCreateView',
    component: LetterCreateView,
  },
  {
    path: '/letter/list/',
    name: 'LetterListView',
    component: LetterListView,
  },
  {
    path: '/letter/:pk/',
    name: 'LetterDetailView',
    component: LetterDetailView,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes: routes,
});

export default router;
