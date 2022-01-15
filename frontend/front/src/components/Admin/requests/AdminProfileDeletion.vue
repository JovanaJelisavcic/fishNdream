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
          <b-button @click="acceptRequest(item.requestId)" variant="success"
            >Accept</b-button
          >
        </b-row>
        <b-row class="m-0 p-2">
          <b-button @click="showRejectModal(item.requestId)" variant="danger"
            >Reject</b-button
          >
        </b-row>
      </template>
    </b-table>
    <b-modal
      id="rejectModalAdmin"
      title="Reject request"
      @ok.prevent="rejectRegistration()"
    >
      <span>Explanation</span>
      <textarea class="w-100" v-model="rejectText"> </textarea>
    </b-modal>
  </div>
</template>

<script>
import {
  getAdminDeletionRequests,
  acceptAdminDeletionRequest,
  rejectAdminDeletionRequest,
} from "../../../api";
export default {
  data() {
    return {
      rejectText: null,
      requestId: null,
      fields: [
        {
          key: "admin.email",
          label: "Email",
          class: "text-center",
        },
        {
          key: "admin.name",
          label: "Name",
          class: "text-center",
        },
        {
          key: "admin.surname",
          label: "Surname",
          class: "text-center",
        },
        {
          key: "requestText",
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
  async mounted() {
    await this.fetchRegisterRequests();
  },
  methods: {
    showRejectModal(requestId) {
      this.rejectText = null;
      this.requestId = requestId;
      this.$bvModal.show("rejectModalAdmin");
    },
    async rejectRegistration() {
      await rejectAdminDeletionRequest({
        requestId: this.requestId,
        reason: this.rejectText,
      }).then(() => {
        this.requestId = null;
        this.rejectText = null;
        this.fetchRegisterRequests();
        this.$bvModal.hide("rejectModalAdmin");
      });
    },
    async acceptRequest(requestId) {
      await acceptAdminDeletionRequest(requestId).then(() => {
        this.fetchRegisterRequests();
      });
    },
    async fetchRegisterRequests() {
      await getAdminDeletionRequests()
        .then((response) => {
          this.items = response;
        })
        .catch(() => {
          alert("An error has occured while fetching deletion requests");
        });
    },
  },
};
</script>

<style></style>
