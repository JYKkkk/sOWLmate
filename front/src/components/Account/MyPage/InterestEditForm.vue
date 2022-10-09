<template>
  <div class="mt-12">
    <h3>관심사 변경</h3>
    <div class="mt-2">
      <p class="signup-explain">나의 관심사를 등록하고 관리해보세요</p>
      <p class="signup-explain">관심사를 토대로 SOWLMATE를 추천드립니다!</p>
    </div>
    <v-chip-group v-model="userInterest" column multiple class="mt-4">
      <v-chip
        class="interest-chip"
        color="primary"
        v-for="interest in InterestList"
        :key="interest"
      >
        {{ interest }}
      </v-chip>
    </v-chip-group>
    <v-row justify="end" class="mt-6">
      <button class="main-btn" @click="userInterestSave(userInterest)">
        저장
      </button>
    </v-row>
  </div>
</template>

<script>
import { mapGetters, mapActions } from 'vuex';

export default {
  name: 'InterestEditForm',
  data() {
    return {
      userInterest: [],
      delete: [],
    };
  },
  components: {},
  computed: {
    ...mapGetters(['InterestList', 'userInfo']),
  },
  methods: {
    ...mapActions(['userInterestSave']),
    interestCheck() {
      for (const userinterest of this.userInfo.interests) {
        if (this.InterestList.includes(userinterest['title'])) {
          const index = this.InterestList.indexOf(userinterest['title']);
          this.userInterest.push(index);
        }
      }
    },
  },
  mounted() {
    this.interestCheck();
  },
};
</script>

<style scoped>
.v-chip {
  width: 10rem;
  height: 3rem;
  justify-content: center;
  margin: 1rem;
}
.main-btn {
  width: 18%;
  height: 2rem;
  margin-right: 2rem;
}
</style>
