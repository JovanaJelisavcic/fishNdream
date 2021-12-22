<template>
  <div>
    <form class="search-container wrapper" @submit.prevent="submitSearch">
      <div class="one">
        <p class="error" v-if="errors">
          {{ errors }}
        </p>
        <vue-date-picker
          class="date-picker"
          v-model="startDate"
          label="Check In"
          formatted="DD-MM-YYYY HH:mm"
          :min-date="minDateStart"
          no-header
          no-shortcuts
          output-format="YYYY-MM-DDTHH:mm"
        ></vue-date-picker>
        <vue-date-picker
          class="date-picker"
          v-model="endDate"
          label="Check Out"
          formatted="DD-MM-YYYY HH:mm"
          :min-date="minDateEnd"
          no-header
          no-shortcuts
          output-format="YYYY-MM-DDTHH:mm"
        ></vue-date-picker>
      </div>
      <div class="two">
        <input
          class="location-field"
          type="text"
          v-model="location"
          placeholder="Location"
        />
        <div class="wrapper">
          <input
            class="guests-num-field one"
            type="number"
            v-model="guestsNum"
            placeholder="Guests Num"
          />
          <button class="search-button two" type="submit">Search</button>
        </div>
      </div>
    </form>
    <div class="slider-container">
      <b-row>
        <b-col><h4 id="filterh4">Filters</h4></b-col>
      <b-col>
        <button class="reset-button" type="reset" @click="resetFilter">
        Reset
      </button>
      </b-col>
      </b-row>
      <b-row>
      <div class="slider">
        Price per hour:
        <Slider
          v-model="priceValues"
          @update="priceFilterChanged"
          :format="format"
          :max="1000"
          :step="10"
        />
      </div>
      </b-row>
    </div>
  </div>
</template>

<script>
import { searchBoats } from "../../api";
import Slider from "@vueform/slider/dist/slider.vue2.js";
export default {
  name: "SearchBoats",
  components: {
    Slider,
  },
  data() {
    return {
      location: "",
      guestsNum: 1,
      startDate: null,
      endDate: null,
      currentDate: new Date(),
      priceValues: [0, 1000],
      format: function (value) {
        return `€${value}`;
      },
      errors: "",
    };
  },
  methods: {
    async submitSearch() {
      if (this.startDate && this.endDate) {
        this.errors = "";
         this.$emit("searchSubmitted");
        this.callSearch();
      }

      if (!this.startDate || !this.endDate) {
        this.errors = "Dates required.";
      }
    },
    async callSearch() {
      var bsa = new Date(this.startDate).toISOString().split(".")[0].split("T");
      this.beginning = bsa[0] + " " + bsa[1];
      bsa = new Date(this.endDate).toISOString().split(".")[0].split("T");
      this.ending = bsa[0] + " " + bsa[1];
      await searchBoats({
        location: this.location,
        guestsNum: this.guestsNum,
        dateTime: this.beginning,
        endTime: this.ending,
      }).then((response) => {
        this.$store.commit("boats/setBoats", response);
      });
    },
    priceFilterChanged() {
       this.$emit("searchSubmitted");
      this.$store.commit("boats/filterPriceBoats", this.priceValues);
    },
    resetFilter() {
      this.$store.commit("boats/resetFilter");
      this.priceValues = [0, 1000];
    },
  },
  computed: {
    minDateStart() {
      var minDate = new Date(this.currentDate);
      minDate.setHours(minDate.getHours() + 2);
      return minDate.toISOString();
    },
    minDateEnd() {
      var minDate = new Date(this.startDate);
      minDate.setHours(minDate.getHours() + 1);
      return minDate.toISOString();
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
}
#filterh4 {
  background: url("~@/assets/filter.png") no-repeat;
  text-align: center;
}
.slider {
  width: 150px;
  height: 20%;
  position: relative;
  float: left;
  text-align: center;
  margin-top: 20px;
}
.guests-num-field {
  background: url("~@/assets/person.png") no-repeat;
  height: auto;
  width: auto;
  margin-top: 15px;
  color: #a4a3a3;
  border: 1px solid #ccc;
  border-radius: 5px;
  text-align: right;
  padding: 5px;
}
.location-field {
  background: url("~@/assets/location.png") no-repeat 2px 2px;
  height: auto;
  width: auto;
  margin-left: 0px;
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
  width: 80%;
  height: auto;
  position: relative;
  float: left;
  border-radius: 5px;
  text-align: center;
}

.wrapper {
  display: grid;
  gap: 10px;
}
.one {
  width: auto;
  height: auto;
  grid-column: 1 / 2;
  grid-row: 1;
}
.two {
  grid-column: 2 / 2;
  grid-row: 1;
}
.error {
  color: red;
  padding: 0px;
  margin-bottom: 0px;
  margin-left: 30px;
}
</style>

