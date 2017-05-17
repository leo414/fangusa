<template>
<nav class="nav_bar_layout">
  <MenuLayout />
  {{title}}
</nav>

</template>

<script>
import MenuLayout from './Menu.vue'

export default {
  name: "NavBar",
  components: {
    MenuLayout,
  },
  props: {
    title: {
      type: String,
      required: true
    },
  }
}
</script>

<style lang="scss" scoped>
@import "../../scss/variables";

.nav_bar_layout {
  position: fixed;
  left: 0;
  top: 0;
  z-index: $z_filter;
  width: 100%;
  height: 50px;
  line-height: 50px;
  overflow: hidden;
  background: $theme_color;
  color: #fff;
  text-align: center;
}

</style>
