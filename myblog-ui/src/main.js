// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'


Vue.config.productionTip = false
// 1.导入axios模块
//注册全局导航栏
import menuBar from  './components/menunavbar.vue';
Vue.component('my-header', menuBar);
// 全局注册，之后可在其他组件中通过 this.$axios 发送数据

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import Cookies from 'js-cookie'
import {LoginBox} from '@/components/login/test'
// 引入封装好的js文件的路径
import getuserinfo from '@/utils/getuserinfo'
// 把全局js挂接到vue原型上
Vue.prototype.$getuserinfo = getuserinfo
import isLogin from '@/utils/isLogin'
Vue.prototype.$getToken = isLogin;
Vue.prototype.$Login = LoginBox.install;
Vue.prototype.$Cookie = Cookies;
// main.js


Vue.use(ElementUI);

new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})



