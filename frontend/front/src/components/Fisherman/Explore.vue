<template>
  <div>
    <div id="top"
      class="ui top fixed secondary menu"
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
import { allCottages, allBoats, allAdventures } from "../../api";
export default {
  name: "Explore",
   async mounted() {
    const response = await allCottages();
    this.$store.commit("cottages/setCottages", response);
    const path = `fisher/explore/cottages`;
    if (this.$route.path !== path) this.$router.push("/fisher/explore/cottages");
    const responseB = await allBoats();
    this.$store.commit("boats/setBoats", responseB);
    const responseA = await allAdventures();
    this.$store.commit("adventures/setAdventures", responseA);
    
  },
};
</script>

<style scoped>
.content {
  height: calc(100%-150px);
  margin-top: 150px;
}
.macolor {
  background-color: rgb(140, 85, 170);
}
#top{
    margin-top: 90px;
}
</style>