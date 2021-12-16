import Vue from 'vue'
import VueRouter from 'vue-router'
import store from "../store"
import Homepage from "../components/Homepage.vue"
import Cottages from "../views/Cottages.vue"
import Boats from "../views/Boats.vue"
import Instructors from "../views/Instructors.vue"
Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Homepage",
    component: Homepage,
    children: [
      {
        path: "cottages",
        name: "Cottages",
        component:  Cottages
      }, {
        path: "boats",
        name: "Boats",
        component: Boats
      }, {
        path: "instructors",
        name: "Instructors",
        component: Instructors
      }
    ]
  },
  {
    path: "/login",
    name: "Login",
    component: require("../views/Login.vue").default,

  }
];

store.commit("login/fillState");

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
