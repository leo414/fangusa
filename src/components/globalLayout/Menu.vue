<template>
<div id="menu">
  <i @click.stop="showMenu = true;" class="i i-menu" />
  <div v-if="showMenu" @click.stop="switchMask" :class="[showMenu ? 'fade_toggle' : '', 'mask_transition']" />
  <section :class="[showMenu ? 'slide_toggle' : '', 'menu_layout', 'tc']">
    <div v-if="!userInfo.image" class="face"></div>
    <img v-else :src="userInfo.image || 'http://placehold.it/120x120'" alt="" class="face" />
    <div class="entry" v-if="!isLogin">
      <router-link to="/login" class="tr pr10">登录</router-link>
      <span>|</span>
      <router-link to="/register" class="tl pl10">注册</router-link>
    </div>

    <nav class="nav">
      <router-link to="/">首页</router-link>
      <router-link to="/users">个人设置</router-link>
      <router-link to="/mark_list">收藏的房源</router-link>
      <router-link to="/contact_us">联系我们</router-link>
    </nav>
  </section>
</div>
</template>

<script>

export default {
  name: "Menu",
  data() {
    let userInfo = {
      image: '',
    }
    if(localStorage.userInfo) {
      userInfo = JSON.parse(localStorage.userInfo)
    }
    return {
      userInfo,
      isLogin: Boolean(localStorage.token),
      showMenu: false,
    }
  },
  watch: {
    showMenu(value) {
      if(value) {
        this.$emit('open')
      }
    },
  },
  methods: {
    switchMask() {
      if(!this.showMenu) return
      this.showMenu = false
    }
  },
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
  padding-top: 5vh;
  background: #fff;
  text-align: center;
}

.i-menu {
  position: fixed;
  top: 2px;
  left: 2px;
  padding: 10px;
  width: 50px;
  text-align: center;
  color: #fff;
  z-index: $z_menu_icon;
  font-size: 28px;
}

.nav_bar_layout .i-menu {
  padding: 0;
  top: 0;
  left: 10px;
}

.face {
  width: 120px;
  height: 120px;
  display: inline-block;
  border-radius: 50%;
}

.entry {
  margin-top: 20px;
  width: 100%;
  height: 50px;
  line-height: 50px;
  font-size: 20px;
  color: #3a3a3a;

  a {
    display: inline-block;
    width: 46%;
    color: #3a3a3a;
  }
}

.nav {
  margin-top: 10vh;
  width: 100%;
  height: auto;

  a {
    display: block;
    width: 100%;
    height: 50px;
    line-height: 50px;
    margin-bottom: 15px;
    color: $theme_color;
    border-bottom: 1px solid #EAEAEA;
    font-size: 18px;
    text-align: center;
  }
}
</style>
