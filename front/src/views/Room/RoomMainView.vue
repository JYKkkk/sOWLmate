<template>
  <v-container class="mt-3">
    <v-row class="mt-16" justify="center">
      <div class="auth-card">
        <RoomListNavigation />
      </div>
      <div class="main-size">
        <v-main>
          <router-view />
        </v-main>
        <v-row class="mt-12 ml-4">
          <router-link :to="{ name: 'RoomCreateView' }"
            ><button class="main-btn">방 생성</button></router-link
          >
          <RoomRandomButton />
        </v-row>
      </div>
    </v-row>
  </v-container>
</template>

<script>
import RoomListNavigation from '@/components/Room/RoomListNavigation.vue';
import RoomRandomButton from '@/components/Room/Home/RoomRandomButton.vue';
export default {
  name: 'RoomMainView',
  components: { RoomListNavigation, RoomRandomButton },
  methods: {},
};
</script>

<style scoped>
.main-size {
  margin-left: 4rem;
  width: 80%;
}

.main-btn {
  width: 10rem;
}
</style>
