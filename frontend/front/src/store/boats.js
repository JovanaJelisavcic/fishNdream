export default {
    namespaced: true,
    state: {
      boats: [],
      filtered: []
    },
    mutations: {
      sort(state, by, dir){
        state.boats= state.boats.sort((p1, p2) => {
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
  