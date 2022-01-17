<template>
  <div>
    <AdminHeader></AdminHeader>
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
import AdminHeader from "../../components/Admin/AdminHeader.vue";
export default {
  components: { AdminHeader },
  name: "HomepageAdmin",
};
</script>
