<template>
<section id="filter_container">
Filter
</section>

</template>

<script>

export default {
  name: "Filter",
  data() {
    return {

    }
  }
}
</script>

<style lang="scss" scoped>
@import "../../scss/variables";

#filter_container {
  position: absolute;
  top: 90px;
  left: 0;
  width: 100%;
  height: 500px;
  z-index: $z_menu_icon;
  color: $content_color;
  background: #fff;
}
</style>
