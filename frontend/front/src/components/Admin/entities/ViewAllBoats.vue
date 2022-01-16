<template>
  <div>
      <b-table bordered striped hover :items="boats" :fields="fields" >
            <template v-slot:cell(options)="{ item }">
        <b-row class="m-0 p-2">
          <b-button @click="deleteBoat(item.boatId)" variant="danger"
            >Delete</b-button
          >
        </b-row>
      
      </template>
      </b-table>
  </div>
</template>

<script>
import { getAllBoats,deleteBoatByID } from "../../../api";
export default {
  data() {
    return {
      boats: [],
      boatId:null,
      fields:[
        {
          key: "address",
          label: "Address",
        },
        {
          key: "boatId",
          label: "Boat ID",
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
          key: "capacity",
          label: "Capacity",
        },
        {
          key: "boatPics",
          label: "Boat pictures",
        },
        {
          key: "description",
          label: "Description",
        },
          {
          key: "unavailablePeriods",
          label: "Unavailable periods",
        },
          {
          key: "rating",
          label: "Rating",
        },
        
        {
          key: "options",
          label: "Options",
        },
      ],
       

       
    };
  },
  computed: {},
  async mounted() {
    await this.fetchAllBoats();
  },
  methods: {
    async fetchAllBoats() {
      await getAllBoats()
        .then((response) => {
          this.boats = response;
        })
        .catch(() => {
          alert(
            "Error has been made. Please check your credentials again"
          );
        });
    },
         async deleteBoat(boatId) {
      await deleteBoatByID(boatId).then(() => {
        this.fetchAllBoats();
      });
    },
    
  },
};
</script>

<style></style>
