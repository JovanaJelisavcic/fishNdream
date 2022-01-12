<template>
  <div v-if="cottage" class="sticky col-md-8 row">
    <b-col>
      <button @click="prev" id="prev">Previous</button>
      <button @click="next" id="next">Next</button>
      <transition-group name="fade" tag="div">
        <div v-for="number in [currentNumber]" :key="number">
          <img :src="currentImage" />
        </div>
      </transition-group>
    </b-col>
    <b-col class="details">
      <h1>{{ cottage.name }}</h1>
      <p>
       <small> {{ cottage.description }}</small><br />
        📍 at {{ cottage.address }}<br />
        {{ cottage.price }}$ per night<br />
        {{ cottage.guestsNum }} 👤 <br />
        {{ cottage.rating }}⭐
      </p>
    </b-col>
  </div>
</template>

<script>
export default {
  name: "CottageDetail",
  props: ["cottage"],
  data() {
    return {
      image_prefix: process.env.VUE_APP_BAKEND_SLIKE_PUTANJA,
      currentNumber: 0,
      timer: null,
    };
  },

  methods: {
    next: function () {
      this.currentNumber += 1;
    },
    prev: function () {
      this.currentNumber -= 1;
    },
  },

  computed: {
    currentImage: function () {
      return this.computeImgArray[
        Math.abs(this.currentNumber) % this.computeImgArray.length
      ];
    },
    computeImgArray() {
      var imgs = [];
      for (var i = 0; i < this.cottage.cottagePics.length; i++) {
        imgs.push(this.image_prefix + "/" + this.cottage.cottagePics[i]);
      }
      return imgs;
    },
  },
};
</script>

<style scoped>
.sticky {
  position: -webkit-sticky;
  position: sticky;
  top: 20%;
  font-size: 18px;
  align-self: flex-start;
  height: auto;
}
.details {
  margin-top: 50px;
  margin-bottom: 1000px;
  padding: 10px;
  border: 1px solid #ddd;
  border-radius: 4px;
}
img {
  height: 500px;
  width: 500px;
  padding: 10px;
  margin-top: 0px;
}
button {
  color: rgb(31, 32, 32);
  border-radius: 12px;
  margin-top: 45px;
}
#prev {
  position: relative;
  float: left;
}
#next {
  position: relative;
  float: right;
}
</style>