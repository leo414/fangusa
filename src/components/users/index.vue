<template>
<section id="contact_us">
  <NavBar title="个人设置" />
</section>

</template>

<script>
import NavBar from '../globalLayout/NavBar.vue'

export default {
  name: "UserProfile",
  components: {
    NavBar
  },
  data() {
    return {

    }
  },
}
</script>

<style lang="scss" scoped>
@import "../../scss/variables";
</style>
