require('es6-promise').polyfill()
import axios from 'axios'
// import qs from 'qs'
import { Message } from 'element-ui'

const Axios = axios.create({
  baseURL: process.env.BASE_API,
  timeout: 10000,
  // withCredentials: true,  // CORS 配置，如果后端不用 CORS 请设置成 false ，或者删除本行
  // headers: {'Content-Type': 'application/x-www-form-urlencoded'},
})

Axios.interceptors.request.use(config => {
  // if(config.method  === 'post'){
  //   // 传参序列化
  //   // Only applicable for request methods 'PUT', 'POST', and 'PATCH'
  //   config.data = qs.stringify(config.data);
  // }
  if (localStorage.token) {  // 判断是否存在token，如果存在的话，则每个http header都加上token
    config.headers.Authorization = `JWT ${localStorage.token}`
  }
  return config
},(error) =>{
  // 错误的传参 
  return Promise.reject(error)
})

Axios.interceptors.response.use(res => {
  return res.data
},error => {
  if(!error.response) return Promise.reject(error.response.data)
  if(error.response.status === 401) {
    // 未登录，跳转到登录页面
    // location.href = '/login'
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