<template>
  <div>
    <!-- <v-img :src="require('@/assets/letter/1.png')" /> -->
    <v-carousel class="ma-6">
      <v-carousel-item
        v-for="(item, i) in items"
        :key="i"
        :src="item"
        @click="select(i)"
        class="img-size"
      ></v-carousel-item>
    </v-carousel>
    <div v-if="!selectedImg" class="btn-box text-gradient mb-2">
      <h4>~편지지를 선택해주세요~</h4>
    </div>
    <div v-if="selectedImg" class="btn-box">
      <button class="main-btn" @click="choice()">이 편지지로 선택</button>
    </div>
    <div>
      <button
        v-if="selectedImg"
        class="main-btn"
        @click="sendMail(letterdata)"
        max-width="100%"
      >
        편지 보내기
      </button>
    </div>
  </div>
</template>

<script>
import { mapActions } from 'vuex';
export default {
  props: {
    letterData: Object,
  },
  data() {
    return {
      items: [
        require('@/assets/letter/1.png'),
        require('@/assets/letter/2.png'),
        require('@/assets/letter/3.png'),
        require('@/assets/letter/4.png'),
        require('@/assets/letter/5.png'),
      ],
      selectedImg: '',
      num: 1,
      letterdata: this.letterData,
    };
  },
  methods: {
    select(index) {
      this.selectedImg = this.items[index];
      this.num = index + 1;
    },
    choice() {
      // const letterdata = this.letterData;
      // letterdata.writingPad = `${this.num}`;
    },
    ...mapActions(['sendMail']),
  },
};
</script>
// https://codepen.io/EightArmsHQ/pen/nBYNjG
<style scoped>
v-carousel-item {
  cursor: pointer;
}
.img-size {
  width: 80%;
  height: 80%;
}
.btn-box {
  display: flex;
  width: 100%;
  justify-content: center;
}
</style>
