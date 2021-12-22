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
    onCottageSelect(cottage) {
      this.$emit('cottageSelect', cottage);
    },
  },
};
</script>


<style scoped>
</style>