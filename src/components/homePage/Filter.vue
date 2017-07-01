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

    <div class="range_ctrl">
      价格区间：
      <p class="fr">美元<mt-switch v-model="switch1"></mt-switch>人民币</p>
    </div>
    <div class="range_box">
      <span class="range_label">开始：</span>
      <mt-range v-model="rangeValue">
        <div slot="start">0</div>
        <div slot="end">100</div>
      </mt-range>
    </div>
    <div class="range_box">
      <span class="range_label">结束：</span>
      <mt-range v-model="rangeValue">
        <div slot="start">0</div>
        <div slot="end">100</div>
      </mt-range>
    </div>

    <div class="range_ctrl">
      房屋面积：
      <p class="fr">平方英尺<mt-switch v-model="switch1"></mt-switch>平方米</p>
    </div>
    <div class="range_box">
      <span class="range_label">开始：</span>
      <mt-range v-model="rangeValue">
        <div slot="start">0</div>
        <div slot="end">100</div>
      </mt-range>
    </div>
    <div class="range_box">
      <span class="range_label">结束：</span>
      <mt-range v-model="rangeValue">
        <div slot="start">0</div>
        <div slot="end">100</div>
      </mt-range>
    </div>
    <mt-button class="btn" @click.native="handleClick" size="large" type="primary">提交</mt-button>
    <mt-button class="btn go_back" @click.native="$router.go(-1)" size="large" type="primary">取消</mt-button>
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
      query: {},
      rangeValue: 2,
      rangeValue2: 4,
      switch1: false,
      house_type: '',
      house_type_list: {
        '公寓': 'Apartment',
        '独栋别墅': 'single Family',
        '联排别墅': 'townhouse',
      },
      build_year: '',
      build_year_list: {
        '5年内': 5,
        '10年内': 10,
        '15年内': 15,
        '20年内': 20,
        '30年内': 30,
      },
      beds: '',
      beds_list:{
        '1+': 1,
        '2+': 2,
        '3+': 3,
        '4+': 4,
        '5+': 5,
      },
      baths: '',
      baths_list: {
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
    house_type(house_type) {
      this.query = {
        ...this.query,
        house_type,
      }
    },

    build_year(house_type) {
      this.query = {
        ...this.query,
        house_type,
      }
    },

    house_type(house_type) {
      this.query = {
        ...this.query,
        house_type,
      }
    },

    house_type(house_type) {
      this.query = {
        ...this.query,
        house_type,
      }
    },
  },

  methods: {
    onAddressChange(picker, values) {
      picker.setSlotValues(1, address[values[0]]);
      this.addressProvince = values[0];
      this.addressCity = values[1];
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
  padding: 20px;
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

.range_ctrl {
  margin-top: 10px;
  font-size: 16px;
  height: 40px;
  line-height: 40px;

  .mint-switch {
    display: inline-block;
    padding-top: 5px;
    vertical-align: top;
  }

  .fr {
    width: 60%;
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
