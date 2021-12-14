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
  </div>
</template>

<script>
import { searchCottages } from "../api";
export default {
  name: "SearchCottages",
  data() {
    return {
      location: "",
      guestsNum: 0,
      beginning: null,
      ending: null,
      date: new Date(),
      currentDate: new Date(),
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
  },
  computed: {
    minDate() {
      return new Date().toISOString().split("T")[0];
    },
  },
};
</script>