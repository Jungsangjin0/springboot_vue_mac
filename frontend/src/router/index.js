import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'

Vue.use(Router)

const First = () => import(/* webpackChunkName: "group-header" */ '../views/First.vue')
const Second = () => import(/* webpackChunkName: "group-header" */'../views/Second.vue')
const Third = () => import(/* webpackChunkName: "group-header" */'../views/Third.vue')
const Fourth = () => import(/* webpackChunkName: "group-header" */'../views/Fourth.vue')

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/first',
      name: 'first',
      component: First
    },
    {
      path: '/second',
      name: 'second',
      component: Second
    },
    {
      path: '/third',
      name: 'third',
      component: Third
    },
    {
      path: '/fourth',
      name: 'fourth',
      component: Fourth
    }
  ]
})
