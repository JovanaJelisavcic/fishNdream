<template>
  <b-tabs>
    <b-tab title="Fisher information" active>
        <b-form-group label="Penalties:" label-for="penalties">
        <b-form-input
          disabled
          id="penalties"
          v-model="form.penalties"
        ></b-form-input>
      </b-form-group>
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
      <b-form-group
        :class="{ error: validation.hasError('form.name') }"
        label="Name :"
        label-for="name"
      >
        <b-form-input
          id="name"
          v-model="form.name"
          placeholder="Name"
          required
        ></b-form-input>
        <div class="message">{{ validation.firstError("form.name") }}</div>
      </b-form-group>
      <b-form-group
        :class="{ error: validation.hasError('form.surname') }"
        label="Surname :"
        label-for="surname"
      >
        <b-form-input
          id="surname"
          v-model="form.surname"
          placeholder="Surname"
          required
        ></b-form-input>
        <div class="message">{{ validation.firstError("form.surname") }}</div>
      </b-form-group>
      <b-form-group
        :class="{ error: validation.hasError('form.address') }"
        label="Address :"
        label-for="address"
      >
        <b-form-input
          id="address"
          v-model="form.address"
          placeholder="Address"
          required
        ></b-form-input>
        <div class="message">
          {{ validation.firstError("form.address") }}
        </div>
      </b-form-group>
      <b-form-group
        :class="{ error: validation.hasError('form.city') }"
        label="City :"
        label-for="city"
      >
        <b-form-input
          id="city"
          v-model="form.city"
          placeholder="City"
          required
        ></b-form-input>
        <div class="message">{{ validation.firstError("form.city") }}</div>
      </b-form-group>
      <b-form-group
        :class="{ error: validation.hasError('form.state') }"
        label="State :"
        label-for="state"
      >
        <b-form-input
          id="state"
          v-model="form.state"
          placeholder="State"
          required
        ></b-form-input>
        <div class="message">{{ validation.firstError("form.state") }}</div>
      </b-form-group>
      <b-form-group
        :class="{ error: validation.hasError('form.phoneNum') }"
        label="Phone number :"
        label-for="number"
      >
        <b-form-input
          id="number"
          v-model="form.phoneNum"
          placeholder="Phone number"
          required
        ></b-form-input>
        <div class="message">{{ validation.firstError("form.phoneNum") }}</div>
      </b-form-group>
      <b-button class="mt-3" @click="onSubmit()" variant="primary"
        >Submit changes</b-button
      >
      <div style="float: right; width: 15%">
        <b-button
          class="mt-3"
          @click="showDeleteFishermanProfileModal()"
          variant="danger"
          >Delete my account</b-button
        >
        <b-modal
          id="deleteFishermanProfile"
          title="Delete your fisherman profile"
          @ok.prevent="onFishermanDelete()"
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
  </b-tabs>
</template>

<script>
import {
  getFishermanData,
  updateFishermanData,
  deleteFishermanProfile,
} from "../../api";
import axios from "axios";
import SimpleVueValidation from "simple-vue-validator";
const Validator = SimpleVueValidation.Validator;
export default {
  name: "MyProfile",
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
        penalties : null
      },
      password: null,
      newPassword: null,
      repeatPassword: null,
      rejectText: null,
    };
  },
  validators: {
    "form.name": function (value) {
      return Validator.value(value)
        .required()
        .regex(
          "^[a-zA-Z ]*$",
          "Must only contain alphabetic characters or spaces."
        );
    },
    "form.surname": function (value) {
      return Validator.value(value)
        .required()
        .regex(
          "^[a-zA-Z ]*$",
          "Must only contain alphabetic characters or spaces."
        );
    },
    "form.phoneNum": function (value) {
      return Validator.value(value)
        .required()
        .maxLength(15)
        .regex(
          "^(?=.*[0-9])[- + / 0-9]+$",
          "Must contain only numbers or +, /, - signs"
        );
    },
    "form.address": function (value) {
      return Validator.value(value).required();
    },
    "form.city": function (value) {
      return Validator.value(value).required();
    },
    "form.state": function (value) {
      return Validator.value(value).required();
    },
  },
  async mounted() {
    await this.fetchFishermanData();
  },
  computed: {},

  methods: {
    showDeleteFishermanProfileModal() {
      this.rejectText = null;
      this.$bvModal.show("deleteFishermanProfile");
    },
    async onSubmit() {
      this.$validate().then(async (response) => {
        if (response) {
          await updateFishermanData(this.form)
            .then(() => {
              this.fetchFishermanData();
            })
            .catch(() => {
              alert("An error has occured while fetching fisherman data");
            });
        }
      });
    },
    async onFishermanDelete() {
      await deleteFishermanProfile({ reason: this.rejectText })
        .then(() => {
          this.rejectText = null;
          this.fetchFishermanData();
          this.$bvModal.hide("deleteFishermanProfile");
          alert(
            "Your deletion request was succesfully sent. You'll receive response on you mail."
          );
        })
        .catch(() => {
          alert("You already filed a request");
        });
    },
    async fetchFishermanData() {
      await getFishermanData()
        .then((response) => {
          const { email, name, surname, address, city, state, phoneNum, penalties } =
            response;
          this.form.email = email;
          this.form.name = name;
          this.form.surname = surname;
          this.form.address = address;
          this.form.city = city;
          this.form.state = state;
          this.form.phoneNum = phoneNum;
           this.form.penalties = penalties;
        })
        .catch(() => {
          alert("An error has occured while fetching fisherman data");
        });
    },
    changePassword() {
      if (
        this.password.length >= 6 &&
        this.password.length <= 15 &&
        this.newPassword.length >= 6 &&
        this.newPassword.length <= 15 &&
        this.newPassword == this.repeatPassword
      ) {
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
      } else {
        alert(
          "Password must be between 6 and 15 characters, and confirm password must match the new one!"
        );
      }
    },
  },
};
</script>

<style scoped>
a.nav-link {
  color: #8c55aa !important;
  font-weight: bold;
}
.message {
  color: red;
}
</style>