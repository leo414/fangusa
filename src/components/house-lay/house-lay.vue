<template lang="html">
<section class="city_layout">
  <router-link :to="'/house/' + info.url_object_id" class="img_box" :style="background">
    <span class="tag">推荐房源</span>
    <footer class="footer">
      <h3 class="price1">${{info.zestimate}}</h3>
      <h2 class="price2">约￥{{info.zestimate | toRMB_W}} 万</h2>
    </footer>
  </router-link>

  <div class="hd">
    <p class="title text_ellipsis">{{info.city_name}}</p>
    <p class="title text_ellipsis">{{info.beds}}室{{info.baths}}卫 {{info.house_type}}</p>
    <span class="desc">{{info.build_year}} 年建造 | {{parseInt(info.square *  0.093)}} 平米</span>
  </div>
  <router-link :to="'/house/' + info.url_object_id" class="btn fr">查看详情</router-link>

  <footer class="footer">
    房源信息发布于：3 天前
    <span class="fr">
      <i style="color: #8492A6;" class="i i-star" />
      加入收藏
    </span>
  </footer>
</section>
</template>

<script>
export default {
  name: 'HouseLay',
  props: {
    info: {
      type: Object,
      default: {},
    },
  },
  computed: {
    background() {
      return {
        backgroundImage: 'url('+ this.info.front_image_url +')',
        backgroundSize: 'cover',
        backgroundRepeat: 'no-repeat',
        backgroundPosition: 'center',
      }
    }
  },
}
</script>

<style lang="scss" scoped>
@import '../../scss/variables.scss';

.city_layout {
  height: auto;
  padding: 10px;
  background: #fff;
}

.img_box {
  position: relative;
  left: 0;
  right: 0;
  display: block;
  padding: 10px;
  margin-bottom: 10px;
  width: 100%;
  height: 220px;
  cursor: pointer;  

  .tag {
    padding: 5px;
    font-size: 12px;
    color: #fff;
    cursor: point; 
    background: $btn_color;
  }

  .footer {
    position: absolute;
    color: #fff;
    bottom: 10px;
    left: 10px;

    h2, h3 { color: #fff; }

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
  color: #324057;

  .title {
    font-size: 18px;
    margin-bottom: 5px;
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
  color: #324057;
  font-size: 14px;
  clear: both;
}
</style>
