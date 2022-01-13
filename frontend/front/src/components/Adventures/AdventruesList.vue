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
import { isSubscribedInstructor } from "../../api";
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
    async onAdventureSelect(adventure) {
       let isit = await isSubscribedInstructor(adventure.instructor.email);
      this.$store.commit("adventures/setIsSubscribed", isit);

      this.$emit('adventureSelect', adventure);
    },
  }
};
</script>
