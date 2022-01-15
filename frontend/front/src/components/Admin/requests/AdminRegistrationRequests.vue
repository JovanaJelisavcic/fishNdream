<template>
  <div>
    <b-table
      bordered
      :items="items"
      :fields="fields"
      show-empty
      :empty-text="'No registration requests'"
    >
      <template v-slot:cell(options)="{ item }">
        <b-row class="m-0 p-2">
          <b-button @click="acceptRequest(item.email)" variant="success"
            >Accept</b-button
          >
        </b-row>
        <b-row class="m-0 p-2">
          <b-button @click="showRejectModal(item.email)" variant="danger"
            >Reject</b-button
          >
        </b-row>
      </template>
    </b-table>
    <b-modal
      id="rejectModal"
      title="Reject request"
      @ok.prevent="rejectRegistration()"
    >
      <span>Explanation</span>
      <textarea class="w-100" v-model="rejectText"> </textarea>
    </b-modal>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import {
  getRegisterRequests,
  rejectRegistration,
  acceptRegistration,
} from "../../../api";
export default {
  data() {
    return {
      rejectText: null,
      rejectEmail: null,
      fields: [
        {
          key: "email",
          label: "Email",
        },
        {
          key: "regType",
          label: "Registration type",
          class: "text-center",
        },
        {
          key: "explanation",
          label: "Description",
        },
        {
          key: "options",
          label: "Options",
        },
      ],
      items: [],
    };
  },
  computed: {
    rejectData: {
      ...mapGetters("adminRegistrationRequests", { get: "getRejectData" }),
    },
  },
  async mounted() {
    await this.fetchRegisterRequests();
  },
  methods: {
    showRejectModal(email) {
      this.rejectText = null;
      this.rejectEmail = email;
      this.$bvModal.show("rejectModal");
    },
    async rejectRegistration() {
      await rejectRegistration({
        email: this.rejectEmail,
        reason: this.rejectText,
      }).then(() => {
        this.rejectEmail = null;
        this.rejectText = null;
        this.fetchRegisterRequests();
        this.$bvModal.hide("rejectModal");
      });
    },
    async acceptRequest(email) {
      await acceptRegistration(email).then(() => {
        this.fetchRegisterRequests();
      });
    },
    async fetchRegisterRequests() {
      await getRegisterRequests()
        .then((response) => {
          this.items = response;
        })
        .catch(() => {
          alert(
            "Doslo je do greske prilikom dobavljanja zahteva za registraciju"
          );
        });
    },
  },
};
</script>

<style></style>
