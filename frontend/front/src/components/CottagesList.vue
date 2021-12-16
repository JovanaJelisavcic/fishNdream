<template>
  <ul class="list-group">
    <CottageItem
      v-for="(cottage, cottageId) in cottages"
      :key="cottageId"
      :cottage="cottage"
    ></CottageItem>
  </ul>
</template>

<script>
import { mapGetters } from "vuex";
import { allCottages } from "../api";
import CottageItem from "./CottageItem.vue";
export default {
  name: "CottagesList",
  components: {
    CottageItem,
  },
  computed: {
    cottages: {
      ...mapGetters("cottages", { get: "getFilteredCottages" })
    }
  },
  async mounted() {
    const response = await allCottages();
    this.$store.commit("cottages/setCottages", response);
  }
};
</script>
