<template>
  <section id="map_search">
    <el-row>
      <el-col :span="16" class="map_container">
        <div id="map_box"></div>
      </el-col>
      <el-col :span="8" class="house_list">
        <div class="house_list"></div>
      </el-col>
    </el-row>
  </section>

</template>

<script>

import mapboxgl from 'mapbox-gl/dist/mapbox-gl'
mapboxgl.accessToken = 'pk.eyJ1IjoiemF4bGN0IiwiYSI6ImNqNHVsODAwNjBrcXAycXI1cTVkdGU3ZHEifQ.0QfeJeP1LfAbm64_bYxj6A'

export default {
  name: 'MapSearch',
  data() {
    return {
    }
  },

  mounted() {
    const map = new mapboxgl.Map({
      container: 'map_box',
      style: 'mapbox://styles/zaxlct/cj2iaf2o9002b2rmqr8brbsez'
    })
  }
}
</script>

<style>

.map_container {
  height: 600px;
  box-sizing: content-box;
}

#map_box {
  height: 600px;
  box-sizing: content-box;
}

.house_list {
  height: 500px;
  background: #fff;
}
</style>
