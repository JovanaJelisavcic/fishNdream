<template>
  <div>
    <b-table
      show-empty
      :empty-text="'There are no fishermen'"
      bordered
      striped
      hover
      :items="fisherman"
      :fields="fields"
    >
      <template v-slot:cell(options)="{ item }">
        <b-row class="m-0 p-2">
          <b-button @click="deleteFisherman(item.email)" variant="danger"
            >Delete</b-button
          >
        </b-row>
      </template>
    </b-table>
  </div>
</template>

<script>
import { deleteFishermanByEmail } from "../../../api";
export default {
  props: ["fisherman"],
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
    async deleteFisherman(email) {
      await deleteFishermanByEmail(email)
        .then(() => {
          alert("Successfull deletion");
          this.$emit("fishermanDeleted");
        })
        .catch(() => {
          alert("You can't delete entity with future reservations");
        });
    },
  },
};
</script>

<style></style>
