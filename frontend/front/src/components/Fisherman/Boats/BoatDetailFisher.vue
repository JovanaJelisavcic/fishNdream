<template>
  <div v-if="boat" class="sticky col-md-8">
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
        <b-row>
          <b-col>
            <h1>{{ boat.name }}</h1>
          </b-col>
          <b-col>
            <b-button
              id="subs-button"
              v-if="!isSubscribedBoat"
              variant="outline-primary"
              class="pull-right"
              @click="goSubscribe"
              >🔔 Subscribe</b-button
            >
            <div v-if="isSubscribedBoat">🔔 You're subscribed!</div>
          </b-col>
        </b-row>

        <p>
          <small>{{ boat.boatType }}</small
          ><br />
          <small> {{ boat.description }}</small
          ><br />
          📍 at {{ boat.address }}<br />
          {{ boat.price }}$ per hour<br />
          {{ boat.capacity }} 👤 on {{ boat.length }}m long boat <br />
          {{ boat.rating }}⭐<br />
          <br />
          The owner is {{ boat.owner.name }} {{ boat.owner.surname }}<br />
          And you'll have to respect his/her rules:<br />
          {{ boat.behaviourRules }}<br />
        </p>
        <p v-if="boat.cancelPolicy">
          If you cancel your reservation the owner keeps part of the money
        </p>
        <p v-if="!boat.cancelPolicy">
          You can cancel your reservation for free!
        </p>
        <p>
          <br />
          Boat spec<br />
          *{{ boat.engineNum }} engine(s) with {{ boat.enginePower }}HP <br />
          *Maximum of {{ boat.maxSpeed }}knots
        </p>
        <b-table striped :items="items"></b-table>
      </b-col>
    </b-row>
    <b-row>
      <div class="actions ui middle aligned divided list" v-if="actions">
        <ActionItemBoat
          class="item"
          v-for="(action, reservationId) in actions"
          :key="reservationId"
          :action="action"
        ></ActionItemBoat>
      </div>
      <div v-if="!actions">There are no active promotions for this boat</div>
    </b-row>
    <div class="reservation-part" v-if="reservable">
      <button @click="reserveBoat" class="ui positive huge button">
        Reserve
      </button>
      from
      {{ moment(beginDate).format("YYYY-MM-DD HH:mm") }} to
      {{ moment(endDate).format("YYYY-MM-DD HH:mm") }} for {{ reservePrice }}$
    </div>
    <b-row>
      <vue-cal
        class="vuecal--green-theme"
        active-view="month"
        :disable-views="['years', 'week']"
        :min-date="minDate"
        today-button
        :events="events"
        events-on-month-view="true"
        :time-from="5 * 60"
        :time-to="23 * 60"
        style="height: 500px; margin-top: 40px"
      />
    </b-row>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import { subscribeBoat } from "../../../api";
import moment from "moment";
import ActionItemBoat from "./ActionItemBoat.vue";
export default {
  name: "BoatDetailFisher",
  components: {
    ActionItemBoat,
  },
  props: ["boat"],
  data() {
    return {
      image_prefix: process.env.VUE_APP_BAKEND_SLIKE_PUTANJA,
      currentNumber: 0,
      timer: null,
      currentDate: new Date(),
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
      await subscribeBoat(this.boat.boatId);
      this.$store.commit("boats/setIsSubscribed", true);
    },
    moment,
    reserveBoat() {
      let id = this.boat.boatId;
      let begin = this.beginDate;
      let end = this.endDate;
      let people = this.boat.capacity;
      let regType = "BOAT";
      let name = this.boat.name;
      let price = this.reservePrice;
      let guests = this.peopleNum;

      this.$router.push({
        name: "ReservationPage",
        params: { id, begin, end, people, regType, name, price, guests },
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
      for (var i = 0; i < this.boat.boatPics.length; i++) {
        imgs.push(this.image_prefix + "/" + this.boat.boatPics[i]);
      }
      return imgs;
    },
    minDate() {
      return this.currentDate;
    },
    events() {
      var events = [];
      for (let ev of this.boat.unavailablePeriods) {
        events.push({ start: ev.beggining, end: ev.ending, title: "Busy" });
      }

      return events;
    },
    items() {
      var items = [];
      for (let ev of this.boat.additionalServices) {
        items.push({ service: ev.name, price: ev.price + "$" });
      }

      return items;
    },
    isSubscribedBoat: {
      ...mapGetters("boats", { get: "getIsSubscribed" }),
    },
    beginDate: {
      ...mapGetters("boats", { get: "getBeginDate" }),
    },
    endDate: {
      ...mapGetters("boats", { get: "getEndDate" }),
    },
    actions: {
      ...mapGetters("boats", { get: "getActionsRes" }),
    },
    reservable: {
      ...mapGetters("boats", { get: "getIsReservable" }),
    },
    reservePrice: {
      ...mapGetters("boats", { get: "getReservePrice" }),
    },
    peopleNum: {
      ...mapGetters("boats", { get: "getPeopleNum" }),
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
.vuecal__cell--disabled {
  text-decoration: line-through;
}
.vuecal__cell--before-min {
  color: #b6d6c7;
}
.vuecal__now-line {
  color: #06c;
}
</style>