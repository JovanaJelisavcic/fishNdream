<template>
  <div>
    <form @submit.prevent="submitSearch">
      <input type="text" v-model="location" placeholder="Location" />

      <DatePicker v-model="beginning" />
      <DatePicker v-model="ending" />
      <input type="number" v-model="guestsNum" placeholder="Guests Num" />
      <button type="submit">Search</button>
    </form>
  </div>
</template>

<script>
import DatePicker from "./DatePicker.vue";
import { searchCottages } from "../api";
export default {
  name: "SearchCottages",
   data() {
    return {
       location: '', guestsNum: '', beginning: '', ending: '' 
    };
  },
  components: {
    DatePicker,
  },
  methods: {
    async submitSearch() {
      const response = await searchCottages({
        location: this.location,
        guestsNum: this.guestNum,
        dateTime: this.beginning,
        endTime: this.ending
      });
      console.log(response);
    },
  },
};
</script>