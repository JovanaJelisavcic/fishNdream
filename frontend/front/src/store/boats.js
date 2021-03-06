export default {
  namespaced: true,
  state: {
    boats: [],
    filtered: [],
    boatId: null,
    isSubscribed: true,
    actionsRes: null,
    beginDate: null,
    endDate: null,
    isReservable: null,
    reservePrice: 0,
    peopleNum: null,
  },
  mutations: {
    sort(state, by, dir) {
      state.boats = state.boats.sort((p1, p2) => {
        let modifier = 1;
        if (dir === "desc") modifier = -1;
        if (p1[by] < p2[by]) return -1 * modifier;
        if (p1[by] > p2[by]) return 1 * modifier;
        return 0;
      });
    },
    setBoats(state, data) {
      state.boats = data;
      state.filtered = data;
    },
    setFiltered(state, data) {
      state.filtered = data;
    },
    filterPriceBoats(state, data) {
      state.filtered = state.filtered.filter(boat =>
        (boat.price >= data[0]) && (boat.price <= data[1])
      );
    },
    resetFilter(state) {
      state.filtered = state.boats;
    },
    setIsSubscribed(state, data) {
      state.isSubscribed = data;
    }
    ,
    setIsReservable(state, data) {
      state.isReservable = data;
    },
    setActionsRes(state, data) {
      state.actionsRes = data;
    },
    setBeginDate(state, data) {
      state.beginDate = data;
    },
    setEndDate(state, data) {
      state.endDate = data;
    }, setReservePrice(state, data) {
      state.reservePrice = data;
    },
    setPeopleNum(state, data) {
      state.peopleNum = data;
    }
  },
  actions: {

  },
  getters: {
    getBoats(state) {
      return state.boats;
    },
    getFilteredBoats(state) {
      return state.filtered;
    }, getIsSubscribed(state) {
      return state.isSubscribed;
    }, getActionsRes(state) {
      return state.actionsRes;
    }, getBeginDate(state) {
      return state.beginDate;
    }, getEndDate(state) {
      return state.endDate;
    }, getIsReservable(state) {
      return state.isReservable;
    }, getReservePrice(state) {
      return state.reservePrice;
    }, getPeopleNum(state) {
      return state.peopleNum;
    }

  }
};
