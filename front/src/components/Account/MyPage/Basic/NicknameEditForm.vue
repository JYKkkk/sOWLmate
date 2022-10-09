<template>
  <v-row>
    <v-label for="nickname" class="mr-10 width-6 font-08">닉네임</v-label>
    <v-text-field
      id="nickname"
      color="primary"
      variant="underlined"
      v-model="nickname"
      :placeholder="this.userNickname"
      @keydown="NICKNAME_CHECK(false)"
    ></v-text-field>
    <button
      v-if="!isNicknameCheck"
      class="sub-btn btn-small confirm-position mr-1"
      @click="nicknameCheck(nickname)"
    >
      <span>중복검사</span>
    </button>
    <button
      v-if="isNicknameCheck && nickname"
      class="sub-btn btn-small confirm-position"
      @click="modifyUserInfo({ nickname: nickname })"
    >
      <span>변경</span>
    </button>
  </v-row>
</template>

<script>
import { mapGetters, mapActions, mapMutations } from 'vuex';

export default {
  name: 'NicknameEditForm',
  props: {
    userNickname: String,
  },
  data() {
    return {
      nickname: '',
    };
  },
  computed: {
    ...mapGetters(['isNicknameCheck']),
  },
  methods: {
    ...mapActions(['nicknameCheck', 'modifyUserInfo']),
    ...mapMutations(['NICKNAME_CHECK']),
  },
};
</script>

<style></style>
