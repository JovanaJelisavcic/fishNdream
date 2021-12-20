import axios from "axios";

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