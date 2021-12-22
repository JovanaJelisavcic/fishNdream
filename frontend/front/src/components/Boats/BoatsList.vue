<template>
  <ul class="list-group col-md-4">
    <BoatItem
      v-for="(boat, boatId) in boats"
      :key="boatId"
      :boat="boat"
       @boatSelect="onBoatSelect"
    ></BoatItem>
  </ul>
</template>

<script>
import { mapGetters } from "vuex";
import BoatItem from "./BoatItem.vue";
export default {
  name: "BoatsList",
  components: {
    BoatItem,
  },
  computed: {
    boats: {
      ...mapGetters("boats", { get: "getFilteredBoats" }),
    },
  },
  methods: {
    onBoatSelect(boat) {
      this.$emit('boatSelect', boat);
    },
  }
};
</script>
