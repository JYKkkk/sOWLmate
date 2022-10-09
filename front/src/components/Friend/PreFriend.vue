<template>
  <div class="mt-10">
    <div class="mt-16">
      <v-row>
        <h2>PRE-FRIENDS</h2>
        <div class="ml-6"></div>
        <p class="sub-chip"><span>펜팔 가능</span></p>
      </v-row>
      <br />
      <div v-if="!selected">
        <p>나와 한 번 이상 만난 적 있는, 나의 friends가 될 예비친구들입니다.</p>
        <br />
        <p>
          예비 친구에게 편지를 통해, 혹은 화상 미팅을 통해 만남을 갖고, 친밀도를
          쌓아 friends가 되어 보세요!
        </p>
        <p>friends가 되면, 프로필이 공개되고 나의 친구 목록에 추가됩니다.</p>
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
              :profilePictureUrl="1"
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
