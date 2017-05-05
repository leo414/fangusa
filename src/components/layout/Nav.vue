<template lang="html">
<section class="bg_white_container">
  <div id="nav" class="container">
    <Row>
      <Coll span="4" class="logo">
        <router-link to="/"><img src="../../assets/logo.png" alt=""></router-link>
      </Coll>
      <Coll span="16" offset="1">
        <ul class="nav_list">
          <li><router-link to="#">首页</router-link></li>
          <li><router-link to="#">全部房产信息</router-link></li>
          <li><router-link to="#">美国置业指南</router-link></li>
          <li><router-link to="#">一站式服务</router-link></li>
          <li><router-link to="#">精品看房团</router-link></li>
          <li><router-link to="#">博客</router-link></li>
          <li><router-link to="#">联系我们</router-link></li>
        </ul>
      </Coll>
      <Coll class="entry" span="3">
        <router-link to="login">登录</router-link>
        <i class="i shugang" />
        <router-link to="register">注册</router-link>
      </Coll>
    </Row>
  </div>
</section>
</template>

<script>
import { Row, Col } from 'iview/src/components/grid'

export default {
  name: 'Nav',
  components: {
    Row,
    'Coll': Col,
  },
  data() {
    return {
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

.nav_list {
  height: inherit;

  li {
    display: inline-block;
    margin-right: 15px;
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
