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
      id="rejectModalUser"
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
  getUserDeletionRequests,
  acceptUserDeletionRequest,
  rejectUserDeletionRequest,
} from "../../../api";
export default {
  data() {
    return {
      rejectText: null,
      requestId: null,
      fields: [
        {
          key: "fisherman.email",
          label: "Email",
          class: "text-center",
        },
        {
          key: "fisherman.name",
          label: "Name",
          class: "text-center",
        },
        {
          key: "fisherman.surname",
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
      this.$bvModal.show("rejectModalUser");
    },
    async rejectRegistration() {
      await rejectUserDeletionRequest({
        requestId: this.requestId,
        reason: this.rejectText,
      }).then(() => {
        this.requestId = null;
        this.rejectText = null;
        this.fetchRegisterRequests();
        this.$bvModal.hide("rejectModalUser");
      });
    },
    async acceptRequest(requestId) {
      await acceptUserDeletionRequest(requestId).then(() => {
        this.fetchRegisterRequests();
      });
    },
    async fetchRegisterRequests() {
      await getUserDeletionRequests()
        .then((response) => {
          this.items = response;
        })
        .catch(() => {
        });
    },
  },
};
</script>

<style></style>
