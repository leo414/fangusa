require('es6-promise').polyfill()
import axios from 'axios'
import { Toast } from 'mint-ui'
import Vue from 'vue'

const Axios = axios.create({
  baseURL: process.env.BASE_API,
  timeout: 5000,
  withCredentials: true,  // CORS 配置，如果后端不用 CORS 请设置成 false ，或者删除本行
})
// Axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;'

// 保存 Toast 事件，便于销毁
let toast = null


/**
 * 
 * @class AjaxFactory
 * url: String | 请求的 url
 * data: Object | 请求的数据
 */
class AjaxFactory {
  constructor(url='/commodity', data={}) {
    this.url = url
    this.data = data
  }

  GET() {
    return this._processingData(Axios.get(this.url, {params: this.data}))
  }

  POST() {
    return this._processingData(Axios.post(this.url, this.data))
  }

  _processingData(AJAX_PROMISE) {
    return AJAX_PROMISE
      .then(response => {
        if(response.status !== 200) return this._ajaxFail()

        const { data } = response
        if(data.succes) return data
        this._ajaxFail(data.error_msg)
      })
      .catch(error => {
        console.error('Ajax ' + error)
        this._ajaxFail()
      })
  }

  _ajaxFail(message = '') {
    toast = Toast({
      message: message || '网络错误，请检查网络后尝试刷新！',
      position: 'middle',
      duration: 1500
    })
  }
}

// 组件销毁时清除 toast
Vue.mixin({
  beforeDestroy() {
    if(toast) toast.close()
  }
})

export default AjaxFactory
