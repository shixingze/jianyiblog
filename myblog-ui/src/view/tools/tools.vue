<template>
    <div id="bigdiv">
        <el-row :gutter="12">
  <el-col :span="8">
    <el-card shadow="always">
     bilibili视频下载
     <router-link  to="/tools/bili" class="nav-link nav-link-icon"
                >下载</router-link
              >
    </el-card>
  </el-col>
  <el-col :span="8">
    <el-card shadow="always">   
         图片base64转码
         <router-link  to="/tools/base64" class="nav-link nav-link-icon"
                >下载</router-link
              >
    </el-card>
  </el-col>
  <el-col :span="8">
    <el-card shadow="always">
            从不显示
            <router-link  to="/tools/bili" class="nav-link nav-link-icon"
                >下载</router-link
              >
    </el-card>
  </el-col>
</el-row>
    </div>
  </template>
  
  <script>
  export default {
    name: 'App',
   data() {
      return {
     
        
      };
    }
  };
  </script>
  
  <style scoped >
  #bigdiv{
   padding: 10% 10%;
   min-height: 100%;
 
  }
  </style>
  
  
  