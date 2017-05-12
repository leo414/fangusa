<template>
<section class="house_layout">
  <span class="time">刚刚更新</span>
  <i class="star i i-star" />

  <div class="info">
    <span class="tag">推荐房源</span>
    <div class="title">
      <div class="fl text_ellipsis">旧金山 三室两卫独栋别墅</div>
      <div class="fr text_ellipsis">$34.000</div>
    </div>
    <div class="desc">
      <div class="fl text_ellipsis">学区：高中10  初中9  小学9</div>
      <div class="fr text_ellipsis">（约¥50万）</div>
    </div>
    <div class="desc desc_bottom">
      <div class="fl text_ellipsis">2015年建造 ｜ 190平米</div>
      <div class="fr text_ellipsis">预估月租金：$1800（约¥9000）</div>
    </div>
  </div>
</section>

</template>

<script>

export default {
  name: "HouseLayout",
  data() {
    return {

    }
  }
}
</script>

<style lang="scss" scoped>
@import "../../scss/variables";

.house_layout {
  width: 100%;
  height: 200px;
  margin-bottom: 2px;
  position: relative;
  left: 0;
  right: 0;
  background: url('http://placehold.it/375x200') center no-repeat;
  background-size: cover;
}

.time {
  display: inline-block;
  margin: 10px;
  padding: 2px 10px;
  background: rgba(0, 0, 0, .5);
  opacity: .8;
  color: #fff;
  font-size: 12px;
}

.star {
  position: absolute;
  top: 5px;
  right: 5px;
  width: 40px;
  height: 40px;
  text-align: center;
  line-height: 40px;
  font-size: 28px;
  color: $theme_color;
}

.info {
  position: absolute;
  bottom: 0;
  right: 0;
  padding: 5px;
  width: 100%;
  color: #fff;
  font-size: 12px;

  .tag {
    padding: 2px 10px;
    background: $btn_color;
  }

  .title {
    width: 100%;
    height: 30px;
    line-height: 30px;
    font-size: 16px;

    .fl {
      width: 70%;
    }

    .fr {
      width: 30%;
      text-align: right;
    }
  }

  .desc {
    @extend .title;
    height: 20px;
    line-height: 20px;
    font-size: 12px;
  }

  .desc_bottom {
    .fl {
      width: 50%;
    }

    .fr {
      width: 50%;
    }
  }
}
</style>
