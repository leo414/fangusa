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
      style: 'mapbox://styles/mapbox/streets-v9',
      center: [-103.59179687498357, 40.66995747013945],
      zoom: 4,
    })

    map.on('load', function() {
      map.addSource("earthquakes", {
        type: "geojson",
        data: EarthQuakes,
        cluster: true,
        clusterMaxZoom: 14, // Max zoom to cluster points on
        clusterRadius: 50 // Radius of each cluster when clustering points (defaults to 50)
      });

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
              [0, "#51bbd6"],
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
          }
        }
      });

      map.addLayer({
        id: "cluster-count",
        type: "symbol",
        source: "earthquakes",
        filter: ["has", "point_count"],
        layout: {
          "text-field": "{point_count_abbreviated}",
          "text-font": ["DIN Offc Pro Medium", "Arial Unicode MS Bold"],
          "text-size": 12
        }
      });

      map.addLayer({
        id: "unclustered-point",
        type: "circle",
        source: "earthquakes",
        filter: ["!has", "point_count"],
        paint: {
          "circle-color": "#11b4da",
          "circle-radius": 4,
          "circle-stroke-width": 1,
          "circle-stroke-color": "#fff"
        }
      });
    });
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
