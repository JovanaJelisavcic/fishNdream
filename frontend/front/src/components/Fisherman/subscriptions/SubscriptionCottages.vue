<template>
  <div>
    <b-table
      bordered
      striped
      hover
      :items="subscriptions"
      :fields="fields"
      show-empty
      :empty-text="'No subscriptions'"
    >
      <template v-slot:cell(options)="{ item }">
        <b-row class="m-0 p-2">
          <b-button
            @click="unsubscribe(item.cottage.cottageId)"
            variant="danger"
            >Unsubscribe</b-button
          >
        </b-row>
      </template>
    </b-table>
  </div>
</template>


<script>
import {
  getAllCottageSubscriptions,
  unsubscribeCottageByID,
} from "../../../api";
export default {
  data() {
    return {
      subscriptions: [],
      subscriptionId: null,
      fields: [
        {
          key: "cottage.name",
          label: "Name",
        },
        {
          key: "cottage.address",
          label: "Address",
        },
        {
          key: "cottage.description",
          label: "Description",
        },
        {
          key: "cottage.rating",
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
  async mounted() {
    await this.fetchAllSubscriptions();
  },
  methods: {
    async fetchAllSubscriptions() {
      await getAllCottageSubscriptions()
        .then((response) => {
          this.subscriptions = response;
        })
        .catch(() => {
          this.subscriptions = null;
        });
    },
    async unsubscribe(boatId) {
      await unsubscribeCottageByID(boatId).then(() => {
        alert("Unsubscribed successfully");
        this.fetchAllSubscriptions();
      });
    },
  },
};
</script>