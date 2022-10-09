<template>
  <v-tabs v-model="tab" direction="vertical" class="mt-8">
    <v-tab>
      <router-link :to="{ name: 'RoomMainListView' }"
        >전체 유저 방 조회</router-link
      >
    </v-tab>
    <v-tab>
      <router-link :to="{ name: 'RoomFriendsListView' }"
        >친구 방 조회</router-link
      >
    </v-tab>
  </v-tabs>
</template>

<script>
export default {
  name: 'RoomListNavigation',
  components: {},
  computed: {},
};
</script>

<style scoped>
.room-nav {
  margin-left: 7rem;
}
</style>
