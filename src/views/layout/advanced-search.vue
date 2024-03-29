<template lang="html">
  <section class="advanced_search">
    <div class="container">
      <el-cascader
        class="cascader"
        clearable
        placeholder="请选择热门城市和区域"
        :options="cityData"
        v-model="selectedOptions"
        @change="countryChange">
      </el-cascader>
      
      <el-select 
        @change="value => onSelectChange('house_type', value)" 
        v-model="house_type" 
        clearable
        style="width: 150px; margin-right: 20px;" 
        placeholder="房屋类型"
      >
        <el-option
          v-for="item in house_type_list"
          :key="item.value"
          :label="item.label"
          :value="item.value">
        </el-option>
      </el-select>

      <el-select 
        @change="value => onSelectChange('build_year', value)" 
        v-model="build_year" 
        clearable 
        style="width: 150px; margin-right: 20px;" 
        placeholder="房龄"
      >
        <el-option
          v-for="item in build_year_list"
          :key="item.value"
          :label="item.label"
          :value="item.value">
        </el-option>
      </el-select>

      <el-select 
        @change="value => onSelectChange('beds', value)" 
        v-model="beds" 
        clearable 
        style="width: 150px; margin-right: 20px;" 
        placeholder="卧室数"
      >
        <el-option
          v-for="item in beds_list"
          :key="item.value"
          :label="item.label"
          :value="item.value">
        </el-option>
      </el-select>

      <el-select 
        @change="value => onSelectChange('baths', value)" 
        v-model="baths" 
        clearable
        style="width: 150px;" 
        placeholder="卫浴数"
      >
        <el-option
          v-for="item in baths_list"
          :key="item.value"
          :label="item.label"
          :value="item.value">
        </el-option>
      </el-select>
    </div>

    <div class="container" style="margin-top: 15px;">
      <div class="slider_box" style="margin-right: 80px;">
        <div class="desc">
          房屋面积：{{area_slide.value[0]}}-{{area_slide.value[1]}}
          <el-switch
            style="margin-left: 10px;"
            @change="onAreaSwitch"
            v-model="area_slide.isChina"
            :width="80"
            on-text="平方英尺"
            off-text="平方米"
            on-color="#0142a1"
            off-color="#ff4949">
          </el-switch>
          <el-button size="small" class="fr" @click="onAreaSearch" type="primary">搜索</el-button>        
        </div>
        
        <el-slider
          v-model="area_slide.value"
          :max="area_slide_max"
          range>
        </el-slider>
      </div>

      <div class="slider_box">
        <div class="desc">
          价格区间：{{price_slide.value[0]}}k-{{price_slide.value[1]}}k
          <el-switch
            style="margin-left: 10px;"
            @change="onPriceSwitch"
            v-model="price_slide.isChina"
            on-text="美元"
            off-text="人民币"
            :width="70"
            on-color="#0142a1"
            off-color="#ff4949">
          </el-switch>

          <el-button size="small" class="fr" @click="onPriceSearch" type="primary">搜索</el-button>
        </div>
        <el-slider
          v-model="price_slide.value"
          :max="price_slide_max"
          :format-tooltip="value => value + 'k'"
          range>
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
      area_slide: {
        isChina: false,
        value: [0, 0],
      },
      price_slide: {
        isChina: false,
        value: [0, 0],
      },
      cityData: HOT_CITIES,
      selectedOptions: [],
      house_type: '',
      house_type_list: [
        {
          value: 'Apartment',
          label: '公寓',
        },
        {
          value: 'single Family',
          label: '独栋别墅',
        },
        {
          value: 'townhouse',
          label: '联排别墅',
        },
      ],
      build_year: '',
      build_year_list: [
          {
            value: '5',
            label: '5年内'
          },
          {
            value: '10',
            label: '10 年内'
          },
          {
            value: '15',
            label: '15 年内'
          },
          {
            value: '20',
            label: '20 年内'
          },
          {
            value: '30',
            label: '30 年内'
          },
      ],
      beds: '',
      beds_list: [
        {
          value: '1',
          label: '1+'
        },
        {
          value: '2',
          label: '2+'
        },
        {
          value: '3',
          label: '3+'
        },
        {
          value: '4',
          label: '4+'
        },
        {
          value: '5',
          label: '5+'
        },
      ],
      baths: '',
      baths_list: [
        {
          value: '1',
          label: '1+'
        },
        {
          value: '2',
          label: '2+'
        },
        {
          value: '3',
          label: '3+'
        },
        {
          value: '4',
          label: '4+'
        },
        {
          value: '5',
          label: '5+'
        },
      ],
    }
  },
  watch: {
    house_type(value) {
      this.onSelectChange('house_type', value)
    },
  },
  computed: {
    area_slide_max() {
      return this.area_slide.isChina ? 10000 : 1000
    },
    price_slide_max() {
      return this.price_slide.isChina ? 2000 : 10000
    }
  },
  methods: {
    onAreaSwitch(isChina) {
      if(!isChina) {
        // 一英尺等于多少米
        this.area_slide.value = this.area_slide.value.map(value => parseInt(value * 0.093))
      } else {
        this.area_slide.value = this.area_slide.value.map(value => parseInt(value * 10.76))
      }
    },

    onAreaSearch() {
      const [ min_square, max_square ] = this.area_slide.value
      let query = null
      if(this.$route.name === 'SearchResult') {
        query = {
          ...this.$route.query,
          min_square,
          max_square,
        }
      } else {
        query = {
          min_square,
          max_square,
        }
      }
      this.$router.push({path: '/result', query})
    },

    onPriceSwitch(isChina) {
      const { dollar_to_rmb, rmb_to_dollar } = JSON.parse(sessionStorage.rate)
      if(!isChina) {
        // 一美元等于多少元
        this.price_slide.value = this.price_slide.value.map(value => parseInt(value * dollar_to_rmb))
      } else {
        this.price_slide.value = this.price_slide.value.map(value => parseInt(value * rmb_to_dollar))
      }
    },

    onPriceSearch() {
      let [ min_price, max_price ] = this.price_slide.value
      min_price = min_price * 1000
      max_price = max_price * 1000
      let query = null
      if(this.$route.name === 'SearchResult') {
        query = {
          ...this.$route.query,
          min_price,
          max_price,
        }
      } else {
        query = {
          min_price,
          max_price,
        }
      }
      this.$router.push({path: '/result', query})
    },

    countryChange(value) {
      // TODO 如果 country 发生改变，重置 city
      console.log(value)
    },
    onSelectChange(type, value) {
      let query = null
      if(type === 'build_year') {
        const date = new Date()
        const thisYear = date.getFullYear()
        
        if(this.$route.name === 'SearchResult') {
          query = {
            ...this.$route.query,
            min_build_year: thisYear - value,
            max_build_year: thisYear,
          }
        } else {
          query = {
            min_build_year: thisYear - value,
            max_build_year: thisYear,
          }
        }

        this.$router.push({path: '/result', query})
        return
      }

      if(this.$route.name === 'SearchResult') {
        query = {
          ...this.$route.query,
          [type]: value,
        }
      } else {
        query = {[type]: value}
      }

      this.$router.push({path: '/result', query})
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
