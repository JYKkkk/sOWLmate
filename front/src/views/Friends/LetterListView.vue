<template>
  <v-container class="mt-3">
    <v-row justify="center" class="mt-16">
      <v-col cols="3"> <MemoryNavigation /> </v-col>
      <v-col cols="9">
        <h2>띵똥! 편지 왔어요</h2>
        <p class="p-small mt-4">
          나에게 도착한 편지, 누구에게 왔을까 궁금하지 않나요?
        </p>
      </v-col>
      <v-container class="list-position">
        <v-row>
          <v-col v-for="letter in nowContent" :key="letter.no" cols="12" md="4">
            <LetterCard
              :fromUserNickname="letter.fromUserNickname"
              :letterNo="letter.no"
            />
          </v-col>
        </v-row>
      </v-container>
      <!-- 페이지 -->
      <div class="pagenation-position">
        <div class="text-center">
          <v-pagination
            v-model="page"
            :length="totalpage"
            :total-visible="4"
          ></v-pagination>
        </div>
      </div>
    </v-row>
  </v-container>
</template>

<script>
import { mapGetters, mapActions } from 'vuex';
import LetterCard from '@/components/Temp/LetterCard.vue';
import MemoryNavigation from '@/components/Temp/MemoryNavigation.vue';

export default {
  name: 'LetterListView',
  components: {
    LetterCard,
    MemoryNavigation,
  },
  data() {
    return {
      page: 1,
      totalpage: 1,
    };
  },
  computed: {
    ...mapGetters(['letterList']),
    nowContent() {
      // 한페이지에 10개씩
      const startindex = (this.page - 1) * 10;
      const endindex = this.page * 10;
      return this.letterList.slice(startindex, endindex);
    },
  },
  methods: {
    ...mapActions(['totalLetterList']),
    pagetotal() {
      this.totalpage = parseInt(this.letterList.length / 10) + 1;
      if (!this.letterList % 10) {
        this.totalpage -= 1;
      }
    },
  },
  mounted() {
    this.pagetotal();
    if (this.letterList.length < 1) {
      this.totalLetterList();
    }
  },
};
</script>

<style scoped>
.pagenation-position {
  position: fixed;
  bottom: 0;
}
.list-position {
  position: relative;
  left: 10rem;
}
</style>
