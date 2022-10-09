<template>
  <div class="d-flex flex-row mt-16">
    <v-tabs v-model="tab" direction="vertical" color="primary">
      <v-tab>
        <router-link :to="{ name: 'MyPageBasicInfoView' }"
          >기본정보</router-link
        >
      </v-tab>
      <v-tab>
        <router-link :to="{ name: 'MyPageEditPasswordView' }"
          >비밀번호 변경</router-link
        >
      </v-tab>
      <v-tab>
        <router-link :to="{ name: 'MyPageEditLanguageView' }"
          >언어 변경</router-link
        >
      </v-tab>
      <v-tab>
        <router-link :to="{ name: 'MyPageEditPreferenceLanguageView' }"
          >선호 언어 변경</router-link
        >
      </v-tab>
      <v-tab>
        <router-link :to="{ name: 'MypageEditInterestView' }"
          >관심사 변경</router-link
        >
      </v-tab>
      <v-tab>
        <router-link :to="{ name: 'PhotoBoothView' }">사진첩</router-link>
      </v-tab>
    </v-tabs>
  </div>
</template>

<script>
export default {
  name: 'MyPageNavigation',
  components: {},
  computed: {},
};
</script>

<style scoped></style>
