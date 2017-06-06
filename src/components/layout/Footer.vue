<template lang="html">
<footer id="footer" class="bg_white_container">
  <div class="container">
    <el-row class="top">
      <el-col :span="8">
        <router-link class="logo" to="/"><img src="../../assets/logo.png" alt=""></router-link>
        <p>
          文字内容简介 文字内容简介 文字内容简介 文字内容简介 文字内容简介 文字内容简介
          文字内容简介 文字内容简介 文字内容简介 文字内容简介 文字内容简介 文字内容简介 文字内容简介
        </p>
      </el-col>

      <el-col :span="6" :offset="2">
        <h2 class="h2">网站导航</h2>
        <ul class="nav_list">
          <li><router-link to="#">首页</router-link></li>
          <li><router-link to="#">全部房产信息</router-link></li>
          <li><router-link to="#">美国置业指南</router-link></li>
          <li><router-link to="#">一站式服务</router-link></li>
          <li><router-link to="#">精品看房团</router-link></li>
          <li><router-link to="#">博客</router-link></li>
        </ul>
      </el-col>

      <el-col :span="6" :offset="2">
        <h2 class="h2">微信公众号</h2>
        <img src="http://placehold.it/120x120" alt="" />
        <p>公众号描述，描述</p>
      </el-col>
    </el-row>
  </div>

  <el-row class="bottom">
    <div class="container">
      <el-col :span="8" class="tl pl-30">
        <router-link to="#">备案信息</router-link>
      </el-col>
      <el-col :span="8">
        <router-link to="#">使用条款</router-link>
        <i class="i i-shugang" />
        <router-link to="#">隐私协议</router-link>
        <i class="i i-shugang" />
        <router-link to="#">关于我们</router-link>
        <i class="i i-shugang" />
        <router-link to="#">联系我们</router-link>
      </el-col>
      <el-col :span="8" class="tr pr-30">
        社交媒体 icon
      </el-col>
    </div>
  </el-row>
</footer>
</template>

<script>
import { Row, Col } from 'iview/src/components/grid'
export default {
  name: 'Footer',
  components: {
    Row,
    'Coll': Col,
  },
}
</script>

<style lang="scss" scoped>
@import "../../scss/variables.scss";
#footer {
  margin-top: 50px;
  padding-top: 30px;
  border-top: 14px $btn_color solid;
}

.top {
  .h2 {
    margin-bottom: 10px;
    color: #000;
  }
  .nav_list {
    li {
      margin-bottom: 10px;
    }

    a {
      color: #333;
      margin-bottom: 10px;
    }
  }

  .logo {
    width: 200px;
    display: block;
    margin-bottom: 20px;

    img {
      width: inherit;
    }
  }
}

.bottom {
  margin-top: 30px;
  width: 100%;
  height: 40px;
  line-height: 40px;
  background: $theme_color;
  text-align: center;
  color: #fff;

  a {
    color: #fff;
  }
}
</style>
