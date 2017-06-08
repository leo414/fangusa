<template lang="html">
  <div class="new_house container">
    <h2 class="h2">{{title}}</h2>

    <el-row type="flex" justify="space-between" class="code-row-bg">
      <el-col class="house" :span="8">
        <house-lay />
      </el-col>
      <el-col class="house" :span="8">
        <house-lay />
      </el-col>
      <el-col class="house" :span="8">
        <house-lay />
      </el-col>
    </el-row>

    <el-row type="flex" justify="space-between" class="code-row-bg">
      <el-col class="house" :span="8">
        <house-lay />
      </el-col>
      <el-col class="house" :span="8">
        <house-lay />
      </el-col>
      <el-col class="house" :span="8">
        <house-lay />
      </el-col>
    </el-row>
  </div>
</template>

<script>

import HouseLay from '../layout/house-lay'

export default {
  name: 'HouseList',
  props: {
    title: String,
  },
  components: {
    HouseLay,
  },
  data() {
    return {
      value2: 0,
    }
  }
}
</script>

<style lang="scss" scoped>
.new_house {
  margin-top: 20px;
}

.h2 {
  padding: 20px 0;
}

.house {
  padding-right: 15px;
  &:last-child {
    padding-right: 0;
  }
}

</style>
