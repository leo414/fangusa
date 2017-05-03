// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'

import VueRouter from 'vue-router'
import Vuex from 'vuex'
import FastClick from 'fastclick'

import App from './App'
import Routers from './router'
import Util from './libs/util'

import './scss/utility.scss'

Vue.use(Vuex)
Vue.use(VueRouter)

Vue.config.productionTip = false
FastClick.attach(document.body)

// route config
const RouterConfig = {
  mode: 'history',
  routes: Routers
}
const router = new VueRouter(RouterConfig)

router.beforeEach((to, from, next) => {
  Util.title(to.meta.title)
  next()
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  render: h => h(App)
})
