<template>
  <div class="container">
    <header class="header">
      <h2 class="fl">房产信息</h2>
      <el-button type="primary" class="fr btn"><router-link to="/map">地图选房</router-link></el-button>
    </header>
    <el-row :gutter="20" class="house_list">
      <el-col :span="8"><house-lay /></el-col>
      <el-col :span="8"><house-lay /></el-col>
      <el-col :span="8"><house-lay /></el-col>
      <el-col :span="8"><house-lay /></el-col>
      <el-col :span="8"><house-lay /></el-col>
      <el-col :span="8"><house-lay /></el-col>
      <el-col :span="8"><house-lay /></el-col>
      <el-col :span="8"><house-lay /></el-col>
      <el-col :span="8"><house-lay /></el-col>
      <el-col :span="8"><house-lay /></el-col>
      <el-col :span="8"><house-lay /></el-col>
    </el-row>
  </div>
</template>

<script>
import HouseLay from 'components/house-lay/house-lay'
export default {
  name: 'SearchResult',
  components: {
    HouseLay,
  },
}
</script>

<style lang="scss" scoped>
  .container {
    margin-top: 100px;
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
</style>
