<template>
  <div>
    <div v-if="roomInterest.length === 0">
      <p>관심사를 먼저 선택해야 이용 가능합니다.</p>
      <router-link :to="{ name: 'MypageEditInterestView' }"
        >관심사 선택하러 가기</router-link
      >
    </div>
    <div v-else>
      <h5>나의 관심사</h5>
      <v-chip v-for="interest in roomInterest" :key="interest" color="primary">
        {{ interest }}
      </v-chip>
      <button class="sub-btn" v-if="!isEditInterest" @click="editInterest()">
        <span>모든 관심사 선택 검색</span>
      </button>
      <!-- 선택 검색 눌렀을 때 -->
      <v-chip v-if="isEditInterest" @click="allCheck()">All</v-chip>
      <v-chip-group
        v-if="isEditInterest"
        v-model="roomInterest"
        color="primary"
        @click="roomInterestCheck()"
        column
        multiple
      >
        <v-chip v-for="interest in InterestList" :key="interest">
          {{ interest }}
        </v-chip>
      </v-chip-group>
      <v-btn v-if="isEditInterest" @click="editInterest()">닫기</v-btn>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';

export default {
  name: 'InterestSelector',
  data() {
    return {
      isEditInterest: false,
      roomInterest: [],
      isAllCheck: false,
    };
  },
  emits: ['roomInterest'],
  computed: {
    ...mapGetters(['InterestList', 'userInfo']),
  },
  methods: {
    userInfoCheck() {
      for (const userinterest of this.userInfo.interests) {
        if (this.InterestList.includes(userinterest['title'])) {
          this.roomInterest.push(userinterest['title']);
        }
      }
    },
    editInterest() {
      this.isEditInterest = !this.isEditInterest;
    },
    allCheck() {
      if (this.isAllCheck) {
        this.roomInterest = [];
        this.userInfoCheck();
        this.isAllCheck = !this.isAllCheck;
      } else {
        this.roomInterest = this.InterestList;
        this.isAllCheck = !this.isAllCheck;
      }
    },
  },
  mounted() {
    this.userInfoCheck();
  },
  watch() {
    this.$emit('roomInterest', this.roomInterest);
  },
};
</script>

<style scoped>
.sub-btn {
  margin-left: 2rem;
  width: 8rem;
}
</style>
