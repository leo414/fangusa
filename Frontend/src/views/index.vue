<style scoped lang="scss">

</style>

<template>
<div class="index">
  hello world
</div>

</template>
<script>
import API from '../libs/api'

export default {
  created() {
    this.$http.get(API.PrefetchLaunchImages).then(response => {
      console.log(response)
    }, response => {
      // TODO
    })
  },

  methods: {
  }
}
</script>
