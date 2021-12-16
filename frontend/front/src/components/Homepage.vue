<template>
<div>
  <div class="ui top fixed secondary menu">
    <div class="header item">
      <h1><img src="@/assets/logo.png" />fishNdream</h1>
    </div>
    <router-link to="/cottages" class="item"> Cottages </router-link>
    <router-link to="/boats" class="item"> Boats </router-link>
    <router-link to="/instructors" class="item"> Instructors </router-link>
    <div class="right menu">
       <div class="item">
    <div class="ui primary button">Sign up</div>
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
  <!-- <div>
        <b-tabs content-class="mt-3">
          <b-tab class="item" title="Cottages" active
            ><p><Cottages /></p
          ></b-tab>
          <b-tab class="item" title="Boats"
            ><p><Boats /></p
          ></b-tab>
          <b-tab class="item" title="Instructors"
            ><p><Instructors /></p
          ></b-tab>
        </b-tabs>
      </div>





      <div class="right menu">
      <a @click="goLogin" class="ui item"> Login </a>
    </div>
    </div>-->
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

<style scoped>
.content {
  height: calc(100%-150px);
  margin-top:150px
}
</style>