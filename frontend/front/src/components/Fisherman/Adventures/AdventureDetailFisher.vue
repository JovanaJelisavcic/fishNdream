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
          <div v-if="isSubscribedInstructor">🔔 You're subscribed!</div></b-col
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
    <b-row
      ><div class=" actions ui middle aligned divided list" v-if="actions">
        <h3>Are you interested in promotions?</h3>
        <div
          class="item"
          v-for="(action, reservationId) in actions"
          :key="reservationId"
        >
          <div class="right floated content">
            <div class="ui button resA-button">Reserve Promotion</div>
          </div>
          <div class="content">
            <b-row>
            <b-col>
           <h4>  📅 {{ action.beginning }} to {{ action.ending }}<br /> </h4>
             ONLY AVAILABLE UNTIL
              {{ action.actionEndTime }} <br />
              {{ action.price }}$ for {{ action.participantsNum }}👤 
            </b-col>
            <b-col>
            <div v-if="action.additionalServices">
              <div
                v-for="service in action.additionalServices"
                v-bind:key="service.serviceId"
              >
                {{ service.name }}
              </div>
            </div>
            </b-col>
            </b-row>
          </div>
        </div>
      </div>
      <div v-if="!actions">There are no active promotions for this cottage</div>
    </b-row>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import { subscribeInstructor } from "../../../api";
export default {
  name: "AdventureDetailFisher",
  props: ["adventure"],
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
  },
};
</script>

<style scoped>
.actions{
  margin-left: 25px;
}
.resA-button{
  margin-right: 100px
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