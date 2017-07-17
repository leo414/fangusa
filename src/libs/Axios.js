require('es6-promise').polyfill()
import axios from 'axios'
import { Toast } from 'mint-ui'
import { API } from '../libs/Constant'
import Vue from 'vue'
import _includes from 'lodash.includes'

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
  const UrlLength = config.baseURL.length
  const Pathname = config.url.slice(-(config.url.length - UrlLength))
  // 只有用户的方面的 API 才需要添加 token
  if ((localStorage.token && _includes(API.USER, Pathname)) || config.method === 'delete') {  
    config.headers.Authorization = `JWT ${localStorage.token}`
  }
  return config
},error => {
  // 错误的传参 
  return Promise.reject(error)
})

Axios.interceptors.response.use(res => {
  return res.data
},error => {
  if(!error.response) return Promise.reject(error)
  if(error.response.status === 401) {
    localStorage.token = ''
    localStorage.userInfo = ''
    location.href = '/login'
  } else if (error.response.status === 400) {
    const { data } = error.response
    const errorMsg = Object.keys(data).reduce((str, key) => str + data[key][0] + '      ', '')

    const { config } = error.response
    const UrlLength = config.baseURL.length
    const Pathname = config.url.slice(-(config.url.length - UrlLength))

    if(Pathname !== API.HOUSE.Login) {
      ShowMessage(errorMsg.trim())
    }
  }
  return Promise.reject(error.response.data)
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
