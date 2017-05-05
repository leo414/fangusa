<template lang="html">
<div id="home_page">
  <banner-layout />
  <HotCity />
  <HouseList title="最新房源" />
  <HouseList title="学区好房" />
  <router-link id="vr" to="/vr_list"></router-link>
  <ServiceList />
</div>
</template>

<script>
import Banner from './Banner.vue'
import HotCity from './HotCity.vue'
import HouseList from './HouseList.vue'
import ServiceList from './ServiceList.vue'
export default {
  name: 'HomePage',
  components: {
    bannerLayout: Banner,
    HotCity,
    HouseList,
    ServiceList,
  }
}
</script>

<style lang="scss" scoped>
#vr {
  display: block;
  margin-top: 50px;
  width: 100%;
  height: 500px;
  background: url('../../assets/vr.png') center center no-repeat;
  background-size: cover;
}
</style>
