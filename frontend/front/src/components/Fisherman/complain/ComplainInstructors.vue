<template>
  <div>
    <b-table
      bordered
      :items="items"
      :fields="fields"
      show-empty
      :empty-text="'No instructors you can complain about'"
    >
      <template v-slot:cell(options)="{ item }">
        <b-row class="m-0 p-2">
          <b-button @click="showComplainModalInstructor(item.email)" variant="success"
            >Complain</b-button
          >
        </b-row>
      </template>
    </b-table>
    <b-modal
      id="complainModalInstructor"
      title="Complain"
      @ok.prevent="complainInstructor()"
    >
      <span>Write your complaint</span>
      <textarea class="w-100" v-model="complaintText"> </textarea>
    </b-modal>
  </div>
</template>

<script>
import {
  getPossibleInstructorsComplain,
  complainInstructor,
} from "../../../api";
export default {
  data() {
    return {
      complaintText: null,
      email: null,
      fields: [
        {
          key: "email",
          label: "Email",
        },
        {
          key: "name",
          label: "Name",
          class: "text-center",
        },
        {
          key: "surname",
          label: "Surname",
          class: "text-center",
        },
        {
          key: "shortBio",
          label: "Bio",
          class: "text-center",
        },
        {
          key: "rating",
          label: "Rating",
          class: "text-center",
        },
        {
          key: "options",
          label: "Options",
          class: "text-center",
        },
      ],
      items: [],
    };
  },
  async mounted() {
    await this.fetchPossible();
  },
  methods: {
    showComplainModalInstructor(email) {
      this.complaintText = null;
      this.email = email;
      this.$bvModal.show("complainModalInstructor");
    },
    async complainInstructor() {
      await complainInstructor({
        email: this.email,
        reason: this.complaintText,
      }).then(() => {
        this.email = null;
        this.complaintText = null;
        this.fetchPossible();
        this.$bvModal.hide("complainModalInstructor");
      });
    },
    async fetchPossible() {
      await getPossibleInstructorsComplain()
        .then((response) => {
          this.items = response;
        })
        .catch(() => {
          this.items = null;
        });
    },
  },
};
</script>

<style></style>
