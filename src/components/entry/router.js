export default [
  {
    path: '/login',
    meta: {
      title: '登录'
    },
    name: 'Login',
    component: resolve => require(['./Login.vue'], resolve)
  },
  {
    path: '/register',
    meta: {
      title: '注册'
    },
    name: 'Register',
    component: resolve => require(['./Register.vue'], resolve)
  },
]
