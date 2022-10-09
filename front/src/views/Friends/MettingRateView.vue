<template>
  <div class="bg">
    <div class="container">
      <div class="feedback">
        <div class="rating">
          <input type="radio" name="rating" id="rating-5" v-model="point5" />
          <label for="rating-5"></label>
          <input type="radio" name="rating" id="rating-4" v-model="point4" />
          <label for="rating-4"></label>
          <input type="radio" name="rating" id="rating-3" v-model="point3" />
          <label for="rating-3"></label>
          <input type="radio" name="rating" id="rating-2" v-model="point2" />
          <label for="rating-2"></label>
          <input type="radio" name="rating" id="rating-1" v-model="point1" />
          <label for="rating-1"></label>
          <div class="emoji-wrapper">
            <div class="emoji">
              <div class="ratingbox rating-0">
                <h4 class="text-gradient">우린 여기까지인가봐...</h4>
              </div>
              <div class="ratingbox rating-1">
                <h4 class="text-gradient">우리 나쁘지 않았어</h4>
              </div>
              <div class="ratingbox rating-2">
                <h4 class="text-gradient">우리 좀더 이야기해볼까봐~</h4>
              </div>
              <div class="ratingbox rating-3">
                <h4 class="text-gradient">너 좀 재미있구나?</h4>
              </div>
              <div class="ratingbox rating-4">
                <h4 class="text-gradient">언제 또 볼래? 당장 정해~</h4>
              </div>
              <div class="ratingbox rating-5">
                <h4 class="text-gradient">
                  내 영혼의 단짝! 어디있다 이제 나타난거야~
                </h4>
              </div>
            </div>
          </div>
        </div>
      </div>
      <button class="main-btn" @click="user_evaluation()">제출</button>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import sowl from '@/api/sowl';
import router from '@/router';
import { mapGetters } from 'vuex';
export default {
  data() {
    return {
      point1: 0,
      point2: 0,
      point3: 0,
      point4: 0,
      point5: 0,
    };
  },
  computed: {
    ...mapGetters(['toUserNickname', 'fromUserNickname']),
  },
  methods: {
    user_evaluation() {
      let usereval = 0;
      if (this.point5) {
        usereval = 10;
      } else if (this.point4) {
        usereval = 8;
      } else if (this.point3) {
        usereval = 6;
      } else if (this.point2) {
        usereval = 4;
      } else if (this.point1) {
        usereval = 2;
      }
      axios({
        url: sowl.intimacy.intimacy(),
        method: 'put',
        data: {
          fromUserId: this.fromUserNickname,
          toUserId: this.toUserNickname,
          eval: usereval,
        },
      })
        .then(() => {
          // console.log(response);
          router.push({ name: 'HomeView' });
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
};
</script>

<style scoped>
* {
  box-sizing: border-box;
}
.bg {
  width: 100%;
  height: 100%;
  background: linear-gradient(180deg, #a48ee6 0%, #acc8fb 100%);
}
.container {
  background-image: url('https://www.toptal.com/designers/subtlepatterns/patterns/concrete-texture.png');
  display: flex;
  flex-wrap: wrap;
  height: 100vh;
  align-items: center;
  justify-content: center;
  padding: 0 20px;
}

.rating {
  display: flex;
  width: 100%;
  justify-content: center;
  overflow: hidden;
  flex-direction: row-reverse;
  height: 150px;
  position: relative;
}

.rating-0 {
  filter: grayscale(100%);
}

.rating > input {
  display: none;
}

.rating > label {
  cursor: pointer;
  width: 40px;
  height: 40px;
  margin-top: auto;
  background-image: url("data:image/svg+xml;charset=UTF-8,%3csvg xmlns='http://www.w3.org/2000/svg' width='126.729' height='126.73'%3e%3cpath fill='%23e3e3e3' d='M121.215 44.212l-34.899-3.3c-2.2-.2-4.101-1.6-5-3.7l-12.5-30.3c-2-5-9.101-5-11.101 0l-12.4 30.3c-.8 2.1-2.8 3.5-5 3.7l-34.9 3.3c-5.2.5-7.3 7-3.4 10.5l26.3 23.1c1.7 1.5 2.4 3.7 1.9 5.9l-7.9 32.399c-1.2 5.101 4.3 9.3 8.9 6.601l29.1-17.101c1.9-1.1 4.2-1.1 6.1 0l29.101 17.101c4.6 2.699 10.1-1.4 8.899-6.601l-7.8-32.399c-.5-2.2.2-4.4 1.9-5.9l26.3-23.1c3.8-3.5 1.6-10-3.6-10.5z'/%3e%3c/svg%3e");
  background-repeat: no-repeat;
  background-position: center;
  background-size: 76%;
  transition: 0.3s;
}

.rating > input:checked ~ label,
.rating > input:checked ~ label ~ label {
  background-image: url("data:image/svg+xml;charset=UTF-8,%3csvg xmlns='http://www.w3.org/2000/svg' width='126.729' height='126.73'%3e%3cpath fill='%23fcd93a' d='M121.215 44.212l-34.899-3.3c-2.2-.2-4.101-1.6-5-3.7l-12.5-30.3c-2-5-9.101-5-11.101 0l-12.4 30.3c-.8 2.1-2.8 3.5-5 3.7l-34.9 3.3c-5.2.5-7.3 7-3.4 10.5l26.3 23.1c1.7 1.5 2.4 3.7 1.9 5.9l-7.9 32.399c-1.2 5.101 4.3 9.3 8.9 6.601l29.1-17.101c1.9-1.1 4.2-1.1 6.1 0l29.101 17.101c4.6 2.699 10.1-1.4 8.899-6.601l-7.8-32.399c-.5-2.2.2-4.4 1.9-5.9l26.3-23.1c3.8-3.5 1.6-10-3.6-10.5z'/%3e%3c/svg%3e");
}

.rating > input:not(:checked) ~ label:hover,
.rating > input:not(:checked) ~ label:hover ~ label {
  background-image: url("data:image/svg+xml;charset=UTF-8,%3csvg xmlns='http://www.w3.org/2000/svg' width='126.729' height='126.73'%3e%3cpath fill='%23d8b11e' d='M121.215 44.212l-34.899-3.3c-2.2-.2-4.101-1.6-5-3.7l-12.5-30.3c-2-5-9.101-5-11.101 0l-12.4 30.3c-.8 2.1-2.8 3.5-5 3.7l-34.9 3.3c-5.2.5-7.3 7-3.4 10.5l26.3 23.1c1.7 1.5 2.4 3.7 1.9 5.9l-7.9 32.399c-1.2 5.101 4.3 9.3 8.9 6.601l29.1-17.101c1.9-1.1 4.2-1.1 6.1 0l29.101 17.101c4.6 2.699 10.1-1.4 8.899-6.601l-7.8-32.399c-.5-2.2.2-4.4 1.9-5.9l26.3-23.1c3.8-3.5 1.6-10-3.6-10.5z'/%3e%3c/svg%3e");
}

.emoji-wrapper {
  width: 100%;
  text-align: center;
  height: 100px;
  overflow: hidden;
  position: absolute;
  top: 0;
  left: 0;
}

.emoji-wrapper:before,
.emoji-wrapper:after {
  content: '';
  height: 15px;
  width: 100%;
  position: absolute;
  left: 0;
  z-index: 1;
}

.emoji-wrapper:before {
  top: 0;
  background: linear-gradient(
    to bottom,
    rgba(255, 255, 255, 1) 0%,
    rgba(255, 255, 255, 1) 35%,
    rgba(255, 255, 255, 0) 100%
  );
}

.emoji-wrapper:after {
  bottom: 0;
  background: linear-gradient(
    to top,
    rgba(255, 255, 255, 1) 0%,
    rgba(255, 255, 255, 1) 35%,
    rgba(255, 255, 255, 0) 100%
  );
}

.emoji {
  display: flex;
  flex-direction: column;
  align-items: center;
  transition: 0.3s;
}

.emoji > svg {
  margin: 15px 0;
  width: 70px;
  height: 70px;
  flex-shrink: 0;
}

#rating-1:checked ~ .emoji-wrapper > .emoji {
  transform: translateY(-100px);
}
#rating-2:checked ~ .emoji-wrapper > .emoji {
  transform: translateY(-200px);
}
#rating-3:checked ~ .emoji-wrapper > .emoji {
  transform: translateY(-300px);
}
#rating-4:checked ~ .emoji-wrapper > .emoji {
  transform: translateY(-400px);
}
#rating-5:checked ~ .emoji-wrapper > .emoji {
  transform: translateY(-500px);
}

.feedback {
  max-width: 500px;
  background-color: #fff;
  width: 100%;
  margin-left: 10%;
  padding: 30px;
  border-radius: 8px;
  display: flex;
  flex-direction: column;
  flex-wrap: wrap;
  align-items: center;
  box-shadow: 0 4px 30px rgba(0, 0, 0, 0.05);
}
.main-btn {
  position: relative;
  width: 10rem;
  height: 2rem;
  top: 12rem;
  left: -20rem;
}
.ratingbox {
  height: 2.4rem;
  margin: 2rem;
}
</style>
