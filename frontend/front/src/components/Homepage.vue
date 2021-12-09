<template>
  <div>
    <h1><img src="@/assets/logo.png" />fishNdream</h1>
    <div class="ui secondary pointing menu">
      <div>
        <router-link to="/cottages">Cottages</router-link>
        <router-link to="/boats">Boats</router-link>
        <router-link to="/instructors">Instructors</router-link>
      </div>
      <div class="right menu">
        <a @click="goLogin" class="ui item"> Login </a>
      </div>
    </div>
    <div class="ui segment">
      <router-view />
    </div>
  </div>
</template>

<script>
export default {
  name: "Homepage",
  methods: {
    goLogin() {
      this.$router.push("/login");
    },
  },
};
</script>