// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'

import VueRouter from 'vue-router'

import App from './App'
import Routers from './router'
import Util from './libs/util'

import  './scss/utility.scss'
import 'iview/dist/styles/iview.css'

import LoadingBar from 'iview/src/components/loading-bar'

Vue.use(VueRouter)

Vue.config.productionTip = false

// route config
const RouterConfig = {
  mode: 'history',
  routes: Routers
}
const router = new VueRouter(RouterConfig)

router.beforeEach((to, from, next) => {
  LoadingBar.start()
  Util.title(to.meta.title)
  next()
})

router.afterEach((to, from, next) => {
  LoadingBar.finish()
  window.scrollTo(0, 0)
  // 谷歌统计
  if (window.ga) {
    window.ga('set', 'page', to.fullPath) // 你可能想根据请求参数添加其他参数，可以修改这里的 to.fullPath
    window.ga('send', 'pageview')
  }
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  render: h => h(App)
})
