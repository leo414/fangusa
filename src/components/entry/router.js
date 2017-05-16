export default [
  {
    path: '/login',
    meta: {
      title: '登录'
    },
    name: 'Login',
    component: resolve => require(['./Login.vue'], resolve)
  },
]
