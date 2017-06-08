<template>
<section id="OtherHouse">
  <div class="same_house">
    <h3>相似房源</h3>
    <section class="house">
      <img class="img" src="http://placehold.it/80x65" />
      <div class="hd">
        <h4 class="text_ellipsis theme_color">旧金山 三室两位独栋别墅</h4>
        <small class="text_ellipsis">2015 年建造 | 190 平米</small>
        <h4 class="price">$334,000（约￥50万）</h4>
      </div>
    </section>

    <section class="house">
      <img class="img" src="http://placehold.it/80x65" />
      <div class="hd">
        <h4 class="text_ellipsis theme_color">旧金山 三室两位独栋别墅</h4>
        <small class="text_ellipsis">2015 年建造 | 190 平米</small>
        <h4 class="price">$334,000（约￥50万）</h4>
      </div>
    </section>

    <section class="house">
      <img class="img" src="http://placehold.it/80x65" />
      <div class="hd">
        <h4 class="text_ellipsis theme_color">旧金山 三室两位独栋别墅</h4>
        <small class="text_ellipsis">2015 年建造 | 190 平米</small>
        <h4 class="price">$334,000（约￥50万）</h4>
      </div>
    </section>
  </div>

  <div class="recommend_house">
    <h3>推荐房源</h3>
    <el-carousel v-model="value1">
      <el-carousel-item>
        <div class="house">
          <el-button size="small" type="error">推荐房源</el-button>
          <div class="footer">
            <h3 class="h3">$350,000(约xxxxx)</h3>
            <!--<Icon class="star" type="ios-star-outline" />-->
            <i class="i i-weixin wexin" />
          </div>
        </div>
      </el-carousel-item>
      <el-carousel-item>
        <div class="house"></div>
      </el-carousel-item>
      <el-carousel-item>
        <div class="house"></div>
      </el-carousel-item>
      <el-carousel-item>
        <div class="house"></div>
      </el-carousel-item>
    </el-carousel>
  </div>

  <div class="house_type">
    <h3>房屋类型</h3>
    <ul>
      <li class="theme_color">
        <!--<Icon type="arrow-right-b"></Icon>-->
        独栋别墅
        <span class="fr">(30)</span>
      </li>
      <li class="theme_color">
        <!--<Icon type="arrow-right-b"></Icon>-->
        独栋别墅
        <span class="fr">(30)</span>
      </li>
      <li class="theme_color">
        <!--<Icon type="arrow-right-b"></Icon>-->
        独栋别墅
        <span class="fr">(30)</span>
      </li>
    </ul>
  </div>
</section>

</template>
<script>

export default {
  name: "OtherHouse",
  data() {
    return {
      value1: 0,
    }
  }
}
</script>
<style lang="scss" scoped>
@import "../../scss/variables";

.same_house {
  margin-top: 20px;
  padding: 30px 20px;
  width: 100%;
  background: #fff;
  height: auto;
}

.house {
  width: 100%;
  height: 70px;
  margin-bottom: 15px;

  .img {
    width: 80px;
    height: 65px;
  }

  .hd {
    display: inline-block;
    vertical-align: top;
    font-size: 12px;

    .price {
      margin-top: 5px;
    }
  }
}

.recommend_house {
  @extend .same_house;

  .house {
    position: relative;
    left: 0;
    right: 0;
    height: 150px;
    background: url('http://placehold.it/250x150') center center no-repeat;
    background-size: cover;

    button {
      transform: scale(.6, .6);
      margin: 5px;
      font-size: 12px;
    }

    .h3 {
      position: absolute;
      bottom: 0px;
      left: 10px;
      color: #fff;
    }

    i {
      position: absolute;
      bottom: 10px;
      border-radius: 3px;
      color: #fff;
      opacity: .9;
    }

    .star {
      right: 40px;
      font-size: 16px;
      padding: 4px;
      background: $theme_color;
    }

    .wexin {
      right: 10px;
      padding: 0 3px;
      background: $we_color;
    }
  }
}

.house_type {
  @extend .same_house;
  li { margin-bottom: 5px; }
}
</style>
