<template>
  <div>
    <b-row>
      <SearchCottages @searchSubmitted="onSearchSubmitted" />
    </b-row>
    <b-row>
      <CottagesList @cottageSelect="onCottageSelect" class="seconrow" />

      <CottageDetailFisher v-if="selectedCottage" :cottage="selectedCottage" />
    </b-row>
  </div>
</template>

<script>
import SearchCottages from "../../Cottages/SearchCottages.vue";
import CottagesList from "../../Cottages/CottagesList.vue";
import CottageDetailFisher from "./CottageDetailFisher.vue";
export default {
  name: "CottagesFisher",
  components: {
    SearchCottages,
    CottagesList,
    CottageDetailFisher,
  },
  data() {
    return {
      selectedCottage: null,
    };
  },
  methods: {
    onCottageSelect(cottage) {
      this.selectedCottage = cottage; 
    },
    onSearchSubmitted() {
      this.selectedCottage = null;
    },
  },
};
</script>

<style >
.seconrow {
  margin-top: 50px;
}
</style>