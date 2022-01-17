<template>
  <b-tabs>
    <b-tab title="Boats" active>
      <ComplainBoats></ComplainBoats>
    </b-tab>
    <b-tab title="Cottages" active>
      <ComplainCottages></ComplainCottages>
    </b-tab>
    <b-tab title="Instructors" active>
      <ComplainInstructors></ComplainInstructors>
    </b-tab>
  </b-tabs>
</template>

<script>
import ComplainBoats from "../../components/Fisherman/complain/ComplainBoats.vue";
import ComplainCottages from "../../components/Fisherman/complain/ComplainCottages.vue";
import ComplainInstructors from "../../components/Fisherman/complain/ComplainInstructors.vue";
export default {
  name: "FileComplaint",
  components: {
    ComplainBoats,
    ComplainCottages,
    ComplainInstructors,
  },
};
</script>