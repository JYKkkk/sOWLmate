<template>
  <div class="wrapper">
    <div class="profile-card js-profile-card" @click="show = !show">
      <div class="profile-card__img">
        <ProfileAvatar :profilePictureUrl="this.profilePictureUrl" />
      </div>
      <div class="profile-card__cnt js-profile-cnt">
        <h3 class="text-gradient">{{ name }}</h3>
      </div>
      <v-expand-transition>
        <v-container>
          <div v-show="show">
            <ProfileBasicInfo
              class="upup"
              v-if="region"
              :region="this.region"
              :language="this.language"
              :interests="this.interests"
            />
            <ProgressBar :intimacyEval="intimacyEval" />
            <br />
            <router-link :to="{ name: 'LetterCreateView' }">
              <button class="main-btn mb-4" style="width: 100%">
                편지쓰기
              </button>
            </router-link>
            <router-link :to="{ name: 'LetterListView' }">
              <button class="sub-btn" style="width: 100%">편지함</button>
            </router-link>
          </div>
        </v-container>
      </v-expand-transition>
    </div>
  </div>
</template>

<script>
import ProfileAvatar from '@/components/Profile/ProfileAvatar.vue';
import ProgressBar from '@/components/Profile/ProgressBar.vue';
import ProfileBasicInfo from '@/components/Profile/ProfileBasicInfo.vue';

export default {
  components: {
    ProfileAvatar,
    ProgressBar,
    ProfileBasicInfo,
  },
  props: {
    name: String,
    intimacyEval: Number,
    region: String,
    language: String,
    interests: Array,
    profilePictureUrl: String,
  },
  data: () => ({
    show: false,
  }),
  methods: {},
};
</script>

<style lang="scss">
@import '~@/assets/scss/pages/profile.scss';

.upup {
  position: relative;
  top: -1.2rem;
}
</style>
