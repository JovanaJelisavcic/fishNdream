<template>
  <ul class="list-group  col-md-4">
    <AdventureItem
      v-for="(adventure, adventureId) in adventures"
      :key="adventureId"
      :adventure="adventure"
        @adventureSelect="onAdventureSelect"
    ></AdventureItem>
  </ul>
</template>

<script>
import { mapGetters } from "vuex";
import AdventureItem from "../Adventures/AdventureItem.vue";
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
  methods: {
    onAdventureSelect(adventure) {
      this.$emit('adventureSelect', adventure);
    },
  }
};
</script>
