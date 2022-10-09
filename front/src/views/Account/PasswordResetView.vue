<template>
  <v-container>
    <v-row>
      <v-col cols="7" class="auth-card">
        <PasswordResetCard />
      </v-col>
      <v-col cols="5" xs="11">
        <v-container>
          <PasswordResetForm />
          <div class="mt-1 d-flex justify-end">
            <router-link :to="{ name: 'LoginView' }" class="auth-q"
              >비밀번호가 생각나셨나요?</router-link
            >
          </div>
        </v-container>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import PasswordResetForm from '@/components/Account/PasswordReset/PasswordResetForm.vue';
import PasswordResetCard from '@/components/Account/PasswordReset/PasswordResetCard.vue';
export default {
  name: 'PasswordResetView',
  components: {
    PasswordResetCard,
    PasswordResetForm,
  },
};
</script>

<style></style>
