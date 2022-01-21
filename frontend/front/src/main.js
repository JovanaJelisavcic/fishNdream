import "bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import Vue from 'vue';
import App from './App';
import store from './store';
import router from './router';
import axios from "./config/axios";
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import VueCtkDateTimePicker from 'vue-ctk-date-time-picker';
import "vue-ctk-date-time-picker/dist/vue-ctk-date-time-picker.css";
import VueCompositionAPI from '@vue/composition-api'
import SimpleVueValidation from 'simple-vue-validator';
import VueCal from 'vue-cal'
import 'vue-cal/dist/vuecal.css'



Vue.prototype.$http = axios;
Vue.config.productionTip = false;

Vue.use(VueCompositionAPI);
Vue.use(BootstrapVue);
Vue.use(IconsPlugin);
Vue.use(SimpleVueValidation);
Vue.component('vue-cal',VueCal);
Vue.component('vue-date-picker',VueCtkDateTimePicker);

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