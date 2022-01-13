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

export const allCottagesFisher = async () => {
  let { data } = await axios.get("/cottage/all");
  return data;
};

export const allBoatsFisher = async () => {
  let { data } = await axios.get("/boat/all");
  return data;
};

export const allAdventuresFisher = async () => {
  let { data } = await axios.get("/instructor/all");
  return data;
};

export const isSubscribedCottage = async (param) => {
  let { data } = await axios.get(`/fisherman/isSubscribedCottage/${param}`);
  return data;
};

export const subscribeCottage = async (param) => {
  let { data } = await axios.post(`/cottage/subscribe/${param}`);
  return data;
};

export const isSubscribedBoat = async (param) => {
  let { data } = await axios.get(`/fisherman/isSubscribedBoat/${param}`);
  return data;
};

export const subscribeBoat = async (param) => {
  let { data } = await axios.post(`/boat/subscribe/${param}`);
  return data;
};

export const isSubscribedInstructor = async (param) => {
  let { data } = await axios.get(`/fisherman/isSubscribedInstructor/${param}`);
  return data;
};

export const subscribeInstructor = async (param) => {
  let { data } = await axios.post(`/instructor/subscribe/${param}`);
  return data;
};

export const getActionsCottage = async (param) => {
  let { data } = await axios.get(`/reservationCottage/actions/${param}`);
  return data;
};

export const getActionsBoat = async (param) => {
  let { data } = await axios.get(`/reservationBoat/actions/${param}`);
  return data;
};

export const getActionsAdventure = async (param) => {
  let { data } = await axios.get(`/reservationAdventure/actions/${param}`);
  return data;
};