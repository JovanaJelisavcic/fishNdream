<template>
  <div v-if="cottage" class="sticky col-md-8 row">
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
          <div v-if="isSubscribedCottage">
            🔔 You're subscribed!
          </div></b-col
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
  </div>
</template>


<script>
import { mapGetters } from "vuex";
import { subscribeCottage } from "../../../api";
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
  },
};
</script>

<style scoped>
#subs-button {
  margin-top: 0px;
  margin-left: 40px;
}
.sticky {
  position: -webkit-sticky;
  position: sticky;
  top: 20%;
  font-size: 18px;
  align-self: flex-start;
  height: auto;
}
.details {
  margin-top: 50px;
  margin-bottom: 1000px;
  padding: 10px;
  border: 1px solid #ddd;
  border-radius: 4px;
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