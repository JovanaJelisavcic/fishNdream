export default {
  namespaced: true,
  state: {
    adventures: [],
    filtered: [],
    adventureId: null,
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
      state.adventures = state.adventures.sort((p1, p2) => {
        let modifier = 1;
        if (dir === "desc") modifier = -1;
        if(by=="rating"){
          if (p1["instructor"][by] < p2["instructor"][by]) return -1 * modifier;
          if (p1["instructor"][by] > p2["instructor"][by]) return 1 * modifier;
        }else{
          if (p1[by] < p2[by]) return -1 * modifier;
          if (p1[by] > p2[by]) return 1 * modifier;
        }
       
        return 0;
      });
    },
    setAdventures(state, data) {
      state.adventures = data;
      state.filtered = data;
    },
    setFiltered(state, data) {
      state.filtered = data;
    },
    filterPriceAdventures(state, data) {
      state.filtered = state.filtered.filter(adv =>
        (adv.price >= data[0]) && (adv.price <= data[1])
      );
    },
    resetFilter(state) {
      state.filtered = state.adventures;
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
    }, setIsReservable(state, data) {
      state.isReservable = data;
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
    getAdventures(state) {
      return state.adventures;
    },
    getFilteredAdventures(state) {
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
