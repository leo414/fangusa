<template>
<div>
  <section class="filter_container">
    <div class="page-picker-wrapper">
      <mt-picker :slots="addressSlots" @change="onAddressChange" :visible-item-count="5"></mt-picker>
    </div>
    <p class="page-picker-desc">地址: {{ addressProvince }} {{ addressCity }}</p>

    <div class="select_list">
      <multiselect
        v-model="house_type"
        :options="Object.keys(house_type_list)"
        :searchable="false"
        :close-on-select="true"
        :show-labels="false"
        placeholder="房屋类型">
      </multiselect>

      <multiselect
        v-model="build_year"
        :options="Object.keys(build_year_list)"
        :searchable="false"
        :close-on-select="true"
        :show-labels="false"
        placeholder="房龄">
      </multiselect>

      <multiselect
        v-model="beds"
        :options="Object.keys(beds_list)"
        :searchable="false"
        :close-on-select="true"
        :show-labels="false"
        placeholder="卧室数">
      </multiselect>

      <multiselect
        v-model="baths"
        :options="Object.keys(baths_list)"
        :searchable="false"
        :close-on-select="true"
        :show-labels="false"
        placeholder="卫浴数">
      </multiselect>
    </div>

    <div class="range_container">
      <div class="range_ctrl">
        <p>价格区间：1万 - {{price_slide.value}}万</p>
        <p class="right"><mt-switch @change="onPriceSwitch" v-model="price_slide.isChina"></mt-switch>{{price_slide.isChina ? '人民币' : '美元'}}</p>
      </div>
      <div class="range_box">
        <mt-range v-model="price_slide.value" :min="1" :max="price_slide_max">
          <div slot="start">1万</div>
          <div slot="end">{{price_slide_max}}万</div>
        </mt-range>
      </div>
    </div>

    <div class="range_container">
      <div class="range_ctrl">
        <p>房屋面积：1 - {{area_slide.value}}</p>
        <p class="right"><mt-switch @change="onAreaSwitch" v-model="area_slide.isChina"></mt-switch>{{area_slide.isChina ? '平方米' : '平方英尺'}}</p>
      </div>
      <div class="range_box">
        <mt-range v-model="area_slide.value" :min="1" :max="area_slide_max">
          <div slot="start">1</div>
          <div slot="end">{{area_slide_max}}</div>
        </mt-range>
      </div>
    </div>

    <mt-button class="btn" @click="handleClick" size="large" type="primary">提交</mt-button>
    <mt-button class="btn go_back" @click="$router.go(-1)" size="large" type="primary">取消</mt-button>
  </section>
</div>
</template>

<script>
import Multiselect from 'vue-multiselect'

 const address = {
    '北京': ['北京'],
    '广东': ['广州', '深圳', '珠海', '汕头', '韶关', '佛山', '江门', '湛江', '茂名', '肇庆', '惠州', '梅州', '汕尾', '河源', '阳江', '清远', '东莞', '中山', '潮州', '揭阳', '云浮'],
    '重庆': ['重庆'],
    '辽宁': ['沈阳', '大连', '鞍山', '抚顺', '本溪', '丹东', '锦州', '营口', '阜新', '辽阳', '盘锦', '铁岭', '朝阳', '葫芦岛'],
    '江苏': ['南京', '苏州', '无锡', '常州', '镇江', '南通', '泰州', '扬州', '盐城', '连云港', '徐州', '淮安', '宿迁'],
 }

export default {
  name: "Filter",
  components: { Multiselect },
  data () {
    return {
      area_slide: {
        isChina: false,
        value: 10000,
      },
      price_slide: {
        isChina: false,
        value: 200,
      },
      house_type: '',
      house_type_list: {
        '全部': '',
        '公寓': 'Apartment',
        '独栋别墅': 'single Family',
        '联排别墅': 'townhouse',
      },
      build_year: '',
      build_year_list: {
        '全部': '',
        '5年内': 5,
        '10年内': 10,
        '15年内': 15,
        '20年内': 20,
        '30年内': 30,
      },
      beds: '',
      beds_list:{
        '全部': '',
        '1+': 1,
        '2+': 2,
        '3+': 3,
        '4+': 4,
        '5+': 5,
      },
      baths: '',
      baths_list: {
        '全部': '',
        '1+': 1,
        '2+': 2,
        '3+': 3,
        '4+': 4,
        '5+': 5,
      },
      addressSlots: [
        {
          flex: 1,
          values: Object.keys(address),
          className: 'slot1',
          textAlign: 'center'
        }, {
          divider: true,
          content: '-',
          className: 'slot2'
        }, {
          flex: 1,
          values: ['北京'],
          className: 'slot3',
          textAlign: 'center'
        }
      ],
      addressProvince: '北京',
      addressCity: '北京'
    }
  },
  
  watch: {
    build_year(build_year) {
      const date = new Date()
      const thisYear = date.getFullYear()
      if(build_year) {
        this.query = {
          ...this.query,
          min_build_year: thisYear - this.build_year_list[build_year],
          max_build_year: thisYear,
        }
      } else {
        this.query = {
          ...this.query,
          min_build_year: '',
          max_build_year: '',
        }
      }
      
    },
  },

  computed: {
    morkPrice() {
      const { dollar_to_rmb, rmb_to_dollar } = window.globalData
      if(this.isRMB) {
        // 一元换算成美元
        return parseInt(this.price * rmb_to_dollar)
      } else {
        return parseInt(this.price * dollar_to_rmb)
      }
    },
    area_slide_max() {
      return this.area_slide.isChina ? 1000 : 10000
    },

    price_slide_max() {
      return this.price_slide.isChina ? 1400 : 200
    }
  },

  methods: {
    onAddressChange(picker, values) {
      picker.setSlotValues(1, address[values[0]]);
      this.addressProvince = values[0];
      this.addressCity = values[1];
    },

    onAreaSwitch(isChina) {
      if(!isChina) {
        // 一英尺等于多少米
        this.area_slide.value = parseInt(this.area_slide.value * 0.093)
      } else {
        this.area_slide.value = parseInt(this.area_slide.value * 10.76)
      }
    },

    onPriceSwitch(isChina) {
      const { dollar_to_rmb, rmb_to_dollar } = window.globalData
      if(!isChina) {
        // 一美元等于多少元
        this.price_slide.value = parseInt(this.price_slide.value * dollar_to_rmb)
      } else {
        this.price_slide.value = parseInt(this.price_slide.value * rmb_to_dollar)
      }
    },

    handleClick() {
      let build_year_query = {
        min_build_year: '',
        max_build_year: '',
      }
      
      if(this.build_year) {
        const date = new Date()
        const thisYear = date.getFullYear()
        build_year_query = {
          min_build_year: thisYear - this.build_year_list[this.build_year],
          max_build_year: thisYear,
        }
      }

      const { rmb_to_dollar } = window.globalData
      // console.log(this.beds_list[this.beds])
      const query = {
        min_price: 0,
        max_price: this.price_slide.isChina ? parseInt(this.price_slide.value * rmb_to_dollar) : this.price_slide.value,
        min_square: 0,
        max_square: this.area_slide.isChina ? parseInt(this.area_slide.value * 10.76) : this.area_slide.value,
        house_type: this.house_type_list[this.house_type] || '',
        beds: this.beds_list[this.beds] || '',
        baths: this.baths_list[this.baths] || '',
        ...build_year_query,
      }

      this.$router.push({path: '/', query})
    },
  },
}
</script>

<style src="vue-multiselect/dist/vue-multiselect.min.css"></style>
<style lang="scss" scoped>
@import "../../scss/variables";

.filter_container {
  width: 100%;
  height: auto;
  min-height: 100vh;
  padding: 10px;
  padding-top: 0;
  background: #fff;
}

.input {
  width: 100%;
  height: 40px;
  padding-left: 10px;
  display: inline-block;
  border: none;
  outline: none;
  background: none;
  border-radius: 4px;
  border: 1px solid rgba(60,60,60,.15);
}

.select_list {
  margin-top: 20px;
  margin-bottom: 20px;
  font-size: 0;

  .multiselect {
    margin-top: 15px;
    width: 48%;
    margin-right: 4%;
    display: inline-block;

    &:nth-child(2n+0) {
      margin-right: 0;
    }
  }
}

.range_container {
  margin-bottom: 20px;
  padding: 8px;
  border: 1px #eee solid;
  width: 100%;
  height: auto;
}

.range_ctrl {
  display: flex;
  margin-top: 10px;
  font-size: 16px;
  height: 40px;
  line-height: 40px;

  .mint-switch {
    display: inline-block;
    padding-top: 5px;
    vertical-align: top;
  }

  .right {
    flex: 1;
    font-size: 14px;
    text-align: right;
  }
}

.range_box {
  margin-bottom: 10px;
  display: flex;
  width: 100%;
  height: 30px;
  line-height: 30px;

  .range_label {
    width: 44px;
    font-size: 14px;
  }

  .mt-range {
    flex: 1;
  }
}

.btn {
  margin-top: 15px;
  background: $theme_color;
}

.go_back {
  display: block;
  width: 100%;
  height: 40px;
  line-height: 40px;
  text-align: center;
  color: $content_color;
  background: #ccc;
}

.go_back {
  background: #ccc;
}
</style>
