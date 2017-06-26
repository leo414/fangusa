<template>
<section class="house_detail_container container">
  <header class="header">
    <h1 class="h1">
      {{info.beds}}室{{info.baths}}卫 {{info.house_type}}
      <el-button size="small" class="vr"><i class="i i-vr" /> VR 看房</el-button>
      <el-button size="small" class="mark"><i class="i i-star" /> 加入收藏</el-button>
      <el-tooltip placement="top" effect="light">
        <QrImage slot="content" houseId="url_object_id"></QrImage>
        <el-button size="small" class="wechat"><i class="i i-weixin" /> 微信分享</el-button>
      </el-tooltip>
      <span class="fr price">
        售价：${{info.zestimate}}（约￥{{info.zestimate | toRMB_W}}万）
      </span>
    </h1>
  </header>

  <div class="content_left">
    <h3 class="fl subtitle">{{info.build_year}} 年建造 | {{parseInt(info.square *  0.093)}} 平米</h3>
    <small class="fr u_line pointer" @click="print">打印此页</small>
    <photo-show :images="info.image_urls" />
    <house-info :info="info" />
  </div>

  <div class="content_right">
    <h3 class="tr subtitle">估计月租金收入 ${{info.rent_estimate}} (约￥{{info.rent_estimate | toRMB}})</h3>
    <credit-computed :price="info.zestimate"></credit-computed>
    <other-house />
  </div>
</section> 
</template>

<script>
import PhotoShow from './photo-show'
import CreditComputed from './credit-computed'
import HouseInfo from './house-info'
import OtherHouse from './other-house'
import QrImage from 'components/qr-image/qr-image'

export default {
  name: "HouseDetail",
  components: {
    PhotoShow,
    CreditComputed,
    HouseInfo,
    OtherHouse,
    QrImage,
  },
  data() {
    return {
      info: {},
    }
  },
  mounted() {
    this.fetchData()
  },
  methods: {
    print() {
      window.print()
    },
    fetchData() {
      this.$http.get(this.API.HOUSE.List + this.$route.params.id + '/').then(res => {
        if(res) {
          this.info = res
        }
      })
    },
  },
}
</script>

<style lang="scss">
@import "../../scss/variables";

.house_detail_container {
  margin-top: 30px;

  .content_left {
    margin-right: 30px;
    width: 740px;
    float: left;

    @media screen and (max-width: $container_width) {
      width: 100%;
    }
  }

  .content_right {
    width: 280px;
    float: right;

    @media screen and (max-width: $container_width) {
      display: none;
    }
  }

  .subtitle { 
    font-weight: 400;
    margin-bottom: 10px; 
    font-size: 16px;
  }
}

.price {
  @media screen and (max-width: $container_width) {
    display: none;
  }
}

.header {
  width: 100%;

  .h1 {
    height: 40px;
    line-height: 40px;
    font-size: 28px;
  }
}

.vr {
  margin-left: 10px;
  margin-bottom: 6px;
  vertical-align: middle;
  background: $btn_color;
  color: #fff;
  border: none;
  font-size: 12px;

  &:hover {
    color: #fff;
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
