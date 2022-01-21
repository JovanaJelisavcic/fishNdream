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
import { isSubscribedBoat, getActionsBoat, isStillFreeBoat, getBoatPrice} from "../../api";
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

           var bsa = this.beginDate.split("T");
          var beginning = bsa[0] + " " + bsa[1] + ":00";
          bsa = this.endDate.split("T");
          var ending = bsa[0] + " " + bsa[1] + ":00";
          let pr = await getBoatPrice({
            id: boat.boatId,
            begin: beginning,
            end: ending,
          });
          this.$store.commit("boats/setReservePrice", pr);
        }  else this.$store.commit("boats/setIsReservable", false);
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
