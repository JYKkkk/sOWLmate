<template>
  <div>
    <button class="main-btn" @click="randomRoom()">RANDOM</button>
  </div>
</template>

<script>
import { mapGetters, mapActions, mapMutations } from 'vuex';

export default {
  computed: {
    ...mapGetters(['roomAll', 'userInfo', 'userList']),
  },
  data() {
    return {
      userData: {
        userId: '',
        conferenceNo: '',
      },
      room: {},
      toUserNickname: '',
    };
  },
  methods: {
    ...mapActions(['joinRoom', 'getAllRoomList']),
    ...mapMutations(['TO_USER_NICKNAME', 'FROM_USER_NICKNAME']),
    randomRoom() {
      this.FROM_USER_NICKNAME(this.userInfo.nickname);
      this.userData.userId = this.userInfo.id;

      var conference = Math.floor(Math.random() * this.roomAll.length);
      this.userData.conferenceNo = this.roomAll[conference].conferenceNo;

      this.room = this.roomAll[conference];

      for (let user of this.userList) {
        if (this.room.ownerId === user['id']) {
          this.TO_USER_NICKNAME(user['nickname']);
          break;
        }
      }

      return this.joinRoom(this.userData);
    },
  },
  mounted() {
    this.getAllRoomList();
  },
};
</script>

<style scoped>
.main-btn {
  width: 10rem;
}
</style>
