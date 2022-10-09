<template>
  <v-container class="mt-3">
    <div>
      <h1>Photo Booth</h1>
      <button @click="getPhotos">사진불러오기</button>
      <!--이미지 소스 리스트 -> 이미지 카드 뷰 -> 클릭 시 확대된 모달창-->
      <ul>
        <li v-for="photo in photos" :key="photo.no">
          <img
            class="item_photo"
            :src="photo.pictureUrl"
            @click="
              {
                isModalViewed = true;
                pictureUrl = photo.pictureUrl;
              }
            "
          />
          <profile-modal
            v-if="isModalViewed"
            @close-modal="isModalViewed = false"
            :pictureUrl="pictureUrl"
          ></profile-modal>
        </li>
      </ul>
    </div>
  </v-container>
</template>

<script>
import { mapGetters } from 'vuex';
import sowl from '@/api/sowl.js';
import axios from 'axios';

import ProfileModal from '@/components/Profile/ProfileModal.vue';

export default {
  name: 'PhotoBoothView',
  components: {
    ProfileModal,
  },
  data() {
    return {
      photos: [],
      isModalViewed: false,
      pictureUrl: '',
    };
  },
  methods: {
    getPhotos() {
      // console.log(this.currentUser);
      // console.log(sowl.photoBooth.userPhotos());
      axios
        .get(`${sowl.photoBooth.userPhotos()}`, {
          headers: {
            userId: this.currentUser,
          },
        })
        .then((response) => {
          this.photos = response.data;
          // console.log(this.photos);
        })
        .catch((error) => {
          console.error(error);
        });
    },
  },
  computed: {
    ...mapGetters(['currentUser']),
  },
};
</script>

<style>
.item_photo {
  width: 150px;
  height: 150px;
}
</style>
