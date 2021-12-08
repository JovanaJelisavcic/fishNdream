import Vue from 'vue/dist/vue.js';
import App from './App';
import store from './store';


new Vue({
    el: '#app',
    store,
    render: h => h(App),
    components: {
        App
    }
})



const token = localStorage.getItem("token");
if (token) {
  const usr = localStorage.getItem("username");
  store.commit("login/setUsername", usr);
  if (usr) store.commit("login/setisRegisteredUser", true);
  store.commit("login/setToken", token);
}