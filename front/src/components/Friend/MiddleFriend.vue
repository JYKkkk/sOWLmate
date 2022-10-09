<template>
  <div class="mt-16">
    <div class="mt-16">
      <v-row>
        <h2>FRIENDS</h2>
        <div class="ml-6"></div>
        <p class="sub-chip"><span>펜팔 가능</span></p>
        <p class="sub-chip"><span>친구 목록</span></p>
        <p class="sub-chip"><span>프로필 공개</span></p>
      </v-row>
      <br />
      <div v-if="!selected">
        <p>나와 일정 기간 친밀도를 쌓아 친구 목록에 등록된 친구들입니다</p>
        <br />
        <p>친구의 모습이 궁금하지 않으신가요?</p>
        <p>더욱 친밀도를 쌓아 친구와 마스크를 벗고 이야기 해보세요!</p>
      </div>
    </div>
    <div class="friend-list-contaioner">
      <v-sheet class="mx-auto">
        <v-slide-group show-arrows center-active class="pa-4">
          <v-slide-group-item
            v-for="friend in friendsList"
            :key="friend.toUserNickname"
          >
            <ProfileForm
              :name="friend.toUserNickname"
              :intimacyEval="friend.intimacyEval"
              :region="friend.region"
              :language="friend.language"
              :interests="friend.interests"
              :profilePictureUrl="friend.profilePictureUrl"
            />
          </v-slide-group-item>
        </v-slide-group>
      </v-sheet>
    </div>
  </div>
</template>

<script>
import ProfileForm from '@/components/Profile/ProfileForm.vue';

export default {
  components: {
    ProfileForm,
  },
  props: {
    friendsList: Array,
    selected: Number,
  },
  computed: {},
};
</script>

<style scoped>
.friend-list-contaioner {
  position: relative;
  left: -1.2rem;
}
p {
  letter-spacing: -0.02em;
  color: #adb5bd;
}
</style>
