import Vue from "vue";
import VueRouter from "vue-router";
import App from "../App.vue";
import store from "../store";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "App",
    component: App,
    meta: {},
  },
  {
    path: "/login",
    name: "Login",
    component: require("../views/Login").default,
    meta: {},
  },
];

store.commit("login/fillState");

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
