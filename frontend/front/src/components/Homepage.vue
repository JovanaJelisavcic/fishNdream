<template>
  <div>
    <h1><img src="@/assets/logo.png" />fishNdream</h1>
    <div class="ui secondary pointing menu">
      <div>
        <b-tabs content-class="mt-3">
          <b-tab title="Cottages" active
            ><p><Cottages /></p
          ></b-tab>
          <b-tab title="Boats"
            ><p><Boats /></p
          ></b-tab>
          <b-tab title="Instructors"
            ><p><Instructors /></p
          ></b-tab>
        </b-tabs>
      </div>
      <div class="right menu">
      <a @click="goLogin" class="ui item"> Login </a>
    </div>
    </div>
  </div>
</template>

<script>
import Cottages from "../views/Cottages.vue";
import Boats from "../views/Boats.vue";
import Instructors from "../views/Instructors.vue";
export default {
  name: "Homepage",
  methods: {
    goLogin() {
      this.$router.push("/login");
    },
  },
  components: {
    Cottages,
    Boats,
    Instructors,
  },
};
</script>