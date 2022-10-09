<template>
  <div class="align">
    <p class="p-small">{{ region }}/{{ language }}</p>
    <v-row class="my-1">
      <p class="main-chip" v-for="interest in interests" :key="interest">
        <span>{{ interest }}</span>
      </p>
    </v-row>
  </div>
</template>

<script>
export default {
  props: {
    region: String,
    language: String,
    interests: Array,
  },
};
</script>

<style scoped>
.p-small {
  color: #adb5bd;
}
.align {
  text-align: center;
  justify-content: center;
}
</style>
