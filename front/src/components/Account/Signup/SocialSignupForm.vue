<template>
  <div>
    <h1 class="mt-16 mb-6">Sign up continue</h1>
    <form @submit.prevent="signup(userData)">
      <!-- 닉네임 -->
      <div>
        <v-row>
          <v-text-field
            color="primary"
            prepend-inner-icon="mdi-robot-excited-outline"
            variant="underlined"
            label="닉네임"
            v-model="userData.nickname"
            @input="nicknameCheck(userData.nickname)"
          ></v-text-field>
        </v-row>
        <div class="mt-2">
          <p
            v-if="userData.nickname != '' && !isNicknameCheck"
            class="form-err"
          >
            이미 있는 닉네임 입니다.
          </p>
          <p v-if="isNicknameCheck" class="form-blue">
            사용할 수 있는 닉네임 입니다.
          </p>
        </div>
      </div>
      <!-- 지역 설정 -->
      <div class="mt-2">
        <h4>지역</h4>
        <p class="p-small signup-explain">현재 계신 지역을 선택해주세요.</p>
        <v-row class="mt-1">
          <v-select
            color="primary"
            prepend-inner-icon="mdi-home-search-outline"
            :items="regionList"
            v-model="userData.region"
            label="지역"
            variant="underlined"
          ></v-select>
        </v-row>
      </div>
      <!-- 사용 언어 설정 -->
      <div class="mt-2">
        <h4>언어</h4>
        <p class="p-small signup-explain">주요 사용하는 언어를 선택해주세요.</p>
        <v-row class="mt-1">
          <v-select
            color="primary"
            prepend-inner-icon="mdi-alphabet-latin"
            :items="languageList"
            v-model="userData.language"
            label="사용 언어"
            variant="underlined"
          ></v-select>
        </v-row>
      </div>
      <!-- 선호 언어 설정 -->
      <div class="mt-2">
        <h4>선호 언어</h4>
        <p class="p-small signup-explain">
          매칭되고싶은 사용자 언어를 선택해주세요.
        </p>
        <v-row class="mt-1">
          <v-select
            color="primary"
            prepend-inner-icon="mdi-account-heart-outline"
            :items="languageList"
            v-model="userData.preferenceLanguage"
            label="선호 언어"
            variant="underlined"
          ></v-select>
        </v-row>
      </div>
      <!-- 유저 이름 -->
      <div class="mt-2">
        <h4>유저 이름</h4>
        <p class="p-small signup-explain">
          유저 이름은 공개되지 않으며, 비밀번호 찾기에 이용됩니다.
        </p>
        <v-row class="mt-1">
          <v-text-field
            color="primary"
            prepend-inner-icon="mdi-key-outline"
            variant="underlined"
            label="유저 이름"
            v-model="userData.name"
          ></v-text-field>
        </v-row>
        <div class="mt-2">
          <p v-if="userData.name === ''" class="form-err">
            유저 이름을 입력해주세요.
          </p>
        </div>
      </div>
      <!-- 회원 가입 버튼 -->
      <v-btn
        class="main-btn btn-big mt-12"
        width="100%"
        type="submit"
        v-bind:disabled="!isNicknameCheck || userData.name === ''"
      >
        회원가입
      </v-btn>
    </form>
  </div>
</template>

<script>
import { mapActions, mapGetters } from 'vuex';

export default {
  name: 'GoogleRegisterView',
  data() {
    return {
      userData: {
        id: '',
        password: '',
        name: '',
        profilePictureUrl: '',
        nickname: '',
        region: '',
        language: '',
        preferenceLanguage: '',
        loginType: '1',
      },
      authentication_num: '',
      authentication_check: false,
      authentication_checked: false,
      email_button: false,
    };
  },
  created() {
    this.userData.id = this.$route.query.userid;
    this.userData.password = this.$route.query.userpwd;
    this.userData.name = this.$route.query.username;
    this.userData.profilePictureUrl = this.$route.query.userphotourl;
    this.userData.nickname = this.$route.query.usernickname;
    // console.log(this.userData);
  },
  computed: {
    ...mapGetters([
      'isPasswordDoubleCheck',
      'isPasswordDoubleChecked',
      'isIdCheck',
      'isIdChecked',
      'isEmailValidCheck',
      'isNicknameCheck',
      'isIdEmailCheck',
      'languageList',
      'regionList',
    ]),
  },
  methods: {
    ...mapActions([
      'signup',
      'passwordDoubleCheck',
      'idCheck',
      'emailValidCheck',
      'nicknameCheck',
      'idEmailCheck',
      'getLanguageList',
      'getRegionList',
    ]),
  },
  mounted() {
    this.getLanguageList();
    this.getRegionList();
  },
};
</script>

<style></style>
