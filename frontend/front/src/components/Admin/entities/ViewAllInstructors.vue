<template>
  <div>
      <b-table bordered striped hover :items="instructors" :fields="fields" >
         <template v-slot:cell(options)="{ item }">
        <b-row class="m-0 p-2">
          <b-button @click="deleteInstructor(item.email)" variant="danger"
            >Delete</b-button
          >
        </b-row>
      
      </template>
      </b-table>
  </div>
</template>

<script>
import { getAllInstructors,deleteInstructorByID } from "../../../api";
export default {
  data() {
    return {
      instructors: [],
      email:null,
       fields:[
        {
          key: "address",
          label: "Address",
        },
        {
          key: "city",
          label: "City",
        },
        {
          key: "email",
          label: "Email",
        },
        {
          key: "name",
          label: "Name",
        },
        {
          key: "phoneNum",
          label: "Number",
        },
        {
          key: "rating",
          label: "Rating",
        },
        {
          key: "shortBio",
          label: "Biography",
        },
        {
          key: "state",
          label: "State",
        },
        {
          key: "surname",
          label: "Surname",
        },
        {
          key: "options",
          label: "Options",
        },
      ],
       
    };
  },
  computed: {},
  async mounted() {
    await this.fetchAllInstructors();
  },
  methods: {
    async fetchAllInstructors() {
      await getAllInstructors()
        .then((response) => {
          this.instructors = response;
        })
        .catch(() => {

        });
    },
      async deleteInstructor(email) {
      await deleteInstructorByID(email).then(() => {
        this.fetchAllInstructors();
      });
    },
  },
};
</script>

<style></style>
