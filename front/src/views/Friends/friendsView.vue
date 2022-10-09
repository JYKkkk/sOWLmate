<template>
  <v-container class="mt-3">
    <v-row justify="center" class="mt-16">
      <v-col cols="3">
        <MemoryNavigation />
      </v-col>
      <v-col cols="9">
        <v-tabs
          ><v-tab @click="selected = 0"> 전체 </v-tab>
          <v-tab @click="selected = 1"> 예비친구 </v-tab>
          <v-tab @click="selected = 2"> 친구 </v-tab>
          <v-tab @click="selected = 3"> 소울메이트 </v-tab>
        </v-tabs>
        <hr />
        <TotalFriend
          v-if="selected === 0"
          class="my-16"
          :preFriendsList="this.preFriendsList"
          :friendsList="this.friendsList"
          :sowlmateList="this.sowlmateList"
        />
        <PreFriend
          v-if="selected === 1"
          class="my-16"
          :friendsList="this.preFriendsList"
          :selected="selected"
        />
        <MiddleFriend
          v-if="selected === 2"
          class="my-16"
          :friendsList="this.friendsList"
          :selected="selected"
        />
        <SowlMate
          v-if="selected === 3"
          class="my-16"
          :friendsList="this.sowlmateList"
          :selected="selected"
        />
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import TotalFriend from '@/components/Friend/TotalFriend.vue';
import PreFriend from '@/components/Friend/PreFriend.vue';
import MiddleFriend from '@/components/Friend/MiddleFriend.vue';
import SowlMate from '@/components/Friend/SowlMate.vue';
import MemoryNavigation from '@/components/Temp/MemoryNavigation.vue';

import { mapActions, mapGetters } from 'vuex';

export default {
  name: 'friendsView',
  components: {
    TotalFriend,
    PreFriend,
    MiddleFriend,
    SowlMate,
    MemoryNavigation,
  },
  data() {
    return {
      selected: 0,
    };
  },
  computed: {
    ...mapGetters(['preFriendsList', 'friendsList', 'sowlmateList']),
  },
  methods: {
    ...mapActions(['totalFriendList']),
  },
  mounted() {
    this.totalFriendList();
  },
};
</script>

<style scoped></style>
