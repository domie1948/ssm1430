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
		<TITLE>修改游记信息</TITLE>
	    <link rel="stylesheet" href="kindeditor_a5/themes/default/default.css" />
	<link rel="stylesheet" href="kindeditor_a5/plugins/code/prettify.css" />
	<script charset="utf-8" src="kindeditor_a5/kindeditor.js"></script>
	<script charset="utf-8" src="kindeditor_a5/lang/zh_CN.js"></script>
	<script charset="utf-8" src="kindeditor_a5/plugins/code/prettify.js"></script>
	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="neirongxiangqing"]', {
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
	document.location.href="youjixinxi_add.jsp?id=<%=id%>";
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
			<form action="updateYoujixinxi.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">修改游记信息<input type="hidden" name="id" value="${youjixinxi.id}" /></td>
						</tr>
						<tr ><td width="200">游记编号：</td><td><input name='youjibianhao' type='text' id='youjibianhao' value='<%=connDbBean.getID()%>' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr ><td width="200">游记标题：</td><td><input name='youjibiaoti' type='text' id='youjibiaoti' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelyoujibiaoti' /></td></tr>		<tr ><td width="200">封面图片：</td><td><input name='fengmiantupian' type='text' id='fengmiantupian' size='50' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;<input type='button' value='上传' onClick="up('fengmiantupian')" style='border:solid 1px #000000; color:#666666'/>&nbsp;*<label id='clabelfengmiantupian' /></td></tr>		<tr ><td width="200">行程时间：</td><td><input name='xingchengshijian' type='text' id='xingchengshijian' value='<%=connDbBean.getdate()%>' onblur='' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:100px; height:16px; border:solid 1px #000000; color:#666666'/></td></tr>		<tr ><td width="200">主要景点：</td><td><input name='zhuyaojingdian' type='text' id='zhuyaojingdian' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelzhuyaojingdian' /></td></tr>		<tr ><td width="200">行程路线：</td><td><input name='xingchengluxian' type='text' id='xingchengluxian' value='' onblur='' size='50' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr ><td width="200">内容详情：</td><td><textarea name="neirongxiangqing" cols="100" rows="8" style="width:700px;height:200px;visibility:hidden;"></textarea></td></tr>		<tr ><td width="200">发布人：</td><td><input name='faburen' type='text' id='faburen' onblur='' style='border:solid 1px #000000; color:#666666' value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.youjibianhao.value='${youjixinxi.youjibianhao}';</script>	<script language="javascript">document.form1.youjibiaoti.value='${youjixinxi.youjibiaoti}';</script>	<script language="javascript">document.form1.fengmiantupian.value='${youjixinxi.fengmiantupian}';</script>	<script language="javascript">document.form1.xingchengshijian.value='${youjixinxi.xingchengshijian}';</script>	<script language="javascript">document.form1.zhuyaojingdian.value='${youjixinxi.zhuyaojingdian}';</script>	<script language="javascript">document.form1.xingchengluxian.value='${youjixinxi.xingchengluxian}';</script>	<script language="javascript">document.form1.neirongxiangqing.value='${youjixinxi.neirongxiangqing}';</script>	<script language="javascript">document.form1.faburen.value='${youjixinxi.faburen}';</script>	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var youjibiaotiobj = document.getElementById("youjibiaoti"); if(youjibiaotiobj.value==""){document.getElementById("clabelyoujibiaoti").innerHTML="&nbsp;&nbsp;<font color=red>请输入游记标题</font>";return false;}else{document.getElementById("clabelyoujibiaoti").innerHTML="  "; } 	var fengmiantupianobj = document.getElementById("fengmiantupian"); if(fengmiantupianobj.value==""){document.getElementById("clabelfengmiantupian").innerHTML="&nbsp;&nbsp;<font color=red>请输入封面图片</font>";return false;}else{document.getElementById("clabelfengmiantupian").innerHTML="  "; } 	var zhuyaojingdianobj = document.getElementById("zhuyaojingdian"); if(zhuyaojingdianobj.value==""){document.getElementById("clabelzhuyaojingdian").innerHTML="&nbsp;&nbsp;<font color=red>请输入主要景点</font>";return false;}else{document.getElementById("clabelzhuyaojingdian").innerHTML="  "; } 	


return true;   
}   
popheight=450;
</script>  
