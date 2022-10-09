<template>
  <div>
    <div class="plane-group-container">
      <!-- <PasswordResetDeco /> -->
      <img :src="require('@/assets/sowlImage/etc/plane_white_group.svg')" />
    </div>
    <div class="password-reset-deco-container">
      <!-- <PasswordResetDeco /> -->
      <img :src="require('@/assets/sowlImage/etc/password_reset_deco.svg')" />
    </div>
  </div>
</template>

<script>
// import PasswordResetDeco from '@/components/Account/PasswordReset/PasswordResetDeco.vue';
export default {
  name: 'PasswordResetCard',
  components: {
    // PasswordResetDeco,
  },
};
</script>

<style scoped>
.password-reset-deco-container {
  position: relative;
  left: -6rem;
  top: 20rem;
}
.plane-group-container {
  position: absolute;
}
</style>
