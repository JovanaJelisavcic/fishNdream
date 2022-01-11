import axios from "../config/axios";
import { login } from "../api";
export default {
  namespaced: true,
  state: {
    email: null,
    first_name: null,
    last_name: null,
    username: null,
    password: null,
    token: null,
    status: null,
    isRegisteredUser: false,
    role: null
  },
  mutations: {
    setisRegisteredUser(state, value) {
      state.isRegisteredUser = value;
    }, setRole(state, value) {
      state.role = value;
    },
    setUsername(state, value) {
      state.username = value;
    },
    setToken(state, data) {
      state.token = data;
    },
    firstLogin(state) {
      state.status = "FIRST_LOGIN";
    },
    loginSuccess(state, data) {
      const { token, username, role } = data;
      state.username = username;
      state.token = token;
      state.role = role;
      localStorage.setItem("token", state.token);
      localStorage.setItem("username", state.username);
      localStorage.setItem("role", state.role);
      axios.defaults.headers.common["Authorization"] = `Bearer ${state.token}`;
      state.isRegisteredUser = true;
    },
    fillState(state) {
      state.token = localStorage.getItem("token");
      if (state.token) state.isRegisteredUser = true;
    },
    loginFailed(state) {
      state.status = "FAILED";
    },
    clearToken(state) {
      localStorage.removeItem("token");
      localStorage.removeItem("username");
      localStorage.removeItem("role");
      state.isRegisteredUser = false;
      state.username = null;
      state.token = null;
      state.role=null;
    },
    resetStatus(state) {
      state.status = null;
    },
  },
  actions: {
    async login({ commit }, { email, password }) {
      if (axios.defaults) {
        delete axios.defaults.headers.common["Authorization"];
      }
      try {
        const response = await login({
          username: email,
          password: password,
        });
        if (response) {
          if (response.accessToken) {
            commit("loginSuccess", {
              token: response.accessToken ? response.accessToken : null,
              username: email, role: response.roles[0]
            });
            return true;
          }
        }
      } catch (e) {
        commit("loginFailed");
        return false;
      }
      return false;
    },
    async logout({ commit }) {
      commit("resetStatus");
      commit("clearToken");
    },
  },
  getters: {
    getisRegisteredUser(state) {
      return state.isRegisteredUser;
    },
    getEmail(state) {
      return state.email;
    },
    getRole(state) {
      return state.role;
    },
    check(state) {
      let token = state.token;
      return !!token;
    },
    getUsername(state) {
      return state.username;
    },
  },
};