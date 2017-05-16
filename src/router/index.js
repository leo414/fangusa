import entryRoutes from '../components/entry/router'

const routers = [
  ...entryRoutes,
  
  {
    path: '/',
    meta: {
      title: 'Fangusa'
    },
    name: 'HomePage',
    component: resolve => require(['../components/homePage/index.vue'], resolve)
  },

  {
    path: '/house/:id',
    meta: {
      title: '房产详情'
    },
    name: 'HouseDetail',
    component: resolve => require(['../components/detail/index.vue'], resolve)
  },

  {
    path: '/filter',
    meta: {
      title: '高级搜索'
    },
    name: 'Filter',
    component: resolve => require(['../components/homePage/Filter.vue'], resolve)
  },

  {
    path: '/mark_list',
    meta: {
      title: '收藏列表'
    },
    name: 'MarkList',
    component: resolve => require(['../components/markList/index.vue'], resolve)
  },

  {
    path: '/contact_us',
    meta: {
      title: '联系我们'
    },
    name: 'ContactUs',
    component: resolve => require(['../components/contactUs/index.vue'], resolve)
  },
]

export default routers
