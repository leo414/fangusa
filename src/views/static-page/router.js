const ContactUs = resolve => import('./contact-us.vue').then(module => resolve(module))

export default [
  {
    path: '/contact',
    meta: {
      title: '联系我们'
    },
    name: 'ContactUs',
    component: ContactUs,
  },
]