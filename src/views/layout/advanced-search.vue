<template lang="html">
  <section class="advanced_search">
      <div class="container">
        <el-input style="width: 330px; margin-right: 20px;" placeholder="房屋编号 / 邮编 / 地址"></el-input>
       
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

      <div class="container" style="margin-top: -5px;">
         <el-select placeholder="城市圈" style="width: 150px; margin-right: 22px;" v-model="model1">
          <el-option
            v-for="item in cityList"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>

        <el-select placeholder="地域" style="width: 150px; margin-right: 22px;" v-model="model1">
          <el-option
            v-for="item in cityList"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>

        <div class="slider_box" style="margin-right: 20px;">
          <div class="desc">
            房屋面积：不限-不限
            <el-switch
              class="fr"
              v-model="value2"
              :width="84"
              on-text="平方英尺"
              off-text="平方米"
              on-color="#0142a1"
              off-color="#ff4949">
            </el-switch>
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
              class="fr"
              v-model="value2"
              on-text="美元"
              off-text="人民币"
              :width="70"
              on-color="#0142a1"
              off-color="#ff4949">
            </el-switch>
          </div>
          <el-slider
            v-model="value9"
            range
            show-stops
            :max="10">
          </el-slider>
        </div>

        <el-button size="small" class="i_button" type="primary" icon="search">高级搜索</el-button>
      </div>
  </section>
</template>

<script>

export default {
  name: 'AdvancedSearch',
  data() {
    return {
      value9: [4, 8],
      value2: true,
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
  width: 100%;
  height: 170px;
  box-shadow: 0 0 10px rgba(0,0,0,.1);
  background: rgba(255,255,255,.9);

  .slider_box {
    display: inline-block;
    width: 335px;
    font-size: 12px;
    vertical-align: middle;

    .desc {
      height: 28px;
      line-height: 28px;
    }
  }

  .i_button {
    margin-top: 10px;
    float: right;
  }
}
</style>
