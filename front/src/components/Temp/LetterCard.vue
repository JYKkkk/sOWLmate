<template>
  <div class="jb-a mt-12" @click="goDetail(this.letterNo)">
    <img
      :src="require('@/assets/sowlImage/letter_envelope_close.svg')"
      class="jb-b"
    />
    <img
      :src="require('@/assets/sowlImage/letter_envelope_open.svg')"
      class="jb-c"
    />
    <p class="jb-d">{{ fromUserNickname }}이</p>
  </div>
</template>

<script>
import { mapActions } from 'vuex';
export default {
  props: {
    fromUserNickname: String,
    title: String,
    letterNo: Number,
  },
  methods: {
    ...mapActions(['goDetail']),
  },
};
</script>

<style scoped>
body {
  box-sizing: border-box;
  font-family: Consolas, monospace;
}
h1 {
  text-align: center;
}
img {
  max-width: 100%;
}
.jb-a {
  width: 8rem;
  margin: 0px auto;
  position: relative;
}
.jb-b {
  width: 6.8rem;
}
.jb-c {
  position: absolute;
  top: -3rem;
  left: -0.6rem;
  display: none;
}
.jb-d {
  position: absolute;
  top: -0.8rem;
  left: 1rem;
  display: none;
  width: 3rem;

  font-size: 0.2rem;
  transform: rotate(-15deg);
}

.jb-a:hover .jb-c {
  display: block;
}
.jb-a:hover .jb-d {
  display: block;
}
</style>
