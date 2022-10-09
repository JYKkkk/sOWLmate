<template>
  <div>
    <v-container>
      <v-row justify="center">
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
  name: 'SowlMateRoomList',
  components: { RoomListCard },
  computed: {
    ...mapGetters(['sowlmateRoomList']),
  },
};
</script>

<style></style>
