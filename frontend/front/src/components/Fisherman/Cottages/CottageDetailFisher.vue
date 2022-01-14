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
    <b-row
      ><div class="actions ui middle aligned divided list" v-if="actions">
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
                <h4>
                  📅 {{ moment(action.beginning).format("YYYY-MM-DD") }} to
                  {{ moment(action.ending).format("YYYY-MM-DD") }}<br />
                </h4>
                ONLY AVAILABLE UNTIL
                {{ moment(action.actionEndTime).format("YYYY-MM-DD HH:mm") }}
                <br />
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
import { subscribeCottage } from "../../../api";
import moment from "moment";
export default {
  name: "CottageDetailFisher",
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
  },
};
</script>

<style scoped>
.actions {
  margin-left: 25px;
}
.resA-button {
  margin-right: 100px;
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