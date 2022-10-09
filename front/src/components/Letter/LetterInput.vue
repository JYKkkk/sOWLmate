<template>
  <form @submit.prevent="emitLetterInput()">
    <div id="background">
      <div class="autocomplete-size">
        <p class="push">Dear</p>
        <v-autocomplete
          v-model="letterData.toUserId"
          :items="friendslList"
          item-title="toUserNickname"
          item-value="toUserId"
          prepend-inner-icon="mdi-account-outline"
          placeholder="편지를 보낼 상대방을 선택해주세요."
        >
        </v-autocomplete>
      </div>
      <div class="title-size">
        <label for="title">Title</label><br />
        <v-text-field
          color="primary"
          prepend-inner-icon="mdi-format-title"
          label="title"
          variant="underlined"
          v-model="letterData.title"
        ></v-text-field>

        <br />
        <div class="content-size">
          <label for="message">Message</label><br />
          <v-textarea
            prepend-inner-icon="mdi-comment"
            v-model="letterData.content"
            name="message_to_recipient"
            placeholder="Be SOULMATE, WITH SOWLMATE!"
          ></v-textarea>
        </div>
        <br />
      </div>
      <div class="ml-8">
        <p>Yours soulful</p>
        <br />
        <v-text-field
          color="primary"
          id="sender_name"
          name="sender"
          placeholder="your name"
          prepend-inner-icon="mdi-account-heart-outline"
          variant="underlined"
        ></v-text-field>
        <v-btn
          class="main-btn btn-big mt-12"
          width="100%"
          type="submit"
          @click="emitProgress(), emitLetterInput()"
        >
          다음
        </v-btn>
      </div>
    </div>
  </form>
</template>

<script>
import { mapGetters } from 'vuex';

export default {
  name: 'LetterCreateView',
  data() {
    return {
      totalFriendsList: [],
      letterData: {
        fromUserId: this.$store.state.accounts.currentUser,
        toUserId: '',
        title: '',
        content: '',
        writingPad: '안됨',
        writingFont: '없음',
      },
      friendslList: this.$store.state.friends.penpalList,
    };
  },
  computed: {
    ...mapGetters([
      'preFriendsList',
      'friendsList',
      'sowlmateList',
      'userInfo',
      'currentUser',
      'penpalList',
    ]),
  },
  methods: {
    emitProgress() {
      this.$emit('progress', 1);
    },
    emitLetterInput() {
      this.$emit('letterData', this.letterData);
    },
  },
  mounted() {
    this.letterData.fromUserId = this.currentUser;
    for (const friend of this.penpalList) {
      this.totalFriendsList.push(friend.toUserNickname);
    }
  },
};
</script>

<style scoped>
h1 {
  text-align: center;
  font-size: 4em;
  color: #f7f7f7;
  margin-bottom: -15px;
}

p {
  display: inline;
  font-size: 1em;
}

#background {
  display: flex;
}

/*form*/
input,
textarea {
  border: none;
  border-radius: 4%;
  height: 1.9em;
  /* padding: 0.7em; */
  font-size: 1.3em;
}

input:focus,
textarea:focus {
  outline-color: pink;
}

.mail_stamp {
  width: 100px;
  float: left;
}

#address {
  text-decoration: underline;
}

textarea {
  overflow: auto;
  resize: none;
  height: 10em;
  width: 17em;
  margin-top: 0.5em;
  margin-bottom: 1em;
}

.push {
  margin-bottom: 1em;
  margin-top: 0.5em;
}

#sender_name {
  margin-top: 4.5em;
  margin-bottom: 1.5em;
}
.autocomplete-size {
  width: 10rem;
  margin-right: 2rem;
}
.title-size {
  width: 20rem;
}
/* .content-size {
  left: -60rem;
  width: 50rem;
} */
/* footer {
  margin: 2em auto;
  text-align: center;
  color: white;
} */
</style>
