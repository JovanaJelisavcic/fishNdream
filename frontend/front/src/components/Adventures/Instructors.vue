<template>
  <div class="">
    <b-row><SearchAdventures @searchSubmitted="onSearchSubmitted" /></b-row>
    <b-row>
      <AdventuresList @adventureSelect="onAdventureSelect" class="seconrow" />
      <AdventureDetail :adventure="selectedAdventure" />
    </b-row>
  </div>
</template>


<script>
import SearchAdventures from "./SearchAdventures.vue";
import AdventuresList from "./AdventruesList.vue";
import AdventureDetail from "./AdventureDetail.vue"
export default {
  name: "Adventures",
  components: {
    SearchAdventures,
    AdventuresList,
    AdventureDetail
  },
  data() {
    return {
      selectedAdventure: null,
    };
  },
  methods: {
    onAdventureSelect(adventure) {
      this.selectedAdventure = adventure;
    },
    onSearchSubmitted() {
      this.selectedAdventure = null;
    },
  },
};
</script>

<style scoped>
.seconrow {
  margin-top: 50px;
}
</style>


