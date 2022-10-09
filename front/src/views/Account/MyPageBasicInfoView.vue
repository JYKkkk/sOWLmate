<template>
  <v-container>
    <h3>기본 정보</h3>
    <v-row justify="center">
      <MyPageAvatar
        :profilePictureUrl="this.userInfo.profilePictureUrl"
        class="profile-position"
      />
    </v-row>
    <div class="mt-8">
      <MyPageBasicInfoForm
        :currentUser="this.currentUser"
        :userNickname="this.userInfo.nickname"
        :userRegion="this.userInfo.region"
      />
    </div>
    <v-row justify="end">
      <v-btn size="x-small" @click="withdrawal">탈퇴</v-btn>
    </v-row>
  </v-container>
</template>

<script>
import MyPageAvatar from '@/components/Account/MyPage/Basic/MyPageAvatar.vue';
import MyPageBasicInfoForm from '@/components/Account/MyPage/Basic/MyPageBasicInfoForm.vue';
import { mapGetters, mapActions } from 'vuex';
import axios from 'axios';
import sowl from '@/api/sowl';

export default {
  name: 'MyPageBasicInfoView',
  components: {
    MyPageAvatar,
    MyPageBasicInfoForm,
  },
  methods: {
    ...mapActions(['logout']),
    withdrawal() {
      axios({
        url: sowl.users.users(),
        method: 'delete',
        data: {
          userId: this.currentUser,
        },
      })
        .then(() => {
          alert('성공적으로 탈퇴하였습니다');
          this.logout();
        })
        .catch((error) => {
          console.error(error);
        });
    },
  },
  computed: {
    ...mapGetters(['currentUser', 'userInfo']),
  },
};
</script>

<style scoped>
.profile-position {
  left: 50%;
}
</style>
