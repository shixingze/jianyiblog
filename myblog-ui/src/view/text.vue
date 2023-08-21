<template>
    <div id="app">
      <div class="list" v-for="(data,index) in datas" :key="index">
          {{data}}
      </div>
  
    </div>
  </template>
  
  <script>
  export default {
    name: 'app',
    data() {
      return {
        datas:[],
        testdatas:['1','2','3','4','5'],  //初始加载测试数据
        count:5,  //默认加载数量
        isAchiveBottom: false //滚动条是否到底部标志
      }
    },
    created() {
      //使用window.onscroll = function(){}this指向出现问题
      //故应该使用箭头函数，因为箭头函数无this，会从上一级找，故会找到vue实例的this
      window.onscroll = () => {
        //变量scrollTop是滚动条滚动时，距离顶部的距离
        var scrollTop =
          document.documentElement.scrollTop || document.body.scrollTop;
        //变量windowHeight是可视区的高度
        var windowHeight =
          document.documentElement.clientHeight || document.body.clientHeight;
        //变量scrollHeight是滚动条的总高度
        var scrollHeight =
          document.documentElement.scrollHeight || document.body.scrollHeight;
        //滚动条到底部的条件(距底部20px时触发加载)
        if (
          scrollTop + windowHeight >= scrollHeight - 20 &&
          !this.isAchiveBottom &&
          !this.noMore
        ) {
          // console.log(
          //   "距顶部" +
          //     scrollTop +
          //     "可视区高度" +
          //     windowHeight +
          //     "滚动条总高度" +
          //     scrollHeight
          // );
          this.isAchiveBottom = true;
          //延时触发数据加载
          setTimeout(() => {
            //后端需要进行分页，然后前端从后端拿来实现滚动加载
            //这里利用数组push来模拟从后端拿到的数据
            this.datas.push("test");
            this.isAchiveBottom = false;
          }, 500);
        }
      };
    },
    beforeMount() {
      // 在页面挂载前就发起请求
      this.getInitial();
    },
    methods: {
      getInitial(){
        for (var i = 0; i < this.count; i++) {
          this.datas.push(this.testdatas[i]);
        }
      }
    },
  }
  </script>
  
  <style scoped>
  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
  }
  .list{
    background-color: #d2d2d2;
    border-radius: 3px;
    width: 50%;
    height: 150px;
    line-height: 150px;
    margin: 0 auto 20px auto;
  }
  
  </style>
  