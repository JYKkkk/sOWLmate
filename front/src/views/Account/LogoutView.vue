<template>
  <div>
    <h1>LogoutView.vue</h1>
  </div>
</template>

<script>
import { mapActions, mapGetters } from 'vuex';

export default {
  name: 'LogoutView',
  methods: {
    ...mapActions(['logout']),
  },
  computed: {
    ...mapGetters(['isLoggedIn']),
  },
  created() {
    if (this.isLoggedIn) {
      this.logout();
    } else {
      alert('잘못된 접근');
      this.$router.back();
    }
  },
};
</script>

<style></style>
