<template>
<section id="PhotoShow">
  <Carousel v-model="value1">
     <Carousel-item>
        <div class="photo"></div>
     </Carousel-item>
     <Carousel-item>
        <div class="photo"></div>
     </Carousel-item>
     <Carousel-item>
        <div class="photo"></div>
     </Carousel-item>
     <Carousel-item>
        <div class="photo"></div>
     </Carousel-item>
   </Carousel>
   <ul class="small_photo">
    <li><img src="http://placehold.it/60x30" /></li>
    <li><img src="http://placehold.it/60x30" /></li>
    <li><img src="http://placehold.it/60x30" /></li>
    <li><img src="http://placehold.it/60x30" /></li>
    <li><img src="http://placehold.it/60x30" /></li>
    <li><img src="http://placehold.it/60x30" /></li>
   </ul>
</section>

</template>
<script>
import Carousel from 'iview/src/components/carousel'
const CarouselItem = Carousel.Item

export default {
  name: "PhotoShow",
  components: {
    Carousel,
    CarouselItem,
  },
  data() {
    return {
      value1: 0,
    }
  }
}
</script>
<style lang="scss" scoped>
#PhotoShow {
  background: #fff;
  clear: both;
}

.photo {
  width: 100%;
  height: 400px;
  background: url('http://placehold.it/740x400') center center no-repeat;
  background-size: cover;
}

.small_photo {
  width: 100%;
  height: 30px;
  overflow: hidden;
  text-align: center;
  font-size: 0;

  li {
    display: inline-block;
    margin-right: 2px;
  }
}
</style>
