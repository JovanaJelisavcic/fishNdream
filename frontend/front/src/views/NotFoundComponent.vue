<template>
  <div>
    404 Page Not Found<br />
    <small>Check your permissions!</small><br />
    <button @click="goHome" style="float: left" class="ui button">
      Home Page
    </button>
  </div>
</template>

<script>
export default {
  name: "NotFoundComponent",
  methods: {
    goHome() {
      let role = localStorage.getItem('role');
      let accessToken = localStorage.getItem('token');
      if(!role && !accessToken){
        this.$router.push("/");
      }else if(role==="FISHERMAN"){
           this.$router.push("/fisher");
      }else if(role==="SYS_ADMIN"){
           this.$router.push("/admin");
      }else{
          this.$router.push("/owner");
      }
     
    },
  },
};
</script>