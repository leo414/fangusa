// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'

import iView from 'iview'
import VueRouter from 'vue-router'
import Vuex from 'vuex'
import VueResource from 'vue-resource'

import App from './App'
import Routers from './router'
import Util from './libs/util'

import  './scss/index.scss'
import 'iview/dist/styles/iview.css'

Vue.use(iView)
Vue.use(VueResource)
Vue.use(Vuex)
Vue.use(VueRouter)

Vue.config.productionTip = false

Vue.http.interceptors.push(function(request, next) {
  request.method = 'GET'
  request.headers.set('Content-Type', 'application/x-www-form-urlencoded;charset=UTF-8;')
  next()
})

Vue.http.options.emulateJSON = true

// route config
const RouterConfig = {
  mode: 'history',
  routes: Routers
}
const router = new VueRouter(RouterConfig)

router.beforeEach((to, from, next) => {
  iView.LoadingBar.start()
  Util.title(to.meta.title)
  next()
})

router.afterEach((to, from, next) => {
  iView.LoadingBar.finish()
  window.scrollTo(0, 0)
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: { App }
})
