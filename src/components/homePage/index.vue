<template lang="html">
<section id="home_page">
  <Search />
  <MenuLayout />
</section>
</template>

<script>
import Menu from '../globalLayout/Menu.vue'
import Search from './Search.vue'

export default {
  name: 'HomePage',
  components: {
    MenuLayout: Menu,
    Search,
  },
}
</script>

<style lang="css">
</style>
