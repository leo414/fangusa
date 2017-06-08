<template lang="html">
<div id="home_page">
  <banner-lay />
  <hot-city />
  <house-list title="最新房源" />
  <house-list title="学区好房" />
  <router-link id="vr" to="/vr_list"></router-link>
  <service-list />
  <!--<BlogList />-->
  <!--<Partner />-->
</div>
</template>

<script>
import BannerLay from './banner-lay'
import HotCity from './hot-city'
import HouseList from './house-list'
import ServiceList from './service-list'
// import BlogList from './BlogList
// import Partner from './Partner
export default {
  name: 'HomePage',
  components: {
    BannerLay,
    HotCity,
    HouseList,
    ServiceList,
    // BlogList,
    // Partner,
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
