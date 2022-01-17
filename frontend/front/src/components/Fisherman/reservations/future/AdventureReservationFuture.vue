<template>
  <div class="content">
    <b-table
      sort-icon-left
      bordered
      striped
      hover
      :items="reservations"
      :fields="fields"
      show-empty
      :empty-text="'No future reservations'"
    >
      <template v-slot:cell(options)="{ item }">
        <b-row class="m-0 p-2">
          <b-button
            @click="cancel(item.reservationId, item.actionRes)"
            variant="danger"
            >Cancel</b-button
          >
        </b-row>
      </template>
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
import {
  getAllFutureAdventureReservations,
  cancelResAvdenture,
  cancelActionResAvdenture,
} from "../../../../api";
export default {
  data() {
    return {
      reservations: [],
      reservationId: null,
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
          key: "adventure.name",
          label: "Adventure name",
          sortable: false,
        },
        {
          key: "additionalServices",
          label: "Additional Services",
          sortable: false,
        },
        {
          key: "options",
          label: "Options",
          class: "text-center",
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
      await getAllFutureAdventureReservations()
        .then((response) => {
          this.reservations = response;
        })
        .catch(() => {
          this.reservations = null;
        });
    },
    async cancel(reservationId, actionRes) {
      if (actionRes) {
        await cancelActionResAvdenture(reservationId)
          .then(() => {
            alert("Canceled successfully");
            this.fetchAllReservations();
          })
          .catch(() => {
            alert("You can't cancel less then 3 days before reservation");
          });
      } else {
        await cancelResAvdenture(reservationId)
          .then(() => {
            alert("Canceled successfully");
            this.fetchAllReservations();
          })
          .catch(() => {
            alert("You can't cancel less then 3 days before reservation");
          });
      }
    },
  },
};
</script>

<style scoped>
::v-deep .sr-only {
  display: none !important;
}
</style>