<template>
    <span style="font-size: 13px">{{ content }}</span>
  </template>
  
  <script>
  export default {
    data () {
      return {
        content: '',
      }
    },
    props: {
      date: {
        type: String,
        default: new Date().toString()
      },
      time: {
        type: Number,
        default: 0,
        dateTimeStamp: ''
      }
    },
    mounted() {
      this.diffTime()
    },
    methods: {
      diffTime () {
          this.dateTimeStamp = this.time
          if (!this.dateTimeStamp) {
            if(!this.date) {
              return '刚刚'
            }
            this.dateTimeStamp = new Date(this.date).getTime()
          }
          var minute = 1000 * 60;
          var hour = minute * 60;
          var day = hour * 24;
          var halfamonth = day * 15;
          var month = day * 30;
  
          var now = new Date().getTime();
          var diffValue = now - this.dateTimeStamp;
  
          var monthC =diffValue/month;
          var weekC =diffValue/(7*day);
          var dayC =diffValue/day;
          var hourC =diffValue/hour;
          var minC =diffValue/minute;
          if (parseInt(monthC) >=1) {
            this.content = parseInt(monthC) + '个月前'
          } else if (parseInt(dayC) > 1) {
            this.content = parseInt(dayC) + '天前'
          } else if (parseInt(dayC) === 1) {
            this.content = '昨天'
          } else if(parseInt(hourC)>=1){
            this.content = parseInt(hourC) +"小时前";
          } else if(parseInt(minC)>=1){
            this.content = parseInt(minC) +"分钟前";
          } else {
            this.content = "刚刚";
          }
      }
    }
  }
  </script>
  
  <style>
  
  </style>
  
  