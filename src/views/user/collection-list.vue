<template>
  <div>
    <el-row :gutter="20" class="house_list" v-if="results.length">
      <el-col :span="8" v-for="(info, key) in results" :key="key">
        <house-lay :info="info.house" />
      </el-col>
    </el-row>
    <p v-else>暂无收藏数据</p>
  </div>
</template>

<script>
import HouseLay from 'components/house-lay/house-lay'

export default {
  name: 'CollectionList',
  components: {
    HouseLay,
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
      this.$http.get(this.API.USER.Fav).then(res => {
        if(res.results) {
          this.results = res.results
          this.total = res.total
        }
      })
    },
  }  
}
</script>

<style>
  
</style>
