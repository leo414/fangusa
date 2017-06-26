import Vue from 'vue'
import { API } from '../libs/Constant'
import { Message } from 'element-ui'

Vue.mixin({
  created() {
    this.API = API
  },

  filters: {
    toRMB(value) {
      const { dollar_to_rmb } = JSON.parse(sessionStorage.rate)
      return parseInt(value * dollar_to_rmb)
    },

    toRMB_W(value) {
      const { dollar_to_rmb } = JSON.parse(sessionStorage.rate)
      return parseInt(value * dollar_to_rmb / 10000)
    },
  },

  beforeDestroy() {
    Message.closeAll()
  },
})