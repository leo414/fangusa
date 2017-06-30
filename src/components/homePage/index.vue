<template lang="html">
<section>
  <Search />
  <div 
    v-infinite-scroll="loadMore"
    infinite-scroll-disabled="loading"
    infinite-scroll-distance="10"
    :infinite-scroll-immediate-check="true"
    class="house_lsit"
  >
    <house-layout v-for="(info, index) in houseList" :info="info" :key="index" />
    <div v-if="!isAllLoad">
      <p v-show="loading" class="scroll_loading">
        <mt-spinner type="fading-circle"></mt-spinner>
        加载中...
      </p>
    </div>
  </div>
</section>
</template>

<script>
import Search from './Search'
import HouseLayout from '../globalLayout/HouseLayout'

export default {
  name: 'HomePage',
  components: {
    Search,
    HouseLayout,
  },
  data() {
    const { query } = this.$route
    return {
      loading: false,
      houseList: [],
      page: 1,
      count: 1,
      total: 0,
      isAllLoad: false,
      query,
    }
  },
  mounted() {
    this.fetchData()
  },

  watch: {
    $route(to) {
      const { query } = to
      this.query = query
      this.houseList = []
      this.page = 1
      this.fetchData()
    },
  },

  methods: {
    fetchData() {
      const data = {
        params: {
          page: this.page,
          ...this.query,
        }
      }
      this.$http.get(this.API.HOUSE.List, data).then(res => {
        if(res.results) {
          this.houseList = [...this.houseList, ...res.results]
          this.count = res.count
          if(this.loading) this.loading = false
        }
      })
    },
    loadMore(){
      this.loading = true
      if(this.page >= Math.ceil(this.count / 30)) {
        this.isAllLoad = true
        return
      }
      this.page = this.page + 1
      this.fetchData()
    },
  },
}
</script>

<style lang="scss" scoped>
.house_lsit {
  margin-top: 90px;
}

.mint-spinner-fading-circle {
  display: inline-block;
}

.scroll_loading {
  text-align: center;
  height: 50px;
  line-height: 50px;
  // 部分样式在 minthack .scss
}
</style>
