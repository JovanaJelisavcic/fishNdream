import Vue from 'vue' 
import VueRouter from 'vue-router'
import store from "../store";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Homepage",
    component: require("../components/Homepage.vue").default,
    meta: {
    },
  },
  {
    path: "/login",
    name: "Login",
    component: require("../views/Login.vue").default,
    meta: {},
  },{
    path: "/cottages",
    name: "Cottages",
    component: require("../views/Cottages.vue").default,
    meta: {},
  },{
    path: "/boats",
    name: "Boats",
    component: require("../views/Boats.vue").default,
    meta: {},
  },{
    path: "/instructors",
    name: "Instructors",
    component: require("../views/Instructors.vue").default,
    meta: {},
  }
];

store.commit("login/fillState");

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
