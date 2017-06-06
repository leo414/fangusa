<template>
  <div id="app">
    <nav-lay />
    <!--<search-layout />-->
    <router-view class="app_content"></router-view>
    <footer-lay />
  </div>
</template>

<script>
import NavLay from './components/layout/nav-lay'
import FooterLay from './components/layout/footer-lay'
// import Search from './components/layout/Search
export default {
  name: 'App',
  components: {
    NavLay,
    FooterLay,
    // searchLayout: Search,
  },
}
</script>

<style lang="scss">
</style>
