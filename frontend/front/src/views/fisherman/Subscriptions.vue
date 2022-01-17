<template>
  <b-tabs>
    <b-tab title="Boats" active>
      <SubscriptionBoats></SubscriptionBoats>
    </b-tab>
    <b-tab title="Cottages" active>
      <SubscriptionCottages ></SubscriptionCottages>
    </b-tab>
    <b-tab title="Instructors" active>
      <SubscriptionInstructors ></SubscriptionInstructors>
    </b-tab>
  </b-tabs>
</template>

<script>
import SubscriptionInstructors from '../../components/Fisherman/subscriptions/SubscriptionInstructors.vue'
import SubscriptionCottages from '../../components/Fisherman/subscriptions/SubscriptionCottages.vue'
import SubscriptionBoats from '../../components/Fisherman/subscriptions/SubscriptionBoats.vue'


export default {
  name: "Subscriptions",
     components: {
     SubscriptionInstructors,
     SubscriptionCottages,
     SubscriptionBoats
     
     }
};
</script>