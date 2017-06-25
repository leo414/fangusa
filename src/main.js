// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import Util from './libs/util'
import VueAwesomeSwiper from 'vue-awesome-swiper'

import './scss/index.scss'
import './mixins/GlobalMixin'

Vue.use(VueAwesomeSwiper)
Vue.config.productionTip = false

/**
 * Element UI 
 */
import 'element-ui/lib/theme-default/index.css'

import { 
  Row, 
  Col,
  Input,
  Switch,
  Select,
  Option,
  Slider,
  Button,
  Form,
  FormItem,
  Carousel,
  CarouselItem,
  Tooltip, 
  Pagination,
} from 'element-ui'
Vue.use(Row)
Vue.use(Col)
Vue.use(Input)
Vue.use(Switch)
Vue.use(Select)
Vue.use(Option)
Vue.use(Form)
Vue.use(FormItem)
Vue.use(Slider)
Vue.use(Button)
Vue.use(Carousel)
Vue.use(CarouselItem)
Vue.use(Tooltip)
Vue.use(Pagination)


/**
 * Axios config
 */
import AxiosPlugin from './libs/axios'
Vue.use(AxiosPlugin)


/**
 * route config
 */
import VueRouter from 'vue-router'
import Routers from './router'

Vue.use(VueRouter)

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
