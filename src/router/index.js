const Homepage = resolve => require(['../components/homePage/index.vue'], resolve)

const routers = [
  {
    path: '/',
    meta: {
      title: '房美国首页'
    },
    name: 'Homepage',
    component: Homepage
  },
]
export default routers
