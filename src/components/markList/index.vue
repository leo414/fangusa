<template>
<section id="mark_list">
  <NavBar title="收藏房源" />

  <div class="house_lsit">
    <HouseLayout v-for="info in 10" :key="info" />
  </div>
</section>

</template>

<script>
import NavBar from '../globalLayout/NavBar.vue'
import HouseLayout from '../globalLayout/HouseLayout.vue'
export default {
  name: "MarkList",
  data() {
    return {

    }
  },
  components: {
    NavBar,
    HouseLayout,
  },
}
</script>

<style lang="scss" scoped>
@import "../../scss/variables";

.house_lsit {
  margin-top: 50px;
}

.btn_bar {
  width: 100%;
  height: 44px;
  line-height: 44px;
}
</style>
