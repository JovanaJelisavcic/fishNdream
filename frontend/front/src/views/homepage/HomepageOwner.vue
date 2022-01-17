<template>
    <div>Welcome Service Owner!
 <a @click="goLogout" class="ui button"> Logout </a>

    </div>
    
</template>

<script>
export default {
     name: "HomepageOwner",
      methods: {
    goLogout() {
      this.$store.dispatch('login/logout');
      this.$router.push("/");
    }
  }
}
</script>
