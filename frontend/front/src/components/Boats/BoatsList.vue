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
import { isSubscribedBoat, getActionsBoat, isStillFreeBoat } from "../../api";
export default {
  name: "BoatsList",
  components: {
    BoatItem,
  },
  computed: {
    boats: {
      ...mapGetters("boats", { get: "getFilteredBoats" }),
    },
    beginDate: {
      ...mapGetters("boats", { get: "getBeginDate" }),
    },
    endDate: {
      ...mapGetters("boats", { get: "getEndDate" }),
    },
  },
  methods: {
    async onBoatSelect(boat) {
      if (localStorage.getItem("role") == "FISHERMAN") {
        let isit = await isSubscribedBoat(boat.boatId);
        this.$store.commit("boats/setIsSubscribed", isit);

        if (this.beginDate != null) {
          let b = await isStillFreeBoat(
            boat.boatId,
            this.beginDate,
            this.endDate
          );
          this.$store.commit("boats/setIsReservable", b);
        }
        let actions = null;
        try {
          actions = await getActionsBoat(boat.boatId);
        } catch {
          actions = null;
        }
        this.$store.commit("boats/setActionsRes", actions);
      }

      this.$emit("boatSelect", boat);
    },
  },
};
</script>
