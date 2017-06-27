require('es6-promise').polyfill()
import axios from 'axios'
import { Toast } from 'mint-ui'
import Vue from 'vue'

// 保存 Toast 事件，便于销毁
let toast = null

const ShowMessage = (message = '网络错误，请检查网络后尝试刷新！') => {
  toast = Toast({
    message: message || '网络错误，请检查网络后尝试刷新！',
    position: 'middle',
    duration: 1500
  })
}

const Axios = axios.create({
  baseURL: process.env.BASE_API,
  timeout: 10000,
})

Axios.interceptors.request.use(config => {
  return config
},(error) =>{
  return Promise.reject(error)
})

Axios.interceptors.response.use(res => {
  if(res.status !== 200) {
    ShowMessage()
  }

  return res.data
},error => {
  ShowMessage()
  return Promise.reject(error)
})

// 组件销毁时清除 toast
Vue.mixin({
  beforeDestroy() {
    if(toast) toast.close()
  }
})

export default {
  install(Vue) {
    Object.defineProperty(Vue.prototype, '$http', { value: Axios })
  }
}
