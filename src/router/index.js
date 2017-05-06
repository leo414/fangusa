const Homepage = resolve => require(['../components/homePage/index.vue'], resolve)
const Login = resolve => require(['../components/entry/Login.vue'], resolve)
const Register = resolve => require(['../components/entry/Register.vue'], resolve)
const ChangePd = resolve => require(['../components/entry/ChangePd.vue'], resolve)

const routers = [
  {
    path: '/',
    meta: {
      title: '首页'
    },
    name: 'Homepage',
    component: Homepage,
  },{
    path: '/login',
    meta: {
      title: '登录'
    },
    name: 'Login',
    component: Login,
  },{
    path: '/register',
    meta: {
      title: '注册'
    },
    name: 'Register',
    component: Register,
  },{
    path: '/change_pd',
    meta: {
      title: '修改密码'
    },
    name: 'ChangePd',
    component: ChangePd,
  }
]
export default routers
