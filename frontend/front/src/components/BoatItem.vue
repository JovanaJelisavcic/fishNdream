<template>
  <div class="item">
    <div class="ui image">
      <img :src="image_prefix + '/' + boat.boatPics[0]" />
    </div>
    <div class="content">
       <div class="header">{{ boat.name }}</div>
        <div class="meta">
        <span class="price">{{ boat.price }}$</span>
        <span class="rating"> {{ boat.rating }}⭐</span>
      </div>
    <div class="description">
        <p>{{boat.address}}</p>
        
      </div>
   </div> 
  </div>
</template>

<script>
export default {
  name: "BoatItem",
  props: ["boat"],
  data() {
    return {
      image_prefix: process.env.VUE_APP_BAKEND_SLIKE_PUTANJA,
    };
  },
};
</script>

<style scoped>
.image{
  height: 250px;
  width: 250px;
  padding: 10px 10px 10px 10px;
}
</style>