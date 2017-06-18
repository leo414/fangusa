<template lang="html">
<section id="hot_city" class="container">
  <h2 class="h2">热门城市</h2>
  <el-row type="flex" justify="space-between">
    <el-col class="city" :span="8"></el-col>
    <el-col class="city" :span="8"></el-col>
    <el-col class="city" :span="8"></el-col>
  </el-row>

   <el-row type="flex" justify="space-between">
    <el-col class="city" :span="8"></el-col>
    <el-col class="city" :span="8"></el-col>
    <el-col class="city" :span="8"></el-col>
  </el-row>
</section>
</template>

<script>

export default {
  name: 'HotCity',
}
</script>

<style lang="scss" scoped>
#hot_city {
  margin-top: 20px;
}

.h2 {
  padding: 20px 0;
}

.city {
  width: 330px;
  height: 330px;
  margin-bottom: 28px;
  background: url('http://placehold.it/330x330') center center no-repeat;
  background-size: cover;
}
</style>
