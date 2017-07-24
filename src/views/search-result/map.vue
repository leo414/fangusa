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
import EarthQuakes from './earthquakes.json'
import mapboxgl from 'mapbox-gl/dist/mapbox-gl'
import MapboxGeocoder from '@mapbox/mapbox-gl-geocoder'

mapboxgl.accessToken = 'pk.eyJ1IjoiemF4bGN0IiwiYSI6ImNqNHVsODAwNjBrcXAycXI1cTVkdGU3ZHEifQ.0QfeJeP1LfAbm64_bYxj6A'

//const bounds = [
//  [596.77734375, 43.96119063892024],
//  [645.556640625, 25.562265014427492]
//]

export default {
  name: 'MapSearch',
  data() {
    return {
    }
  },

  mounted() {
    const map = new mapboxgl.Map({
      container: 'map_box',
      style: 'mapbox://styles/mapbox/streets-v9',
      center: [-103.59179687498357, 40.66995747013945],
      zoom: 4,
      //maxBounds: bounds,
    })

    map.on('load', () => {
      map.addSource("earthquakes", {
        type: "geojson",
        data: EarthQuakes,
        cluster: true,
        clusterMaxZoom: 14, // Max zoom to cluster points on
        clusterRadius: 50 // Radius of each cluster when clustering points (defaults to 50)
      })

      map.addLayer({
        id: "clusters",
        type: "circle",
        source: "earthquakes",
        filter: ["has", "point_count"],
        paint: {
          "circle-color": {
            property: "point_count",
            type: "interval",
            stops: [
              [0, "#4caa00"],
              [100, "#f1f075"],
              [750, "#f28cb1"],
            ]
          },
          "circle-radius": {
            property: "point_count",
            type: "interval",
            stops: [
              [0, 20],
              [100, 30],
              [750, 40]
            ]
          },
        }
      })

      map.addLayer({
        id: "cluster-count",
        type: "symbol",
        source: "earthquakes",
        filter: ["has", "point_count"],
        layout: {
          "text-field": "{point_count_abbreviated}",
          "text-font": ["DIN Offc Pro Medium", "Arial Unicode MS Bold"],
          "text-size": 12,
        }
      })

      map.addLayer({
        id: "unclustered-point",
        type: "circle",
        source: "earthquakes",
        filter: ["!has", "point_count"],
        paint: {
          "circle-color": "#4caa00",
          "circle-radius": 4,
          "circle-stroke-width": 1,
          "circle-stroke-color": "#fff"
        }
      })
    })

    // 放大缩小组件
    map.addControl(new mapboxgl.NavigationControl(), "bottom-left")

    // 搜索组件
    map.addControl(new MapboxGeocoder({
      accessToken: mapboxgl.accessToken
    }))

    // popup
    const popup = new mapboxgl.Popup({closeOnClick: false})
      .setLngLat([-96, 37.8])
      .setHTML('<h1>Hello World!</h1>')
      .addTo(map)

    map.on('moveend', e => this.onMapMoveend(e))
    map.on('click', e => this.onClickMap(e))
  },
  methods: {
    onMapMoveend(e) {
      console.log(e)
    },

    onClickMap(e) {
      console.log(e)
    },
  },
}
</script>

<style lang="sass" scoped>
.map_container
  height: 800px;
  box-sizing: content-box

#map_box
  height: 800px;
  box-sizing: content-box

.house_list
  height: 500px;
  background: #fff
</style>
