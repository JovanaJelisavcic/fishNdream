<template>
  <div>
      TOTAL REVENUE = {{ this.total.toFixed(2) }}$ 
      <br>
    <b-table bordered striped hover :items="reports" :fields="fields">
      <template v-slot:cell(fishermanPrice)="{ item }">
        <b-row class="m-0 p-2"> {{ item.fishermanPrice }}$ </b-row>
      </template>
      <template v-slot:cell(revenue)="{ item }">
        <b-row class="m-0 p-2"> {{ item.revenue }}$ </b-row>
      </template>
      <template v-slot:cell(percentageActive)="{ item }">
        <b-row class="m-0 p-2"> {{ item.percentageActive }}% </b-row>
      </template>
    </b-table>
  
  </div>
</template>

<script>
import { getAllReportsForAdmin } from "../../api";
export default {
  data() {
    return {
      reports: [],
      fields: [
        {
          key: "revenueId",
          label: "Revenue ID",
        },
        {
          key: "reservationId",
          label: "Reservation ID",
          class: "text-center",
        },
        {
          key: "resType",
          label: "Reservation Type",
        },
        {
          key: "fishermanPrice",
          label: "Fisherman Price",
        },
        {
          key: "revenue",
          label: "Revenue",
        },
        {
          key: "percentageActive",
          label: "Active percentage",
        },
      ],
    };
  },
  computed: {
    total() {
      let res = 0;
      for (let step = 0; step < this.reports.length; step++) {
        res += this.reports[step].revenue;
      }
      return res;
    },
  },
  async mounted() {
    await this.fetchAllReports();
  },
  methods: {
    async fetchAllReports() {
      await getAllReportsForAdmin()
        .then((response) => {
          this.reports = response;
        })
        .catch(() => {});
    },
  },
};
</script>

<style></style>
