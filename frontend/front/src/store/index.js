import Vuex from 'vuex';
import Vue from 'vue';
import login from './login'
import cottages from './cottages'
import boats from './boats'

Vue.use(Vuex);


export default new Vuex.Store({
  state: {},
  mutations: {},
  actions: {},
  modules: {
        login,
        cottages,
        boats
    }
});