<template>
  <div>
    <div id="top"
      class="ui top secondary menu"
      style="background-color: rgb(140, 85, 170)"
    >
      <div class="header item">
        <router-link
          to="/fisher/explore/cottages"
          class="item"
          active-class="active"
          exact-active-class="active"
        >
          Cottages
        </router-link>
        <router-link
          to="/fisher/explore/boats"
          class="item"
          active-class="active"
          exact-active-class="active"
        >
          Boats
        </router-link>
        <router-link
          to="/fisher/explore/instructors"
          class="item"
          active-class="active"
          exact-active-class="active"
        >
          Instructors
        </router-link>
      </div>
    </div>
    <div class="content">
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
import { allCottagesFisher, allBoatsFisher, allAdventuresFisher } from "../../api";
export default {
  name: "Explore",
   async mounted() {
    const response = await allCottagesFisher();
    this.$store.commit("cottages/setCottages", response);
    const responseB = await allBoatsFisher();
    this.$store.commit("boats/setBoats", responseB);
    const responseA = await allAdventuresFisher();
    this.$store.commit("adventures/setAdventures", responseA);

    this.$store.commit("adventures/setBeginDate", null);
    this.$store.commit("cottages/setBeginDate", null);
    this.$store.commit("boats/setBeginDate", null);

    
    this.$store.commit("adventures/setEndDate", null);
    this.$store.commit("cottages/setEndDate", null);
    this.$store.commit("boats/setEndDate", null);
    
  },
};
</script>

<style scoped>
.macolor {
  background-color: rgb(140, 85, 170);
}

</style>