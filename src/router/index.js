const Homepage = resolve => import('views/homePage/index').then(module => resolve(module))
const Login = resolve => import('views/entry/login').then(module => resolve(module))
const Register = resolve => import('views/entry/register').then(module => resolve(module))
const ChangePd = resolve => import('views/entry/change-pd').then(module => resolve(module))
const HouseDetail = resolve => import('views/detail/index').then(module => resolve(module))
// const MapSearch = () => import('views/searchResult/MapSearch)

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

  // {
  //   path: '/map_search',
  //   meta: {
  //     title: '地图搜索房源'
  //   },
  //   name: 'MapSearch',
  //   component: MapSearch,
  // },

  {
    path: '/detail/:id',
    meta: {
      title: '房详情'
    },
    name: 'HouseDetail',
    component: HouseDetail,
  },
]
export default routers
