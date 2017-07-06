require('es6-promise').polyfill()
import axios from 'axios'
// import qs from 'qs'
import { Message } from 'element-ui'
import { API } from 'libs/Constant'
import _includes from 'lodash.includes'

const Axios = axios.create({
  baseURL: process.env.BASE_API,
  timeout: 10000,
})

Axios.interceptors.request.use(config => {
  const UrlLength = config.baseURL.length
  const Pathname = config.url.slice(-(config.url.length - UrlLength))
  // 只有用户的方面的 API 才需要添加 token
  if (localStorage.token &&  _includes(API.USER, Pathname)) {
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
    // 未登录 or  token 过期，跳转到登录页面
    localStorage.token = ''
    location.href = '/login'
  } else if (error.response.status === 400) {
    const { data } = error.response
    const errorMsg = Object.keys(data).reduce((str, key) => str + data[key][0] + '      ', '')
    Message.error(errorMsg.trim())
  }
  return Promise.reject(error.response.data)
})

export default {
  install(Vue) {
    Object.defineProperty(Vue.prototype, '$http', { value: Axios })
  }
}