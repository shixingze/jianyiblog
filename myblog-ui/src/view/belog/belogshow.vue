<template>
  <div id="bigdiv" style="max-width: 1140px">
    <div class="view column-view">
      <div class="left-area left-area">
        <div class="left">
          <h1 class="article-title">
            {{ this.blog.blogTitle }}
          </h1>

          <div class="userdata">
            <div class="userdata-img">
              <img
                :src="'/api/' + this.userData.avatar"
                width="100%"
                height="100%"
                alt=""
              />
            </div>
            <div class="userdata-right">
              <div>
                <span class="right-name">{{ this.userData.nickName }}</span>
              </div>
              <div class="right-meta-box">
                <span>{{ this.blog.createdTime }}</span
                ><span>&nbsp;·&nbsp;</span>阅读<span>{{
                  this.blog.blogBrowsing
                }}</span>
              </div>
            </div>
          </div>
          <div class="blogdata">
            <Editor
              class="text-data"
              v-model="html"
              :defaultConfig="editorConfig"
              :mode="mode"
              @onCreated="onCreated"
            />
          </div>
          <!-- 底部代码 -->
          <div class="fenzubiaoqian">
            <div class="container">
              <div class="row">
                <div class="col-2">分类：</div>
                
                  <span class="col-1 badge badge-primary"
                  style="margin: 0 5px"
                  size="big"
                  v-for="cate in blog.categoryList"
                  :key="cate.categoryId"
                >
                  {{ cate.categoryName }}
                </span>
                <div class="col"></div>
              </div>
              <div class="row">
                <div class="col">标签：</div>
                
              </div>
            </div>
<!-- 
            <div class="fenlei">
              <span class="fenzubiaoqian-title">分类:</span>
              <div class="biaoqian-left">
                <el-tag
                  style="margin: 0 5px"
                  size="big"
                  v-for="cate in blog.categoryList"
                  :key="cate.categoryId"
                >
                  {{ cate.categoryName }}
                </el-tag>
              </div>
            </div>

            <div class="biaoqian">
              <span class="">标签:</span>
            </div> -->
          </div>
        </div>
        <div class="pinlunqu">
          <el-row class="pl-header">
            <h3>相关文章</h3>
          </el-row>
        </div>
      </div>
      <!-- 右侧代码 -->

      <!-- 右侧代码 -->
      <div class="rightsidebar" :class="whether ? 'right' : 'right'">
        <div class="user-card">
          <img class="card-img" :src="'/api/' + this.userData.avatar" alt="" />
          <div class="userinfo">
            <span>{{ this.userData.nickName }}</span>
            <div>{{ this.userData.email }}</div>
          </div>
          <div class="show-order-data">
            <el-row gutter="20">
              <el-col :span="2" />
              <el-col :span="18">
                <div class="show-order-data-div">
                  <span class="userinfo-title">博文数量</span
                  ><span class="userinfo-data">{{
                    this.userData.blogAllnum
                  }}</span>
                </div>
              </el-col>
            </el-row>
            <el-row gutter="20">
              <el-col :span="2" />
              <el-col :span="18">
                <div class="show-order-data-div">
                  <span class="userinfo-title">总访问量</span
                  ><span class="userinfo-data">{{
                    this.userData.lookAllnum
                  }}</span>
                </div>
              </el-col>
            </el-row>
            <el-row gutter="20">
              <el-col :span="2" />
              <el-col :span="18">
                <div class="show-order-data-div">
                  <span class="userinfo-title">获得点赞</span
                  ><span class="userinfo-data">{{
                    this.userData.startAllnum
                  }}</span>
                </div>
              </el-col>
            </el-row>
          </div>
          <div class="card-btn-div">
            <el-row :gutter="20">
              <el-col :span="12"><button class="card-btn">关注</button></el-col>
              <el-col :span="12"><button class="card-btn">私信</button></el-col>
            </el-row>
            <!-- <button class="card-btn">关注</button>
          <button class="card-btn">私信</button> -->
          </div>
        </div>
        <div id="menuFlag" :class="whether ? 'isFixed' : 'blogdao'">
          <div class="blogdao-title">目录</div>
          <!-- 标题目录 -->
          <div class="dao-div">
            <ul id="header-container"></ul>
          </div>
        </div>
      </div>
    </div>

    <!-- 左悬浮 -->
    <div class="left-start-div">
      <ul class="btn-ui">
       
        <li class="panel-btn" id="dianzanb"   v-bind:class="[
              this.chheck.checkStart == 'startOK'
                ? 'panel-btn2'
                : '',
            ]" :badge="this.blogNum.blogLike">
          <button
            v-bind:class="[
              this.chheck.checkStart == 'startOK'
                ? 'buttoncheck'
                : 'btn-ui-btn',
            ]"
            id="dianzanbtn"
            @click="dianzan"
          >
            <i class="iconfont icon-dianzan"></i>
          </button>
        </li>
        <li class="panel-btn" :badge="this.blogNum.blogComments">
          <button class="btn-ui-btn" @click="drawer = true" type="primary">
            <i class="iconfont icon-pinglun"></i>
          </button>
        </li>
        <li class="panel-btnnonum">
          <button class="btn-ui-btn">
            <i class="iconfont icon-shoucangxuanzhong"></i>
          </button>
        </li>
        <li class="panel-btnnonum">
          <button class="btn-ui-btn">
            <i class="iconfont icon-fenxiang"></i>
          </button>
        </li>
        <li class="panel-btnnonum">
          <button class="btn-ui-btn" @click="initDao">
            <i class="iconfont icon-dashang"></i>
          </button>
        </li>
        <li class="panel-btnnonum"><button class="btn-ui-btn">12</button></li>
      </ul>
    </div>
    <el-drawer
      title="评论"
      :visible.sync="drawer"
      :direction="direction"
      :before-close="handleClose"
      size="40%"
    >
      <div class="pl-data">
        <CommData
          :v-if="this.commentCode == 200"
          :comments="commonTreeData"
          :blogId="blog.blogId"
          @my-event="addComment"
        ></CommData>
      </div>
    </el-drawer>
  </div>
</template>

<script>
import Vue from "vue";
// import LeftMenuBar from '../../components/leftMenuBar.vue'
import { Editor, Toolbar } from "@wangeditor/editor-for-vue";

import CommData from "../../components/commData.vue";
import initBlogDaoHang from "../../components/daohangmulu/fromDao.vue";
import { getOneBlog, getBasicBy, getOneblogNum } from "../../api/blogapi";
import { getCommtree } from "../../api/common";
import { startCheck } from "../../api/start";
export default Vue.extend({
  components: { Editor, Toolbar, CommData, initBlogDaoHang },
  data() {
    return {
      textarea: "",
      editor: null,
      toolbarConfig: {},
      editorConfig: {
        placeholder: "请输入内容...",
        readOnly: true,
        scroll: true,
      },
      mode: "default", // or 'simple'
      blog: {},
      whether: "",
      //评论开关
      drawer: false,
      direction: "rtl",
      name: "我是传递过来的数据",
      commonTreeData: [],
      commentCode: "",
      blogNum: {},
      chheck: {
        checkStart: "",
      },
      userData: {},
      isHaveToken: false,
    };
  },

  mounted() {
    window.addEventListener("scroll", this.handleScroll);
  },
  beforeDestroy() {
    const editor = this.editor;
    if (editor == null) return;
    editor.destroy(); // 组件销毁时，及时销毁编辑器
  },

  //在这里调用ajax请求方法
  created() {
    var id = this.$route.query.blogId;
    this.getOne(id);
    this.getOneNum(id);
    this.commonTree(id);
    this.isHaveTokenStatus();
  },
  methods: {
    handFocus() {
      alert("点击了");
    },

    // 是否存在token
    isHaveTokenStatus() {
      if (this.$getToken()) {
        this.isHaveToken = true;
      } else {
        this.isHaveToken = false;
      }
    },
    onCreated(editor) {
      this.editor = Object.seal(editor); // 一定要用 Object.seal() ，否则会报错
      setTimeout(() => {
        this.initDao();
      }, 500);
    },
    getOne(blogId) {
      getOneBlog({ blogId: blogId }).then(async (res) => {
        if (res.code === 500) {
          this.$notify.error({
            title: "错误",
            message: res.msg,
          });
        } else if (res.code === 200) {
          this.blog = res.data;
          this.html = res.data.blogContent;
          this.getUserData(res.data.createdBy);
        }
      });
    },
    getOneNum(blogId) {
      getOneblogNum({ blogId: blogId }).then(async (res) => {
        if (res.code === 500) {
          this.$notify.error({
            title: "错误",
            message: res.msg,
          });
        } else if (res.code === 200) {
          this.blogNum = res.data;
          if (res.data.checkStart === "startOK") {
            this.chheck.checkStart = "startOK";
          }
        }
      });
    },
    commonTree(blogId) {
      getCommtree(blogId).then(async (res) => {
        if (res.code === 500) {
          this.$notify.error({
            title: "错误",
            message: res.msg,
          });
        } else if (res.code === 200) {
          this.commonTreeData = res.data;
          this.commentCode = res.code;
          //       console.log(this.commonTreeData);
        }
      });
    },

    //获取基本作者信息
    getUserData(userName) {
      getBasicBy({ username: userName }).then(async (res) => {
        if (res.code === 500) {
          this.$notify.error({
            title: "错误",
            message: res.msg,
          });
        } else if (res.code === 200) {
          this.userData = res.data;
        }
      });
    },
    //点赞方法
    dianzan() {
      var dzbtn = document.getElementById("dianzanbtn");
      var dianzanb = document.getElementById("dianzanb");
      if (this.$getToken()) {
        // alert("有token")
        startCheck({ blogId: this.blog.blogId }).then(async (res) => {
          if (res.code === 500) {
            this.$notify.error({
              title: "错误",
              message: res.msg,
            });
          } else if (res.code === 200) {
            if (res.data === "startNO") {
              // alert("取消点赞");
              dzbtn.className = "btn-ui-btn";
              dianzanb.classList.remove("panel-btn2")

            } else if (res.data === "startOK") {
              // alert("点赞点赞");
              dzbtn.className = "buttoncheck";
               dianzanb.classList.add("panel-btn2")
            }
            //更新数值
            this.getOneNum(this.blog.blogId);
          }
        });
      } else {
        this.$Login();
      }
    },
    //收藏
    收藏() {
      if (this.$getToken()) {
        alert("有token");
      } else {
        alert(this.$getToken());
        this.$Login();
      }
    },
    //滚动顶部固定
    handleScroll() {
      //计算滚动条位置
      var scrollTop =
        window.pageYOffset ||
        document.documentElement.scrollTop ||
        document.body.scrollTop;
      //计算绑定div位置
      var offsetTop = document.querySelector("#menuFlag").offsetTop;

      //进行比较设置位置fixed
      this.whether = scrollTop + 10 > offsetTop;
      if (this.whether) {
        this.whether = scrollTop > offsetTop + 100;
      }
    },

    //定位方法
    onTouch(id) {
      const sixteen = document.getElementById(id);
      // 本案例默认滚动元素是　html ，你可以根据你需要的滚动元素进行设置。
      document.documentElement.scrollTo({
        top: sixteen.offsetTop + 40,
        behavior: "smooth", // 让滚动更丝滑
      });
    },
    initDao() {
      // 标题 DOM 容器
      this.onChange(this.editor);
    },
    onChange(editor) {
      const headerContainer = document.getElementById("header-container");
      const headers = editor.getElemsByTypePrefix("header");
      headerContainer.innerHTML = headers
        .map((header) => {
          const text = E.SlateNode.string(header);

          const { id, type } = header;
          return `<li id="${id}" type="${type}">${text}</li>`;
        })
        .join("");

      headerContainer.addEventListener("mousedown", (event) => {
        if (event.target.tagName !== "LI") return;
        event.preventDefault();
        const id = event.target.id;
        //滚动到指定id
        this.onTouch(id);
      });
    },
  },
});
</script>
// .dao-div ul li {
//     height: 40px;
//     padding: 5px;
//     color: inherit;
//     border-radius: 5px;
//     line-height: 30px;
//     display: inline-block;
//     white-space: nowrap;
//     width: 100%;
//     overflow: hidden;
//     text-overflow: ellipsis;
// }
<style   >
.icon {
  width: 2em;
  height: 1em;
  vertical-align: -0.15em;
  fill: currentColor;
  overflow: hidden;
}
.isFixed {
  position: fixed;
  top: 6.766999999999999rem;
  width: inherit;
  transition: top 0.2s;
  margin: 10px 0;
  padding: 10px 20px;
  min-height: 50px;
  max-height: 500px;
  background-color: rgb(255, 255, 255);
}

body {
  /* background-color: rgba(204, 204, 204, 0.242); */
}
#category li a:before {
  /* 添加一个折叠符号，为了好看 */
  content: "∟";
  position: absolute;
  left: 10px;
  bottom: 5px;
  font-size: 12px;
}

/* 最外部div */
#bigdiv {
  position: relative;
  margin: 0 auto;
  width: 100%;
  max-width: 960px;
  background-color: rgba(253, 252, 252, 0.336);
}
/* 第二层div */
#bigdiv .view {
  margin-top: 6rem;
}
#bigdiv .column-view {
  padding: 0 0 8rem;
}

/* 左侧div */
.left-area {
  margin-bottom: 1.5rem;
}
.left-area {
  position: relative;
  width: 820px;
  max-width: 100%;
  box-sizing: border-box;
}
.left {
  border-radius: 4px 4px 0 0;
  position: relative;
  padding-top: 2.667rem;
  z-index: 0;
  border-radius: 4px;
  background-color: #fff;
  padding-left: 2.67rem;
  padding-right: 2.67rem;
  box-sizing: border-box;
}

/* 评论区样式 */
.pinlunqu {
  border-radius: 4px;
  background-color: var(--jianyi-card-bg);
  box-sizing: border-box;
  width: 100%;
  padding-left: 2rem;
  padding-right: 2rem;
  padding-bottom: 2rem;
  padding-top: 2rem;
  margin-top: 1.67rem;
}
.pl-header {
  margin-bottom: 2rem;
}

.el-textarea__inner {
  border-radius: 0px;
  min-height: 2rem;
  background-color: #f9f9f9fa;
}

.avatar {
  margin-right: 16px;
  width: 40px;
  height: 40px;
  border-radius: 50%;
  box-sizing: border-box;
  display: inline-flex;
  position: relative;
}

/* 评论区样式 */

/* 右侧div */
.rightsidebar {
  position: absolute;
  top: 0;
  right: 0;
  width: 25rem;
}

.fenlei {
  height: 100%;
  width: 100%;
  line-height: 60px;
  padding: 10px 10px;
}
.biaoqian {
  width: 100%;
  height: 50px;
}
.userdata {
  width: 98%;
  padding: 5px 5px;
}
.article-title {
  margin: 0 0 1.667rem;
  font-size: 2.667rem;
  font-weight: 600;
  line-height: 1.31;
  color: #252933;
  margin-block-start: 0.83em;
  margin-block-end: 0.83em;
}
.userdata {
  height: 70px;
  padding: 10px 5px;
}
.userdata-img {
  width: 7%;
  padding: 2px 0;
  height: 100%;
  float: left;
}
.userdata-img img {
  flex: 0 0 auto;
  margin-right: 1rem;
  width: 3.333rem;
  height: 3.333rem;
  border-radius: 50%;
}

.userdata-right {
  width: 92%;
  height: 100%;
  float: left;
  padding: 0 10px;
}
.right-meta-box {
  font-size: 0.8rem;
  color: #8a919f;
  margin-top: 2px;
  line-height: 22px;
}
.right-name {
  max-width: 128px;
  display: inline-block;
  vertical-align: top;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  font-size: 0.9rem;
  font-weight: 500;
  color: #515767;
  line-height: 2rem;
}
.fenzubiaoqian {
  padding-top: 10px;
  border-radius: 0 0 4px 4px;
  padding-bottom: 3.33rem;
}
.fenzubiaoqian {
  width: 100%;
  -ms-flex-wrap: nowrap;
  flex-wrap: nowrap;
  -webkit-box-pack: justify;
  -ms-flex-pack: justify;
  justify-content: space-between;
  -webkit-box-align: center;
  -ms-flex-align: center;
  align-items: center;
  padding: 35px 0px;
  height: 150px;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
  background: #fff;

  border-bottom-left-radius: 2px;
  border-bottom-right-radius: 2px;
  margin-top: 100px;
}
.fenzubiaoqian-title {
  float: left;
  padding: 10px 10px;
  height: 100%;
  width: 10%;
  line-height: 60px;
  font-size: 1rem;
}

.fenzubiaoqian i {
  font-size: 16px;
  padding-left: 10px;
}

.pl-data {
  width: 100%;
  float: left;
  padding: 10px 10px;
}

.user-card {
  width: 100%;
  height: 300px;
  padding: 10px 10px;
  background-color: rgb(255, 255, 255);
  border: 1px solid white;
  border-radius: 4px;
  box-shadow: 0 8px 16px 0 rgba(250, 250, 250, 0.05);
}
.blogdao-title {
  font-weight: 500;
  height: 40px;
  padding: 1.333rem 0;
  margin: 0 5px;
  font-size: 16px;
  line-height: 0em;
  color: #1d2129;
  border-bottom: 1px solid #e4e6eb;
}
.blogdao {
  background-color: rgb(255, 255, 255);
  margin: 10px 0;
  padding: 10px 20px;
}
.dao-div {
  width: 100%;
}
.dao-div ul {
  width: 100%;
  padding: 10px 0;
  max-height: 380px;
  overflow: auto;
}

.dao-div ul::-webkit-scrollbar {
  width: 6px;
}

.dao-div ul::-webkit-scrollbar-track {
  background-color: rgb(213, 227, 233);
  background-image: -webkit-linear-gradient(
    45deg,
    rgba(255, 255, 255, 0.2) 25%,
    transparent 25%,
    transparent 50%,
    rgba(255, 255, 255, 0.2) 50%,
    rgba(255, 255, 255, 0.2) 75%,
    transparent 75%,
    transparent
  );
  border-radius: 2px;
}

.dao-div ul::-webkit-scrollbar-thumb {
  background: #afd3f749;
  border-radius: 10px;
}
.dao-div ul::-webkit-scrollbar-thumb:hover {
  background: #9d9e9e;
}

.dao-div ul li {
  height: 40px;
  padding: 5px;
  color: inherit;
  border-radius: 5px;
  line-height: 30px;
  display: inline-block;
  white-space: nowrap;
  width: 100%;
  overflow: hidden;
  text-overflow: ellipsis;
}
.dao-div ul li:hover {
  background: rgba(5, 107, 232, 0.05);
}
.card-img {
  flex: 0 0 auto;
  width: 3rem;
  height: 3rem;
  border-radius: 50%;
  float: left;
}
.userinfo {
  flex: 1 1 auto;
  min-width: 0;
  margin-left: 1.333rem;
  float: left;
  height: 3rem;
}
.userinfo-title {
  font-size: 0.9rem;
  color: #252933;
  font-weight: 400;
}
.userinfo-data {
  margin-left: 10px;
  font-weight: 600;
  color: rgb(27, 27, 26);
}
.show-order-data {
  width: 100%;
  height: 100px;
  padding: 20px 5px;
  float: left;
}
.show-order-data-div {
  width: 100%;
}
.card-btn-div {
  width: 100%;
  height: 60px;
  padding: 5px 5px;
  float: left;
}
.card-btn {
  border-radius: 4px;
  width: 100%;
  font-size: 14px;
  justify-content: center;
  border: 1px solid;
  height: 40px;
  background-color: #4788d7d0;
  color: #fff;
  line-height: 30px;

  border: none;
}

.left-start-div {
  position: fixed;
  margin-left: -7rem;
  top: 140px;
  z-index: 2;
}

.btn-ui {
  width: 100%;
  height: 100%;
  padding: 20px 10px;
  outline: none;
}
.panel-btn {
  position: relative;
  margin-bottom: 1.667rem;
  width: 4rem;
  height: 4rem;
  background-color: #fff;
  background-position: 50%;
  background-repeat: no-repeat;
  border-radius: 50%;
  box-shadow: 0 2px 4px 0 rgb(0 0 0 / 4%);
  cursor: pointer;
  text-align: center;
  font-size: 1.67rem;
}
.panel-btnnonum {
  position: relative;
  margin-bottom: 1.667rem;
  width: 4rem;
  height: 4rem;
  background-color: #fff;
  background-position: 50%;
  background-repeat: no-repeat;
  border-radius: 50%;
  box-shadow: 0 2px 4px 0 rgb(0 0 0 / 4%);
  cursor: pointer;
  text-align: center;
  font-size: 1.67rem;
}
.buttoncheck {
  width: 100%;
  height: 100%;
  border-radius: 50%;
  border: none;
  /* background: rgba(5, 109, 232, 0.15);
   */
   /* background-color: red; */
  /* background-position: 50%; */
  /* color: #056de8; */
  color: rgb(11, 34, 238);
  background-repeat: no-repeat;

  transition: 1s;
}
.panel-btn {
  position: relative;
  margin-bottom: 1.667rem;
  width: 4rem;
  height: 4rem;

  background-position: 50%;
  background-repeat: no-repeat;
  border-radius: 50%;
  box-shadow: 0 2px 4px 0 rgb(0 0 0 / 4%);
  cursor: pointer;
  text-align: center;
  font-size: 1.67rem;
}

.btn-ui-btn {
  width: 100%;
  height: 100%;
  border: none;
   color: #535557;
  background-color: #fff;
  background-position: 50%;
  background-repeat: no-repeat;
  border-radius: 50%;
  transition: 1s;
  cursor: pointer;
  outline: none;
}
.btn-ui-btn:hover {
  transition: 1s;
  color: #056de8;
  /* background: rgba(5, 109, 232, 0.15); */
}

.panel-btn::after {
  content: attr(badge);
    position: absolute;
    top: 0;
    left: 75%;
    height: 17px;
    line-height: 17px;
    padding: 0 5px;
    border-radius: 9px;
    font-size: 11px;
    text-align: center;
    white-space: nowrap;
    background-color:#535557;
  color: #fff;
}
.panel-btn2::after {
    background-color:rgb(11, 34, 238);
}
/* .panel-btn .buttoncheck:after {
 
    background-color: royalblue;
 
} */

/* 去除聚焦框 */
input:focus {
  outline: none;
}
button:focus {
  outline: none;
  border-color: transparent;
}
select:focus {
  outline: none;
}

@media screen and (max-width: 960px) {
  /* #bigdiv{
    padding: 1% 1%;
  } */
  .right {
    display: none;
  }
  /* .left {
    width: 70%;
    padding: 1em;
  } */
  .left-start-div {
    display: none;
  }
  /* body {
        background-color:lightblue;
    } */
}

.fenzubiaoqian-title,
.fenzubiaoqian-title {
  float: left;
  padding: 10px 10px;
  width: 17%;
  line-height: 60px;
  font-size: 1rem;
}
.fenlei {
  width: 80%;
  line-height: 60px;
  padding: 10px 10px;
}
ian-left {
  width: 100%;
}
</style>
