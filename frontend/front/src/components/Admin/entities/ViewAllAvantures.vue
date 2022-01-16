<template>
  <div>
      <b-table bordered striped hover :items="adventures"  :fields="fields" >

         <template v-slot:cell(options)="{ item }">
        <b-row class="m-0 p-2">
          <b-button @click="deleteAdventure(item.adventureId)" variant="danger"
            >Delete</b-button
          >
        </b-row>
      
      </template>
      </b-table>
  </div>
</template>

<script>
import { getAllAdvantures,deleteAdventureByID } from "../../../api";
export default {
  data() {
    return {
      adventures: [

        
      ],
      fields:[
        {
          key: "adventureId",
          label: "Adventure ID",
        },
        {
          key: "adventurePics",
          label: "Adventure Pictures",
        },
        {
          key: "behaviourRules",
          label: "Behaviour Rules",
        },
        {
          key: "cancelPolicy",
          label: "Cancel Policy",
        },
        {
          key: "description",
          label: "Description",
        },
        {
          key: "instructor",
          label: "Instructor",
        },
        {
          key: "maxParticipants",
          label: "Max Participants",
        },
        {
          key: "name",
          label: "Name",
        },
        {
          key: "price",
          label: "Price",
        },
        {
          key: "options",
          label: "Options",
        },
      ],
      adventureId:null,
       
    };
  },
  computed: {},
  async mounted() {
    await this.fetchAllAdventures();
  },
  methods: {
    async fetchAllAdventures() {
      await getAllAdvantures()
        .then((response) => {
          this.adventures = response;
        })
        .catch(() => {
          alert(
            "Error has been made. Please check your credentials again"
          );
        });
    },
            async deleteAdventure(adventureId) {
      await deleteAdventureByID(adventureId).then(() => {
        this.fetchAllAdventures();
      });
    },
  },
};
</script>

<style></style>
