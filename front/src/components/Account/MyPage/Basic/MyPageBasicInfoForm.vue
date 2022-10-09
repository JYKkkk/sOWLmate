<template>
  <div>
    <v-row>
      <v-label for="email" class="mr-10 width-6 font-08"
        >아이디(이메일)</v-label
      >
      <v-text-field
        id="email"
        variant="underlined"
        :placeholder="this.currentUser"
        readonly
        :value="this.currentUser"
      ></v-text-field>
    </v-row>
    <NicknameEditForm :userNickname="this.userNickname" />
    <RegionEditForm :userRegion="this.userRegion" />
  </div>
</template>

<script>
import NicknameEditForm from '@/components/Account/MyPage/Basic/NicknameEditForm.vue';
import RegionEditForm from '@/components/Account/MyPage/Basic/RegionEditForm.vue';

export default {
  components: {
    NicknameEditForm,
    RegionEditForm,
  },
  props: {
    currentUser: String,
    userNickname: String,
    userRegion: String,
  },
};
</script>

<style></style>
