<template>
  <b-tabs>
    <b-tab title="Admin information" active>
      <b-form-group label="Email address:" label-for="email">
        <b-form-input
          disabled
          id="email"
          v-model="form.email"
          type="email"
          placeholder="Email"
          required
        ></b-form-input>
      </b-form-group>
      <b-form-group label="Name :" label-for="name">
        <b-form-input
          id="name"
          v-model="form.name"
          placeholder="Name"
          required
        ></b-form-input>
      </b-form-group>
      <b-form-group label="Surname :" label-for="surname">
        <b-form-input
          id="surname"
          v-model="form.surname"
          placeholder="Surname"
          required
        ></b-form-input>
      </b-form-group>
      <b-form-group label="Address :" label-for="address">
        <b-form-input
          id="address"
          v-model="form.address"
          placeholder="Address"
          required
        ></b-form-input>
      </b-form-group>
      <b-form-group label="City :" label-for="city">
        <b-form-input
          id="city"
          v-model="form.city"
          placeholder="City"
          required
        ></b-form-input>
      </b-form-group>
      <b-form-group label="State :" label-for="state">
        <b-form-input
          id="state"
          v-model="form.state"
          placeholder="State"
          required
        ></b-form-input>
      </b-form-group>
      <b-form-group label="Phone number :" label-for="number">
        <b-form-input
          id="number"
          v-model="form.phoneNum"
          placeholder="Phone number"
          required
        ></b-form-input>
      </b-form-group>
      <b-button class="mt-3" @click="onSubmit()" variant="primary"
        >Submit changes</b-button
      >
      <div style="float: right; width: 15%">
        <b-button
          class="mt-3"
          @click="showDeleteAdminProfileModal()"
          variant="danger"
          >Delete admin profile</b-button
        >
        <b-modal
          id="deleteAdminProfile"
          title="Delete your admin profile"
          @ok.prevent="onAdminDelete()"
        >
          <span>Explanation</span>
          <textarea class="w-100" v-model="rejectText"> </textarea>
        </b-modal>
      </div>
    </b-tab>
    <b-tab title="Change password" active>
      <form @submit.prevent="changePassword">
        <b-form-group label="Current password:">
          <b-form-input
            style="width: 30%"
            placeholder="Current password"
            name="password"
            v-model="password"
            type="password"
          >
          </b-form-input>
        </b-form-group>

        <b-form-group label="New password:">
          <b-form-input
            style="width: 30%"
            placeholder="New password"
            name="newPassword"
            v-model="newPassword"
             type="password"
          ></b-form-input>
        </b-form-group>

        <b-form-group label="Confirm new password:">
          <b-form-input
            style="width: 30%"
            placeholder="Confirm new password"
             type="password"
            name="confirmPassword"
            v-model="repeatPassword"
          ></b-form-input>
        </b-form-group>

        <b-button class="mt-3 btn btn-danger" type="submit">
          Update password
        </b-button>
      </form>
    </b-tab>
    <b-tab title="Change gain percentage" active>
      <b-form-group label="New percentage:" label-for="gainPercentage">
        <b-form-input
          style="width: 30%"
          id="gainPercentage"
          v-model="gainPercentage"
          type="number"
          placeholder="Enter new percentage"
          required
        ></b-form-input>
        <b-button class="mt-3" @click="onNewGainPercentage()" variant="primary"
          >Change percentage</b-button
        >
      </b-form-group>
    </b-tab>
  </b-tabs>
</template>

<script>
import {
  getAdminData,
  updateAdminData,
  changeSystemGain,
  deleteAdminProfile,
} from "../../api";
import axios from "axios";
export default {
  data() {
    return {
      form: {
        email: null,
        name: null,
        surname: null,
        address: null,
        city: null,
        state: null,
        phoneNum: null,
      },
      password: null,
      newPassword: null,
      repeatPassword: null,
      gainPercentage: null,
      rejectText: null,
    };
  },
  async mounted() {
    await this.fetchAdminData();
  },
  computed: {},

  methods: {
    showDeleteAdminProfileModal() {
      this.rejectText = null;
      this.$bvModal.show("deleteAdminProfile");
    },
    async onSubmit() {
      await updateAdminData(this.form)
        .then(() => {
          this.fetchAdminData();
        })
        .catch(() => {
          alert("An error has occured while fetching admin data");
        });
    },
    async onAdminDelete() {
      await deleteAdminProfile({ reason: this.rejectText })
        .then(() => {
          this.rejectText = null;
          this.fetchAdminData();
          this.$bvModal.hide("deleteAdminProfile");
          alert("Your deletion request was succesfully sent. You'll receive response on you mail.");
        })
        .catch(() => {
          alert("You already filed a request");
        });
    },

    async onNewGainPercentage() {
      await changeSystemGain({ newPrc: this.gainPercentage })
        .then(() => {
          alert("Gain percentage is changed!");
          this.gainPercentage = "";
        })
        .catch(() => {
          alert("An error has occured while fetching admin data");
          this.gainPercentage = "";
        });
    },
    async fetchAdminData() {
      await getAdminData()
        .then((response) => {
          const { email, name, surname, address, city, state, phoneNum } =
            response;
          this.form.email = email;
          this.form.name = name;
          this.form.surname = surname;
          this.form.address = address;
          this.form.city = city;
          this.form.state = state;
          this.form.phoneNum = phoneNum;
        })
        .catch(() => {
          alert("An error has occured while fetching admin data");
        });
    },
    changePassword() {
      axios
        .post(`/register/changePassword`, {
          password: this.newPassword,
          oldPassword: this.password,
          confirmPassword: this.repeatPassword,
        })
        .then(() => {
          this.password = "";

          alert(
            "Password has been successfully changed! Please login again with your new password."
          );

          this.$store.dispatch("login/logout");
          this.$router.push("/login");
        })
        .catch(() => {
          // clear form inputs
          this.password = this.newPassword = this.repeatPassword = "";
          alert("Please try again.");
        });
    },
  },
};
</script>

<style scoped>
a.nav-link {
  color: #8c55aa !important;
  font-weight: bold;
}
</style>
