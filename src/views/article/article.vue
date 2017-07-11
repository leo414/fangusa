<template>
<article class="container">
  <h1 class="h1">{{article.title}}</h1>
  <small>发表时间 {{article.add_time && article.add_time.substring(0, 10)}}</small>
  <header class="header">
    <img :src="article.front_image" alt="">
  </header>
  <section class="content" v-html="article.content"></section>
  <div class="tag_list">
    标&nbsp;&nbsp;&nbsp;&nbsp;签&nbsp;&nbsp;
    <span class="tag" v-for="(tag, index) in article.tags" :key="index">{{tag}}</span>
  </div>
</article>  
</template>

<script>
export default {
  name: 'BlogList',
  data() {
    return {
      article: {},
    }
  },
  mounted() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      const { id } = this.$route.params
      this.$http.get(this.API.OTHER.Article + id + '/').then(res => {
        if(res) {
          this.article = res
        }
      })
    }
  },
}
</script>

<style lang="scss" scoped>
.h1 {
  font-size: 24px;
}  

.header {
  width: 100%;
  text-align: center;
  height: 300px;

  img {
    height: 300px;
  }
}

.content {
  margin-top: 20px;
  width: 100%;
  text-align: left;
}

.tag_list {
  margin-top: 30px;
  width: 100%;
  height: 26px;

  .tag {
    margin-right: 20px;
    padding: 0 13px;    
    height: 26px;
    line-height: 26px;    
    display: inline-block;
    border-radius: 13px;
    cursor: pointer;
    background-color: #e3e6e9;
    font-size: 14px;
    color: #000;
  }
}
</style>
