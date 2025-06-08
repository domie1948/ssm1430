<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>游记信息详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  游记信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%' height=44>游记编号：</td><td width='39%'>${youjixinxi.youjibianhao}</td><td  rowspan=6 align=center><a href=${youjixinxi.fengmiantupian} target=_blank><img src=${youjixinxi.fengmiantupian} width=228 height=215 border=0></a></td></tr><tr><td width='11%' height=44>游记标题：</td><td width='39%'>${youjixinxi.youjibiaoti}</td></tr><tr><td width='11%' height=44>行程时间：</td><td width='39%'>${youjixinxi.xingchengshijian}</td></tr><tr><td width='11%' height=44>主要景点：</td><td width='39%'>${youjixinxi.zhuyaojingdian}</td></tr><tr><td width='11%' height=44>行程路线：</td><td width='39%'>${youjixinxi.xingchengluxian}</td></tr><tr><td width='11%' height=44>发布人：</td><td width='39%'>${youjixinxi.faburen}</td></tr><tr><td width='11%' height=100  >内容详情：</td><td width='39%' colspan=2 height=100 >${youjixinxi.neirongxiangqing}</td></tr><tr><td colspan=3 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

