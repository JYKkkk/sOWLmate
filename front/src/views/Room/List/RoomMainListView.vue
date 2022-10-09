<template>
  <div>
    <h2>방 목록</h2>
    <p class="signup-explain">
      나의 선호 언어 : {{ userInfo.preferenceLanguage }} 와 관심사에 맞추어 방을
      볼 수 있습니다.
    </p>
    <router-link :to="{ name: 'MyPageEditLanguageView' }"
      ><div class="sub-chip"><span>선호 언어 수정</span></div></router-link
    >
    <RoomMainList />
  </div>
</template>

<script>
import RoomMainList from '@/components/Room/Home/RoomMainList.vue';
import { mapGetters } from 'vuex';

export default {
  name: 'RoomMainListView',
  components: { RoomMainList },
  computed: {
    ...mapGetters(['userInfo']),
  },
};
</script>

<style scoped>
.sub-chip {
  width: 6rem;
}
</style>
