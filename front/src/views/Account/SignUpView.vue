<template>
  <v-container>
    <v-row>
      <v-col cols="7" class="auth-card">
        <SignUpCard />
      </v-col>
      <v-col cols="5" xs="11">
        <v-container>
          <SignUpForm />
          <div class="mt-1 d-flex justify-end">
            <router-link :to="{ name: 'LoginView' }" class="auth-q"
              >이미 회원이신가요?</router-link
            >
          </div>
        </v-container>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import SignUpCard from '@/components/Account/Signup/SignUpCard.vue';
import SignUpForm from '@/components/Account/Signup/SignUpForm.vue';

export default {
  name: 'SignUpView',
  components: {
    SignUpCard,
    SignUpForm,
  },
};
</script>

<style></style>
