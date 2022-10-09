<template>
  <v-container>
    <v-row>
      <v-col cols="7" class="auth-card">
        <SignUpCard />
      </v-col>
      <v-col cols="5" xs="11">
        <v-container>
          <SocialSignupForm />
        </v-container>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import SignUpCard from '@/components/Account/Signup/SignUpCard.vue';
import SocialSignupForm from '@/components/Account/Signup/SocialSignupForm.vue';

export default {
  name: 'SignUpView',
  components: {
    SignUpCard,
    SocialSignupForm,
  },
};
</script>

<style></style>
