<template>
  <v-container>
    <v-row>
      <v-col cols="7" class="auth-card">
        <LoginCard />
      </v-col>
      <v-col cols="5" xs="11">
        <v-container>
          <LoginForm />
        </v-container>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import LoginForm from '@/components/Account/Login/LoginForm.vue';
import LoginCard from '@/components/Account/Login/LoginCard.vue';

// import firebase from 'firebase/app';;

export default {
  name: 'LoginView',
  components: {
    LoginForm,
    LoginCard,
  },
};
</script>

<style scoped></style>
