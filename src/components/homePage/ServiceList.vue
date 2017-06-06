<template lang="html">
<section class="service_list container">
  <h1 class="h1">一站式服务</h1>
  <el-row class="table">
    <el-col :span="6" class="box">
      <div class="icon icon-1"></div>
      <p class="h2">置业指南</p>
      <div class="desc">
        Lorem ipsum dolor sit amet, consectetur adipisicing elit.
        Saepe, maxime, autem! Recusandae architecto, vitae culpa,
      </div>
      <router-link class="find" to="">Find more</router-link>
    </el-col>

    <el-col :span="6" class="box">
      <div class="icon icon-2"></div>
      <p class="h2">房屋贷款</p>
      <div class="desc">
        Lorem ipsum dolor sit amet, consectetur adipisicing elit.
        Saepe, maxime, autem! Recusandae architecto, vitae culpa,
      </div>
      <router-link class="find" to="">Find more</router-link>
    </el-col>

    <el-col :span="6" class="box">
      <div class="icon icon-3"></div>
      <p class="h2">置业托管</p>
      <div class="desc">
        Lorem ipsum dolor sit amet, consectetur adipisicing elit.
        Saepe, maxime, autem! Recusandae architecto, vitae culpa,
      </div>
      <router-link class="find" to="">Find more</router-link>
    </el-col>

    <el-col :span="6" class="box">
      <div class="icon icon-4"></div>
      <p class="h2">私人订制</p>
      <div class="desc">
        Lorem ipsum dolor sit amet, consectetur adipisicing elit.
        Saepe, maxime, autem! Recusandae architecto, vitae culpa,
      </div>
      <router-link class="find" to="">Find more</router-link>
    </el-col>
  </el-row>
</section>
</template>

<script>
import { Row, Col } from 'iview/src/components/grid'
import Carousel from 'iview/src/components/carousel'
const CarouselItem = Carousel.Item

export default {
  name: 'ServiceList',
  components: {
    Row,
    Coll: Col,
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
@import '../../scss/mixins.scss';

.h1 {
  margin: 40px 0;
  color: #000;
  text-align: center;
}

.table {
  height: 340px;
  background: #fff;
  text-align: center;
  border: 1px #eee solid;
}

.box{
  height: 340px;
  padding: 60px 20px 20px 20px;
  border-right: 1px #eee solid;

  &:last-child {
    border: none;
  }

  .icon {
    width: 80px;
    height: 80px;
    display: inline-block;
    margin-bottom: 20px;
  }

  .icon-1 {
    background: url('http://ww3.sinaimg.cn/large/006tNbRwly1ffas591qpuj30bc0bcjsy.jpg') center center no-repeat;
    background-size: contain;
  }

  .icon-2 {
    background: url('http://ww4.sinaimg.cn/large/006tNbRwly1ffas53hh68j308o0bkdg3.jpg') center center no-repeat;
    background-size: contain;
  }

  .icon-3 {
    background: url('http://ww3.sinaimg.cn/large/006tNbRwly1ffas53nnzrj309u0bomzq.jpg') center center no-repeat;
    background-size: contain;
  }

  .icon-4 {
    background: url('http://ww4.sinaimg.cn/large/006tNbRwly1ffas53scz9j30aa09o3z5.jpg') center center no-repeat;
    background-size: contain;
  }

  .h2 {
    font-weight: bold;
    font-size: 20px;
    color: #000;
  }

  .desc {
    height: 60px;
    font-size: 12px;
    @include text-multiLine-ellipsis(3, 20px)
  }

  .find {
    display: block;
    margin-top: 15px;
    font-size: 16px;
  }
}
</style>
