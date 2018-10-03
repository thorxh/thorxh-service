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
          path: 'add',
          component: () => import('@/views/photo_album/album/add')
        }
      ]
    }
  ]
})
