import axios from "axios";
axios.defaults.baseURL = process.env.VUE_APP_BAKEND_PUTANJA;
const token = localStorage.getItem("token");
if (token) {
  axios.defaults.headers.common["Authorization"] = `Bearer ${token}`;
}

axios.interceptors.response.use(
  function(response) {
    return response;
  },
  function() {
    return { data: null };
  }
);

export default axios;