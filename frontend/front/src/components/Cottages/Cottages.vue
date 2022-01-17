<template>
  <div class="">
    <b-row>
      <SearchCottages @searchSubmitted="onSearchSubmitted" />
    </b-row>
    <b-row>
      <CottagesList @cottageSelect="onCottageSelect" class="seconrow" />

      <CottageDetail
        :cottage="selectedCottage"
      />
    </b-row>
  </div>
</template>


<script>
import SearchCottages from "./SearchCottages.vue";
import CottagesList from "./CottagesList.vue";
import CottageDetail from "./CottageDetail.vue";
export default {
  name: "Cottages",
  components: {
    SearchCottages,
    CottagesList,
    CottageDetail,
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