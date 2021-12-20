<template>
  <div class="item">
    <div class="ui image">
      <img :src="image_prefix + '/' + adventure.adventurePics[0]" />
    </div>
    <div class="content">
       <div class="header">{{ adventure.name }}</div>
        <div class="meta">
        <span class="price">{{ adventure.price }}$</span>
        <span class="rating"> {{ adventure.rating }}⭐</span>
      </div>
    <div class="description">
        <p>{{adventure.address}}</p>
        
      </div>
   </div> 
  </div>
</template>

<script>
export default {
  name: "AdventureItem",
  props: ["adventure"],
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