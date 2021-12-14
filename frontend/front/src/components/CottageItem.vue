<template>
  <li class="list-group-item">
      <img src='../assets/fisherman.jpg'/>
      <h4>{{cottage.name}}</h4>
      <p>   {{cottage.description}} <br/>
          {{cottage.address}}<br/>
          {{cottage.price}} <br/> 
          {{cottage.rating}} <br/> 
          
      </p>
      
  </li>
</template>

<script>
export default {
  name: "CottageItem",
  props: ['cottage']
};
</script>