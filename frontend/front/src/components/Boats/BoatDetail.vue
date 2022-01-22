<template>
  <div v-if="boat" class="sticky col-md-8">
    <b-row>
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
        <h1>{{ boat.name }}</h1>
        <p>
          <small> {{ boat.description }}</small
          ><br />
          📍 at {{ boat.address }}<br />
          {{ boat.price }}$ per hour<br />
          {{ boat.capacity }} 👤 on {{ boat.length }}m long boat <br />
          {{ boat.rating }}⭐<br />
        </p>
        <b-table striped :items="items"></b-table>
      </b-col>
    </b-row>
    <b-row>
      <vue-cal
        class="vuecal--green-theme"
        active-view="month"
        :disable-views="['years', 'week']"
        :min-date="minDate"
        today-button
        :events="events"
        events-on-month-view="true"
        :time-from="5 * 60"
        :time-to="23 * 60"
        style="height: 500px"
      />
    </b-row>
  </div>
</template>

<script>
export default {
  name: "BoatDetail",
  props: ["boat"],
  data() {
    return {
      image_prefix: process.env.VUE_APP_BAKEND_SLIKE_PUTANJA,
      currentNumber: 0,
      timer: null,
      currentDate: new Date(),
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
      for (var i = 0; i < this.boat.boatPics.length; i++) {
        imgs.push(this.image_prefix + "/" + this.boat.boatPics[i]);
      }
      return imgs;
    },
    minDate() {
      return this.currentDate;
    },
    events() {
      var events = [];
      for (let ev of this.boat.unavailablePeriods) {
        events.push({ start: ev.beggining, end: ev.ending, title: "Busy" });
      }

      return events;
    },
    items() {
      var items = [];
      for (let ev of this.boat.additionalServices) {
        items.push({ service: ev.name, price: ev.price + "$" });
      }

      return items;
    },
  },
};
</script>

<style scoped>
.sticky {

  font-size: 18px;

}
.details {
  margin-top: 40px;
  margin-bottom: 0px;
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
.vuecal__cell--disabled {
  text-decoration: line-through;
}
.vuecal__cell--before-min {
  color: #b6d6c7;
}
.vuecal__now-line {
  color: #06c;
}
</style>