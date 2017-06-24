<template>
<section id="OtherHouse">
  <div class="same_house">
    <h3 class="title">相似房源</h3>
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
    <h3 class="title">推荐房源</h3>
    <el-carousel v-model="value1">
      <el-carousel-item>
        <div class="house">
          <el-button class="btn" size="small" type="danger">推荐房源</el-button>
          <div class="footer">
            <h4 class="h4">$350,000(约xxxxx)</h4>
            <i class="star i i-star" />
            <i class="i i-weixin wexin" />
          </div>
        </div>
      </el-carousel-item>
    </el-carousel>
  </div>

  <div class="house_type">
    <h3 class="title">房屋类型</h3>
    <ul>
      <li class="theme_color">
        <i class="i i-youjiantou" />
        独栋别墅
        <span class="fr">(30)</span>
      </li>
      <li class="theme_color">
        <i class="i i-youjiantou" />
        独栋别墅
        <span class="fr">(30)</span>
      </li>
      <li class="theme_color">
        <i class="i i-youjiantou" />
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
  margin-top: 30px;
  padding: 30px 20px;
  width: 100%;
  background: #fff;
  height: auto;
}

.title {
  margin-bottom: 15px;
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
  height: 260px;
  
  .house {
    position: relative;
    left: 0;
    right: 0;
    height: 150px;
    background: url('http://placehold.it/250x150') center center no-repeat;
    background-size: cover;

    .btn {
      margin: 5px;
      padding: 2px 4px;
      font-size: 12px;
    }

    .h4 {
      position: absolute;
      bottom: 0px;
      left: 10px;
      font-size: 16px;
      color: #fff;
    }

    i {
      position: absolute;
      bottom: 5px;
      border-radius: 3px;
      color: #fff;
      opacity: .9;
      width: 30px;
      height: 30px;
      text-align: center;
      line-height: 30px;
      cursor: point;
    }

    .star {
      right: 40px;
      background: $theme_color;
    }

    .wexin {
      right: 5px;
      background: $we_color;
    }
  }
}

.house_type {
  @extend .same_house;
  li { 
    margin-bottom: 5px;

    i { font-size: 14px; }
  }
}
</style>