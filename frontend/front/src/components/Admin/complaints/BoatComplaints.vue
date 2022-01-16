<template>
  <div>
      <b-table bordered striped hover :items="boatComplaints"  :fields="fields" >

         <template v-slot:cell(options)="{ item }">
        <b-row class="m-0 p-2">
              <textarea class="w-100" v-model="respondText"> </textarea>
          <b-button @click="respondToBoatComplaint(item.complaintId,respondText)" variant="danger"
            >Delete</b-button
          >
        </b-row>
      
      </template>
      </b-table>
  </div>
</template>

<script>
import { getBoatComplaints,respondToBoatComplaint} from "../../../api";
export default {
  data() {
    return {
      boatComplaints: [

        
      ],
      fields:[
        {
          key: "complaintId",
          label: "Complaint ID",
        },
        {
          key: "boat",
          label: "Boat",
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
          label: "Respond",
        },
      ],
      complaintId:null,
      respondText:null,
       
    };
  },
  computed: {},
  async mounted() {
    await this.fetchAllBoatComplaints();
  },
  methods: {
    async fetchAllBoatComplaints() {
      await getBoatComplaints()
        .then((response) => {
          this.boatComplaints = response;
        })
        .catch(() => {
        });
    
    },
     async respondToBoatComplaint() {
      await respondToBoatComplaint({
        complaintId: this.complaintId,
        reason: this.respondText,
      }).then(() => {
        this.complaintId = null;
        this.respondText = null;
        this.fetchAllBoatComplaints();
      });
  },
    
  },
};
</script>

<style></style>
