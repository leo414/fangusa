<template>
  <div class="container">
    <header class="header">
      <h2 class="fl">房产信息</h2>
      <el-button type="primary" class="fr btn"><router-link to="/map">地图选房</router-link></el-button>
    </header>
    <el-row :gutter="20" class="house_list">
      <el-col :span="8" v-for="(info, key) in results" :key="key">
        <house-lay :info="info" />
      </el-col>
    </el-row>

    <el-pagination
      class="pagination"
      layout="prev, pager, next"
      :page-size="30"
      @current-change="onChagePage"
      :total="total">
    </el-pagination>
  </div>
</template>

<script>
import HouseLay from 'components/house-lay/house-lay'
export default {
  name: 'SearchResult',
  components: {
    HouseLay,
  },
  data() {
    return {
      results: [],
      pageCount: 1,
      total: 0,
    }
  },
  mounted() {
    this.fetchData()
  },

  watch: {
    $route() {
      this.fetchData()
    },
  },

  methods: {
    onChagePage(page) {
      this.currentPage = page
      this.fetchData()
    },

    fetchData() {
      const data = {
        params: {
          ...this.$route.query,
          page: this.currentPage,
        }
      }
      this.$http.get(this.API.HOUSE.List, data).then(res => {
        if(res.results) {
          this.results = res.results
          this.total = res.count
        }
      })
    },
  },
}
</script>

<style lang="scss" scoped>
  .container {
    margin-top: 170px;
  }

  .header {
    width: 100%;
    height: 40px;
    line-height: 40px;

    .btn {
      margin-top: 5px;
    }

    a {
      color: #fff;
    }
  }

  .el-col {
    margin-top: 20px;
  }

  .pagination {
    margin-top: 20px;
    text-align: center;
  }
</style>
