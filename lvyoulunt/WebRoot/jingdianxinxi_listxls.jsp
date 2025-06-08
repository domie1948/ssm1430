<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="jingdianxinxihsgb" scope="page" class="com.bean.JingdianxinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=jingdianxinxi.xls");
%>
<html>
  <head>
    <title>景点信息</title>
  </head>

  <body >
 <%
			String sql="select * from jingdianxinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>景点编号</td>    <td align='center'>景点名称</td>    <td align='center'>景点等级</td>    <td align='center'>门票价格</td>    <td align='center'>交通状况</td>    <td align='center'>地理位置</td>    <td  width='90' align='center'>景点主图</td>        <td  width='80' align='center'>是否审核</td>
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=jingdianxinxihsgb.getAllJingdianxinxi(11);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.jingdianbianhao}</td>    <td>${u.jingdianmingcheng}</td>    <td>${u.jingdiandengji}</td>    <td>${u.menpiaojiage}</td>    <td>${u.jiaotongzhuangkuang}</td>    <td>${u.diliweizhi}</td>    <td width='90' align='center'><a href='${u.jingdianzhutu}' target='_blank'><img src='${u.jingdianzhutu}' width=88 height=99 border=0 /></a></td>        <td align='center'>${u.issh} <input type="button" value="审核" onclick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=jingdianxinxi'"/></td>
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

