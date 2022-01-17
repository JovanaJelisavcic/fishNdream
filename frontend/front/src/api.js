import axios from "axios";

export const login = async (params) => {
  let { data } = await axios.post("/register/signin", { ...params });
  return data;
};

export const searchCottages = async (params) => {
  let { data } = await axios.post("/search/cottages", { ...params });
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
  let { data } = await axios.post("/search/boats", { ...params });
  return data;
};

export const allAdventures = async () => {
  let { data } = await axios.get("/instructor/");
  return data;
};

export const searchAdventures = async (params) => {
  let { data } = await axios.post("/search/adventures", { ...params });
  return data;
};

export const registerFisherman = async (params) => {
  let { data } = await axios.post("/register/user", { ...params });
  return data;
};

export const registerOwner = async (params) => {
  let { data } = await axios.post("/register/owner", { ...params });
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


export const reserveActionCottage = async (param) => {
  let { data } = await axios.post(`/reservationCottage/actions/reserve/${param}`);
  return data;
};

export const searchCottagesFisherman = async (params) => {
  let { data } = await axios.post("/search/cottages/fisher", { ...params });
  return data;
};

export const searchBoatsFisherman = async (params) => {
  let { data } = await axios.post("/search/boats/fisher", { ...params });
  return data;
};

export const searchAdventuresFisherman = async (params) => {
  let { data } = await axios.post("/search/adventures/fisher", { ...params });
  return data;
};

export const isStillFreeCottage = async (id, beginDate, endDate) => {
  let { data } = await axios.get(`/cottage/${id}/stillFree/${beginDate}/${endDate}`);
  return data;
};

export const getRegisterRequests = async () => {
    let { data } = await axios.get("/register/requests");
    return data;

};
export const acceptRegistration = async (email) => {
  let { data } = await axios.post(`register/allow/${email}`);
  return data;
};
export const rejectRegistration = async (params) => {
  let { data } = await axios.post(
    `/register/refuse?email=${params.email}&reason=${params.reason}`
  );
  return data;
};

export const getAdminDeletionRequests = async () => {
  let { data } = await axios.get("deleteAccount/admin/requests");
  return data;
};


export const acceptAdminDeletionRequest = async (params) => {
  let { data } = await axios.post(`/deleteAccount/admin/accept/${params.id}?resp=${params.reason}`);
  return data;
};

export const rejectAdminDeletionRequest = async (params) => {
  let { data } = await axios.post(
    `deleteAccount/admin/refuse/${params.requestId}?resp=${params.reason}`
  );
  return data;
};

export const getUserDeletionRequests = async () => {
  let { data } = await axios.get("deleteAccount/requests");
  return data;

};

export const acceptUserDeletionRequest = async (params) => {
  let { data } = await axios.post(`/deleteAccount/accept/${params.id}?resp=${params.reason}`);
  return data;
};

export const rejectUserDeletionRequest = async (params) => {
  let { data } = await axios.post(`/deleteAccount/refuse/${params.requestId}?resp=${params.reason}`);
  return data;
};



export const getAllReportsForAdmin = async () => {
  let { data } = await axios.get("/admin/revenue");
  return data;

};

export const getAllBoats = async () => {
  let { data } = await axios.get("/unautho/boats");
  return data;

};
export const getAllBoatOwners = async () => {
  let { data } = await axios.get("/admin/boatOwners");
  return data;

};

export const getAllCottages = async () => {
  let { data } = await axios.get("/unautho/cottages");
  return data;

};
export const getAllCottageOwners = async () => {
  let { data } = await axios.get("/admin/cottageOwners");
  return data;

};
export const getAllFisherman = async () => {
  let { data } = await axios.get("/admin/fishermen");
  return data;

};
export const getAllAdvantures = async () => {
  let { data } = await axios.get("/instructor/all");
  return data;

};
export const getAllInstructors = async () => {
  let { data } = await axios.get("/unautho/instructors/");
  return data;

};
export const deleteInstructorByID = async (email) => {
  let { data } = await axios.post(`/admin/delete/instructor/${email}`);
  return data;
};
export const deleteFishermanByEmail = async (email) => {
  let { data } = await axios.post(`/admin/delete/fisherman/${email}`);
  return data;
};
export const deleteBoatByID = async (id) => {
  let { data } = await axios.post(`/admin/delete/boat/${id}`);
  return data;
};
export const deleteCottageByID = async (id) => {
  let { data } = await axios.post(`/admin/delete/cottage/${id}`);
  return data;
};

export const deleteBoatOwnerByEmail = async (email) => {
  let { data } = await axios.post(`/admin/delete/boatowner/${email}`);
  return data;
};
export const deleteCottageOwnerByEmail = async (email) => {
  let { data } = await axios.post(`/admin/delete/cottageowner/${email}`);
  return data;
};


export const deleteAdventureByID = async (id) => {
  let { data } = await axios.post(`admin/delete/adventure/${id}`);
  return data;
};


export const registerNewAdmin = async (params) => {
  let { data } = await axios.post("register/admin", { ...params });
  return data;
};


export const getInstructorComplaints = async () => {
  let { data } = await axios.get("/complaint/instructors");
  return data;

};

export const getCottageComplaints = async () => {
  let { data } = await axios.get("/complaint/cottages");
  return data;

};

export const getBoatComplaints = async () => {
  let { data } = await axios.get("/complaint/boats");
  return data;

};

export const respondToInstructorComplaint = async (params) => {
  let { data } = await axios.post(`/complaint/respond/instructor/${params.complaintId}?reason=${params.reason}`);
  return data;
};
export const respondToCottageComplaint = async (params) => {
  let { data } = await axios.post(`/complaint/respond/cottage/${params.complaintId}?reason=${params.reason}`);
  return data;
};
export const respondToBoatComplaint = async (params) => {
  let { data } = await axios.post(`/complaint/respond/boat/${params.complaintId}?reason=${params.reason}`);
  return data;
};

export const changeSystemGain = async (params) => {
  let { data } = await axios.post("/admin/gain", { ...params });
  return data;
};
export const deleteAdminProfile = async (params) => {
  let { data } = await axios.post(
    `/deleteAccount/admin/request?reason=${params.reason}`
  );
  return data;
};


export const getAdminData = async () => {
  let { data } = await axios.get("/admin/myprofile");
  return data;
};


export const updateAdminData = async (params) => {
  let { data } = await axios.put("/admin/update", { ...params });
  return data;
};


export const deleteFishermanProfile = async (params) => {
  let { data } = await axios.post(
    `/deleteAccount/request?reason=${params.reason}`
  );
  return data;
};


export const getFishermanData = async () => {
  let { data } = await axios.get("/fisherman/myprofile");
  return data;
};


export const updateFishermanData = async (params) => {
  let { data } = await axios.put("/fisherman/update", { ...params });
  return data;
};