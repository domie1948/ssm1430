﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>站内私信详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  站内私信详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>收件人：</td><td width='39%'>${zhanneisixin.shoujianren}</td>     <td width='11%'>标题：</td><td width='39%'>${zhanneisixin.biaoti}</td></tr><tr>     <td width='11%'>内容：</td><td width='39%'>${zhanneisixin.neirong}</td>     <td width='11%'>发件人：</td><td width='39%'>${zhanneisixin.fajianren}</td></tr><tr>     <td width='11%'>权限：</td><td width='39%'>${zhanneisixin.quanxian}</td>     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

