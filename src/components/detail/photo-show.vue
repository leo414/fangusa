<template>
<section id="PhotoShow">
  <el-carousel indicator-position="outside" height="400px">
    <el-carousel-item v-for="item in 4" :key="item" class="banner_item">
      <div class="photo"></div>
    </el-carousel-item>
  </el-carousel>
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
export default {
  name: "PhotoShow",
  data() {
    return {
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
