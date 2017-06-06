<template lang="html">
<div id="search" class="bg_white_container">
  <section class="input_container">
    <div class="container">
      <div class="input_box">
        <input v-model="search_key" type="search" placeholder="城市名／邮编／房源编号" />
        <button>搜索</button>
      </div>
      <div class="advanced_search_btn" @click="is_show_search = !is_show_search">
        <i class="i i-shezhi1" />
        <a href="javascript:;">高级搜索</a>
        <i v-if="!is_show_search" class="i i-xiajiantou" />
        <i v-else class="i i-shangjiantou" />
      </div>
    </div>
  </section>

  <section class="filter">
    <div class="container">
      热门城市：
      <router-link to="#">洛杉矶</router-link>
      <router-link to="#">旧金山</router-link>
      <router-link to="#">达拉斯</router-link>
      <router-link to="#">西雅图</router-link>
      <router-link to="#">纽约</router-link>
      <router-link to="#">波士顿</router-link>
    </div>

    <transition name="slide-fade">
      <advanced-search v-if="is_show_search" />
    </transition>
  </section>

</div>
</template>

<script>
import { Row, Col } from 'iview/src/components/grid'
import AdvancedSearch from './AdvancedSearch

export default {
  name: 'Search',
  components: {
    Row,
    Coll: Col,
    AdvancedSearch,
  },
  data() {
    return {
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
  }
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
    }

    input {
      width: 570px;
      height: inherit;
      padding-left: 10px;
      font-size: 16px;
      border-top-left-radius: 3px;
      border-bottom-right-radius: 3px;
      border: none;
      background: #fff;
    }

    button {
      width: 70px;
      height: inherit;
      letter-spacing: 2px;
      border-top-right-radius: 3px;
      border-bottom-right-radius: 3px;
      font-size: 16px;
      border: none;
      color: #fff;
      background: $btn_color;
    }
  }
}

.filter {
  position: relative;
  left: 0;
  top: 0;
  height: 60px;
  line-height: 60px;
  background: $app_bg_colol;
  font-size: 16px;
  color: #000;

  a {
    color: #000;
    text-decoration: underline;
    margin-right: 20px;
  }
}
</style>
