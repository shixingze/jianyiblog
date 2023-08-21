<template>
  <div class="footer-bar-div" @mouseenter="handleMouseenter" @mouseleave="handleMouseleave">
    <div class="footer-bar" v-show="show">
       <iframe frameborder="no" border="0" marginwidth="0" marginheight="0" width=700 height=86 src="//music.163.com/outchain/player?type=2&id=2048584480&auto=1&height=66">
       </iframe>
    </div>
    
  </div>
</template>

<script>
export default {
  data() {
    return {
      show: false     // 控制是否显示底部组件
    }
  },
  methods: {
    handleMouseenter() {
      this.show = true;   // 鼠标进入时显示底部组件
    },
    handleMouseleave() {
      this.show = false;   // 鼠标离开时隐藏底部组件
    }
  }
}
</script>

<style>
.footer-bar-div{
    position:fixed;
    left: 0px;
    top: 0px;
    height: 100%;
    width: 7px;
    background-color: rgb(153, 67, 239);
     box-shadow: 0 2px 4px rgba(0, 1, 1, 0.2); /* 水平偏移量 垂直偏移量 阴影模糊半径 颜色 */
}
.footer-bar {
  z-index: 88;
  position: fixed;
  bottom: 0;
  left: 0;
  width: 100%;
  
  background-color: #fff;
  border-top: 1px solid #ddd;
  justify-content: center;
  align-items: center;
}
</style>
 