<template>
  <div>
      <b-table bordered striped hover :items="cottageComplaints"  :fields="fields" show-empty
      :empty-text="'No comlaints'">

         <template v-slot:cell(options)="{ item }">
        <b-row class="m-0 p-2">
            <textarea class="w-100" v-model="respondText"> </textarea>
          <b-button @click="respondToCottageComplaint(item.complaintId,respondText)" variant="success"
            >Respond</b-button
          >
        </b-row>
      
      </template>
      </b-table>
  </div>
</template>

<script>
import { getCottageComplaints,respondToCottageComplaint } from "../../../api";
export default {
  data() {
    return {
        respondText:null,
      cottageComplaints: [

        
      ],
      fields:[
        {
          key: "complaintId",
          label: "Complaint ID",
        },
        {
          key: "cottage",
          label: "Cottage",
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
       
    };
  },
  computed: {},
  async mounted() {
    await this.fetchAllCottageComplaints();
  },
  methods: {
    async fetchAllCottageComplaints() {
      await getCottageComplaints()
        .then((response) => {
          this.cottageComplaints = response;
        })
        .catch(() => {
           this.cottageComplaints = null;
        });
    
    },
      async respondToCottageComplaint(id, text) {
      await respondToCottageComplaint({
        complaintId: id,
        reason: text,
      }).then(() => {
        this.complaintId = null;
        this.respondText = null;
        this.fetchAllCottageComplaints();
      });
  },
  }
};
</script>

<style></style>
