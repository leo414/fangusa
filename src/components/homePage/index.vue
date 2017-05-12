<template lang="html">
<section id="home_page">
  <Search />
  <HouseLayout v-for="info in 10" :key="info" />
</section>
</template>

<script>
import Search from './Search.vue'
import HouseLayout from '../globalLayout/HouseLayout.vue'

export default {
  name: 'HomePage',
  components: {
    Search,
    HouseLayout,
  },
}
</script>

<style lang="css">
</style>
