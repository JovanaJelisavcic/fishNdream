import axios from "axios";

export const login = async (params) => {
  let { data } = await axios.post("/register/signin", { ...params });
  return data;
};