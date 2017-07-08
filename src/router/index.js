const Homepage = resolve => import('views/home-page/index').then(module => resolve(module))
const Login = resolve => import('views/entry/login').then(module => resolve(module))
const Register = resolve => import('views/entry/register').then(module => resolve(module))
const ChangePd = resolve => import('views/entry/change-pd').then(module => resolve(module))
const HouseDetail = resolve => import('views/detail/index').then(module => resolve(module))
const User = resolve => import('views/user/index').then(module => resolve(module))
const SearchResult = resolve => import('views/search-result/search-result').then(module => resolve(module))
const Map = resolve => import('views/search-result/map') .then(module => resolve(module))

const routers = [
  {
    path: '/',
    meta: {
      title: '首页'
    },
    name: 'Homepage',
    component: Homepage,
  },
    {
    path: '/user',
    meta: {
      title: '个人中心'
    },
    name: 'Homepage',
    component: User,
  },
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
  {
    path: '/change_pd',
    meta: {
      title: '修改密码'
    },
    name: 'ChangePd',
    component: ChangePd,
  },

  {
    path: '/map',
    meta: {
      title: '地图搜索房源'
    },
    name: 'Map',
    component: Map,
  },

  {
    path: '/house/:id',
    meta: {
      title: '房详情'
    },
    name: 'HouseDetail',
    component: HouseDetail,
  },

  {
    path: '/result/',
    meta: {
      title: '房源搜索结果'
    },
    name: 'SearchResult',
    component: SearchResult,
  },
]
export default routers
