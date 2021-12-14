export default {
    namespaced: true,
    state: {
      cottages: []
    },
    mutations: {
      setCottages(state, data) {
        state.cottages = data;
      }
    },
    actions: {
    },
    getters: {
      getCottages(state) {
        return state.cottages;
      }
    },
  };
  