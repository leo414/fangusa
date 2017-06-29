<template>
  <div class="chart_line_container" v-if="tabs.length">
    <el-tabs v-model="activeName">
      <el-tab-pane v-for="(tab, index) in tabs" :key="index" :label="tab" :name="tab">{{tab}}</el-tab-pane>
    </el-tabs>

    <ve-line 
      :data="chartData" 
      :settings="chartSettings" 
      legend-visible
    >
    </ve-line>
  </div>
</template>

<script>
export default {
  name: 'ChartLine',
  props: {
    id: {
      default: '',
      type: String,
    }
  },
  data() {
    return {
      activeName: 'one_year_trend',
      one_year_trend: [],
      five_year_trend: [],
      ten_year_trend: [],
      chartData: {},
      chartSettings: {},
    }
  },

  watch: {
    id(url_object_id) {
      if(url_object_id) {
        this.fetchData(url_object_id)
      }
    },
    activeName(key) {
      this.renderCharts(key)
    },
  },
 
  methods: {
    getLocalTime(timestamp) {
      const date = new Date(timestamp)
      let Y = date.getFullYear(),
          m = date.getMonth() + 1,
          d = date.getDate()
      if(m<10){
        m = '0' + m
      }
      if(d<10){
        d = '0' + d
      }
      return Y + '-' + m + '-' + d
    },

    fetchData(url_object_id) {
      this.$http.get(this.API.HOUSE.Trend + url_object_id + '/').then(res => {
        if(res) {
          const {
            one_year_trend = [],
            five_year_trend = [],
            ten_year_trend = [],
          } = res
          this.one_year_trend = one_year_trend
          this.five_year_trend = five_year_trend
          this.ten_year_trend = ten_year_trend
          this.renderCharts('one_year_trend')
        }
      })
    },

    renderCharts(key) {
      this.chartData = {
        columns: this.columns,
        rows: this.renderRows(key),
      }
    },

    renderRows(key) {
      let result = []
      const chartsData = this[key]
      const length = Math.max(...chartsData.map(trend => trend.data.length))
      for(let i = 0; i< length; i++) {
        result.push({})
      }

      chartsData.forEach((trend, index) => {
        trend.data.forEach((item, index2) => {
          result[index2]['日期'] = this.getLocalTime(item.xValue)
          result[index2][trend.name] = item.yValue
          result[index2][trend.name] = item.yValue
        })
      })
      return result
    },
  },
  computed: {
    tabs() {
      let newTabs = []
      if(this.one_year_trend.length) {
        newTabs.push('one_year_trend')
      }
      if(this.five_year_trend.length) {
        newTabs.push('five_year_trend')
      }
      if(this.ten_year_trend.length) {
        newTabs.push('ten_year_trend')
      }
      return newTabs
    },

    columns() {
      const nameList = this.one_year_trend.map(item => item.name)
      return ['日期', ...nameList]
    },
  },
}
</script>

<style scoped>
 
</style>
