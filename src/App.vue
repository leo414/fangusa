<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: 'App',
  components: {
  },
  created() {
    if(sessionStorage.rate) return
    this.$http.get(this.API.HOUSE.Rate).then(res => {
      if(res) {
        window.globalData = res
      }
    })
  },
}
</script>
