﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<jsp:useBean id="code" scope="page" class="com.util.CheckCode" />
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>系统登陆</title>

<meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css" href="images/style.css" tppabs="css/style.css" />
<style>
body{height:100%;background:#16a085;overflow:hidden;}
canvas{z-index:-1;position:absolute;}
body,td,th {
	font-size: 0.28em;
}
</style>
<script src="images/jquery.js"></script>
<script src="images/verificationNumbers.js" tppabs="images/verificationNumbers.js"></script>
<script src="images/Particleground.js" tppabs="images/Particleground.js"></script>
<script>
$(document).ready(function() {
  //粒子背景特效
  $('body').particleground({
    dotColor: '#5cbdaa',
    lineColor: '#5cbdaa'
  });
  //验证码
  createCode();
  //测试提交，对接程序删除即可
  $(".submit_btn").click(function(){
	  location.href="javascrpt:;"/*tpa=http://***index.html*/;
	  });
});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
	<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
	<script type="text/javascript">
	function hsgchecklogin() {
			if(document.f11.username.value=="" || document.f11.pwd.value=="" || document.f11.pagerandom.value=="")
	{
		alert("请输入完整");
		return false;
	}
	if (document.f11.pagerandom.value != document.f11.yzm.value) {
			alert("验证码错误！");
			document.f11.pagerandom.focus();
			return false;
	}
	
	}
	</script>

<body>
<dl class="admin_login">
 <dt>
 <form name="f11" id="f11" method="post" action="hsgloginyanzheng.jsp">
  <strong><font color=white>旅游论坛</font></strong>
  <em>Management System</em>
 </dt>
 <dd class="user_icon">
  <input type="text" placeholder="账号" class="login_txtbx" name="username" id="username"/>
 </dd>
 <dd class="pwd_icon">
  <input type="password" placeholder="密码" class="login_txtbx" name="pwd" id="pwd"/>
 </dd>
 <dd>
 <div style="padding-top:10px;">
  <font color=white>权限：</font><select name="cx" id="cx">
              <option value="管理员">管理员</option>
             <!--quxanxiaxndexnglxu-->
            </select>
	</div>	
 </dd>
 <dd class="val_icon">
  <div class="checkcode">
    <input type="text"  placeholder="验证码" maxlength="4" class="login_txtbx" id="pagerandom" name="pagerandom">
   
  </div>
 &nbsp; <%
								String yzm=code.getCheckCode();
								%>  <input type="hidden" name="yzm" id="yzm" value="<%=yzm %>" >
								   <%=yzm %>
 </dd>
 <dd>
  <input type="submit" value="立即登陆" class="submit_btn" onclick="return hsgchecklogin();"/> <input name="login" type="hidden" id="login" value="1">
 </dd>
 <dd>

 </dd>
 
 </form>
</dl>
</body>
</html>





