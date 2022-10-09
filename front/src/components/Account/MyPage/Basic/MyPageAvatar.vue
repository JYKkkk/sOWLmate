<template>
  <div>
    <div class="img-label">
      <label for="image" v-if="profile">
        <img :src="profile" alt="프로필이미지" />
      </label>
      <label for="image" v-if="!profile">
        <img
          src="https://pdtxar.com/wp-content/uploads/2019/04/person-placeholder.jpg"
          alt="프로필이미지"
        />
      </label>
      <v-badge
        floating
        content="삭제"
        color="primary"
        @click="img_delete()"
        class="badge-position"
      ></v-badge>
      <input type="file" id="image" @change="upload()" />
    </div>
  </div>
</template>

<script>
import firebase from 'firebase/compat/app';
import 'firebase/compat/storage';
import { mapGetters } from 'vuex';
import axios from 'axios';
import sowl from '@/api/sowl';

export default {
  props: {
    profilePictureUrl: String,
  },
  data() {
    return {
      profile: this.profilePictureUrl,
    };
  },
  computed: {
    ...mapGetters(['currentUser', 'userInfo']),
  },
  methods: {
    upload() {
      const storage = firebase.storage();
      var file = document.querySelector('#image').files[0];
      var storageRef = storage.ref();
      var spaceRef = storageRef.child('image/' + this.currentUser);
      var uploading = spaceRef.put(file);
      uploading.on(
        'state_changed',
        null,
        (error) => {
          console.error('프로필 업로드 실패:', error);
        },
        // 성공시 동작하는 함수
        () => {
          uploading.snapshot.ref.getDownloadURL().then((imgUrl) => {
            this.profile = imgUrl;
            axios({
              url: sowl.users.profile(),
              method: 'put',
              data: {
                userId: this.currentUser,
                profilePictureUrl: imgUrl,
              },
            })
              .then(() => {})
              .catch((error) => {
                console.log(error);
              });
          });
        },
      );
    },
    img_delete() {
      axios({
        url: sowl.users.profile(),
        method: 'put',
        data: {
          userId: this.currentUser,
          profilePictureUrl: '',
        },
      })
        .then(() => {
          this.profile = '';
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
  mounted() {
    if (this.profilePictureUrl.length > 0) {
      this.profile = this.profilePictureUrl;
    }
  },
};
</script>

<style scoped>
img {
  width: 10rem;
  height: 10rem;
  border-radius: 50%;
  cursor: pointer;
}

input {
  visibility: hidden;
}
.badge-position {
  position: relative;
  left: -2rem;
  cursor: pointer;
}
.img-label {
  position: relative;
  left: 10rem;
  margin-top: 5rem;
}
</style>
