<template>
    <div id="big">
     
     <div class="inputdiv">
       
<el-upload
  list-type="picture"
   action=''
   accept=".jpg, .png"
   :limit="1"
   :auto-upload="false"
   :file-list="fileList"
   :on-change="getFile"
   :on-preview="handlePictureCardPreview"
   :on-remove="handleUploadRemove"
   >
    <el-button class="upload-btn" size="small" type="primary" @click="uploadimg">选择图片上传</el-button>
    <div slot="tip" class="el-upload__tip">只能上传一张jpg/png文件</div>
</el-upload>
           
        </div>
       <div class="text">注意:本网站功能只适用于学习用途</div>
     
       
     
    </div>
  </template>
  
  <script>
  function toUtf8(str) {    
    var out, i, len, c;    
    out = "";    
    len = str.length;    
    for(i = 0; i < len; i++) {    
        c = str.charCodeAt(i);    
        if ((c >= 0x0001) && (c <= 0x007F)) {    
            out += str.charAt(i);    
        } else if (c > 0x07FF) {    
            out += String.fromCharCode(0xE0 | ((c >> 12) & 0x0F));    
            out += String.fromCharCode(0x80 | ((c >>  6) & 0x3F));    
            out += String.fromCharCode(0x80 | ((c >>  0) & 0x3F));    
        } else {    
            out += String.fromCharCode(0xC0 | ((c >>  6) & 0x1F));    
            out += String.fromCharCode(0x80 | ((c >>  0) & 0x3F));    
        }    
    }    
    return out;    
}

import { down } from "../../../api/bili";
  export default {
    name: 'app',
    data() {
      return {
        input: ''
      }
    },
    

    methods: {
      
         /**
	 * 字节流转换成文件下载
	 * inputFileName：文件名
	 * data：后台取得数据
	 */
	fileConversion(inputFileName,data){
		let str = data.headers['content-disposition'];
		// 文件名
		let fileName = inputFileName;
		let blob = new Blob([data.data], {
			type:
			"application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
		});
		if (window.navigator.msSaveOrOpenBlob) {
			navigator.msSaveBlob(blob);
		} else {
			let elink = document.createElement("a");
			elink.download = fileName;
			elink.style.display = "none";
			elink.href = URL.createObjectURL(blob);
			document.body.appendChild(elink);
			elink.click();
			document.body.removeChild(elink);
		}
	},

      download(){
        if(this.input =="" || this.input ==null){
            alert("请输入视频地址")
        }
        down({ URL: this.input }).then(async (res) => {
            console.log(res)
            console.log(res.headers)
            let s = toUtf8(res.headers["content-disposition"])
            var name =  s.split(";")[1].split("=")[1];
            name = decodeURIComponent(name);
            if(name == null || name.length ==0){
             name = "文件名为获取到";
            }
          
            //浏览器兼容，Google和火狐支持a标签的download，IE不支持
            if (window.navigator && window.navigator.msSaveBlob) {
            //IE浏览器、微软浏览器
            /* 经过测试，微软浏览器Microsoft Edge下载文件时必须要重命名文件才可以打开，
              IE可不重命名，以防万一，所以都写上比较好 */
            window.navigator.msSaveBlob(res.data, '文件.mp4');
          } else {
            //其他浏览器
            let link = document.createElement('a'); // 创建a标签
            link.style.display = 'none';
            let objectUrl = URL.createObjectURL(res.data);
            
            link.download = name+".mp4"; 
            link.href = objectUrl;
            link.click();
            URL.revokeObjectURL(objectUrl);
          }
      });
      }
    },

  }
  </script>
  
  <style scoped>
  #big{
    display: flex;
    min-height: 100vh;
  }
 .inputdiv{
    width: 50%;
    height: 20rem;
    margin: 10rem auto;
    box-shadow: 0 10px 16px 0 rgb(0 0 0 / 6%), 0 6px 20px 0 rgb(0 0 0 / 10%) !important
 }
 .inputd{
  padding: 2rem 10px;
 }
 .btn-div{
    width: 10%;
    margin: 0 auto;
    padding: 1rem 1rem;
 }
 .text{
  font-size: 2rem;
  color: red;
  width: 50%;
  margin: 0 auto;
 }
 .upload-btn{
    border: 2px dashed #ccc;
    width: 80%;
    border-radius: 5px;
    background-color: white;
    margin: 50px 0;
    text-align: center;
    color: #666;
 }
  </style>
  