<template>
  <div>
    <b-table
      show-empty
      :empty-text="'There are no instructors'"
      bordered
      striped
      hover
      :items="instructors"
      :fields="fields"
    >
      <template v-slot:cell(options)="{ item }">
        <b-row class="m-0 p-2">
          <b-button @click="deleteInstructor(item.email)" variant="danger"
            >Delete</b-button
          >
        </b-row>
      </template>
      <template v-slot:cell(rating)="{ item }">
        <b-row class="m-0 p-2"> {{ item.rating }} ⭐ </b-row>
      </template>
    </b-table>
  </div>
</template>

<script>
import { deleteInstructorByID } from "../../../api";
export default {
  props: ["instructors"],
  data() {
    return {
      email: null,
      fields: [
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
  methods: {
    async deleteInstructor(email) {
      await deleteInstructorByID(email)
        .then(() => {
          alert("Successfull deletion");
          this.$emit("instructorDeleted");
        })
        .catch(() => {
          alert("You can't delete entity with future reservations");
        });
    },
  },
};
</script>

<style></style>
