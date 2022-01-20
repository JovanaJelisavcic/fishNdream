import Vue from 'vue'
import VueRouter from 'vue-router'
import store from "../store"
import Homepage from "../views/homepage/Homepage.vue"
import HomepageFisher from "../views/homepage/HomepageFisher.vue"
import HomepageAdmin from "../views/homepage/HomepageAdmin.vue"
import HomepageOwner from "../views/homepage/HomepageOwner.vue"
import NotFoundComponent from "../views/NotFoundComponent.vue"
import MyProfile from "../views/fisherman/MyProfile"
import Explore from "../views/fisherman/Explore"
import FileComplaint from "../views/fisherman/FileComplaint.vue"
import MyReservations from "../views/fisherman/MyReservations"
import Subscriptions from "../views/fisherman/Subscriptions"
import CottagesFisher from "../components/Fisherman/Cottages/CottagesFisher.vue"
import BoatsFisher from "../components/Fisherman/Boats/BoatsFisher.vue"
import AdventuresFisher from "../components/Fisherman/Adventures/AdventuresFisher.vue"
import Cottages from "../components/Cottages/Cottages.vue"
import Boats from "../components/Boats/Boats"
import Instructors from "../components/Adventures/Instructors"
import AdminRequests from "../views/admin/AdminRequests.vue";
import AdminSettings from "../views/admin/AdminSettings.vue";
import AdminRegistration from "../views/admin/AdminRegistration.vue";
import AdminEntityOverview from "../views/admin/AdminEntityOverview.vue";
import AdminReports from "../views/admin/AdminReports.vue";
import AdminComplaints from "../views/admin/AdminComplaints.vue";
import ChangePassword from "../components/Admin/ChangePassword.vue";
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
  {
    path: "/changePass",
    name: "ChangePassword",
    component: ChangePassword,
    meta: {
      requiresAuth: true,
      adminAuth: true,
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
  let first = localStorage.getItem('first');
  if(to.path=="/" && role=="FISHERMAN"){
    router.push({path: '/fisher/explore'});
  }
  if(to.path=="/" && role=="SYS_ADMIN" && first=="false"){
    router.push({path: '/admin'});
  }else if((to.path=="/" || to.path=="/admin" )&& role=="SYS_ADMIN" && first=="true"){
    router.push({path: '/changePass'});
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

