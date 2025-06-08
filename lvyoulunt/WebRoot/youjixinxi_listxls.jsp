<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="youjixinxihsgb" scope="page" class="com.bean.YoujixinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=youjixinxi.xls");
%>
<html>
  <head>
    <title>游记信息</title>
  </head>

  <body >
 <%
			String sql="select * from youjixinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>游记编号</td>    <td align='center'>游记标题</td>    <td  width='90' align='center'>封面图片</td>    <td  width='65' align='center'>行程时间</td>    <td align='center'>主要景点</td>    <td align='center'>行程路线</td>        <td align='center'>发布人</td>    <td  width='80' align='center'>是否审核</td>
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=youjixinxihsgb.getAllYoujixinxi(11);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.youjibianhao}</td>    <td>${u.youjibiaoti}</td>    <td width='90' align='center'><a href='${u.fengmiantupian}' target='_blank'><img src='${u.fengmiantupian}' width=88 height=99 border=0 /></a></td>    <td>${u.xingchengshijian}</td>    <td>${u.zhuyaojingdian}</td>    <td>${u.xingchengluxian}</td>        <td>${u.faburen}</td>    <td align='center'>${u.issh} <input type="button" value="审核" onclick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=youjixinxi'"/></td>
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

