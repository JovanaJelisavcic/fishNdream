<template>
    <b-tabs>
      <b-tab title="Boats" active>
        <ViewAllBoats></ViewAllBoats>
      </b-tab>
         <b-tab title="Boat Owners" active>
        <ViewAllBoatOwners></ViewAllBoatOwners>
      </b-tab>
        <b-tab title="Cottages" active>
        <ViewAllCottages></ViewAllCottages>
      </b-tab>
        <b-tab title="Cottage Owners" active>
        <ViewAllCottageOwners></ViewAllCottageOwners>
      </b-tab>
       <b-tab title="Fisherman" active>
        <ViewAllFisherman></ViewAllFisherman>
      </b-tab>
       <b-tab title="Adventures" active>
        <ViewAllAdventures></ViewAllAdventures>
      </b-tab>
       <b-tab title="Instructors" active>
        <ViewAllInstructors></ViewAllInstructors>
      </b-tab>
  </b-tabs>
</template>

<script>

import ViewAllBoats from '../../components/Admin/entities/ViewAllBoats.vue';
import ViewAllCottages from '../../components/Admin/entities/ViewAllCottages.vue'
import ViewAllBoatOwners from '../../components/Admin/entities/ViewAllBoatOwners.vue'
import ViewAllCottageOwners from '../../components/Admin/entities/ViewAllCottageOwners.vue'
import ViewAllFisherman from '../../components/Admin/entities/ViewAllFisherman.vue'
import ViewAllAdventures from '../../components/Admin/entities/ViewAllAvantures.vue'
import ViewAllInstructors from '../../components/Admin/entities/ViewAllInstructors.vue'

export default {
   components: {
     ViewAllBoats,
     ViewAllCottages,
     ViewAllBoatOwners,
     ViewAllCottageOwners,
     ViewAllFisherman,
     ViewAllAdventures,
     ViewAllInstructors
     
     }
     };
</script>

<style></style>
