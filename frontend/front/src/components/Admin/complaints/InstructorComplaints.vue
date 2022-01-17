<template>
  <div>
      <b-table bordered striped hover :items="instructorComplaints"  :fields="fields"  show-empty
      :empty-text="'No comlaints'" >

         <template v-slot:cell(options)="{ item }">
        <b-row class="m-0 p-2">
         <textarea class="w-100" v-model="respondText"> </textarea>
          <b-button @click="respondToInstructorComplaint(item.complaintId,respondText)" variant="success"
            >Respond</b-button
          >
        </b-row>
      
      </template>
      </b-table>
  </div>
</template>

<script>
import { getInstructorComplaints, respondToInstructorComplaint } from "../../../api";
export default {
  data() {
    return {
      instructorComplaints: [

        
      ],
      fields:[
        {
          key: "complaintId",
          label: "Complaint ID",
        },
        {
          key: "instructor",
          label: "Instructor",
        },        
        {
          key: "fisherman",
          label: "Fisherman",
        },
        {
          key: "complaintText",
          label: "Complaint Text",
        },
        {
          key: "options",
          label: "Options",
        },
      ],
      complaintId:null,
      respondText:null
       
    };
  },
  computed: {},
  async mounted() {
    await this.fetchAllInstructorComplaints();
  },
  methods: {
    async fetchAllInstructorComplaints() {
      await getInstructorComplaints()
        .then((response) => {
          this.instructorComplaints = response;
        })
        .catch(() => {
           this.instructorComplaints = null;
        });
    
    },
      async respondToInstructorComplaint(id, text) {
      await respondToInstructorComplaint({
        complaintId: id,
        reason: text,
      }).then(() => {
        this.complaintId = null;
        this.respondText = null;
        this.fetchAllInstructorComplaints();
      });
    },
  },
};
</script>

<style></style>
