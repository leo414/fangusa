// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'

import VueRouter from 'vue-router'
import FastClick from 'fastclick'

import App from './App'
import Routers from './router'
import Util from './libs/util'
import './mixins/GlobalMixin'
import './scss/index.scss'

/**
 * Axios config
 */
import AxiosPlugin from './libs/axios'
Vue.use(AxiosPlugin)

import {
  Field,
  Button,
  Range,
  Switch,
  Radio,
  InfiniteScroll,
  Spinner,
  Swipe, 
  SwipeItem,
  Picker,
} from 'mint-ui'

Vue.component(Picker.name, Picker)
Vue.component(Swipe.name, Swipe)
Vue.component(SwipeItem.name, SwipeItem)
Vue.component(Spinner.name, Spinner)
Vue.use(InfiniteScroll)
Vue.component(Radio.name, Radio)
Vue.component(Switch.name, Switch)
Vue.component(Range.name, Range)
Vue.component(Field.name, Field)
Vue.component(Button.name, Button)

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
