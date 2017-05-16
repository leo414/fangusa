// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'

import VueRouter from 'vue-router'
import FastClick from 'fastclick'

import App from './App'
import Routers from './router'
import Util from './libs/util'

import './scss/utility.scss'

import { Field } from 'mint-ui'
import { Button } from 'mint-ui'
import { Range } from 'mint-ui'
import { Switch } from 'mint-ui'
import { Actionsheet } from 'mint-ui'

Vue.component(Actionsheet.name, Actionsheet)
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
