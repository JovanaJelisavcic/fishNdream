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
import { deleteCottageOwnerByEmail } from "../../../api";
export default {
  props: ["cottageOwners"],
  data() {
    return {
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

  methods: {
    async deleteCottageOwner(email) {
      await deleteCottageOwnerByEmail(email)
        .then(() => {
          alert("Successfull deletion");
          this.$emit("cottageOwnerDeleted");
        })
        .catch(() => {
          alert("You can't delete entity with future reservations");
        });
    },
  },
};
</script>

<style></style>
