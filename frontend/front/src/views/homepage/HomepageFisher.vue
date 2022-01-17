<template>
  <div>
    <FishermanHeader></FishermanHeader>
    <div
      class="p-3"
      style="
        width: 100%;
        height: calc(100% - 80px);
        max-height: calc(100% - 80px);
        overflox-x: scroll;
      "
    >
      <router-view></router-view>
    </div>
  </div>

</template>

<script>
import FishermanHeader from "../../components/Fisherman/FishermanHeader.vue";
export default {
  components: { FishermanHeader },
  name: "HomepageFisher",
};
</script>

