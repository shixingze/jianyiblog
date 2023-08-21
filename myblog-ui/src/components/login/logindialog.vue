<template>
  <!--登陆框 -->
  <div v-if="show" id="login-box">
    <div class=".login-mini" id="popup">
      <div class="top-div">
        <div align="center">
          <span>登录账号</span>
          <a class="guanbi" @click="uplogin"></a>
        </div>
      </div>
      <div class="min">
        <div class="tc_login">
          <div class="left">
            <h4 align="center">手机扫描</h4>
            <div align="center">
              <img
                src="../../../static/assets/images/erweima.jpg"
                width="150"
                height="150"
              />
            </div>
            <dd>
              <div align="center">扫描二维码登录</div>
            </dd>
          </div>
          <div class="right" v-if="denglushow">
            <form action="#" class="form" id="form1" ref="form">
              <div align="center">
                <a href="">邮箱快捷登录</a>
                <i class="icon-mobile-phone"></i>
                <input
                  type="text"
                  id="name"
                  required="required"
                  placeholder="用户名/邮箱"
                  autocomplete="off"
                  v-model="form.username"
                  class="input_yh"
                />
                <input
                  type="password"
                  name="pass"
                  id="pass"
                  required="required"
                  placeholder="密码"
                  autocomplete="off"
                  v-model="form.password"
                  class="input_mm"
                />
              </div>
              <dd>
                <div align="center"><a href="">遇到登录问题</a></div>
              </dd>
              <div align="center">
                <input
                  style="color: #fff; font-size: 1.2em; padding: 0 50px 0 50px"
                  @click="submitForm()"
                  class="btn"
                  value="登录"
                />
              </div>
            </form>
            <dd>
              <div align="center">
                <a href="#" @click="zhuceShow">立即注册</a>
              </div>
            </dd>
           
          </div>

          <!-- 注册功能 -->
          <div class="right" v-if="zhuceshow">
            <form action="#" class="form" id="form1" ref="zhuce">
              <div align="center" id="inputdiv">
                <el-row :gutter="20">
                  <el-col :span="24">
                    <input
                      type="text"
                      id="name"
                      required="required"
                      placeholder="账号"
                      autocomplete="off"
                      v-model="zhuce.username"
                      class="input_yh"
                  /></el-col>
                </el-row>
                <el-row :gutter="20">
                  <el-col :span="24">
                    <input
                      type="text"
                      name="pass"
                      id="pass"
                      required="required"
                      placeholder="密码"
                      autocomplete="off"
                      v-model="zhuce.password"
                      class="input_mm"
                  /></el-col>
                </el-row>
                <el-row :gutter="20">
                  <el-col :span="24">
                    <input
                      type="email"
                      name="pass"
                      id="pass"
                      required="required"
                      placeholder="邮箱"
                      autocomplete="off"
                      v-model="zhuce.email"
                      class="input_yx"
                    />
                  </el-col>
                </el-row>
                <el-row :gutter="20">
                  <el-col :span="24">
                    <el-input
                      type="text"
                      placeholder="输入验证码"
                      v-model="zhuce.authCode"
                      maxlength="10"
                    >
                    </el-input>
                    <!-- <input
                      type="email"
                      name="pass"
                      id="pass"
                      required="required"
                      placeholder="输入验证码"
                      autocomplete="off"
                      v-model="zhuce.vcode"
                      class="input_mm"
                    /> -->
                  </el-col>
                  <el-col :span="12" class="fasong">
                    <span v-show="!isSendCode" @click="sendyzCode"
                      >发送验证码</span
                    >
                    <span v-show="isSendCode">{{ sendMins }}s后重新获取</span>
                  </el-col>
                </el-row>

                <!-- <div class="input-group mb-3">
  <input type="text" class="form-control" placeholder="Recipient's username" aria-label="Recipient's username" aria-describedby="button-addon2">
  <button class=" btn-outline-secondary" type="button" id="button-addon2">Button</button>
</div> -->
                <!-- <input
                  type="password"
                  name="pass"
                  id="pass"
                  required="required"
                  placeholder="验证码"
                  autocomplete="off"
                  v-model="zhuce.password"
                  class="input_mm input-code"
                  style="width: 50%;"
                />
               <button class="input-code-button">发送</button> -->
              </div>

              <dd>
                <div align="center"><a href="">遇到登录问题</a></div>
              </dd>
              <div align="center">
                <input
                  style="color: #fff; font-size: 1.2em; padding: 0 50px 0 50px"
                  @click="zhuceF"
                  class="btn"
                  value="注册"
                />
              </div>
            </form>
            <dd>
              <div align="center">
                <a href="#" @click="goLoginShow">去登陆</a>
              </div>
            </dd>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
  
  <script>
import { getToken, getyzCode, register, getUserInfo } from "@/api/login";
import Cookies from "js-cookie";
export default {
  data() {
    return {
      show: true,
      denglushow: true,
      form: {
        username: "",
        password: "",
      },
      zhuceshow: false,
      zhuce: {
        username: "",
        authCode: "",
        email: "",
        password: "",
      },
      //是否在发送
      isSendCode: false,
      sendMins: 60,
      timeFun:null
    };
  },
  created() {},
  mounted() {},
  methods: {
    //  发送验证码
    sendyzCode() {
      if (!this.zhuce.email) {
        this.$notify({
          title: "警告",
          message: "请填写邮箱号码！",
          type: "warning",
        });
      } else if (!this.zhuce.email.includes("@")) {
        this.$notify({
          title: "警告",
          message: "请填写正确的邮箱号码！",
          type: "warning",
        });
      } else {
        getyzCode({
          email: this.zhuce.email,
        }).then(async (res) => {
          console.log(res);
          if (res.code === 500) {
          } else if (res.code === 200) {
            this.isSendCode = true;
            let timer = 60;
            this.sendmsg = timer + "s";
            this.timeFun = setInterval(() => {
              --timer;
              this.sendMins = timer;
              if (timer == 0) {
                this.isSendCode = false;
                clearInterval(this.timeFun);
                this.timeFun = null;
              }
            }, 1000);
          }
        });
      }
    },
    //注册
    zhuceF() {
      register({
        data: this.zhuce,
      }).then(async (res) => {
        console.log(res);
        if (res.code === 500) {
          this.$notify.error({
            title: "错误",
            message: res.msg,
          });
        } else if (res.code === 200) {
          this.show = false;
          this.$notify({
            title: "成功",
            message: "注册成功!",
            type: "success",
          });
        }
      });
    },
    showlogin() {
      this.show = true;
    },
    uplogin() {
      this.show = false;
    },
    zhuceShow() {
      this.denglushow = false;
      this.zhuceshow = true;
    },
    goLoginShow() {
      this.denglushow = true;
      this.zhuceshow = false;
    },
    //登录
    submitForm() {
      var msgdiv = document.getElementById("message");
      getToken({
        username: this.form.username,
        password: this.form.password,
      }).then(
        async (res) => {
          console.log(res);
          if (res.code === 500) {
            this.password = "";
            msgdiv.style.display = "block";
            msgdiv.innerHTML = res.msg;
          } else if (res.code === 200) {
            Cookies.set("token", res.data.token, 1);
            this.uplogin();
            this.$notify({
              title: "登录成功",
              message: res.msg,
              type: "success",
            });
            try {
              let result = await getUserInfo();
              localStorage.setItem("userData", JSON.stringify(result.data));
            } catch (error) {}
            location.reload();
          }
        },
        (err) => {
          // console.log(err.msg);
          this.password = "";
          // this.$message.error(err.msg);
        }
      );
    },
  },
  computed: {},
  watch: {},
  components: {},
};
</script>
  
  <style  scoped>
.fasong {
  display: block;
  cursor: pointer;
  /* height: 24px;
    line-height: 24px;
    font-size: 14px; */
  position: absolute;
  font-weight: 500;
  color: #222226;
  top: 60%;
  right: 10px;
  transform: translateY(-50%);
}
.input-code-button {
  width: 10%;
}
.inputdiv {
  display: flex;
  flex-direction: column;
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
  width: 700px;
  height: auto;
  padding: 10px 10px;
  border-radius: 8px;
  -webkit-box-shadow: 0 0 6px rgb(0 0 0 / 10%);
  box-shadow: 0 0 6px rgb(0 0 0 / 10%);
  padding: 52px 65px 29px 92px;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
  background-color: #fff;
  background-image: url("../../../static/assets/images/jianyi.png");
  background-position: 0 0, 100% 100%;
  background-repeat: no-repeat, no-repeat;
  background-size: 15%;
  -webkit-box-orient: vertical;
  -webkit-box-direction: normal;
  -ms-flex-direction: column;
  flex-direction: column;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
  margin: auto;
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

  padding-left: 20px;
}
#close {
  position: absolute;
  right: 20px;
  top: 5px;
  font-size: 35px;
  color: darkgray;
  cursor: pointer;
}

.top-div {
  width: 532px;
  height: 46px;
  background-image: url(../../../static/assets/images/popup_top_bj.jpg);
  border-bottom: 1px solid #ebeaea;
  position: relative;
  cursor: move;
  margin: auto;
  margin-top: 50px;
}
.top-div i {
  width: 35px;
  height: 35px;
  background: url(../../../static/assets/images/sucai_tubiao.png) -314px -5px;
  position: absolute;
  top: 6px;
  left: 8px;
  display: block;
}
.top-div span {
  font: 18px/18px "microsoft yahei";
  color: #707070;
  display: block;
  position: absolute;
  top: 13px;
  left: 50px;
}

.top-div a.guanbi {
  background: url(../../../static/assets/images/popup_guanbi.png) repeat 0px 0px;
  width: 35px;
  height: 35px;
  display: block;
  position: absolute;
  top: 8px;
  right: 10px;
  cursor: pointer;
}
.top-div a.guanbi span {
  display: none;
}
.yzmcode {
  width: 70%;
}
.top-div a.guanbi:hover {
  background: url(../../../static/assets/images/popup_guanbi.png) repeat 0px -35px;
}

.right .input_yh {
  background: url(../../../static/assets/images/tc_login_yonghu.jpg) no-repeat
    left top;
}
.right .input_mm {
  background: url(../../../static/assets/images/tc_login_mima.jpg) no-repeat
    left top;
}

.right .input_yx {
  background: url(../../../static/assets/images/yx1.png) no-repeat left top;
  background-size: 32px 36px;
}
.right .input_yx:focus {
  background: url(../../../static/assets/images/yx2.png) no-repeat left top;
  background-size: 32px 36px;
}

.right .input_yh:focus {
  background: url(../../../static/assets/images/tc_login_yonghu2.jpg) no-repeat
    left top;
}
.right .input_mm:focus {
  background: url(../../../static/assets/images/tc_login_mima2.jpg) no-repeat
    left top;
}

.btn {
  background: #36a803;
  border: none;
  border-radius: 2px;
  color: #fff;
  cursor: pointer;
  height: 50px;
  font-family: "Open Sans", sans-serif;
  font-size: 1.2em;
  letter-spacing: 0.05em;
  text-align: center;
  text-transform: uppercase;
  transition: background 0.3s ease-in-out;
  width: 255px;
  padding: 0 50px 0 50px;
  font-weight: bold;
}
.btn:hover {
  background: #019a0d;
}

.message {
  width: 255px;
  float: right;
  height: 25px;
  white-space: nowrap;
  background-color: #fff8f4;
  border: 1px solid #e3abb9;
  line-height: 20px;
  padding: 2px 4px;
  overflow: hidden;
  font-size: 12px;
  color: #e57b89;
  margin-bottom: 10px;
  text-align: left;
  display: none;
}

@media (max-width: 960px) {
  .top-div {
    width: 90%;
    height: 46px;
    background-image: url(/static/img/popup_top_bj.d3a4262.jpg);
    border-bottom: 1px solid #ebeaea;
    position: relative;
    cursor: move;
    margin: auto;
    margin-top: 50px;
  }
  .tc_login {
    width: 90%;
    height: 380px;
    background-color: #fff;
    margin: auto;
  }

  .tc_login .left {
    width: 200px;
    height: 380px;
    float: left;
    display: none;
  }
  .tc_login .right {
  }
}
</style>

  
  
  