<template>
  <div>
    <h1 class="text-gradient greeting">Hello, friends!</h1>
    <SignUpDeco class="signup_deco_container" />
    <PlaneAnimation class="plane-position" />
    <div class="plane-group-container">
      <!-- <PasswordResetDeco /> -->
      <img :src="require('@/assets/sowlImage/etc/plane_white_group.svg')" />
    </div>
    <div class="img-container">
      <v-img
        :src="require('@/assets/sowlImage/signup_sowl.svg')"
        class="login-img"
      />
    </div>
  </div>
</template>

<script>
import SignUpDeco from '@/components/Account/Signup/SignUpDeco.vue';
import PlaneAnimation from '@/components/Account/Login/PlaneAnimation.vue';
export default {
  components: {
    SignUpDeco,
    PlaneAnimation,
  },
};
</script>

<style scoped>
.img-container {
  position: fixed;
  bottom: -40%;
  left: 8rem;
  width: 50rem;
  height: 100%;
  overflow: hidden;
}
.signup_deco_container {
  position: fixed;
}

.plane-position {
  position: fixed;
  top: 20rem;
}
.plane-group-container {
  position: fixed;
  left: -4rem;
}
</style>
