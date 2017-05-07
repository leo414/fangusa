<template>
<section id="HouseDetail" class="container">
  <header calss="header">
    <h1 class="h1">
      旧金山三室两厅独栋别墅
      <i-button size="small" class="vr"><Icon type="ios-videocam" /> VR 看房</i-button>
      <i-button size="small" class="mark"><Icon type="ios-star-outline"></Icon> 加入收藏</i-button>
      <i-button size="small" class="wechat"><i class="i i-weixin" /> 微信分享</i-button>
      <span class="fr price">
        售价：$350,000（约￥50万）
      </span>
    </h1>
  </header>

  <div class="content_left">
    <h3 class="fl">2015 年建造 | 190 平米</h3>
    <small class="fr u_line pointer" @click="print">打印此页</small>
    <PhotoShow />
    <HouseInfo />
  </div>

  <div class="content_right">
    <h3 class="tr">估计月租金收入：$1800（约￥8500）</h3>
    <CreditComputed />
    <OtherHouse />
  </div>
</section>
</template>

<script>
import Button from 'iview/src/components/button'
import Icon from 'iview/src/components/icon'
import PhotoShow from './PhotoShow.vue'
import CreditComputed from './CreditComputed.vue'
import HouseInfo from './HouseInfo.vue'
import OtherHouse from './OtherHouse.vue'

export default {
  name: "HouseDetail",
  components: {
    iButton: Button,
    Icon,
    PhotoShow,
    CreditComputed,
    HouseInfo,
    OtherHouse,
  },
  data() {
    return {

    }
  },
  methods: {
    print() {
      window.print()
    }
  },
}
</script>

<style lang="scss">
@import "../../scss/variables";

#HouseDetail {
  margin-top: 30px;

  .content_left {
    margin-right: 30px;
    width: 740px;
    float: left;

    @media screen and (max-width: 750px) {
      width: 100%;
    }
  }

  .content_right {
    width: 280px;
    float: right;

    @media screen and (max-width: 750px) {
      display: none;
    }
  }

  h3 {
    margin-bottom: 10px;
  }
}

.price {
  @media screen and (max-width: 750px) {
    display: none;
  }
}

.header {
  width: 100%;

  .h1 {
    height: 40px;
    line-height: 40px;
  }
}

.vr {
  margin-bottom: 5px;
  margin-left: 10px;
  background: $btn_color;
  color: #fff;
  border: none;
  font-size: 12px;
  padding: 0px 8px;

  i {
    font-size: 14px;
  }
}


.mark {
  @extend .vr;
  background: $theme_color;
}

.wechat {
  @extend .vr;
  background: $we_color;
}
</style>
