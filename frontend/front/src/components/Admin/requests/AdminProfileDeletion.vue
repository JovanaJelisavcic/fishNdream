<template>
  <div>
    <b-table
      bordered
      :items="items"
      :fields="fields"
      show-empty
      :empty-text="'No deletion requests'"
    >
      <template v-slot:cell(options)="{ item }">
        <b-row class="m-0 p-2">
          <b-button @click="showAcceptModal(item.requestId)" variant="success"
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
    <b-modal
      id="acceptModalAdmin"
      title="Accept request"
      @ok.prevent="acceptRegistration()"
    >
      <span>Explanation</span>
      <textarea class="w-100" v-model="acceptText"> </textarea>
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
      acceptText: null,
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
    showAcceptModal(requestId) {
      this.acceptText = null;
      this.requestId = requestId;
      this.$bvModal.show("acceptModalAdmin");
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
    async acceptRegistration() {
      await acceptAdminDeletionRequest({
        id: this.requestId,
        reason: this.acceptText,
      }).then(() => {
        this.requestId = null;
        this.acceptText = null;
        this.fetchRegisterRequests();
        this.$bvModal.hide("acceptModalAdmin");
      });
    },
    async fetchRegisterRequests() {
      await getAdminDeletionRequests()
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
