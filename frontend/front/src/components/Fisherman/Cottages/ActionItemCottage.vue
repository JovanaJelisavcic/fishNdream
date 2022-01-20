<template>
  <div>
    <div class="right floated content">
      <button
        class="ui button purple resA-button"
        @click="reserveAction($event, action.reservationId)"
      >
        Reserve Promotion
      </button>
    </div>
    <div class="content">
      <b-row>
        <b-col>
          <h4>
            📅 {{ moment(action.beginning).format("YYYY-MM-DD") }} to
            {{ moment(action.ending).format("YYYY-MM-DD") }}<br />
          </h4>
          ONLY AVAILABLE UNTIL
          {{ moment(action.actionEndTime).format("YYYY-MM-DD HH:mm") }}
          <br />
          <h6>
            {{ action.price }}$ for {{ action.participantsNum }}👤 for
            {{ action.duration }} nights
          </h6>
          <small
            >{{ action.discount.toFixed(2) }}% discount from
            {{ action.originalPrice }}$</small
          >
        </b-col>
        <b-col>
          <div v-if="action.additionalServices">
            <div
              v-for="service in action.additionalServices"
              v-bind:key="service.serviceId"
            >
              {{ service.name }}
            </div>
          </div>
        </b-col>
      </b-row>
    </div>
  </div>
</template>


<script>
import { mapGetters } from "vuex";
import { reserveActionCottage, getActionsCottage, isStillFreeCottage } from "../../../api";
import moment from "moment";
export default {
  name: "ActionItemCottage",
  props: ["action"],
  data() {
    return {};
  },
  methods: {
    async reserveAction(e, reservationId) {
      await reserveActionCottage(reservationId)
        .then(() => {
          alert("Successfully reserved");
        })
        .catch(() => alert("You already canceled this reservation once"));

      await getActionsCottage(this.action.cottage.cottageId)
        .then((res) => this.$store.commit("cottages/setActionsRes", res))
        .catch(() => this.$store.commit("cottages/setActionsRes", null));
      if (this.beginDate != null) {
      
        let b = await isStillFreeCottage(
          this.action.cottage.cottageId,
          this.beginDate,
          this.endDate
        );
        this.$store.commit("cottages/setIsReservable", b);
      }
    },
    moment,
  },
  computed: {
    beginDate: {
      ...mapGetters("cottages", { get: "getBeginDate" }),
    },
    endDate: {
      ...mapGetters("cottages", { get: "getEndDate" }),
    },
  },
};
</script>


<style scoped>
.resA-button {
  margin-right: 100px;
}
</style>