<template>
<section id="link_page">
  <div class="slide-wrap">
    <div class="item" v-for="(item, index) in img_list" :key="index">{{item}}</div>
  </div>

  <div class="pagenumber">
    <div :class="index === startSlide ? 'now' : ''" v-for="(item, index) in img_list" :key="index"></div>
  </div>
</section>

</template>

<script>
import Fmover from 'finger-mover'
import fmoverSlideX from 'fmover-slide-x'

export default {
  name: "LinkPage",
  data() {
    return {
      img_list: ['图1', '图2', '图3'],
      startSlide: 0,
    }
  },
  mounted() {
    const self = this
    new Fmover({
      el: '.slide-wrap',
      plugins: [
        fmoverSlideX({
          loop: false,
          onChangeStart(index){
            console.log(index)
            self.startSlide = index - 1
          }
        })
      ]
    })
  }
}
</script>

<style>
.slide-wrap {
  height: 100vh !important;
}

.slide-wrap .item {
  font-size: 30px;
  text-align: center;
  background-color: #19bbff;
  color: #fff;
}

.pageview{
  -webkit-box-flex: 1;
  width: 0;
}
.pagenumber{
  display: -webkit-box;
  position: absolute;
  bottom: 2em;
  left: 35%;
  height: 2em;
  width: 30%;
}
.pagenumber div{
  -webkit-box-flex: 1;
  width: 0;
  position: relative;
}
.pagenumber .now:after {
  background: rgba(255,255,255,1) !important;
}
.pagenumber div:after{
  content: "";
  width: 8px;
  height: 8px;
  background: rgba(255,255,255,0.5);
  border-radius: 2em;
  position: absolute;
  top: 50%;
  left: 50%;
  margin-top: -0.2em;
  margin-left: -0.2em;
}
</style>
