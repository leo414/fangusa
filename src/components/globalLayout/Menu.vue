<template>
<div id="menu">
  <i @click.stop="showMenu = true;" class="i i-menu" />
  <div @click.stop="switchMask" :class="[showMenu ? 'fade_toggle' : '', 'mask_transition']" />
  <section :class="[showMenu ? 'slide_toggle' : '', 'menu_layout']">
    <div class="face"></div>
    <div class="entry">
      <router-link to="/login" class="tr pr10">登录</router-link>
      |
      <router-link to="/register" class="tl pl10">注册</router-link>
    </div>
    <nav class="nav">
      <router-link to="/login">个人设置</router-link>
      <router-link to="/login">收藏的房源</router-link>
      <router-link to="/login">联系我们</router-link>
    </nav>
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
  width: 70vw;
  height: 100vh;
  @include slide_animation(left-right);
  position: fixed;
  left: 0;
  top: 0;
  z-index: $z_menu_slide;
  padding-top: 10vh;
  background: #fff;
  text-align: center;
}

.i-menu {
  position: fixed;
  top: 30px;
  left: 30px;
  z-index: $z_menu_icon;
  font-size: 24px;
}

.face {
  width: 150px;
  height: 150px;
  display: inline-block;
  border-radius: 50%;
  background: url(http://placehold.it/150x150) center no-repeat;
  background-size: cover;
}

.entry {
  width: 100%;
  height: 50px;
  line-height: 50px;
  margin-top: 20px;
  font-size: 22px;

  a {
    display: inline-block;
    width: 46%;
    color: #3a3a3a;
  }
}

.nav {
  margin-top: 15vh;
  width: 100%;
  height: auto;

  a {
    display: block;
    width: 100%;
    height: 50px;
    line-height: 50px;
    margin-bottom: 20px;
    color: $theme_color;
    border-bottom: 1px solid #EAEAEA;
    font-size: 20px;
    text-align: center;
  }
}
</style>
