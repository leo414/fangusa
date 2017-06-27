<template lang="html">
<section>
  <Search />
  <div 
    v-infinite-scroll="loadMore"
    infinite-scroll-disabled="loading"
    infinite-scroll-distance="10"
    :infinite-scroll-immediate-check="true"
    class="house_lsit"
  >
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
      loading: false,
      houseList: [],
      pageCount: 1,
      total: 0,
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
    },
    loadMore(){
      console.log(1212)
      this.loading = true
    },
  },
}
</script>

<style lang="scss" scoped>
.house_lsit {
  margin-top: 90px;
}
</style>
