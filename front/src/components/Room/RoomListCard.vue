<template>
  <v-card class="mx-auto" max-width="300">
    <v-img height="200px" :src="require('@/assets/sowlImage/room_img.svg')" />
    <v-card-title>{{ room.title }}</v-card-title>
    <v-card-subtitle class="pb-0">
      {{ room.language }} | {{ room.interest }}</v-card-subtitle
    >
    <v-card-actions>
      <v-btn @click="joinRoom(userData)" color="orange" text> 입장하기 </v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
import { mapGetters, mapActions, mapMutations } from 'vuex';

export default {
  props: {
    room: {
      type: Object,
      required: true,
    },
  },
  data() {
    return {
      userData: {
        userId: '',
        conferenceNo: '',
      },
    };
  },
  computed: {
    ...mapGetters(['userInfo', 'userList']),
  },
  methods: {
    ...mapActions(['joinRoom', 'getUserList']),
    ...mapMutations(['TO_USER_NICKNAME', 'FROM_USER_NICKNAME']),
    conferenceCheck() {
      this.getUserList();
      this.userData.userId = this.userInfo.id;
      this.userData.conferenceNo = this.room.no;
      this.FROM_USER_NICKNAME(this.userInfo.nickname);
      for (const user of this.userList) {
        // console.log(user);
        if (this.room.ownerId === user['id']) {
          this.TO_USER_NICKNAME(user['nickname']);
          break;
        }
      }
    },
  },
  mounted() {
    this.conferenceCheck();
  },
};
</script>

<style></style>
