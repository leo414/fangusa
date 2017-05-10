<template>
<div id="menu">
  <i @click.stop="showMenu = true;" class="i i-menu" />
  <div @click.stop="switchMask" :class="[showMenu ? 'fade_toggle' : '', 'mask_transition']" />
  <section :class="[showMenu ? 'slide_toggle' : '', 'menu_layout']">

  </section>
</div>


</template>

<script>

export default {
  name: "Menu",
  data() {
    return {
      showMenu: false,
    }
  },
  methods: {
    switchMask() {
      if(!this.showMenu) return
      this.showMenu = false
    }
  }
}
</script>

<style lang="scss" scoped>
@import "../../scss/variables";
@import "../../scss/mixins";

.menu_layout {
  width: 60vw;
  height: 100vh;
  @include slide_animation(left-right);
  position: relative;
  left: 0;
  right: 0;
  z-index: $z_menu_slide;
  background: #fff;
}

.i-menu {
  position: fixed;
  top: 30px;
  left: 30px;
  z-index: $z_menu_icon;
  font-size: 24px;
}
</style>
