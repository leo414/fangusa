require('es6-promise').polyfill()
import axios from 'axios'
import Vue from 'vue'
import { Message } from 'element-ui'

const ShowMessage = (message = '网络错误，请检查网络后尝试刷新！') => Message.error(message || '网络错误，请刷新重试！')

const Axios = axios.create({
  baseURL: process.env.BASE_API,
  timeout: 10000,
  // withCredentials: true,  // CORS 配置，如果后端不用 CORS 请设置成 false ，或者删除本行
  // headers: {'Content-Type': 'application/x-www-form-urlencoded'},
})

Axios.interceptors.response.use(res => {
  if(res.status !== 200) {
    ShowMessage()
  } else if (res.data.status === 'not_found') {
    ShowMessage('查询商品不存在')
  } else if (res.data.status === 'false'){
    ShowMessage(res.data.message)
  }

  return res.data
},error => {
  ShowMessage()
  return Promise.reject(error)
})


export default {
  install(Vue) {
    Object.defineProperty(Vue.prototype, '$http', { value: Axios })
  }
}