<template>
  <div>
    <div
      class="row"
      style="padding: 0px 20px"
      v-clickoutside="hideReplyBtn"
      @click="inputFocus"
    >
      <div class="col-sm-1" style="padding: 0">
        <img v-show="islogin"
          class="header-img img-thumbnail"
          :src="'/api/' + this.user.avatar"
          alt=""
        />
          <el-avatar v-show="!islogin" icon="el-icon-user-solid"></el-avatar>
      </div>

      <div class="col-sm">
        <div class="row inputRow">
          <div class="reply-info">
            <el-input
              id="textarea"
              class="chatInput"
              type="textarea"
              :rows="3"

              :disabled="isDisable"
              resize= "none"
              placeholder="请输入内容"
              v-model="replyComment"
            >
            </el-input>
          </div>
        </div>

        <div class="row inputRow">
          <div class="col" style="padding-left: 0px"></div>
          <div class="col-7"></div>
          <div class="col-2" style="padding-right: 0px">
            <button
              type="button"
              v-show="islogin"
              class="btn btn-outline-primary"
              style="width: 100%"
              @click="sendComment"
            >
              发送
            </button>
          </div>
        </div>
      </div>
    </div>

    <div
      v-for="(item, i) in comments"
      :key="i.commentId"
      class="author-title reply-father"
    >
      <el-avatar class="header-img" :size="40" :src="item.headImg"></el-avatar>
      <div class="author-info">
        <span class="author-name">{{ item.createdBy }}</span
        ><span class="bozhu-cl" v-if="item.isMy == 1">博主</span>
        <span class="author-time">{{ item.createdTime }}</span>
      </div>
      <div class="icon-btn">
        <span @click="showReplyInput(i, item.blogId, item.commentId)"
          ><i class="iconfont el-icon-s-comment"></i>{{ item.startNum }}</span
        >
      </div>
      <div class="talk-box">
        <p>
          <span class="reply-data">{{ item.commentText }}</span>
        </p>
      </div>
      <div class="reply-box">
        <div
          v-for="(reply, j) in item.childs"
          :key="j.commentId"
          class="author-title"
        >
          <el-avatar
            class="header-img"
            :size="40"
            src="https://ae01.alicdn.com/kf/Hd60a3f7c06fd47ae85624badd32ce54dv.jpg"
          ></el-avatar>
          <div class="author-info">
            <span class="author-name">{{ reply.createdBy }}</span
            ><i v-if="19870621 == reply.id">你是博主</i>
            <span class="author-time">{{ reply.createdTime }}</span>
          </div>
          <div class="icon-btn">
            <span @click="showReplyInput(i, reply.from, reply.id)"
              ><i class="iconfont el-icon-s-comment"></i
              >{{ reply.startNum }}</span
            >
          </div>
          <div class="talk-box">
            <p>
              <span
                >回复 <i style="color: #777888">{{ reply.replyName }}</i
                >:</span
              >
              <span class="reply-data">{{ reply.commentText }}</span>
            </p>
          </div>
          <div class="reply-box"></div>
        </div>
      </div>
      <div v-show="_inputShow(i)" class="my-reply my-comment-reply">
        <el-avatar class="header-img" :size="40" :src="myHeader"></el-avatar>
        <div class="reply-info">
          <div
            tabindex="0"
            contenteditable="true"
            spellcheck="false"
            placeholder="输入评论..."
            @input="onDivInput($event)"
            class="reply-input reply-comment-input"
          ></div>
        </div>
        <div class="reply-btn-box">
          <el-button
            class="reply-btn"
            size="medium"
            v-show="islogin"
            @click="sendCommentReply(i, j)"
            type="primary"
            >发表评论</el-button
          >
        </div>
      </div>
    </div>
  </div>
</template>



<script>
import { addCommentOne, getCommtree } from "../api/common";
import emojiVue from "./emoji.vue";

const clickoutside = {
  // 初始化指令
  bind(el, binding, vnode) {
    function documentHandler(e) {
      // 这里判断点击的元素是否是本身，是本身，则返回
      if (el.contains(e.target)) {
        return false;
      }
      // 判断指令中是否绑定了函数
      if (binding.expression) {
        // 如果绑定了函数 则调用那个函数，此处binding.value就是handleClose方法
        binding.value(e);
      }
    }
    // 给当前元素绑定个私有变量，方便在unbind中可以解除事件监听
    el.vueClickOutside = documentHandler;
    document.addEventListener("click", documentHandler);
  },
  update() {},
  unbind(el, binding) {
    // 解除事件监听
    document.removeEventListener("click", el.vueClickOutside);
    delete el.vueClickOutside;
  },
};
export default {
  components: { emojiVue },
  props: {
    comments: [],
    required: true,
    blogId: "",
  },
  name: "ArticleComment",
  data() {
    return {
      btnShow: false,
      index: "0",
      replyComment: "",
      myName: "Lana Del Rey",
      myHeader:
        "https://ae01.alicdn.com/kf/Hd60a3f7c06fd47ae85624badd32ce54dv.jpg",
      myId: 19870621,
      commblogId: "",
      commPid: -1,
      user: {},
      islogin:false,
      isDisable:false
    };
  },
  directives: { clickoutside },
  created() {
    this.getUserData();
    this.isloginFaction();
  },
  methods: {
    isloginFaction(){
       if (this.$getToken()) {
        this.islogin = true;
        this.isDisable = false;
       }else{
        this.islogin = false;
        this.isDisable = true;
       }
    },
    getUserData() {
      var udata = JSON.parse(localStorage.getItem("userData"));
      if (udata) {
        this.user = udata;
      }
    },
    // 文本编辑表情
    changeText() {
      var textArea = document.getElementById("textarea");
      function changeSelectedText(obj, str) {
        if (window.getSelection) {
          // 非IE浏览器
          textArea.setRangeText(str);
          // 在未选中文本的情况下，重新设置光标位置
          textArea.selectionStart += str.length;
          textArea.focus();
        } else if (document.selection) {
          // IE浏览器
          obj.focus();
          var sel = document.selection.createRange();
          sel.text = str;
        }
      }
      changeSelectedText(
        textArea,
        this.$refs.getEmoji.faceList[this.$refs.getEmoji.emojiItem]
      );
      this.message = textArea.value; // 要同步data中的数据
      // console.log(this.$refs.getEmoji.faceList[this.$refs.getEmoji.emojiItem]);
    },

    //新增评论
    addComment(blogId, commentText, commentPid) {
      if (this.$getToken()) {
        addCommentOne({
          blogId: blogId,
          commentText: commentText,
          commentPid: commentPid,
        }).then(async (res) => {
          if (res.code === 500) {
            this.$notify.error({
              title: "错误",
              message: res.msg,
            });
          } else if (res.code === 200) {
            this.commonTree(this.blogId);
          }
        });
      } else {
        
        this.$Login();
      }
    },
    //查询评论树
    commonTree(blogId) {
      getCommtree(blogId).then(async (res) => {
        if (res.code === 500) {
          this.$notify.error({
            title: "错误",
            message: res.msg,
          });
        } else if (res.code === 200) {
          this.comments = res.data;
        }
      });
    },
    //在这里调用ajax请求方法
    inputFocus() {
      var replyInput = document.getElementById("replyInput");
      replyInput.style.padding = "8px 8px";
      replyInput.style.border = "2px solid blue";
      replyInput.focus();
    },

    showReplyInput(i, blogid, id) {
      this.comments[this.index].inputShow = false;
      this.index = i;
      this.comments[i].inputShow = true;
      this.commblogId = blogid;
      this.commPid = id;
    },
    _inputShow(i) {
      return this.comments[i].inputShow;
    },
    sendComment() {
      if (!this.replyComment) {
        this.$message({
          showClose: true,
          type: "warning",
          message: "评论不能为空",
        });
      } else {
        this.addComment(this.blogId, this.replyComment, 0);
      }
    },

    sendCommentReply(i, j) {
      if (!this.replyComment) {
        this.$message({
          showClose: true,
          type: "warning",
          message: "评论不能为空",
        });
      } else {
        alert(this.commPid);
        this.addComment(this.commblogId, replyComment, this.commPid);
      }
    },

    onDivInput: function (e) {
      this.replyComment = e.target.innerHTML;
    },
    dateStr(date) {
      //获取js 时间戳
      var time = new Date().getTime();
      //去掉 js 时间戳后三位，与php 时间戳保持一致
      time = parseInt((time - date) / 1000);
      //存储转换值
      var s;
      if (time < 60 * 10) {
        //十分钟内
        return "刚刚";
      } else if (time < 60 * 60 && time >= 60 * 10) {
        //超过十分钟少于1小时
        s = Math.floor(time / 60);
        return s + "分钟前";
      } else if (time < 60 * 60 * 24 && time >= 60 * 60) {
        //超过1小时少于24小时
        s = Math.floor(time / 60 / 60);
        return s + "小时前";
      } else if (time < 60 * 60 * 24 * 30 && time >= 60 * 60 * 24) {
        //超过1天少于30天内
        s = Math.floor(time / 60 / 60 / 24);
        return s + "天前";
      } else {
        //超过30天ddd
        var date = new Date(parseInt(date));
        return (
          date.getFullYear() +
          "/" +
          (date.getMonth() + 1) +
          "/" +
          date.getDate()
        );
      }
    },
  },
};
</script>


<style scoped lang="css">
.my-reply {
  padding: 10px;
  background-color: #fafbfc;
  font-family: -apple-system, SF UI Text, Arial, PingFang SC, Hiragino Sans GB,
    Microsoft YaHei, WenQuanYi Micro Hei, sans-serif;
  position: relative;
  display: flex;
  flex-direction: column; /* 垂直布局 */
}

.header-img {
  display: inline-block;
  vertical-align: top;
  width: 4rem;
  height: 4rem;
}
.my-reply {
  display: inline-block;
  margin-left: 5px;
  width: 90%;
  min-height: 6rem;
}

.reply-info {
  width: 100%;
  height: 100%;
}
.inputRow {
  padding: 0px 10px;
}
#textarea {
  height: 80%;
}

@media screen and (max-width: 1200px) {
  .my-reply .reply-info {
    width: 80%;
  }
}

.my-reply .reply-info {
  line-height: 22px;
  padding: 10px 10px;
  color: #ccc;
  background-color: #fff;
  border-radius: 5px;
}
.reply-input {
  width: 100%;
  min-height: 100px;
  line-height: 22px;
  padding: 10px 10px;
  color: #000000;
  /* background-color:rgba(248,249,251,0.8); */
  background-color: rgb(228 230 235 / 80%);
  border-radius: 5px;
  outline: none;
}
.reply-input:focus {
  padding: 8px 8px;
  border: 2px solid #00f;
  box-shadow: none;
  outline: none;
}

.my-reply .reply-info .reply-input:empty:before {
  content: attr(placeholder);
}

.my-reply .reply-info .reply-input:focus:before {
  content: none;
}

.my-reply .reply-info .reply-input:focus {
  padding: 8px 8px;
  border: 2px solid #00f;
  box-shadow: none;
  outline: none;
}

.my-reply {
  height: 25px;
  margin: 10px 0;
}

.reply-btn-box {
  width: 100%;
  height: 20%;
}
.my-reply .reply-btn {
  position: relative;
  float: right;
  margin-right: 15px;
}

.my-comment-reply {
  margin-left: 50px;
}

.my-comment-reply .reply-input {
  width: flex;
}
/* 
    .author-title:not(:last-child) {
        border-bottom: 1px solid rgba(178, 186, 194, 0.3);
    } */

.author-title {
  margin-top: 1rem;
  padding: 10px;
  min-height: 78px;
  font-family: -apple-system, SF UI Text, Arial, PingFang SC, Hiragino Sans GB,
    Microsoft YaHei, WenQuanYi Micro Hei, sans-serif;
}

.author-title .header-img {
  display: inline-block;
  vertical-align: top;
}

.author-title .author-info {
  display: inline-block;
  margin-left: 5px;
  width: 60%;
  height: 20px;
  line-height: 20px;
}

.author-title .author-info > span {
  display: block;
  cursor: pointer;
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
}

.author-title .author-info .author-name {
  /* color: #000;
        font-size: 18px;
        font-weight: bold; */
  display: inline-block;
  max-width: 110px;
  color: #777888;
  margin-right: 4px;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  float: left;
}

.author-title .author-info .author-time {
  font-size: 14px;
}
.author-time {
  font-size: 14px;
  color: #777888;
  float: left;
}
.author-title .icon-btn {
  width: 70px;
  padding: 0 !important;
  float: right;
}

@media screen and (max-width: 1200px) {
  .author-title .icon-btn {
    width: 20%;
    padding: 7px;
  }
}

.author-title .icon-btn > span {
  cursor: pointer;
}

.author-title .icon-btn .iconfont {
  margin: 0 5px;
}

.author-title .talk-box {
  margin: 0 50px;
}

.author-title .talk-box > p {
  margin: 0;
}

.author-title .talk-box .reply {
  font-size: 16px;
  color: #000;
}

.author-title .reply-box {
  margin: 10px 0 0 50px;
}

.reply-data {
  font-size: 14px;
  color: #222226;
  line-height: 22px;
  word-break: break-word;
  font-family: -apple-system, SF UI Text, Arial, PingFang SC, Hiragino Sans GB,
    Microsoft YaHei, WenQuanYi Micro Hei, sans-serif;
  padding: 0;
  margin: 0;
}
.bozhu-cl {
  color: white;
  width: 50px;
  font-size: 12px;
  text-align: center;
  float: left;
  border-radius: 15px;
  font-family: "Franklin Gothic Medium", "Arial Narrow", Arial, sans-serif;
  background-color: rgb(250, 104, 0);
}
</style>