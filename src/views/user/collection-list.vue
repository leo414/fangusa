<template>
  <div>
    <h3 class="h3">收藏房源</h3>

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
  name: 'CollectionList',
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
}
</script>

<style>
  
</style>
