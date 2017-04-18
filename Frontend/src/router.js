const Index = resolve => require(['./views/index.vue'], resolve)

const routers = [
  {
    path: '/',
    meta: {
      title: 'fangusa'
    },
    component: Index,
  }
]
export default routers
