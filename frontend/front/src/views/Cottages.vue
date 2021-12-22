<template>
  <div class="container">
    <b-row>
      <SearchCottages />
    </b-row>
      <b-row>
      <CottagesList @cottageSelect="onCottageSelect" class="seconrow" />
      <CottageDetail :cottage="selectedCottage"/>
    </b-row>
  </div>
</template>


<script>
import SearchCottages from "../components/SearchCottages.vue";
import CottagesList from "../components/CottagesList.vue";
import CottageDetail from "../components/CottageDetail.vue"
export default {
  name: "Cottages",
  components: {
    SearchCottages,
    CottagesList,
    CottageDetail
  },
  data() {
    return {
      selectedCottage: null
    };
  },
  methods:{
    onCottageSelect(cottage){
      this.selectedCottage=cottage;
    }
  }
};
</script>

<style scoped>
.seconrow {
  margin-top: 50px;
}
</style>