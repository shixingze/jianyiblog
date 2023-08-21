<template>
    <div id="userdata-div">
        <div class="div-all-data">
      <div class="left-div">
        <div class="left-top"></div>
      </div>
      <div class="right-div"></div>
        </div>
    </div>
  </template>
  
  <script>

  export default {
    name: 'userdata',
   data() {
      return {
        
      };
    }
  };
  </script>
  
 <style scoped>
 #userdata-div{
    width: 100%;
    height: 500px;
    padding: 0 5cm;
    margin-top: 100px;
 }
 .div-all-data{
    width: 100%;
    height: 500px;
  
 }
 .left-div{
    width: 68%;
    height: 100%;
    float: left;
    background-color: antiquewhite;
 }
 .left-top{
    width: 100%;
    height: 10rem;
    background-color: #fff;
    border-radius: 2px;
    padding: 2.5rem;
    box-shadow: 0 1px 2px 0 rgb(0 0 0 / 5%);
 }
 .right-div{
    width: 30%;
    height: 100%;
    float: right;
    background-color: rebeccapurple;
 }
 </style>
  
  