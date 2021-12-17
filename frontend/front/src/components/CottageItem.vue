<template>
  <div class="item">
    <div class="ui image">
      <img :src="image_prefix + '/' + cottage.cottagePics[0]" />
    </div>
    <div class="content">
       <div class="header">{{ cottage.name }}</div>
        <div class="meta">
        <span class="price">{{ cottage.price }}$</span>
        <span class="rating"> {{ cottage.rating }}⭐</span>
      </div>
    <div class="description">
        <p>{{cottage.address}}</p>
        
      </div>
   </div> 
  </div>
</template>

<script>
export default {
  name: "CottageItem",
  props: ["cottage"],
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