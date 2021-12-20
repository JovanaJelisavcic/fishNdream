export default {
    namespaced: true,
    state: {
      boats: [],
      filtered: []
    },
    mutations: {
      setBoats(state, data) {
        state.boats = data;
        state.filtered = data;
      },
      setFiltered(state,data){
        state.filtered=data;
      },
      filterPriceBoats(state,data){
        state.filtered=state.filtered.filter(boat =>
          (boat.price >= data[0]) && (boat.price <= data[1])
        );
      },
      resetFilter(state){
        state.filtered=state.boats;
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
      }
    }
  };
  