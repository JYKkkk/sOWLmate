<template>
  <div>
    <v-container>
      <v-row justify="center">
        <v-col v-for="room in preFriendsRoomList" :key="room.id">
          <RoomListCard :room="room.id" />
        </v-col>
        <v-col v-for="room in friendsRoomList" :key="room.id">
          <RoomListCard :room="room.id" />
        </v-col>
        <v-col v-for="room in sowlmateRoomList" :key="room.id">
          <RoomListCard :room="room.id" />
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import RoomListCard from '@/components/Room/RoomListCard.vue';
import { mapGetters } from 'vuex';

export default {
  name: 'TotalFriendRoomList',
  components: { RoomListCard },
  computed: {
    ...mapGetters([
      'preFriendsRoomList',
      'friendsRoomList',
      'sowlmateRoomList',
    ]),
  },
};
</script>

<style></style>
