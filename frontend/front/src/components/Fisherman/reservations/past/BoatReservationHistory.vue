<template>
  <div>
    <b-table
      sort-icon-left
      bordered
      striped
      hover
      :items="reservations"
      :fields="fields"
      show-empty
      :empty-text="'No reservation history'"
    >
      <template v-slot:cell(additionalServices)="{ item }">
        <b-row class="m-0 p-2">
          <b-list-group v-if="item.additionalServices">
            <b-list-group-item
              v-for="(service, serviceId) in item.additionalServices"
              :key="serviceId"
              :service="service"
              class="d-flex justify-content-between align-items-center"
            >
              {{ service.name }} - {{ service.price }}$
            </b-list-group-item>
          </b-list-group>
        </b-row>
      </template>
      <template v-slot:cell(price)="{ item }">
        <b-row class="m-0 p-2"> {{ item.price }}$ </b-row>
      </template>
    </b-table>
  </div>
</template>

<script>
import { getAllPastBoatReservations } from "../../../../api";
export default {
  data() {
    return {
      reservations: [],
      fields: [
        {
          key: "beginning",
          label: "Beginning Date",
          class: "text-center",
          sortable: true,
        },
        {
          key: "ending",
          label: "Ending Date",
          class: "text-center",
          sortable: true,
        },
        {
          key: "participantsNum",
          label: "Guests Number",
          sortable: false,
        },
        {
          key: "price",
          label: "Price",
          sortable: true,
        },
        {
          key: "duration",
          label: "Duration (minutes)",
          sortable: true,
        },
        {
          key: "boat.name",
          label: "Adventure name",
          sortable: false,
        },
        {
          key: "additionalServices",
          label: "Additional Services",
          sortable: false,
        },
      ],
    };
  },
  computed: {},
  async mounted() {
    await this.fetchAllReservations();
  },
  methods: {
    async fetchAllReservations() {
      await getAllPastBoatReservations()
        .then((response) => {
          this.reservations = response;
        })
        .catch(() => {
          this.reservations = null;
        });
    },
  },
};
</script>

<style scoped>
::v-deep .sr-only {
  display: none !important;
}
</style>

