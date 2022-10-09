<template>
  <v-card class="mx-auto" max-width="1000">
    <v-card-text>
      <div>from {{ this.singleLetter.toUserNickname }}</div>
      <p class="text-h4 text--primary">{{ this.singleLetter.title }}</p>
      <p>{{ this.singleLetter.createDate }}</p>
      <div class="text--primary">
        {{ this.singleLetter.content }}
      </div>
    </v-card-text>
  </v-card>
</template>

<script>
import { mapGetters } from 'vuex';
export default {
  name: 'LetterDetailView',
  computed: {
    ...mapGetters(['singleLetter']),
  },
};
</script>

<style scoped></style>
