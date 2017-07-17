<template>
  <div class="collection_box">
    <h3 class="h3">收藏的房源信息</h3>
    <div class="collection_list" v-if="results.length">
      <el-row class="collection" v-for="(info, index) in houseList" :key="index">
        <el-col :span="7" class="item">
          <div class="img" @click="linkDetail(info.url_object_id)" :style="background(info.front_image_url)"></div>
        </el-col>

        <el-col :span="11" class="item">
          <div class="item">
            <h3 class="name theme_color text_ellipsis">
              {{info.city_name}}
              {{info.beds}}室{{info.baths}}卫 {{info.house_type}}
            </h3>

            <el-button v-if="info.vr_url" @click="LinkTo(info.vr_url)" size="small" class="vr"><i class="i i-vr" /> VR 看房</el-button>
            <el-button size="small" class="mark"><i class="i i-star" /> 加入收藏</el-button>
            <el-tooltip placement="top" effect="light">
              <QrImage slot="content" :houseId="info.url_object_id"></QrImage>
              <el-button size="small" class="wechat"><i class="i i-weixin" /> 微信分享</el-button>
            </el-tooltip>

            <span class="desc">{{info.build_year}} 年建造 | {{parseInt(info.square *  0.093)}} 平米</span>
          </div>
        </el-col>

        <el-col :span="6" class="item">
          <div class="item fr">
            <h3 class="price tr">
              ${{info.zestimate}}
              约￥{{info.zestimate | toRMB_W}} 万
            </h3>
            
            <p class="rent">
              预估月租金收入：{{info.rent_estimate || '暂无数据'}}
            </p>

            <el-button class="btn_detail fr" type="primary" size="large">查看详情</el-button> 
          </div>
        </el-col>
      </el-row>
    </div>
    <p v-else>暂无收藏数据</p>
  </div>
</template>

<script>
import QrImage from 'components/qr-image/qr-image'

export default {
  name: 'CollectionList',
  components: {
    QrImage,
  },
  data() {
    return {
      results: [],
    }
  },
  mounted() {
    this.fetchData()
  },

  methods: {
    fetchData() {
      this.$http.get(this.API.USER.Fav).then(res => {
        if(res.results) {
          this.results = res.results
        }
      })
    },

    LinkTo(url) {
      window.open(url)
    },

    linkDetail(url) {
      this.$router.push('/house/' + url)
    },

    background(img) {
      return {
        backgroundImage: 'url('+ img +')',
        backgroundSize: 'cover',
        backgroundRepeat: 'no-repeat',
        backgroundPosition: 'center',
      }
    },
  },

  computed: {
    houseList() {
      return this.results.map(result => result.house)
    }
  },
}
</script>

<style lang="scss" scoped>
@import '../../scss/variables';

.collection_box {
  width: 100%;

  .h3 {
    padding-left: 20px;
    padding-bottom: 20px;
  }
}

.collection_list {
  padding-top: 10px;
  width: 100%;
  background: $app_bg_colol;
  min-height: 400px;
}

.collection {
  margin-bottom: 10px;
  padding: 10px;
  width: 100%;
  height: 180px;
  background: #fff;

  .item {
    padding-left: 10px;
    vertical-align: top;
    height: 160px;
    background: 'cover';

    .img {
      width: 100%;
      height: 160px;
      cursor: pointer;
    }

    .name {
      margin-top: 20px;
      margin-bottom: 10px;
    }

    .desc {
      display: block;
      margin-top: 30px;
      font-size: 12px;
    }

    .price {
      margin-top: 20px;
    }

    .rent {
      margin-top: 10px;
      font-size: 12px;
      color: #3a3a3a;
      text-align: right;
    }

    .btn_detail {
      margin-top: 30px;
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
}
</style>
