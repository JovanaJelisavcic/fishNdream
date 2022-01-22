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
            📅 {{ moment(action.beginning).format("YYYY-MM-DD HH:mm") }} to
            {{ moment(action.ending).format("YYYY-MM-DD HH:mm") }}<br />
          </h4>
          ONLY AVAILABLE UNTIL
          {{ moment(action.actionEndTime).format("YYYY-MM-DD HH:mm") }}
          <br />
          <h6>
            {{ action.price }}$ for {{ action.participantsNum }}👤 for
            {{ action.duration }} minutes
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
import { reserveActionBoat, getActionsBoat, isStillFreeBoat } from "../../../api";
import moment from "moment";
export default {
  name: "ActionItemBoat",
  props: ["action"],
  data() {
    return {};
  },
  methods: {
    async reserveAction(e, reservationId) {
      await reserveActionBoat(reservationId)
        .then(() => {
          alert("Successfully reserved");
        })
        .catch(() => alert("You already canceled this reservation once"));

      await getActionsBoat(this.action.boat.boatId)
        .then((res) => this.$store.commit("boats/setActionsRes", res))
        .catch(() => this.$store.commit("boats/setActionsRes", null));

      if (this.beginDate != null) {
        let b = await isStillFreeBoat(
          this.action.boat.boatId,
          this.beginDate,
          this.endDate
        );
        this.$store.commit("boats/setIsReservable", b);
      }
    },
    moment,
  },
  computed: {
    beginDate: {
      ...mapGetters("boats", { get: "getBeginDate" }),
    },
    endDate: {
      ...mapGetters("boats", { get: "getEndDate" }),
    },
  },
};
</script>


<style scoped>
.resA-button {
  margin-right: 100px;
}
</style>