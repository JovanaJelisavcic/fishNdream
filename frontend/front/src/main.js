import Vue from 'vue';
import App from './App';
import store from './store';
import router from './router';
import axios from "./config/axios";

Vue.prototype.$http = axios;
Vue.config.productionTip = false;

new Vue({
    store,
    router,
    render: h => h(App),
    components: {
        App
    }
}).$mount("#app");



const token = localStorage.getItem("token");
if (token) {
  const usr = localStorage.getItem("username");
  store.commit("login/setUsername", usr);
  if (usr) store.commit("login/setisRegisteredUser", true);
  store.commit("login/setToken", token);
}