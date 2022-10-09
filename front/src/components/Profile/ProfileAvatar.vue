<template>
  <img :src="friendImg" id="profileimg" alt="profile card" />
</template>

<script>
export default {
  props: {
    profilePictureUrl: String,
  },
  data() {
    return {
      friendImg: '',
    };
  },
  mounted() {
    if (this.profilePictureUrl === 1) {
      // 예비친구일 때
      this.friendImg =
        'https://firebasestorage.googleapis.com/v0/b/sowlmate-3afc1.appspot.com/o/image%2F1258903816712897489127unknow.svg?alt=media&token=b572b927-fdec-4e26-ab6f-7bb7943afd0e';
    } else if (!this.profilePictureUrl) {
      this.friendImg =
        'https://pdtxar.com/wp-content/uploads/2019/04/person-placeholder.jpg';
    } else {
      this.friendImg = this.profilePictureUrl;
    }
  },
};
</script>

<style scoped>
.questionMark {
  font-size: 5rem;
  position: absolute;
}
</style>
