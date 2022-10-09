<template>
  <div>
    <h1 class="text-gradient greeting">Welcome Back!</h1>
    <PlaneAnimation class="plane-position" />
    <!-- <PlaneAnimation2 class="plane-position2" /> -->
    <LoginDeco class="login-deco-position" />
    <!-- <v-img
      :src="require('@/assets/sowlImage/etc/plane_white.svg')"
      class="plane-white1"
    /> -->
    <div class="plane-group-container">
      <!-- <PasswordResetDeco /> -->
      <img :src="require('@/assets/sowlImage/etc/plane_white_group.svg')" />
    </div>
    <div class="img-container">
      <v-img
        :src="require('@/assets/sowlImage/login_sowl.svg')"
        class="login-img"
      />
    </div>
  </div>
</template>

<script>
import PlaneAnimation from '@/components/Account/Login/PlaneAnimation.vue';
// import PlaneAnimation2 from '@/components/Account/Login/PlaneAnimation2.vue';
import LoginDeco from '@/components/Account/Login/LoginDeco.vue';
export default {
  components: {
    PlaneAnimation,
    // PlaneAnimation2,

    LoginDeco,
  },
};
</script>

<style scoped>
.login-deco-position {
  position: absolute;
  left: -40rem;
  top: -1rem;
  overflow: hidden;
}
.img-container {
  position: relative;
  top: 4rem;
  left: -2rem;
  width: 50rem;
  height: 100%;
  overflow: hidden;
}

.login-img {
  max-width: 100%;
  height: auto;
  display: block;
}

.plane-position {
  position: relative;
  left: -20rem;
  top: 10rem;
}

.plane-position2 {
  position: relative;
  left: -10rem;
  top: 5rem;
}
.plane-white1 {
  position: relative;
  width: 3rem;
  top: 16rem;
}
.plane-group-container {
  position: absolute;
  left: -4rem;
}
</style>
