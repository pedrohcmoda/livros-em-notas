<template>
  <AppHeader />
  <main>
    <router-view/>
  </main>
  <AppFooter />
</template>

<script>
import AppHeader from '@/components/AppHeader.vue'
import AppFooter from '@/components/AppFooter.vue'
import {Notifications} from "@kyvg/vue3-notification";

export default {
  components: {
    AppHeader,
    AppFooter
  }
}
</script>