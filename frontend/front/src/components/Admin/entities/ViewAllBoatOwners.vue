<template>
  <div>
    <b-table bordered striped hover :items="boatOwners" :fields="fields">
      <template v-slot:cell(options)="{ item }">
        <b-row class="m-0 p-2">
          <b-button @click="deleteBoatOwner(item.email)" variant="danger"
            >Delete</b-button
          >
        </b-row>
      </template>
      <template v-slot:cell(rating)="{ item }">
        <b-row class="m-0 p-2"> {{ item.rating }} ⭐ </b-row>
      </template>
    </b-table>
  </div>
</template>

<script>
import { getAllBoatOwners, deleteBoatOwnerByEmail } from "../../../api";
export default {
  data() {
    return {
      boatOwners: [],
      email: null,
      fields: [
        {
          key: "address",
          label: "Address",
        },
        {
          key: "city",
          label: "City",
        },
        {
          key: "email",
          label: "Email",
        },
        {
          key: "name",
          label: "Name",
        },
        {
          key: "phoneNum",
          label: "Number",
        },
        {
          key: "state",
          label: "State",
        },
        {
          key: "rating",
          label: "Rating",
        },
        {
          key: "surname",
          label: "Surname",
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
    await this.fetchAllBoatOwners();
  },
  methods: {
    async fetchAllBoatOwners() {
      await getAllBoatOwners()
        .then((response) => {
          this.boatOwners = response;
        })
        .catch(() => {this.boatOwners=null});
    },
    async deleteBoatOwner(email) {
      await deleteBoatOwnerByEmail(email).then(() => {
        this.fetchAllBoatOwners();
      }).catch(()=> {alert("You can't delete entity with future reservations")});
    },
  },
};
</script>

<style></style>
