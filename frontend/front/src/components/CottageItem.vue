<template>
  <li class="list-group-item">
      <img  :src="image_prefix + '/' + cottage.cottagePics[0]"/>
      <h4>{{cottage.name}}</h4>
      <p> {{cottage.address}}<br/>
          Price : {{cottage.price}} <br/> 
          Rating : {{cottage.rating}} <br/> 
          
      </p>
      
  </li>
</template>

<script>
export default {
  name: "CottageItem",
  props: ['cottage'],
  data() {
    return {
      image_prefix: process.env.VUE_APP_BAKEND_SLIKE_PUTANJA
    };
  }
};
</script>

<style scoped>
img {
  width: 150px;
  height: 150px;
}
</style>