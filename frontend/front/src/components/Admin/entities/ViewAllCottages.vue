<template>
  <div>
    <b-table
      show-empty
      :empty-text="'There are no cottages'"
      bordered
      striped
      hover
      :items="cottages"
      :fields="fields"
    >
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
import { deleteCottageByID } from "../../../api";
export default {
  props: ["cottages"],
  data() {
    return {
      image_prefix: process.env.VUE_APP_BAKEND_SLIKE_PUTANJA,
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
          key: "owner.email",
          label: "Owner",
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
  methods: {
    async deleteCottage(cottageId) {
      await deleteCottageByID(cottageId)
        .then(() => {
          alert("Successfull deletion");
          this.$emit("cottageDeleted");
        })
        .catch(() => {
          alert("You can't delete entity with future reservations");
        });
    },
  },
};
</script>

<style></style>
