<template>
  <ul class="list-group col-md-4">
    <CottageItem
      v-for="(cottage, cottageId) in cottages"
      :key="cottageId"
      :cottage="cottage"
      @cottageSelect="onCottageSelect"
    ></CottageItem>
  </ul>
</template>

<script>
import { mapGetters } from "vuex";
import CottageItem from "./CottageItem.vue";
import {
  isSubscribedCottage,
  getActionsCottage,
  isStillFreeCottage,
} from "../../api";
export default {
  name: "CottagesList",
  components: {
    CottageItem,
  },
  computed: {
    cottages: {
      ...mapGetters("cottages", { get: "getFilteredCottages" }),
    },
    beginDate: {
      ...mapGetters("cottages", { get: "getBeginDate" }),
    },
    endDate: {
      ...mapGetters("cottages", { get: "getEndDate" }),
    },
  },
  methods: {
    async onCottageSelect(cottage) {
      if (localStorage.getItem("role") == "FISHERMAN") {
        let isit = await isSubscribedCottage(cottage.cottageId);
        this.$store.commit("cottages/setIsSubscribed", isit);

        if (this.beginDate != null) {
          
          let b = await isStillFreeCottage(
            cottage.cottageId,
            this.beginDate,
            this.endDate
          );
          this.$store.commit("cottages/setIsReservable", b);
        }

        let actions = null;
        try {
          actions = await getActionsCottage(cottage.cottageId);
        } catch {
          actions = null;
        }
        this.$store.commit("cottages/setActionsRes", actions);
      }
      this.$emit("cottageSelect", cottage);
    },
  },
};
</script>


<style scoped>
</style>