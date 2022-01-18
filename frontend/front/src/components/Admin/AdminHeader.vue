<template>
  <div>
    <b-navbar
      toggleable="lg"
      class="p-3"
      style="
        background-color: rgb(140, 85, 170);
        height: 80px;
        max-height: 80px;
      "
    >
      <h1><img src="@/assets/logo.png" />fishNdream</h1>

      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav>
          <b-nav-item>
            <router-link
              to="/admin/requests"
              class="admin-header-item"
              active-class="admin-header-item-active"
              exact-active-class="admin-header-item-active"
            >
              <span class="text-black">Requests</span>
            </router-link>
          </b-nav-item>
          <b-nav-item v-if="superAdmin == 'true'">
            <router-link
              to="/admin/admin-registration"
              class="admin-header-item"
              active-class="admin-header-item-active"
              exact-active-class="admin-header-item-active"
            >
              <span class="text-black">Admin registration</span>
            </router-link></b-nav-item
          >
          <b-nav-item>
            <router-link
              to="/admin/entity-overview"
              class="admin-header-item"
              active-class="admin-header-item-active"
              exact-active-class="admin-header-item-active"
            >
              <span class="text-black">Entity overview</span>
            </router-link></b-nav-item
          >
          <b-nav-item>
            <router-link
              to="/admin/reports"
              class="admin-header-item"
              active-class="admin-header-item-active"
              exact-active-class="admin-header-item-active"
            >
              <span class="text-black">Reports</span>
            </router-link></b-nav-item
          >
          <b-nav-item>
            <router-link
              to="/admin/complaints"
              class="admin-header-item"
              active-class="admin-header-item-active"
              exact-active-class="admin-header-item-active"
            >
              <span class="text-black">Complaints</span>
            </router-link></b-nav-item
          >
        </b-navbar-nav>

        <b-navbar-nav class="ml-auto">
          <b-nav-item-dropdown menu-class="admin-header-item" right>
            <template #button-content> Options </template>
            <b-dropdown-item>
              <router-link
                to="/admin/settings"
                class="admin-header-sub-item"
                active-class="admin-header-sub-item-active"
                exact-active-class="admin-header-sub-item-active"
              >
                <span class="">Settings</span>
              </router-link></b-dropdown-item
            >
            <b-dropdown-item @click="logout()">Logout</b-dropdown-item>
          </b-nav-item-dropdown>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
  </div>
</template>

<script>
import {getAllReportsForAdmin} from "../../api"
export default {
  data() {
    return {
      superAdmin: null,
    };
  },
  methods: {
    logout() {
      this.$store.dispatch("login/logout");
      this.$router.push("/");
    },
  },
 async mounted() {
    await getAllReportsForAdmin()
        .then(() => {
        });
      const path = `/admin/requests`;
    if (this.$route.path !== path) {
      this.$router.push("/admin/requests");
    }
    this.superAdmin = localStorage.getItem("isSuperAdmin");
  },
};
</script>

<style>
.navbar-collapse {
  padding: 1rem;
  background-color: rgb(140, 85, 170);
  color: black !important;
  font-weight: 500;
}
.navbar-light .navbar-nav .nav-link {
  color: black !important;
  font-weight: 500;
}
.admin-header-item {
  color: black;
  text-decoration: none;
  font-weight: 500;
}
.admin-header-item-active {
  color: black;
  text-decoration: underline;
}
.admin-header-sub-item {
  color: black;
  text-decoration: none;
}
.admin-header-sub-item-active {
  color: black;
  text-decoration: underline;
}
.admin-header-item:hover {
  background-color: #c19fd4;
  border-radius: 0.2rem;
  box-shadow: 1px 1px #d9c3e5;
}
</style>
