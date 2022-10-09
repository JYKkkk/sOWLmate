<template>
  <div>
    <h2 class="mt-16 mb-6">비밀번호 찾기</h2>
    <form @submit.prevent="resetPassword(userData)">
      <div>
        <v-text-field
          color="primary"
          prepend-inner-icon="mdi-account-outline"
          type="email"
          label="아이디(Email)"
          variant="underlined"
          v-model="userData.userId"
          @input="idCheck(userData.userId)"
        ></v-text-field>
        <p v-if="isIdCheck || !isIdChecked" class="form-err">
          아이디를 정확하게 입력해주세요.
        </p>
        <p v-if="!isIdCheck" class="form-blue">아이디가 확인되었습니다.</p>
      </div>
      <div>
        <v-text-field
          color="primary"
          prepend-inner-icon="mdi-key-outline"
          variant="underlined"
          type="text"
          label="유저 이름"
          v-model="userData.userName"
        ></v-text-field>
      </div>
      <v-btn
        class="main-btn btn-big mt-12"
        width="100%"
        type="submit"
        v-bind:disabled="isIdCheck"
        @click="showModal = true"
      >
        임시 비밀번호 전송
      </v-btn>
    </form>
    <PasswordResetModal v-if="showModal" @close="pageLink()" />
  </div>
</template>

<script>
import { mapActions, mapGetters } from 'vuex';
import PasswordResetModal from '@/components/Account/PasswordReset/PasswordResetModal.vue';

export default {
  name: 'PasswordResetForm',
  components: {
    PasswordResetModal,
  },
  data() {
    return {
      showModal: false,
      userData: {
        userId: '',
        userName: '',
      },
    };
  },
  computed: {
    ...mapGetters(['isIdCheck', 'isIdChecked', 'isIdUsernameCheck']),
  },
  methods: {
    ...mapActions(['idCheck', 'resetPassword']),
    pageLink() {
      // console.log(this.isIdUsernameCheck);
      if (this.isIdUsernameCheck) {
        this.$router.push({ name: 'LoginView' });
      }
      this.showModal = false;
    },
  },
};
</script>

<style scoped></style>
