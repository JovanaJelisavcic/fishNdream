<template>
  <div>
    <b-table
      show-empty
      :empty-text="'There are no boats'"
      bordered
      striped
      hover
      :items="boats"
      :fields="fields"
    >
      <template v-slot:cell(options)="{ item }">
        <b-row class="m-0 p-2">
          <b-button @click="deleteBoat(item.boatId)" variant="danger"
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
      <template v-slot:cell(boatPics)="{ item }">
        <img
          class="m3-3"
          style="height: 60px; width: 60px"
          :src="image_prefix + '/' + item.boatPics[0]"
        />
      </template>
    </b-table>
  </div>
</template>

<script>
import { deleteBoatByID } from "../../../api";
export default {
  props: ["boats"],
  data() {
    return {
      image_prefix: process.env.VUE_APP_BAKEND_SLIKE_PUTANJA,
      boatId: null,
      fields: [
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
    async deleteBoat(boatId) {
      await deleteBoatByID(boatId)
        .then(() => {
          alert("Successfull deletion");
          this.$emit("boatDeleted");
        })
        .catch(() => {
          alert("You can't delete entity with future reservations");
        });
    },
  },
};
</script>

<style></style>
