<template>
  <div>
    <div>
      <h3>Create new admin</h3>
      <b-form-group label="Email address:" label-for="email">
        <b-form-input
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
      <b-form-group label="Set password :" label-for="password">
        <b-form-input
          id="password"
          v-model="form.password"
          placeholder="Set password"
          required
        ></b-form-input>
      </b-form-group>
      <b-form-group label="Confirm password:" label-for="confirmPassword">
        <b-form-input
          id="confirmPassword"
          v-model="form.confirmPassword"
          placeholder="Confirm password"
          required
        ></b-form-input>
      </b-form-group>
      <b-form-group label="Explanation :" label-for="explanation">
        <b-form-input
          id="explanation"
          v-model="form.explanation"
          placeholder="Explanation"
          required
        ></b-form-input>
      </b-form-group>
      <b-button class="mt-3" @click="onSubmit()" variant="primary"
        >Submit changes</b-button
      >
    </div>
  </div>
</template>

<script>
import { registerNewAdmin } from "../../api";
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
        regType: "SYS_ADMIN",
        password: null,
        confirmPassword: null,
        explanation: null,
      },
    };
  },
  methods: {
    async onSubmit() {
      await registerNewAdmin(this.form)
        .then(() => {
          alert("New admin is successfully added!");
          this.form = "";
        })
        .catch(() => {
          alert("An error has occured while adding new admin.");
          this.form = "";
        });
    },
  },
};
</script>

<style></style>
