<template>
  <v-container>
    <v-row>
      <v-col class="text-right"
        ><v-btn v-if="isKor" color="white" @click="changeLang"
          >한/영(Ko/En)</v-btn
        >
        <v-btn v-else color="white" @click="changeLang"
          >Ko/En(한/영)</v-btn
        ></v-col
      >
    </v-row>
    <v-row class="my-12 text-center" align="center">
      <v-col
        v-if="isKor"
        cols="5"
        data-aos="fade-right"
        data-aos-offset="150"
        data-aos-delay="50"
        data-aos-duration="1100"
        data-aos-easing="ease-in-out"
        data-aos-mirror="true"
      >
        <h3>나의 글로벌</h3>
        <h3><a class="text-gradient">SOWLMATE</a>를 찾는 시간</h3>
        <v-btn
          class="move1 mt-5 rounded-xl"
          elevation="2"
          text
          x-large
          @click="pushToSignUp"
          >시작하기</v-btn
        >
      </v-col>
      <v-col
        v-else
        cols="5"
        data-aos="fade-right"
        data-aos-offset="150"
        data-aos-delay="50"
        data-aos-duration="1100"
        data-aos-easing="ease-in-out"
        data-aos-mirror="true"
      >
        <h3>Time to find</h3>
        <h3>your global<a class="text-gradient">SOWLMATE</a></h3>
        <v-btn
          class="move1 mt-5 rounded-xl"
          elevation="2"
          text
          x-large
          @click="pushToSignUp"
          >Sign Up</v-btn
        >
      </v-col>
      <v-col cols="7">
        <img
          :src="require('@/assets/sowlImage/mainBigSmall.png')"
          class="my-3"
          data-aos="flip-left"
          data-aos-offset="200"
          data-aos-delay="50"
          data-aos-duration="1100"
          data-aos-easing="ease-in-out"
          data-aos-mirror="true"
        />
      </v-col>
    </v-row>
    <v-row class="my-9 text-center">
      <v-col>
        <img :src="require('@/assets/expandMore1.png')" />
        <h3>Scroll</h3>
      </v-col>
    </v-row>
    <v-row
      class="description my-16 py-15 text-center rounded-lg"
      align="center"
    >
      <v-col
        v-if="isKor"
        cols="12"
        data-aos="fade-down"
        data-aos-offset="120"
        data-aos-delay="50"
        data-aos-duration="800"
        data-aos-easing="ease-in-out"
        data-aos-mirror="true"
      >
        <p>처음이라도 괜찮아요!</p>
        <p>천천히 오래봐요 우리</p>
        <p>부담 없이 즐기는 화상 펜팔, 지금 시작해볼까요?</p>
      </v-col>
      <v-col
        v-else
        cols="12"
        data-aos="fade-down"
        data-aos-offset="120"
        data-aos-delay="50"
        data-aos-duration="800"
        data-aos-easing="ease-in-out"
        data-aos-mirror="true"
      >
        <p>First time trying our app?</p>
        <p>We're here to help you make new friends in the long run</p>
        <p>Let's make some new friends!</p>
      </v-col>
    </v-row>
    <!--관심사 지정 및 언어 선택 소개-->
    <v-row class="mt-16 mb-9 text-center" align="center">
      <v-col
        v-if="isKor"
        cols="5"
        data-aos="fade-right"
        data-aos-offset="150"
        data-aos-delay="50"
        data-aos-duration="1000"
        data-aos-easing="ease-in-out"
        data-aos-mirror="true"
      >
        <h3>나의 관심사를 지정하고,</h3>
        <h3>원하는 언어를 선택해보세요!</h3>
        <p>나와의 sowlmate가 될 다양한 사람들을 한 눈에 보고,</p>
        <p>진정한 관계를 이어나갈 친구를 선택할 수 있답니다.</p>
        <p>앗, 결정이 힘들다구요?</p>
        <p>랜덤으로 나의 취향에 맞는 친구들을 만나볼 수도 있어요!</p>
      </v-col>
      <v-col
        v-else
        cols="5"
        data-aos="fade-right"
        data-aos-offset="150"
        data-aos-delay="50"
        data-aos-duration="1000"
        data-aos-easing="ease-in-out"
        data-aos-mirror="true"
      >
        <h3>Please select</h3>
        <h3>your interestsand preferred language</h3>
        <p>You can choose your soulmate</p>
        <p>
          by browsing thousands of users and finding the perfect one for you
        </p>
        <p>Oh, is it too hard to choose?</p>
        <p>
          Leave it to us, we can match you with a friend through our perfect
          random-match algorithms!
        </p>
      </v-col>
      <v-col cols="7">
        <img
          :src="require('@/assets/main/main_1.png')"
          class="my-3"
          data-aos="fade-left"
          data-aos-offset="200"
          data-aos-delay="50"
          data-aos-duration="1000"
          data-aos-easing="ease-in-out"
          data-aos-mirror="true"
        />
      </v-col>
    </v-row>
    <!--마스킹 소개-->
    <v-row class="my-9 text-center" align="center">
      <v-col cols="7">
        <img
          :src="require('@/assets/main/main_2.png')"
          class="my-3"
          data-aos="fade-right"
          data-aos-offset="200"
          data-aos-delay="50"
          data-aos-duration="1000"
          data-aos-easing="ease-in-out"
          data-aos-mirror="true"
        />
      </v-col>
      <v-col
        v-if="isKor"
        cols="5"
        data-aos="fade-left"
        data-aos-offset="150"
        data-aos-delay="50"
        data-aos-duration="1000"
        data-aos-easing="ease-in-out"
        data-aos-mirror="true"
      >
        <h3>처음부터 얼굴부터 마주하는 게</h3>
        <h3>부끄러운 당신을 위해 준비했어요!</h3>
        <p>일정 기간의 만남은 얼굴 마스킹을 통해 진행된답니다!</p>
        <p>어느 정도 마음이 생겼다면, 조심스럽게 오픈해봐도 좋아요</p>
        <p>단, 서로의 마음이 일치해야 한답니다</p>
      </v-col>
      <v-col
        v-else
        cols="5"
        data-aos="fade-left"
        data-aos-offset="150"
        data-aos-delay="50"
        data-aos-duration="1000"
        data-aos-easing="ease-in-out"
        data-aos-mirror="true"
      >
        <h3>For those who are shy ...</h3>
        <p>We provide a ‘mask function’ for the first several meetings !</p>
        <p>
          You can take off your mask whenever you’re ready to build new memories
          with your friend.
        </p>
      </v-col>
    </v-row>
    <!--번역 소개-->
    <v-row class="my-9 text-center" align="center">
      <v-col
        v-if="isKor"
        cols="5"
        data-aos="fade-right"
        data-aos-offset="150"
        data-aos-delay="50"
        data-aos-duration="1000"
        data-aos-easing="ease-in-out"
        data-aos-mirror="true"
      >
        <h3>말이 안 통한다는</h3>
        <h3>걱정은 그만!</h3>
        <p>음성 혹은 자막, 원하는 방식으로 자동 변역이 제공됩니다.</p>
        <p>필요하다면, 채팅도 번역이 가능해요!</p>
      </v-col>
      <v-col
        v-else
        cols="5"
        data-aos="fade-right"
        data-aos-offset="150"
        data-aos-delay="50"
        data-aos-duration="1000"
        data-aos-easing="ease-in-out"
        data-aos-mirror="true"
      >
        <h3>Concerned about language barrier? No worries!</h3>
        <p>
          Automatic translation for any voice mails or letters is provided to
          both sides.
        </p>
      </v-col>
      <v-col cols="7">
        <img
          :src="require('@/assets/main/main_3.png')"
          class="my-3"
          data-aos="fade-left"
          data-aos-offset="200"
          data-aos-delay="50"
          data-aos-duration="1000"
          data-aos-easing="ease-in-out"
          data-aos-mirror="true"
        />
      </v-col>
    </v-row>
    <!--편지 소개-->
    <v-row class="my-9 text-center" align="center">
      <v-col cols="7">
        <img
          :src="require('@/assets/main/main_4.png')"
          class="my-3"
          data-aos="fade-right"
          data-aos-offset="200"
          data-aos-delay="50"
          data-aos-duration="1000"
          data-aos-easing="ease-in-out"
          data-aos-mirror="true"
        />
      </v-col>
      <v-col
        v-if="isKor"
        cols="5"
        data-aos="fade-left"
        data-aos-offset="150"
        data-aos-delay="50"
        data-aos-duration="1000"
        data-aos-easing="ease-in-out"
        data-aos-mirror="true"
      >
        <h3>친구에게 못다한 말은</h3>
        <h3>나만의 편지로 전송해보세요!</h3>
        <p>내가 직접 만든 편지로 마음을 전해보세요!</p>
        <p>sowlmate의 마스코트 sowl이 전해준답니다!</p>
      </v-col>
      <v-col
        v-else
        cols="5"
        data-aos="fade-left"
        data-aos-offset="150"
        data-aos-delay="50"
        data-aos-duration="1000"
        data-aos-easing="ease-in-out"
        data-aos-mirror="true"
      >
        <h3>Keep in touch with your friend through personal letter!</h3>
        <p>Express your feelings by sending a personal letter!</p>
        <p>Our mascot ‘Sowl’ will safely deliver your letter!</p>
      </v-col>
    </v-row>
    <!--인생네컷 소개-->
    <v-row class="my-9 text-center" align="center">
      <v-col
        v-if="isKor"
        cols="5"
        data-aos="fade-right"
        data-aos-offset="150"
        data-aos-delay="50"
        data-aos-duration="1000"
        data-aos-easing="ease-in-out"
        data-aos-mirror="true"
      >
        <h3>기억에 남을</h3>
        <h3>추억을 더욱 더 쌓고 싶다면?</h3>
        <p>사진으로 기록해보세요</p>
        <p>친구와 함께 하는 인생네컷도 준비되어 있답니다!</p>
      </v-col>
      <v-col
        v-else
        cols="5"
        data-aos="fade-right"
        data-aos-offset="150"
        data-aos-delay="50"
        data-aos-duration="1000"
        data-aos-easing="ease-in-out"
        data-aos-mirror="true"
      >
        <h3>Want to keep making memories together?</h3>
        <p>Cherish your memory by taking a picture with your friend.</p>
        <p>Four-frame photobooth is ready for you!</p>
      </v-col>
      <v-col cols="7">
        <img
          :src="require('@/assets/main/main_4.png')"
          class="my-3"
          data-aos="fade-left"
          data-aos-offset="200"
          data-aos-delay="50"
          data-aos-duration="1000"
          data-aos-easing="ease-in-out"
          data-aos-mirror="true"
        />
      </v-col>
    </v-row>
    <v-row class="intimacy mt-16 pb-16 text-center rounded-lg" align="center">
      <v-col
        v-if="isKor"
        cols="12"
        data-aos="fade-down"
        data-aos-offset="150"
        data-aos-delay="50"
        data-aos-duration="800"
        data-aos-easing="ease-in-out"
        data-aos-mirror="true"
      >
        <h2>서로의 속도로 함께 쌓아가는</h2>
        <h2>너와 나의 FRIENDSHIP</h2>
      </v-col>
      <v-col
        v-else
        cols="12"
        data-aos="fade-down"
        data-aos-offset="150"
        data-aos-delay="50"
        data-aos-duration="800"
        data-aos-easing="ease-in-out"
        data-aos-mirror="true"
      >
        <h2>We can take it slow</h2>
        <h2>And build a friendship that lasts</h2>
      </v-col>
    </v-row>
    <v-row class="mt-n16 text-center" align="center">
      <v-col
        cols="12"
        data-aos="fade-down"
        data-aos-offset="150"
        data-aos-delay="50"
        data-aos-duration="800"
        data-aos-easing="ease-in-out"
        data-aos-mirror="true"
      >
        <img :src="require('@/assets/main/main_6.png')" />
      </v-col>
    </v-row>
    <v-row class="mt-n9 mb-16 text-center" align="center">
      <v-col
        v-if="isKor"
        cols="12"
        data-aos="fade-down"
        data-aos-offset="100"
        data-aos-delay="50"
        data-aos-duration="800"
        data-aos-easing="ease-in-out"
        data-aos-mirror="true"
      >
        <p class="mt-4">서로의 마음이 일치해야 친구가 될 수 있답니다!</p>
      </v-col>
      <v-col
        v-else
        cols="12"
        data-aos="fade-down"
        data-aos-offset="100"
        data-aos-delay="50"
        data-aos-duration="800"
        data-aos-easing="ease-in-out"
        data-aos-mirror="true"
      >
        <p class="mt-4">Through thick and thin</p>
        <p>We could be like two peas in pod!</p>
      </v-col>
    </v-row>
    <v-row class="move2 my-16 py-9 rounded-lg text-center">
      <v-col
        v-if="isKor"
        cols="12"
        data-aos="fade-right"
        data-aos-offset="150"
        data-aos-delay="50"
        data-aos-duration="1100"
        data-aos-easing="ease-in-out"
        data-aos-mirror="true"
        data-aos-once="true"
      >
        <h3>SOWLMATE를 통해</h3>
        <h3>나의 글로벌 SOULMATE를 만들어보세요!</h3>
        <v-btn
          class="mt-7 rounded-xl"
          color="white"
          elevation="2"
          text
          x-large
          @click="pushToSignUp"
          >시작하기</v-btn
        >
      </v-col>
      <v-col
        v-else
        cols="12"
        data-aos="fade-right"
        data-aos-offset="150"
        data-aos-delay="50"
        data-aos-duration="1100"
        data-aos-easing="ease-in-out"
        data-aos-mirror="true"
        data-aos-once="true"
      >
        <h3>Make new SOULMATES through SOWLMATE!</h3>
        <v-btn
          class="mt-7 rounded-xl"
          color="white"
          elevation="2"
          text
          x-large
          @click="pushToSignUp"
          >PRESS START</v-btn
        >
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: 'HelloWorldBeforeLogin',
  data() {
    return {
      isKor: true,
    };
  },
  methods: {
    changeLang() {
      this.isKor = !this.isKor;
    },
    pushToSignUp() {
      this.$router.push({ name: 'SignUpView' });
    },
  },
};
</script>
<style lang="scss" scoped>
.move1 {
  background-image: $color-main;
  color: white;
}
.description {
  background-image: $color-main;
  color: white;
}
.intimacy {
  background-image: $color-main;
  color: white;
}
.move2 {
  background-image: $color-main;
  color: white;
}
</style>
