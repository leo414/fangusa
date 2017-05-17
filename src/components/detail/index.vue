<template>
<section id="house_detail">
  <div class="header">
    <i @click="$router.go(-1)" class="i go_back i-xiangzuojiantou" />
    房产详情
    <div class="icon"><i class="i i-weixin" /></div>
  </div>
  <div class="house">
    <span class="tag">推荐房源</span>
  </div>
  <section class="house_info">
    <div class="title">
      <div class="fl text_ellipsis">旧金山 三室两卫独栋别墅</div>
      <div class="fr text_ellipsis">$350,000</div>
    </div>
    <div class="info">
      <div class="fl">房产编号：ABC123456</div>
      <div class="fr">约¥50万</div>
    </div>
    <a href="/" class="vr_btn"><i class="i i-vr"></i> VR 看房</a>
  </section>

  <div class="divide_bar">
    <p class="fl">房屋介绍</p>
    <i class="fr i i-xiangshangjiantou" />
  </div>
  <div class="desc">
    <p>
      Cras quis nulla commodo, aliquam lectus sed, blandit augue. Cras ullamcorper bibendum bibendum.
       Duis tincidunt urna non pretium porta. Nam condimentum vitae ligula vel ornare.
       Phasellus at semper turpis. Nunc eu tellus tortor. Etiam at condimentum nisl, vitae sagittis orci. Donec id
    </p>
  </div>
  <div class="divide_bar">
    <p class="fl">房屋详情</p>
    <i class="fr i i-xiangshangjiantou" />
  </div>
  <div class="detail">
    <div class="cell">
      <span class="fl text_ellipsis">房屋编号</span>
      <span class="fr text_ellipsis">xxxxxxxxxxxxx</span>
    </div>
    <div class="cell">
      <span class="fl text_ellipsis">房屋编号</span>
      <span class="fr text_ellipsis">xxxxxxxxxxxxx</span>
    </div>
    <div class="cell">
      <span class="fl text_ellipsis">房屋编号房屋编号</span>
      <span class="fr text_ellipsis">xxxxxxxxxxxquis nulla commodo, aliquam lectus sed, blandit augue. Crasxx</span>
    </div>
    <div class="cell">
      <span class="fl text_ellipsis">房屋编号</span>
      <span class="fr text_ellipsis">xxxxxxxxxxxxx</span>
    </div>
  </div>

  <div class="divide_bar">
    <p class="fl">学校信息</p>
    <i class="fr i i-xiangshangjiantou" />
  </div>

  <div class="school_info">
    <div class="tr_title">
      <p class="td td_1">学校名字</p>
      <p class="td td_2">评分(10分)</p>
      <p class="td td_3">年级</p>
      <p class="td td_4">距离(公里)</p>
    </div>
    <div class="tr">
      <p class="td td_1">小学: Monroe Elementary School</p>
      <p class="td td_2">3</p>
      <p class="td td_3">PX-5</p>
      <p class="td td_4">距离(公里)</p>
    </div>
    <div class="tr">
      <p class="td td_1">中学: Monroe Elementary School</p>
      <p class="td td_2">3</p>
      <p class="td td_3">PX-2</p>
      <p class="td td_4">距离(公里)</p>
    </div>
    <div class="tr">
      <p class="td td_1">高学: Monroe Elementary School</p>
      <p class="td td_2">3</p>
      <p class="td td_3">PX-8</p>
      <p class="td td_4">距离(公里)</p>
    </div>
  </div>

  <div class="divide_bar">
    <p class="fl">相似房源</p>
    <i class="fr i i-xiangshangjiantou" />
  </div>
  <HouseLayout v-for="info in 10" :key="info" />

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

    }
  },
  methods: {

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

.house {
  margin-top: 58px;
  position: relative;
  left: 0;
  right: 0;
  width: 100%;
  height: 250px;
  background: url('http://placehold.it/375x250') center no-repeat;
  background-size: cover;

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
