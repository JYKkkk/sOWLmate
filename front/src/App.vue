<template>
  <v-app>
    <TheNavBar />
    <v-main>
      <router-view />
    </v-main>
  </v-app>
</template>

<script>
import TheNavBar from '@/components/Common/TheNavBar.vue';
export default {
  components: {
    TheNavBar,
  },
  name: 'App',

  data: () => ({
    //
  }),
};
</script>
