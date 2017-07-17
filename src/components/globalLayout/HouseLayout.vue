<template>
<router-link :to="'/house/' + info.url_object_id" tag="div" class="house_layout"  :style="background">
  <span class="time">{{info.add_time.substring(0, 10)}}</span>
  <i v-if="!info.delete_id" class="star i i-star" @click.stop="userFav(info.url_object_id)"></i>
  <i class="star i i-star-full" @click.stop="deleteHouse(info.delete_id)"></i>

  <div class="info">
    <span class="tag">推荐房源</span>
    <div class="title">
      <div class="fl text_ellipsis">{{info.city_name}} {{info.beds}}室{{info.baths}}卫 {{info.house_type}}</div>
      <div class="fr text_ellipsis">${{info.zestimate}}</div>
    </div>
    <div class="desc">
      <div class="fl text_ellipsis">学区：高中{{info.nearby_schools[0].school_score}} 初中{{info.nearby_schools[1].school_score}}  小学{{info.nearby_schools[2].school_score}}</div>
      <div class="fr text_ellipsis">（约¥{{info.zestimate | toRMB_W}}万）</div>
    </div>
    <div class="desc desc_bottom">
      <div class="fl text_ellipsis">{{info.build_year}}年建造 ｜ {{parseInt(info.square *  0.093)}}平米</div>
      <div class="fr text_ellipsis" v-if="info.rent_estimate">预估月租金：${{info.rent_estimate}}（约¥{{info.rent_estimate | toRMB}}）</div>
    </div>
  </div>
</router-link>

</template>

<script>
import { FavMixin } from '../../mixins/mixins'

export default {
  name: "HouseLayout",
  props: {
    info: {
      type: Object,
      default: {},
    },
  },
  mixins: [FavMixin],
  data() {
    return {

    }
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
  methods: {
    deleteHouse(id) {
      this.$http.delete(this.API.USER.Fav + id + '/').then(res => {
        location.reload()
      })
    },
  },
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
  font-size: 24px;
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
