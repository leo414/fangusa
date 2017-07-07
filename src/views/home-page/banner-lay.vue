<template lang="html">
  <el-carousel indicator-position="outside" height="500px">
    <el-carousel-item 
      v-for="(banner, index) in bannerList" 
      :key="index" 
      @click.native="goDetail(banner.url_object_id)"
      :style="background(banner.front_image_url)"
      class="banner_item">
    </el-carousel-item>
  </el-carousel>
</template>

<script>

export default {
  name: 'BannerLay',
  data() {
    return {
      bannerList: [],
    }
  },
  mounted() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      this.$http.get(this.API.HOUSE.List + '?banner=2').then(res => {
        if(res.results) {
          this.bannerList = res.results
        }
      })
    },
    background(img) {
      return {
        backgroundImage: 'url('+ img +')',
        backgroundSize: 'cover',
        backgroundRepeat: 'no-repeat',
        backgroundPosition: 'center',
        cursor: 'pointer',
      }
    },
    goDetail(id) {
      this.$router.push('/house/' + id)
    },
  },
}
</script>

<style lang="scss" scoped>
.el-carousel__item h3 {
  color: #475669;
  font-size: 18px;
  opacity: 0.75;
  line-height: 500px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}
</style>
