<template>
  <div class="content">
    <b-table bordered striped hover :items="subscriptions" :fields="fields"  show-empty
      :empty-text="'No subscriptions'">
      <template v-slot:cell(options)="{ item }">
        <b-row class="m-0 p-2">
          <b-button @click="unsubscribe(item.boat.boatId)" variant="danger"
            >Unsubscribe</b-button
          >
        </b-row>
      </template>
    </b-table>
  </div>
</template>


<script>
import { getAllBoatSubscriptions,unsubscribeBoatByID } from "../../../api";
export default {
  data() {
    return {
      subscriptions: [],
      subscriptionId:null,
      fields:[
        {
          key: "boat.name",
          label: "Name",
           class: "text-center",
        },
        {
          key: "boat.address",
          label: "Address",
           class: "text-center",
        },
        {
          key: "boat.description",
          label: "Description",
           class: "text-center",
        },
        {
          key: "boat.rating",
          label: "Rating",
           class: "text-center",
        },
        {
          key: "options",
          label: "Options",
           class: "text-center",
        },
      ],
       

       
    };
  },
  computed: {},
  async mounted() {
    await this.fetchAllSubscriptions();
  },
  methods: {
    async fetchAllSubscriptions() {
      await getAllBoatSubscriptions()
        .then((response) => {
          this.subscriptions = response;
        })
        .catch(() => {
            this.subscriptions=null;
        });
    },
         async unsubscribe(boatId) {
      await unsubscribeBoatByID(boatId).then(() => {
          alert("Unsubscribed successfully")
        this.fetchAllSubscriptions();
      });
    },
    
  },
};

</script>