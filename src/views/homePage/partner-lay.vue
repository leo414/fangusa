<template lang="html">
<div class="container" id="partner">
  <h2 class="h2">
    合作伙伴
  </h2>

  <el-row class="partner_list" :gutter="8">
    <el-col :span="6">
      <div class="item"></div>
    </el-col>
    <el-col :span="6">
      <div class="item"></div>
    </el-col>
    <el-col :span="6">
      <div class="item"></div>
    </el-col>
    <el-col :span="6">
      <div class="item"></div>
    </el-col>
  </el-row>

  <el-row class="partner_list" :gutter="8">
    <el-col :span="6">
      <div class="item"></div>
    </el-col>
    <el-col :span="6">
      <div class="item"></div>
    </el-col>
    <el-col :span="6">
      <div class="item"></div>
    </el-col>
    <el-col :span="6">
      <div class="item"></div>
    </el-col>
  </el-row>
</div>
</template>

<script>

export default {
  name: 'PartnerLay',
}
</script>

<style lang="scss" scoped>
#partner {
  margin-top: 60px;
}

.partner_list {
  margin-top: 20px;
  height: 160px;

  &:last-child {
    margin-top: 8px;
  }

  .item {
    height: 160px;
    background: url('http://placehold.it/256x160') center center no-repeat;
    background-size: cover;
  }
}
</style>
