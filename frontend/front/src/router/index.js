import Vue from 'vue'
import VueRouter from 'vue-router'
import store from "../store"
import Homepage from "../components/Homepage.vue"
import HomepageFisher from "../components/HomepageFisher.vue"
import HomepageAdmin from "../components/HomepageAdmin.vue"
import HomepageOwner from "../components/HomepageOwner.vue"
import NotFoundComponent from "../components/NotFoundComponent.vue"
import Cottages from "../views/Cottages.vue"
import Boats from "../views/Boats.vue"
import Instructors from "../views/Instructors.vue"
Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Homepage",
    component: Homepage,
    meta: {
      requiresAuth: false,
      adminAuth: false,
      userAuth: false,
    },
    children: [
      {
        path: "cottages",
        name: "Cottages",
        component: Cottages
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
    meta: {
      requiresAuth: false,
      adminAuth: false,
      userAuth: false,
    },

  },
  {
    path: "/register",
    name: "Register",
    component: require("../views/Register.vue").default,
    meta: {
      requiresAuth: false,
      adminAuth: false,
      userAuth: false,
    },

  }, {
    path: "/fisher",
    name: "HomepageFisher",
    component: HomepageFisher,
    meta: {
      requiresAuth: true,
      adminAuth: false,
      userAuth: true,
    },
  }, {
    path: "/admin",
    name: "HomepageAdmin",
    component: HomepageAdmin,
    meta: {
      requiresAuth: true,
      adminAuth: true,
      userAuth: false,
    },
  }, {
    path: "/owner",
    name: "HomepageOwner",
    component: HomepageOwner,
    meta: {
      requiresAuth: true,
      adminAuth: false,
      userAuth: false,
    },
  }, {
    path: "/notfound",
    name: "NotFoundComponent",
    component: NotFoundComponent,
    meta: {
      requiresAuth: false,
      adminAuth: false,
      userAuth: false,
    },
  }
];

store.commit("login/fillState");

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});


router.beforeEach((to, from, next) => {
  let role = localStorage.getItem('role');
  let accessToken = localStorage.getItem('token');
  if (to.meta.requiresAuth) {
    if (!role || !accessToken) {
      router.push({ path: '/login' });
    } else {
      if (to.meta.adminAuth) {
        if (role === "SYS_ADMIN") {
          return next();
        } else {
          router.push({ path: '/notfound' });
        }
      } else if (to.meta.userAuth) {
        if (role === "FISHERMAN") {
          return next();
        } else {
          router.push({ path: '/notfound' });
        }
      } else if (!to.meta.userAuth && !to.meta.adminAuth) {
        if (role === "COTTAGE_OWNER" || role === "BOAT_OWNER" || role === "INSTRUCTOR") {
          return next();
        } else {
          router.push({ path: '/notfound' });
        }
      }
    }
  } else {
    return next();
  }

});


export default router;

