import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

export default new VueRouter({
  routes: [
    {
      path: '/photo_album',
      component: () => import('@/views/photo_album/main'),
      children: [
        {
          path: 'album/add',
          component: () => import('@/views/photo_album/album/add')
        },
        {
          path: 'album/list',
          component: () => import('@/views/photo_album/album/list')
        },
        {
          path: 'photo/add',
          component: () => import('@/views/photo_album/photo/add')
        },
        {
          path: 'photo/list',
          component: () => import('@/views/photo_album/photo/list')
        }
      ]
    }
  ]
})
