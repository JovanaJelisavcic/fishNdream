<template>
    <div>
    <b-tabs>
      <b-tab title="History" active>
            <b-tabs class="mt-3">
          <b-tab title="Cottage" active>
            <CottageReservationsHistory></CottageReservationsHistory>
          </b-tab>
          <b-tab title="Boats">
            <BoatReservationsHistory></BoatReservationsHistory>
          </b-tab>
            <b-tab title="Adventures">
            <AdventureReservationsHistory></AdventureReservationsHistory>
          </b-tab>
        </b-tabs>
      </b-tab>
      <b-tab title="Future">
        <b-tabs class="mt-3">
          <b-tab title="Cottage" active>
            <CottageReservationsFuture></CottageReservationsFuture>
          </b-tab>
          <b-tab title="Boats">
            <BoatReservationsFuture></BoatReservationsFuture>
          </b-tab>
            <b-tab title="Adventures">
            <AdventureReservationsFuture></AdventureReservationsFuture>
          </b-tab>
        </b-tabs>
      </b-tab>
    </b-tabs>
  </div>
</template>

<script>
import CottageReservationsFuture from "../../components/Fisherman/reservations/future/CottageReservationFuture.vue"
import CottageReservationsHistory from "../../components/Fisherman/reservations/past/CottageReservationHistory.vue"
import BoatReservationsFuture from "../../components/Fisherman/reservations/future/BoatReservationFuture.vue"
import BoatReservationsHistory from "../../components/Fisherman/reservations/past/BoatReservationHistory.vue"
import AdventureReservationsFuture from "../../components/Fisherman/reservations/future/AdventureReservationFuture.vue"
import AdventureReservationsHistory from "../../components/Fisherman/reservations/past/AdventureReservationHistory.vue"

export default {
    name: "MyReservations",
    components:{
      CottageReservationsHistory,
      AdventureReservationsFuture,
      BoatReservationsFuture,
      CottageReservationsFuture,
      AdventureReservationsHistory,
      BoatReservationsHistory

    }
}
</script>