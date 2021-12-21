<template>
  <div  class="container">
    <SearchBoats />
    <BoatsList />
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