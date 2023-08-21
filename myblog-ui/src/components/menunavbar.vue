<template>
  <nav
    class="navbar navbar-expand-lg navbar-transparent navbar-dark bg-dark py-4"
  >
    <div class="container">
      <a class="navbar-brand" href="./" style="z-index: 2"
        ><strong>JIANYIBLOG(Shi)</strong>Personal website</a
      >
      <button
        class="navbar-toggler"
        type="button"
        data-action="offcanvas-open"
        data-target="#navbar_main"
        aria-controls="navbar_main"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="navbar-collapse offcanvas-collapse" id="navbar_main">
        <header
          id="my-header"
          class=" my-header"
          :class="{ allblack: paths != '/',
                   daohangShow: paths === '/' && scrollStatus,
                   daohangTM: paths === '/' && !scrollStatus
           }"
        >
          <nav>
            <ul class="navbar-nav ml-auto align-items-lg-center min-menu">
              <h6 class="dropdown-header font-weight-600 d-lg-none px-0">
                Menu
              </h6>
              <li class="nav-item active">
                <router-link class="nav-link" to="/">首页</router-link>
              </li>
              <li class="nav-item">
                <router-link to="/belog" class="nav-link nav-link-icon"
                  >blog 博客</router-link
                >
              </li>
              <li class="nav-item">
                <router-link to="/tools" class="nav-link nav-link-icon"
                  >工具箱</router-link
                >
              </li>
              <li class="nav-item dropdown">
                <a
                  class="nav-link dropdown-toggle"
                  href="#"
                  id="navbar_main_dropdown_1"
                  role="button"
                  data-toggle="dropdown"
                  aria-haspopup="true"
                  aria-expanded="false"
                  >消息</a
                >
                <div
                  class="dropdown-menu"
                  aria-labelledby="navbar_1_dropdown_1"
                >
                  <!-- <a class="dropdown-item" ro>blog 博客</a> -->
                  <router-link class="dropdown-item" to="/belog"
                    >blog 博客</router-link
                  >
                  <a class="dropdown-item" href="./pages/about.html"
                    >folder 文件盒</a
                  >
                  <a class="dropdown-item" href="./pages/sign-in.html"
                    >music 音乐盒</a
                  >
                  <a class="dropdown-item" href="./pages/contact.html"
                    >Personal page 个人页</a
                  >
                  <router-link class="dropdown-item" to="/dengji"
                    >登记表单</router-link
                  >
                  <a
                    href="http://192.168.1.6:8099/api/from/image?url=http://localhost:8080/%23/dengji"
                    >表单二维码</a
                  >
                  <router-link class="dropdown-item" to="/jilist"
                    >表单列表</router-link
                  >
                </div>
              </li>

              <li class="nav-item">
                <a @click="openlogin" target="_blank" class="nav-link d-lg-none"
                  >登 录</a
                >
                <a
                  @click="openlogin"
                  target="_blank"
                  :class="
                    isLogin
                      ? 'isFixed'
                      : 'btn btn-sm bg-white d-none d-lg-inline-flex'
                  "
                  >登 录 login</a
                >
              </li>
              <li class="nav-item">
                <el-popover
                  placement="bottom"
                  width="250"
                  trigger="click"
                  content="这是一段内容,这是一段内容,这是一段内容,这是一段内容。"
                >
                  <div class="userdata-tanchuang">
                    <img :src="'/api/' + this.userData.avatar" alt="" />
                    <div class="user-data-info">
                      {{ this.userData.nickName }}
                      <div style="font-size: 10px">
                        {{ this.userData.phone }}
                      </div>
                      <router-link to="/userdata" style="font-size: 10px"
                        >管理页></router-link
                      >
                    </div>
                  </div>
                  <el-row class="text-num">
                    <el-col :span="8">{{ this.userData.followNum }}</el-col>
                    <el-col :span="8">{{ this.userData.forStartNum }}</el-col>
                    <el-col :span="8">{{ this.userData.collectionNum }}</el-col>
                  </el-row>
                  <el-row class="text-num-size">
                    <el-col :span="8">关注</el-col>
                    <el-col :span="8">被赞</el-col>
                    <el-col :span="8">收藏</el-col>
                  </el-row>
                  <div
                    class="login-user"
                    slot="reference"
                    :class="!isLogin ? 'isFixed' : 'login-user'"
                  >
                    <img :src="'/api/' + this.userData.avatar" alt="" />
                  </div>
                  、
                </el-popover>
              </li>
              <div class="dropdown-divider d-lg-none my-4"></div>
              <h6 class="dropdown-header font-weight-600 d-lg-none px-0">
                Social Media
              </h6>

              <li class="nav-item">
                <button
                  @click="gotoBlog"
                  class="nav-link nav-link-icon fabu-btn"
                  style="color: white"
                >
                  发布博文
                </button>
              </li>
            </ul>
          </nav>
        </header>
      </div>
    </div>
  </nav>
</template>

<script>
import { Path } from "slate";

export default {
  name: "HelloWorld",
   watch: {
    '$route'(to, from) {
      // 在路由切换时执行操作
      console.log('Route changed:', from.path, '->', to.path);
    },
  },
  props: {
    paths: {
      default: "",
    },
  },
  data() {
    return {
      msg: "Welcome to Your Vue.js App",
      show_common_alert: false,
      scrollStatus:false,
      form: {
        username: "",
        password: "",
      },
      isLogin: "",
      userData: {},
    };
  },
  created() {
    this.isLoginDto();
    this.getUserData();
  },
  mounted() {
    this.setBar();
    this.doAfterRender(); // 在mounted钩子中调用特定方法
  },

  methods: {
     setBar() {
      
      window.addEventListener("scroll",  ()=> {
        var scrollPos = window.scrollY;

        if (scrollPos > 50) {
          this.scrollStatus = true;
        } else {
          this.scrollStatus = false;
        }
      });
    },

    getUserData() {
      var data = JSON.parse(localStorage.getItem("userData"));
      if (data) {
        this.userData = data;
      }
    },
    isLoginDto() {
      if (this.$getToken()) {
        this.isLogin = true;
      }
    },
    openlogin() {
      this.$Login();
    },
    gotoBlog() {
      if (this.$getToken()) {
        this.$router.push("/editor");
      } else {
        this.$Login();
      }
    },
  },
};
</script>

<style scoped>
/* 导航栏样式 */
.daohangTM {
  box-shadow: none;
  /* background-color: #ebeff500 !important; */
  /* opacity: 1; */
  transition-property: all;
  transition-duration: 0.5s;
}
.daohangShow {
  background-color: rgba(0, 0, 0, 0.85);
  transition-property: all;
  transition-duration: 0.5s;
}
.allblack {
  background-color: rgba(0, 0, 0, 0.85);
  transition-property: all;
  transition-duration: 0.6s;
}
.login-user {
  height: 40px;
  width: 40px;
}
.userdto-card {
  width: 200px;
  height: 200px;
  background-color: aquamarine;
  position: absolute;
}
.login-user img {
  border-radius: 50%;
  height: 40px;
  width: 40px;
}
.isFixed {
  display: none;
}
.navbar {
  height: 100%;
}
#login-box {
  width: 100%;
  height: 100%;
  position: fixed;
  top: 0;
  left: 0;
  font-size: 14px;
  background: rgba(0, 0, 0, 0.5);
  z-index: 10010;
  align-items: center;
}
.login-mini {
  -webkit-box-pack: center;
  -ms-flex-pack: center;
  justify-content: center;
  -webkit-box-align: center;
  -ms-flex-align: center;

  width: 900px;
  height: 500px;
  margin: auto;
  border-radius: 8px;
  -webkit-box-shadow: 0 0 6px rgb(0 0 0 / 10%);
  box-shadow: 0 0 6px rgb(0 0 0 / 10%);
  padding: 52px 65px 29px 92px;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
  background-color: #fff;
  background-image: url(https://s1.hdslb.com/bfs/seed/jinkela/short/mini-login/img/22_open.72c00877.png),
    url(https://s1.hdslb.com/bfs/seed/jinkela/short/mini-login/img/33_open.43a09438.png);
  background-position: 0 100%, 100% 100%;
  background-repeat: no-repeat, no-repeat;
  background-size: 14%;
  position: relative;
  top: 80px;
  -webkit-box-orient: vertical;
  -webkit-box-direction: normal;
  -ms-flex-direction: column;
  flex-direction: column;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}
.left-erweima {
  width: 40%;
  height: 200px;
  float: left;
  background-color: rebeccapurple;
}
.right-login {
  width: 60%;
  height: auto;
  float: right;
}
#close {
  position: absolute;
  right: 20px;
  top: 5px;
  font-size: 35px;
  color: darkgray;
  cursor: pointer;
}

.mini-zhanghao {
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  padding: 0 20px;
  -webkit-box-align: center;
  -ms-flex-align: center;
  align-items: center;
  border: 1px solid #e7e7e7;
  border-radius: 8px 8px 0 0;
  height: 43px;
  border-bottom: none;
}

.mini-zhanghao .text,
.mini-password .text {
  margin-right: 20px;
  font-size: 14px;
  color: #212121;
}
.mini-password {
  position: relative;
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  padding: 0 20px;
  -webkit-box-align: center;
  -ms-flex-align: center;
  align-items: center;
  -webkit-box-pack: justify;
  -ms-flex-pack: justify;
  justify-content: space-between;
  border: 1px solid #e7e7e7;
  border-radius: 0 0 8px 8px;
  height: 43px;
}

.input {
  position: relative;
  width: 210px;
  outline: none;
  border: none;
  font-size: 14px;
  color: #212121;
  -webkit-box-shadow: 0 0 0 20px #fff inset;
  box-shadow: inset 0 0 0 20px #fff;
}
.fabu-btn {
  border: none;
  outline: none;
}
.userdata-tanchuang {
  width: 100%;
  height: 80px;
  border-bottom: 0.5px #70809054 solid;
}
.userdata-tanchuang img {
  width: 50px;
  height: 50px;
  border-radius: 50%;
  float: left;
}
.userdata-tanchuang .user-data-info {
  float: left;
  width: 70%;
  color: var(--juejin-font-2);
  font-size: 13px;
  padding: 0 20px;
}
.text-num {
  text-align: center;
  padding: 10px 5px;
  font-weight: 500;
  font-size: 16px;
  line-height: 18px;
  color: black;
}
.text-num-size {
  text-align: center;
  color: var(--juejin-font-3);
  font-weight: 400;
  font-size: 12px;
  line-height: 18px;
}

/* 菜单隐藏 */

header {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  z-index: 1;
  background-color: rgba(0, 0, 0, 0);
  transition: background-color 0.3s ease;
}

nav {
  display: flex;
  justify-content: flex-end;
  align-items: center;
  padding: 8px;
}

nav ul {
  display: flex;
  margin: 0;
  padding: 0;
  list-style: none;
}

nav ul li {
  margin: 0 10px;
}
.bar-blue {
  background-color: blue;
}
.bar-black {
  background-color: #212121;
}

/**小菜单 */
.min-menu {
  margin: 0;
}
</style>
