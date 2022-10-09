<template>
  <div class="mt-10">
    <h3>비밀번호 변경</h3>
    <v-row class="mt-8">
      <v-label for="currentPassword" class="mr-10 width-6 font-08"
        >현재 비밀번호</v-label
      >
      <v-text-field
        id="currentPassword"
        color="primary"
        variant="underlined"
        v-model="currentPassword"
      ></v-text-field>
    </v-row>
    <v-row>
      <v-label for="password" class="mr-10 width-6 font-08"
        >새로운 비밀번호</v-label
      >
      <v-text-field
        id="password"
        color="primary"
        variant="underlined"
        v-model="password"
        @keyup="
          passwordDoubleCheck({ password: password, password2: password2 })
        "
      ></v-text-field>
    </v-row>
    <v-row>
      <v-label for="password2" class="mr-10 width-6 font-08"
        >비밀번호 확인</v-label
      >
      <v-text-field
        id="password2"
        color="primary"
        variant="underlined"
        v-model="password2"
        @keyup="
          passwordDoubleCheck({ password: password, password2: password2 })
        "
      ></v-text-field>
    </v-row>
    <v-row justify="end">
      <button
        v-if="isPasswordDoubleCheck"
        class="main-btn"
        @click="passwordChange()"
      >
        비밀번호 변경
      </button>
    </v-row>
  </div>
</template>

<script>
import { mapGetters, mapActions } from 'vuex';
import axios from 'axios';
import sowl from '@/api/sowl';

export default {
  name: 'PasswordEditForm',
  data() {
    return {
      currentPassword: '',
      password: '',
      password2: '',
    };
  },
  computed: {
    ...mapGetters(['isPasswordDoubleCheck', 'currentUser']),
  },
  methods: {
    ...mapActions(['passwordDoubleCheck']),
    passwordChange() {
      axios({
        url: sowl.users.changePassword(),
        method: 'put',
        data: {
          userId: this.currentUser,
          currentPW: this.currentPassword,
          newPW: this.password,
        },
      })
        .then((response) => {
          if (response.data === 'done') {
            alert('비밀번호가 성공적으로 변경되었습니다');
          } else {
            alert('현재 비밀번호와 일치하지 않습니다.');
          }
          this.currentPassword = '';
          this.password = '';
          this.password2 = '';
          this.passwordDoubleCheck({ password: '1', password2: '' });
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>

<style></style>
