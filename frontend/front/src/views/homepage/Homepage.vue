<template>
  <div>
    <div
      class="ui top fixed secondary menu"
      style="background-color: rgb(140, 85, 170)"
    >
      <div class="header item">
        <h1><img src="@/assets/logo.png" />fishNdream</h1>

        <router-link
          to="/cottages"
          class="item"
          active-class="active"
          exact-active-class="active"
        >
          Cottages
        </router-link>
        <router-link
          to="/boats"
          class="item"
          active-class="active"
          exact-active-class="active"
        >
          Boats
        </router-link>
        <router-link
          to="/instructors"
          class="item"
          active-class="active"
          exact-active-class="active"
        >
          Instructors
        </router-link>
      </div>
      <div class="right menu">
        <div class="item">
          <div class="ui primary button" @click="goRegister">Sign up</div>
        </div>
        <div class="item">
          <a @click="goLogin" class="ui button"> Login </a>
        </div>
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
  name: "Homepage",
  methods: {
    goLogin() {
      this.$router.push("/login");
    },
    goRegister() {
      this.$router.push("/register");
    }
  },
  async mounted() {
    const response = await allCottages();
    this.$store.commit("cottages/setCottages", response);
    const path = `/cottages`;
    if (this.$route.path !== path) this.$router.push("/cottages");
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
</style>