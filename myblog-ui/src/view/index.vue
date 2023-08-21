<template>
  <div>

    <main class="main">
      <section
        class="spotlight parallax bg-cover bg-size--cover"
        data-spotlight="fullscreen"
        style="
          background-image: url('../../static/assets/images/backgrounds/bg3.jpg');
        "
      >
        <span class="mask bg-primary alpha-7"></span>
        <div class="spotlight-holder py-lg pt-lg-xl">
          <div class="container d-flex align-items-center no-padding">
            <div class="col">
              <div
                class="
                  row
                  cols-xs-space
                  align-items-center
                  text-center text-md-left
                  justify-content-center
                "
              >
                <div class="col-7">
                  <div class="text-center mt-5">
                    <img
                      src="../../static/assets/images/jianyi.png"
                      style="width: 400px;margin: auto;"
                      class="img-fluid animated"
                      data-animation-in="jackInTheBox"
                      data-animation-delay="1000"
                    />
                    <h2
                      class="
                        heading
                        display-4
                        font-weight-400
                        text-white
                        mt-5
                        animated
                      "
                      data-animation-in="fadeInUp"
                      data-animation-delay="2000"
                    >
                      <span class="font-weight-700">Personal </span>blog website
                    </h2>
                    <p
                      class="lead text-white mt-3 lh-180 c-white animated"
                      data-animation-in="fadeInUp"
                      data-animation-delay="2500"
                    >
                      Free HTML UI Kit based on the well known Bootstrap 4
                      <strong class="text-white">Webpixels</strong>
                    </p>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
      <section class="slice slice-lg pt-lg-6 pb-lg-6 bg-section-secondary">
        <div class="container">
          <!-- Title -->
          <!-- Section title -->
          <div class="row mb-5 justify-content-center text-center">
            <div class="col-lg-6">
              <span class="badge badge-soft-success badge-pill badge-lg">
                Get belog go
              </span>
              <h2 class="mt-4">本站每周热门资源呈现</h2>
              <div class="mt-2">
                <p class="lead lh-180">
                  Weekly hot resource presentation on this site
                </p>
              </div>
            </div>
          </div>
          <!-- Card -->
          <div class="row mt-5">
            <div class="col-md-4"  style="margin-top: 10px;" v-for="item in hotblogsix" :key="item.blogId">
              <div class="card">
                <div class="card-body pb-5">
                  <div class="pt-4 pb-5 card-img" style="padding-top: 0px;">
                    <img
                      :src="'/api/'+item.blogCover"
                      class="img-fluid img-center"
                      style="height: 100px"
                      alt="Illustration"
                    />
                  </div>
      
                  <router-link   :to="'/belog/show/?blogId='+item.blogId" target="_blank" ><h5 class="h5 lh-130 mb-3 card-body-title">{{item.blogTitle}}</h5></router-link>
                  <p class="text-muted mb-0 card-body-text">
                     {{item.blogAbstract}}
                  </p>
                    <div class="card-body-icon row">
                      <span > <i class="iconfont icon-dianzan"></i>{{item.blogLike}}</span>
                      <span ><i class="iconfont icon-xiaoxi"></i> {{item.blogComments}}</span>
                      <span ><i class="iconfont icon-yulan"></i> {{item.blogBrowsing}}</span>
                    </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        
      </section>
      <div class="music-div">
        <div class="music-gun-div">
             <div class="str_wrap">
              <iframe frameborder="no" border="0" marginwidth="0" marginheight="0" width=330 height=86 src="//music.163.com/outchain/player?type=2&id=1403318151&auto=1&height=66">
              </iframe>
             </div>
        </div>     
      </div>
      
     <header>
    <div class="jumbotron jumbotron-lg jumbotron-fluid mb-0 pb-3 bg-primary position-relative">
        <div class="container-fluid text-white h-100">
            <div class="d-lg-flex align-items-center justify-content-between text-center pl-lg-5">
                <div class="col pt-4 pb-4">
                    <h1 class="display-3">Build something <strong>nice</strong> & easy</h1>
                    <h5 class="font-weight-light mb-4">With this FREE Bootstrap 4.1.3<strong> UI Kit</strong> & <strong><i class="fab fa-sass fa-2x text-info"></i></strong></h5>
                    <a href="#" class="btn btn-lg btn-outline-white btn-round">Learn more</a>
                </div>
                <div class="col align-self-bottom align-items-right text-right h-max-380 h-xl-560 position-relative z-index-1">
                    <img src="../../static/assets/images/prv/device-1.png" style="width: 400px;" class="rounded img-fluid">
                </div>
            </div>
        </div>
    </div>
</header>
    </main>
    <footer class="pt-5 pb-3 footer  footer-dark bg-tertiary">
      <div class="container">
        <div class="row">
          <div class="col-12 col-md-4">
            <div class="pr-lg-5">
              <h1 class="heading h6 text-uppercase font-weight-700 mb-3"><strong>Boomerang</strong> UI Kit</h1>
              <p>Boomerang is a high quality UI Kit built on top of the well known Bootstrap 4 Framework. This theme was designed as its own extended version of Bootstrap with multiple functionalities and controls added, extended color palette and beautiful typography.</p>
            </div>
          </div>
          <div class="col-6 col-md">
            <h5 class="heading h6 text-uppercase font-weight-700 mb-3">联系方式</h5>
            <ul class="list-unstyled text-small">
              <li><a class="text-muted" href="#">QQ   1731150369</a></li>
              <li><a class="text-muted" href="#">PHONE   17736590607</a></li>
              <li><a class="text-muted" href="#">WE-CAT   ze_213</a></li>
              <li><a class="text-muted" href="#">E-MAIL 1731150369@qq.com</a></li>
              <!-- <li><a class="text-muted" href="#">Another one</a></li>
              <li><a class="text-muted" href="#">Last time</a></li> -->
            </ul>
          </div>
          <div class="col-6 col-md">
            <h5 class="heading h6 text-uppercase font-weight-700 mb-3">Solutions</h5>
            <ul class="list-unstyled text-small">
              <li><a class="text-muted" href="#">Resource</a></li>
              <li><a class="text-muted" href="#">Resource name</a></li>
              <li><a class="text-muted" href="#">Another resource</a></li>
              <li><a class="text-muted" href="#">Final resource</a></li>
            </ul>
          </div>
          <div class="col-6 col-md">
            <h5 class="heading h6 text-uppercase font-weight-700 mb-3">Resources</h5>
            <ul class="list-unstyled text-small">
              <li><a class="text-muted" href="#">Business</a></li>
              <li><a class="text-muted" href="#">Education</a></li>
              <li><a class="text-muted" href="#">Government</a></li>
              <li><a class="text-muted" href="#">Gaming</a></li>
            </ul>
          </div>
          <div class="col-6 col-md">
            <h5 class="heading h6 text-uppercase font-weight-700 mb-3">About</h5>
            <ul class="list-unstyled text-small">
              <li><a class="text-muted" href="#">Team</a></li>
              <li><a class="text-muted" href="#">Locations</a></li>
              <li><a class="text-muted" href="#">Privacy</a></li>
              <li><a class="text-muted" href="#">Terms</a></li>
            </ul>
          </div>
        </div>
        <hr>
        <div class="d-flex align-items-center">
          <span class="">
            &copy; 2018 <a href="https://webpixels.io/" class="footer-link" target="_blank">Webpixels</a>. All rights reserved.
          </span>
          <ul class="nav ml-lg-auto">
            <li class="nav-item">
              <a class="nav-link active" href="https://instagram.com/webpixelsofficial" target="_blank"><i class="fab fa-instagram"></i></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="https://facebook.com/webpixels" target="_blank"><i class="fab fa-facebook"></i></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="https://github.com/webpixels" target="_blank"><i class="fab fa-github"></i></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="https://dribbble.com/webpixels" target="_blank"><i class="fab fa-dribbble"></i></a>
            </li>
          </ul>
        </div>
      </div>
    </footer>
  </div>
</template>

<script>
import {blogHotSix} from '@/api/home'
export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: 'myblog',
      hotblogsix : [],
      
    }
  },
  
    //在这里调用ajax请求方法
    created(){
      this.hotsix();
      this.setBar();
    },

  methods: {
  
    hotsix() {
      blogHotSix().then(
        async (res) => {
          if (res.code === 500) {
            this.$notify.error({
               title: '错误',
              message: res.msg
        });
          } else if (res.code === 200) {
            this.hotblogsix = res.data
          }
        },
        (err) => {
          // console.log(err.msg);
          this.password = "";
          // this.$message.error(err.msg);
        }
      );

      // this.$axios
      //   .get("/blog/hotsix", {
      //   })
      //   .then((successResponse) => {
      //     if (successResponse.data.code === 200) {
      //        this.bloghotsix = successResponse.data.data;
      //        console.log( this.bloghotsix);
      //       // this.$notify({
      //       //   title: "成功",
      //       //   message: successResponse.data.msg,
      //       //   type: "success",
      //       // });
      //     }
      //   })
      //   .catch((failResponse) => {});
    },
  }
  
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.head{
    position: fixed;
    top: 0;
    left: 0;
    height: 5rem;
    z-index: 999;
}
header{
  display: block;
}
.main-header.visible {
    transform: translateZ(0);
}
.main-header {
    position: fixed;
    top: 0;
    left: 0;
    right: 0;
    transition: all .2s;
    transform: translate3d(0,-100%,0);
}
.main-header {
    background: var(--juejin-navigation);
    /* border-bottom: 1px solid #f1f1f1; */
    color: #909090;
    height: 5rem;
    z-index: 250;
}



.main{
  position: relative;
    margin: 0 auto;
    width: 100%;
 
}
.ic{
  float: left;
}
.musicbar {
  max-width: 80%;
  margin: 10px auto;
}
.card-body{
  max-height: 400px;
  min-height: 223px;
}
.card-body:hover{
  /* border: 1px solid darkgray; */
  box-shadow: 0 8px 16px 0 rgb(0 0 0 / 5%);
}
.card-body-title{
  text-overflow: -o-ellipsis-lastline;
overflow: hidden;
text-overflow: ellipsis;
display: -webkit-box;
-webkit-line-clamp: 2;
-webkit-box-orient: vertical;
float: left;
width: 60%;
}
.card-body-text{
  text-overflow: -o-ellipsis-lastline;
overflow: hidden;
text-overflow: ellipsis;
display: -webkit-box;
-webkit-line-clamp: 4;
-webkit-box-orient: vertical;
float: left;
width: 70%;
}
.card-body-icon{
  width: 85%;
  padding: 0 10px;
  margin: 0 auto;
  position: absolute;
  bottom: 9px;
}
.card-img{
  float: left;
  width: 28%;
  padding-top: 0px;
  margin-right: 5px;
}

.card-body-icon span{
  width: 33%;
  padding: 10px 10px;
}

.music-div{
height: 357px;
background:#f1f3f6;

}
.music-gun-div{
  position: relative;
  display: flex;
  width: 70%;
  min-width: 70%;
  align-items: center;
  margin: 0 auto;
  height: 100%;
}
.str_wrap{
  overflow: hidden;
  width: 100%;
  height: 100%;
  font-size: 1rem;
  line-height: 1rem;
  position: relative;
  white-space: nowrap;
  display: flex;
    flex-direction: column;
  justify-content: center;
  align-items: center;
}
@media screen and (max-width: 720px) {
  .mask{
          width: 100%;
        }
          
      }
</style>
