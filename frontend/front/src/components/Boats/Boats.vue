<template>
  <div class="">
    <b-row> <SearchBoats @searchSubmitted="onSearchSubmitted" /></b-row>
    <b-row>
      <BoatsList @boatSelect="onBoatSelect" class="seconrow" />
      <BoatDetail :boat="selectedBoat" />
    </b-row>
  </div>
</template>


<script>
import SearchBoats from "./SearchBoats.vue";
import BoatsList from "./BoatsList.vue";
import BoatDetail from "./BoatDetail.vue";
export default {
  name: "Boats",
  components: {
    SearchBoats,
    BoatsList,
    BoatDetail,
  },
  data() {
    return {
      selectedBoat: null,
    };
  },
  methods: {
    onBoatSelect(boat) {
      this.selectedBoat = boat;
    },
    onSearchSubmitted() {
      this.selectedBoat = null;
    },
  },
};
</script>


<style scoped>
.seconrow {
  margin-top: 50px;
}
</style>