<template>
  <div v-if="adventure" class="sticky col-md-8 row">
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
      <h1>{{ adventure.name }}</h1>
      <p>
        <small>{{ adventure.description }}</small
        ><br />
        📍 at {{ adventure.address }}<br />
        {{ adventure.price }}$ per hour<br />
        {{ adventure.maxParticipants }} 👤
        <br />
      </p>
      <p v-if="adventure.cancelPolicy">
        If you cancel your reservation the owner keeps part of the money
      </p>
      <p v-if="!adventure.cancelPolicy">You can cancel your reservation for free!</p>
      <h3>
        Instructor: {{ adventure.instructor.name }}
        {{ adventure.instructor.surname }}
      </h3>
      <p>
        "{{ adventure.instructor.shortBio }}"<br />
        {{ adventure.instructor.rating }}⭐<br />
        From {{ adventure.instructor.city }}<br />
        And you'll have to respect his/her rules:<br />
        {{ adventure.behaviourRules }}<br />
      </p>
       <b-table striped :items="items"></b-table>
    </b-col>
  </div>
</template>

<script>
export default {
  name: "AdventureDetailFisher",
  props: ["adventure"],
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
      for (var i = 0; i < this.adventure.adventurePics.length; i++) {
        imgs.push(this.image_prefix + "/" + this.adventure.adventurePics[i]);
      }
      return imgs;
    },
    items() {
      var items = [];
      for (let ev of this.adventure.additionalServices) {
        items.push({ service: ev.name, price: ev.price + "$" });
      }

      return items;
    },
  },
};
</script>

<style scoped>
.sticky{
  font-size: 18px;
}
.details {
  margin-top: 40px;
  margin-bottom: 1080px;
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