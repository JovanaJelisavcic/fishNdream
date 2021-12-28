<template>
  <div class="container">
    <b-form @submit="onSubmit" @reset="onReset" v-if="show">
      <b-form-group
        id="input-group-1"
        label="Email:"
        label-for="input-1"
        description="We'll never share your email with anyone else."
      >
        <b-form-input
          id="input-1"
          v-model="form.email"
          type="email"
          placeholder="lokoiuk@email.com"
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="Name:" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="form.name"
          placeholder="John"
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-5" label="Surname:" label-for="input-5">
        <b-form-input
          id="input-5"
          v-model="form.surname"
          placeholder="Doe"
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-3" label="Role:" label-for="input-3">
        <b-form-select
          id="input-3"
          v-model="form.role"
          :options="roles"
          required
          description="Select if you want to register as owner or fisherman."
        ></b-form-select>
      </b-form-group>

      <b-form-group
        id="input-group-6"
        label="Street Address:"
        label-for="input-6"
      >
        <b-form-input
          id="input-6"
          v-model="form.streetAddress"
          placeholder="Foreignville 98/1"
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-7" label="City:" label-for="input-7">
        <b-form-input
          id="input-7"
          v-model="form.city"
          placeholder="Madrid"
          required
        ></b-form-input>
      </b-form-group>
      <b-form-group id="input-group-8" label="State:" label-for="input-8">
        <b-form-input
          id="input-8"
          v-model="form.state"
          placeholder="Spain"
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group
        id="input-group-9"
        label="Phone number:"
        label-for="input-9"
      >
        <b-form-input
          id="input-9"
          v-model="form.phone"
          placeholder="036-582-965"
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-10" label="Password:" label-for="input-10">
        <b-form-input
        type="password"
          id="input-10"
          v-model="form.password"
          aria-describedby="password-help-block"
          placeholder="*******"
          required
        ></b-form-input>
         <b-form-text id="password-help-block">
      Your password must be 6-15 characters long.
    </b-form-text>
      </b-form-group>
      <b-form-group
        id="input-group-11"
        label="Confirm Password:"
        label-for="input-11"
      >
        <b-form-input
          id="input-11"
          v-model="form.confirmPassword"
          type="password"
          placeholder="*******"
          required
        ></b-form-input>
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
        ></b-form-textarea>
      </b-form-group>

      <b-button type="submit" variant="primary">Submit</b-button>
      <b-button type="reset" variant="danger">Reset</b-button>
    </b-form>
  </div>
</template>

<script>
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
    };
  },
  methods: {
    onSubmit(event) {
      event.preventDefault();
      alert(JSON.stringify(this.form));
    },
    onReset(event) {
      event.preventDefault();
      // Reset our form values
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

      // Trick to reset/clear native browser form validation state
      this.show = false;
      this.$nextTick(() => {
        this.show = true;
      });
    },
  },
};
</script>

<style scoped>
.container{
    margin-top: 20px;
}
</style>