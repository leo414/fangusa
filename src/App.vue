<template>
  <div id="app">
    <nav-lay />
    <search-lay></search-lay>
    <router-view class="app_content"></router-view>
    <footer-lay />
  </div>
</template>

<script>
import NavLay from './components/layout/nav-lay'
import FooterLay from './components/layout/footer-lay'
import SearchLay from './components/layout/search-lay'
export default {
  name: 'App',
  components: {
    NavLay,
    FooterLay,
    SearchLay,
  },
}
</script>

<style lang="scss">
</style>
