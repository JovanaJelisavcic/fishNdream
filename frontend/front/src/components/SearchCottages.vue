<template>
  <div>
    <form @submit.prevent="submitSearch">
      <input type="text" v-model="location" placeholder="Location" />
      <input type="number" v-model="guestsNum" placeholder="Guests Num" />
      <vue-date-picker
        id="date_from"
        v-model="date"
        label="Check In - Check Out"
        formatted="DD-MM-YYYY"
        only-date
        :min-date="minDate"
        range
        no-header
        no-shortcuts
        output-format="YYYY-MM-DDTHH:mm"
      ></vue-date-picker>
      <button type="submit">Search</button>
    </form>
    <div>
      <div>
        <div>
          Price range:
          <Slider
            v-model="priceValues"
            @update="priceFilterChanged"
            :format="format"
            :max="1000"
            :step="10"
          />
          <button type="reset" @click="resetFilter">Reset</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { searchCottages } from "../api";
import Slider from "@vueform/slider/dist/slider.vue2.js";
export default {
  name: "SearchCottages",
  components: {
    Slider,
  },
  data() {
    return {
      location: "",
      guestsNum: 0,
      beginning: null,
      ending: null,
      date: new Date(),
      currentDate: new Date(),
      priceValues: [0, 1000],
      format: function (value) {
        return `€${value}`;
      }
    };
  },
  methods: {
    async submitSearch() {
      var bs = new Date(this.date.start);
      bs.setHours(10);
      bs.setMinutes(0);
      bs.setSeconds(0);
      var bsa = bs.toISOString().split(".")[0].split("T");
      this.beginning = bsa[0] + " " + bsa[1];
      bs = new Date(this.date.end);
      bs.setHours(12);
      bs.setMinutes(0);
      bs.setSeconds(0);
      bsa = bs.toISOString().split(".")[0].split("T");
      this.ending = bsa[0] + " " + bsa[1];
      await searchCottages({
        location: this.location,
        guestsNum: this.guestsNum,
        dateTime: this.beginning,
        endTime: this.ending,
      }).then((response) => {
        this.$store.commit("cottages/setCottages", response);
      });
    },
    priceFilterChanged() {
      this.$store.commit("cottages/filterPriceCottages", this.priceValues);
    },
    resetFilter() {
      this.$store.commit("cottages/resetFilter");
      this.priceValues= [0, 1000];
    }
  },
  computed: {
    minDate() {
      return new Date().toISOString().split("T")[0];
    },
  },
};
</script>


<style src="@vueform/slider/themes/default.css"></style>

<style scoped>
</style>