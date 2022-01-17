<template>
  <div>
    <b-table
      bordered
      :items="items"
      :fields="fields"
      show-empty
      :empty-text="'No cottages you can complain about'"
    >
      <template v-slot:cell(options)="{ item }">
        <b-row class="m-0 p-2">
          <b-button @click="showComplainModal(item.cottageId)" variant="success"
            >Complain</b-button
          >
        </b-row>
      </template>
    </b-table>
      <b-modal
      id="complainModalUser"
      title="Complain"
      @ok.prevent="complainCottage()"
    >
      <span>Write your complaint</span>
      <textarea class="w-100" v-model="complaintText"> </textarea>
    </b-modal>
  </div>
</template>

<script>
import {
  getPossibleCottagesComplain,
  complainCottage
} from "../../../api";
export default {
  data() {
    return {
      complaintText: null,
      cottageId: null,
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
      this.cottageId = requestId;
      this.$bvModal.show("complainModalUser");
    },
    async complainCottage() {
      await complainCottage({
        id: this.cottageId,
        reason: this.complaintText,
      }).then(() => {
        this.cottageId = null;
        this.complaintText = null;
        this.fetchPossible();
        this.$bvModal.hide("complainModalUser");
      });
    },
    async fetchPossible() {
      await getPossibleCottagesComplain()
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
