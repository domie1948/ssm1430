<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>景点信息详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  景点信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%' height=44>景点编号：</td><td width='39%'>${jingdianxinxi.jingdianbianhao}</td><td  rowspan=6 align=center><a href=${jingdianxinxi.jingdianzhutu} target=_blank><img src=${jingdianxinxi.jingdianzhutu} width=228 height=215 border=0></a></td></tr><tr><td width='11%' height=44>景点名称：</td><td width='39%'>${jingdianxinxi.jingdianmingcheng}</td></tr><tr><td width='11%' height=44>景点等级：</td><td width='39%'>${jingdianxinxi.jingdiandengji}</td></tr><tr><td width='11%' height=44>门票价格：</td><td width='39%'>${jingdianxinxi.menpiaojiage}</td></tr><tr><td width='11%' height=44>交通状况：</td><td width='39%'>${jingdianxinxi.jiaotongzhuangkuang}</td></tr><tr><td width='11%' height=44>地理位置：</td><td width='39%'>${jingdianxinxi.diliweizhi}</td></tr><tr><td width='11%' height=100  >详情介绍：</td><td width='39%' colspan=2 height=100 >${jingdianxinxi.xiangqingjieshao}</td></tr><tr><td colspan=3 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

