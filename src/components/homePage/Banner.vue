<template lang="html">
  <Carousel id="banner" autoplay v-model="value2">
    <Carousel-item>
      <div class="demo-carousel">1</div>
    </Carousel-item>
    <Carousel-item>
      <div class="demo-carousel">2</div>
    </Carousel-item>
    <Carousel-item>
      <div class="demo-carousel">3</div>
    </Carousel-item>
    <Carousel-item>
      <div class="demo-carousel">4</div>
    </Carousel-item>
  </Carousel>
</template>

<script>
import Carousel from 'iview/src/components/carousel'
const CarouselItem = Carousel.Item

export default {
  name: 'Banner',
  components: {
    Carousel,
    CarouselItem,
  },
  data() {
    return {
      value2: 0,
    }
  }
}
</script>

<style lang="scss" scoped>
#banner {
  width: 100%;
  height: 500px;
  line-height: 500px;
}

.demo-carousel {
  width: inherit;
  height: inherit;
  text-align: center;
  color: #fff;
  font-size: 20px;
  background: #506b9e;
}
</style>
