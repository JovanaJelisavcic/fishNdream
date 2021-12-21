<template>
  <div class="container" >
    <SearchCottages/>
    <CottagesList class="float-left"/>
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

<style scoped>
.entity-list{
  margin-left: auto;
  position: relative;
  float: left;
}
</style>