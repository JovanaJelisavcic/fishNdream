<template>
  <div>
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
  </div>
</template>

<script>
import { getAdminData, updateAdminData } from "../../api";
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
    };
  },
  async mounted() {
    await this.fetchAdminData();
  },
  methods: {
    async onSubmit() {
      await updateAdminData(this.form)
        .then(() => {
          this.fetchAdminData();
        })
        .catch(() => {
          alert("An error has occured while fetching admin data");
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
  },
};
</script>

<style></style>
