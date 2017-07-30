<template lang="html">
  <div class="new_house container">
    <h2 class="h2">{{title}}</h2>
    <el-carousel indicator-position="outside" height="410px" :autoplay="false">
      <el-carousel-item v-for="(house, index) in houseList" :key="index">
        <el-row :gutter="20">
          <el-col :span="8" v-for="(info, index2) in house" :key="index2">
            <house-lay :info="info"></house-lay>
          </el-col>
        </el-row>
      </el-carousel-item>
    </el-carousel>
  </div>
</template>

<script>
import HouseLay from 'components/house-lay/house-lay'

export default {
  name: 'HouseList',
  props: {
    title: String,
  },
  components: {
    HouseLay,
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
          let data = res.results.slice(0, 9)
          let houseList = []
          while(data.length > 0) {
            houseList.push(data.splice(0, 3))
          }
          // 对房源数据进行分组，三个一组
          this.houseList = houseList
        }
      })
    }
  },
}
</script>

<style lang="scss" scoped>
.new_house {
  margin-top: 20px;
}

.h2 {
  padding: 20px 0;
}

.house {
  padding-right: 15px;
  &:last-child {
    padding-right: 0;
  }
}

</style>
