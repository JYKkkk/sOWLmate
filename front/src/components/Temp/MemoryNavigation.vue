<template>
  <div class="d-flex flex-row mt-16">
    <v-tabs v-model="tab" direction="vertical" color="primary">
      <v-tab>
        <router-link :to="{ name: 'friendsView' }">나의친구</router-link>
      </v-tab>
      <v-tab>
        <router-link :to="{ name: 'LetterListView' }">편지목록</router-link>
      </v-tab>
      <v-tab>
        <router-link :to="{ name: 'PhotoBoothView' }">사진첩</router-link>
      </v-tab>
    </v-tabs>
  </div>
</template>

<script>
export default {
  name: 'MyPageNavigation',
  components: {},
  computed: {},
};
</script>

<style scoped></style>
