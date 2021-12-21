<template>
  <div class="container">
    <SearchAdventures />
    <AdventuresList />
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


