<template lang="html">
<div id="home_page">
  <banner-layout />
  <HotCity />
  <HouseList title="最新房源" />
  <HouseList title="学区好房" />
</div>
</template>

<script>
import Banner from './Banner.vue'
import HotCity from './HotCity.vue'
import HouseList from './HouseList.vue'
export default {
  name: 'HomePage',
  components: {
    bannerLayout: Banner,
    HotCity,
    HouseList,
  }
}
</script>

<style lang="css">
</style>
