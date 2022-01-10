import axios from "axios";
axios.defaults.baseURL = process.env.VUE_APP_BAKEND_PUTANJA;
const token = localStorage.getItem("token");
if (token) {
  axios.defaults.headers.common["Authorization"] = `Bearer ${token}`;
}

/*axios.interceptors.response.use(
  function(response) {
    return response;
  },
  function() {
    return { data: null };
  }
);*/

axios.interceptors.response.use(
  function (response) {
  return response;
}, function (error) {
//  store.commit('ERROR', error) // just taking some guesses here
  return Promise.reject(error) // this is the important part
});

export default axios;