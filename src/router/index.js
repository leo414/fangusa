const HomePage = resolve => require(['../components/homePage/index.vue'], resolve)

const routers = [
  {
    path: '/',
    meta: {
      title: 'you-test'
    },
    name: 'HomePage',
    component: HomePage
  },
]
export default routers
