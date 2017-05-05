<template lang="html">
  <div id="new_house" class="container">
    <h1 class="h1">{{title}}</h1>
    <Carousel id="banner" autoplay v-model="value2">
      <Carousel-item>
        <Row type="flex" justify="space-between" class="code-row-bg">
          <Coll class="house" span="8">
            <HouseLayout />
          </Coll>
          <Coll class="house" span="8">
            <HouseLayout />
          </Coll>
          <Coll class="house" span="8">
            <HouseLayout />
          </Coll>
        </Row>
      </Carousel-item>

      <Carousel-item>
        <Row type="flex" justify="space-between" class="code-row-bg">
          <Coll class="house" span="8">
            <HouseLayout />
          </Coll>
          <Coll class="house" span="8">
            <HouseLayout />
          </Coll>
          <Coll class="house" span="8">
            <HouseLayout />
          </Coll>
        </Row>
      </Carousel-item>
    </Carousel>
  </div>
</template>

<script>
import { Row, Col } from 'iview/src/components/grid'
import Carousel from 'iview/src/components/carousel'
const CarouselItem = Carousel.Item
import HouseLayout from './HouseLayout.vue'

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
  color: #000;
  font-size: 32px;
}

</style>
