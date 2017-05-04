<template>
  <div id="app">
    <nav-layout />
    <router-view></router-view>
  </div>
</template>

<script>
import Nav from './components/layout/Nav.vue'
export default {
  name: 'App',
  components: {
    navLayout: Nav,
  },
}
</script>

<style lang="scss">
</style>
