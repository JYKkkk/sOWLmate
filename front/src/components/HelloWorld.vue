<template>
  <div>
    <div class="main-img-container">
      <v-img :src="require('@/assets/sowlImage/etc/main_after_login.svg')" />
      <v-container>
        <v-row>
          <v-card elevation="2" class="main-sub-card">
            <p class="p-small text-gray400 mt-4 ml-2">안녕하세요!</p>
            <p class="ml-2 pw-sb">{{ userInfo.nickname }}<span>님</span></p>
            <router-link :to="{ name: 'MyPageBasicInfoView' }">
              <div class="sub-chip"><span>계정관리</span></div>
            </router-link>
            <v-row class="mt-2 ml-2">
              <v-icon icon="mdi-home-search-outline" class="p-small"></v-icon>
              <p class="p-small">
                {{ userInfo.region }}
              </p>
            </v-row>
            <v-row class="mt-2 ml-2">
              <v-icon icon="mdi-alphabet-latin" class="p-small"></v-icon>
              <p class="p-small">{{ userInfo.language }}</p>
            </v-row>
          </v-card>

          <v-container class="main-part">
            <div>
              <v-row class="mt-8 mb-1 ml-1">
                <h3>나의 관심사</h3>
                <router-link :to="{ name: 'MypageEditInterestView' }">
                  <div class="sub-chip"><span>수정</span></div>
                </router-link>
              </v-row>
              <v-chip-group v-if="userInfo.interests" column class="mt-4"
                ><div
                  v-for="interest in userInfo.interests"
                  :key="interest.title"
                  class="main-chip"
                >
                  <span>{{ interest.title }}</span>
                </div>
                <router-link
                  :to="{ name: 'MypageEditInterestView' }"
                  v-if="userInfo.interests.length <= 0"
                >
                  <div class="main-chip">
                    <span>관심사 등록하러 가기</span>
                  </div></router-link
                ></v-chip-group
              >
            </div>
            <div class="mt-8 mb-1">
              <h3>Live On! 추천 친구</h3>
              <p class="auth-q">현재 sowlmate를 기다리고 있는,</p>
              <p class="auth-q">
                나와의 관심사와 선호 언어가 일치하는 친구의 방을 추천드립니다
              </p>
              <div class="mt-4 ml-12">
                <router-link :to="{ name: 'RoomMainListView' }">
                  <button class="sub-btn main-btn-size">
                    <span>방 리스트 가기</span>
                  </button>
                </router-link>
              </div>
            </div>
            <!-- <div class="mt-8 mb-1">
              <h3>Live On! 나의 친구</h3>
              <p class="auth-q">나의 친구가 sowlmate를 기다려요!</p>
              <p class="auth-q">내 친구를 한번 더 보고싶다면?</p>
            </div> -->
            <div class="mt-8 mb-1">
              <h3>직접 맛보는 쫀득쫀득한 친구 매칭</h3>
              <p class="auth-q">
                랜덤으로 친구를 만나보거나, 방을 직접 만들어보세요
              </p>
              <p class="auth-q">
                처음은 누구나 어렵지만, SOWLMATE가 도와줄게요!
              </p>
              <v-row class="mt-4">
                <!-- <div class="main-btn-size ml-16">
                  <button class="sub-btn main-btn-size">
                    <span>랜덤매칭</span>
                  </button>
                </div> -->
                <router-link :to="{ name: 'RoomCreateView' }">
                  <div class="main-btn-size ml-16">
                    <button class="main-btn main-btn-size">방 만들기</button>
                  </div>
                </router-link>
              </v-row>
            </div>
            <div class="mt-8">
              <h3>띵똥! 편지 왔어요</h3>
              <p class="auth-q">
                나에게 도착한 편지, 누구에게 왔을까 궁금하지 않으세요?
              </p>
              <!-- 편지 케러셀 -->
              <v-sheet class="mx-auto card-group-pisiton" max-width="800">
                <v-slide-group show-arrows>
                  <v-slide-group-item v-for="letter in letters10" :key="letter">
                    <LetterCard
                      :fromUserNickname="letter.fromUserNickname"
                      :title="letter.title"
                      :letterNo="letter.no"
                    />
                  </v-slide-group-item>
                </v-slide-group>
              </v-sheet>
            </div>
          </v-container>
        </v-row>
      </v-container>
    </div>
  </div>
</template>

<script>
import { mapGetters, mapActions } from 'vuex';
import LetterCard from '@/components/Temp/LetterCard.vue';
export default {
  name: 'HelloWorld',
  components: {
    LetterCard,
  },
  computed: {
    ...mapGetters(['userInfo', 'preFriendsList', 'letterList']),
    letters10() {
      const letter10 = this.letterList.slice(0, 10);
      return letter10;
    },
  },
  methods: {
    ...mapActions(['totalFriendList', 'totalLetterList']),
  },
  mounted() {
    // console.log('마운티드~');
    this.totalFriendList();
    this.totalLetterList();
  },
};
</script>
<style scoped>
.auth-q {
  font-size: 0.8rem;
}

.main-img-container {
  position: relative;
  top: -2rem;
}
.main-sub-card {
  position: fixed;
  width: 7rem;
  height: 10rem;
}
.main-part {
  position: relative;
  left: 10rem;
}
.main-chip {
  height: 2rem;
  width: 8rem;
  border-radius: 4rem;
}
.card-group-pisiton {
  position: relative;
  left: -4rem;
}
.main-btn-size {
  width: 12rem;
  height: 3rem;
}
</style>
