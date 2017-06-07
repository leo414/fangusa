<template lang="html">
  <div id="new_house" class="container">
    <h1 class="h1">{{title}}</h1>
    <Carousel id="banner" v-model="value2">
      <Carousel-item>
        <el-row type="flex" justify="space-between" class="code-row-bg">
          <el-col class="house" :span="8">
            <HouseLayout />
          </el-col>
          <el-col class="house" :span="8">
            <HouseLayout />
          </el-col>
          <el-col class="house" :span="8">
            <HouseLayout />
          </el-col>
        </el-row>
      </Carousel-item>

      <Carousel-item>
        <el-row type="flex" justify="space-between" class="code-row-bg">
          <el-col class="house" :span="8">
            <HouseLayout />
          </el-col>
          <el-col class="house" :span="8">
            <HouseLayout />
          </el-col>
          <el-col class="house" :span="8">
            <HouseLayout />
          </el-col>
        </el-row>
      </Carousel-item>
    </Carousel>
  </div>
</template>

<script>

import Carousel from 'iview/src/components/carousel'
const CarouselItem = Carousel.Item
import HouseLayout from './HouseLayout

export default {
  name: 'HouseList',
  props: {
    title: String,
  },
  components: {
    Row,
    Coll: Col,
    Carousel,
    CarouselItem,
    HouseLayout,
  },
  data() {
    return {
      value2: 0,
    }
  }
}
</script>

<style lang="scss" scoped>
#new_house {
  margin-top: 20px;
}

.h1 {
  padding: 20px 0;
}

.house {
  padding-right: 15px;
  &:last-child {
    padding-right: 0;
  }
}

</style>
