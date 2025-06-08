<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
		<TITLE>修改景点信息</TITLE>
	    <link rel="stylesheet" href="kindeditor_a5/themes/default/default.css" />
	<link rel="stylesheet" href="kindeditor_a5/plugins/code/prettify.css" />
	<script charset="utf-8" src="kindeditor_a5/kindeditor.js"></script>
	<script charset="utf-8" src="kindeditor_a5/lang/zh_CN.js"></script>
	<script charset="utf-8" src="kindeditor_a5/plugins/code/prettify.js"></script>
	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="xiangqingjieshao"]', {
				cssPath : 'kindeditor_a5/plugins/code/prettify.css',
				uploadJson : 'kindeditor_a5/jsp/upload_json.jsp',
				fileManagerJson : 'kindeditor_a5/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
	</script>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>
       
	</head>
<%
  String id="";
 
   %>
<script language="javascript">

function gows()
{
	document.location.href="jingdianxinxi_add.jsp?id=<%=id%>";
}
function hsgxia2shxurxu(nstr,nwbk)
{
	if (eval("form1."+nwbk).value.indexOf(nstr)>=0)
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value.replace(nstr+"；", "");
	}
	else
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value+nstr+"；";
	}
}
</script>
	<body>
			<form action="updateJingdianxinxi.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">修改景点信息<input type="hidden" name="id" value="${jingdianxinxi.id}" /></td>
						</tr>
						<tr ><td width="200">景点编号：</td><td><input name='jingdianbianhao' type='text' id='jingdianbianhao' value='<%=connDbBean.getID()%>' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr ><td width="200">景点名称：</td><td><input name='jingdianmingcheng' type='text' id='jingdianmingcheng' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabeljingdianmingcheng' /></td></tr>		<tr ><td width="200">景点等级：</td><td><select name='jingdiandengji' id='jingdiandengji'><option value="5A">5A</option><option value="4A">4A</option><option value="3A">3A</option><option value="2A">2A</option><option value="A">A</option></select>&nbsp;*<label id='clabeljingdiandengji' /></td></tr>		<tr ><td width="200">门票价格：</td><td><input name='menpiaojiage' type='text' id='menpiaojiage' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;<label id='clabelmenpiaojiage' />必需数字型</td></tr>		<tr ><td width="200">交通状况：</td><td><select name='jiaotongzhuangkuang' id='jiaotongzhuangkuang'><option value="拥堵">拥堵</option><option value="缓慢">缓慢</option><option value="畅通">畅通</option></select></td></tr>		<tr ><td width="200">地理位置：</td><td><input name='diliweizhi' type='text' id='diliweizhi' value='' onblur='' size='50' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr ><td width="200">景点主图：</td><td><input name='jingdianzhutu' type='text' id='jingdianzhutu' size='50' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;<input type='button' value='上传' onClick="up('jingdianzhutu')" style='border:solid 1px #000000; color:#666666'/>&nbsp;*<label id='clabeljingdianzhutu' /></td></tr>		<tr ><td width="200">详情介绍：</td><td><textarea name="xiangqingjieshao" cols="100" rows="8" style="width:700px;height:200px;visibility:hidden;"></textarea></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.jingdianbianhao.value='${jingdianxinxi.jingdianbianhao}';</script>	<script language="javascript">document.form1.jingdianmingcheng.value='${jingdianxinxi.jingdianmingcheng}';</script>	<script language="javascript">document.form1.jingdiandengji.value='${jingdianxinxi.jingdiandengji}';</script>	<script language="javascript">document.form1.menpiaojiage.value='${jingdianxinxi.menpiaojiage}';</script>	<script language="javascript">document.form1.jiaotongzhuangkuang.value='${jingdianxinxi.jiaotongzhuangkuang}';</script>	<script language="javascript">document.form1.diliweizhi.value='${jingdianxinxi.diliweizhi}';</script>	<script language="javascript">document.form1.jingdianzhutu.value='${jingdianxinxi.jingdianzhutu}';</script>	<script language="javascript">document.form1.xiangqingjieshao.value='${jingdianxinxi.xiangqingjieshao}';</script>	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var jingdianmingchengobj = document.getElementById("jingdianmingcheng"); if(jingdianmingchengobj.value==""){document.getElementById("clabeljingdianmingcheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入景点名称</font>";return false;}else{document.getElementById("clabeljingdianmingcheng").innerHTML="  "; } 	var jingdiandengjiobj = document.getElementById("jingdiandengji"); if(jingdiandengjiobj.value==""){document.getElementById("clabeljingdiandengji").innerHTML="&nbsp;&nbsp;<font color=red>请输入景点等级</font>";return false;}else{document.getElementById("clabeljingdiandengji").innerHTML="  "; } 	    var jingdianzhutuobj = document.getElementById("jingdianzhutu"); if(jingdianzhutuobj.value==""){document.getElementById("clabeljingdianzhutu").innerHTML="&nbsp;&nbsp;<font color=red>请输入景点主图</font>";return false;}else{document.getElementById("clabeljingdianzhutu").innerHTML="  "; } 	


return true;   
}   
popheight=450;
</script>  
