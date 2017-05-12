<template>
<section id="header">
  <MenuLayout @open="is_show_filter = false" />

  <div class="search_box">
    <input type="search" value="22222" />
    <i class="i i-sousuo" />
  </div>
  <div class="btn_bar">
    <p class="title fl">
      置业美国，美国精品房源
    </p>

    <div class="btn_list fr">
      <button class="advanced_search">高级搜索</button>
      <a class="filter" @click.stop="is_show_filter = !is_show_filter">排序 <i class="i i-paixu"/></a>
    </div>
  </div>

  <transition name="slide-fade">
    <ul class="sort_list" v-if="is_show_filter">
      <li class="active">智能排序 <i class="i i-duihao" /></li>
      <li>价格最低 <i class="i i-duihao" /></li>
      <li>价格最高 <i class="i i-duihao" /></li>
      <li>建造年龄最新 <i class="i i-duihao" /></li>
      <li>房屋面积最大 <i class="i i-duihao" /></li>
    </ul>
  </transition>

</section>

</template>

<script>
import Menu from '../globalLayout/Menu.vue'

export default {
  name: "Search",
  components: {
    MenuLayout: Menu,
  },
  data() {
    return {
      is_show_filter: false,
    }
  },
  methods: {
    
  }
}
</script>

<style lang="scss" scoped>
@import "../../scss/variables";

.slide-fade-enter-active {
  transition: all .3s ease;
}
.slide-fade-leave-active {
  transition: all .3s cubic-bezier(1.0, 0.5, 0.8, 1.0);
}
.slide-fade-enter, .slide-fade-leave-active {
  opacity: 0;
}

#header {
  position: relative;
  left: 0;
  right: 0;
  width: 100%;
  height: 90px;
  padding: 10px 20px;
  padding-bottom: 0;
  background: $theme_color;
}

.search_box {
  position: relative;
  left: 0;
  right: 0;
  width: 80vw;
  margin-left: 10vw;
  height: 36px;
  line-height: 36px;
  background: rgba(255, 255, 255, .8);
  border-radius: 4px;

  input {
    width: 100%;
    height: inherit;
    padding-left: 10px;
    padding-right: 30px;
    font-size: 14px;
    border: none;
    background: none;
    outline: none;
  }

  i {
    position: absolute;
    right: 0;
    top: 0;
    width: 40px;
    font-weight: bold;
    text-align: center;
    height: inherit;
  }
}

.btn_bar {
  width: 100%;
  height: 44px;
  line-height: 44px;
  font-size: 12px;
  color: #fff;

  .title {
    width: 48%;
  }

  .btn_list {
    width: 52%;
    text-align: right;

    i {
      font-size: 12px;
    }

    .advanced_search {
      padding: 4px 12px;
      margin-right: 10px;
      background: $btn_color;
      color: #fff;
      border: none;
      border-radius: 10px;
    }
  }
}

.sort_list {
  position: absolute;
  top: 90px;
  left: 0;
  width: 100%;
  height: auto;
  z-index: $z_menu_icon;
  color: $content_color;
  background: #fff;

  li {
    font-size: 14px;
    text-align: center;
    height: 40px;
    line-height: 40px;
    border-bottom: 1px $divder_color solid;

    i { display: none; }
  }

  .active {
    color: $theme_color;

    i {
      display: inline-block;
    }
  }
}
</style>
