﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>左侧导航</title>
<head>
<link rel="stylesheet" type="text/css" href="images/index.css">
<style type="text/css">
body{margin:0;padding:0;overflow-x:hidden;}
html, body{height:100%;}
img{border:none;}
*{font-family:'微软雅黑';font-size:12px;color:#626262;}
dl,dt,dd{display:block;margin:0;}
a{text-decoration:none;}

#bg{background-image:url(images/content/dotted.png);}
.container{width:100%;height:100%;margin:auto;}

/*left*/
.leftsidebar_box{width:160px;height:auto !important;overflow:visible !important;position:fixed;height:100% !important;background-color:#339999;}
.line{height:2px;width:100%;background-image:url(images/left/line_bg.png);background-repeat:repeat-x;}
.leftsidebar_box dt{padding-left:40px;padding-right:10px;background-repeat:no-repeat;background-position:10px center;color:#f5f5f5;font-size:14px;position:relative;line-height:48px;cursor:pointer;}
.leftsidebar_box dd{background-color:#339999;padding-left:40px;}
.leftsidebar_box dd a{color:#f5f5f5;line-height:20px;}
.leftsidebar_box dt img{position:absolute;right:10px;top:20px;}
.system_log dt{background-image:url(images/left/system.png)}
.custom dt{background-image:url(images/left/custom.png)}
.channel dt{background-image:url(images/left/channel.png)}
.app dt{background-image:url(images/left/app.png)}
.cloud dt{background-image:url(images/left/cloud.png)}
.syetem_management dt{background-image:url(images/left/syetem_management.png)}
.source dt{background-image:url(images/left/source.png)}
.statistics dt{background-image:url(images/left/statistics.png)}
.leftsidebar_box dl dd:last-child{padding-bottom:10px;}
</style>
</head>

<body id="bg">

<div class="container">
   
	<div class="leftsidebar_box">
	
		<dl class="system_log">
			<dt onClick="changeImage()">个人资料管理<img src="images/left/select_xl01.png"></dt>
			<dd><a href="doUpdateYonghuzhuce2.do" target="rightFrame">个人资料管理</a></dd>
		</dl>
	
		<dl class="cloud">
			<dt onClick="changeImage()">我的游记信息<img src="images/left/select_xl01.png"></dt>
			<dd class="first_dd"><a href="youjixinxi_add.jsp" target="rightFrame">游记信息添加</a></dd>
			<dd><a href="youjixinxiList2.do" target="rightFrame">我的游记信息</a></dd>
		</dl>
	
		<dl class="syetem_management">
			<dt onClick="changeImage()">我的问答帖子<img src="images/left/select_xl01.png"></dt>
			<dd><a href="tieziList2.do" target="rightFrame">我的问答帖子</a></dd>
		</dl>
	
		<dl class="app">
			<dt onClick="changeImage()">我的收藏记录<img src="images/left/select_xl01.png"></dt>
			<dd class="first_dd"><a href="shoucangjiluList2.do" target="rightFrame">我的收藏记录</a></dd>
		</dl>
	
		 <dl class="cloud">
			<dt onClick="changeImage()">个人相册管理<img src="images/left/select_xl01.png"></dt>
			<dd><a href="gerenxiangce_add.jsp" target="rightFrame">个人相册添加</a></dd>
			<dd><a href="gerenxiangceList2.do" target="rightFrame">个人相册管理</a></dd>

		</dl>
	
		 <dl class="source">
			<dt onClick="changeImage()">站内私信管理<img src="images/left/select_xl01.png"></dt>
			<dd class="first_dd"><a href="zhanneisixin_add.jsp" target="rightFrame">我要发信</a></dd>
			<dd><a href="zhanneisixinList2.do" target="rightFrame">发件箱</a></dd>
			<dd><a href="zhanneisixinList3.do" target="rightFrame">收件箱</a></dd>
		</dl>
	
	<%--	<dl class="statistics">
			<dt>系统管理<img src="images/left/select_xl01.png"></dt>
			
			<dd><a href="youqinglianjie_add.jsp" target="rightFrame">友情连接添加</a></dd>
			<dd><a href="youqinglianjieList.do" target="rightFrame">友情连接查询</a></dd>
			<dd><a href="dx.jsp?lb=系统简介" target="rightFrame">系统简介设置</a></dd>
			<dd><a href="dx.jsp?lb=系统公告" target="rightFrame">系统公告设置</a></dd>
		</dl> --%>
	
	</div>

</div>

<script type="text/javascript" src="images/jquery.js"></script>
<script type="text/javascript">
$(".leftsidebar_box dt").css({"background-color":"#339999"});
$(".leftsidebar_box dt img").attr("src","images/left/select_xl01.png");
$(function(){
	$(".leftsidebar_box dd").hide();
	$(".leftsidebar_box dt").click(function(){
		$(".leftsidebar_box dt").css({"background-color":"#339999"})
		$(this).css({"background-color": "#339999"});
		$(this).parent().find('dd').removeClass("menu_chioce");
		$(".leftsidebar_box dt img").attr("src","images/left/select_xl01.png");
		$(this).parent().find('img').attr("src","images/left/select_xl.png");
		$(".menu_chioce").slideUp(); 
		$(this).parent().find('dd').slideToggle();
		$(this).parent().find('dd').addClass("menu_chioce");
	});
})
</script>


</body>
</html>
