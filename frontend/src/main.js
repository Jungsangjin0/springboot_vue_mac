// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import vuex from './store/store'
import axios from 'axios'

Vue.config.productionTip = false
Vue.prototype.$http = axios // axios 전역 설정

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  vuex,
  components: {App},
  template: '<App/>'
})
