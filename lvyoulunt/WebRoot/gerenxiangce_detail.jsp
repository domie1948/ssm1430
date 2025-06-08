<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>个人相册详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  个人相册详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%' height=44>编号：</td><td width='39%'>${gerenxiangce.bianhao}</td><td  rowspan=4 align=center><a href=${gerenxiangce.fengmian} target=_blank><img src=${gerenxiangce.fengmian} width=228 height=215 border=0></a></td></tr><tr><td width='11%' height=44>名称：</td><td width='39%'>${gerenxiangce.mingcheng}</td></tr><tr><td width='11%' height=44>主题：</td><td width='39%'>${gerenxiangce.zhuti}</td></tr><tr><td width='11%' height=44>用户名：</td><td width='39%'>${gerenxiangce.yonghuming}</td></tr><tr><td width='11%' height=100  >相片：</td><td width='39%' colspan=2 height=100 >${gerenxiangce.xiangpian}</td></tr><tr><td colspan=3 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

