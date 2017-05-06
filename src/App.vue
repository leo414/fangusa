<template>
  <div id="app">
    <nav-layout />
    <search-layout />
    <router-view class="app_content"></router-view>
    <footer-layout />
  </div>
</template>

<script>
import Nav from './components/layout/Nav.vue'
import Footer from './components/layout/Footer.vue'
import Search from './components/layout/Search.vue'
export default {
  name: 'App',
  components: {
    navLayout: Nav,
    searchLayout: Search,
    footerLayout: Footer,
  },
}
</script>

<style lang="scss">
</style>
