import Vue from 'vue'

import iView from 'iview'
import VueRouter from 'vue-router'
import Vuex from 'vuex'
import VueResource from 'vue-resource'

import Util from './libs/util'
import App from './app.vue'
import Routers from './router'
import 'iview/dist/styles/iview.css'

Vue.use(VueRouter)
Vue.use(iView)
Vue.use(VueResource)
Vue.use(Vuex)

Vue.http.interceptors.push(function(request, next) {
  request.method = 'GET'
  request.headers.set('Content-Type', 'application/x-www-form-urlencoded;charset=UTF-8;');
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

new Vue({
  el: '#app',
  router: router,
  render: h => h(App)
})
