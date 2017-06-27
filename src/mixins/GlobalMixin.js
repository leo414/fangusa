import Vue from 'vue'
import { API } from '../libs/Constant'

Vue.mixin({
  created() {
    this.API = API
  },

  filters: {
    toRMB(value) {
      const { dollar_to_rmb } = window.globalData
      return parseInt(value * dollar_to_rmb)
    },

    toRMB_W(value) {
      const { dollar_to_rmb } = window.globalData
      return parseInt(value * dollar_to_rmb / 10000)
    },
  },
})