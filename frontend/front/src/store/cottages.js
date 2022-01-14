
export default {
  namespaced: true,
  state: {
    cottages: [],
    filtered: [],
    cottageId: null,
    isSubscribed: true,
    actionsRes: null,
    beginDate: null,
    endDate: null
  },
  mutations: {
    sort(state, by, dir) {
      state.cottages = state.cottages.sort((p1, p2) => {
        let modifier = 1;
        if (dir === "desc") modifier = -1;
        if (p1[by] < p2[by]) return -1 * modifier;
        if (p1[by] > p2[by]) return 1 * modifier;
        return 0;
      });
    },
    setCottages(state, data) {
      state.cottages = data;
      state.filtered = data;
    },
    setCottageId(state, data) {
      state.cottageId = data;
    },
    setFiltered(state, data) {
      state.filtered = data;
    },
    filterPriceCottages(state, data) {
      state.filtered = state.filtered.filter(cottage =>
        (cottage.price >= data[0]) && (cottage.price <= data[1])
      );
    },
    resetFilter(state) {
      state.filtered = state.cottages;
    },
    setIsSubscribed(state, data) {
      state.isSubscribed = data;
    },
    setActionsRes(state, data) {
      state.actionsRes = data;
    },
    setBeginDate(state, data) {
      state.beginDate = data;
    },
    setEndDate(state, data) {
      state.endDate = data;
    }
  },
  actions: {

  },
  getters: {
    getCottages(state) {
      return state.cottages;
    },
    getFilteredCottages(state) {
      return state.filtered;
    }
    ,
    getCottageId(state) {
      return state.cottageId;
    },getIsSubscribed(state) {
      return state.isSubscribed;
    },getActionsRes(state) {
      return state.actionsRes;
    },getBeginDate(state) {
      return state.beginDate;
    },getEndDate(state) {
      return state.endDate;
    }
  }
};
