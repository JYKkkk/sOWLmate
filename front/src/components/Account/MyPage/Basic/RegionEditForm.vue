<template>
  <v-row>
    <v-label for="region" class="mr-10 width-6 font-08">지역</v-label>
    <v-select
      name="region"
      id="region"
      color="primary"
      v-model="region"
      :items="regionList"
      variant="underlined"
      :placeholder="this.userRegion"
    >
    </v-select>
    <button
      class="sub-btn btn-small confirm-position mr-1"
      @click="modifyUserInfo({ region: region })"
    >
      <span>변경</span>
    </button>
  </v-row>
</template>

<script>
import { mapGetters, mapActions } from 'vuex';

export default {
  name: 'RegionEditForm',
  props: {
    userRegion: String,
  },
  data() {
    return {
      region: '',
    };
  },
  computed: {
    ...mapGetters(['userInfo', 'regionList']),
  },
  methods: {
    ...mapActions(['getUserInfo', 'modifyUserInfo', 'getRegionList']),
  },
  mounted() {
    this.getRegionList();
  },
};
</script>

<style></style>
