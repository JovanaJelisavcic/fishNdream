<template>
  <li class="list-group-item media">

      <img class="m3-3" :src="image_prefix + '/' + adventure.adventurePics[0]" />
    <div class="media-body">
       <h4>{{ adventure.name }}</h4>
        <div class="meta">
        <span class="price">{{ adventure.price }}$</span>
        <span class="rating"> {{ adventure.instructor.rating }}⭐</span>
      </div>
    <div class="description">
        <p>{{adventure.address}}</p>
        
      </div>
   </div> 
  </li>
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
img{
  height: 250px;
  width: 250px;
  padding: 10px 10px 10px 10px;
  
}
li{
  display: flex;
  cursor: pointer;
}
li:hover{
  background-color: rgb(234, 224, 235);
}
</style>