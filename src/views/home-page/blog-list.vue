<template lang="html">
<div class="blog_list container">
  <header class="header">
    <h2 class="h2 fl">博客</h2>
    <el-button class="more_articles" size="small">更多文章</el-button>
  </header>

  <el-row type="flex" justify="space-between" class="code-row-bg">
    <el-col class="blog" v-for="(info, index) in results" :span="6" :key="index">
      <blog-lay :info="info" />
    </el-col>
  </el-row>
</div>
</template>

<script>
import BlogLay from '../layout/blog-lay'

export default {
  name: 'BlogList',
  components: {
    BlogLay,
  },
  data() {
    return {
      results: [],
    }
  },
  mounted() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      this.$http.get(this.API.OTHER.Article).then(res => {
        if(res.results) {
          this.results = res.results.slice(0, 4)
        }
      })
    }
  },
}
</script>

<style lang="scss" scoped>
@import '../../scss/variables';

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

  .more_articles {
    margin-top: 5px;
    float: right;
    font-size: 12px;
    line-height: 15px;
    color: $theme_color;
  }
}
</style>
