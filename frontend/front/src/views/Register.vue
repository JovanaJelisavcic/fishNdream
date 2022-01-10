<template>
  <div class="container">
    <b-form @submit.prevent="onSubmit" @reset="onReset" v-if="show" novalidate>
      <h2>Register to fishNdream</h2>
      <button @click="goHome" style="float: right" class="ui button">
        Home Page
      </button>
      <p>
        Here you can register for any Role: Fisherman, Cottage Owner, Boat Owner
        or Instructor.<br />
        All you have to do is fill in this form and choose which Role are you
        registering for
      </p>
      <div v-if="usernameError">
        <p class="message">
          Account with this email already exists.<br />
          If you already have an account with different role, note that you'll
          need new email address to register for this role.
        </p>
      </div>
      <b-form-group
        id="input-group-1"
        label="Email:"
        label-for="input-1"
        description="We'll never share your email with anyone else."
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
        id="input-group-2"
        label="Name:"
        label-for="input-2"
        :class="{ error: validation.hasError('form.name') }"
      >
        <b-form-input
          id="input-2"
          v-model="form.name"
          placeholder="John"
          required
        ></b-form-input>
        <div class="message">{{ validation.firstError("form.name") }}</div>
      </b-form-group>

      <b-form-group
        id="input-group-5"
        label="Surname:"
        label-for="input-5"
        :class="{ error: validation.hasError('form.surname') }"
      >
        <b-form-input
          id="input-5"
          v-model="form.surname"
          placeholder="Doe"
          required
        ></b-form-input>
        <div class="message">{{ validation.firstError("form.surname") }}</div>
      </b-form-group>

      <b-form-group
        id="input-group-3"
        label="Role:"
        label-for="input-3"
        :class="{ error: validation.hasError('form.role') }"
      >
        <b-form-select
          id="input-3"
          v-model="form.role"
          :options="roles"
          required
          description="Select if you want to register as owner or fisherman."
        ></b-form-select>
        <div class="message">{{ validation.firstError("form.role") }}</div>
      </b-form-group>

      <b-form-group
        id="input-group-6"
        label="Street Address:"
        label-for="input-6"
        :class="{ error: validation.hasError('form.streetAddress') }"
      >
        <b-form-input
          id="input-6"
          v-model="form.streetAddress"
          placeholder="Foreignville 98/1"
          required
        ></b-form-input>
        <div class="message">
          {{ validation.firstError("form.streetAddress") }}
        </div>
      </b-form-group>

      <b-form-group
        id="input-group-7"
        label="City:"
        label-for="input-7"
        :class="{ error: validation.hasError('form.city') }"
      >
        <b-form-input
          id="input-7"
          v-model="form.city"
          placeholder="Madrid"
          required
        ></b-form-input>
        <div class="message">{{ validation.firstError("form.city") }}</div>
      </b-form-group>
      <b-form-group
        id="input-group-8"
        label="State:"
        label-for="input-8"
        :class="{ error: validation.hasError('form.state') }"
      >
        <b-form-input
          id="input-8"
          v-model="form.state"
          placeholder="Spain"
          required
        ></b-form-input>
        <div class="message">{{ validation.firstError("form.state") }}</div>
      </b-form-group>

      <b-form-group
        id="input-group-9"
        label="Phone number:"
        label-for="input-9"
        :class="{ error: validation.hasError('form.phone') }"
      >
        <b-form-input
          id="input-9"
          v-model="form.phone"
          placeholder="036-582-965"
          required
        ></b-form-input>
        <div class="message">{{ validation.firstError("form.phone") }}</div>
      </b-form-group>

      <b-form-group id="input-group-10" label="Password:" label-for="input-10">
        <b-form-input
          type="password"
          id="input-10"
          v-model="form.password"
          placeholder="*******"
          required
          :class="{ error: validation.hasError('form.password') }"
        ></b-form-input>
        <div class="message">{{ validation.firstError("form.password") }}</div>
      </b-form-group>
      <b-form-group
        id="input-group-11"
        label="Confirm Password:"
        label-for="input-11"
        :class="{ error: validation.hasError('form.confirmPassword') }"
      >
        <b-form-input
          id="input-11"
          v-model="form.confirmPassword"
          type="password"
          placeholder="*******"
          required
        ></b-form-input>
        <div class="message">
          {{ validation.firstError("form.confirmPassword") }}
        </div>
      </b-form-group>

      <b-form-group
        v-if="
          this.form.role == 'Cottage Owner' ||
          this.form.role == 'Boat Owner' ||
          this.form.role == 'Instructor'
        "
        id="input-group-12"
        label="Explanation:"
        label-for="input-12"
      >
        <b-form-textarea
          rows="2"
          max-rows="4"
          id="input-12"
          v-model="form.explanation"
          placeholder="I want to teach others what I know"
          required
          description="Explain why you want to join as owner"
          :class="{ error: validation.hasError('form.explanation') }"
        ></b-form-textarea>
        <div class="message">
          {{ validation.firstError("form.explanation") }}
        </div>
      </b-form-group>

      <b-button type="submit" variant="primary">Submit</b-button>
      <b-button type="reset" variant="danger">Reset</b-button>
    </b-form>
    <div v-if="showMessage">
      <h2>Thanks for registering to fishNdream.</h2>
      <p>
        If you registered for Fisherman, you'll have to verify your account on
        email before signing in.<br />
        If you registered for Service Owner (Cottage, Boat, Instructor), you'll
        have to wait for admin to approve your registration. Response will be
        sent to you via email.
      </p>
      <button @click="goHome" class="ui button">Home Page</button>
    </div>
  </div>
</template>

<script>
import { registerFisherman, registerOwner } from "../api";
import SimpleVueValidation from "simple-vue-validator";
const Validator = SimpleVueValidation.Validator;
export default {
  data() {
    return {
      form: {
        email: "",
        name: "",
        surname: "",
        streetAddress: "",
        city: "",
        state: "",
        phone: "",
        role: null,
        explanation: "",
        password: "",
        confirmPassword: "",
      },
      roles: [
        { text: "Select One", value: null },
        "Cottage Owner",
        "Boat Owner",
        "Instructor",
        "Fisherman",
      ],
      show: true,
      submitted: false,
      showMessage: false,
      usernameError: false,
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
    "form.phone": function (value) {
      return Validator.value(value)
        .required()
        .maxLength(15)
        .regex(
          "^(?=.*[0-9])[- + / 0-9]+$",
          "Must contain only numbers or +, /, - signs"
        );
    },
    "form.streetAddress": function (value) {
      return Validator.value(value).required();
    },
    "form.city": function (value) {
      return Validator.value(value).required();
    },
    "form.state": function (value) {
      return Validator.value(value).required();
    },
    "form.role": function (value) {
      return Validator.value(value).required();
    },
    "form.password": function (value) {
      return Validator.value(value).required().lengthBetween(6, 15);
    },
    "form.confirmPassword, form.password": function (
      confirmPassword,
      password
    ) {
      if (this.submitted || this.validation.isTouched("form.confirmPassword")) {
        return Validator.value(confirmPassword).required().match(password);
      }
    },
    "form.explanation, form.role": function (explanation, role) {
      if (role == "Fisherman" || role == null) {
        return;
      }
      if (this.submitted || this.validation.isTouched("form.explanation")) {
        return Validator.value(explanation).required();
      }
    },
  },
  methods: {
    async onSubmit() {
      this.submitted = true;
      this.$validate().then(async (response) => {
        if (response) {
          if (this.form.role == "Fisherman") {
            this.registerFishermanCall();
          } else {
            this.registerOwnerCall();
          }
        }
      });
    },
    async registerOwnerCall() {
      var role = null;
      if (this.form.role == "Instructor") role = "INSTRUCTOR";
      if (this.form.role == "Cottage Owner") role = "COTTAGE_OWNER";
      if (this.form.role == "Boat Owner") role = "BOAT_OWNER";
      await registerOwner({
        email: this.form.email,
        password: this.form.password,
        confirmPassword: this.form.confirmPassword,
        name: this.form.name,
        surname: this.form.surname,
        adress: this.form.streetAddress,
        city: this.form.city,
        state: this.form.state,
        phoneNum: this.form.phone,
        regType: role,
        explanation: this.form.explanation,
      })
        .then(() => {
          this.showMessage = true;
          this.show = false;
          this.usernameError = false;
        })
        .catch(() => {
          this.usernameError = true;
        });
    },
    async registerFishermanCall() {
      await registerFisherman({
        email: this.form.email,
        password: this.form.password,
        confirmPassword: this.form.confirmPassword,
        name: this.form.name,
        surname: this.form.surname,
        adress: this.form.streetAddress,
        city: this.form.city,
        state: this.form.state,
        phoneNum: this.form.phone,
      }).then(() => {
          this.showMessage = true;
          this.show = false;
          this.usernameError = false;
        })
        .catch(() => {
          this.usernameError = true;
        });
    },
    onReset(event) {
      event.preventDefault();

      this.form.email = "";
      this.form.name = "";
      this.form.role = null;
      this.form.surname = "";
      this.form.streetAddress = "";
      this.form.city = "";
      this.form.state = "";
      this.form.phone = "";
      this.form.explanation = "";
      this.form.password = "";
      this.form.confirmPassword = "";
      this.validation.reset();

      this.submitted = false;
      this.show = false;
      this.usernameError = false;
      this.$nextTick(() => {
        this.show = true;
      });
    },
    goHome() {
      this.$router.push("/");
    },
  },
};
</script>

<style scoped>
.container {
  margin-top: 20px;
}
.message {
  color: red;
}
button {
  margin-top: 10px;
  margin-right: 10px;
}
</style>