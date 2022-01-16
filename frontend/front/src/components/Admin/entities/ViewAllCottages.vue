<template>
  <div>
      <b-table bordered striped hover :items="cottages" :fields="fields" >
        <template v-slot:cell(options)="{ item }">
        <b-row class="m-0 p-2">
          <b-button @click="deleteCottage(item.cottageId)" variant="danger"
            >Delete</b-button
          >
        </b-row>
      
      </template>
      </b-table>
  </div>
</template>

<script>
import { getAllCottages,deleteCottageByID } from "../../../api";
export default {
  data() {
    return {
      cottages: [],
      cottageId:null,
        fields:[
        {
          key: "address",
          label: "Address",
        },
        {
          key: "cottageId",
          label: "Cottage ID",
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
          key: "guestsNum",
          label: "Guests",
        },
        {
          key: "cottagePics",
          label: "Cottage pictures",
        },
        {
          key: "description",
          label: "Description",
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
    await this.fetchAllCottages();
  },
  methods: {
    async fetchAllCottages() {
      await getAllCottages()
        .then((response) => {
          this.cottages = response;
        })
        .catch(() => {
          alert(
            "Error has been made. Please check your credentials again"
          );
        });
    },
        async deleteCottage(cottageId) {
      await deleteCottageByID(cottageId).then(() => {
        this.fetchAllCottages();
      });
    },
  },
};
</script>

<style></style>
