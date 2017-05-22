import entryRoutes from '../components/entry/router'

const HomePage = () => import('../components/homePage/index.vue')
const UserProfile = () => import('../components/users/index.vue')

const LinkPage = () => import('../components/users/LinkPage.vue')

const HouseDetail = () => import('../components/detail/index.vue')
const Filter = () => import('../components/homePage/Filter.vue')
const MarkList = () => import('../components/markList/index.vue')
const ContactUs = () => import('../components/contactUs/index.vue')

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

  {
    path: '/link_page',
    meta: {
      title: '引导页'
    },
    name: 'LinkPage',
    component: LinkPage,
  },

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
