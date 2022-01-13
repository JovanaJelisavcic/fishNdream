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
import { isSubscribedBoat } from "../../api";
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
    async onBoatSelect(boat) {
      let isit = await isSubscribedBoat(boat.boatId);
      this.$store.commit("boats/setIsSubscribed", isit);
     
     
     this.$emit("boatSelect", boat);
    },
  },
};
</script>
