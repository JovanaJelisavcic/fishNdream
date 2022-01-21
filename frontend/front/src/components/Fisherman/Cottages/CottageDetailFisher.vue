<template>
  <div v-if="cottage" class="sticky col-md-8">
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
            <h1>{{ cottage.name }}</h1>
          </b-col>
          <b-col>
            <b-button
              id="subs-button"
              v-if="!isSubscribedCottage"
              variant="outline-primary"
              class="pull-right"
              @click="goSubscribe"
              >🔔 Subscribe</b-button
            >
            <div v-if="isSubscribedCottage">🔔 You're subscribed!</div></b-col
          >
        </b-row>
        <b-row>
          <p>
            <small> {{ cottage.description }}</small
            ><br />
            📍 at {{ cottage.address }}<br />
            {{ cottage.price }}$ per night<br />
            {{ cottage.guestsNum }} 👤 in {{ cottage.roomNum }} rooms <br />
            {{ cottage.rating }}⭐<br />
            You'll have to respect the rules of the owner:<br />
            {{ cottage.behaviourRules }}<br />
          </p>
          <b-table striped :items="items"></b-table>
        </b-row>
      </b-col>
    </b-row>
    <b-row>
      <div class="actions ui middle aligned divided list" v-if="actions">
        <ActionItemCottage
          class="item"
          v-for="(action, reservationId) in actions"
          :key="reservationId"
          :action="action"
        ></ActionItemCottage>
      </div>

      <div v-if="!actions">There are no active promotions for this cottage</div>
    </b-row>
    <div class="reservation-part" v-if="reservable">
      <button @click="reserveCottage" class="ui positive huge button">
        Reserve
      </button>
      for dates you searched {{ moment(beginDate).format("YYYY-MM-DD") }} to
      {{ moment(endDate).format("YYYY-MM-DD") }}
    </div>
  </div>
</template>


<script>
import { mapGetters } from "vuex";
import { subscribeCottage } from "../../../api";
import ActionItemCottage from "./ActionItemCottage.vue";
import moment from "moment";
export default {
  name: "CottageDetailFisher",
  components: {
    ActionItemCottage,
  },
  props: ["cottage"],
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
      await subscribeCottage(this.cottage.cottageId);
      this.$store.commit("cottages/setIsSubscribed", true);
    },
    moment,
    reserveCottage() {
      let id = this.cottage.cottageId;
      let begin = this.beginDate;
      let end = this.endDate;
      let people = this.cottage.guestsNum;
      let regType = "COTTAGE";
      let name = this.cottage.name;
      const oneDay = 24 * 60 * 60 * 1000; // hours*minutes*seconds*milliseconds
      const firstDate = new Date(this.endDate);
      const secondDate = new Date(this.beginDate);

      const diffDays = Math.round(Math.abs((firstDate - secondDate) / oneDay));
      let price = this.cottage.price *(diffDays-1) ;
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
      for (var i = 0; i < this.cottage.cottagePics.length; i++) {
        imgs.push(this.image_prefix + "/" + this.cottage.cottagePics[i]);
      }
      return imgs;
    },
    items() {
      var items = [];
      for (let ev of this.cottage.additionalServices) {
        items.push({ service: ev.name, price: ev.price + "$" });
      }

      return items;
    },
    isSubscribedCottage: {
      ...mapGetters("cottages", { get: "getIsSubscribed" }),
    },
    actions: {
      ...mapGetters("cottages", { get: "getActionsRes" }),
    },
    beginDate: {
      ...mapGetters("cottages", { get: "getBeginDate" }),
    },
    endDate: {
      ...mapGetters("cottages", { get: "getEndDate" }),
    },
    reservable: {
      ...mapGetters("cottages", { get: "getIsReservable" }),
    },
    peopleNum: {
      ...mapGetters("cottages", { get: "getPeopleNum" }),
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