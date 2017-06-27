const Login = resolve => import('./Login.vue').then(module => resolve(module))
const Register = resolve => import('./Register.vue').then(module => resolve(module))

export default [
  {
    path: '/login',
    meta: {
      title: '登录'
    },
    name: 'Login',
    component: Login,
  },
  {
    path: '/register',
    meta: {
      title: '注册'
    },
    name: 'Register',
    component: Register,
  },
]
