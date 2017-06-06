<template>
  <div id="app">
    <nav-lay />
    <!--<search-layout />-->
    <router-view class="app_content"></router-view>
    <!--<footer-layout />-->
  </div>
</template>

<script>
import NavLay from './components/layout/nav-lay'
// import Footer from './components/layout/Footer
// import Search from './components/layout/Search
export default {
  name: 'App',
  components: {
    NavLay,
    // searchLayout: Search,
    // footerLayout: Footer,
  },
}
</script>

<style lang="scss">
</style>
