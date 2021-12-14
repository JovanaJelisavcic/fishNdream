<template>
  <ul class="list-group">
    <CottageItem
     v-for="(cottage, cottageId) in cottages"
      :key="cottageId"
      :cottage="cottage"></CottageItem>
  </ul>
</template>

<script>
import { mapGetters } from "vuex";
import CottageItem from "./CottageItem.vue";
export default {
  name: "CottagesList",
  components: {
    CottageItem,
  },
  computed: {
    cottages: {
      ...mapGetters("cottages", { get: "getCottages" }),
    },
  },
};
</script>
