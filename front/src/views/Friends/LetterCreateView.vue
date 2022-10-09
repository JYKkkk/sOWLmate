<template>
  <div class="wrap mt-16">
    <div class="postcard">
      <div v-if="nowProgress === 0" class="letter">
        <LetterInput @progress="progressGet" @letterData="letterDataGet" />
      </div>
      <div v-if="nowProgress === 1" class="cardbox-size">
        <LetterBackgroundSelector :letterData="this.letterData" />
      </div>
    </div>
  </div>
</template>

<script>
import LetterInput from '@/components/Letter/LetterInput.vue';
import LetterBackgroundSelector from '@/components/Letter/LetterBackgroundSelector.vue';
export default {
  name: 'LetterCreateView',
  components: {
    LetterInput,
    LetterBackgroundSelector,
  },
  data() {
    return {
      nowProgress: 0,
      letterData: {},
    };
  },
  methods: {
    progressGet(progress) {
      this.nowProgress = progress;
    },
    letterDataGet(letterData) {
      // console.log(letterData);
      this.letterData = letterData;
    },
  },
};
</script>

<style scoped>
.postcard {
  width: 80%;
  /* height: 90%; */
  background-color: #f7f7f7;
  margin: 0 auto;
  border-radius: 2%;
  display: flex;
  justify-content: center;
  /* padding: 3em; */
  /* margin-top: 10rem; */
  box-shadow: 0.8em 0.8em 15px rgba(0, 0, 0, 0.3);
  -ms-transform: rotate(2.5deg); /* IE 9 */
  -webkit-transform: rotate(2.5deg); /* Chrome, Safari, Opera */
  transform: rotate(2.5deg);
  -moz-transition: all 0.5s ease;
  -webkit-transition: all 0.5s ease;
  -o-transition: all 0.5s ease;
  transition: all 0.5s ease;
}

/*animation*/
.postcard:hover,
.postcard:active,
.postcard:focus {
  -ms-transform: rotate(0deg); /* IE 9 */
  -webkit-transform: rotate(0deg); /* Chrome, Safari, Opera */
  transform: rotate(0deg);
  -moz-transition: all 0.5s ease;
  -webkit-transition: all 0.5s ease;
  -o-transition: all 0.5s ease;
  transition: all 0.5s ease;
}

.cardbox-size {
  width: 100%;
}
</style>
