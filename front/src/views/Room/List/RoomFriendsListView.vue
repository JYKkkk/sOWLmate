<template>
  <v-col cols="9">
    <v-tabs
      ><v-tab @click="selected = 0"> 전체 </v-tab>
      <v-tab @click="selected = 1"> 예비친구 </v-tab>
      <v-tab @click="selected = 2"> 친구 </v-tab>
      <v-tab @click="selected = 3"> 소울메이트 </v-tab>
    </v-tabs>
    <hr />
    <TotalFriendRoomList
      v-if="selected === 0"
      class="my-16"
      :selected="selected"
    />
    <PreFriendRoomList
      v-if="selected === 1"
      class="my-16"
      :selected="selected"
    />
    <MiddleFriendRoomList
      v-if="selected === 2"
      class="my-16"
      :selected="selected"
    />
    <SowlMateRoomList
      v-if="selected === 3"
      class="my-16"
      :selected="selected"
    />
  </v-col>
</template>

<script>
import TotalFriendRoomList from '@/components/Room/TotalFriendRoomList.vue';
import PreFriendRoomList from '@/components/Room/PreFriendRoomList.vue';
import MiddleFriendRoomList from '@/components/Room/MiddleFriendRoomList.vue';
import SowlMateRoomList from '@/components/Room/SowlMateRoomList.vue';
import { mapActions, mapGetters, mapMutations } from 'vuex';

export default {
  name: 'RoomFreindsListView',
  components: {
    TotalFriendRoomList,
    PreFriendRoomList,
    MiddleFriendRoomList,
    SowlMateRoomList,
  },
  data() {
    return {
      selected: 0,
      totalRoomList: {
        preFriendsRoomList: [],
        friendsRoomList: [],
        sowlmateRoomList: [],
      },
    };
  },
  computed: {
    ...mapGetters(['preFriendsList', 'friendsList', 'sowlmateList', 'roomAll']),
  },
  methods: {
    ...mapActions(['totalFriendList']),
    ...mapMutations(['ROOM_PRE', 'ROOM_FRIENDS', 'ROOM_SOWLMATE']),
    totalRoomFriendsList() {
      for (let room of this.roomAll) {
        if (this.preFriendsList.includes(room.ownerId)) {
          this.totalRoomList.preFriendsRoomList.push(room);
        }
      }
      for (let room of this.roomAll) {
        if (this.friendsList.includes(room.ownerId)) {
          this.totalRoomList.friendsRoomList.push(room);
        }
      }
      for (let room of this.roomAll) {
        if (this.sowlmateList.includes(room.ownerId)) {
          this.totalRoomList.sowlmateRoomList.push(room);
        }
      }
      this.ROOM_PRE(this.totalRoomList.preFriendsRoomList);
      this.ROOM_FRIENDS(this.totalRoomList.friendsRoomList);
      this.ROOM_SOWLMATE(this.totalRoomList.sowlmateRoomList);
    },
  },
  mounted() {
    this.totalFriendList();
    this.totalRoomFriendsList();
  },
};
</script>

<style scoped></style>
