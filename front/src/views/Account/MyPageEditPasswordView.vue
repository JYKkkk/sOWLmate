<template>
  <v-container>
    <PasswordEditForm />
  </v-container>
</template>

<script>
import PasswordEditForm from '@/components/Account/MyPage/PasswordEditForm.vue';

export default {
  name: 'MyPageEditPasswordView',
  components: {
    PasswordEditForm,
  },
};
</script>

<style></style>
