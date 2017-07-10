<template>
<article class="container">
  <h1>{{article.title}}</h1>
  <small>发表时间 {{article.add_time && article.add_time.substring(0, 10)}}</small>
  <header></header>
  <section v-html="article.content"></section>
  <div class="tag_list">

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

<style>
  
</style>
