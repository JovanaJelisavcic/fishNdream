<template>
  <div>
    <div class="right floated content">
      <button
        v-if="showButton"
        class="ui button purple resA-button"
        @click="reserveAction($event, action.reservationId)"
      >
        Reserve Promotion
      </button>
        <p class="resA-button" v-if="showReserved">Reserved!</p>
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
          <h6>{{ action.price }}$ for {{ action.participantsNum }}👤  </h6>
          <small>{{action.discount}}% discount from {{action.originalPrice}}$</small>
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
import { isStillFreeCottage, reserveActionCottage } from "../../../api";
import moment from "moment";
export default {
  name: "ActionItemCottage",
  props: ["action"],
  data() {
    return {
        showButton: true,
        showReserved: false
    };
  },
  methods: {
    async reserveAction(e, reservationId) {
       await reserveActionCottage(reservationId);
      this.showReserved=true;
      this.showButton=false;
      if(this.beginDate!=null){
       let b= await isStillFreeCottage(this.action.cottage.cottageId,this.beginDate.toISOString(),this.endDate.toISOString());
           if(!b){
               this.$emit("notAvaiableAnymore");
           }
      }
     
    },
    moment,
  },
  computed:{
    beginDate: {
      ...mapGetters("cottages", { get: "getBeginDate" }),
    },
    endDate: {
      ...mapGetters("cottages", { get: "getEndDate" }),
    }
  }
};
</script>


<style scoped>
.resA-button {
  margin-right: 100px;
}
</style>