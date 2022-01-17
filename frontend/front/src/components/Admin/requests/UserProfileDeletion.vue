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
      id="rejectModalUser"
      title="Reject request"
      @ok.prevent="rejectRegistration()"
    >
      <span>Explanation</span>
      <textarea class="w-100" v-model="rejectText"> </textarea>
    </b-modal>
      <b-modal
      id="acceptModalUser"
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
  getUserDeletionRequests,
  acceptUserDeletionRequest,
  rejectUserDeletionRequest,
} from "../../../api";
export default {
  data() {
    return {
      rejectText: null,
      acceptText: null,
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
    await this.fetchRegisterRequests();
  },
  methods: {
    showRejectModal(requestId) {
      this.rejectText = null;
      this.requestId = requestId;
      this.$bvModal.show("rejectModalUser");
    },
    showAcceptModal(requestId) {
      this.acceptText = null;
      this.requestId = requestId;
      this.$bvModal.show("acceptModalUser");
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
    async acceptRegistration() {
      await acceptUserDeletionRequest({
        id: this.requestId,
        reason: this.acceptText,
      }).then(() => {
        this.requestId = null;
        this.acceptText = null;
        this.fetchRegisterRequests();
        this.$bvModal.hide("acceptModalUser");
      }).catch(()=>{
        this.requestId = null;
        this.acceptText = null;
        this.$bvModal.hide("acceptModalUser");
        alert("User still has reservation, it is not recommended to allow deletion!");
      });
    },
    async fetchRegisterRequests() {
      await getUserDeletionRequests()
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
