<template>
  <div class="mb-12">
    <v-row class="mt-6 justify-space-around">
      <div class="left">
        <v-row>
          <div class="mr-16">
            <router-link to="/">
              <div class="logo-size">
                <img
                  :src="require('@/assets/sowlImage/sowlmate_logo.png')"
                  alt="로고이미지"
                />
              </div>
            </router-link>
          </div>
          <div>
            <router-link to="/" class="mr-4"><button>Home</button></router-link>
          </div>
          <div v-if="isLoggedIn" class="mr-4">
            <router-link :to="{ name: 'RoomMainListView' }">Room</router-link>
          </div>
          <div v-if="isLoggedIn">
            <router-link :to="{ name: 'friendsView' }">친구</router-link>
          </div>
        </v-row>
      </div>
      <div class="right">
        <v-row>
          <div v-if="!isLoggedIn" class="mr-4">
            <router-link :to="{ name: 'LoginView' }"
              ><button>로그인</button></router-link
            >
          </div>
          <div v-if="!isLoggedIn">
            <router-link :to="{ name: 'SignUpView' }"
              ><button>회원가입</button></router-link
            >
          </div>
        </v-row>
        <v-menu transition="scroll-y-transition" v-if="isLoggedIn">
          <template v-slot:activator="{ props }">
            <h4 class="ma-2 p-small text-gradient" v-bind="props">
              {{ this.userInfo.nickname }}님
            </h4>
          </template>
          <v-list>
            <v-list-item>
              <v-list-item-title class="mt-2"
                ><router-link :to="{ name: 'MyPageBasicInfoView' }"
                  >마이페이지</router-link
                ></v-list-item-title
              >
              <v-list-item-title class="mt-4"
                ><router-link :to="{ name: 'LogoutView' }"
                  >로그아웃</router-link
                ></v-list-item-title
              >
            </v-list-item>
          </v-list>
        </v-menu>
      </div>
    </v-row>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';

export default {
  name: 'TheNavBar',
  components: {},
  computed: {
    ...mapGetters(['isLoggedIn', 'userInfo']),
  },
};
</script>
<style lang="scss" scoped>
.logo-size img {
  position: relative;
  height: 1.6rem;
  left: 0;
  top: 0;
}
.right {
  position: relative;
  right: 1rem;
}
</style>
