<template>
  <div>
    <h1 class="mt-16 mb-6">Login</h1>
    <form @submit.prevent="login(userData)">
      <div>
        <v-text-field
          color="primary"
          prepend-inner-icon="mdi-account-outline"
          label="아이디(Email)"
          variant="underlined"
          v-model="userData.id"
          @input="idValidCheck()"
        ></v-text-field>
        <p v-if="!isEmailValidCheck && userData.id != ''" class="form-err">
          이메일 형식으로 입력해주세요
        </p>
        <p v-if="isEmailValidCheck && isIdCheck" class="form-err">
          없는 아이디 입니다. 아이디를 정확하게 입력해주세요.
        </p>
      </div>
      <div>
        <v-text-field
          color="primary"
          prepend-inner-icon="mdi-lock-outline"
          label="비밀번호"
          variant="underlined"
          v-model="userData.password"
          type="password"
        ></v-text-field>
      </div>
      <p
        v-if="isLoginFail === 'fail' && !isIdCheck && userData.id != ''"
        class="form-err"
      >
        비밀번호가 틀렸습니다.
      </p>
      <div class="mt-1 d-flex justify-end">
        <router-link :to="{ name: 'PasswordResetView' }" class="auth-q"
          >비밀번호를 잊으셨나요?</router-link
        >
      </div>
      <v-btn
        class="main-btn btn-big mt-12"
        width="100%"
        type="submit"
        v-bind:disabled="
          userData.id === '' || userData.password === '' || isIdCheck
        "
      >
        로그인
      </v-btn>
    </form>
    <v-row class="mt-4">
      <v-col cols="0" xs="1" lg="4">
        <hr />
      </v-col>
      <v-col>
        <p class="p-small">or continue with</p>
      </v-col>
      <v-col cols="0" xs="1" lg="4">
        <hr />
      </v-col>
    </v-row>
    <v-container><SocialLogin /></v-container>
    <router-link
      :to="{ name: 'SignUpView' }"
      class="auth-q mt-8 d-flex justify-center underline"
      >처음 오셨나요?
    </router-link>
  </div>
</template>

<script>
import { mapActions, mapGetters, mapMutations } from 'vuex';
import sowl from '@/api/sowl';
import SocialLogin from '@/components/Account/Login/SocialLogin.vue';
export default {
  name: 'LoginForm',
  components: {
    SocialLogin,
  },
  data() {
    return {
      userData: {
        password: '',
        id: '',
      },
      googleConfig: {
        client_id: process.env.VUE_APP_GOOGLE_OAUTH_CLIENT_ID,
        redirect_uri:
          sowl.front.googleRequest() + 'accounts/auth/google/callback',
      },
    };
  },
  computed: {
    ...mapGetters(['isIdCheck', 'isEmailValidCheck', 'isLoginFail']),
  },
  methods: {
    ...mapActions(['login', 'idCheck', 'emailValidCheck']),
    ...mapMutations(['LOGIN_FAIL']),
    idValidCheck() {
      this.idCheck(this.userData.id);
      this.emailValidCheck(this.userData.id);
      this.LOGIN_FAIL('succcess');
    },
  },
};
</script>

<style scoped>
v-btn span {
  font-size: 0.8rem;
  line-height: -0.2rem;
}
.underline {
  text-decoration: underline;
}

.p-small {
  position: relative;
  top: -0.8rem;
}
</style>
