<template>
  <div>
    <b-table
      show-empty
      :empty-text="'There are no adventures'"
      bordered
      striped
      hover
      :items="adventures"
      :fields="fields"
    >
      <template v-slot:cell(options)="{ item }">
        <b-row class="m-0 p-2">
          <b-button @click="deleteAdventure(item.adventureId)" variant="danger"
            >Delete</b-button
          >
        </b-row>
      </template>
      <template v-slot:cell(price)="{ item }">
        <b-row class="m-0 p-2"> {{ item.price }}$ </b-row>
      </template>
      <template v-slot:cell(adventurePics)="{ item }">
        <img
          class="m3-3"
          style="height: 60px; width: 60px"
          :src="image_prefix + '/' + item.adventurePics[0]"
        />
      </template>
    </b-table>
  </div>
</template>

<script>
import { getAllAdvantures, deleteAdventureByID } from "../../../api";
export default {
  data() {
    return {
      image_prefix: process.env.VUE_APP_BAKEND_SLIKE_PUTANJA,
      adventures: [],
      fields: [
        {
          key: "adventureId",
          label: "Adventure ID",
        },
        {
          key: "adventurePics",
          label: "Picture",
        },
        {
          key: "behaviourRules",
          label: "Behaviour Rules",
        },
        {
          key: "cancelPolicy",
          label: "Cancel Policy",
        },
        {
          key: "description",
          label: "Description",
        },
        {
          key: "instructor.email",
          label: "Instructor",
        },
        {
          key: "maxParticipants",
          label: "Max Participants",
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
          key: "options",
          label: "Options",
        },
      ],
      adventureId: null,
    };
  },
  computed: {},
  async mounted() {
    await this.fetchAllAdventures();
  },
  methods: {
    async fetchAllAdventures() {
      await getAllAdvantures()
        .then((response) => {
          this.adventures = response;
        })
        .catch(() => {
          this.adventures = null;
        });
    },
    async deleteAdventure(adventureId) {
      await deleteAdventureByID(adventureId)
        .then(() => {
          this.fetchAllAdventures();
        })
        .catch(() => {
          alert("You can't delete entity with future reservations");
        });
    },
  },
};
</script>

<style></style>
