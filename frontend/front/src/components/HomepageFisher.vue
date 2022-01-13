<template>
  <div>
    <div
      class="ui top fixed secondary menu"
      style="background-color: rgb(140, 85, 170)"
    >
      <div class="header item">
        <h1><img src="@/assets/logo.png" />fishNdream</h1>

        <router-link
          to="/fisher/explore"
          class="item"
          active-class="active"
          exact-active-class="active"
        >
          Explore
        </router-link>
        <router-link
          to="/fisher/myreservations"
          class="item"
          active-class="active"
          exact-active-class="active"
        >
          My Reservations
        </router-link>
        <router-link
          to="/fisher/subscriptions"
          class="item"
          active-class="active"
          exact-active-class="active"
        >
          Subscriptions
        </router-link>
        <router-link
          to="/fisher/complaint"
          class="item"
          active-class="active"
          exact-active-class="active"
        >
          File Complaint
        </router-link>
      </div>
      <div class="right menu">
        <div class="item">
          <div class="ui primary button" @click="goMyProfile">My Profile</div>
        </div>
        <div class="item">
          <a @click="goLogout" class="ui button"> Logout </a>
        </div>
      </div>
    </div>
    <div class="content">
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
export default {
  name: "HomepageFisher",
  methods: {
    goMyProfile() {
      this.$router.push("/fisher/myprofile");
    },
    goLogout() {
      this.$store.dispatch("login/logout");
      this.$router.push("/");
    },
  },
  async mounted() {
    const path = `/fisher/explore/cottages`;
    if (this.$route.path !== path) {
      this.$router.push("/fisher/explore/cottages");
    }
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