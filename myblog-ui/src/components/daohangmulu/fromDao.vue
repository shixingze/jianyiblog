<template>
    <div class="hello">
        <!-- 固定于屏幕右下方的一个悬浮按钮 -->
		<div class="fixed-action-btn">
			<a class="btn-floating btn-large blue z-depth-4">
				<i class="large material-icons">apps</i>
			</a>
			<ul>
				<!-- 文章目录按钮 -->
				<li class="category-btn hide">
					<a class="sidenav-trigger btn-floating blue lighten-2" data-target="category">
						<i class="material-icons">format_list_bulleted</i>
					</a>
				</li>
		 	<!-- 下面也可以添加其他按钮，如返回文章顶部等-->
				<li>
					<a class="btn-floating blue lighten-2" href="javascript: scrollTo(0, 0);">
						<i class="material-icons">publish</i>
					</a>
				</li>
			</ul>
		</div>

		<!-- 文章目录侧栏 -->
		<ul id="category" class="hide sidenav grey lighten-4 grey-text text-darken-3">
			<li>
				<p class="center-align">目录</p>
			</li>
		</ul>
      <div id="post-content">
       <div v-html="this.text"></div>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    props: {
    blogData: {},
  },
    name: 'HelloWorld',
    data () {
      return {
        msg: 'Welcome to Your Vue.js App',
        text:'<p><br></p><h2 style="text-align: start;">什么是Java语言</h2><h2 style="text-align: start;"><span style="color: rgb(68, 68, 68); background-color: rgb(255, 255, 255); font-size: 14px;">简单地说，Java 是由 Sun Microsystems 公司于 1995 年推出的一门面向对象程序设计语言。2010 年 Oracle 公司收购 Sun Microsystems，之后由 Oracle 公司负责 Java 的维护和版本升级。<br><br>其实，Java 还是一个平台。</span><span style="color: rgb(178, 34, 34); background-color: rgb(255, 255, 255); font-size: 14px;">Java 平台由 Java 虚拟机（Java Virtual Machine，JVM）和 Java 应用编程接口（Application Programming Interface，API）构成。</span><span style="color: rgb(68, 68, 68); background-color: rgb(255, 255, 255); font-size: 14px;">Java 应用编程接口为此提供了一个独立于操作系统的标准接口，可分为基本部分和扩展部分。在硬件或操作系统平台上安装一个 Java 平台之后，Java 应用程序就可运行。<br><br>Java 平台已经嵌入了几乎所有的操作系统。这样 Java 程序只编译一次，就可以在各种系统中运行。Java 应用编程接口已经从 1.1x 版本发展到 1.2 版本。常用的 Java 平台基于 Java 1.6，最新版本为 Java 1.8。<br><br>Java 发展至今，就力图使之无所不能。在世界编程语言排行榜中，近年来 Java 一直稳居第一名，比第二名的C语言高出几个百分点。<br><br></span></h2><p><img src="http://c.biancheng.net/uploads/allimg/200103/5-2001031G545249.png" alt="世界编程语言排行榜" data-href="" style="width: 30%;"/><br><span style="color: rgb(178, 34, 34); background-color: rgb(255, 255, 255); font-size: 14px;">按应用范围，Java 可分为 3 个体系，即 Java SE、Java EE 和 Java ME。</span><span style="color: rgb(68, 68, 68); background-color: rgb(255, 255, 255); font-size: 14px;">下面简单介绍这 3 个体系。</span></p><h4 style="text-align: start;">1. Java SE<span style="color: rgb(0, 100, 0); background-color: rgb(255, 255, 255); font-size: 14px;">Java SE（Java Platform Standard Edition，Java 平台标准版）</span><span style="color: rgb(68, 68, 68); background-color: rgb(255, 255, 255); font-size: 14px;">以前称为 J2SE，它允许开发和部署在桌面、服务器、嵌入式环境和实时环境中使用的 Java 应用程序。Java SE 包含了支持 Java Web 服务开发的类，并为 Java EE 提供基础，如 Java 语言基础、JDBC 操作、I/O 操作、网络通信以及多线程等技术。图 1 所示为 Java SE 的体系结构。<br><br></span></h4><p><br>图1 Java SE的体系结构（<a href="http://c.biancheng.net/uploads/allimg/190903/5-1ZZ3155933O7.jpg" target="">点此查看原图</a>）</p><h4 style="text-align: start;">2. Java EE<span style="color: rgb(0, 100, 0); background-color: rgb(255, 255, 255); font-size: 14px;">Java EE（Java Platform Enterprise Edition，Java 平台企业版）</span><span style="color: rgb(68, 68, 68); background-color: rgb(255, 255, 255); font-size: 14px;">以前称为 J2EE。企业版本帮助开发和部署可移植、健壮、可伸缩且安全的服务器端 Java 应用程序。</span><span style="color: rgb(178, 34, 34); background-color: rgb(255, 255, 255); font-size: 14px;">Java EE 是在 Java SE 基础上构建的，它提供 Web 服务、组件模型、管理和通信 API，可以用来实现企业级的面向服务体系结构（Service Oriented Architecture，SOA）和 Web 2.0 应用程序。</span></h4><h4 style="text-align: start;">3. Java ME<span style="color: rgb(0, 100, 0); background-color: rgb(255, 255, 255); font-size: 14px;">Java ME（Java Platform Micro Edition，Java 平台微型版）</span><span style="color: rgb(68, 68, 68); background-color: rgb(255, 255, 255); font-size: 14px;">以前称为 J2ME，也叫 K-JAVA。 Java ME 为在移动设备和嵌入式设备（比如手机、PDA、电视机顶盒和打印机）上运行的应用程序提供一个健壮且灵活的环境。<br><br></span><span style="color: rgb(178, 34, 34); background-color: rgb(255, 255, 255); font-size: 14px;">Java ME 包括灵活的用户界面、健壮的安全模型、丰富的内置网络协议以及对可以动态下载的联网和离线应用程序。</span><span style="color: rgb(68, 68, 68); background-color: rgb(255, 255, 255); font-size: 14px;">基于 Java ME 规范的应用程序 只需编写一次就可以用于许多设备，而且可以利用每个设备的本机功能。</span></h4><h2 style="text-align: start;">Java语言的特点</h2>'
      }
    },
     //在这里调用ajax请求方法
//   created() {
//     initDao()
//   },
  mounted () { //这个属性就可以，在里面声明初始化时要调用的方法即可
      // we can implement any method here like
      this.initDao()
    },
    methods: {
     initDao(){
        // 初始化第三方库的插件
		M.AutoInit();
		document.addEventListener('DOMContentLoaded', function() {
			var elemCategory = document.querySelector('#category');
			M.Sidenav.init(elemCategory, {
				'edge': 'right' // right 表示在右侧栏显示，left 则表示在左边显示
			});
		});
		var postContent = document.querySelector('#post-content');

		if (postContent) { // 存在文章内容
			var categories = postContent.querySelectorAll('h1, h2, h3, h4, h5, h6');

			if (categories.length > 0) { // 文章存在标题
				var category = document.querySelector('#category'),
					categoryBtn = document.querySelector('.category-btn');
				var li = document.createElement('li'),
					a = document.createElement('a');

				a.className = 'waves-effect';
				// 存在目录则显示目录按钮和侧栏
		 	category.classList.remove('hide');
		 	categoryBtn.classList.remove('hide');

				categories.forEach(node => {
					// 每次 cloneNode 取代 createElement
		 		// 因为克隆一个元素快于创建一个元素
					var _li = li.cloneNode(false),
						_a = a.cloneNode(false);

					_a.innerText = node.innerText;
					// 为标题设置跳转链接
					_a.href = '#' + node.id;
					_li.appendChild(_a);
					// 为不同级别标题应用不同的缩进
					_li.style.paddingLeft = node.nodeName.slice(-1) * 32 + 'px';
					category.appendChild(_li);
				})
			}
		}
     }
    }
    
  }
  </script>
  
  <!-- Add "scoped" attribute to limit CSS to this component only -->
  <style scoped>
			#category li a:before {
				/* 添加一个折叠符号，为了好看 */
			 content: "∟";
				position: absolute;
				left: 10px;
				bottom: 5px;
				font-size: 12px;
			}
  </style>
  