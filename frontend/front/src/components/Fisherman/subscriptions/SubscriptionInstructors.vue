<template>
  <div>
    <b-table bordered striped hover :items="subscriptions" :fields="fields"  show-empty
      :empty-text="'No subscriptions'">
      <template v-slot:cell(options)="{ item }">
        <b-row class="m-0 p-2">
          <b-button @click="unsubscribe(item.instructor.email)" variant="danger"
            >Unsubscribe</b-button
          >
        </b-row>
      </template>
    </b-table>
  </div>
</template>


<script>
import { getAllInstructorSubscriptions,unsubscribeInstructorByEmail } from "../../../api";
export default {
  data() {
    return {
      subscriptions: [],
      subscriptionId:null,
      fields:[
        {
          key: "instructor.name",
          label: "Name",
           class: "text-center",
        },
        {
          key: "instructor.surname",
          label: "Surname",
           class: "text-center",
        },
        {
          key: "instructor.city",
          label: "City",
           class: "text-center",
        },{
          key: "instructor.shortBio",
          label: "Bio",
           class: "text-center",
        },{
          key: "instructor.rating",
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
      await getAllInstructorSubscriptions()
        .then((response) => {
          this.subscriptions = response;
        })
        .catch(() => {
            this.subscriptions = null;
        });
    },
         async unsubscribe(boatId) {
      await unsubscribeInstructorByEmail(boatId).then(() => {
          alert("Unsubscribed successfully")
        this.fetchAllSubscriptions();
      });
    },
    
  },
};

</script>