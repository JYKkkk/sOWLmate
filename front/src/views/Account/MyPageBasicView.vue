<template>
  <v-container>
    <v-row>
      <v-col cols="4" class="auth-card">
        <MyPageNavigation class="mypage-nav-position" />
      </v-col>
      <v-col cols="8">
        <v-main>
          <router-view />
        </v-main>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import MyPageNavigation from '@/components/Account/MyPage/MyPageNavigation.vue';

export default {
  name: 'MyPageBasicView',
  components: {
    MyPageNavigation,
  },
};
</script>

<style scoped>
.mypage-nav-position {
  position: relative;
  left: 12rem;
}
</style>
