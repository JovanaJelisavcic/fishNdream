<template>
  <div class="container">
    <b-row><SearchAdventures /></b-row>
    <b-row> <AdventuresList class="seconrow"/></b-row>
    
   
  </div>
</template>


<script>
import SearchAdventures from '../components/SearchAdventures.vue'
import AdventuresList from '../components/AdventruesList.vue'
export default {
 name: 'Adventures',
 components: {
   SearchAdventures,
   AdventuresList
 }
};
</script>

<style scoped>
.seconrow{
  margin-top: 50px;
}
</style>


