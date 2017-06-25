<template lang="html">
<div id="search" class="bg_white_container">
  <section class="input_container">
    <div class="container">
      <div class="input_box">
        <input @keyup.enter="onSearch" v-model.trim="search_key" type="search" placeholder="城市名／邮编／房源编号" />
        <a @click.stop="onSearch" class="btn">搜索</a>
      </div>
      <div class="advanced_search_btn" @click="is_show_search = !is_show_search">
        <i class="i i-shezhi1" />
        <a href="javascript:;">高级搜索</a>
        <i v-if="!is_show_search" class="i i-xiajiantou" />
        <i v-else class="i i-shangjiantou" />
      </div>
    </div>
  </section>

  <section class="filter_container">
    <transition name="slide-fade">
      <advanced-search v-if="is_show_search" />
    </transition>

    <div class="city_seleted container">
      热门城市：
      <router-link v-for="city in hotCities" :key="city.value" :to="'/result?country=' + city.value">{{city.value}}</router-link>
    </div>
  </section>

</div>
</template>

<script>
import AdvancedSearch from './advanced-search'
import { HOT_CITIES } from 'libs/Constant'

export default {
  name: 'SearchLay',
  components: {
    AdvancedSearch,
  },
  data() {
    return {
      hotCities: HOT_CITIES,
      is_show_search: false,
      search_key: '',
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
  },
  watch: {
    $route(to) {
      if(to.name === 'SearchResult') {
        this.is_show_search = true
      } else {
        if(this.is_show_search) this.is_show_search = false
      }
    }
  },
  methods: {
    onSearch() {
      this.$router.push({path: 'result', query: {search: this.search_key}})
    },
  },
}
</script>

<style lang="scss" scoped>
@import "../../scss/variables.scss";

.slide-fade-enter-active {
  transition: all .3s ease;
}
.slide-fade-leave-active {
  transition: all .3s cubic-bezier(1.0, 0.5, 0.8, 1.0);
}
.slide-fade-enter, .slide-fade-leave-active {
  opacity: 0;
}

.input_container {
  width: 100%;
  height: 70px;
  background: $theme_color;

  .container {
    padding-top: 12px;
    padding-left: 120px;

    .advanced_search_btn {
      display: inline-block;
      cursor: pointer;
      margin-left: 30px;
      color: #fff;
      font-size: 18px;

      a {
        color: #fff;
        text-decoration: underline;
      }

      i {
        color: #fff;
      }
    }

    .input_box {
      display: inline-block;
      width: 640px;
      height: 46px;
      border-radius: 3px;
      font-size: 0;
      background: #fff;
    }

    input {
      width: 570px;
      height: inherit;
      padding-left: 10px;
      padding-right: 10px;
      outline: none;
      font-size: 16px;
      border: none;
      background: none;
    }

    .btn {
      display: inline-block;
      vertical-align: top;
      width: 70px;
      line-height: 46px;
      cursor: pointer;
      text-align: center;
      height: inherit;
      letter-spacing: 2px;
      font-size: 16px;
      border: none;
      color: #fff;
      background: $btn_color;
      border-top-right-radius: 3px;
      border-bottom-right-radius: 3px;
    }
  }
}

.filter_container {
  width: 100%;
  background: $app_bg_colol;
}

.city_seleted {
  height: 50px;
  line-height: 50px;
  background: $app_bg_colol;
  font-size: 16px;
  color: #324057;

  a {
    color: #324057;
    text-decoration: underline;
    margin-right: 20px;
  }
}
</style>
