// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'

import VueRouter from 'vue-router'

import App from './App'
import Routers from './router'
import Util from './libs/util'

import 'element-ui/lib/theme-default/index.css'
import  './scss/index.scss'

Vue.use(VueRouter)

Vue.config.productionTip = false

import { 
  Row, 
  Col,
  Input,
  Switch,
  Select,
  Option,
  Slider,
  Button,
} from 'element-ui'
Vue.use(Row)
Vue.use(Col)
Vue.use(Input)
Vue.use(Switch)
Vue.use(Select)
Vue.use(Option)
Vue.use(Slider)
Vue.use(Button)

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

router.afterEach((to, from, next) => {
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
