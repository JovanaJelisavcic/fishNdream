<template>
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
</template>

<script>
import axios from "axios";
export default {
  name: "ChangePassword",
  data() {
    return {
      password: null,
      newPassword: null,
      repeatPassword: null,
    };
  },
  methods:{
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
  }
};
</script>