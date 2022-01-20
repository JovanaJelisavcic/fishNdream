<template>
  <div v-if="adventure" class="sticky col-md-8">
    <b-row>
      <b-col>
        <button @click="prev" id="prev">Previous</button>
        <button @click="next" id="next">Next</button>
        <transition-group name="fade" tag="div">
          <div v-for="number in [currentNumber]" :key="number">
            <img :src="currentImage" />
          </div>
        </transition-group>
      </b-col>
      <b-col class="details">
        <h1>{{ adventure.name }}</h1>

        <p>
          <small>{{ adventure.description }}</small
          ><br />
          📍 at {{ adventure.address }}<br />
          {{ adventure.price }}$ per hour<br />
          {{ adventure.maxParticipants }} 👤
          <br />
        </p>
        <p v-if="adventure.cancelPolicy">
          If you cancel your reservation the owner keeps part of the money
        </p>
        <p v-if="!adventure.cancelPolicy">
          You can cancel your reservation for free!
        </p>
        <b-row>
          <b-col
            ><h3>
              Instructor: {{ adventure.instructor.name }}
              {{ adventure.instructor.surname }}
            </h3></b-col
          >
          <b-col>
            <b-button
              id="subs-button"
              v-if="!isSubscribedInstructor"
              variant="outline-primary"
              class="pull-right"
              @click="goSubscribe"
              >🔔 Subscribe</b-button
            >
            <div v-if="isSubscribedInstructor">
              🔔 You're subscribed!
            </div></b-col
          >
        </b-row>
        <p>
          "{{ adventure.instructor.shortBio }}"<br />
          {{ adventure.instructor.rating }}⭐<br />
          From {{ adventure.instructor.city }}<br />
          And you'll have to respect his/her rules:<br />
          {{ adventure.behaviourRules }}<br />
        </p>
        <b-table striped :items="items"></b-table>
      </b-col>
    </b-row>
    <b-row>
      <div class="actions ui middle aligned divided list" v-if="actions">
        <ActionItemAdventure
          class="item"
          v-for="(action, reservationId) in actions"
          :key="reservationId"
          :action="action"
        ></ActionItemAdventure>
      </div>
      <div v-if="!actions">
        There are no active promotions for this adventure
      </div>
    </b-row>
    <div class="reservation-part" v-if="reservable">
      <button @click="reserveAdventure" class="ui positive huge button">Reserve</button> for dates you
      searched {{ moment(beginDate).format("YYYY-MM-DD HH:mm") }} to
      {{ moment(endDate).format("YYYY-MM-DD HH:mm") }}
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import { subscribeInstructor } from "../../../api";
import moment from "moment";
import ActionItemAdventure from "./ActionItemAdventure.vue";
export default {
  name: "AdventureDetailFisher",
  props: ["adventure"],
  components: {
    ActionItemAdventure,
  },
  data() {
    return {
      image_prefix: process.env.VUE_APP_BAKEND_SLIKE_PUTANJA,
      currentNumber: 0,
      timer: null,
    };
  },

  methods: {
    next: function () {
      this.currentNumber += 1;
    },
    prev: function () {
      this.currentNumber -= 1;
    },
    async goSubscribe() {
      await subscribeInstructor(this.adventure.instructor.email);
      this.$store.commit("adventures/setIsSubscribed", true);
    },
    moment,
    reserveAdventure() {
      let id = this.adventure.adventureId;
      let begin = this.beginDate;
      let end = this.endDate;
      let people = this.adventure.maxParticipants;
      let regType = "ADVENTURE";
      let name = this.adventure.name;
      const oneHour =  60 * 60 * 1000; // hours*minutes*seconds*milliseconds
      const firstDate = new Date(this.endDate);
      const secondDate = new Date(this.beginDate);

      const diffDays = Math.round(Math.abs((firstDate - secondDate) / oneHour));
      let price = this.boat.price *(diffDays-1) ;

      this.$router.push({
        name: "ReservationPage",
        params: { id, begin, end, people, regType, name, price },
      });
    },
  },

  computed: {
    currentImage: function () {
      return this.computeImgArray[
        Math.abs(this.currentNumber) % this.computeImgArray.length
      ];
    },
    computeImgArray() {
      var imgs = [];
      for (var i = 0; i < this.adventure.adventurePics.length; i++) {
        imgs.push(this.image_prefix + "/" + this.adventure.adventurePics[i]);
      }
      return imgs;
    },
    items() {
      var items = [];
      for (let ev of this.adventure.additionalServices) {
        items.push({ service: ev.name, price: ev.price + "$" });
      }

      return items;
    },
    isSubscribedInstructor: {
      ...mapGetters("adventures", { get: "getIsSubscribed" }),
    },
    actions: {
      ...mapGetters("adventures", { get: "getActionsRes" }),
    },
    beginDate: {
      ...mapGetters("adventures", { get: "getBeginDate" }),
    },
    endDate: {
      ...mapGetters("adventures", { get: "getEndDate" }),
    },
    reservable: {
      ...mapGetters("adventures", { get: "getIsReservable" }),
    },
  },
};
</script>

<style scoped>
.reservation-part {
  margin-top: 20px;
}
.actions {
  margin-left: 25px;
}
#subs-button {
  margin-top: 0px;
  margin-left: 40px;
}
.sticky {
  font-size: 18px;
}
.details {
  margin-top: 40px;
  margin-bottom: 0px;
  padding: 10px;
}
img {
  height: 500px;
  width: 500px;
  padding: 10px;
  margin-top: 0px;
}
button {
  color: rgb(31, 32, 32);
  border-radius: 12px;
  margin-top: 45px;
}
#prev {
  position: relative;
  float: left;
}
#next {
  position: relative;
  float: right;
}
</style>