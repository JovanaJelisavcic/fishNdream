<template>
   <div>
    <b-row> <SearchBoats @searchSubmitted="onSearchSubmitted" /></b-row>
    <b-row>
      <BoatsList @boatSelect="onBoatSelect" class="seconrow" />
      <BoatDetailFisher v-if="selectedBoat" :boat="selectedBoat" />
    </b-row>
  </div>
</template>

<script>
import SearchBoats from "../../Boats/SearchBoats.vue";
import BoatsList from "../../Boats/BoatsList.vue";
import BoatDetailFisher from "./BoatDetailFisher.vue";
export default {
    name: "BoatsFisher",
    components: {
    SearchBoats,
    BoatsList,
    BoatDetailFisher,
  },
  data() {
    return {
      selectedBoat: null,
    };
  },
  methods: {
    async onBoatSelect(boat) {
      this.selectedBoat = boat;
    },
    onSearchSubmitted() {
      this.selectedBoat = null;
    },
  },
}
</script>

<style scoped>
.seconrow {
  margin-top: 50px;
}
</style>