<template>
  <div>
    <b-row><SearchAdventures @searchSubmitted="onSearchSubmitted" /></b-row>
    <b-row>
      <AdventuresList @adventureSelect="onAdventureSelect" class="seconrow" />
      <AdventureDetailFisher :adventure="selectedAdventure" />
    </b-row>
  </div>
</template>

<script>
import SearchAdventures from "../../Adventures/SearchAdventures.vue";
import AdventuresList from "../../Adventures/AdventruesList.vue";
import AdventureDetailFisher from "./AdventureDetailFisher.vue"
export default {
  name: "AdventuresFisher",
  components: {
    SearchAdventures,
    AdventuresList,
    AdventureDetailFisher
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