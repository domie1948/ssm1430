<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="zhanneisixinhsgb" scope="page" class="com.bean.ZhanneisixinBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=zhanneisixin.xls");
%>
<html>
  <head>
    <title>վ��˽��</title>
  </head>

  <body >
 <%
			String sql="select * from zhanneisixin  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">���</td>
    <td align='center'>�ռ���</td>    <td align='center'>����</td>        <td align='center'>������</td>    <td align='center'>Ȩ��</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">���ʱ��</td>
    
  </tr>
   <%		
				List pagelist3=zhanneisixinhsgb.getAllZhanneisixin(7);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.shoujianren}</td>    <td>${u.biaoti}</td>        <td>${u.fajianren}</td>    <td>${u.quanxian}</td>    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

