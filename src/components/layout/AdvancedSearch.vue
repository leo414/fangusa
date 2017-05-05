<template lang="html">
  <section class="advanced_search">
      <div class="container">
        <iInput size="large" style="width: 330px; margin-right: 20px;" placeholder="房屋编号 / 邮编 / 地址"></iInput>
        <i-select size="large" style="width: 155px; margin-right: 20px;" v-model="model1">
          <i-option v-for="item in cityList" :value="item.value" :key="item">{{ item.label }} </i-option>
        </i-select>

        <i-select size="large" style="width: 155px; margin-right: 20px;" v-model="model1">
          <i-option v-for="item in cityList" :value="item.value" :key="item">{{ item.label }} </i-option>
        </i-select>

        <i-select size="large" style="width: 155px; margin-right: 20px;" v-model="model1">
          <i-option v-for="item in cityList" :value="item.value" :key="item">{{ item.label }} </i-option>
        </i-select>

        <i-select size="large" style="width: 155px;" v-model="model1">
          <i-option v-for="item in cityList" :value="item.value" :key="item">{{ item.label }} </i-option>
        </i-select>
      </div>

      <div class="container">
        <i-select size="large" style="width: 150px; margin-top: 10px; margin-right: 22px;" v-model="model1">
          <i-option v-for="item in cityList" :value="item.value" :key="item">{{ item.label }} </i-option>
        </i-select>
        <i-select size="large" style="width: 150px; margin-top: 10px; margin-right: 22px;" v-model="model1">
          <i-option v-for="item in cityList" :value="item.value" :key="item">{{ item.label }} </i-option>
        </i-select>
        <div class="slider_box" style="margin-right: 20px;">
          <div class="desc">
            房屋面积：不限-不限
            <p class="fr">
              <span class="theme_color">平方英尺</span>
              <i-switch size="small"></i-switch>
              <span class="theme_color">平方米</span>
            </p>
          </div>
          <i-slider v-model="value1" range></i-slider>
        </div>

        <div class="slider_box">
          <div class="desc">
            价格区间：不限-不限
            <p class="fr">
              <span class="theme_color">美元</span>
              <i-switch size="small"></i-switch>
              <span class="theme_color">人民币</span>
            </p>
          </div>
          <i-slider v-model="value1" range></i-slider>
        </div>
        <i-button size="large" class="i_button" type="primary" icon="ios-search">高级搜索</i-button>
      </div>
  </section>
</template>

<script>
import Input from 'iview/src/components/input'
import Slider from 'iview/src/components/slider'
import Switch from 'iview/src/components/switch'
import { Select, Option } from 'iview/src/components/select'
import Button from 'iview/src/components/button'

export default {
  name: 'AdvancedSearch',
  components: {
    iSwitch: Switch,
    iInput: Input,
    iButton: Button,
    iSlider: Slider,
    iSelect: Select,
    iOption: Option,
  },
  props: {
    isShow: Boolean,
  },
  data() {
    return {
      value1: [20, 50],
      cityList: [
          {
              value: 'beijing',
              label: '北京市'
          },
          {
              value: 'shanghai',
              label: '上海市'
          },
          {
              value: 'shenzhen',
              label: '深圳市'
          },
          {
              value: 'hangzhou',
              label: '杭州市'
          },
          {
              value: 'nanjing',
              label: '南京市'
          },
          {
              value: 'chongqing',
              label: '重庆市'
          }
      ],
      model1: '',
    }
  }
}
</script>

<style lang="scss" scoped>
@import "../../scss/variables.scss";

.advanced_search {
  position: absolute;
  top: 60px;
  left: 0;
  z-index: $z_filter;
  padding-top: 15px;
  width: 100%;
  height: 240px;
  background: #fff;

  .container {
    margin-bottom: 10px;
  }

  .ivu-input-type,
  .ivu-select {
    display: inline-block;
  }

  .slider_box {
    display: inline-block;
    width: 335px;
    font-size: 12px;
  }

  .i_button {
    float: right;
  }
}
</style>
