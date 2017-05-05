<template lang="html">
<section class="city_layout">
  <div class="img_box">
    <span class="tag">推荐房源</span>
    <footer class="footer">
      <h3 class="price1">$200.00</h3>
      <h2 class="price2">约￥50 万</h2>
    </footer>
  </div>

  <div class="hd">
    <p class="title text_ellipsis">旧金山</p>
    <p class="title text_ellipsis">三室两厅独栋别墅</p>
    <span class="desc">2015 年建造 | 190 平米</span>
  </div>
  <button class="btn fr">查看详情</button>

  <footer class="footer">
    房源信息发布于：3 天前
    <span class="fr">
      <Icon type="ios-star-outline" size="18" />
      加入收藏
    </span>
  </footer>
</section>
</template>

<script>
import Icon from 'iview/src/components/icon'
export default {
  name: 'HouseLayout',
  components: {
    Icon,
  }
}
</script>

<style lang="scss" scoped>
@import '../../scss/variables.scss';

.city_layout {
  width: 340px;
  height: auto;
  padding: 10px;
  background: #fff;
}

.img_box {
  position: relative;
  left: 0;
  right: 0;
  padding: 10px;
  margin-bottom: 10px;
  width: 100%;
  height: 220px;
  background: url('http://placehold.it/320x220') center center no-repeat;
  background-size: cover;

  .tag {
    padding: 5px;
    font-size: 12px;
    color: #fff;
    background: $btn_color;
  }

  .footer {
    position: absolute;
    color: #fff;
    bottom: 10px;
    left: 10px;

    .price1 {
      font-size: 16px;
    }

    .price2 {
      font-size: 18px;
    }
  }
}

.hd {
  padding: 10px;
  font-size: 12px;
  color: #000;

  .title {
    font-size: 18px;
    color: $theme_color;
  }

  .desc {
    font-size: 14px;
    margin-top: 10px;
  }
}

.btn {
  padding: 8px 12px;
  margin-bottom: 20px;
  font-size: 14px;
  color: #fff;
  border: 1px $theme_color solid;
  background: $theme_color;
}

.footer {
  color: #000;
  font-size: 14px;
  clear: both;
}
</style>
