<template>
  <div>
    <b-table
      show-empty
      :empty-text="'There are no cottage owners'"
      bordered
      striped
      hover
      :items="cottageOwners"
      :fields="fields"
    >
      <template v-slot:cell(options)="{ item }">
        <b-row class="m-0 p-2">
          <b-button @click="deleteCottageOwner(item.email)" variant="danger"
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
import { getAllCottageOwners, deleteCottageOwnerByEmail } from "../../../api";
export default {
  data() {
    return {
      cottageOwners: [],
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
    await this.fetchAllCottageOwners();
  },
  methods: {
    async fetchAllCottageOwners() {
      await getAllCottageOwners()
        .then((response) => {
          this.cottageOwners = response;
        })
        .catch(() => {
          this.cottageOwners = null;
        });
    },
    async deleteCottageOwner(email) {
      await deleteCottageOwnerByEmail(email)
        .then(() => {
          this.fetchAllCottageOwners();
        })
        .catch(() => {
          alert("You can't delete entity with future reservations");
        });
    },
  },
};
</script>

<style></style>
