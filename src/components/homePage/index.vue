<template lang="html">
<section id="home_page">
  <Search />
  <div class="house_lsit">
    <house-layout v-for="(info, index) in houseList" :info="info" :key="index" />
  </div>
</section>
</template>

<script>
import Search from './Search'
import HouseLayout from '../globalLayout/HouseLayout'

export default {
  name: 'HomePage',
  components: {
    Search,
    HouseLayout,
  },
  data() {
    return {
      houseList: [],
    }
  },
  mounted() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      this.$http.get(this.API.HOUSE.List).then(res => {
        if(res.results) {
          this.houseList = res.results
        }
      })
    }
  },
}
</script>

<style lang="scss" scoped>
.house_lsit {
  margin-top: 90px;
}
</style>
