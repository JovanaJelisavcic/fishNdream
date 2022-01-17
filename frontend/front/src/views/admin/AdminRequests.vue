<template>
  <div>
    <b-tabs>
      <b-tab title="Registration" active>
        <AdminRegistrationRequests></AdminRegistrationRequests>
      </b-tab>
      <b-tab title="Account deletion">
        <b-tabs class="mt-3">
          <b-tab title="Admin" active>
            <AdminProfileDeletion></AdminProfileDeletion>
          </b-tab>
          <b-tab title="User">
            <UserProfileDeletion></UserProfileDeletion>
          </b-tab>
        </b-tabs>
      </b-tab>
    </b-tabs>
  </div>
</template>

<script>
import AdminRegistrationRequests from "../../components/Admin/requests/AdminRegistrationRequests.vue";
import AdminProfileDeletion from "../../components/Admin/requests/AdminProfileDeletion.vue";
import UserProfileDeletion from "../../components/Admin/requests/UserProfileDeletion.vue";
export default {
  components: {
    AdminRegistrationRequests,
    AdminProfileDeletion,
    UserProfileDeletion,
  },
};
</script>

<style></style>
