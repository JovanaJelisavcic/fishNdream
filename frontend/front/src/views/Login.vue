<template>

  <div class="main">
    <p class="sign" align="center">Sign in</p>
     <b-form @submit.prevent="tryLogin" novalidate class="form1">
       <b-form-group

        id="input-group-1"
        :class="{ error: validation.hasError('username') }"
      >
        <b-form-input
          id="input-1"
           class="un"
          v-model="username"
          type="email"
          placeholder="lokoiuk@email.com"
          required
        ></b-form-input>
        <div class="message">{{ validation.firstError("username") }}</div>
      </b-form-group>
        <b-form-group id="input-group-10">
        <b-form-input
          type="password"
          id="input-10"
          v-model="password"
          placeholder="*******"
          required
          class="pass"
          :class="{ error: validation.hasError('password') }"
        ></b-form-input>
        <div class="message">{{ validation.firstError("password") }}</div>
      </b-form-group>
        <p class="message" v-if="errMsg">User doesn't exist or isn't verified yet.<br>
       <small>Fishermen can verify their accounts via mail and Service Owners need to wait for admin to verify them.</small> </p>
      <b-button type="submit" class="submit">Sign in</b-button>
      
     </b-form>
    
  </div>

</template>

         
        
<script>
import SimpleVueValidation from "simple-vue-validator";
const Validator = SimpleVueValidation.Validator;
export default {
  data() {
    return {
      username: null,
      password: null,
      errMsg: false,
    };
  },
  mounted() {
    this.$store.commit("login/clearToken");
  },
  validators: {
    username: function (value) {
      return Validator.value(value).required().email();
    },
    password: function (value) {
      return Validator.value(value).required().lengthBetween(6, 15);
    },
  },
  methods: {
    async tryLogin() {
 if (
        await this.$store.dispatch("login/login", {
          email: this.username,
          password: this.password,
        })
      ) {

        //reroute
        if(localStorage.getItem("role")=="FISHERMAN"){
            this.$router.push("/fisher");
        }else if(localStorage.getItem("role")=="SYS_ADMIN"){
             this.$router.push("/admin");
        }else{
             this.$router.push("/owner");
        }
        
       
       
      }else {
            this.errMsg = true;
      }
    },
  },
};
</script>


<style scoped>
body {
  background-color: #f3ebf6;
  font-family: "Ubuntu", sans-serif;
}

.main {
  background-color: #ffffff;
  width: 400px;
  height: 400px;
  margin: 7em auto;
  border-radius: 1.5em;
  box-shadow: 0px 11px 35px 2px rgba(0, 0, 0, 0.14);
}

.sign {
  padding-top: 40px;
  color: #8c55aa;
  font-family: "Ubuntu", sans-serif;
  font-weight: bold;
  font-size: 23px;
}

.un {
  width: 76%;
  color: rgb(38, 50, 56);
  font-weight: 700;
  font-size: 14px;
  letter-spacing: 1px;
  background: rgba(136, 126, 126, 0.04);
  padding: 10px 20px;
  border: none;
  border-radius: 20px;
  outline: none;
  box-sizing: border-box;
  border: 2px solid rgba(0, 0, 0, 0.02);
  margin-bottom: 50px;
  margin-left: 46px;
  text-align: center;
  margin-bottom: 27px;
  font-family: "Ubuntu", sans-serif;
}

form.form1 {
  padding-top: 40px;
}

.pass {
  width: 76%;
  color: rgb(38, 50, 56);
  font-weight: 700;
  font-size: 14px;
  letter-spacing: 1px;
  background: rgba(136, 126, 126, 0.04);
  padding: 10px 20px;
  border: none;
  border-radius: 20px;
  outline: none;
  box-sizing: border-box;
  border: 2px solid rgba(0, 0, 0, 0.02);
  margin-bottom: 50px;
  margin-left: 46px;
  text-align: center;
  margin-bottom: 27px;
  font-family: "Ubuntu", sans-serif;
}

.un:focus,
.pass:focus {
  border: 2px solid rgba(0, 0, 0, 0.18) !important;
}

.submit {
  cursor: pointer;
  border-radius: 5em;
  color: #fff;
  background: linear-gradient(to right, #9c27b0, #e040fb);
  border: 0;
  padding-left: 40px;
  padding-right: 40px;
  padding-bottom: 10px;
  padding-top: 10px;
  font-family: "Ubuntu", sans-serif;
  margin-left: 35%;
  font-size: 13px;
  box-shadow: 0 0 20px 1px rgba(0, 0, 0, 0.04);
}

.message {
  padding-left: 30px;
  color: red;
}

@media (max-width: 600px) {
  .main {
    border-radius: 0px;
  }
}
</style>