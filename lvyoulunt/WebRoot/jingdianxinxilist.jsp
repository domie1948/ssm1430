﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>景点信息</title>

<link rel="stylesheet" type="text/css" href="qtimages/css/base.css"/>
<link rel="stylesheet" type="text/css" href="qtimages/css/sonpage.css"/>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>

<script type="text/javascript" src="qtimages/jquery.js"></script>
<script type="text/javascript" src="qtimages/inc.js"></script>
<link rel="stylesheet" href="qtimages/hsgbanner.css">
<style type="text/css">
<!--
.STYLE1 {
	font-size: 18px;
	font-weight: bold;
	color: #147001;
}
-->
</style>
</head>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>

<%

%>

<body>

<jsp:include page="qttop.jsp"></jsp:include>
<jsp:include page="hsgbanner.jsp"></jsp:include>

<jsp:include page="bht.jsp"></jsp:include>


<div class="center-content">
	<div class="leftbox">
          <div class="c-left">
              <ul><h2>景点信息/<span>Details</span></h2></ul>
              <!--<ol>
                  <li><a href="#">公司新闻</a></li>
                  <li><a href="#">行业动态</a></li>
				  <li><a href="#">公司新闻</a></li>
                  <li><a href="#">行业动态</a></li>
				  <li><a href="#">公司新闻</a></li>
                  <li><a href="#">行业动态</a></li>
              </ol>-->
          </div>

          <div class="albaba">
          	<a href="#"><img src="qtimages/alibaba.png" width="250" height="500"/></a>
          </div>
                    <div class="conacts">
                	
					<ul>
                    	<li>公司地址：xxxxxxxxC-xxxxxx室
</li>
                     	<li>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;编：xxxx</li>
                        <li>电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话：xxx-xxxx xxx-xxxxx</li>
                        <li>传&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;真：0871-xxxxx</li>
                        <li>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：xxxxxxx@163.com
</li>                 
                    </ul>
           </div>
    </div>
    <div class="c-right">
    	<div class="tree-nav">
        	<h2>景点信息</h2>
            <p><a href="index.do">首页</a>/ 景点信息</p>
        </div>
<div class="news_content">
                                
								
<form action="jdxxList.do" name="myform" method="post">
									查询   景点名称：<input name="jingdianmingcheng" type="text" id="jingdianmingcheng" style='border:solid 1px #000000; color:#666666' size="12" /> 景点等级：<select name='jingdiandengji' id='jingdiandengji' style='border:solid 1px #000000; color:#666666;'><option value="">所有</option><option value="5A">5A</option><option value="4A">4A</option><option value="3A">3A</option><option value="2A">2A</option><option value="A">A</option></select>  门票价格：<input name="menpiaojiage" type="text" id="menpiaojiage" style='border:solid 1px #000000; color:#666666' size="12" /> 交通状况：<select name='jiaotongzhuangkuang' id='jiaotongzhuangkuang' style='border:solid 1px #000000; color:#666666;'><option value="">所有</option><option value="拥堵">拥堵</option><option value="缓慢">缓慢</option><option value="畅通">畅通</option></select>  地理位置：<input name="diliweizhi" type="text" id="diliweizhi" style='border:solid 1px #000000; color:#666666' size="12" />
									<input type="submit" value="查询" /> <input type="button" name="Submit2" value="切换视图"  onClick="javascript:location.href='jdxxListtp.do';" />
								</form>	

	
<br />
<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                          <tr>
                            <td align="center" bgcolor="#ebf0f7" width="30px">序号</td>
                            <td bgcolor='#ebf0f7'>景点编号</td>    <td bgcolor='#ebf0f7'>景点名称</td>    <td bgcolor='#ebf0f7'>景点等级</td>    <td bgcolor='#ebf0f7'>门票价格</td>    <td bgcolor='#ebf0f7'>交通状况</td>    <td bgcolor='#ebf0f7'>地理位置</td>    <td bgcolor='#ebf0f7' width='90' align='center'>景点主图</td>        
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 添加时间 </td>
                            <td align="center" bgcolor="#ebf0f7" width="50px"> 操作 </td>
                          </tr>
                          <%
					int i=0;
				%>
                          <c:forEach items="${list}" var="u">
                            <%
					i++;
				%>
                            <tr align="center" bgcolor="#FFFFFF">
                              <td align="center"><%=i%></td>
                             <td>${u.jingdianbianhao}</td>    <td>${u.jingdianmingcheng}</td>    <td>${u.jingdiandengji}</td>    <td>${u.menpiaojiage}</td>    <td>${u.jiaotongzhuangkuang}</td>    <td>${u.diliweizhi}</td>    <td width='90'><a href='${u.jingdianzhutu}' target='_blank'><img src='${u.jingdianzhutu}' width=88 height=99 border=0 /></a></td>        
                              <td align="center"> ${u.addtime} </td>
                              <td align="center"><a href="jdxxDetail.do?id=${u.id}">详细</a></td>
                            </tr>
                          </c:forEach>
                        </table>
<br>

<p align="center"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="jdxxList.do?page=1" >首页</a>
             <a href="jdxxList.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="jdxxList.do?page=${page.page+1 }">下一页</a>
			<a href="jdxxList.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>




					  
      </div>
                            
    </div>
</div>




<jsp:include page="qtdown.jsp"></jsp:include>

</body>
</html>
