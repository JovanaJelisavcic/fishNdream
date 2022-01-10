import axios from "axios";

axios.interceptors.response.use(function (response) {
  return response;
}, function (error) {
//  store.commit('ERROR', error) // just taking some guesses here
  return Promise.reject(error) // this is the important part
});

export const login = async (params) => {
  let { data } = await axios.post("/register/signin", { ...params });
  return data;
};

export const searchCottages = async (params) => {
  let { data } = await axios.post("/search/cottages", { ...params});
  return data;
};

export const allCottages = async () => {
  let { data } = await axios.get("/cottage/");
  return data;
};

export const allBoats = async () => {
  let { data } = await axios.get("/boat/");
  return data;
};

export const searchBoats = async (params) => {
  let { data } = await axios.post("/search/boats", { ...params});
  return data;
};

export const allAdventures = async () => {
  let { data } = await axios.get("/instructor/");
  return data;
};

export const searchAdventures = async (params) => {
  let { data } = await axios.post("/search/adventures", { ...params});
  return data;
};

export const registerFisherman = async (params) => {
  let { data } = await axios.post("/register/user", { ...params});
  return data;
};

export const registerOwner = async (params) => {
  let { data } = await axios.post("/register/owner", { ...params} );
  return data;
};