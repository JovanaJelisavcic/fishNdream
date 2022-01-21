<template>
  <div>
    <h1>Reservation Details</h1>
    id: {{ this.id }} name: {{ this.name }} begin : {{ this.begin }} endtime :
    {{ this.end }} numofpeople : {{ this.people }} regType :
    {{ this.regType }} total price; {{ this.totalPrice }}
    <div>
      <b-form-group
        label="Number of guests:"
        label-for="guests-number"
        label-cols-md="4"
        description=" 0 will be considered as maximum capacity"
      >
        <input
          id="guests-number"
          v-model="chosenPeople"
          type="number"
          class="mb-3"
          :max="people"
          :min="0"
        />
      </b-form-group>
      <b-form-group
        label="Search Additional Services:"
        label-for="services-search"
        label-cols-md="4"
      >
        <b-form-input
          id="services-search"
          v-model="criteria"
          class="mb-3"
          @input="searchServices"
        ></b-form-input>
      </b-form-group>
      <b-table
        :items="options"
        :fields="fields"
        responsive="sm"
        ref="selectableTable"
        selectable
        @row-selected="onRowSelected"
      >
        <template #cell(selected)="{ rowSelected }">
          <template v-if="rowSelected">
            <span aria-hidden="true">&check;</span>
            <span class="sr-only">Selected</span>
          </template>
          <template v-else>
            <span aria-hidden="true">&nbsp;</span>
            <span class="sr-only">Not selected</span>
          </template>
        </template>
      </b-table>
    </div>
    <b-button @click="confirmRes">Confirm Reservation</b-button>
    <b-button @click="giveUp">Give up</b-button>
  </div>
</template>

<script>
import {
  getAllCottageServices,
  searchCottageServices,
  reserveCottage,
  getAllBoatServices,
  searchBoatServices,
  reserveBoat,
  getAllAdventureServices,
  searchAdventureServices,
  reserveAdventure,
} from "../../api";
export default {
  name: "ReservationPage",
  props: ["id", "name", "begin", "end", "regType", "people", "price", "guests"],
  data() {
    return {
      fields: ["selected", "serviceId", "name", "price"],
      selected: [],
      options: [],
      services: null,
      criteria: "",
      chosenPeople: this.guests,
      totalPrice: 0,
    };
  },
  methods: {
    giveUp() {
      if (this.regType == "COTTAGE") {
        this.$router.push("/fisher/explore/cottages");
      } else if (this.regType == "BOAT") {
        this.$router.push("/fisher/explore/boats");
      } else if (this.regType == "ADVENTURE") {
        this.$router.push("/fisher/explore/instructors");
      }
    },
    confirmRes() {
      let chosenServices = [];
      for (var i = 0; i < this.selected.length; i++) {
        chosenServices.push(this.selected[i].serviceId);
      }
      if (this.regType == "COTTAGE") {
        this.callCottage(chosenServices);
      } else if (this.regType == "BOAT") {
        this.callBoat(chosenServices);
      } else if (this.regType == "ADVENTURE") {
        this.callAdventure(chosenServices);
      }
    },
    async callAdventure(chosenServices) {
      var bsa = this.begin.split("T");
      var beginning = bsa[0] + " " + bsa[1] + ":00";
      bsa = this.end.split("T");
      var ending = bsa[0] + " " + bsa[1] + ":00";
      await reserveAdventure({
        beginning: beginning,
        ending: ending,
        participantsNum: this.chosenPeople,
        entityId: this.id,
        servicesIds: chosenServices,
      })
        .then(() => {
          alert("Reservation successfull!");
          this.$router.push("/fisher/myreservations");
        })
        .catch(() =>
          alert(
            "Entity already had been reserved and canceled by this user for this period. We suggest you change reservation period "
          )
        );
    },
    async callBoat(chosenServices) {
      var bsa = this.begin.split("T");
      var beginning = bsa[0] + " " + bsa[1] + ":00";
      bsa = this.end.split("T");
      var ending = bsa[0] + " " + bsa[1] + ":00";
      await reserveBoat({
        beginning: beginning,
        ending: ending,
        participantsNum: this.chosenPeople,
        entityId: this.id,
        servicesIds: chosenServices,
      })
        .then(() => {
          alert("Reservation successfull!");
          this.$router.push("/fisher/myreservations");
        })
        .catch(() =>
          alert(
            "Entity already had been reserved and canceled by this user for this period. We suggest you change reservation period "
          )
        );
    },
    async callCottage(chosenServices) {
      var bsa = this.begin.split("T");
      var beginning = bsa[0] + " " + bsa[1] + ":00";
      bsa = this.end.split("T");
      var ending = bsa[0] + " " + bsa[1] + ":00";
      await reserveCottage({
        beginning: beginning,
        ending: ending,
        participantsNum: this.chosenPeople,
        entityId: this.id,
        servicesIds: chosenServices,
      })
        .then(() => {
          alert("Reservation successfull!");
          this.$router.push("/fisher/myreservations");
        })
        .catch(() =>
          alert(
            "Entity already had been reserved and canceled by this user for this period. We suggest you change reservation period "
          )
        );
    },
    searchServices() {
      if (this.regType == "COTTAGE") {
        this.serachCottage();
      } else if (this.regType == "BOAT") {
        this.searchBoat();
      } else if (this.regType == "ADVENTURE") {
        this.searchAdventure();
      }
    },
    async searchAdventure() {
      await searchAdventureServices({
        id: this.id,
        criteria: this.criteria,
      })
        .then((res) => (this.services = res))
        .catch(() => {this.services = null});
      this.setServices();
    },
    async searchBoat() {
      var bsa = this.begin.split("T");
      var beginning = bsa[0] + " " + bsa[1] + ":00";
      bsa = this.end.split("T");
      var ending = bsa[0] + " " + bsa[1] + ":00";
      await searchBoatServices({
        id: this.id,
        criteria: this.criteria,
        begin: beginning,
        end: ending,
      })
        .then((res) => (this.services = res))
        .catch(() => (this.services = null));
      this.setServices();
    },
    async serachCottage() {
      await searchCottageServices({
        id: this.id,
        criteria: this.criteria,
      })
        .then((res) => (this.services = res))
        .catch(() => (this.services = null));
      this.setServices();
    },
    onRowSelected(items) {
      this.selected = items;
      for (var i = 0; i < items.length; i++) {
        this.totalPrice = parseInt(this.totalPrice) + parseInt(items[i].price);
      }
    },
    setServices() {
      if (this.services != null) {
        this.options = [];
        for (var i = 0; i < this.services.length; i++) {
          this.options.push({
            serviceId: this.services[i].serviceId,
            name: this.services[i].name,
            price: this.services[i].price,
          });
        }
      }else this.options=[];
      this.totalPrice= this.price;
    },
    async fetchAllServicesAdventure() {
      await getAllAdventureServices(this.id)
        .then((res) => (this.services = res))
        .catch(() => (this.services = null));
      this.setServices();
    },
    async fetchAllServicesBoat() {
      var bsa = this.begin.split("T");
      var beginning = bsa[0] + " " + bsa[1] + ":00";
      bsa = this.end.split("T");
      var ending = bsa[0] + " " + bsa[1] + ":00";
      await getAllBoatServices({
        begin: beginning,
        end: ending,
        id: this.id,
      })
        .then((res) => (this.services = res))
        .catch(() => (this.services = null));
      this.setServices();
    },
    async fetchAllServicesCottage() {
      await getAllCottageServices(this.id)
        .then((res) => (this.services = res))
        .catch(() => (this.services = null));
      this.setServices();
    },
  },
  async mounted() {
    if (this.regType == "COTTAGE") {
      this.fetchAllServicesCottage();
    } else if (this.regType == "BOAT") {
      this.fetchAllServicesBoat();
    } else if (this.regType == "ADVENTURE") {
      this.fetchAllServicesAdventure();
    }
    this.totalPrice=this.price;
  },
};
</script>

