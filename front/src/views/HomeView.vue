<template>
  <div>
    <HelloWorld v-if="isLoggedIn" />
    <HelloWorldBeforeLogin v-else />
  </div>
</template>

<script>
import { defineComponent } from 'vue';
import { mapGetters } from 'vuex';

// Components
import HelloWorld from '../components/HelloWorld.vue';
import HelloWorldBeforeLogin from '@/components/HelloWorldBeforeLogin.vue';

export default defineComponent({
  name: 'HomeView',
  components: {
    HelloWorld,
    HelloWorldBeforeLogin,
  },
  computed: {
    ...mapGetters(['isLoggedIn']),
  },
});
</script>
