<template lang="html">
<section class="bg_white_container">
  <div id="nav" class="container">
    <el-row class="row_container">
      <el-col :span="4" class="logo">
        <router-link to="/"><img src="../../assets/logo.png" alt="LOGO"></router-link>
      </el-col>
      <el-col :span="16" :offset="1">
        <ul class="nav_list" v-once>
          <li><router-link to="/">首页</router-link></li>
          <li><router-link to="#">全部房产信息</router-link></li>
          <li><router-link to="#">美国置业指南</router-link></li>
          <li><router-link to="#">一站式服务</router-link></li>
          <li><router-link to="#">精品看房团</router-link></li>
          <li><router-link to="#">博客</router-link></li>
          <li><router-link to="/contact">联系我们</router-link></li>
        </ul>
      </el-col>
      <el-col class="entry" :span="3" v-if="!isLogin">
        <router-link to="/login">登录</router-link>
        <i class="i i-shugang" />
        <router-link to="/register">注册</router-link>
      </el-col>

      <el-col class="entry" :span="3" v-else>
        <router-link to="/user">个人中心</router-link>
        <i class="i i-shugang" />
        <a @click.stop="logout">登出</a>
      </el-col>
    </el-row>
  </div>
</section>
</template>

<script>

export default {
  name: 'NavLay',
  data() {
    return {
      isLogin: localStorage.token ? true : false,
    }
  },
  watch: {
    $route() {
      this.isLogin = localStorage.token ? true : false
    },
  },
  methods: {
    logout() {
      localStorage.token = ''
      this.isLogin = false
      this.$router.push('/login')
    }
  },
}
</script>

<style lang="scss" scoped>
@import "../../scss/variables.scss";

#nav {
  height: 70px;
  overflow: hidden;
  line-height: 70px;
  font-size: 16px;

  a {
    color: $theme_color;
  }
}

.row_container {
  height: 70px;
}

.nav_list {
  height: inherit;

  li {
    display: inline-block;
    margin-right: 18px;
    font-weight: bold;
  }
}

.logo {
  padding: 10px;

  img {
    width: 100%;
  }
}

.entry {
  text-align: right;
}
</style>
