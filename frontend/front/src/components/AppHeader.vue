<template>
  <div>
    <h1><img src="@/assets/logo.png" />fishNdream</h1>
    <div class="ui secondary pointing menu">
      <a class="item"> Cottages </a>
      <a class="item"> Boats </a>
      <a class="item active"> Instructors </a>
      <div class="right menu">
        <a @click="goLogin" class="ui item"> Login </a>
      </div>
    </div>
    <div class="ui segment">
      <p> <Login></Login></p>
    </div>
  </div>
</template>

<script>
import Login from "../views/Login";
export default {
  
  name: "AppHeader",
   methods: {
    goLogin() {
        this.$router.push("/login");
      }
    },
  components: {
    Login
  }
};
</script>