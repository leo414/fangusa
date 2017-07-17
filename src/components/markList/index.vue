<template>
<section id="mark_list">
  <NavBar title="收藏房源" />

  <div class="house_list" v-if="results.length">
    <HouseLayout v-for="(info, index) in houseList" :info="info" :key="index" />
  </div>
  <h3 class="house_list" v-else>暂无收藏</h3>
</section>

</template>

<script>
import NavBar from '../globalLayout/NavBar'
import HouseLayout from '../globalLayout/HouseLayout'
export default {
  name: "MarkList",
  data() {
    return {
      results: [],
    }
  },
  components: {
    NavBar,
    HouseLayout,
  },

  mounted() {
    this.fetchData()
  },

  methods: {
    fetchData() {
      this.$http.get(this.API.USER.Fav).then(res => {
        if(res.results) {
          this.results = res.results
        }
      })
    },
  },  

  computed: {
    houseList() {
      return this.results.map(result => {
        result.house.delete_id = result.id
        return result.house
      })
    }
  },
}
</script>

<style lang="scss" scoped>
@import "../../scss/variables";

.house_list {
  margin-top: 50px;
}

.btn_bar {
  width: 100%;
  height: 44px;
  line-height: 44px;
}
</style>
