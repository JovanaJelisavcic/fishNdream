<template>
  <div>
    <b-table
      bordered
      :items="items"
      :fields="fields"
      show-empty
      :empty-text="'No boats you can complain about'"
    >
      <template v-slot:cell(options)="{ item }">
        <b-row class="m-0 p-2">
          <b-button @click="showComplainModal(item.boatId)" variant="success"
            >Complain</b-button
          >
        </b-row>
      </template>
    </b-table>
      <b-modal
      id="complainModalUser"
      title="Complain"
      @ok.prevent="complainBoat(boatId)"
    >
      <span>Write your complaint</span>
      <textarea class="w-100" v-model="complaintText"> </textarea>
    </b-modal>
  </div>
</template>

<script>
import {
  getPossibleBoatsComplain,
  complainBoat
} from "../../../api";
export default {
  data() {
    return {
      complaintText: null,
      boatId: null,
      fields: [
        {
          key: "name",
          label: "Name",
          class: "text-center",
        },
        {
          key: "address",
          label: "Address",
          class: "text-center",
        },
        {
          key: "description",
          label: "Description",
          class: "text-center",
        },
        {
          key: "rating",
          label: "Rating",
           class: "text-center",
        },
        {
          key: "options",
          label: "Options",
           class: "text-center",
        },
      ],
      items: [],
    };
  },
  async mounted() {
    await this.fetchPossible();
  },
  methods: {
    showComplainModal(requestId) {
      this.complaintText = null;
      this.boatId = requestId;
      this.$bvModal.show("complainModalUser");
    },
    async complainBoat(boatId) {
      await complainBoat({
        id: boatId,
        reason: this.complaintText,
      }).then(() => {
        this.boatId = null;
        this.complaintText = null;
        this.fetchPossible();
        this.$bvModal.hide("complainModalUser");
      });
    },
    async fetchPossible() {
      await getPossibleBoatsComplain()
        .then((response) => {
          this.items = response;
        })
        .catch(() => {
            this.items = null;
        });
    },
  },
};
</script>

<style></style>
