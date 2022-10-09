<template>
  <div>
    <PreFriend :friendsList="this.preFriendsList" />
    <MiddleFriend :friendsList="this.friendsList" />
    <SowlMate :friendsList="this.sowlmateList" />
  </div>
</template>

<script>
import PreFriend from '@/components/Friend/PreFriend.vue';
import MiddleFriend from '@/components/Friend/MiddleFriend.vue';
import SowlMate from '@/components/Friend/SowlMate.vue';

export default {
  components: {
    PreFriend,
    MiddleFriend,
    SowlMate,
  },
  props: {
    preFriendsList: Array,
    friendsList: Array,
    sowlmateList: Array,
  },
};
</script>

<style></style>
