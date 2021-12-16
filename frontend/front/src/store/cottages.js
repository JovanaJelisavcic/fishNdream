
export default {
  namespaced: true,
  state: {
    cottages: [],
    filtered: []
  },
  mutations: {
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
