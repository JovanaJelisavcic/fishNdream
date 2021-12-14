<template>
  <div>
    <SearchCottages/>
    <CottagesList/>
  </div>
</template>


<script>
import SearchCottages from '../components/SearchCottages.vue';
import CottagesList from '../components/CottagesList.vue';
export default {
 name: 'Cottages',
 components: {
   SearchCottages,
   CottagesList
 }
};
</script>
