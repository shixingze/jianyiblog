import Vue from 'vue'
import Router from 'vue-router'
// import HelloWorld from '@/components/HelloWorld'
import index from '../view/index'
import Cookies from 'js-cookie'
import belogIndex from '@/view/belog/belogIndex'
import editor from '@/components/editor'
import commData from '@/components/commData'
import dengji from '@/view/dengji/index'
import belogshow from '@/view/belog/belogshow'
import pinlun from '@/view/belog/pinglun'
import dengjilist from '@/view/dengji/dengjilist'
import dengjiok from '@/view/dengji/success'
import { name } from 'file-loader'
import fromDao from '@/components/daohangmulu/fromDao'
import userdata from '@/view/user/userdata'
import text from '@/view/text'
import download from '@/view/tools/bili/download'
import tools from '@/view/tools/tools'
import base64 from '@/view/tools/base64/base64'
Vue.use(Router)

const router = new Router({
  routes: [
    {
      path: '/',
      name: 'index',
      component: index
    },
    {
      path: '/belog',
      name: 'belog',
      component: belogIndex
    },
    {
      path: '/editor',
      name: 'editor',
      component: editor,
      meta: { requiresAuth: true }
    },
    {
      path: '/fromDao',
      name: 'fromDao',
      component: fromDao
        },
    {
      path: '/commData',
      name: 'commData',
      component: commData
    },
    {
      path: '/dengji',
      name: 'dengji',
      component: dengji
    },
    {
      path: '/belog/show',
      name: 'show',
      component: belogshow
    },
    {
      path: '/belog/pinlun',
      name: 'pinlun',
      component: pinlun
    },
    {
     path:"/jilist",
     name:"jilist",
     component:dengjilist
    },
    {
      path:"dengjiok",
      name:"dengjiok",
      component:dengjiok
    },
    {
      path:"/userdata",
      name:"userdata",
      component:userdata
    },
    {
      path:"/text",
      name:"text",
      component:text
    },
    {
      path:"/tools/bili",
      name:"download",
      component:download
    },
    {
      path:"/tools",
      name:"tools",
      component:tools
    },
    {
      path:"/tools/base64",
      name:"base64",
      component:base64
    }
    
  ]
})
// //挂载路由
// router.beforeEach((to, from, next) => {
  
//   if(to.path === "/editor"){
//     alert("editor")
//   }
//   //to访问路径
//   //from 从哪而来
//   return next();
// })
router.afterEach((to, from, next) => {
 
  if (to.name === '/') {
    // 在指定路由切换时调用组件方法
    const componentInstance = router.app.$children[0]; // 假设你的组件是第一个子组件
    componentInstance.setBar();
  }
 // 存储样式信息到本地存储
 localStorage.setItem('navBarStyle', to.path === '/about' ? 'blue' : 'default');
  if (to.matched.some(record => record.meta.requiresAuth)) {
    // this route requires auth, check if logged in
    // if not, redirect to login page.
    next()
  } else {
    next() // 确保一定要调用 next()
  }
  
})

export default router

