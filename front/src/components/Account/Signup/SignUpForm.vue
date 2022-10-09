<template>
  <div>
    <h1 class="mt-16 mb-6">Sign up</h1>
    <SocialLogin />
    <v-row class="mt-4">
      <v-col cols="0" xs="1" lg="4">
        <hr />
      </v-col>
      <v-col>
        <p class="p-small divide-text">or continue with</p>
      </v-col>
      <v-col cols="0" xs="1" lg="4">
        <hr />
      </v-col>
    </v-row>
    <form @submit.prevent="signup(userData)">
      <h4 class="mt-2">기본정보</h4>
      <!-- 아이디 관련 type에 이메일이라고 쓰면 이메일 형식인지 검사해주는데 안예쁨-->
      <div>
        <div>
          <v-row class="mt-1">
            <v-text-field
              color="primary"
              prepend-inner-icon="mdi-account-outline"
              label="아이디(Email)"
              variant="underlined"
              v-model="userData.id"
              @input="resetId()"
            ></v-text-field>
            <!-- 중복 검사 -->
            <button
              class="sub-btn btn-small confirm-position"
              v-if="!isIdChecked"
              @click="idCheck(userData.id)"
            >
              <span> 중복 검사 </span>
            </button>
            <button
              class="sub-btn btn-small confirm-position"
              v-if="isIdCheck && isEmailValidCheck && isIdEmailCheck === ''"
              @click="idEmailCheck(userData.id), (email_button = true)"
            >
              <span>인증요청</span>
            </button>
          </v-row>
          <div class="mt-2">
            <p v-if="!isIdChecked" class="form-err">중복 검사를 해주세요.</p>
            <p v-if="!isEmailValidCheck && isIdCheck" class="form-err">
              이메일 형식이 아닙니다.
            </p>
            <p v-if="!isIdCheck && isIdChecked" class="form-err">
              이미 있는 아이디 입니다.
            </p>
            <p
              v-if="
                isIdCheck &&
                isEmailValidCheck &&
                !authentication_check &&
                userData.id &&
                !email_button
              "
              class="form-blue"
            >
              사용 가능한 아이디 입니다. 이메일 인증을 해주세요.
            </p>
            <p v-if="email_button && userData.id" class="form-blue">
              인증 메일을 보냈습니다. 메일을 확인해주세요.
            </p>
          </div>
        </div>
        <!-- 이메일 인증 확인 -->
        <v-row v-if="isIdEmailCheck != '' && !authentication_check">
          <v-text-field
            color="primary"
            prepend-inner-icon="mdi-email-check-outline"
            label="인증 번호 입력"
            variant="underlined"
            v-model="authentication_num"
            @input="resetId()"
          ></v-text-field>
          <button
            v-if="
              isIdCheck &&
              isEmailValidCheck &&
              isIdEmailCheck != '' &&
              !authentication_check
            "
            class="sub-btn btn-small confirm-position mr-1"
            @click="authenticationNum(isIdEmailCheck)"
          >
            <span>확인</span>
          </button>
          <button
            v-if="
              isIdCheck &&
              isEmailValidCheck &&
              isIdEmailCheck != '' &&
              !authentication_check
            "
            class="sub-btn btn-small confirm-position"
            @click="idEmailCheck(userData.id)"
          >
            <span>재요청</span>
          </button>
        </v-row>
        <div class="mt-2">
          <p v-if="authentication_check" class="form-blue">
            인증이 완료되었습니다.
          </p>
          <p
            v-if="authentication_checked && !authentication_check"
            class="form-err"
          >
            인증 번호가 틀렸습니다.
          </p>
        </div>
      </div>
      <!-- 비밀번호 -->
      <v-row>
        <v-text-field
          color="primary"
          prepend-inner-icon="mdi-lock-outline"
          variant="underlined"
          type="password"
          label="비밀번호"
          v-model="userData.password"
          @input="
            passwordDoubleCheck({
              password: userData.password,
              password2: password2,
            })
          "
        ></v-text-field>
      </v-row>
      <!-- 비밀번호 확인 -->
      <div>
        <v-row>
          <v-text-field
            color="primary"
            prepend-inner-icon="mdi-lock-outline"
            variant="underlined"
            type="password"
            label="비밀번호 확인"
            v-model="password2"
            @input="
              passwordDoubleCheck({
                password: userData.password,
                password2: password2,
              })
            "
          ></v-text-field>
        </v-row>
        <div class="mt-2">
          <p
            v-if="!isPasswordDoubleCheck && isPasswordDoubleChecked"
            class="form-err"
          >
            비밀번호가 일치하지 않습니다
          </p>
          <p
            v-if="!isPasswordDoubleCheck && !isPasswordDoubleChecked"
            class="form-err"
          >
            비밀번호 확인이 필요합니다
          </p>
        </div>
      </div>
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
        <p class="signup-explain">매칭되고싶은 사용자 언어를 선택해주세요.</p>
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
        v-bind:disabled="
          !isPasswordDoubleCheck ||
          !authentication_check ||
          !isNicknameCheck ||
          userData.name === ''
        "
      >
        회원가입
      </v-btn>
    </form>
  </div>
</template>

<script>
import { mapActions, mapGetters, mapMutations } from 'vuex';
import SocialLogin from '@/components/Account/Login/SocialLogin.vue';
export default {
  components: {
    SocialLogin,
  },
  data() {
    return {
      userData: {
        id: '',
        password: '',
        nickname: '',
        region: '',
        language: '',
        preferenceLanguage: '',
        name: '',
      },
      password2: '',
      authentication_num: '',
      authentication_check: false,
      authentication_checked: false,
      email_button: false,
    };
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
    ...mapMutations(['ID_CHECKED', 'ID_CHECK', 'ID_EMAIL_CHECK']),
    resetId() {
      this.ID_CHECKED(false);
      this.ID_CHECK(false);
      this.ID_EMAIL_CHECK('');
      this.emailValidCheck(this.userData.id);
      this.authentication_check = false;
      this.authentication_checked = false;
    },
    authenticationNum(isIdEmailCheck) {
      this.authentication_checked = true;
      if (this.authentication_num === isIdEmailCheck) {
        this.authentication_check = true;
        return;
      }
    },
  },
  mounted() {
    this.getLanguageList();
    this.getRegionList();
  },
};
</script>

<style scoped>
.divide-text {
  position: relative;
  top: -0.8rem;
}
.btn-small {
  width: 4rem;
}
</style>
