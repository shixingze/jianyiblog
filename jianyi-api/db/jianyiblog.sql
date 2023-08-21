/*
 Navicat Premium Data Transfer

 Source Server         : mysql57
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : jianyiblog

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 07/03/2023 17:19:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog`  (
  `blog_id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `blog_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '标题',
  `blog_content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '博文内容',
  `blog_like` bigint NULL DEFAULT NULL COMMENT '点赞数',
  `blog_comments` bigint NULL DEFAULT NULL COMMENT '评论数',
  `blog_browsing` bigint NULL DEFAULT NULL COMMENT '浏览量',
  `blog_abstract` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '文章摘要',
  `blog_cover` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '博文封面',
  `CREATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新时间',
  `cates` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`blog_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '博客文章表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES (9, 'JAVA 基础', '<p><br></p><h2 style=\"text-align: start;\">什么是Java语言</h2><h2 style=\"text-align: start;\"><span style=\"color: rgb(68, 68, 68); background-color: rgb(255, 255, 255); font-size: 14px;\">简单地说，Java 是由 Sun Microsystems 公司于 1995 年推出的一门面向对象程序设计语言。2010 年 Oracle 公司收购 Sun Microsystems，之后由 Oracle 公司负责 Java 的维护和版本升级。<br><br>其实，Java 还是一个平台。</span><span style=\"color: rgb(178, 34, 34); background-color: rgb(255, 255, 255); font-size: 14px;\">Java 平台由 Java 虚拟机（Java Virtual Machine，JVM）和 Java 应用编程接口（Application Programming Interface，API）构成。</span><span style=\"color: rgb(68, 68, 68); background-color: rgb(255, 255, 255); font-size: 14px;\">Java 应用编程接口为此提供了一个独立于操作系统的标准接口，可分为基本部分和扩展部分。在硬件或操作系统平台上安装一个 Java 平台之后，Java 应用程序就可运行。<br><br>Java 平台已经嵌入了几乎所有的操作系统。这样 Java 程序只编译一次，就可以在各种系统中运行。Java 应用编程接口已经从 1.1x 版本发展到 1.2 版本。常用的 Java 平台基于 Java 1.6，最新版本为 Java 1.8。<br><br>Java 发展至今，就力图使之无所不能。在世界编程语言排行榜中，近年来 Java 一直稳居第一名，比第二名的C语言高出几个百分点。<br><br></span></h2><p><img src=\"http://c.biancheng.net/uploads/allimg/200103/5-2001031G545249.png\" alt=\"世界编程语言排行榜\" data-href=\"\" style=\"width: 30%;\"/><br><span style=\"color: rgb(178, 34, 34); background-color: rgb(255, 255, 255); font-size: 14px;\">按应用范围，Java 可分为 3 个体系，即 Java SE、Java EE 和 Java ME。</span><span style=\"color: rgb(68, 68, 68); background-color: rgb(255, 255, 255); font-size: 14px;\">下面简单介绍这 3 个体系。</span></p><h4 style=\"text-align: start;\">1. Java SE<span style=\"color: rgb(0, 100, 0); background-color: rgb(255, 255, 255); font-size: 14px;\">Java SE（Java Platform Standard Edition，Java 平台标准版）</span><span style=\"color: rgb(68, 68, 68); background-color: rgb(255, 255, 255); font-size: 14px;\">以前称为 J2SE，它允许开发和部署在桌面、服务器、嵌入式环境和实时环境中使用的 Java 应用程序。Java SE 包含了支持 Java Web 服务开发的类，并为 Java EE 提供基础，如 Java 语言基础、JDBC 操作、I/O 操作、网络通信以及多线程等技术。图 1 所示为 Java SE 的体系结构。<br><br></span></h4><p><br>图1 Java SE的体系结构（<a href=\"http://c.biancheng.net/uploads/allimg/190903/5-1ZZ3155933O7.jpg\" target=\"\">点此查看原图</a>）</p><h4 style=\"text-align: start;\">2. Java EE<span style=\"color: rgb(0, 100, 0); background-color: rgb(255, 255, 255); font-size: 14px;\">Java EE（Java Platform Enterprise Edition，Java 平台企业版）</span><span style=\"color: rgb(68, 68, 68); background-color: rgb(255, 255, 255); font-size: 14px;\">以前称为 J2EE。企业版本帮助开发和部署可移植、健壮、可伸缩且安全的服务器端 Java 应用程序。</span><span style=\"color: rgb(178, 34, 34); background-color: rgb(255, 255, 255); font-size: 14px;\">Java EE 是在 Java SE 基础上构建的，它提供 Web 服务、组件模型、管理和通信 API，可以用来实现企业级的面向服务体系结构（Service Oriented Architecture，SOA）和 Web 2.0 应用程序。</span></h4><h4 style=\"text-align: start;\">3. Java ME<span style=\"color: rgb(0, 100, 0); background-color: rgb(255, 255, 255); font-size: 14px;\">Java ME（Java Platform Micro Edition，Java 平台微型版）</span><span style=\"color: rgb(68, 68, 68); background-color: rgb(255, 255, 255); font-size: 14px;\">以前称为 J2ME，也叫 K-JAVA。 Java ME 为在移动设备和嵌入式设备（比如手机、PDA、电视机顶盒和打印机）上运行的应用程序提供一个健壮且灵活的环境。<br><br></span><span style=\"color: rgb(178, 34, 34); background-color: rgb(255, 255, 255); font-size: 14px;\">Java ME 包括灵活的用户界面、健壮的安全模型、丰富的内置网络协议以及对可以动态下载的联网和离线应用程序。</span><span style=\"color: rgb(68, 68, 68); background-color: rgb(255, 255, 255); font-size: 14px;\">基于 Java ME 规范的应用程序 只需编写一次就可以用于许多设备，而且可以利用每个设备的本机功能。</span></h4><h2 style=\"text-align: start;\">Java语言的特点</h2>', 15, 12, 189, '其实，Java 还是一个平台。Java 平台由 Java 虚拟机（Java Virtual Machine，JVM）和 Java 应用编程接口（Application Programming Interface，API）构成。Java 应用编程接口为此提供了一个独立于操作系统的标准接口，可分为基本部分和扩展部分。在硬件或操作系统平台上安装一个 Java 平台之后，Java 应用程序就可运行。', 'cover/1662082487496img3.jpg', 'admin', '2022-09-02 09:34:51', 'admin', '2022-09-02 09:34:51', NULL);
INSERT INTO `blog` VALUES (10, 'LINUX 常用指令', '<h2>查看防火墙指令</h2><p>firewall-cmd --state</p><h2>关闭防火墙</h2><p>systemctl stop firewalld</p><h2>永久关闭</h2><p>systemctl disable firewalld</p><h2>打开</h2><p>systemctl start firewalld</p><p><strong>192.168.122.1</strong></p><p><span style=\"color: rgb(0, 119, 170);\">ALTER</span> SYSTEM <span style=\"color: rgb(0, 119, 170);\">ADD</span> BACKEND <span style=\"color: rgb(102, 153, 0);\">\"</span>192.168.122.1<span style=\"color: rgb(102, 153, 0);\">:9050\"</span><span style=\"color: rgb(153, 153, 153);\">;</span></p><h2>解压</h2><p>j解压 gz &nbsp; tar -zxvf 名称</p><h2>开放端口</h2><h2>添加指定需要开放的端口：</h2><p>firewall-cmd --add-port=123/tcp --permanent</p><h2>重载入添加的端口：</h2><p>firewall-cmd --reload</p><p>查询指定端口是否开启成功：</p><p>firewall-cmd --query-port=123/tcp</p><p>查找文件</p><p><span style=\"color: rgb(51, 51, 51); background-color: rgb(255, 255, 255); font-family: Arial;\">find / -name</span></p><p><span style=\"color: rgb(51, 51, 51); background-color: rgb(255, 255, 255); font-family: Arial;\"><br></span></p><p><span style=\"color: rgb(51, 51, 51); background-color: rgb(255, 255, 255); font-family: Arial;\">查看各磁盘内存占用</span></p><p><span style=\"color: rgb(51, 51, 51); background-color: rgb(255, 255, 255);\">df -Th</span></p><p><span style=\"color: rgb(51, 51, 51); background-color: rgb(255, 255, 255);\">查看当前路径下文件所占内存大小</span></p><p><span style=\"color: rgb(51, 51, 51); background-color: rgb(255, 255, 255);\">输入: du --max-depth=1 -h 查看当前文件夹下面各个文件或则文件夹大小</span></p><p><span style=\"color: rgb(51, 51, 51); background-color: rgb(255, 255, 255);\"><br></span></p><p><span style=\"background-color: rgb(255, 255, 255);\">查看端口与服务：</span></p><p><span style=\"background-color: rgb(255, 255, 255);\">netstat -anp</span></p><p><span style=\"background-color: rgb(255, 255, 255);\">查看端口命令</span></p><p><span style=\"color: rgb(77, 77, 77); background-color: rgb(255, 255, 255); font-size: 16px;\">lsof -i:端口号</span></p><p><span style=\"color: rgb(77, 77, 77); background-color: rgb(255, 255, 255); font-size: 16px;\">netstat -ntlp //查看当前所有tcp端口·</span></p><p><span style=\"color: rgb(77, 77, 77); background-color: rgb(255, 255, 255); font-size: 16px;\">netstat -ntulp |grep 80 //查看所有80端口使用情况·</span></p><p><span style=\"color: rgb(77, 77, 77); background-color: rgb(255, 255, 255); font-size: 16px;\">netstat -an | grep 3306 //查看所有3306端口使用情况·</span></p><p><span style=\"color: rgb(77, 77, 77); background-color: rgb(255, 255, 255); font-size: 16px;\"><br></span></p><p>172.25.50.191</p><p><span style=\"color: rgb(0, 119, 170);\">ALTER</span> SYSTEM <span style=\"color: rgb(0, 119, 170);\">ADD</span> BACKEND <span style=\"color: rgb(102, 153, 0);\">\"</span>172.25.50.191<span style=\"color: rgb(102, 153, 0);\">:9050\"</span><span style=\"color: rgb(153, 153, 153);\">;</span></p><p><span style=\"color: rgb(94, 94, 94); background-color: rgb(255, 255, 255); font-size: 13px;\">netstat &nbsp; -nultp</span></p><p><span style=\"color: rgb(77, 77, 77); background-color: rgb(255, 255, 255);\">mysql当前状态</span></p><p><span style=\"background-color: rgb(254, 254, 242); font-family: Verdana;\"> service mysqld status</span></p><p><span style=\"background-color: rgb(254, 254, 242); font-family: Verdana;\"><br></span></p><p><span style=\"background-color: rgb(254, 254, 242); font-family: Verdana;\">后台启动sh文件</span></p><p><span style=\"font-size: 12px;\">nohup sh carte.sh pwd/carte-config-master-18080.xml &amp;</span></p><p><span style=\"font-size: 12px;\"><br></span></p><p><span style=\"font-size: 12px;\"><br></span></p><p><span style=\"font-size: 12px;\"><br></span></p><p>bin/start_fe.sh --daemon</p><p><br></p><p>回车</p><p><br></p><p><span style=\"font-size: 12px;\">查看文件权限</span></p><p><span style=\"color: rgb(51, 51, 51); background-color: rgb(255, 255, 255); font-size: 16px;\">ls -l</span></p><p><span style=\"color: rgb(51, 51, 51); background-color: rgb(255, 255, 255); font-size: 16px;\">ll</span></p><p><span style=\"color: rgb(51, 51, 51); background-color: rgb(255, 255, 255); font-size: 16px;\">文件授权</span></p><p><span style=\"color: rgb(77, 77, 77); background-color: rgb(255, 255, 255); font-size: 16px;\">chmod 777</span></p><p>查看软件安装后产生的文件</p><p>rpm -ql mysql-8.0.26-1.module_el8.4.0+915+de215114.x86_64</p><p><br></p><p><span style=\"background-color: rgb(255, 255, 255);\">看到正在运行的sh脚本</span></p><p><span style=\"background-color: rgb(255, 255, 255);\"><br></span></p><p><span style=\"color: rgb(0, 119, 170);\">ALTER</span> SYSTEM <span style=\"color: rgb(0, 119, 170);\">ADD</span> BACKEND <span style=\"color: rgb(102, 153, 0);\">\"172.25.50.191:9050\"</span><span style=\"color: rgb(153, 153, 153);\">;</span></p><p><span style=\"color: rgb(153, 153, 153);\"><br></span></p><p><span style=\"color: rgb(153, 153, 153);\">安装mirrodb</span></p><p><span style=\"color: rgb(51, 51, 51); background-color: rgb(255, 255, 255); font-family: Arial;\">yum install mariadb-server</span></p><p><span style=\"color: rgb(51, 51, 51); background-color: rgb(255, 255, 255); font-family: Arial;\"><br></span></p><p><span style=\"color: rgb(51, 51, 51); background-color: rgb(255, 255, 255); font-family: Arial;\">查看centos版本</span></p><p><span style=\"color: rgb(153, 153, 153); background-color: rgb(45, 45, 45);\">cat /etc/centos-release</span></p><p><span style=\"color: rgb(153, 153, 153); background-color: rgb(45, 45, 45);\"><br></span></p><p><span style=\"color: rgb(153, 153, 153); background-color: rgb(45, 45, 45);\"><br></span></p><p><span style=\"color: rgb(153, 153, 153); background-color: rgb(45, 45, 45);\"><br></span></p><p><span style=\"color: rgb(153, 153, 153); background-color: rgb(45, 45, 45);\">查看正在运行的程序</span></p><p><span style=\"font-size: 12px;\">ps -aux</span></p><p><span style=\"font-size: 12px;\"><br></span></p><p><span style=\"font-size: 12px;\"><br></span></p>', 4, 0, 300, 'Linux 内核最初只是由芬兰人林纳斯·托瓦兹（Linus Torvalds）在赫尔辛基大学上学时出于个人爱好而编写的。\n\nLinux 是一套免费使用和自由传播的类 Unix 操作系统，是一个基于 POSIX 和 UNIX 的多用户、多任务、支持多线程和多 CPU 的操作系统。\n\nLinux 能运行主要的 UNIX 工具软件、应用程序和网络协议。它支持 32 位和 64 位硬件。Linux 继承了 Unix 以网络为核心的设计思想，是一个性能稳定的多用户网络操作系统。', 'cover/1662087468654linux.jpg', 'admin', '2022-09-02 10:57:53', 'admin', '2022-09-02 10:57:53', NULL);
INSERT INTO `blog` VALUES (11, 'CSS 教程嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻', '<p><br></p><h2 style=\"text-align: start;\">外部样式表</h2><p style=\"text-align: start;\">当样式需要应用于很多页面时，外部样式表将是理想的选择。在使用外部样式表的情况下，你可以通过改变一个文件来改变整个站点的外观。每个页面使用 &lt;link&gt; 标签链接到样式表。 &lt;link&gt; 标签在（文档的）头部：</p><p style=\"text-align: start;\"><span style=\"color: olive;\">&lt;</span><span style=\"color: green;\">head</span><span style=\"color: olive;\">&gt;</span><span style=\"color: gray;\"> </span><span style=\"color: olive;\">&lt;</span><span style=\"color: green;\">link</span><span style=\"color: gray;\"> </span><span style=\"color: rgb(0, 0, 139);\">rel</span><span style=\"color: gray;\">=</span><span style=\"color: rgb(139, 0, 0);\">\"</span><span style=\"color: rgb(170, 17, 17);\">stylesheet</span><span style=\"color: rgb(139, 0, 0);\">\"</span><span style=\"color: gray;\"> </span><span style=\"color: rgb(0, 0, 139);\">type</span><span style=\"color: gray;\">=</span><span style=\"color: rgb(139, 0, 0);\">\"</span><span style=\"color: rgb(170, 17, 17);\">text/css</span><span style=\"color: rgb(139, 0, 0);\">\"</span><span style=\"color: gray;\"> </span><span style=\"color: rgb(0, 0, 139);\">href</span><span style=\"color: gray;\">=</span><span style=\"color: rgb(139, 0, 0);\">\"</span><span style=\"color: rgb(170, 17, 17);\">mystyle.css</span><span style=\"color: rgb(139, 0, 0);\">\"</span><span style=\"color: olive;\">&gt;</span><span style=\"color: gray;\"> </span><span style=\"color: olive;\">&lt;/</span><span style=\"color: green;\">head</span><span style=\"color: olive;\">&gt;</span></p><p style=\"text-align: start;\">浏览器会从文件 mystyle.css 中读到样式声明，并根据它来格式文档。</p><p style=\"text-align: start;\">外部样式表可以在任何文本编辑器中进行编辑。文件不能包含任何的 html 标签。样式表应该以 .css 扩展名进行保存。下面是一个样式表文件的例子：</p><p style=\"text-align: start;\"><span style=\"color: rgb(0, 85, 170);\">hr</span><span style=\"color: gray;\"> </span><span style=\"color: olive;\">{</span><span style=\"color: green;\">color:</span><span style=\"color: gray;\">sienna;</span><span style=\"color: olive;\">}</span><span style=\"color: gray;\"> </span><span style=\"color: rgb(0, 85, 170);\">p</span><span style=\"color: gray;\"> </span><span style=\"color: olive;\">{</span><span style=\"color: green;\">margin-left:</span><span style=\"color: maroon;\">20</span><span style=\"color: rgb(170, 17, 17);\">px</span><span style=\"color: gray;\">;</span><span style=\"color: olive;\">}</span><span style=\"color: gray;\"> </span><span style=\"color: rgb(0, 85, 170);\">body</span><span style=\"color: gray;\"> </span><span style=\"color: olive;\">{</span><span style=\"color: green;\">background-image:</span><span style=\"color: gray;\">url(\"/images/back40.gif\");</span><span style=\"color: olive;\">}</span></p><blockquote style=\"text-align: start;\">不要在属性值与单位之间留有空格（如：\"margin-left: 20 px\" ），正确的写法是 \"margin-left: 20px\" 。</blockquote><hr/><p><br></p><h2 style=\"text-align: start;\">内部样式表</h2><p style=\"text-align: start;\">当单个文档需要特殊的样式时，就应该使用内部样式表。你可以使用 &lt;style&gt; 标签在文档头部定义内部样式表，就像这样:</p><p style=\"text-align: start;\"><span style=\"color: olive;\">&lt;</span><span style=\"color: green;\">head</span><span style=\"color: olive;\">&gt;</span><span style=\"color: gray;\"> </span><span style=\"color: olive;\">&lt;</span><span style=\"color: green;\">style</span><span style=\"color: olive;\">&gt;</span><span style=\"color: gray;\"> hr {color:sienna;} p {margin-left:20px;} body {background-image:url(\"images/back40.gif\");} </span><span style=\"color: olive;\">&lt;/</span><span style=\"color: green;\">style</span><span style=\"color: olive;\">&gt;</span><span style=\"color: gray;\"> </span><span style=\"color: olive;\">&lt;/</span><span style=\"color: green;\">head</span><span style=\"color: olive;\">&gt;<br></span></p><hr/><p><br></p><h2 style=\"text-align: start;\">内联样式</h2><p style=\"text-align: start;\">由于要将表现和内容混杂在一起，内联样式会损失掉样式表的许多优势。请慎用这种方法，例如当样式仅需要在一个元素上应用一次时。</p><p style=\"text-align: start;\">要使用内联样式，你需要在相关的标签内使用样式（style）属性。Style 属性可以包含任何 CSS 属性。本例展示如何改变段落的颜色和左外边距：</p><p style=\"text-align: start;\"><span style=\"color: olive;\">&lt;</span><span style=\"color: green;\">p</span><span style=\"color: gray;\"> </span><span style=\"color: rgb(0, 0, 139);\">style</span><span style=\"color: gray;\">=</span><span style=\"color: rgb(139, 0, 0);\">\"</span><span style=\"color: rgb(170, 17, 17);\">color:sienna;margin-left:20px</span><span style=\"color: rgb(139, 0, 0);\">\"</span><span style=\"color: olive;\">&gt;</span><span style=\"color: gray;\">这是一个段落。</span><span style=\"color: olive;\">&lt;/</span><span style=\"color: green;\">p</span><span style=\"color: olive;\">&gt;<br></span></p><hr/><p><br></p><h2 style=\"text-align: start;\">多重样式</h2><p style=\"text-align: start;\">如果某些属性在不同的样式表中被同样的选择器定义，那么属性值将从更具体的样式表中被继承过来。 </p><p style=\"text-align: start;\">例如，外部样式表拥有针对 h3 选择器的三个属性：</p><p style=\"text-align: start;\"><span style=\"color: rgb(0, 85, 170);\">h3</span><span style=\"color: gray;\"> </span><span style=\"color: olive;\">{</span><span style=\"color: gray;\"> </span><span style=\"color: green;\">color:</span><span style=\"color: rgb(0, 0, 139);\">red</span><span style=\"color: gray;\">; </span><span style=\"color: green;\">text-align:</span><span style=\"color: rgb(170, 17, 17);\">left</span><span style=\"color: gray;\">; </span><span style=\"color: green;\">font-size:</span><span style=\"color: maroon;\">8</span><span style=\"color: rgb(170, 17, 17);\">pt</span><span style=\"color: gray;\">; </span><span style=\"color: olive;\">}</span></p><p style=\"text-align: start;\">而内部样式表拥有针对 h3 选择器的两个属性：</p><p style=\"text-align: start;\"><span style=\"color: rgb(0, 85, 170);\">h3</span><span style=\"color: gray;\"> </span><span style=\"color: olive;\">{</span><span style=\"color: gray;\"> </span><span style=\"color: green;\">text-align:</span><span style=\"color: rgb(170, 17, 17);\">right</span><span style=\"color: gray;\">; </span><span style=\"color: green;\">font-size:</span><span style=\"color: maroon;\">20</span><span style=\"color: rgb(170, 17, 17);\">pt</span><span style=\"color: gray;\">; </span><span style=\"color: olive;\">}</span></p><p style=\"text-align: start;\">假如拥有内部样式表的这个页面同时与外部样式表链接，那么 h3 得到的样式是：</p><p style=\"text-align: start;\"><span style=\"color: rgb(0, 85, 170);\">color</span><span style=\"color: navy;\">:red</span><span style=\"color: gray;\">; </span><span style=\"color: rgb(0, 85, 170);\">text-align</span><span style=\"color: navy;\">:right</span><span style=\"color: gray;\">; </span><span style=\"color: rgb(0, 85, 170);\">font-size</span><span style=\"color: gray;\">:20</span><span style=\"color: rgb(0, 85, 170);\">pt</span><span style=\"color: gray;\">;</span></p><p style=\"text-align: start;\">即颜色属性将被继承于外部样式表，而文字排列（text-alignment）和字体尺寸（font-size）会被内部样式表中的规则取代。</p><hr/><p><br></p><h2 style=\"text-align: start;\">多重样式优先级</h2><p style=\"text-align: start;\">样式表允许以多种方式规定样式信息。样式可以规定在单个的 HTML 元素中，在 HTML 页的头元素中，或在一个外部的 CSS 文件中。甚至可以在同一个 HTML 文档内部引用多个外部样式表。</p><p style=\"text-align: start;\">一般情况下，优先级如下：</p><p style=\"text-align: start;\"><strong>（内联样式）Inline style &gt; （内部样式）Internal style sheet &gt;（外部样式）External style sheet &gt; 浏览器默认样式</strong></p><p style=\"text-align: start;\"><a href=\"https://static.runoob.com/assets/css/css-howto/style.css\" target=\"_blank\">style.css</a> 文件样式代码如下：</p><pre style=\"text-align: start;\"><code>h3 {\n    color:blue;\n}\n</code></pre><h2>实例</h2><p><span style=\"color: olive;\">&lt;</span><span style=\"color: green;\">head</span><span style=\"color: olive;\">&gt;</span><span style=\"color: gray;\"> </span><span style=\"color: rgb(170, 85, 0);\">&lt;!-- 外部样式 style.css --&gt;</span><span style=\"color: gray;\"> </span><span style=\"color: olive;\">&lt;</span><span style=\"color: green;\">link</span><span style=\"color: gray;\"> </span><span style=\"color: rgb(0, 0, 139);\">rel</span><span style=\"color: gray;\">=</span><span style=\"color: rgb(139, 0, 0);\">\"</span><span style=\"color: rgb(170, 17, 17);\">stylesheet</span><span style=\"color: rgb(139, 0, 0);\">\"</span><span style=\"color: gray;\"> </span><span style=\"color: rgb(0, 0, 139);\">type</span><span style=\"color: gray;\">=</span><span style=\"color: rgb(139, 0, 0);\">\"</span><span style=\"color: rgb(170, 17, 17);\">text/css</span><span style=\"color: rgb(139, 0, 0);\">\"</span><span style=\"color: gray;\"> </span><span style=\"color: rgb(0, 0, 139);\">href</span><span style=\"color: gray;\">=</span><span style=\"color: rgb(139, 0, 0);\">\"</span><span style=\"color: rgb(170, 17, 17);\">style.css</span><span style=\"color: rgb(139, 0, 0);\">\"</span><span style=\"color: olive;\">/&gt;</span><span style=\"color: gray;\"> </span><span style=\"color: rgb(170, 85, 0);\">&lt;!-- 设置：h3{color:blue;} --&gt;</span><span style=\"color: gray;\"> </span><span style=\"color: olive;\">&lt;</span><span style=\"color: green;\">style</span><span style=\"color: gray;\"> </span><span style=\"color: rgb(0, 0, 139);\">type</span><span style=\"color: gray;\">=</span><span style=\"color: rgb(139, 0, 0);\">\"</span><span style=\"color: rgb(170, 17, 17);\">text/css</span><span style=\"color: rgb(139, 0, 0);\">\"</span><span style=\"color: olive;\">&gt;</span><span style=\"color: gray;\"> /* 内部样式 */ h3{color:green;} </span><span style=\"color: olive;\">&lt;/</span><span style=\"color: green;\">style</span><span style=\"color: olive;\">&gt;</span><span style=\"color: gray;\"> </span><span style=\"color: olive;\">&lt;/</span><span style=\"color: green;\">head</span><span style=\"color: olive;\">&gt;</span><span style=\"color: gray;\"> </span><span style=\"color: olive;\">&lt;</span><span style=\"color: green;\">body</span><span style=\"color: olive;\">&gt;</span><span style=\"color: gray;\"> </span><span style=\"color: olive;\">&lt;</span><span style=\"color: green;\">h3</span><span style=\"color: olive;\">&gt;</span><span style=\"color: gray;\">显示绿色，是内部样式</span><span style=\"color: olive;\">&lt;/</span><span style=\"color: green;\">h3</span><span style=\"color: olive;\">&gt;</span><span style=\"color: gray;\"> </span><span style=\"color: olive;\">&lt;/</span><span style=\"color: green;\">body</span><span style=\"color: olive;\">&gt;<br></span><a href=\"https://www.runoob.com/try/try.php?filename=css-howto\" target=\"_blank\" style=\"text-align: center;\">尝试一下 »</a></p><p style=\"text-align: start;\"><strong>注意：</strong>如果外部样式放在内部样式的后面，则外部样式将覆盖内部样式，实例如下：</p><p style=\"text-align: start;\"><br></p><h2>实例</h2><p><span style=\"color: olive;\">&lt;</span><span style=\"color: green;\">head</span><span style=\"color: olive;\">&gt;</span><span style=\"color: gray;\"> </span><span style=\"color: rgb(170, 85, 0);\">&lt;!-- 设置：h3{color:blue;} --&gt;</span><span style=\"color: gray;\"> </span><span style=\"color: olive;\">&lt;</span><span style=\"color: green;\">style</span><span style=\"color: gray;\"> </span><span style=\"color: rgb(0, 0, 139);\">type</span><span style=\"color: gray;\">=</span><span style=\"color: rgb(139, 0, 0);\">\"</span><span style=\"color: rgb(170, 17, 17);\">text/css</span><span style=\"color: rgb(139, 0, 0);\">\"</span><span style=\"color: olive;\">&gt;</span><span style=\"color: gray;\"> /* 内部样式 */ h3{color:green;} </span><span style=\"color: olive;\">&lt;/</span><span style=\"color: green;\">style</span><span style=\"color: olive;\">&gt;</span><span style=\"color: gray;\"> </span><span style=\"color: rgb(170, 85, 0);\">&lt;!-- 外部样式 style.css --&gt;</span><span style=\"color: gray;\"> </span><span style=\"color: olive;\">&lt;</span><span style=\"color: green;\">link</span><span style=\"color: gray;\"> </span><span style=\"color: rgb(0, 0, 139);\">rel</span><span style=\"color: gray;\">=</span><span style=\"color: rgb(139, 0, 0);\">\"</span><span style=\"color: rgb(170, 17, 17);\">stylesheet</span><span style=\"color: rgb(139, 0, 0);\">\"</span><span style=\"color: gray;\"> </span><span style=\"color: rgb(0, 0, 139);\">type</span><span style=\"color: gray;\">=</span><span style=\"color: rgb(139, 0, 0);\">\"</span><span style=\"color: rgb(170, 17, 17);\">text/css</span><span style=\"color: rgb(139, 0, 0);\">\"</span><span style=\"color: gray;\"> </span><span style=\"color: rgb(0, 0, 139);\">href</span><span style=\"color: gray;\">=</span><span style=\"color: rgb(139, 0, 0);\">\"</span><span style=\"color: rgb(170, 17, 17);\">style.css</span><span style=\"color: rgb(139, 0, 0);\">\"</span><span style=\"color: olive;\">/&gt;</span><span style=\"color: gray;\"> </span><span style=\"color: olive;\">&lt;/</span><span style=\"color: green;\">head</span><span style=\"color: olive;\">&gt;</span><span style=\"color: gray;\"> </span><span style=\"color: olive;\">&lt;</span><span style=\"color: green;\">body</span><span style=\"color: olive;\">&gt;</span><span style=\"color: gray;\"> </span><span style=\"color: olive;\">&lt;</span><span style=\"color: green;\">h3</span><span style=\"color: olive;\">&gt;</span><span style=\"color: gray;\">显示蓝色，是外部样式</span><span style=\"color: olive;\">&lt;/</span><span style=\"color: green;\">h3</span><span style=\"color: olive;\">&gt;</span><span style=\"color: gray;\"> </span><span style=\"color: olive;\">&lt;/</span><span style=\"color: green;\">body</span><span style=\"color: olive;\">&gt;</span></p><p><br></p>', 0, 0, 21, 'CSS (Cascading Style Sheets，层叠样式表），是一种用来为结构化文档（如 HTML 文档或 XML 应用）添加样式（字体、间距和颜色等）的计算机语言，CSS 文件扩展名为 .css。\n\n通过使用 CSS 我们可以大大提升网页开发的工作效率！\n\n在我们的 CSS 教程中，您会学到如何使用 CSS 同时控制多重网页的样式和布局。\n\nCSS3 现在已被大部分现代浏览器支持，而下一版的 CSS4 仍在开发中。', 'cover/1662087753351css-logo.png', 'admin', '2022-09-02 11:02:37', 'admin', '2022-09-02 11:02:37', NULL);
INSERT INTO `blog` VALUES (12, '纯css控制文字2行显示多余部分隐藏', '<p><br></p><p style=\"text-align: start;\">在编写页面的时候，经常遇到一些地方的文字显示1行，多余的文字隐藏，这样显示1行的很好控制：<br>css代码如下：</p><pre style=\"text-align: start;\"><code class=\"language-has-numbering\">white-space: nowrap;\noverflow: hidden;\ntext-overflow: ellipsis;\n</code></pre><p style=\"text-align: start;\">3行代码搞定，这个很常见。但是要是2行文字显示多余隐藏呢，我之前在网上搜到的很多说什么用js去控制，用php控制。。。等等诸如此类的复杂方法，为什么不能同样用css去控制呢？后来找到答案了，用css同样可以去控制2行文字显示多余隐藏。<br>css代码如下：</p><pre style=\"text-align: start;\"><code class=\"language-has-numbering\">text-overflow: -o-ellipsis-lastline;\noverflow: hidden;\ntext-overflow: ellipsis;\ndisplay: -webkit-box;\n-webkit-line-clamp: 2;\n-webkit-box-orient: vertical;\n</code></pre><p style=\"text-align: start;\">更方便的是改变webkit-line-clamp的值还可以实现3、4、5等等多行文字显示多余隐藏的效果~<br>转载：<a href=\"https://blog.csdn.net/this_itboy/article/details/51799086\" target=\"\">https://blog.csdn.net/this_itboy/article/details/51799086</a></p><p><br></p>', 0, 0, 6, '3行代码搞定，这个很常见。但是要是2行文字显示多余隐藏呢，我之前在网上搜到的很多说什么用js去控制，用php控制。。。等等诸如此类的复杂方法，为什么不能同样用css去控制呢？后来找到答案了，用css同样可以去控制2行文字显示多余隐藏。', 'cover/1662089383658捕获.PNG', 'shixingze', '2022-09-02 11:29:58', 'shixingze', '2022-09-02 11:29:58', NULL);
INSERT INTO `blog` VALUES (13, '程序员转型？不可能，绝对不可能', '<p>引言</p><p>这两年互联网行业的裁员可谓是一浪接一浪，连阿里腾讯这样的大厂都一轮一轮的裁员，身边不少的朋友都担心什么时候就被毕业了；许多开发者也随之对自己的前程感到迷茫，纷纷选择了躺平</p><p><br></p><p>但为了生活，一些 Android 开发者便开始寻求突破这种逆境的方法，于是便盯上了车企行业：智能座舱、车载系统、GPS 图像显示，看起来似乎是个不错的方向；许多大厂车企对此也都是抛出极高的薪资来吸引开发者们；例如：</p><p><br></p><p>蔚来汽车：</p><p><br></p><p><br></p><p><br></p><p>但想要成功转型，可并不那么简单；相信大家从上述招聘信息上不难看出，想要众多 Android 开发者中有着自己的一席之地，那就必须要对 Android Framework 有着深入的理解，不然无论你是继续内卷，还是想要进行转型，都难以突破这一界限；实际上大多的 Android 开发者对于 Android Framework 其实并没有对其有着太多的了解，更别说深入理解了，所以想要成为一个真正的 Android 高级工程师， Framework 一定是你必不可缺的一门知识</p><p><br></p><p>如何深入学习 Framework ？</p><p>个人认为，当你提出如何深入学习 Framework 这个问题的时候，你就已经具备了最基础的条件–探索欲和求知欲；当然这个东西比较虚，我再讲一些实在的</p><p><br></p><p>关于 Android Framework 的底层开发资料，其实大家在网上也可以看到许多，但是大多都没有一个好的方向去给大家学习，断断续续的学习并不能让大家的技术水平提升</p><p><br></p><p>下面给大家提供一张 Framework 源码学习思维导图</p><p><br></p><p><br></p><p><br></p><p>希望这份思维导图能够给大家学习 Framework 源码 提供一个好的方向，并且我根据上述这份思维导图融合了这些年的工作经历及对网上的资料查询和整理， 最终将其整合了一份 Framework 源码学习手册；有需要这份 Framework 源码学习手册 的朋友：可以 私信 发送 “进阶” 即可 免费获取，希望大家通过阅读这份 Framework 源码学习手册，能够查漏补缺，完善自身的不足之处；早日攻克 Android Framework 这一难题</p><p>————————————————</p><p>版权声明：本文为CSDN博主「Android技术栈」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。</p><p>原文链接：https://blog.csdn.net/m0_70748845/article/details/126651875</p>', 3, 0, 8, '但想要成功转型，可并不那么简单；相信大家从上述招聘信息上不难看出，想要众多 Android 开发者中有着自己的一席之地，那就必须要对 Android Framework 有着深入的理解，不然无论你是继续内卷，还是想要进行转型，都难以突破这一界限；实际上大多的 Android 开发者对于 Android Framework 其实并没有对其有着太多的了解，更别说深入理解了，所以想要成为一个真正的 Android 高级工程师， Framework 一定是你必不可缺的一门知识', 'cover/16620895268849a82c66eca913533274b950266983d77.png', 'admin', '2022-09-02 11:32:08', 'admin', '2022-09-02 11:32:08', NULL);
INSERT INTO `blog` VALUES (14, 'SpringBoot整合Spring Security【超详细教程】', '<p>请开始写前言</p><p>Spring Security是一个功能强大且高度可定制的身份验证和访问控制框架。提供了完善的认证机制和方法级的授权功能。是一款非常优秀的权限管理框架。它的核心是一组过滤器链，不同的功能经由不同的过滤器。这篇文章就是想通过一个小案例将Spring Security整合到SpringBoot中去。要实现的功能就是在认证服务器上登录，然后获取Token，再访问资源服务器中的资源。</p><p><br></p><p><br></p><p><br></p><p>基本概念</p><p>单点登录</p><p>什么叫做单点登录呢。就是在一个多应用系统中，只要在其中一个系统上登录之后，不需要在其它系统上登录也可以访问其内容。举个例子，京东那么复杂的系统肯定不会是单体结构，必然是微服务架构，比如订单功能是一个系统，交易是一个系统…那么我在下订单的时候登录了，付钱难道还需要再登录一次吗，如果是这样，用户体验也太差了吧。实现的流程就是我在下单的时候系统发现我没登录就让我登录，登录完了之后系统返回给我一个Token，就类似于身份证的东西；然后我想去付钱的时候就把Token再传到交易系统中，然后交易系统验证一下Token就知道是谁了，就不需要再让我登录一次。</p><p><br></p><p><br></p><p><br></p><p>JWT</p><p>上面提到的Token就是JWT(JSON Web Token)，是一种用于通信双方之间传递安全信息的简洁的、URL安全的表述性声明规范。一个JWT实际上就是一个字符串，它由三部分组成，头部、载荷与签名。为了能够直观的看到JWT的结构，我画了一张思维导图：</p><p><br></p><p><br></p><p><br></p><p>最终生成的JWT令牌就是下面这样，有三部分，用 . 分隔。</p><p><br></p><p>base64UrlEncode(JWT 头)+“.”+base64UrlEncode(载荷)+“.”+HMACSHA256(base64UrlEncode(JWT 头) + “.” + base64UrlEncode(有效载荷),密钥)</p><p><br></p><p>eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWV9.TJVA95OrM7E2cBab30RMHrHDcEfxjoYZgeFONFh7HgQ</p><p>————————————————</p><p>版权声明：本文为CSDN博主「Robod」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。</p><p>原文链接：https://blog.csdn.net/weixin_43461520/article/details/107941983</p>', 0, 0, 3, 'Spring Security是一个功能强大且高度可定制的身份验证和访问控制框架。提供了完善的认证机制和方法级的授权功能。是一款非常优秀的权限管理框架。它的核心是一组过滤器链，不同的功能经由不同的过滤器。这篇文章就是想通过一个小案例将Spring Security整合到SpringBoot中去。要实现的功能就是在认证服务器上登录，然后获取Token，再访问资源服务器中的资源。', 'cover/1662089652199aHR0cHM6Ly9naXRlZS5jb20vUm9ib2RMZWUvaW1hZ2Vfc3RvcmUvcmF3L21hc3Rlci9KYXZhL1NwcmluZ0Jvb3QlRTYlOTUlQjQlRTUlOTAlODhTcHJpbmdTZWN1cml0eS9TcHJpbmdTZWN1cml0eSVFOCVCRiU4NyVFNiVCQiVBNCVFNSU5OSVBOCVFOSU5MyVCRS5qcGc.png', 'admin', '2022-09-02 11:34:42', 'admin', '2022-09-02 11:34:42', NULL);
INSERT INTO `blog` VALUES (15, 'Spring Boot拦截器精讲', '<p>请开始写</p><h2 style=\"text-align: start;\">定义拦截器<span style=\"color: rgb(68, 68, 68); background-color: rgb(255, 255, 255); font-size: 14px;\">在 Spring Boot 中定义拦截器十分的简单，只需要创建一个拦截器类，并实现 HandlerInterceptor 接口即可。<br><br>HandlerInterceptor &nbsp;接口中定义以下 3 个方法，如下表。<br><br></span></h2><table style=\"width: auto; text-align: start;\"><tbody><tr><th colspan=\"1\" rowspan=\"1\" width=\"auto\">返回值类型</th><th colspan=\"1\" rowspan=\"1\" width=\"auto\">方法声明</th><th colspan=\"1\" rowspan=\"1\" width=\"auto\">描述</th></tr><tr><td colspan=\"1\" rowspan=\"1\" width=\"auto\">boolean</td><td colspan=\"1\" rowspan=\"1\" width=\"auto\">preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) </td><td colspan=\"1\" rowspan=\"1\" width=\"auto\">该方法在控制器处理请求方法前执行，其返回值表示是否中断后续操作，返回 true 表示继续向下执行，返回 false 表示中断后续操作。</td></tr><tr><td colspan=\"1\" rowspan=\"1\" width=\"auto\">void</td><td colspan=\"1\" rowspan=\"1\" width=\"auto\">postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)</td><td colspan=\"1\" rowspan=\"1\" width=\"auto\">该方法在控制器处理请求方法调用之后、解析视图之前执行，可以通过此方法对请求域中的模型和视图做进一步修改。</td></tr><tr><td colspan=\"1\" rowspan=\"1\" width=\"auto\">void</td><td colspan=\"1\" rowspan=\"1\" width=\"auto\">afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)</td><td colspan=\"1\" rowspan=\"1\" width=\"auto\">该方法在视图渲染结束后执行，可以通过此方法实现资源清理、记录日志信息等工作。</td></tr></tbody></table><h4 style=\"text-align: start;\">示例1<span style=\"color: rgb(68, 68, 68); background-color: rgb(255, 255, 255); font-size: 14px;\">以 spring-boot-adminex 项目为例，在 net.biancheng.www.componet 中创建一个名为 LoginInterceptor 的拦截器类，对登陆进行拦截，代码如下。</span></h4><p><br></p><pre><code >package net.biancheng.www.componet;import lombok.extern.slf4j.Slf4j;import org.springframework.web.servlet.HandlerInterceptor;import org.springframework.web.servlet.ModelAndView;import javax.servlet.http.HttpServletRequest;import javax.servlet.http.HttpServletResponse;@Slf4jpublic class LoginInterceptor implements HandlerInterceptor {    /**     * 目标方法执行前     *     * @param request     * @param response     * @param handler     * @return     * @throws Exception     */    @Override    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {        Object loginUser = request.getSession().getAttribute(\"loginUser\");        if (loginUser == null) {            //未登录，返回登陆页            request.setAttribute(\"msg\", \"您没有权限进行此操作，请先登陆！\");            request.getRequestDispatcher(\"/index.html\").forward(request, response);            return false;        } else {            //放行            return true;        }    }    /**     * 目标方法执行后     *     * @param request     * @param response     * @param handler     * @param modelAndView     * @throws Exception     */    @Override    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {        log.info(\"postHandle执行{}\", modelAndView);    }    /**     * 页面渲染后     *     * @param request     * @param response     * @param handler     * @param ex     * @throws Exception     */    @Override    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {        log.info(\"afterCompletion执行异常{}\", ex);    }}</code></pre><h2 style=\"text-align: start;\">注册拦截器<span style=\"color: rgb(68, 68, 68); background-color: rgb(255, 255, 255); font-size: 14px;\">创建一个实现了 WebMvcConfigurer 接口的配置类（使用了 @Configuration 注解的类），重写 addInterceptors() 方法，并在该方法中调用 registry.addInterceptor() 方法将自定义的拦截器注册到容器中。</span></h2><h4 style=\"text-align: start;\">示例 2<span style=\"color: rgb(68, 68, 68); background-color: rgb(255, 255, 255); font-size: 14px;\">在配置类 MyMvcConfig 中，添加以下方法注册拦截器，代码如下。<br></span></h4><p><br></p><pre><code >@Configurationpublic class MyMvcConfig implements WebMvcConfigurer {    ......    @Override    public void addInterceptors(InterceptorRegistry registry) {        registry.addInterceptor(new LoginInterceptor());    }}</code></pre><h2 style=\"text-align: start;\">指定拦截规则</h2><p><br></p>', 0, 0, 1, NULL, 'cover/1662187830996总览图.png', 'admin', '2022-09-03 14:56:28', 'admin', '2022-09-03 14:56:28', NULL);
INSERT INTO `blog` VALUES (16, '12', '<p>请开始写</p>', 0, 0, 0, '12', '', 'shixingze', '2022-09-03 14:56:58', 'shixingze', '2022-09-03 14:56:58', NULL);
INSERT INTO `blog` VALUES (17, '12', '<p>请开始写</p>', 0, 0, 0, '12', '', 'admin', '2022-09-03 15:00:01', 'admin', '2022-09-03 15:00:01', '12,1,');
INSERT INTO `blog` VALUES (18, '', '<p>请开始写</p>', 0, 0, 0, '', '', 'admin', '2022-09-03 15:03:58', 'admin', '2022-09-03 15:03:58', '2,20,');
INSERT INTO `blog` VALUES (19, 'vueceshi', '<p>两种方法：</p><p>findIndex（）和 indexOf（）方法</p><p><br></p><p>findIndex（）顾名思义，查找符合条件的值并返回其索引（返回值为-1表示不存在满足条件的值），通过判断返回值对其进行下一步操作</p><p><br></p><p>indexOf（）从头开始寻找是否存在符合条件的字符串，返回值为-1表示不存在</p><p><br></p><p>//方法一:通用</p><p>xx(Arr,date){ </p><p>	// 返回值等于-1 说明数组Arr中不存在id为date的对象</p><p>	if( Arr.findIndex(item =&gt; item.id=== date )!==-1){</p><p>	...</p><p>	}	</p><p>}</p><p><br></p><p>//方法二：当数组里的对象为字符串时用这个方法更简单</p><p>xx(Arr,date){</p><p>	// 返回值等于-1 说明数组Arr中不存在id为date的对象</p><p>	if( Arr.indexOf(date)!==-1 ){</p><p>	...</p><p>	}	</p><p>}</p><p> &nbsp; &nbsp;</p><p>————————————————</p><p>版权声明：本文为CSDN博主「椿☽」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。</p><p>原文链接：https://blog.csdn.net/weixin_52418790/article/details/122654245</p>', 0, 0, 0, 'vue测试标签', 'cover/16621894374211635843570(1).png', 'shixingze', '2022-09-03 15:17:50', 'shixingze', '2022-09-03 15:17:50', '1,10,');
INSERT INTO `blog` VALUES (20, 'vueceshi777777777777777777777777777777', '<p>两种方法：</p><p>findIndex（）和 indexOf（）方法</p><p><br></p><p>findIndex（）顾名思义，查找符合条件的值并返回其索引（返回值为-1表示不存在满足条件的值），通过判断返回值对其进行下一步操作</p><p><br></p><p>indexOf（）从头开始寻找是否存在符合条件的字符串，返回值为-1表示不存在</p><p><br></p><p>//方法一:通用</p><p>xx(Arr,date){ </p><p>	// 返回值等于-1 说明数组Arr中不存在id为date的对象</p><p>	if( Arr.findIndex(item =&gt; item.id=== date )!==-1){</p><p>	...</p><p>	}	</p><p>}</p><p><br></p><p>//方法二：当数组里的对象为字符串时用这个方法更简单</p><p>xx(Arr,date){</p><p>	// 返回值等于-1 说明数组Arr中不存在id为date的对象</p><p>	if( Arr.indexOf(date)!==-1 ){</p><p>	...</p><p>	}	</p><p>}</p><p> &nbsp; &nbsp;</p><p>————————————————</p><p>版权声明：本文为CSDN博主「椿☽」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。</p><p>原文链接：https://blog.csdn.net/weixin_52418790/article/details/122654245</p>', 0, 0, 0, 'vue测试标签', 'cover/16621894374211635843570(1).png', 'admin', '2022-09-03 15:33:01', 'admin', '2022-09-03 15:33:01', '2,20,');
INSERT INTO `blog` VALUES (21, '我的测试文章', '<p>请开始写11111111111111111111111111111111111121</p><p>21</p><p>21212121</p><p>212121212</p><p>121212😂😀</p><table style=\"width: auto;\"><tbody><tr><th colSpan=\"1\" rowSpan=\"1\" width=\"auto\">1</th><th colSpan=\"1\" rowSpan=\"1\" width=\"auto\">1</th><th colSpan=\"1\" rowSpan=\"1\" width=\"auto\">1</th><th colSpan=\"1\" rowSpan=\"1\" width=\"auto\">1</th><th colSpan=\"1\" rowSpan=\"1\" width=\"auto\">1</th><th colSpan=\"1\" rowSpan=\"1\" width=\"510\">1</th><th colSpan=\"1\" rowSpan=\"1\" width=\"622\">1</th></tr><tr><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\"></td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\"></td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\"></td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\"></td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\"></td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\"></td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\"></td></tr><tr><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\"></td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\"></td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\"></td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\"></td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\"></td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\"></td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\"></td></tr></tbody></table><p><br></p>', 0, 0, 1, '我曾经把完整的镜子打碎', 'cover/1664010430740jianyi.png', 'admin', '2022-09-24 17:36:28', 'admin', '2022-09-24 17:36:28', '2,20,23,');
INSERT INTO `blog` VALUES (22, '我的测试文章', '<p>请开始写11111111111111111111111111111111111121</p><p>21</p><p>21212121</p><p>212121212</p><p>121212😂😀</p><table style=\"width: auto;\"><tbody><tr><th colSpan=\"1\" rowSpan=\"1\" width=\"auto\">1</th><th colSpan=\"1\" rowSpan=\"1\" width=\"auto\">1</th><th colSpan=\"1\" rowSpan=\"1\" width=\"auto\">1</th><th colSpan=\"1\" rowSpan=\"1\" width=\"auto\">1</th><th colSpan=\"1\" rowSpan=\"1\" width=\"auto\">1</th><th colSpan=\"1\" rowSpan=\"1\" width=\"510\">1</th><th colSpan=\"1\" rowSpan=\"1\" width=\"622\">1</th></tr><tr><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\"></td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\"></td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\"></td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\"></td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\"></td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\"></td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\"></td></tr><tr><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\"></td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\"></td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\"></td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\"></td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\"></td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\"></td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\"></td></tr></tbody></table><p><br></p>', 0, 0, 0, '我曾经把完整的镜子打碎', 'cover/1664010430740jianyi.png', 'shixingze', '2022-09-24 17:40:16', 'shixingze', '2022-09-24 17:40:16', '2,20,23,');
INSERT INTO `blog` VALUES (23, 'jAVA', '<h2>java 教程开发</h2><h4>方法二</h4><div data-w-e-type=\"todo\"><input type=\"checkbox\" disabled ><span style=\"color: rgb(89, 126, 247);\">路径：http://localhost:8080/#/index?name=1</span></div><p>&lt;router-link :to=\"{path:\'/index\',query: {name: id}}\"&gt;</p><p>跳转&lt;/router-link&gt;(id是参数)</p><table style=\"width: auto;\"><tbody><tr><th colSpan=\"1\" rowSpan=\"1\" width=\"auto\">1212</th><th colSpan=\"1\" rowSpan=\"1\" width=\"auto\">12</th><th colSpan=\"1\" rowSpan=\"1\" width=\"auto\">12</th><th colSpan=\"1\" rowSpan=\"1\" width=\"auto\">12</th><th colSpan=\"1\" rowSpan=\"1\" width=\"auto\">12</th></tr><tr><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\">34</td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\">34</td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\">34</td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\">34</td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\">12</td></tr><tr><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\">34</td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\">34</td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\">34</td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\">34</td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\">34</td></tr></tbody></table><div data-w-e-type=\"todo\"><input type=\"checkbox\" disabled >参数使用：this.$route.query.id</div><p><br></p><p>this.$route是一个数组，里面包含路由的所有信息</p><pre><code class=\"language-java\">    /**\r\n     * 根据id查询单条\r\n     * @return\r\n     */\r\n    public AjaxResult getOne(Blog blog){\r\n        if (blog.getBlogId() != null && blog.getBlogId() &gt; 0){\r\n            Blog blog1 = blogMapper.selectByPrimaryKey(blog.getBlogId());\r\n          return AjaxResult.success(blog1);\r\n        }else {\r\n            return AjaxResult.error(\"未传入文章id，或该文章已经被删除。\");\r\n        }\r\n    }</code></pre><p><span style=\"color: rgb(212, 212, 212);\"> </span><span style=\"color: rgb(156, 220, 254);\"><code>width</code></span><span style=\"color: rgb(212, 212, 212);\"><code>: </code></span><span style=\"color: rgb(181, 206, 168);\"><code>70%</code></span><span style=\"color: rgb(212, 212, 212);\"><code>;</code></span></p><p><span style=\"color: rgb(212, 212, 212);\"><code> &nbsp;</code></span><span style=\"color: rgb(156, 220, 254);\"><code>background-color</code></span><span style=\"color: rgb(212, 212, 212);\"><code>: </code></span><span style=\"color: rgb(206, 145, 120);\"><code>#fff</code></span><span style=\"color: rgb(212, 212, 212);\"><code>;</code></span></p><p><span style=\"color: rgb(212, 212, 212);\"><code> &nbsp;</code></span><span style=\"color: rgb(156, 220, 254);\"><code>float</code></span><span style=\"color: rgb(212, 212, 212);\"><code>: </code></span><span style=\"color: rgb(206, 145, 120);\"><code>left</code></span><span style=\"color: rgb(212, 212, 212);\"><code>;</code></span></p><p><br></p><p><br></p><blockquote><strong>注意：router-link中链接如果是‘/\'开始就是从根路由开始，如果开始不带‘/\'，则从当前路由开始。</strong></blockquote><p><br></p>', 0, 0, 0, 'JAVA', 'cover/1664020791518css-logo.png', 'admin', '2022-09-24 20:00:01', 'admin', '2022-09-24 20:00:01', '2,1,');
INSERT INTO `blog` VALUES (24, '测试', '<blockquote>这是一个引用</blockquote><p><br></p><p><br></p><pre><code class=\"language-java\">\r\nimport org.springframework.boot.SpringApplication;\r\nimport org.springframework.boot.autoconfigure.SpringBootApplication;\r\n\r\n@SpringBootApplication\r\npublic class JianyiBlogApplication {\r\n\r\n    public static void main(String[] args) {\r\n        SpringApplication.run(JianyiBlogApplication.class, args);\r\n    }\r\n\r\n}\r\n</code></pre><h3></h3><h3><strong>哇大群大群伟大的我的错</strong></h3><p>😀😃😄😁😆</p><p style=\"line-height: 1;\"><span style=\"font-family: 黑体;\"><u>上的吃撒测试的v </u></span></p><p><br></p><p><span style=\"color: rgb(225, 60, 57); background-color: rgb(89, 89, 89);\">从事地产VS调查VS</span></p><p><img src=\"https://img.cdn.apipost.cn/website7/img/wechat_web.png\" alt=\"12\" data-href=\"https://img.cdn.apipost.cn/website7/img/wechat_web.png\" style=\"\"/></p><p><br></p><p><br></p><p>这是一个连接 </p><p> <a href=\"https://www.php.cn/div-tutorial-475380.html\" target=\"_blank\">这是</a><a href=\"https://www.php.cn/div-tutorial-475380.html\" target=\"_blank\">一个连接</a> </p><p><br></p><p>表格</p><table style=\"width: 100%;\"><tbody><tr><th colSpan=\"1\" rowSpan=\"1\" width=\"auto\">2</th><th colSpan=\"1\" rowSpan=\"1\" width=\"auto\">3</th><th colSpan=\"1\" rowSpan=\"1\" width=\"auto\">4</th><th colSpan=\"1\" rowSpan=\"1\" width=\"auto\">5</th><th colSpan=\"1\" rowSpan=\"1\" width=\"auto\">6</th><th colSpan=\"1\" rowSpan=\"1\" width=\"auto\">7</th></tr><tr><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\">2323</td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\">2323</td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\">2323</td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\">2323</td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\">2323</td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\">2323</td></tr><tr><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\">2323</td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\">23232323</td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\">2323</td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\">2323</td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\">2323</td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\">2323</td></tr><tr><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\">2323</td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\">2323</td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\">2323</td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\">2323</td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\">2323</td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\">23232323</td></tr><tr><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\">2323</td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\">2323</td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\">2323</td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\">2323</td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\">2323</td><td colSpan=\"1\" rowSpan=\"1\" width=\"auto\">2323</td></tr></tbody></table><p><br></p><p><br></p><p><span style=\"color: rgb(252, 237, 225); background-color: rgb(115, 209, 61); font-size: 29px; font-family: 黑体;\">字体</span></p><p><br></p><p><br></p><ul><li><span style=\"color: rgb(252, 237, 225); background-color: rgb(115, 209, 61); font-size: 29px; font-family: 黑体;\">1</span></li><li><span style=\"color: rgb(252, 237, 225); background-color: rgb(115, 209, 61); font-size: 29px; font-family: 黑体;\">2</span></li><li><span style=\"color: rgb(252, 237, 225); background-color: rgb(115, 209, 61); font-size: 29px; font-family: 黑体;\">2</span></li><li><span style=\"color: rgb(252, 237, 225); background-color: rgb(115, 209, 61); font-size: 29px; font-family: 黑体;\">3</span></li><li><span style=\"color: rgb(252, 237, 225); background-color: rgb(115, 209, 61); font-size: 29px; font-family: 黑体;\">4</span></li><li><span style=\"color: rgb(252, 237, 225); background-color: rgb(115, 209, 61); font-size: 29px; font-family: 黑体;\">6</span></li></ul><p><br></p><p><br></p><ol><li>无序列表</li><li>wewe</li></ol><p><br></p><div data-w-e-type=\"todo\"><input type=\"checkbox\" disabled >这是一个代</div><p><br></p><p>行内代码</p><p><br></p><p><span style=\"color: rgb(128, 128, 128);\">&lt;</span><span style=\"color: rgb(86, 156, 214);\">span</span><span style=\"color: rgb(128, 128, 128);\">&gt;</span><span style=\"color: rgb(212, 212, 212);\">浏览量：1000次</span><span style=\"color: rgb(128, 128, 128);\">&lt;/</span><span style=\"color: rgb(86, 156, 214);\">span</span><span style=\"color: rgb(128, 128, 128);\">&gt;</span></p><p><span style=\"color: rgb(128, 128, 128);\">&lt;</span><span style=\"color: rgb(86, 156, 214);\">span</span><span style=\"color: rgb(128, 128, 128);\">&gt;</span><span style=\"color: rgb(212, 212, 212);\">点赞量：2000个</span><span style=\"color: rgb(128, 128, 128);\">&lt;/</span><span style=\"color: rgb(86, 156, 214);\">span</span><span style=\"color: rgb(128, 128, 128);\">&gt;</span></p>', 0, 0, 0, '测试', 'cover/16641672554499a82c66eca913533274b950266983d77.png', 'admin', '2022-09-26 12:41:08', 'admin', '2022-09-26 12:41:08', '2,20,23,1,3,');
INSERT INTO `blog` VALUES (25, '我的测试接口文档', '<p><br></p><h2 style=\"text-align: left;\"><span style=\"color: rgb(0, 0, 0);\">1、json文件数据集接口（指标）</span></h2><h3 style=\"text-align: left;\"><span style=\"color: rgb(26, 26, 26);\">1.1 文件上传接口</span></h3><p style=\"text-align: left;\"><span style=\"color: rgb(51, 51, 51);\">接口地址：</span><span style=\"color: rgb(33, 33, 33); background-color: rgb(255, 255, 255);\">http://10.50.18.1:8081/dataset/table/json/upload</span></p><p style=\"text-align: left;\"><span style=\"color: rgb(51, 51, 51);\">返回格式：json</span></p><p style=\"text-align: left;\"><span style=\"color: rgb(51, 51, 51);\">请求方法：PUT</span></p><p style=\"text-align: left;\"><span style=\"color: rgb(51, 51, 51);\">接口备注：获取json文件解析结果</span></p><p style=\"text-align: left;\"><span style=\"color: rgb(51, 51, 51);\">请求参数说明：</span></p><table style=\"width: auto;\"><tbody><tr><td colSpan=\"1\" rowSpan=\"1\" width=\"97\">名称</td><td colSpan=\"1\" rowSpan=\"1\" width=\"88\">类型</td><td colSpan=\"1\" rowSpan=\"1\" width=\"116\">是否必填</td><td colSpan=\"1\" rowSpan=\"1\" width=\"355\">说明</td></tr><tr><td colSpan=\"1\" rowSpan=\"1\" width=\"97\">tableId</td><td colSpan=\"1\" rowSpan=\"1\" width=\"88\">String</td><td colSpan=\"1\" rowSpan=\"1\" width=\"116\">是</td><td colSpan=\"1\" rowSpan=\"1\" width=\"355\">追加替换操作将指标id传入 不是 的话传入\"\"空字符</td></tr><tr><td colSpan=\"1\" rowSpan=\"1\" width=\"97\">editType</td><td colSpan=\"1\" rowSpan=\"1\" width=\"88\">int</td><td colSpan=\"1\" rowSpan=\"1\" width=\"116\">shi</td><td colSpan=\"1\" rowSpan=\"1\" width=\"355\">初始导入 替换为0 追加1</td></tr><tr><td colSpan=\"1\" rowSpan=\"1\" width=\"97\">path</td><td colSpan=\"1\" rowSpan=\"1\" width=\"88\">string</td><td colSpan=\"1\" rowSpan=\"1\" width=\"116\">是</td><td colSpan=\"1\" rowSpan=\"1\" width=\"355\">path语法 路径</td></tr><tr><td colSpan=\"1\" rowSpan=\"1\" width=\"97\">file</td><td colSpan=\"1\" rowSpan=\"1\" width=\"88\">file文件</td><td colSpan=\"1\" rowSpan=\"1\" width=\"116\">是</td><td colSpan=\"1\" rowSpan=\"1\" width=\"355\">json文件</td></tr></tbody></table><p style=\"text-align: left;\"><span style=\"color: rgb(51, 51, 51);\">返回参数说明：</span></p><table style=\"width: auto;\"><tbody><tr><td colSpan=\"1\" rowSpan=\"1\" width=\"202\">名称</td><td colSpan=\"1\" rowSpan=\"1\" width=\"141\">类型</td><td colSpan=\"1\" rowSpan=\"1\" width=\"304\">说明</td></tr><tr><td colSpan=\"1\" rowSpan=\"1\" width=\"202\">success</td><td colSpan=\"1\" rowSpan=\"1\" width=\"141\">boolean</td><td colSpan=\"1\" rowSpan=\"1\" width=\"304\">返回状态</td></tr><tr><td colSpan=\"1\" rowSpan=\"1\" width=\"202\">message</td><td colSpan=\"1\" rowSpan=\"1\" width=\"141\">String</td><td colSpan=\"1\" rowSpan=\"1\" width=\"304\">返回信息</td></tr><tr><td colSpan=\"1\" rowSpan=\"1\" width=\"202\">data</td><td colSpan=\"1\" rowSpan=\"1\" width=\"141\">object</td><td colSpan=\"1\" rowSpan=\"1\" width=\"304\">返回数据</td></tr></tbody></table><p style=\"text-align: left;\"><span style=\"color: rgb(51, 51, 51);\">json返回示例：</span></p><p style=\"text-align: left;\"><br></p><p style=\"text-align: left;\"><span style=\"color: rgb(0, 0, 0);\">编码格式放下个接口</span></p><p style=\"text-align: left;\"><br></p><p style=\"text-align: left;\"><br></p><p><br></p>', 0, 0, 0, '我的测试接口文档', '', 'admin', '2022-09-29 13:45:15', 'admin', '2022-09-29 13:45:15', '22,1,');
INSERT INTO `blog` VALUES (26, '1212121212', '<blockquote style=\"text-indent: 2em;\"><span style=\"color: rgb(235, 144, 58);\">擦撒吃撒从</span></blockquote><p><br></p><p>😀😀😀</p><p><br></p><pre><code class=\"language-c\">@SpringBootApplication\r\npublic class JianyiBlogApplication {\r\n\r\n    public static void main(String[] args) {\r\n        SpringApplication.run(JianyiBlogApplication.class, args);\r\n    }\r\n\r\n}\r\n</code></pre><p><br></p>', 1, 0, 10, '121212', '', 'shixingze', '2022-10-11 18:17:30', 'shixingze', '2022-10-11 18:17:30', '2,20,1,');
INSERT INTO `blog` VALUES (27, '', '<p><br></p>', 0, 0, 0, '', '', 'admin', '2022-10-15 15:31:02', 'admin', '2022-10-15 15:31:02', NULL);
INSERT INTO `blog` VALUES (28, '111', '<pre><code class=\"language-java\">package com.jianyi.jianyiblog.controller;\r\n\r\nimport com.jianyi.jianyiblog.common.AjaxResult;\r\nimport com.jianyi.jianyiblog.entity.BlogCategory;\r\nimport com.jianyi.jianyiblog.service.BlogCategoryService;\r\nimport org.apache.commons.lang3.ObjectUtils;\r\nimport org.springframework.web.bind.annotation.*;\r\n\r\nimport javax.annotation.Resource;\r\n\r\n@RestController\r\n@RequestMapping(\"/api/blog/category\")\r\npublic class BlogCategoryController {\r\n\r\n    @Resource\r\n    private BlogCategoryService blogCategoryService;\r\n    /**\r\n     * 新增与修改\r\n     * @return\r\n     */\r\n    @PostMapping(\"/save\")\r\n    public AjaxResult save(@RequestBody BlogCategory blogCategory) throws Exception {\r\n        return  blogCategoryService.save(blogCategory);\r\n    }\r\n    /**\r\n     * 获取第一分类\r\n     * @return\r\n     */\r\n    @GetMapping(\"/firstCate\")\r\n    public AjaxResult firstCate() throws Exception {\r\n        return  blogCategoryService.firstCate();\r\n    }\r\n    /**\r\n     * 获取第子集分类\r\n     * @return\r\n     */\r\n    @PostMapping(\"/childCate\")\r\n    public AjaxResult childCate(@RequestBody BlogCategory blogCategory) throws Exception {\r\n        if (ObjectUtils.isEmpty(blogCategory.getCategoryId())){\r\n            return AjaxResult.error(\"未选择一级分类\");\r\n        }\r\n        return  blogCategoryService.childtCate(blogCategory.getCategoryId());\r\n    }\r\n}\r\n\n </code></pre><p>121212121</p>', 0, 0, 0, '1212', 'cover/1666581679256linux.jpg', 'admin', '2022-10-24 11:21:27', 'admin', '2022-10-24 11:21:27', '2,1,');
INSERT INTO `blog` VALUES (29, 'js实现点击评论进行显示回复框', '<p style=\"text-align: start;\">有人在群里问如何在留言评论那里点击回复按钮，下面就自动显示一个回复框，他想要的效果如图：</p><p style=\"text-align: start;\"><img src=\"https://images2018.cnblogs.com/blog/704203/201803/704203-20180321153909061-1660339330.png\" alt=\"\" data-href=\"\" style=\"height: auto;\"></p><h4 style=\"text-align: start;\">于是我随意的写了一段HTML，代码如下：</h4><p style=\"text-align: start;\"><br></p><pre><code class=\"language-cpp\">&lt;!DOCTYPE HTML&gt;\n&lt;html lang=\"en-US\"&gt;\n&lt;head&gt;\n    &lt;meta charset=\"UTF-8\"&gt;\n    &lt;title&gt;&lt;/title&gt;\n    &lt;script src=\"http://cdn.bootcss.com/jquery/2.2.4/jquery.js\"&gt;&lt;/script&gt;\n&lt;/head&gt;\n&lt;ul&gt;\n    &lt;li&gt;\n        1号用户评论\n        &lt;div&gt;hello,我是第1条评论 2018-03-21 12:00:00 &lt;a href=\"javascript:;\" class=\"reply_btn\" &gt;回复&lt;/a&gt;&lt;/div&gt;\n    &lt;/li&gt;\n    &lt;li&gt;\n        2号用户评论\n        &lt;div&gt;hello,我是第2条评论 2018-03-21 12:00:00 &lt;a href=\"javascript:;\" class=\"reply_btn\" &gt;回复&lt;/a&gt;&lt;/div&gt;\n    &lt;/li&gt;\n    &lt;li&gt;\n        3号用户评论\n        &lt;div&gt;hello,我是第3条评论 2018-03-21 12:00:00 &lt;a href=\"javascript:;\" class=\"reply_btn\" &gt;回复&lt;/a&gt;&lt;/div&gt;\n    &lt;/li&gt;\n&lt;/ul&gt;\n&lt;body&gt;\n    &lt;script type=\"text/javascript\"&gt;\n        $(function(){\n            //页面加载完毕后开始执行的事件\n            $(\".reply_btn\").click(function(){\n                $(\".reply_textarea\").remove();\n                $(this).parent().append(\"&lt;div class=\'reply_textarea\'&gt;&lt;textarea name=\'\' cols=\'40\' rows=\'5\'&gt;&lt;/textarea&gt;&lt;br/&gt;&lt;input type=\'submit\' value=\'发表\' /&gt;&lt;/div&gt;\");\n            });\n        });\n    &lt;/script&gt;\n&lt;/body&gt;\n&lt;/html&gt;</code></pre><p><br></p>', 0, 0, 170, '有人在群里问如何在留言评论那里点击回复按钮，下面就自动显示一个回复框，他想要的效果如图：', 'cover/1670118864313css-logo.png', 'admin', '2022-12-04 09:56:49', 'admin', '2022-12-04 09:56:49', '23,3,');

-- ----------------------------
-- Table structure for blog_blog_category
-- ----------------------------
DROP TABLE IF EXISTS `blog_blog_category`;
CREATE TABLE `blog_blog_category`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `blog_id` int NOT NULL COMMENT '文章id',
  `cate_id` int NULL DEFAULT NULL COMMENT '分类id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_blog_category
-- ----------------------------

-- ----------------------------
-- Table structure for blog_category
-- ----------------------------
DROP TABLE IF EXISTS `blog_category`;
CREATE TABLE `blog_category`  (
  `category_id` int NOT NULL AUTO_INCREMENT COMMENT '类别id',
  `category_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '类别名称',
  `category_pid` int NOT NULL COMMENT '上级id',
  `category_remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `CREATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '博客文章分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_category
-- ----------------------------
INSERT INTO `blog_category` VALUES (1, '后端', 0, '后端大菜单标签', 'admin', '2022-09-02 15:06:43', 'admin', '2022-09-02 15:06:43');
INSERT INTO `blog_category` VALUES (2, 'java', 1, '一种大众化编程语言', 'admin', '2022-09-02 15:08:19', 'admin', '2022-09-02 15:08:19');
INSERT INTO `blog_category` VALUES (3, '前端', 0, '前端大框架', 'admin', '2022-09-02 15:09:44', 'admin', '2022-09-02 15:09:44');
INSERT INTO `blog_category` VALUES (4, '移动开发', 0, NULL, 'admin', '2022-09-02 18:18:38', 'admin', '2022-09-02 18:18:38');
INSERT INTO `blog_category` VALUES (5, '编程语言', 0, NULL, 'admin', '2022-09-02 18:19:23', 'admin', '2022-09-02 18:19:23');
INSERT INTO `blog_category` VALUES (6, '人工智能', 0, NULL, 'admin', '2022-09-02 18:20:40', 'admin', '2022-09-02 18:20:40');
INSERT INTO `blog_category` VALUES (7, '大数据', 0, NULL, 'admin', '2022-09-02 18:20:46', 'admin', '2022-09-02 18:20:46');
INSERT INTO `blog_category` VALUES (8, '数据结构与算法', 0, NULL, 'admin', '2022-09-02 18:20:57', 'admin', '2022-09-02 18:20:57');
INSERT INTO `blog_category` VALUES (9, '音视频', 0, NULL, 'admin', '2022-09-02 18:21:05', 'admin', '2022-09-02 18:21:05');
INSERT INTO `blog_category` VALUES (10, '服务器', 0, NULL, 'admin', '2022-09-02 18:21:15', 'admin', '2022-09-02 18:21:15');
INSERT INTO `blog_category` VALUES (11, '操作系统', 0, NULL, 'admin', '2022-09-02 18:26:01', 'admin', '2022-09-02 18:26:01');
INSERT INTO `blog_category` VALUES (12, '运维管理', 0, NULL, 'admin', '2022-09-02 18:26:07', 'admin', '2022-09-02 18:26:07');
INSERT INTO `blog_category` VALUES (13, '数据库管理', 0, NULL, 'admin', '2022-09-02 18:26:16', 'admin', '2022-09-02 18:26:16');
INSERT INTO `blog_category` VALUES (17, '测试', 0, NULL, 'admin', '2022-09-02 18:38:03', 'admin', '2022-09-02 18:38:03');
INSERT INTO `blog_category` VALUES (18, '开发工具', 0, NULL, 'admin', '2022-09-02 18:38:55', 'admin', '2022-09-02 18:38:55');
INSERT INTO `blog_category` VALUES (19, '设计', 0, NULL, 'admin', '2022-09-02 18:39:01', 'admin', '2022-09-02 18:39:01');
INSERT INTO `blog_category` VALUES (20, 'springboot', 1, '', 'admin', '2022-09-02 15:08:19', 'admin', '2022-09-02 15:08:19');
INSERT INTO `blog_category` VALUES (21, 'mybatis', 1, '', 'admin', '2022-09-02 15:08:19', 'admin', '2022-09-02 15:08:19');
INSERT INTO `blog_category` VALUES (22, 'log4j', 1, '', 'admin', '2022-09-02 15:08:19', 'admin', '2022-09-02 15:08:19');
INSERT INTO `blog_category` VALUES (23, 'html', 3, '前端超文本编程语言', 'admin', '2022-09-02 15:09:44', 'admin', '2022-09-02 15:09:44');

-- ----------------------------
-- Table structure for blog_collect
-- ----------------------------
DROP TABLE IF EXISTS `blog_collect`;
CREATE TABLE `blog_collect`  (
  `collect_id` bigint NOT NULL AUTO_INCREMENT COMMENT '收藏表',
  `blog_id` bigint NULL DEFAULT NULL COMMENT '文章id',
  `user_id` bigint NULL DEFAULT NULL COMMENT '用户id',
  `create_time` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`collect_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '博客收藏表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_collect
-- ----------------------------

-- ----------------------------
-- Table structure for blog_collection
-- ----------------------------
DROP TABLE IF EXISTS `blog_collection`;
CREATE TABLE `blog_collection`  (
  `collection_id` bigint NOT NULL AUTO_INCREMENT COMMENT '收藏主键',
  `group_id` bigint NULL DEFAULT NULL COMMENT '收藏文件夹id',
  `blog_id` bigint NULL DEFAULT NULL COMMENT '博客id',
  `user_id` int NULL DEFAULT NULL COMMENT '用户id',
  `create_time` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`collection_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '博客收藏表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_collection
-- ----------------------------
INSERT INTO `blog_collection` VALUES (1, 1, 9, 1, '2022-12-03');

-- ----------------------------
-- Table structure for blog_comment
-- ----------------------------
DROP TABLE IF EXISTS `blog_comment`;
CREATE TABLE `blog_comment`  (
  `comment_id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `comment_uid` int NULL DEFAULT NULL COMMENT '评论人id',
  `comment_text` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '评论内容',
  `comment_pid` int NOT NULL COMMENT '父id',
  `blog_id` int NULL DEFAULT NULL COMMENT '文章id',
  `admin_comment` int NULL DEFAULT NULL COMMENT '是否管理员评论',
  `start_num` int NULL DEFAULT NULL COMMENT '点赞数',
  `CREATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新时间',
  `reply_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '回复人',
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '博客评论表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_comment
-- ----------------------------
INSERT INTO `blog_comment` VALUES (1, 1, '我是第一个评论的', 0, 9, 0, 12, 'admin', '2022-10-13', 'admin', '2022-10-13 10:51:44', '');
INSERT INTO `blog_comment` VALUES (2, 2, '我靠你是真的快', 1, 9, 0, 666, 'shixingze', '2022-10-18', 'admin', '2022-10-13 10:51:44', 'admin');
INSERT INTO `blog_comment` VALUES (3, 2, '占个二楼玩一玩', 0, 9, 0, 45, 'shixingze', '2022-10-17', 'admin', '2022-10-13 10:51:44', '');
INSERT INTO `blog_comment` VALUES (4, 3, '你也挺快阿啊vv啊v发vvvv阿飞v啊v阿达v力量的发劳动法驸马拉代码发ADSL驸马', 2, 9, 0, 12, '老王潜力', '2022-10-15', 'admin', '2022-10-13 10:51:44', 'shixingze');
INSERT INTO `blog_comment` VALUES (5, 4, '真的是快', 1, 9, 0, 12, '岁月静好', '2022-10-13', 'admin', '2022-10-13 10:51:44', 'admin');
INSERT INTO `blog_comment` VALUES (6, 1, '请问请问', 0, 9, 0, 0, 'admin', '2022-11-26 :18:33:03', 'admin', '2022-11-26 :18:33:03', NULL);
INSERT INTO `blog_comment` VALUES (8, 4, '时兴泽的评论 啊啊啊啊啊啊啊', 0, 9, 0, 0, 'shixingze', '2022-11-26 :20:40:17', 'shixingze', '2022-11-26 :20:40:17', NULL);
INSERT INTO `blog_comment` VALUES (9, 4, '121212', 0, 9, 0, 0, 'shixingze', '2022-11-26 :21:08:50', 'shixingze', '2022-11-26 :21:08:50', NULL);
INSERT INTO `blog_comment` VALUES (10, 4, '121212', 0, 9, 0, 0, 'shixingze', '2022-11-26 :21:09:20', 'shixingze', '2022-11-26 :21:09:20', NULL);
INSERT INTO `blog_comment` VALUES (11, 1, 'admin来评论了', 0, 13, 0, 0, 'admin', '2022-11-26 :22:16:16', 'admin', '2022-11-26 :22:16:16', NULL);
INSERT INTO `blog_comment` VALUES (12, 4, 'shixingze 也来评论了', 0, 13, 0, 0, 'shixingze', '2022-11-26 :22:16:59', 'shixingze', '2022-11-26 :22:16:59', NULL);
INSERT INTO `blog_comment` VALUES (13, 4, '12', 0, 13, 0, 0, 'shixingze', '2022-11-26 :22:23:58', 'shixingze', '2022-11-26 :22:23:58', NULL);
INSERT INTO `blog_comment` VALUES (14, 4, '12', 0, 9, 0, 0, 'shixingze', '2022-11-27 :12:40:32', 'shixingze', '2022-11-27 :12:40:32', NULL);
INSERT INTO `blog_comment` VALUES (15, 4, 'shixingze评论的', 0, 10, 0, 0, 'shixingze', '2022-11-27 :14:09:10', 'shixingze', '2022-11-27 :14:09:10', NULL);
INSERT INTO `blog_comment` VALUES (16, 4, '2323', 0, 10, 0, 0, 'shixingze', '2022-11-27 :14:34:30', 'shixingze', '2022-11-27 :14:34:30', NULL);
INSERT INTO `blog_comment` VALUES (17, 4, '实习工作1212121212', 0, 9, 0, 0, 'shixingze', '2022-11-27 :15:27:55', 'shixingze', '2022-11-27 :15:27:55', NULL);

-- ----------------------------
-- Table structure for blog_follow
-- ----------------------------
DROP TABLE IF EXISTS `blog_follow`;
CREATE TABLE `blog_follow`  (
  `follow_id` bigint NOT NULL COMMENT '关注id',
  `source_uid` bigint NULL DEFAULT NULL COMMENT '来自者',
  `foris_uid` bigint NULL DEFAULT NULL COMMENT '关注者',
  `create_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '事件',
  PRIMARY KEY (`follow_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '博客关注表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_follow
-- ----------------------------
INSERT INTO `blog_follow` VALUES (1, 2, 1, '2022-12-03');

-- ----------------------------
-- Table structure for blog_label
-- ----------------------------
DROP TABLE IF EXISTS `blog_label`;
CREATE TABLE `blog_label`  (
  `label_id` int NOT NULL AUTO_INCREMENT COMMENT '标签id',
  `label_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '标签名称',
  `label_alias` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标签别名',
  `label_remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标签备注',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`label_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '文章标签' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_label
-- ----------------------------

-- ----------------------------
-- Table structure for blog_look
-- ----------------------------
DROP TABLE IF EXISTS `blog_look`;
CREATE TABLE `blog_look`  (
  `look_id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `look_uid` bigint NULL DEFAULT NULL COMMENT '观看人id',
  `blog_id` bigint NULL DEFAULT NULL COMMENT '文章id',
  `create_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '观看时间',
  PRIMARY KEY (`look_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_look
-- ----------------------------

-- ----------------------------
-- Table structure for blog_start
-- ----------------------------
DROP TABLE IF EXISTS `blog_start`;
CREATE TABLE `blog_start`  (
  `start_id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `blog_id` bigint NULL DEFAULT NULL COMMENT '文章id',
  `user_id` bigint NULL DEFAULT NULL COMMENT '用户id',
  `create_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  `de_flg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除标识',
  PRIMARY KEY (`start_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '博客点赞表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_start
-- ----------------------------
INSERT INTO `blog_start` VALUES (14, 10, 4, '2022-11-27 14:08:18', '0');
INSERT INTO `blog_start` VALUES (16, 9, 4, '2022-11-27 15:27:40', '0');
INSERT INTO `blog_start` VALUES (18, 10, 1, '2022-12-01 12:52:50', '0');
INSERT INTO `blog_start` VALUES (19, 26, 1, '2022-12-03 11:53:20', '0');

-- ----------------------------
-- Table structure for buiness_rating_obj
-- ----------------------------
DROP TABLE IF EXISTS `buiness_rating_obj`;
CREATE TABLE `buiness_rating_obj`  (
  `rating_id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `business_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '业务对象实体',
  `business_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '业务对象实体编码',
  `rating_pid` bigint NULL DEFAULT NULL COMMENT '上级id',
  `buinessthree_pid` int NULL DEFAULT NULL COMMENT '领域上级三级id',
  `sort` int NULL DEFAULT NULL COMMENT '排序',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`rating_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '业务实体对象' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of buiness_rating_obj
-- ----------------------------
INSERT INTO `buiness_rating_obj` VALUES (1, '运输调度', 'D2100401', 0, 9, 1, NULL);
INSERT INTO `buiness_rating_obj` VALUES (2, '货运管理', NULL, 0, 9, 1, NULL);
INSERT INTO `buiness_rating_obj` VALUES (3, '物资管理', NULL, 0, 9, 1, NULL);
INSERT INTO `buiness_rating_obj` VALUES (4, '路网能力', 'D210040101', 1, NULL, 1, NULL);
INSERT INTO `buiness_rating_obj` VALUES (7, '机车编组', 'D210040102', 1, NULL, 1, NULL);
INSERT INTO `buiness_rating_obj` VALUES (8, '调度计划', 'D210040103', 1, NULL, 1, NULL);
INSERT INTO `buiness_rating_obj` VALUES (9, '调度命令', 'D210040104', 1, NULL, 1, NULL);
INSERT INTO `buiness_rating_obj` VALUES (11, '调度指挥', 'D210040105', 1, NULL, 1, NULL);
INSERT INTO `buiness_rating_obj` VALUES (12, '基本运行图', 'D210040106', 1, NULL, 1, NULL);
INSERT INTO `buiness_rating_obj` VALUES (14, '车站行车组织', 'D210040107', 1, NULL, 1, NULL);
INSERT INTO `buiness_rating_obj` VALUES (17, '机车位置', 'D210040108', 1, NULL, 1, NULL);
INSERT INTO `buiness_rating_obj` VALUES (18, '司乘管理', 'D210040109', 1, NULL, 1, NULL);
INSERT INTO `buiness_rating_obj` VALUES (22, '场站作业', 'D210040110', 1, NULL, 1, NULL);

-- ----------------------------
-- Table structure for collection_group
-- ----------------------------
DROP TABLE IF EXISTS `collection_group`;
CREATE TABLE `collection_group`  (
  `group_id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `group_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文件夹名称',
  `group_pid` bigint NULL DEFAULT NULL COMMENT '上级文件夹id',
  `create_time` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '创建时间',
  `user_id` bigint NULL DEFAULT NULL COMMENT '所属用户id',
  `group_remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`group_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of collection_group
-- ----------------------------
INSERT INTO `collection_group` VALUES (1, '测试文件夹', 0, '2022-12-03', 1, '测试');

-- ----------------------------
-- Table structure for form_dengji
-- ----------------------------
DROP TABLE IF EXISTS `form_dengji`;
CREATE TABLE `form_dengji`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户姓名',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机电话',
  `id_card` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `temperature` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '温度',
  `create_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of form_dengji
-- ----------------------------
INSERT INTO `form_dengji` VALUES (11, 'shi', '88', '88', '88', '2022-09-18 13:00:55');
INSERT INTO `form_dengji` VALUES (12, 'we', '1313131', '1111', '11111', '2022-09-18 13:16:27');
INSERT INTO `form_dengji` VALUES (13, 'we', '12', '12', '12', '2022-10-13 14:07:39');
INSERT INTO `form_dengji` VALUES (14, 'we', '12', '12', '12', '2022-10-13 14:08:17');
INSERT INTO `form_dengji` VALUES (15, '', '大菜单', '上是', '大去', '2022-10-15 16:57:33');
INSERT INTO `form_dengji` VALUES (16, '', '1', '12', '1', '2022-10-15 16:57:50');
INSERT INTO `form_dengji` VALUES (17, '', '12', '1', '1', '2022-10-15 16:58:40');
INSERT INTO `form_dengji` VALUES (18, '是现在', '11', '11', '11', '2022-10-15 17:01:29');
INSERT INTO `form_dengji` VALUES (19, '12', '12', '12', '12', '2022-10-15 17:10:20');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menu_id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `pid` bigint NULL DEFAULT NULL COMMENT '上级菜单ID',
  `type` int NULL DEFAULT NULL COMMENT '菜单类型',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单标题',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组件名称',
  `component` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组件',
  `menu_sort` int NULL DEFAULT NULL COMMENT '排序',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '链接地址',
  `i_frame` bit(1) NULL DEFAULT NULL COMMENT '是否外链',
  `hidden` bit(1) NULL DEFAULT b'0' COMMENT '隐藏',
  `permission` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `create_time` bigint NULL DEFAULT NULL COMMENT '创建日期',
  `update_time` bigint NULL DEFAULT NULL COMMENT '更新时间',
  `status` int NULL DEFAULT NULL,
  PRIMARY KEY (`menu_id`) USING BTREE,
  UNIQUE INDEX `uniq_title`(`title`) USING BTREE,
  UNIQUE INDEX `uniq_name`(`name`) USING BTREE,
  INDEX `inx_pid`(`pid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 109 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统菜单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 0, 0, '运维中心', 'system', 'Layout', 6, 'xitong-top', '/system', b'0', b'0', NULL, NULL, 'admin', NULL, 1663730923059, 0);
INSERT INTO `sys_menu` VALUES (2, 1, 1, '用户管理', 'system-user', 'system/user/index', 1, 'peoples', 'user', b'0', b'0', 'user:read', NULL, NULL, NULL, 1620281952752, 0);
INSERT INTO `sys_menu` VALUES (6, 1, 6, '系统参数', 'system-param', 'system/SysParam/index', 6, 'sys-tools', 'system-param', b'0', b'0', 'sysparam:read', NULL, 'admin', NULL, 1651891662781, 0);
INSERT INTO `sys_menu` VALUES (8, 0, 1, '数据服务', 'dataset', 'dataset/index.vue', 3, 'shujufuwu', '/dataset', b'0', b'0', 'data:read', NULL, 'admin', NULL, 1664519715915, 0);
INSERT INTO `sys_menu` VALUES (10, 0, 1, '视图管理', 'view', 'chart/index', 2, 'chengguo', '/chart', b'0', b'0', 'chart:read', NULL, 'admin', NULL, 1663731695859, 0);
INSERT INTO `sys_menu` VALUES (15, 2, 2, '创建用户', NULL, NULL, 10, NULL, NULL, b'0', b'0', 'user:add', NULL, 'admin', 1614930862373, 1654681694145, 0);
INSERT INTO `sys_menu` VALUES (16, 2, 2, '删除用户', NULL, NULL, 10, NULL, NULL, b'0', b'0', 'user:del', NULL, 'admin', 1614930903502, 1649747780278, 0);
INSERT INTO `sys_menu` VALUES (17, 2, 2, '编辑用户', NULL, NULL, 999, NULL, NULL, b'0', b'0', 'user:edit', NULL, NULL, 1614930935529, 1614930935529, 0);
INSERT INTO `sys_menu` VALUES (24, 34, 2, '创建连接', NULL, NULL, 997, NULL, NULL, b'0', b'0', 'datasource:add', NULL, NULL, 1614931168956, 1615783705537, 0);
INSERT INTO `sys_menu` VALUES (28, 2, 2, '修改密码', NULL, NULL, 999, NULL, NULL, b'0', b'0', 'user:editPwd', NULL, NULL, 1615275128262, 1615275128262, 0);
INSERT INTO `sys_menu` VALUES (30, 0, 1, '大屏管理', 'panel', 'panel/index.vue', 1, 'keshihua', '/panel', b'0', b'0', NULL, NULL, 'admin', NULL, 1663731339766, 0);
INSERT INTO `sys_menu` VALUES (34, 0, 1, '数据源', 'datasource', 'system/datasource/index', 4, 'shujuyuan-top', '/datasource', b'0', b'0', 'datasource:read', NULL, 'admin', NULL, 1663731372246, 0);
INSERT INTO `sys_menu` VALUES (35, 1, 1, '用户表单', 'system-user-form', 'system/user/form', 10, '', 'user-form', b'0', b'1', NULL, NULL, 'admin', NULL, 1654680026737, 0);
INSERT INTO `sys_menu` VALUES (39, 0, 1, '数据源表单', 'datasource-form', 'system/datasource/form', 5, NULL, '/ds-form', b'1', b'1', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_menu` VALUES (40, 1, 1, '模板管理', 'system-template', 'panel/template/index', 10, 'dashboard', 'moban', b'0', b'0', 'template:read', NULL, 'admin', NULL, 1652783449920, 0);
INSERT INTO `sys_menu` VALUES (50, 0, 1, '个人信息', 'person-info', 'system/user/privateForm', 999, NULL, '/person-info', b'1', b'1', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_menu` VALUES (51, 0, 1, '重置密码', 'person-pwd-reset', 'system/user/personPwd', 999, NULL, '/person-pwd', b'1', b'1', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_menu` VALUES (52, 0, 1, '关于', 'about', 'system/about/index', 10, 'system', '/about', b'0', b'1', NULL, NULL, 'admin', NULL, 1653014694867, 0);
INSERT INTO `sys_menu` VALUES (53, 1, 6, '站内消息', 'sys-msg-web', 'msg/index', 10, 'all-msg', 'system-msg-web', b'0', b'0', NULL, NULL, 'admin', NULL, 1651891479265, 0);
INSERT INTO `sys_menu` VALUES (54, 53, 6, '所有消息', 'sys-msg-web-all', 'msg/all', 1, 'web-msg', 'all', b'0', b'0', NULL, NULL, 'admin', NULL, 1651891447785, 0);
INSERT INTO `sys_menu` VALUES (55, 53, 6, '未读消息', 'sys-msg-web-unread', 'msg/unread', 2, 'unread-msg', 'unread', b'0', b'0', NULL, NULL, 'admin', NULL, 1651891492792, 0);
INSERT INTO `sys_menu` VALUES (56, 53, 6, '已读消息', 'sys-msg-web-readed', 'msg/readed', 3, 'readed-msg', 'readed', b'0', b'0', NULL, NULL, 'admin', NULL, 1651891506895, 0);
INSERT INTO `sys_menu` VALUES (58, 60, 6, '数据同步', 'sys-task-dataset', 'system/task/dataset', 10, 'dataset-task', 'dataset', b'0', b'0', 'task:read', NULL, 'admin', NULL, 1651891543318, 0);
INSERT INTO `sys_menu` VALUES (59, 53, 6, '接收管理', 'sys-msg-setting', 'msg/setting', 4, 'msg-setting', 'setting', b'0', b'0', NULL, NULL, 'admin', NULL, 1651891516805, 0);
INSERT INTO `sys_menu` VALUES (60, 1, 6, '任务管理', 'sys-task', 'system/task/index', 10, 'task', 'system-task', b'0', b'0', '', NULL, 'admin', NULL, 1651891524895, 0);
INSERT INTO `sys_menu` VALUES (61, 30, 2, '仪表新增', NULL, NULL, NULL, NULL, NULL, NULL, b'0', 'panel:group:add', NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_menu` VALUES (62, 30, 2, '仪表删除', NULL, NULL, NULL, NULL, NULL, NULL, b'0', 'panel:group:delete', NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_menu` VALUES (63, 1, 1, '菜单管理', 'system-menu', 'system/menu/index', 1, 'system', 'menu', b'0', b'0', 'menu:read', NULL, 'admin', NULL, 1663731328183, 0);
INSERT INTO `sys_menu` VALUES (64, 1, 1, '分享链接', 'system-link', 'system/link/index', 1, 'interlinkage', 'link', b'0', b'1', 'link:read', NULL, 'admin', NULL, 1653014788371, 1);
INSERT INTO `sys_menu` VALUES (65, 1, 1, '角色管理', 'system-role', 'system/role/index', 1, 'lole', 'role', b'0', b'0', 'role:read', NULL, NULL, NULL, 1620281952752, 0);
INSERT INTO `sys_menu` VALUES (66, 1, 1, '组织管理', 'system-dept', 'system/dept/index', 1, 'organization', 'dept', b'0', b'0', 'dept:read', NULL, NULL, NULL, 1620281952752, 0);
INSERT INTO `sys_menu` VALUES (98, 30, 1, '仪表盘', 'panel-ybp', 'panel/ybp/index', 1, NULL, 'ybp', b'0', b'0', NULL, 'admin', 'admin', 1651919104832, 1652064001727, 0);
INSERT INTO `sys_menu` VALUES (99, 30, 1, '可视化', 'panel-panel', 'panel/panel/index', 1, NULL, 'panel', b'0', b'0', NULL, 'admin', 'admin', 1651919547728, 1652064009810, 0);
INSERT INTO `sys_menu` VALUES (100, 1, 1, '系统日志', 'system-record', 'system/record/index', 1, 'dashboard', 'record', b'0', b'0', '', 'admin', 'admin', 1652238155551, 1654678554018, 0);
INSERT INTO `sys_menu` VALUES (108, 1, 1, '日志详情', 'system-record-targetdetails', 'system/record/targetdetails.vue', 1, NULL, 'record-targetdetails', b'0', b'1', NULL, 'admin', 'admin', 1654674728191, 1654683712342, 0);
INSERT INTO `sys_menu` VALUES (109, 1, 1, '目录管理', NULL, 'system/catalogue/index', 1, 'sys-tools', 'catalogue', b'0', b'0', NULL, 'admin', NULL, 1654740005903, NULL, 0);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '角色状态（1正常 2停用）',
  `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `create_time` bigint NULL DEFAULT NULL COMMENT '创建日期',
  `update_time` bigint NULL DEFAULT NULL COMMENT '更新时间',
  `del_flag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '逻辑删除',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_id`) USING BTREE,
  UNIQUE INDEX `uniq_name`(`role_name`) USING BTREE,
  INDEX `role_name_index`(`role_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '管理员', '1', '', NULL, 'admin', 1638344503482, 1647395381957, NULL, NULL);
INSERT INTO `sys_role` VALUES (2, '部门及下属管理员', '1', '', NULL, 'admin', 1638344503483, 1647306427707, NULL, NULL);
INSERT INTO `sys_role` VALUES (3, '本部门管理员', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role` VALUES (4, '指定部门管理员', '1', NULL, 'admin', NULL, 1642402338586, NULL, NULL, NULL);
INSERT INTO `sys_role` VALUES (5, '个人员工', '1', NULL, 'admin', 'admin', 1642402869524, 1647395554004, NULL, NULL);

-- ----------------------------
-- Table structure for sys_roles_menus
-- ----------------------------
DROP TABLE IF EXISTS `sys_roles_menus`;
CREATE TABLE `sys_roles_menus`  (
  `menu_id` bigint NOT NULL COMMENT '菜单ID',
  `role_id` bigint NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`menu_id`, `role_id`) USING BTREE,
  INDEX `FKcngg2qadojhi3a651a5adkvbq`(`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色菜单关联' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_roles_menus
-- ----------------------------
INSERT INTO `sys_roles_menus` VALUES (1, 1);
INSERT INTO `sys_roles_menus` VALUES (6, 1);
INSERT INTO `sys_roles_menus` VALUES (8, 1);
INSERT INTO `sys_roles_menus` VALUES (10, 1);
INSERT INTO `sys_roles_menus` VALUES (24, 1);
INSERT INTO `sys_roles_menus` VALUES (30, 1);
INSERT INTO `sys_roles_menus` VALUES (34, 1);
INSERT INTO `sys_roles_menus` VALUES (35, 1);
INSERT INTO `sys_roles_menus` VALUES (40, 1);
INSERT INTO `sys_roles_menus` VALUES (53, 1);
INSERT INTO `sys_roles_menus` VALUES (54, 1);
INSERT INTO `sys_roles_menus` VALUES (55, 1);
INSERT INTO `sys_roles_menus` VALUES (56, 1);
INSERT INTO `sys_roles_menus` VALUES (58, 1);
INSERT INTO `sys_roles_menus` VALUES (59, 1);
INSERT INTO `sys_roles_menus` VALUES (60, 1);
INSERT INTO `sys_roles_menus` VALUES (61, 1);
INSERT INTO `sys_roles_menus` VALUES (62, 1);
INSERT INTO `sys_roles_menus` VALUES (63, 1);
INSERT INTO `sys_roles_menus` VALUES (64, 1);
INSERT INTO `sys_roles_menus` VALUES (65, 1);
INSERT INTO `sys_roles_menus` VALUES (66, 1);
INSERT INTO `sys_roles_menus` VALUES (1, 2);
INSERT INTO `sys_roles_menus` VALUES (2, 2);
INSERT INTO `sys_roles_menus` VALUES (6, 2);
INSERT INTO `sys_roles_menus` VALUES (8, 2);
INSERT INTO `sys_roles_menus` VALUES (15, 2);
INSERT INTO `sys_roles_menus` VALUES (16, 2);
INSERT INTO `sys_roles_menus` VALUES (17, 2);
INSERT INTO `sys_roles_menus` VALUES (24, 2);
INSERT INTO `sys_roles_menus` VALUES (28, 2);
INSERT INTO `sys_roles_menus` VALUES (30, 2);
INSERT INTO `sys_roles_menus` VALUES (34, 2);
INSERT INTO `sys_roles_menus` VALUES (35, 2);
INSERT INTO `sys_roles_menus` VALUES (39, 2);
INSERT INTO `sys_roles_menus` VALUES (40, 2);
INSERT INTO `sys_roles_menus` VALUES (50, 2);
INSERT INTO `sys_roles_menus` VALUES (51, 2);
INSERT INTO `sys_roles_menus` VALUES (52, 2);
INSERT INTO `sys_roles_menus` VALUES (53, 2);
INSERT INTO `sys_roles_menus` VALUES (54, 2);
INSERT INTO `sys_roles_menus` VALUES (55, 2);
INSERT INTO `sys_roles_menus` VALUES (56, 2);
INSERT INTO `sys_roles_menus` VALUES (58, 2);
INSERT INTO `sys_roles_menus` VALUES (59, 2);
INSERT INTO `sys_roles_menus` VALUES (60, 2);
INSERT INTO `sys_roles_menus` VALUES (61, 2);
INSERT INTO `sys_roles_menus` VALUES (62, 2);
INSERT INTO `sys_roles_menus` VALUES (63, 2);
INSERT INTO `sys_roles_menus` VALUES (64, 2);
INSERT INTO `sys_roles_menus` VALUES (65, 2);
INSERT INTO `sys_roles_menus` VALUES (66, 2);
INSERT INTO `sys_roles_menus` VALUES (8, 3);
INSERT INTO `sys_roles_menus` VALUES (10, 3);
INSERT INTO `sys_roles_menus` VALUES (24, 3);
INSERT INTO `sys_roles_menus` VALUES (25, 3);
INSERT INTO `sys_roles_menus` VALUES (26, 3);
INSERT INTO `sys_roles_menus` VALUES (27, 3);
INSERT INTO `sys_roles_menus` VALUES (30, 3);
INSERT INTO `sys_roles_menus` VALUES (34, 3);
INSERT INTO `sys_roles_menus` VALUES (61, 3);
INSERT INTO `sys_roles_menus` VALUES (62, 3);
INSERT INTO `sys_roles_menus` VALUES (50, 5);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `gender` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `is_admin` bit(1) NULL DEFAULT b'0' COMMENT '是否为admin账号',
  `enabled` bigint NULL DEFAULT NULL COMMENT '状态：1启用、0禁用',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新着',
  `pwd_reset_time` bigint NULL DEFAULT NULL COMMENT '修改密码的时间',
  `create_time` bigint NULL DEFAULT NULL COMMENT '创建日期',
  `update_time` bigint NULL DEFAULT NULL COMMENT '更新时间',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像地址',
  `occupation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '从事职业',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '我是管理员哦', '男', '17736590607', 'admin@fit2cloud.com', '123456', b'1', 1, NULL, NULL, NULL, NULL, 1657275529729, 'cover/1662082487496img3.jpg', '站主');
INSERT INTO `sys_user` VALUES (4, 'shixingze', '时分', '男', NULL, '121212@qq.com', '123456', b'0', 1, NULL, NULL, NULL, 1642496161668, 1657275541303, 'cover/d47a4ead30976982a23525e1bf94b7b0.jpg', '后端开发程序员');
INSERT INTO `sys_user` VALUES (5, '1', '智能决策服务', '男', NULL, '123456@qq.com', '123456', b'0', 1, NULL, NULL, NULL, 1657616389280, 1660562745997, NULL, NULL);

-- ----------------------------
-- Table structure for sys_users_roles
-- ----------------------------
DROP TABLE IF EXISTS `sys_users_roles`;
CREATE TABLE `sys_users_roles`  (
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `role_id` bigint NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE,
  INDEX `FKq4eq273l04bpu4efj0jd0jb98`(`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色关联' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_users_roles
-- ----------------------------
INSERT INTO `sys_users_roles` VALUES (1, 1);
INSERT INTO `sys_users_roles` VALUES (5, 2);
INSERT INTO `sys_users_roles` VALUES (15, 2);
INSERT INTO `sys_users_roles` VALUES (4, 5);
INSERT INTO `sys_users_roles` VALUES (5, 5);

-- ----------------------------
-- Triggers structure for table sys_role
-- ----------------------------
DROP TRIGGER IF EXISTS `delete_auth_role_target`;
delimiter ;;
CREATE TRIGGER `delete_auth_role_target` AFTER DELETE ON `sys_role` FOR EACH ROW select delete_auth_target(OLD.role_id,'role') into @ee
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table sys_user
-- ----------------------------
DROP TRIGGER IF EXISTS `delete_auth_user_target`;
delimiter ;;
CREATE TRIGGER `delete_auth_user_target` AFTER DELETE ON `sys_user` FOR EACH ROW select delete_auth_target(OLD.user_id,'user') into @ee
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
