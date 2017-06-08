<template lang="html">
<div class="blog_list container">
  <header class="header">
    <h1 class="h1 fl">博客</h1>
    <router-link class="more_articles" to="/">更多文章</router-link>
  </header>

  <Carousel id="banner" autoplay v-model="value2">
    <Carousel-item>
      <el-row type="flex" justify="space-between" class="code-row-bg">
        <el-col class="blog" :span="6">
          <BlogLayout />
        </el-col>
        <el-col class="blog" :span="6">
          <BlogLayout />
        </el-col>
        <el-col class="blog" :span="6">
          <BlogLayout />
        </el-col>
        <el-col class="blog" :span="6">
          <BlogLayout />
        </el-col>
      </el-row>
    </Carousel-item>
    <Carousel-item>
      <el-row type="flex" justify="space-between" class="code-row-bg">
        <el-col class="blog" :span="6">
          <BlogLayout />
        </el-col>
        <el-col class="blog" :span="6">
          <BlogLayout />
        </el-col>
        <el-col class="blog" :span="6">
          <BlogLayout />
        </el-col>
        <el-col class="blog" :span="6">
          <BlogLayout />
        </el-col>
      </el-row>
    </Carousel-item>
  </Carousel>
</div>
</template>

<script>

import Carousel from 'iview/src/components/carousel'
import Icon from 'iview/src/components/icon'
import Button from 'iview/src/components/button'
const CarouselItem = Carousel.Item
import BlogLayout from './BlogLayout

export default {
  name: 'BlogList',
  components: {
    Row,
    Coll: Col,
    Carousel,
    CarouselItem,
    BlogLayout,
    Icon,
    iButton: Button,
  },
  data() {
    return {
      value2: 0,
    }
  }
}
</script>

<style lang="scss" scoped>
@import '../../scss/variables.scss';

.blog_list {
  margin-top: 60px;
}

.blog {
  padding-right: 15px;
  &:last-child {
    padding-right: 0;
  }
}

.header {
  width: 100%;
  height: 40px;
  margin: 15px 0;
  clear: both;

  .h1 {
    color: #324057;
  }

  .more_articles {
    margin-top: 5px;
    float: right;
    font-size: 12px;
    line-height: 15px;
    padding: 5px 15px;
    border: 1px $theme_color solid;
    color: $theme_color;
    border-radius: 5px;
  }
}
</style>
