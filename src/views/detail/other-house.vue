<template>
<section id="OtherHouse">
  <div class="same_house">
    <h3 class="title">相似房源</h3>
    <router-link tag="div" :to="'/house/' + info.url_object_id" class="house" v-for="(info, index) in results" :key="index">
      <img class="img" :src="info.front_image_url" />
      <div class="hd">
        <h4 class="text_ellipsis theme_color">{{info.city_name}} {{info.beds}}室{{info.baths}}卫 {{info.house_type}}</h4>
        <small class="text_ellipsis">{{info.build_year}} 年建造 | {{parseInt(info.square *  0.093)}} 平米</small>
        <h4 class="price">${{info.zestimate}}（约￥{{info.zestimate | toRMB_W}}万）</h4>
      </div>
    </router-link>
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
  props: {
    cityName: {
      type: String,
      default: '',
    },
    price: {
      type: Number,
      default: 0,
    },
  },
  data() {
    return {
      value1: 0,
      results: [],
    }
  },
  watch:{
    cityName(city_name) {
      if(!city_name) return
      this.fetchData()
    },
  },
  methods: {
    fetchData() {
      const data = {
        params: {
          city_name: this.cityName,
          min_price: this.price - 50000 >= 0 ? this.price - 50000 : 0,
          max_price: this.price + 50000,
        }
      }
      this.$http.get(this.API.HOUSE.List, data).then(res => {
        if(res.results) {
          this.results = res.results.slice(0, 3)
        }
      })
    },
  },
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
  margin-bottom: 15px;
  width: 100%;
  height: 70px;
  cursor: pointer;
  font-size: 0;

  .img {
    margin-right: 10px;
    width: 80px;
    height: 65px;
  }

  .hd {
    width: 150px;
    display: inline-block;
    vertical-align: top;
    font-size: 12px;

    small {
      display: block;
      margin-top: 5px;
    }

    .price {
      margin-top: 15px;
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