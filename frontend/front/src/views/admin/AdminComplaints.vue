<template>
  <div>
    <b-tabs>
      <b-tab title="Instructor Complaints" active>
        <InstructorComplaints></InstructorComplaints>
      </b-tab>
      <b-tab title="Cottage Complaints" active>
        <CottageComplaints></CottageComplaints>
      </b-tab>
      <b-tab title="Boat Complaints" active>
        <BoatComplaints></BoatComplaints>
      </b-tab>
    </b-tabs>
  </div>
</template>

<script>
import InstructorComplaints from "../../components/Admin/complaints/InstructorComplaints.vue"
import CottageComplaints from "../../components/Admin/complaints/CottageComplaints.vue"
import BoatComplaints from "../../components/Admin/complaints/BoatComplaints.vue"
export default {
  components:{
    InstructorComplaints,
    CottageComplaints,
    BoatComplaints
  }
};
</script>

<style></style>
