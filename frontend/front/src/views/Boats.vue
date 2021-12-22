<template>
  <div  class="container">
    <b-row> <SearchBoats /></b-row>
    <b-row> <BoatsList class="seconrow" /></b-row>
   
   
  </div>
</template>


<script>
import SearchBoats from '../components/SearchBoats.vue';
import BoatsList from '../components/BoatsList.vue';
export default {
 name: 'Boats',
 components: {
   SearchBoats,
   BoatsList
 }
};
</script>


<style scoped>
.seconrow{
  margin-top: 50px;
}
</style>