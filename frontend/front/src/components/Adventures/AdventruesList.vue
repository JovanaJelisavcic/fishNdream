<template>
  <ul class="list-group col-md-4">
    <AdventureItem
      v-for="(adventure, adventureId) in adventures"
      :key="adventureId"
      :adventure="adventure"
      @adventureSelect="onAdventureSelect"
    ></AdventureItem>
  </ul>
</template>

<script>
import { mapGetters } from "vuex";
import AdventureItem from "../Adventures/AdventureItem.vue";
import {
  isSubscribedInstructor,
  getActionsAdventure,
  isStillFreeAdventure,
  getAdventurePrice,
} from "../../api";
export default {
  name: "AdventuresList",
  components: {
    AdventureItem,
  },
  computed: {
    adventures: {
      ...mapGetters("adventures", { get: "getFilteredAdventures" }),
    },
    beginDate: {
      ...mapGetters("adventures", { get: "getBeginDate" }),
    },
    endDate: {
      ...mapGetters("adventures", { get: "getEndDate" }),
    },
  },
  methods: {
    async onAdventureSelect(adventure) {
      if (localStorage.getItem("role") == "FISHERMAN") {
        let isit = await isSubscribedInstructor(adventure.instructor.email);
        this.$store.commit("adventures/setIsSubscribed", isit);

        if (this.beginDate != null) {
          let b = await isStillFreeAdventure(
            adventure.adventureId,
            this.beginDate,
            this.endDate
          );
          this.$store.commit("adventures/setIsReservable", b);

          var bsa = this.beginDate.split("T");
          var beginning = bsa[0] + " " + bsa[1] + ":00";
          bsa = this.endDate.split("T");
          var ending = bsa[0] + " " + bsa[1] + ":00";
          let pr = await getAdventurePrice({
            id: adventure.adventureId,
            begin: beginning,
            end: ending,
          });
          this.$store.commit("adventures/setReservePrice", pr);
        } else this.$store.commit("adventures/setIsReservable", false);

        let actions = null;
        try {
          actions = await getActionsAdventure(adventure.adventureId);
        } catch {
          actions = null;
        }
        this.$store.commit("adventures/setActionsRes", actions);
      }
      this.$emit("adventureSelect", adventure);
    },
  },
};
</script>
