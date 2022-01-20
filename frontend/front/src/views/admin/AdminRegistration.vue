<template>
  <div>
    <div>
      <h3>Create new admin</h3>
      <b-form-group
        id="input-group-1"
        label="Email:"
        label-for="input-1"
        :class="{ error: validation.hasError('form.email') }"
      >
        <b-form-input
          id="input-1"
          v-model="form.email"
          type="email"
          placeholder="lokoiuk@email.com"
          required
        ></b-form-input>
        <div class="message">{{ validation.firstError("form.email") }}</div>
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
    </div>
  </div>
</template>

<script>
import { registerNewAdmin } from "../../api";
import SimpleVueValidation from "simple-vue-validator";
const Validator = SimpleVueValidation.Validator;
export default {
  data() {
    return {
      form: {
        email: "",
        name: "",
        surname: "",
        address: "",
        city: "",
        state: "",
        phoneNum: "",
        regType: "SYS_ADMIN",
        password: null,
        confirmPassword: null,
        explanation: null,
      },
    };
  },
  validators: {
     "form.email": function (value) {
      return Validator.value(value).required().email();
    },
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
  methods: {
    async onSubmit() {
      this.$validate().then(async (response) => {
        if (response) {
          await registerNewAdmin(this.form)
            .then(() => {
              alert("New admin is successfully added!");
              this.form = "";
            })
            .catch(() => {
              alert("User with this username already exists");
              this.form = "";
            });
        }
      });
    },
  },
};
</script>


<style scoped>
.message {
  color: red;
}
</style>
