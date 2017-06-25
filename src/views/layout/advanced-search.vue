<template lang="html">
  <section class="advanced_search">
    <div class="container">
        <el-cascader
        class="cascader"
        clearable
        placeholder="请选择热门城市和区域"
        :options="cityData"
        v-model="selectedOptions"
        @change="handleChange">
      </el-cascader>
      
      <el-select v-model="model1" style="width: 150px; margin-right: 20px;" placeholder="房屋类型">
        <el-option
          v-for="item in cityList"
          :key="item.value"
          :label="item.label"
          :value="item.value">
        </el-option>
      </el-select>

      <el-select v-model="model1" style="width: 150px; margin-right: 20px;" placeholder="房龄">
        <el-option
          v-for="item in cityList"
          :key="item.value"
          :label="item.label"
          :value="item.value">
        </el-option>
      </el-select>

        <el-select v-model="model1" style="width: 150px; margin-right: 20px;" placeholder="卧室数">
        <el-option
          v-for="item in cityList"
          :key="item.value"
          :label="item.label"
          :value="item.value">
        </el-option>
      </el-select>

      <el-select v-model="model1" style="width: 150px;" placeholder="卫浴数">
        <el-option
          v-for="item in cityList"
          :key="item.value"
          :label="item.label"
          :value="item.value">
        </el-option>
      </el-select>
    </div>

    <div class="container" style="margin-top: 15px;">
      <div class="slider_box" style="margin-right: 80px;">
        <div class="desc">
          房屋面积：不限-不限
          <el-switch
            style="margin-left: 10px;"
            v-model="value2"
            :width="80"
            on-text="平方英尺"
            off-text="平方米"
            on-color="#0142a1"
            off-color="#ff4949">
          </el-switch>
          <el-button size="small" class="fr" type="primary">搜索</el-button>        
        </div>
        
        <el-slider
          v-model="value9"
          range
          show-stops
          :max="10">
        </el-slider>
      </div>

      <div class="slider_box">
        <div class="desc">
          价格区间：不限-不限
          <el-switch
            style="margin-left: 10px;"
            v-model="value2"
            on-text="美元"
            off-text="人民币"
            :width="70"
            on-color="#0142a1"
            off-color="#ff4949">
          </el-switch>

          <el-button size="small" class="fr" type="primary">搜索</el-button>
        </div>
        <el-slider
          v-model="value9"
          range
          show-stops
          :max="10">
        </el-slider>
      </div>
    </div>
  </section>
</template>

<script>
import { HOT_CITIES } from 'libs/Constant'

export default {
  name: 'AdvancedSearch',
  data() {
    return {
      value9: [4, 8],
      value2: true,
      cityData: HOT_CITIES,
      selectedOptions: [],
      cityList: [
          {
              value: 'beijing',
              label: '北京市'
          },
          {
              value: 'shanghai',
              label: '上海市'
          },
      ],
      model1: '',
    }
  },
   methods: {
    handleChange(value) {
      console.log(value);
    }
  },
}
</script>

<style lang="scss" scoped>
@import "../../scss/variables.scss";

.advanced_search {
  margin-top: 50px;
  padding-top: 20px;  
  position: absolute;
  z-index: $z_filter;
  width: 100%;
  height: 140px;
  box-shadow: 0 1px 5px rgba(0,0,0,.1);
  background: rgba(255,255,255, 1);

  .cascader {
    width: 250px;
    margin-right: 20px;
  }

  .slider_box {
    display: inline-block;
    width: 380px;
    font-size: 12px;
    vertical-align: middle;

    .desc {
      height: 28px;
      line-height: 28px;
    }
  }
}

</style>
