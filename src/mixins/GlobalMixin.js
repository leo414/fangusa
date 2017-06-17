import Vue from 'vue'
import { API } from '../libs/Constant'
import { Message } from 'element-ui'

Vue.mixin({
  created() {
    this.API = API
  },

  beforeDestroy() {
    Message.closeAll()
  },
})