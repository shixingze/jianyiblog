<template>
  <div style="margin-top: 82px">
    <div class="editor-set">
      <div id="top-container">
        <p>
          <a @click="goFrom">&lt;&lt; 返回上一页</a>
        </p>
      </div>
      <div class="bar-div">
        <Toolbar
          style="height: 100%; line-height: 100%"
          :editor="editor"
          :defaultConfig="toolbarConfig"
          :mode="mode"
        />
      </div>
    </div>
    <div id="content">
      <div class="editor-container">
        <div id="title-container">
          <input ref="blogTitle" placeholder="请输入标题" />
        </div>
        <div class="text">
          <Editor
            class="text-data"
            style="overflow-y: hidden"
            v-model="html"
            :defaultConfig="editorConfig"
            :mode="mode"
            @onCreated="onCreated"
          />
        </div>
      </div>
    </div>
    <div class="save-div">
      <div class="save-big">
        <div class="text-save-dev">
          <div class="right-dev-title">
            <span class="text-save-dev-name">封面上传</span>
            <!--不使用action 符号#   用http-request实现自定义上传  :http-request="httpRequest"  :on-change="handleChange"-->
            <el-upload
              class="upload-demo"
              action="https://jsonplaceholder.typicode.com/posts/"
  :on-preview="handlePreview"
  :on-remove="handleRemove"
  :file-list="fileList"
  list-type="picture"
              :on-change="handleChange"
             
              :http-request="httpRequest"
              ><!--覆盖默认上传-->
              <el-button size="small" type="primary">点击上传</el-button>
              <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
            </el-upload>
          </div>
          <div class="right-dev-title">
            <span class="text-save-dev-name">
              <span style="color: red; margin-right: 5px">*</span>文章标签</span
            >
            <div>
              <div style="float: left; margin: 0 10px">
                <el-button
                  v-for="child in checkCatelist"
                  :key="child"
                  size="mini"
                  >{{ child.categoryName }}</el-button
                >
              </div>
              <el-popover placement="right" width="500" trigger="click">
                <div>
                  <h6 style="text-align: center">标签</h6>
                  <el-input placeholder="请输入内容" v-model="input" clearable>
                  </el-input>
                  <ul class="bianqian-ul">
                    <li v-for="cate in firstCatelist" :key="cate">
                      <a @click="childCateByid(cate.categoryId)">{{
                        cate.categoryName
                      }}</a>
                    </li>
                  </ul>
                  <div class="bianqian-div">
                    <div>选中标签</div>
                    <div class="bianqian-child">
                      <el-button
                        size="mini"
                        class="child-btn"
                        @click="checkCate(child)"
                        v-for="child in childCatelist"
                        :key="child"
                        >{{ child.categoryName }}</el-button
                      >
                    </div>
                  </div>
                </div>
                <el-button slot="reference" size="mini">添加文章标签</el-button>
              </el-popover>
            </div>
          </div>
          <div style="padding: 1px 5px; width: 100%">
            <span class="text-save-dev-name"
              ><span style="color: red; margin-right: 5px">*</span
              >文章摘要</span
            >
            <div>
              <textarea class="blog-zhaiyao" ref="blogAbstract"></textarea>
            </div>
            <!-- <el-input
              ref="blogAbstract"
              type="textarea"
              :rows="2"
              placeholder="输入文章简要"
              v-model="textarea"
            >
            </el-input> -->
          </div>
          <!-- <div class="right-dev-title">
            <button class="buttion" @click="add()">发布文章</button>
          </div> -->
        </div>
      </div>
      <div class="bottom-btn">
        <div class="bottom-btn-div">
          <button class="buttion" @click="add()">发布文章</button>
          <button class="buttion-hui">定时发布</button>
          <button class="buttion-hui">保存到草稿</button>
        </div>
      </div>
    </div>
  </div>
</template>
 
<script>
import Vue from "vue";
import { Editor, Toolbar } from "@wangeditor/editor-for-vue";
import { getChildCate,getfirstCate,addBlog ,imgupload} from "../api/category";

export default Vue.extend({
  components: { Editor, Toolbar },
  data() {
    return {
      editor: null,
      toolbarConfig: {},
      editorConfig: { placeholder: "请输入内容..." },
      mode: "default",
      imageUrl: "",
      saveUrl: "",
      tempUrl: "",
      //一级分类
      firstCatelist:[],
      //子集
      childCatelist:[],
      //选中的分类
      checkCatelist:[]
    };
  },
     //在这里调用ajax请求方法
     created(){
      this.firstCate();
    },
  methods: {
    //上一路由
    goFrom(){
     this.$router.go(-1);
    },
    //将上传图片的原路径赋值给临时路径
    handleChange(file, fileList) {
      this.tempUrl = URL.createObjectURL(file.raw);
    },
    //添加标签
    checkCate(item){
      // 返回值等于-1 说明数组Arr中不存在id为date的对象
	     if( this.checkCatelist.findIndex(cate => cate.categoryId=== item.categoryId)!==-1){
        this.$notify({
          title: '警告',
          message: '已选中该标签',
          type: 'warning'
        });
	     }else{
        this.checkCatelist.push(item);
       }
    },
    //实现图片上传功能
    httpRequest(item) {
      //验证图片格式大小信息
      const isJPG =
        item.file.type == "image/jpeg" || item.file.type == "image/png";
      const isLt2M = item.file.size / 1024 / 1024 < 2;
      if (!isJPG) {
        this.$message.error("上传图片只能是 JPG 或 PNG 格式!");
      }
      if (!isLt2M) {
        this.$message.error("上传图片大小不能超过 2MB!");
      }
      //图片格式大小信息没问题 执行上传图片的方法
      if (isJPG && isLt2M == true) {
        // post上传图片
        let App = this;
        //定义FormData对象 存储文件
        let mf = new FormData();
        //将图片文件放入mf
        mf.append("file", item.file);
//获取子集标签
      imgupload({
        mf
      }).then(
        async (res) => {
          if (res.code === 500) {
            this.$notify.error({
                title: "错误",
                message: res.msg,
              });
          } else if (res.code === 200) {
              //将临时文件路径赋值给显示图片路径（前端显示的图片）
              App.imageUrl =
                "/api/" + res.data;
              App.saveUrl = res.data;
              //将后台传来的数据库图片路径赋值给car对象的图片路径
              App.car.carImg = res.data;
          }
        }
      );
      }
      
    },
    onCreated(editor) {
      this.editor = Object.seal(editor); // 一定要用 Object.seal() ，否则会报错
    },
    //获取一级标签
    firstCate() {
      getfirstCate().then(
        async (res) => {
          if (res.code === 500) {
            this.$notify.error({
                title: "错误",
                message: res.msg,
              });
          } else if (res.code === 200) {
            this.firstCatelist = res.data;
          }
        }
      );
    },
    //获取子集标签
    childCateByid(id) {
      getChildCate({
        categoryId:id
      }).then(
        async (res) => {
          if (res.code === 500) {
            this.$notify.error({
                title: "错误",
                message: res.msg,
              });
          } else if (res.code === 200) {
            this.childCatelist = res.data;
          }
        }
      );
    },
    add() {
      addBlog({
        blogTitle: this.$refs.blogTitle.value,
          blogAbstract: this.$refs.blogAbstract.value,
          blogContent: this.editor.getHtml(),
          blogCover: this.saveUrl,
          checkCateList: this.checkCatelist,
      }).then(
        async (res) => {
          if (res.code === 500) {
            this.$notify.error({
                title: "错误",
                message: res.msg,
              });
          } else if (res.code === 200) {
            this.$notify({
              title: "成功",
              message: res.msg,
              type: "success",
            });
          }
        }
      )
    },
 
    
  },
  mounted() {
 

// 模拟 ajax 请求，异步渲染编辑器
    setTimeout(() => {
      this.html = "<p>请开始写</p>";
    }, 1500);
  },
  beforeDestroy() {
    const editor = this.editor;
    if (editor == null) return;
    editor.destroy(); // 组件销毁时，及时销毁编辑器
  },
});

</script>

<style scoped>
body {
  background-color: rgba(245, 245, 245, 0.863);
}
#top-container {
  width: 100%;
  border-bottom: 1px solid #e8e8e8;
  padding-left: 30px;
}
#top-container p {
  margin: auto;
  height: 40px;
  line-height: 40px;
}
#content {
  height: calc(100% - 40px);
  background-color: rgba(245, 245, 245, 0.863);
  overflow-y: auto;
  position: relative;
}

.editor-container {
  width: 850px;
  min-height: 700px;
  margin: 100px auto 0px auto;
  background-color: #fff;
  padding: 20px 50px 50px 50px;
  border: 1px solid #e8e8e8;
  box-shadow: 0 2px 10px rgb(0 0 0 / 12%);
}
.text-data{
  min-height: 700px;
}

/* 设置代码块向下 */
.w-e-bar-bottom .w-e-select-list {
    bottom: 0;
    margin-bottom: 40px;
    margin-top: 0;
    bottom: inherit;
}


#title-container {
  padding: 0 0;
  border-bottom: 1px solid #e8e8e8;
}

#title-container input {
  word-break: break-all;
  font-size: 30px;
  border: 0;
  outline: none;
  width: 100%;
  line-height: 1;
}

/** 
文件
*/
.avatar-uploader {
  margin-top: 20px;
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
  width: 100px;
  height: 100px;
}

.avatar-uploader:hover {
  border-color: #409eff;
}

.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  line-height: 178px;
  text-align: center;
}

.avatar {
  width: 178px;
  height: 178px;
  display: flex;
}

.w-e-text-container .w-e-scroll {
  background-color: #fff;
}
#w-e-textarea-1 {
  min-height: 900px;
  font-family: "宋体";
  width: 100%;
  font-size: 20px;
}
/* .w-e-toolbar{
position: fixed;
top: 200px;
} */
.editor-set {
  width: 100%;
  background-color: #fff;
  position: fixed;
  top: 62px;
  z-index: 100;
  margin: 0 auto;
  border-bottom: 1px solid #e8e8e8;
}
.editor-set .bar-div {
  width: 1400px;
  margin: 0 auto;
}

.text-save-dev {
  width: 850px;
  /* margin: 100px auto 150px auto; */

  padding: 20px 50px 50px 50px;
  border: 1px solid #e8e8e8;
  -webkit-box-shadow: 0 2px 10px rgb(0 0 0 / 12%);
  box-shadow: 0 2px 10px rgb(0 0 0 / 12%);
}
.save-big {
  background-color: #fff;
  width: 850px;
  font-size: 25px;
  margin: 0 auto;
  height: 500px;
}
.text-save-dev-name {
  font-size: 14px;
  color: #606266;
  line-height: 40px;
  padding: 0 12px 0 0;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
}
.right-dev-title {
  width: 100%;
  padding: 0px 5px;
  margin-top: 5px;
}
.right-dev-title textarea {
  border: 0;
  border-bottom: 1px solid #ccc;
  resize: none;
  outline: none;
}
.avatar-uploader {
  width: 100px;
  height: 50px;
}
.avatar-uploader-icon {
  width: 100px;
  height: 50px;
  line-height: 49px;
}

.buttion span {
  font-size: 10px;
  line-height: 20px;
  margin-top: 7px;
}
.bianqian-ul {
  width: 40%;
  list-style: none;
  text-align: left;
  padding: 5px 0;
  margin-top: 5px;
  float: left;
  height: 250px;
  overflow: auto;
}
.bianqian-child {
  padding: 5px 0;
  margin-top: 5px;
  height: 250px;
  overflow: auto;
}
.bianqian-ul li {
  margin-top: 10px;
  cursor: pointer;
}
.bianqian-ul::-webkit-scrollbar {
  /*滚动条整体样式*/

  width: 5px; /*高宽分别对应横竖滚动条的尺寸*/

  height: 1px;
}

.bianqian-ul::-webkit-scrollbar-thumb {
  /*滚动条里面小方块*/

  border-radius: 10px;

  -webkit-box-shadow: inset 0 0 5px rgba(232, 176, 34, 0.2);

  background: darkgray;
}

.bianqian-ul::-webkit-scrollbar-track {
  /*滚动条里面轨道*/

  -webkit-box-shadow: inset 0 0 5px #fff;

  border-radius: 10px;

  background: #ededed;
}

.bianqian-div {
  margin: 5px 5px 5px 10px;
  float: right;
  height: 100%;
  width: 50%;
}
.child-btn {
  font-size: 10px;
  margin: 2px;
  padding: 2px;
}
.save-div {
  width: 100%;
  background-color: rgba(245, 245, 245, 0.863);
}

.blog-zhaiyao {
  width: 80%;
  min-height: 30px;
  padding: 8px 12px;
    color: #252933;
    outline: none;
    min-height: 64px;
    box-sizing: border-box;
    line-height: 22px;
    font-size: 14px;
    resize: both;
    background: #f2f3f5;
    border: 1px solid #f2f3f5;
    border-radius: 4px;
}
.bottom-btn {
  width: 100%;
  height: 70px;
  /* background-color: purple; */
  background-color: #fff;
  position: fixed;
  bottom: 0px;
  left: 0px;
  display: flex;
  align-items: center;
  justify-content: center;
}
.bottom-btn-div {
  width: 60%;
}

.buttion {
  margin-left: 10px;
  width: 100px;
  height: 40px;
  border-radius: 20px;
  border: 0;
  background-color: #fc5531;
  color: #fff;
  transition: width 1s;
  -webkit-transition: width 2s; /* Safari */
  float: right;
}

.buttion:hover {
  background-color: #d23d2c;
}
.buttion-hui {
  width: 100px;
  height: 40px;
  border-radius: 20px;
  float: right;
  border: 1px solid #ccc;
  color: #ccc;
  margin-left: 10px;
}
.buttion-hui:hover {
  border: 1px solid rgb(133, 132, 132);
  color: rgb(133, 132, 132);
}
.bottom-btn button {
}



@media (max-width:960px){
  .editor-set,.editor-set .bar-div{
    width: 100%;
    height: 100px;
  }
  #title-container input{
     word-break: break-all;
    font-size: 2rem;
    border: 0;
    outline: none;
    width: 100%;
    line-height: 1;
  }
   .editor-container{
    width: 90%;
    min-height: 700px;
    margin: 180px auto 0px auto;
    background-color: #fff;
    padding: 10px 20px 20px 10px;
    border: 1px solid #e8e8e8;
    -webkit-box-shadow: 0 2px 10px rgb(0 0 0 / 12%);
    box-shadow: 0 2px 10px rgb(0 0 0 / 12%);
   }
.save-big[data-v-18686cfd] {
    background-color: #fff;
    width: 90%;
    font-size: 25px;
    margin: 0 auto;
    height: 450px;
}
   .text-save-dev{
    width: 100%;
    /* margin: 100px auto 150px auto; */
padding: 10px 20px 20px 10px;
    border: 1px solid #e8e8e8;
    -webkit-box-shadow: 0 2px 10px rgb(0 0 0 / 12%);
    box-shadow: 0 2px 10px rgb(0 0 0 / 12%);
}
.bottom-btn {
    width: 100%;
    height: 70px;
    /* background-color: purple; */
    background-color: #fff;
    position: fixed;
    bottom: 0px;
    left: 0px;
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-align: center;
    -ms-flex-align: center;
    align-items: center;
    -webkit-box-pack: center;
    -ms-flex-pack: center;
    justify-content: center;
}
.bottom-btn-div[data-v-18686cfd] {
    width: 90%;
}
}
</style>


