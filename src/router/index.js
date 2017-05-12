const HomePage = resolve => require(['../components/homePage/index.vue'], resolve)
const MarkList = resolve => require(['../components/markList/index.vue'], resolve)
const ContactUs = resolve => require(['../components/contactUs/index.vue'], resolve)

const routers = [
  {
    path: '/',
    meta: {
      title: 'you-test'
    },
    name: 'HomePage',
    component: HomePage
  },

  {
    path: '/mark_list',
    meta: {
      title: '收藏列表'
    },
    name: 'MarkList',
    component: MarkList
  },

  {
    path: '/contact_us',
    meta: {
      title: '联系我们'
    },
    name: 'ContactUs',
    component: ContactUs
  },
]
export default routers
