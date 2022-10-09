<template>
  <div>
    <div class="meter">
      <span id="percent" :style="`width:${intimacyEval}%`"
        ><span class="progress"></span
      ></span>
    </div>
    <v-row class="d-flex justify-space-around mb-2"
      ><v-label class="intimacy-label">STRANGER</v-label>
      <v-label class="intimacy-label">FRIENDS</v-label>
      <v-label class="intimacy-label">SOWLMATE</v-label></v-row
    >
    <!-- <img :src="require('@/assets/logo.png')" class="mytry" /> -->
  </div>
</template>

<script>
export default {
  props: {
    intimacyEval: Number,
  },
  methods: {},
  mounted() {},
};
</script>

<style lang="scss" scoped>
:root {
  --leftposition: 0px;
}

.meter {
  width: 100%;
  height: 7px;
  position: relative;
  background: white;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25), 0px 2px 20px $color-blue;
  overflow: hidden;
}

.meter span {
  display: block;
  height: 100%;
}

.progress {
  background-image: $color-main;
  animation: progressBar 2s ease-in-out;
  animation-fill-mode: both;
}

@keyframes progressBar {
  0% {
    width: 0;
  }
  100% {
    width: 100%;
  }
}
.mytry {
  position: relative;
  top: -2rem;
  width: 1rem;
  height: 1rem;
  animation: mytry 2s ease-in-out;
  animation-fill-mode: both;
}
@-webkit-keyframes mytry {
  0% {
    left: 0%;
  }
  100% {
    left: 40px;
  }
}
.intimacy-label {
  position: relative;
  font-size: 0.4rem;
  color: #4285f4;
  top: 1rem;
}
</style>
