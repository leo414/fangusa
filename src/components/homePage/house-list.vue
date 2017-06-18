<template lang="html">
  <div class="new_house container">
    <h2 class="h2">{{title}}</h2>

    <swiper :options="swiperOption">
      <swiper-slide v-for="(house, index) in houseList" :key="index">
        <house-lay :info="house" />
      </swiper-slide>
      <div class="swiper-pagination" slot="pagination"></div>
      <div class="swiper-button-prev" slot="button-prev"></div>
      <div class="swiper-button-next" slot="button-next"></div>
    </swiper>
  </div>
</template>

<script>

import HouseLay from '../layout/house-lay'

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
      swiperOption: {
        pagination: '.swiper-pagination',
        slidesPerView: 3,
        slidesPerGroup: 3,
        paginationClickable: true,
        spaceBetween: 20,
        nextButton: '.swiper-button-next',
        prevButton: '.swiper-button-prev',
      },
    }
  },
  mounted() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      this.$http.get(this.API.HOUSE.List).then(res => {
        this.houseList = res.results
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
