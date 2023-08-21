<template>
  <div id="app">
    <main class="head">
      <header visible="visible" data-fetch-key="0" class="main-header main-header visible">
        <Menunavbar :paths="currentRoute" />
      </header>
    
    </main>
  
      <router-view/> 
   
    <footer-bar/>
  </div>
</template>

<script>
import { onMounted } from 'vue';
import FooterBar from './components/FooterBar.vue';
import Menunavbar from './components/menunavbar.vue'
export default {
  name: 'App',
  components: { Menunavbar, FooterBar },
 data() {
    return {
   
      
    };
  },
 computed: {
    currentRoute() {
      return this.$route.path; // 获取当前路由地址
    },
  },
};
</script>

<style scoped >
@import "@wangeditor/editor/dist/css/style.css";
body{
  min-width:0px;
}

.head{
    position: fixed;
    top: 0;
    left: 0;
    height: 5rem;
    z-index: 999;
}
header{
  display: block;
}
.main-header.visible {
    transform: translateZ(0);
}
.main-header {
    position: fixed;
    top: 0;
    left: 0;
    right: 0;
    transition: all .2s;
    transform: translate3d(0,-100%,0);
}
.main-header {
    background: var(--juejin-navigation);
    /* border-bottom: 1px solid #f1f1f1; */
    color: #909090;
    height: 5rem;
    z-index: 250;
}

</style>


