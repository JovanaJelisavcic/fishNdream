<template>
  <ul class="ui items">
    <AdventureItem
      v-for="(adventure, adventureId) in adventures"
      :key="adventureId"
      :adventure="adventure"
    ></AdventureItem>
  </ul>
</template>

<script>
import { mapGetters } from "vuex";
import AdventureItem from "./AdventureItem.vue";
export default {
  name: "AdventuresList",
  components: {
    AdventureItem,
  },
  computed: {
    adventures: {
      ...mapGetters("adventures", { get: "getFilteredAdventures" }),
    },
  },
};
</script>
