<template>
<section id="house_detail">
  <div class="header">
    <i @click="$router.go(-1)" class="i go_back i-xiangzuojiantou" />
    房产详情
    <div class="icon"><i class="i i-weixin" /></div>
  </div>

  <mt-swipe :auto="2000" class="house_img_list">
    <mt-swipe-item v-for="(img, index) in info.image_urls" :key="index" :style="background(img)">
    </mt-swipe-item>
  </mt-swipe>

  <section class="house_info">
    <div class="title">
      <div class="fl text_ellipsis">{{info.city_name}} {{info.beds}}室{{info.baths}}卫 {{info.house_type}}</div>
      <div class="fr text_ellipsis">${{info.zestimate}}</div>
    </div>
    <div class="info">
      <div class="fl">房产编号：{{info.zpid}}</div>
      <div class="fr" v-if="info.zestimate">约¥{{info.zestimate | toRMB_W}}万</div>
    </div>
    <!--<a href="/" class="vr_btn"><i class="i i-vr"></i> VR 看房</a>-->
  </section>

  <div class="divide_bar">
    <p class="fl">房屋介绍</p>
    <i class="fr i i-xiangshangjiantou" />
  </div>
  <div class="desc">
    <p>{{info.house_desc}}</p>
  </div>
  <div class="divide_bar">
    <p class="fl">房屋详情</p>
    <i class="fr i i-xiangshangjiantou" />
  </div>
  <div class="detail">
    <div class="cell">
      <span class="fl text_ellipsis">房屋编号</span>
      <span class="fr text_ellipsis">{{info.zpid  || '暂无数据'}}</span>
    </div>
    <div class="cell">
      <span class="fl text_ellipsis">房屋地址</span>
      <span class="fr text_ellipsis">{{info.address  || '暂无数据'}}</span>
    </div>
    <div class="cell">
      <span class="fl text_ellipsis">居住面积</span>
      <span class="fr text_ellipsis">{{info.square + ' sqft'  || '暂无数据'}}</span>
    </div>
    <div class="cell">
      <span class="fl text_ellipsis">土地面积：</span>
      <span class="fr text_ellipsis">{{info.lot + ' sqft' || '暂无数据'}}</span>
    </div>
    <div class="cell">
      <span class="fl text_ellipsis">建筑年代</span>
      <span class="fr text_ellipsis">{{info.build_year  || '暂无数据'}}</span>
    </div>
    <div class="cell">
      <span class="fl text_ellipsis">房屋类型</span>
      <span class="fr text_ellipsis">{{info.house_type || '暂无数据'}}</span>
    </div>
    <div class="cell">
      <span class="fl text_ellipsis">卧室数</span>
      <span class="fr text_ellipsis">{{info.beds || '暂无数据'}}</span>
    </div>
    <div class="cell">
      <span class="fl text_ellipsis">卫浴数</span>
      <span class="fr text_ellipsis">{{info.baths || '暂无数据'}}</span>
    </div>
    <div class="cell">
      <span class="fl text_ellipsis">私人车库</span>
      <span class="fr text_ellipsis">{{info.parking || '暂无数据'}}</span>
    </div>
    <div class="cell">
      <span class="fl text_ellipsis">物业费（每月）</span>
      <span class="fr text_ellipsis">{{info.property_costs || '暂无数据'}}</span>
    </div>
    <div class="cell">
      <span class="fl text_ellipsis">地产税（每年）</span>
      <span class="fr text_ellipsis">{{info.property_tax_history || '暂无数据'}}</span>
    </div>
    <div class="cell">
      <span class="fl text_ellipsis">预估月租金收入</span>
      <span class="fr text_ellipsis">{{info.rent_estimate || '暂无数据'}}</span>
    </div>
  </div>

  <div class="divide_bar">
    <p class="fl">学校信息</p>
    <i class="fr i i-xiangshangjiantou" />
  </div>

  <div class="school_info" v-if="info.nearby_schools">
    <div class="tr_title">
      <p class="td td_1">学校名字</p>
      <p class="td td_2">评分(10分)</p>
      <p class="td td_3">年级</p>
      <p class="td td_4">距离(公里)</p>
    </div>
    <div class="tr">
      <p class="td td_1">小学: {{info.nearby_schools[0].school_name}}</p>
      <p class="td td_2">{{info.nearby_schools[0].school_score}}</p>
      <p class="td td_3">{{info.nearby_schools[0].school_grade}}</p>
      <p class="td td_4">{{info.nearby_schools[0].school_distance}}</p>
    </div>
    <div class="tr">
      <p class="td td_1">中学: {{info.nearby_schools[1].school_name}}</p>
      <p class="td td_2">{{info.nearby_schools[1].school_score}}</p>
      <p class="td td_3">{{info.nearby_schools[1].school_grade}}</p>
      <p class="td td_4">{{info.nearby_schools[1].school_distance}}</p>
    </div>
    <div class="tr">
      <p class="td td_1">高中: {{info.nearby_schools[2].school_name}}</p>
      <p class="td td_2">{{info.nearby_schools[2].school_score}}</p>
      <p class="td td_3">{{info.nearby_schools[2].school_grade}}</p>
      <p class="td td_4">{{info.nearby_schools[2].school_distance}}</p>
    </div>
  </div>

  <div class="divide_bar">
    <p class="fl">相似房源</p>
    <i class="fr i i-xiangshangjiantou" />
  </div>

  <HouseLayout :info="info" v-for="(info, index) in results" :key="index"></HouseLayout>

</section>

</template>

<script>
import HouseLayout from '../globalLayout/HouseLayout.vue'

export default {
  name: "HouseDetail",
  components: {
    HouseLayout,
  },
  data() {
    return {
      info: {},
      results: [],
    }
  },
  mounted() {
    this.fetchData()
  },

  watch: {
    $route(to) {
      // 点击相似房源或者推荐房源进入房子详情页时，刷新页面
      location.reload()
    },
  },
    
  methods: {
    fetchData() {
      this.$http.get(this.API.HOUSE.List + this.$route.params.id + '/').then(res => {
        if(res) {
          this.info = res
          this.fetchSimilarHouse(res.city_name, res.zestimate)
        }
      })
    },
    background() {
      return {
        backgroundImage: 'url('+ this.info.front_image_url +')',
        backgroundSize: 'cover',
        backgroundRepeat: 'no-repeat',
        backgroundPosition: 'center',
      }
    },
    fetchSimilarHouse(city_name, price) {
      const data = {
        params: {
          city_name,
          min_price: price - 50000 >= 0 ? price - 50000 : 0,
          max_price: price + 50000,
        }
      }
      this.$http.get(this.API.HOUSE.List, data).then(res => {
        if(res.results) {
          this.results = res.results
        }
      })
    },
  },
}
</script>

<style lang="scss" scoped>
@import "../../scss/variables";
@import "../../scss/mixins";

.header {
  position: fixed;
  left: 0;
  top: 0;
  z-index: $z_filter;
  width: 100%;
  height: 58px;
  line-height: 58px;
  overflow: hidden;
  background: $theme_color;
  text-align: center;
  font-size: 22px;
  color: #fff;

  .icon {
    position: absolute;
    right: 10px;
    top: 10px;
    width: 34px;
    height: 34px;
    text-align: center;
    line-height: 34px;
    background: $we_color;
    border-radius: 6px;

    i { font-size: 24px; }
  }
}

.go_back {
  position: absolute;
  left: 5px;
  top: 10px;
  width: 40px;
  height: 40px;
  text-align: center;
  line-height: 40px;
  color: #fff;
  z-index: $z_menu_icon;
  font-size: 22px;
}

.house_img_list {
  margin-top: 58px;
  position: relative;
  left: 0;
  right: 0;
  width: 100%;
  height: 250px;

  .tag {
    display: inline-block;
    margin: 10px;
    padding: 5px 10px;
    border-radius: 4px;
    font-size: 12px;
    color: #fff;
    background: $btn_color;
  }
}

.house_info {
  width: 100%;
  height: auto;
  padding-bottom: 15px;
  background: #fff;
}

.title {
  width: 100%;
  line-height: 40px;
  height: 40px;
  padding: 10px;
  font-size: 18px;

  .fl {
    width: 70%;
    font-weight: bold;
    text-align: left;
    color: $theme_color;
  }

  .fr {
    width: 30%;
    text-align: right;
  }
}

.info {
  @extend .title;
  padding: 0 10px;
  height: 30px;
  line-height: 30px;
  font-size: 14px;

  .fl {
    font-weight: 400;
    color: #000;
    line-height: 20px;
  }

  .fr {
    line-height: 20px;
  }
}

.vr_btn {
  margin-top: 10px;
  margin-left: 10px;
  display: block;
  width: 86px;
  height: 26px;
  text-align: center;
  line-height: 26px;
  background: $btn_color;
  border-radius: 4px;
  color: #fff;
  font-size: 12px;
}

.divide_bar {
  height: 26px;
  line-height: 26px;
  font-size: 12px;
  padding-left: 10px;
  width: 100%;

  .fl { font-weight: bold; }

  .i {
    width: 40px;
    height: 26px;
    font-size: 14px;
    text-align: center;
  }
}

.desc {
  padding: 15px 10px;
  height: auto;
  background: #fff;
  font-size: 14px;
  color: #3a3a3a;

  p {
    @include text-multiLine-ellipsis(5, 20px);
  }
}

.detail {
  @extend .desc;

  .cell {
    width: 100%;
    height: 30px;
    line-height: 30px;
  }

  .fl {
    width: 30%;
  }

  .fr {
    width: 70%;
  }
}

.school_info {
  width: 100%;
  background: #fff;
  padding: 10px 5px;
  font-size: 0;
  color: #3a3a3a;

  .tr_title {
    color: #000;
    border-bottom: 1px $divder_color solid;
    padding-bottom: 5px;

    .td_1 {
      line-height: 38px;
    }

    .td_2 { color: #000; }

    .td {
      margin-bottom: 0;
    }
  }

  .td {
    display: inline-block;
    margin-bottom: 5px;
    vertical-align: top;
    font-size: 14px;
    height: 38px;
    line-height: 38px;
    text-align: center;
  }

  .td_1 {
    width: 50%;
    text-align: left;
    line-height: 20px;
  }

  .td_2 {
    width: 18%;
    color: $btn_color;
  }

  .td_3 {
    width: 14%;
  }

  .td_4 {
    width: 18%;
  }
}
</style>
