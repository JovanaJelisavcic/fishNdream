<template>
  <div>
          <b-table bordered striped hover :items="reports" :fields="fields"></b-table>
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
          key: "percentageActive" ,
          label: "Active percentage",
        },
      ],
    };
  },
  computed: {},
  async mounted() {
    await this.fetchAllReports();
  },
  methods: {
    async fetchAllReports() {
      await getAllReportsForAdmin()
        .then((response) => {
          this.reports = response;
        })
        .catch(() => {
          alert(
            "Error has been made. Please check your credentials again"
          );
        });
    },
  },
};
</script>

<style></style>
