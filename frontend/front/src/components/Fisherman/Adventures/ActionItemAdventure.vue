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
import {
  getActionsAdventure,
  reserveActionAdventure,
  isStillFreeAdventure,
} from "../../../api";
import moment from "moment";
export default {
  name: "ActionItemAdventure",
  props: ["action"],
  data() {
    return {};
  },
  methods: {
    async reserveAction(e, reservationId) {
      await reserveActionAdventure(reservationId)
        .then(() => {
          alert("Successfully reserved");
        })
        .catch(() => alert("You already canceled this reservation once"));

      await getActionsAdventure(this.action.adventure.adventureId)
        .then((res) => this.$store.commit("adventures/setActionsRes", res))
        .catch(() => this.$store.commit("adventures/setActionsRes", null));

      if (this.beginDate != null) {
        let b = await isStillFreeAdventure(
          this.action.adventure.adventureId,
          this.beginDate,
          this.endDate
        );
        this.$store.commit("adventures/setIsReservable", b);
      }
    },
    moment,
  },
  computed: {
    beginDate: {
      ...mapGetters("adventures", { get: "getBeginDate" }),
    },
    endDate: {
      ...mapGetters("adventures", { get: "getEndDate" }),
    },
  },
};
</script>


<style scoped>
.resA-button {
  margin-right: 100px;
}
</style>