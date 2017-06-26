<template>
<section class="photo_show">
  <el-carousel indicator-position="outside" height="400px">
    <el-carousel-item v-for="(img, index) in images" :key="index" class="banner_item">
      <div class="photo" :style="background(img)"></div>
    </el-carousel-item>
  </el-carousel>
  <ul class="small_photo">
    <li item v-for="(img, index) in images" :key="index" :style="background(img)"></li>
  </ul>
</section>
</template>
<script>
export default {
  name: "PhotoShow",
  props: {
    images: {
      type: Array,
      default() {
        return []
      },
    },
  },
  data() {
    return {
    }
  },
  methods: {
    background(image) {
      return {
        backgroundImage: 'url('+ image +')',
        backgroundSize: 'cover',
        backgroundRepeat: 'no-repeat',
        backgroundPosition: 'center',
      }
    },
  },
}
</script>
<style lang="scss" scoped>
.photo_show {
  background: #fff;
  clear: both;
}

.photo {
  width: 100%;
  height: 400px;
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
    width: 60px;
    height: 30px;
  }
}
</style>
