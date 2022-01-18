<template>
  <div>
    <b-table bordered striped hover :items="cottages" :fields="fields">
      <template v-slot:cell(options)="{ item }">
        <b-row class="m-0 p-2">
          <b-button @click="deleteCottage(item.cottageId)" variant="danger"
            >Delete</b-button
          >
        </b-row>
      </template>
      <template v-slot:cell(price)="{ item }">
        <b-row class="m-0 p-2"> {{ item.price }}$ </b-row>
      </template>
      <template v-slot:cell(rating)="{ item }">
        <b-row class="m-0 p-2"> {{ item.rating }} ⭐ </b-row>
      </template>
            <template v-slot:cell(cottagePics)="{ item }">
        <img
          class="m3-3"
          style="height: 60px; width: 60px"
          :src="image_prefix + '/' + item.cottagePics[0]"
        />
      </template>
    </b-table>
  </div>
</template>

<script>
import { getAllCottages, deleteCottageByID } from "../../../api";
export default {
  data() {
    return {
      image_prefix: process.env.VUE_APP_BAKEND_SLIKE_PUTANJA,
      cottages: [],
      cottageId: null,
      fields: [
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
          label: "Picture",
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
        .catch(() => {this.cottages=null});
    },
    async deleteCottage(cottageId) {
      await deleteCottageByID(cottageId).then(() => {
        this.fetchAllCottages();
      }).catch(()=> {alert("You can't delete entity with future reservations")});
    },
  },
};
</script>

<style></style>
