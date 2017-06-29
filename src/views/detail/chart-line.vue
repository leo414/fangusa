<template>
  <div>
    <ve-line 
      :data="chartData" 
      :settings="chartSettings" 
      :tooltip-visible="false"
      legend-visible
    >
    </ve-line>
  </div>
</template>

<script>
import Trend from './trend'

export default {
  name: 'ChartLine',
  data() {
    return {
      chartData: {},
      chartSettings: {},
      Trend,
    }
  },
  mounted() {
    // const data = this.Trend.one_year_trend[0].data
    // data.forEach(item => item.xValue = this.getLocalTime(item.xValue))
    // this.chartData = {
    //   columns: this.columns,
    //   rows: data
    // }

    // this.chartSettings = {
    //   scale: { y: true },
    // }


    // const data = this.Trend.one_year_trend[0].data.map(item => ({
    //   '日期': this.getLocalTime(item.xValue),
    //   [this.columns[1]]: item.yValue,
    // }))

    let result = []
    const length = this.Trend.one_year_trend[0].data.length
    for(let i = 0; i< length; i++) {
      result.push({})
    }

    // 算出 this.Trend.one_year_trend 里每个 data.length 的最小值
    // Because the stupid Zillow programmer, so I wrote this line of stupid code.    
    const minLength = Math.min.apply(null, this.Trend.one_year_trend.map(trend => trend.data.length))
    
    this.Trend.one_year_trend.forEach((trend, index) => {
      for(let i = 0; i < minLength; i++) {
        if(index === 0) {
          result[i]['日期'] = trend.data[i].xValue
          result[i][trend.name] = trend.data[i].yValue
        } else {
          result[i][trend.name] = trend.data[i].yValue
        }
      }
    })

    console.log(result)
  },
  methods: {
    getLocalTime(timestamp) {
      const date = new Date(timestamp)
      let Y = date.getFullYear(),
          m = date.getMonth()+1,
          d = date.getDate()
      if(m<10){
        m = '0'+m
      }
      if(d<10){
        d = '0'+d
      }
      return Y+'-'+m+'-'+d
    }
  },
  computed: {
    columns() {
      const nameList = this.Trend.one_year_trend.map(item => item.name)
      return ['日期', ...nameList]
    },
  },
}
</script>

<style>
  
</style>
