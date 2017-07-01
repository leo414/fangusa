import entryRoutes from '../components/entry/router'

const HomePage = resolve => import('../components/homePage/index.vue').then(module => resolve(module))
const UserProfile = resolve => import('../components/users/index.vue').then(module => resolve(module))

// const LinkPage = resolve => import('../components/users/LinkPage.vue').then(module => resolve(module))

const HouseDetail = resolve => import('../components/detail/index.vue').then(module => resolve(module))
const Filter = resolve => import('../components/homePage/Filter.vue').then(module => resolve(module))
const MarkList = resolve => import('../components/markList/index.vue').then(module => resolve(module))
const ContactUs = resolve => import('../components/contactUs/index.vue').then(module => resolve(module))

const routers = [
  ...entryRoutes,

  {
    path: '/',
    meta: {
      title: 'Fangusa'
    },
    name: 'HomePage',
    component: HomePage,
  },

  // {
  //   path: '/link_page',
  //   meta: {
  //     title: '引导页'
  //   },
  //   name: 'LinkPage',
  //   component: LinkPage,
  // },

  {
    path: '/users',
    meta: {
      title: '个人设置'
    },
    name: 'UserProfile',
    component: UserProfile,
  },

  {
    path: '/house/:id',
    meta: {
      title: '房产详情'
    },
    name: 'HouseDetail',
    component: HouseDetail,
  },

  {
    path: '/filter',
    meta: {
      title: '高级搜索'
    },
    name: 'Filter',
    component: Filter,
  },

  {
    path: '/mark_list',
    meta: {
      title: '收藏列表'
    },
    name: 'MarkList',
    component: MarkList,
  },

  {
    path: '/contact_us',
    meta: {
      title: '联系我们'
    },
    name: 'ContactUs',
    component: ContactUs,
  },
]

export default routers
