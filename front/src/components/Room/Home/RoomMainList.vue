<template>
  <div class="mt-4">
    <InterestSelector @roomInterest="showList" />
    <!-- 일단은 선호하는 언어 기준으로, 원하면 바꿔라 -->
    <!-- 시간 남으면 언어 선택 -->
    <v-container>
      <v-row justify="center">
        <v-col v-for="room in roomAll" :key="room.id">
          <RoomListCard :room="room" />
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import RoomListCard from '@/components/Room/RoomListCard.vue';
import InterestSelector from '@/components/Room/Home/InterestSelector.vue';
import { mapGetters, mapActions } from 'vuex';

export default {
  name: 'RoomMainList',
  components: { RoomListCard, InterestSelector },
  computed: {
    ...mapActions(['roomBy']),
    ...mapGetters(['roomByInterestLanguage', 'roomAll', 'userInfo']),
  },
  data() {
    return {
      roomList: [],
    };
  },
  methods: {
    ...mapActions(['getAllRoomList']),
    showList(roomInterest) {
      let preferLanguage = this.userInfo.preferLanguage;
      for (let interest of roomInterest) {
        let userData = {
          interest: interest,
          language: preferLanguage,
        };
        this.roomList = [...this.roomList, ...this.getRoomList(userData)];
      }
    },
  },
  mounted() {
    this.getAllRoomList();
  },
};
</script>

<style></style>
