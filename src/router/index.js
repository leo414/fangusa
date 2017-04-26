const Hello = resolve => require(['../components/Hello.vue'], resolve)

const routers = [
  {
    path: '/',
    meta: {
      title: 'fangusa-test'
    },
    name: 'Hello',
    component: Hello
  },
]
export default routers
