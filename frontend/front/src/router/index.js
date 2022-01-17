import Vue from 'vue'
import VueRouter from 'vue-router'
import store from "../store"
import Homepage from "../components/Homepage.vue"
import HomepageFisher from "../components/HomepageFisher.vue"
import HomepageAdmin from "../views/admin/HomepageAdmin.vue"
import HomepageOwner from "../components/HomepageOwner.vue"
import NotFoundComponent from "../components/NotFoundComponent.vue"
import MyProfile from "../components/Fisherman/MyProfile.vue"
import Explore from "../components/Fisherman/Explore.vue"
import FileComplaint from "../components/Fisherman/FileComplaint.vue"
import MyReservations from "../components/Fisherman/MyReservations.vue"
import Subscriptions from "../components/Fisherman/Subscriptions.vue"
import CottagesFisher from "../components/Fisherman/Cottages/CottagesFisher.vue"
import BoatsFisher from "../components/Fisherman/Boats/BoatsFisher.vue"
import AdventuresFisher from "../components/Fisherman/Adventures/AdventuresFisher.vue"
import Cottages from "../views/Cottages.vue"
import Boats from "../views/Boats.vue"
import Instructors from "../views/Instructors.vue"
import AdminRequests from "../views/admin/AdminRequests.vue";
import AdminSettings from "../views/admin/AdminSettings.vue";
import AdminRegistration from "../views/admin/AdminRegistration.vue";
import AdminEntityOverview from "../views/admin/AdminEntityOverview.vue";
import AdminReports from "../views/admin/AdminReports.vue";
import AdminComplaints from "../views/admin/AdminComplaints.vue";
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
    children: [
      {
        path: "explore",
        name: "Explore",
        component: Explore,
        children: [
          {
            path: "cottages",
            name: "CottagesFisher",
            component: CottagesFisher
          }, {
            path: "boats",
            name:"BoatsFisher",
            component: BoatsFisher
          }, {
            path: "instructors",
            name: "AdventuresFisher",
            component: AdventuresFisher
          }
        ]
      }, {
        path: "complaint",
        name: "FileComplaint",
        component: FileComplaint
      }, {
        path: "myreservations",
        name: "MyReservations",
        component: MyReservations
      }, {
        path: "subscriptions",
        name: "Subscriptions",
        component: Subscriptions
      }
    ]
  }, {
    path: "/fisher/myprofile",
    name: "MyProfile",
    component: MyProfile,
    meta: {
      requiresAuth: true,
      adminAuth: false,
      userAuth: true,
    }
  },
  {
    path: "/admin",
    name: "HomepageAdmin",
    component: HomepageAdmin,
    meta: {
      requiresAuth: true,
      adminAuth: true,
      userAuth: false,
    },
    children: [
      {
        path: "/admin/requests",
        name: "adminRequests",
        component: AdminRequests,
        meta: {
          requiresAuth: true,
          adminAuth: true,
          userAuth: false,
        },
      },
      {
        path: "/admin/settings",
        name: "adminSettings",
        component: AdminSettings,
        meta: {
          requiresAuth: true,
          adminAuth: true,
          userAuth: false,
        },
      },
      {
        path: "/admin/admin-registration",
        name: "adminRegistration",
        component: AdminRegistration,
        meta: {
          requiresAuth: true,
          adminAuth: true,
          userAuth: false,
        },
      },
      {
        path: "/admin/entity-overview",
        name: "adminEntityOverview",
        component: AdminEntityOverview,
        meta: {
          requiresAuth: true,
          adminAuth: true,
          userAuth: false,
        },
      },
      {
        path: "/admin/reports",
        name: "adminReport",
        component: AdminReports,
        meta: {
          requiresAuth: true,
          adminAuth: true,
          userAuth: false,
        },
      },
      {
        path: "/admin/complaints",
        name: "adminComplaints",
        component: AdminComplaints,
        meta: {
          requiresAuth: true,
          adminAuth: true,
          userAuth: false,
        },
      },
    ],
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
  },
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
  if(to.path=="/" && role=="FISHERMAN"){
    router.push({path: '/fisher/explore'});
  }
  if(to.path=="/" && role=="SYS_ADMIN"){
    router.push({path: '/admin'});
  }
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

