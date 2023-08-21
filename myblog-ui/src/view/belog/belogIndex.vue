<template>
  <div id="blogdiv">
      <div class="headbigbardiv">
        <ul
          class="row headbigbar"
          id="headbigbar"
        >
          <li class="firsta"  v-for = "item in firstCatelist" :key="item.categoryId" ><a  @click="childCateByid(item.categoryId)">{{item.categoryName}}</a></li>
        </ul>
        <div class="imge-button">
          <img
            class="blog-nav-box"
            id="blog-nav-box"
            src="../../../static/assets/images/button/展开.png"
            width="7%"
          />
        </div>
      </div>
    

    <div class="childheaderdiv">
        <ul class="row headchildbar">
          <li v-for="child in childCatelist" :key="child.categoryId" @click="listByParm(child.categoryId)" class="tag">
             <button type="button"   class="btn btn-outline-primary btn-sm" 
       >
   {{child.categoryName}}
</button>

          </li>
        </ul>
    </div>

    <div>
      <div class="row show-data" >
        <div  v-infinite-scroll="loads"  class="left-data-article">
          <div class="articletext infinite-list"   v-for="blog in blogList" :key="blog.blogId">
            <div class="card-body">
              <div class="meta-container">
                <div class="user-message">
                {{blog.createdBy}}
              </div>
              <div class="dividing">

              </div>
      
              <div class="date"><TimeDiff style="font-size: 1rem;" :date="blog.createdTime"/></div>
              </div>
          

              <div class="d-flex align-items-start">
                <img
                  :src="'/api/'+blog.blogCover"
                  style="width: 100px; height: 100px"
                />
                <div class="icon-text article">
                  <h3 class="heading h5">
                    <router-link   :to="'/belog/show/?blogId='+blog.blogId" target="_blank" class="title-class" >{{blog.blogTitle}}</router-link>
                  </h3>
                  <p class="mb-0 blog-text">
                    <router-link   :to="'/belog/show/?blogId='+blog.blogId" target="_blank" class="blog-text-link" >{{blog.blogAbstract}}</router-link>
                  
                  </p>
                  
                </div>
              
              </div>
              <ul class="action-list">
                    <a href="#" @click="dianzan"><li class="item">  <span><i class="iconfont icon-dianzan"></i>{{blog.blogLike}}</span></li></a>
                    <a href="#"><li class="item">   <span ><i class="iconfont icon-xiaoxi"></i> {{blog.blogComments}}</span></li></a>
                    <a href="#"><li class="item"><span ><i class="iconfont icon-yulan"></i> {{blog.blogBrowsing}}</span></li></a>
                      
                  </ul>
            </div>
          </div>
         
        </div>

        <div class="right-dev">
          <div class="right-dev-title">
            <span>贡献博主</span>
          </div>
          <div class="user-list">
            <div class="user-list-item" v-for="userData in ContrBloggerList" :key="userData.userId">
              <a href="#" target="_blank" rel class="link">
              
                <img :src="'/api/'+userData.avatar" class="lazy avatar avatar" loading="lazy">
               
                <div class="user-info">
                  <a data-v-0ef8bafa="" data-v-edec7d04="" href="/user/2463384809252397" target="_blank" rel="" class="username username">
                    <span data-v-0ef8bafa="" class="name" style="max-width: 128px;">{{userData.nickName }}
                    </span> 
                    <span data-v-3de16c56="" data-v-0ef8bafa="" blank="true" class="rank">
                      <img data-v-3de16c56="" src="//lf3-cdn-tos.bytescm.com/obj/static/xitu_juejin_web/img/lv-3.7938ebc.png" alt="lv-3" title="创作等级">
                    </span> <!----> <!----> 
                  </a>
                  <div class="position">{{userData.occupation}}</div>
                </div>
                   
            </a>
            </div>
          </div>
          <div class="right-dev-title">
            <span>本月热点</span>
          </div>
          
        </div>
        
      </div>
    </div>
  </div>
</template>

<script>
// import LeftMenuBar from '../../components/leftMenuBar.vue'
import { blogListApi,FirstcategoryList ,categoryListByPid,blogBycategory,ContributBlogger} from '@/api/blogapi'
import TimeDiff from "./TimeDiff";
export default {
  name: "belog",
  components: {
     TimeDiff
   },
  data () {
    return {
      msg: 'myblog',
      firstCatelist : [],
      childCatelist :[],
      //总行数
      itemCount:'',
      //当前博客集合
      blogList :[],
       count:10,  //默认加载数量
        isAchiveBottom: false, //滚动条是否到底部标志
        cates:"",//根据过滤查询
         //贡献博主列表
        ContrBloggerList:[]
    }
  },
     //在这里调用ajax请求方法
     created(){
      this.firstCate();
      this.list();
      this.gundongData();
      this.Blogger();
    },
  methods: {
      //点赞方法
      dianzan(){
     var dzbtn =  document.getElementById("dianzanbtn");
      if(this.$getToken()){
        startCheck({ blogId: this.blog.blogId }).then(async (res) => {
        if (res.code === 500) {
          this.$notify.error({
            title: "错误",
            message: res.msg,
          });
        } else if (res.code === 200) {
          if(res.data === "startNO"){
            // alert("取消点赞");
            dzbtn.className = "btn-ui-btn";
          }else if(res.data ==="startOK"){
            // alert("点赞点赞");
            dzbtn.className = "buttoncheck";
          }
          //更新数值
          this.getOneNum(this.blog.blogId);
        }
      });
    }
  },
    changeActive(e) {
      var dec = document.getElementById("headbigbar");
      var img = document.getElementById("blog-nav-box");
      dec.className = "red";
      img.src = "../../../static/assets/images/button/合并.png";
    },
    removeActive(e) {
      var dec = document.getElementById("headbigbar");
      var img = document.getElementById("blog-nav-box");
      img.src = "../../../static/assets/images/button/展开.png";
      dec.className = "headbigbar";
    },
    //获取一级分组列表
    firstCate() {
      FirstcategoryList().then(
        async (res) => {
          if (res.code === 500) {
            this.$notify.error({
               title: '错误',
              message: res.msg
        });
          } else if (res.code === 200) {
            this.firstCatelist = res.data;
          }
        },
      );
    },
    //通过上级菜单获取子集及更新数据
    childCateByid(id) {
      this.cates = id;
      //获取条件过滤后的博客列表
      this.listByParm(id);
      categoryListByPid({ categoryId: id}).then(
        async (res) => {
          if (res.code === 500) {
            this.$notify.error({
               title: '错误',
              message: res.msg
        });
          } else if (res.code === 200) {
            this.childCatelist = res.data;
          }
        },
        (err) => {
          this.$notify.error({
               title: '错误',
              message: res.msg
        });
        }
      );
    },
    //贡献博主接口
    Blogger(){
      ContributBlogger().then(
        async (res) => {
          if (res.code === 500) {
            this.$notify.error({
               title: '错误',
              message: res.msg
        });
          } else if (res.code === 200) {
            this.ContrBloggerList = res.data;
          }
        },
      );
    },
    list() {
      blogListApi(this.count).then(
        async (res) => {
          if (res.code === 500) {
            this.$notify.error({
               title: '错误',
              message: res.msg
        });
          } else if (res.code === 200) {
            this.itemCount = res.data.itemCount;
            this.blogList = res.data.listObject;
          }
        },
        (err) => {
          this.$notify.error({
               title: '错误',
              message: res.msg
        });
        }
      );
    },
     //滚动懒加载
     gundongData(){
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
            this.count+=10;
            var num = 1;
            if(this.itemCount > this.count-10){
              if(this.cates != ""){
                listByParm(this.cates);
              }else{
                this.list();
              }
            }

            this.isAchiveBottom = false;
          }, 200);
        }
      };
     },

    //根据点击上边的条件筛选查询
    listByParm(cates) {
      blogBycategory({
        'cates': cates,
        "pageSize":this.count
      }).then(
        async (res) => {
          if (res.code === 500) {
            this.$notify.error({
               title: '错误',
              message: res.msg
        });
          } else if (res.code === 200) {
            this.blogList = res.data.listObject;
          }
        },
      );
      // blogListBycategory({cates:cateId}).then(
      //   async (res) => {
      //     if (res.code === 500) {
      //       this.$notify.error({
      //          title: '错误',
      //         message: res.msg
      //   });
      //     } else if (res.code === 200) {
      //       this.blogList = res.data;
      //     }
      //   }
      // );
      // this.$axios
      //   .post ("/blog/list", {
      //     cates:cateId
      //   })
      //   .then((successResponse) => {
      //     if (successResponse.data.code === 200) {
      //        this.blogList = successResponse.data.data;
      //     }
      //   })
      //   .catch((failResponse) => {});
    },
    listByTate(id) {
      this.$axios
        .post ("/blog/list", {
          cates:id
        })
        .then((successResponse) => {
          if (successResponse.data.code === 200) {
             this.blogList = successResponse.data.data;
          }
        })
        .catch((failResponse) => {});
    },
    showtime(time) {
      let date =
        typeof time === "number"
          ? new Date(time)
          : new Date((time || "").replace(/-/g, "/"));
      let diff = (new Date().getTime() - date.getTime()) / 1000;
      let dayDiff = Math.floor(diff / 86400);

      let isValidDate =
        Object.prototype.toString.call(date) === "[object Date]" &&
        !isNaN(date.getTime());

      if (!isValidDate) {
        window.console.error("不是有效日期格式");
      }
      const formatDate = function(date) {
        let today = new Date(date);
        let year = today.getFullYear();
        let month = ("0" + (today.getMonth() + 1)).slice(-2);
        let day = ("0" + today.getDate()).slice(-2);
        let hour = today.getHours();
        let minute = today.getMinutes();
        let second = today.getSeconds();
        return `${year}-${month}-${day} ${hour}:${minute}:${second}`;
      };
         //小于0或者大于等于31显示原时间
      if (isNaN(dayDiff) || dayDiff < 0 || dayDiff >= 31) {
        return formatDate(date);
      }
      return (
        (dayDiff === 0 &&
          ((diff < 60 && "刚刚") ||
            (diff < 120 && "1分钟前") ||
            (diff < 3600 && Math.floor(diff / 60) + "分钟前") ||
            (diff < 7200 && "1小时前") ||
            (diff < 86400 && Math.floor(diff / 3600) + "小时前"))) ||
        (dayDiff === 1 && "昨天") ||
        (dayDiff < 7 && dayDiff + "天前") ||
        (dayDiff < 31 && Math.ceil(dayDiff / 7) + "周前")
      );
    },

  },
};

</script>

<style scoped>

.headbigbardiv {
  position: fixed;
    top: 4.2rem;
    width: 100%;
    height: 3.833rem;
    z-index: 100;
    box-shadow: 0 1px 2px 0 rgb(0 0 0 / 5%);
    transition: all .2s;
    transform: translateZ(0);
  padding: 10px 0px;
}
header {  
  background-color: aliceblue;
  width: 100%;
  padding: 0;
}
#blogdiv {
  width: 100%;
  margin: 0 auto;
  margin-top: 5.17rem;
  
}
ul {
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -ms-flex-wrap: wrap;
  flex-wrap: wrap;
  position: relative;
  padding-bottom: 8px;
  top: 0;
  padding: 0;
  margin: 0;
}
li {
  list-style: none;
}
#headbigbar li {
  white-space: nowrap;
  cursor: pointer;
  box-sizing: border-box;
  min-width: 80px;
  padding: 0 10px;
  height: 40px;
}
.headbarbg {
  margin: 10px 0;
  border-radius: 3px;
  -webkit-box-shadow: 0 4px 30px 0 rgb(232 232 237 / 50%);
}
.headbigbar {
  position:absolute;
  width: 100%;
  max-height: 50px;
  min-height: 50px;
  line-height: 50px;
  margin: 0;
  background-color: #fff;
  box-shadow: 0 1px 2px 0 rgb(0 0 0 / 5%);
    transition: all .2s;
  z-index: 10;
  overflow: hidden;
  transition:height 1s;
	-webkit-transition:height 0.2s; /* Safari */
  padding: 0px 6rem;
}
.headbigbar:hover{
  transition:height 1s;
	-webkit-transition:height 0.2s;
   min-height: 100px;
   max-height: 300px;
}

#headbigbar a {
  color: #222226;
  text-decoration: none;
}
#headbigbar a:hover {
  color: #000;
}
.childheaderdiv{
  width: 100%;
  margin-top: 8.5rem;
}
.headchildbar {
  width: 100%;
  padding: 0 6rem;
  display: flex;
    flex-wrap: wrap;
    min-height: 3.6rem;
    -webkit-transition: all .2s;
}
.tag {
    display: flex;
    justify-content: center;
    align-items: center;
     padding:  0 1rem;
  
    border-radius: 1rem;
    font-size: 1.1rem;
    color: #8a9aa9;
}

.articletext {
  width: 92%;
  margin-left: 2%;
}
.article {
  margin-left: 10px;
}
.article .title-class {
  color: #222226;
  font-size: 16px;
  font-family: PingFang SC,Hiragino Sans GB,Arial,Microsoft YaHei,Verdana,Roboto,Noto,Helvetica Neue,sans-serif;
}
.article .title-class:hover {
  border-bottom: #000 0.5px solid;
}
.navbar-transparent {
  background-color: #000;
}

.card-body {
  border-radius: 0;
  border-bottom: 0.6px rgb(112 128 142 / 10%) solid;
  padding: 1.25rem 1.25rem 1rem 1.25rem;
}
.right-dev {
  border-radius: 2px;
   margin-left: 1rem;
  height: 700px;
   border: 1px solid #fff;
  margin-bottom: 16px;
  padding: 0;
  width: 21%;
  background-color: #fff;
  -webkit-box-shadow: 0 1px 2px 0 rgb(0 0 0 / 5%);
    box-shadow: 0 1px 2px 0 rgb(0 0 0 / 5%);

}
.right-dev-title {
  width: 100%;
  margin: 0 auto;
  height: 48px;
  padding: 0 2rem;
  font-size: 18px;
  font-weight: 500;
  line-height: 48px;
  color: #222226;
  border-bottom: 1px solid #e8e8ed;
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-pack: justify;
  -ms-flex-pack: justify;
  justify-content: space-between;
  font-family: PingFang SC, Hiragino Sans GB, Arial, Microsoft YaHei, Verdana,
    Roboto, Noto, Helvetica Neue, sans-serif;
}
.user-list{
  width: 100%;
}
.user-info{
  overflow: hidden;
}
.avatar {
    flex: 0 0 auto;
    width: 3.8rem;
    height: 3.8rem;
    border-radius: 50%;
    margin-right: 0.5rem;
}
.user-list-item{
  padding: 0 2rem;
  height: 5rem;
  border-bottom: 1px solid #e8e8ed;
}
.link {
  height: 100%;
    padding: 1rem 0;
    display: flex;
    align-items: center;
    cursor: pointer;
}
.username {
    font-size: 1.16rem;
    font-weight: 400;
    color: #333;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
    margin-bottom: 3px;
}
.username .name {
    display: inline-block;
    vertical-align: top;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
}
.rank{
    display: inline-flex;
    align-items: center;
    margin-left: 0.33rem;
    vertical-align: middle;
}
.rank img {
    width: 35px;
    height: 16px;
}
.user-list-item:hover{
  background-color: #e8e8ed2a;
}
.right-dev-data {
  margin-top: 15px;
  width: 100%;
  padding: 0 10%;
}
.right-dev-data li {
  height: 80px;
}
.li-icon {
  width: 10%;
  float: left;
  height: 100%;
}
.li-text {
  width: 90%;
  float: right;
  padding: 0 5px;
}


.blog-nav-box {
  position: absolute;
  width: 4%;
  max-height: 30px;
  bottom: 0;
  left: 48%;
  background: #fff;
}



.blog-text{
 
  font-family:'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
  font-size: 14px;
overflow: hidden;
text-overflow: ellipsis;
display: -webkit-box;
-webkit-line-clamp: 2;
-webkit-box-orient: vertical;
text-decoration: none;
color: #000;
}
.blog-text-link{
  text-decoration:none;
  font-family: PingFang SC,Hiragino Sans GB,Arial,Microsoft YaHei,Verdana,Roboto,Noto,Helvetica Neue,sans-serif;
  color:#555666;
font-size: 12px;
}
.articletext:hover{
 background-color: rgba(216, 214, 214, 0.105);
}


.show-data{
  width: 100%;
  padding: 1rem 18rem;
  margin: 0 auto;
}
.left-data-article{
  width: 76%;
  overflow:auto;
  height: auto;
  background-color: #fff;
    -webkit-box-shadow: 0 1px 2px 0 rgb(0 0 0 / 5%);
    box-shadow: 0 1px 2px 0 rgb(0 0 0 / 5%);
    padding: 1rem 2rem;
}
.user-message,.meta-container,.action-list{
  display: flex;
    align-items: center;
    font-size: 12px;
    line-height: normal;
}
.action-list{
  padding: 5px 0px 0px  0px;

}

.action-list .item {
    position: relative;
    margin-right: 30px;
    font-size: 13px;
    line-height: 20px;
    color: #4e5969;
    flex-shrink: 0;
}
.dividing{
    width: 1px;
    height: 14px;
    background: #e5e6eb;
    margin: 0 8px;
}
.date {
    line-height: 22px;
    font-size: 8px;
    color: #86909c;
}
@media (max-width:960px){
  .right-dev {
    display: none;
  }
  .left-data-article{
    width: 100%;
   }
   .show-data{
    width: 100%;
  padding: 10px;
  margin: 0 auto;
   }
 .headbigbar {
    position: absolute;
    width: 100%;
   
  max-height: 50px;
  line-height: 50px;
  margin: 0;
  background-color: #fff;
  box-shadow: 0 1px 2px 0 rgb(0 0 0 / 5%);
    transition: all .2s;
  z-index: 10;
  overflow: hidden;
  transition:height 1s;
	-webkit-transition:height 0.2s; /* Safari */
 
     padding: 0px 10px;
   }
   .headbigbar:hover{
  transition:height 1s;
	-webkit-transition:height 0.2s;
  min-height: 200px;
  max-height: 500px;
}
   .headchildbar  {
    width: 100%;
    padding: 0 1rem;
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    -ms-flex-wrap: wrap;
    flex-wrap: wrap;
    min-height: 3.6rem;
    -webkit-transition: all .2s;
}
}
</style>
