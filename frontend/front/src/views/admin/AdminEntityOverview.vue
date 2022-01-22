<template>
  <b-tabs>
    <b-tab title="Boats" active>
      <ViewAllBoats @boatDeleted="onBoatDeleted" :boats="boats"></ViewAllBoats>
    </b-tab>
    <b-tab title="Boat Owners" active>
      <ViewAllBoatOwners
        @boatOwnerDeleted="onBoatOwnerDeleted"
        :boatOwners="boatOwners"
      ></ViewAllBoatOwners>
    </b-tab>
    <b-tab title="Cottages" active>
      <ViewAllCottages
        @cottageDeleted="onCottageDeleted"
        :cottages="cottages"
      ></ViewAllCottages>
    </b-tab>
    <b-tab title="Cottage Owners" active>
      <ViewAllCottageOwners
        @cottageOwnerDeleted="onCottageOwnerDeleted"
        :cottageOwners="cottageOwners"
      ></ViewAllCottageOwners>
    </b-tab>
    <b-tab title="Fisherman" active>
      <ViewAllFisherman
        @fishermanDeleted="onFishermanDeleted"
        :fisherman="fisherman"
      ></ViewAllFisherman>
    </b-tab>
    <b-tab title="Adventures" active>
      <ViewAllAdventures
        @adventureDeleted="onAdventureDeleted"
        :adventures="adventures"
      ></ViewAllAdventures>
    </b-tab>
    <b-tab title="Instructors" active>
      <ViewAllInstructors
        @instructorDeleted="onInstructorDeleted"
        :instructors="instructors"
      ></ViewAllInstructors>
    </b-tab>
  </b-tabs>
</template>

<script>
import ViewAllBoats from "../../components/Admin/entities/ViewAllBoats.vue";
import ViewAllCottages from "../../components/Admin/entities/ViewAllCottages.vue";
import ViewAllBoatOwners from "../../components/Admin/entities/ViewAllBoatOwners.vue";
import ViewAllCottageOwners from "../../components/Admin/entities/ViewAllCottageOwners.vue";
import ViewAllFisherman from "../../components/Admin/entities/ViewAllFisherman.vue";
import ViewAllAdventures from "../../components/Admin/entities/ViewAllAvantures.vue";
import ViewAllInstructors from "../../components/Admin/entities/ViewAllInstructors.vue";
import {allBoatsAdmin, allCottagesAdmin, getAllFisherman, getAllBoatOwners, getAllCottageOwners, getAllAdvantures, getAllInstructors} from "../../api"
export default {
  data() {
    return {
      adventures: null,
      boats: null,
      boatOwners: null,
      instructors: null,
      cottages: null,
      cottageOwners: null,
      fisherman: null,
    };
  },
  components: {
    ViewAllBoats,
    ViewAllCottages,
    ViewAllBoatOwners,
    ViewAllCottageOwners,
    ViewAllFisherman,
    ViewAllAdventures,
    ViewAllInstructors,
  },
  methods: {
    async fetchAllInstructors() {
      await getAllInstructors()
        .then((response) => {
          this.instructors = response;
        })
        .catch(() => {});
    },
    async fetchAllFisherman() {
      await getAllFisherman()
        .then((response) => {
          this.fisherman = response;
        })
        .catch(() => {
          this.fisherman = null;
        });
    },
    async fetchAllCottages() {
      await allCottagesAdmin()
        .then((response) => {
          this.cottages = response;
        })
        .catch(() => {
          this.cottages = null;
        });
    },
    async fetchAllCottageOwners() {
      await getAllCottageOwners()
        .then((response) => {
          this.cottageOwners = response;
        })
        .catch(() => {
          this.cottageOwners = null;
        });
    },
    async fetchAllBoats() {
      await allBoatsAdmin()
        .then((response) => {
          this.boats = response;
        })
        .catch(() => {
          this.boats = null;
        });
    },
    async fetchAllBoatOwners() {
      await getAllBoatOwners()
        .then((response) => {
          this.boatOwners = response;
        })
        .catch(() => {
          this.boatOwners = null;
        });
    },
    async fetchAllAdventures() {
      await getAllAdvantures()
        .then((response) => {
          this.adventures = response;
        })
        .catch(() => {
          this.adventures = null;
        });
    },
    onBoatDeleted() {
      this.fetchAllBoats();
    },
    onCottageDeleted() {
      this.fetchAllCottages();
    },
    onBoatOwnerDeleted() {
      this.fetchAllBoatOwners();
      this.fetchAllBoats();
    },
    onCottageOwnerDeleted() {
      this.fetchAllCottageOwners();
      this.fetchAllCottages();
    },
    onFishermanDeleted() {
      this.fetchAllFisherman();
    },
    onInstructorDeleted() {
      this.fetchAllAdventures();
      this.fetchAllInstructors();
    },
    onAdventureDeleted() {
      this.fetchAllAdventures();
    },
  },
  async mounted() {
    await this.fetchAllAdventures();
    await this.fetchAllBoatOwners();
    await this.fetchAllBoats();
    await this.fetchAllCottageOwners();
    await this.fetchAllCottages();
    await this.fetchAllFisherman();
    await this.fetchAllInstructors();
  },
};
</script>

<style></style>
