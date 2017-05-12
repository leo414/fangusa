<template lang="html">
<section id="home_page">
  <Search />
  <div class="house_lsit">
    <HouseLayout v-for="info in 10" :key="info" />
  </div>
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

<style lang="scss" scoped>
.house_lsit {
  margin-top: 90px;
}
</style>
