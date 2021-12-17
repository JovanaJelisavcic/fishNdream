<template>
  <div>
    <form class="search-container" @submit.prevent="submitSearch">
      <div class="upper-search">
        <input
          class="location-field"
          type="text"
          v-model="location"
          placeholder="Location"
        />
         <input
          class="guests-num-field"
          type="number"
          v-model="guestsNum"
          placeholder="Guests Num"
        />
        
        <button class="search-button" type="submit">Search</button>
      </div>
      <div class="lower-search">
        <vue-date-picker
          class="date-picker"
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
       
      </div>
    </form>
    <div class="slider-container">
      <h4 id="filterh4">Filters</h4>

      <div class="slider">
        Price per night:
        <Slider
          v-model="priceValues"
          @update="priceFilterChanged"
          :format="format"
          :max="1000"
          :step="10"
        />
      </div>
      <button class="reset-button" type="reset" @click="resetFilter">
        Reset
      </button>
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
      },
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
      this.priceValues = [0, 1000];
    },
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
.search-container {
  width: 50%;
  height: 40%;
  position: relative;
  float: left;
}
.slider-container {
  width: 15%;
  height: 40%;
  position: relative;
  float: right;
}
.reset-button {
  color: rgb(31, 32, 32);
  border-radius: 12px;
  position: relative;
  float: right;
  margin-top: 10px;
}
#filterh4 {
  background: url("~@/assets/filter.png") no-repeat;
  text-align: right;
  margin-right: 100px;
  margin-bottom: 20px;
}
.slider {
  width: 150px;
  height: 20%;
  position: relative;
  float: left;
  text-align: center;
}
.upper-search {
  width: auto;
  height: auto;
  margin-bottom: 20px;
}
.lower-search {
  width: auto;
  height: auto;
  margin-right: 50px;
}
.guests-num-field {
  background: url("~@/assets/person.png") no-repeat;
  height: auto;
  width: 10%;
  margin-left: 10px;
  color: #a4a3a3;
  border: 1px solid #ccc;
  border-radius: 5px;
  text-align: right;
  padding: 5px;
  position: relative;
  float: center;
}
.location-field {
  background: url("~@/assets/location.png") no-repeat 2px 2px;
  height: auto;
  width: auto;
  margin: 0px 0px 0px 29px;
  padding: 5px;
  color: #a4a3a3;
  border: 1px solid #ccc;
  border-radius: 5px;
  text-align: center;
}
.search-button {
  background: url("~@/assets/iconsearch.png") no-repeat;
  text-align: right;
  height: auto;
  width: 80px;
  margin-left: 10px;
  padding: 5px;
  cursor: pointer;
  border: 1px solid rgb(140, 85, 170);
  color: rgb(140, 85, 170);
  border-radius: 8px;
}
.date-picker {
  background: url("~@/assets/calendar.png") no-repeat 7px 7px;
  padding-left: 30px;
  width: 60%;
  height: 30%;
  position: relative;
  float: left;
  border-radius: 5px;
  text-align: center;
}


</style>

