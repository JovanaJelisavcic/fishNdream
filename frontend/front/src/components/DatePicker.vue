<template>
  <div>
    <h2>Vue Simple Datepicker Example</h2>
    <Datepicker format="dd-MM-yyyy"></Datepicker>
  </div>
</template>
 
<script>
import Datepicker from "vuejs-datepicker";

export default {
  name: "DatePicker",
  data() {
    return {};
  },
  components: {
      Datepicker
  }
};
</script>