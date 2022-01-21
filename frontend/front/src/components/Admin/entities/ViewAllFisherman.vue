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
import { getAllFisherman, deleteFishermanByEmail } from "../../../api";
export default {
  data() {
    return {
      fisherman: [],
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
  async mounted() {
    await this.fetchAllFisherman();
  },
  methods: {
    async fetchAllFisherman() {
      await getAllFisherman()
        .then((response) => {
          this.fisherman = response;
        })
        .catch(() => {
          this.fisherman = null;
        });
    },
    async deleteFisherman(email) {
      await deleteFishermanByEmail(email)
        .then(() => {
          this.fetchAllFisherman();
        })
        .catch(() => {
          alert("You can't delete entity with future reservations");
        });
    },
  },
};
</script>

<style></style>
