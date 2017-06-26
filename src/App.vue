<template>
  <div id="app">
    <nav-lay />
    <search-lay></search-lay>
    <router-view class="app_content"></router-view>
    <footer-lay />
  </div>
</template>

<script>
import NavLay from 'views/layout/nav-lay'
import FooterLay from 'views/layout/footer-lay'
import SearchLay from 'views/layout/search-lay'
export default {
  name: 'App',
  components: {
    NavLay,
    FooterLay,
    SearchLay,
  },
  created() {
    if(sessionStorage.rate) return
    this.$http.get(this.API.HOUSE.Rate).then(res => {
      if(res) {
        sessionStorage.rate = JSON.stringify(res)
      }
    })
  },
}
</script>

<style lang="scss">
</style>
