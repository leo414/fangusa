<template>
  <div id="app">
    <nav-layout />
    <router-view></router-view>
    <footer-layout />
  </div>
</template>

<script>
import Nav from './components/layout/Nav.vue'
import Footer from './components/layout/Footer.vue'
export default {
  name: 'App',
  components: {
    navLayout: Nav,
    footerLayout: Footer,
  },
}
</script>

<style lang="scss">
</style>
