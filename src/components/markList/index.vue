<template>
<section id="mark_list">
  <NavBar title="收藏房源" />

  <div class="house_lsit">
    <HouseLayout v-for="(info, index) in houseList" :info="info" :key="index" />
  </div>
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
      return this.results.map(result => result.house)
    }
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
