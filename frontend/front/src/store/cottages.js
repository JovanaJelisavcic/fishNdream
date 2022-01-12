
export default {
  namespaced: true,
  state: {
    cottages: [],
    filtered: []
  },
  mutations: {
    sort(state, by, dir){
      state.cottages= state.cottages.sort((p1, p2) => {
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
    setFiltered(state,data){
      state.filtered=data;
    },
    filterPriceCottages(state,data){
      state.filtered=state.filtered.filter(cottage =>
        (cottage.price >= data[0]) && (cottage.price <= data[1])
      );
    },
    resetFilter(state){
      state.filtered=state.cottages;
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
  }
};
