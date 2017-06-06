<template lang="html">
<div id="home_page">
  <!--<banner-layout />-->
  <!--<HotCity />
  <HouseList title="最新房源" />
  <HouseList title="学区好房" />
  <router-link id="vr" to="/vr_list"></router-link>
  <ServiceList />
  <BlogList />
  <Partner />-->
</div>
</template>

<script>
// import Banner from './Banner
// import HotCity from './HotCity
// import HouseList from './HouseList
// import ServiceList from './ServiceList
// import BlogList from './BlogList
// import Partner from './Partner
export default {
  name: 'HomePage',
  components: {
    // bannerLayout: Banner,
    // HotCity,
    // HouseList,
    // ServiceList,
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
