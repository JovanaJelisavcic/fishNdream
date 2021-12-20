export default {
    namespaced: true,
    state: {
      adventures: [],
      filtered: []
    },
    mutations: {
      setAdventures(state, data) {
        state.adventures = data;
        state.filtered = data;
      },
      setFiltered(state,data){
        state.filtered=data;
      },
      filterPriceAdventures(state,data){
        state.filtered=state.filtered.filter(adv =>
          (adv.price >= data[0]) && (adv.price <= data[1])
        );
      },
      resetFilter(state){
        state.filtered=state.adventures;
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
      }
    }
  };
  