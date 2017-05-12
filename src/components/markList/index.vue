<template>
<section id="mark_list">
  <header class="header">
    <MenuLayout @open="is_show_filter = false" />
    <div class="title">
      收藏的房源
    </div>

    <div class="btn_bar">
      <p class="fl tl">
        共收藏 10 套房源信息
      </p>
    </div>
  </header>

  <div class="house_lsit">
    <HouseLayout v-for="info in 10" :key="info" />
  </div>
</section>

</template>

<script>
import Menu from '../globalLayout/Menu.vue'
import HouseLayout from '../globalLayout/HouseLayout.vue'
export default {
  name: "MarkList",
  data() {
    return {

    }
  },
  components: {
    MenuLayout: Menu,
    HouseLayout,
  },
}
</script>

<style lang="scss" scoped>
@import "../../scss/variables";

.house_lsit {
  margin-top: 90px;
}

.header {
  position: fixed;
  top: 0;
  left: 0;
  z-index: $z_filter;
  width: 100%;
  height: 90px;
  padding: 10px 20px;
  overflow: hidden;
  background: $theme_color;
  color: #fff;
  font-size: 12px;
}

.title {
  width: 100%;
  height: 40px;
  font-size: 22px;
  line-height: 40px;
  text-align: center;
}

.btn_bar {
  width: 100%;
  height: 44px;
  line-height: 44px;
}
</style>
