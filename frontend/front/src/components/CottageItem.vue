<template>
<li class="list-group-item media">
      <img class="m3-3" :src="image_prefix + '/' + cottage.cottagePics[0]" />
    <div class="media-body">
       <h4>{{ cottage.name }}</h4>
        <div class="meta">
        <span class="price">{{ cottage.price }}$</span>
        <span class="rating"> {{ cottage.rating }}⭐</span>
      </div>
    <div class="description">
        <p>{{cottage.address}}</p>
        
      </div>
   </div> 
  </li>
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