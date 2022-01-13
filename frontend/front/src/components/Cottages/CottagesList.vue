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
import { isSubscribedCottage } from "../../api";
export default {
  name: "CottagesList",
  components: {
    CottageItem,
  },
  computed: {
    cottages: {
      ...mapGetters("cottages", { get: "getFilteredCottages" }),
    },
  },
  methods: {
    async onCottageSelect(cottage) {
      let isit = await isSubscribedCottage(cottage.cottageId);
      this.$store.commit("cottages/setIsSubscribed", isit);

      this.$emit("cottageSelect", cottage);
    },
  },
};
</script>


<style scoped>
</style>