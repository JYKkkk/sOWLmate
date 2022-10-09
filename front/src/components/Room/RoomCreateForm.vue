<template>
  <v-container>
    <h2>방 만들기</h2>
    <form @submit.prevent="createRoom(newRoom)">
      <h4 class="mt-6 ml-2">방 제목</h4>
      <v-text-field
        color="primary"
        prepend-icon="mdi-home"
        v-model="newRoom.title"
        label="방 제목을 입력해주세요"
      ></v-text-field>
      <!-- <label for="title">제목 : </label>
      <input
        type="text"
        placeholder="방 제목을 입력해주세요."
        id="title"
        v-model="newRoom.title"
      /> -->
      <div>
        <h4 class="mt-6 ml-2">썸네일 등록</h4>
        <!-- <label for="thumbnail">썸네일 : </label>
        <input type="file" id="thumbnail" /> -->
        <v-file-input
          id="thumbnail"
          accept="image/*"
          label="썸네일 등록하기"
        ></v-file-input>
      </div>
      <h4 class="mt-6 ml-2">관심사 선택</h4>
      <div v-if="userInterest.length === 0">
        <router-link :to="{ name: 'MypageEditInterestView' }"
          >관심사를 먼저 선택해야 이용 가능합니다. 관심사 선택하러
          가기</router-link
        >
      </div>
      <div v-else>
        <p>관심사는 하나만 선택 가능합니다.</p>
        <v-chip-group v-if="!isInterestMore" v-model="newRoom.interest" column>
          <v-chip
            color="primary"
            v-for="interest in userInterest"
            :key="userInterest[interest]"
          >
            {{ interest }}
          </v-chip>
        </v-chip-group>
        <v-btn v-if="!isInterestMore" size="small" @click="interestMore()"
          >관심사 모두 보기</v-btn
        >
        <v-chip-group v-if="isInterestMore" v-model="newRoom.interest" column>
          <v-chip
            color="primary"
            v-for="interest in userInterest"
            :key="userInterest[interest]"
          >
            {{ interest }}
          </v-chip>
          <v-chip
            color="primary"
            v-for="interest in userNotInterest"
            :key="userNotInterest[interest]"
          >
            {{ interest }}
          </v-chip>
        </v-chip-group>
      </div>

      <!-- <div>
        <h4 class="mt-6 ml-2">비밀번호 걸기</h4>
        <input
          type="checkbox"
          id="checkbox"
          true-value="LOCK"
          false-value="UNLOCK"
          v-model="newRoom.locks"
          @click="lockCheck()"
        />
        <label for="checkbox" v-if="newRoom.locks === 'UNLOCK'"> LOCK </label>
        <label for="checkbox" v-if="newRoom.locks === 'LOCK'"> UNLOCK </label>
      </div>
      <div>
        <label for="password" v-if="newRoom.locks === 'LOCK'"
          >방 비밀번호 :
        </label>
        <input
          type="text"
          placeholder="방 비밀번호를 지정해주세요."
          id="password"
          v-if="newRoom.locks === 'LOCK'"
          v-model="newRoom.password"
        />
      </div> -->
      <v-btn
        type="submit"
        @click="upload()"
        :disabled="!newRoom.title && !newRoom.interest"
        >생성</v-btn
      >
    </form>
  </v-container>
</template>

<script>
import { mapGetters, mapActions, mapMutations } from 'vuex';
import firebase from 'firebase/compat/app';
import 'firebase/compat/storage';

export default {
  name: 'RoomCreateForm',
  data() {
    return {
      newRoom: {
        title: '',
        ownerId: '',
        interest: '',
        language: '',
        locks: 'UNLOCK',
        password: '',
        thumbnail: '',
      },
      nickname: {
        userNickname: '',
      },
      userInterest: [],
      userNotInterest: [],
      isInterestMore: false,
    };
  },
  computed: {
    ...mapGetters(['InterestList', 'userInfo']),
  },
  methods: {
    ...mapActions(['userInterestSave', 'createRoom']),
    ...mapMutations(['FROM_USER_NICKNAME']),
    userInfoCheck() {
      this.FROM_USER_NICKNAME(this.userInfo.nickname);
      this.userNotInterest = this.InterestList;
      this.newRoom.ownerId = this.userInfo.id;
      this.newRoom.language = this.userInfo.language;
      for (const userinterest of this.userInfo.interests) {
        if (this.InterestList.includes(userinterest['title'])) {
          this.userInterest.push(userinterest['title']);
          this.userNotInterest = this.userNotInterest.filter(
            (interest) => interest !== userinterest['title'],
          );
        }
      }
    },
    lockCheck() {
      let lock = this.newRoom.locks;
      if (lock === 'LOCK') {
        lock = 'UNLOCK';
        this.newRoom.password = '';
      } else {
        lock = 'LOCK';
      }
    },
    interestMore() {
      this.isInterestMore = !this.isInterestMore;
    },
    upload() {
      if (this.newRoom.interest > 4) {
        this.newRoom.interest = this.userNotInterest[this.newRoom.interest - 4];
      } else {
        this.newRoom.interest = this.userInterest[this.newRoom.interest];
      }
      const storage = firebase.storage();
      var file = document.querySelector('#thumbnail').files[0];
      var storageRef = storage.ref();
      var spaceRef = storageRef.child('thumbnail/' + file.name);
      var uploading = spaceRef.put(file);
      uploading.on(
        'state_changed',
        // 변화시 동작하는 함수
        null,
        //에러시 동작하는 함수
        (error) => {
          console.error('썸네일 업로드 실패:', error);
        },
        // 성공시 동작하는 함수
        () => {
          uploading.snapshot.ref.getDownloadURL().then((url) => {
            this.newRoom.thumbnail = url;
          });
        },
      );
    },
  },
  mounted() {
    this.userInfoCheck();
  },
};
</script>

<style></style>
