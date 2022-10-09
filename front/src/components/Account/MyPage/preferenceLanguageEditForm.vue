<template>
  <div class="mt-12">
    <h3>선호언어 변경</h3>
    <v-row class="mt-8">
      <v-label for="lang" class="mr-10 width-6 font-08">선호언어</v-label>
      <v-select
        name="lang"
        id="lang"
        color="primary"
        v-model="lang"
        :items="languageList"
        variant="underlined"
        :placeholder="this.userRegion"
      >
      </v-select>
    </v-row>
    <v-row justify="end" class="mt-4">
      <button
        @click="modifyUserInfo({ preferenceLanguage: lang })"
        class="main-btn"
      >
        저장
      </button>
    </v-row>
  </div>
</template>

<script>
import { mapGetters, mapActions } from 'vuex';

export default {
  name: 'PasswordEditForm',
  data() {
    return {
      lang: '',
    };
  },
  computed: {
    ...mapGetters(['userInfo', 'languageList']),
  },
  methods: {
    ...mapActions(['getUserInfo', 'modifyUserInfo', 'getLanguageList']),
  },
  mounted() {
    this.getLanguageList();
  },
};
</script>

<style></style>
