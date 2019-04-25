<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>Insert title here</title>
<head>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript">
function checkit()
{
	//判断是否是数字的正则表达式
	var p1 = "^\\d+$";
	var proId = document.form1.proId;
	var proName = document.form1.proName;
	if(proName.value=="")
	{
		alert("请输入供应商名称");
		proName.focus();
		return false;
	}
	return true;
}
</script>
</head>
<body>
<div class="main">
	<div class="optitle clearfix">
		<div class="title">供应商管理&gt;&gt;</div>
	</div>
	<form id="form1" name="form1" method="post" action="ProAddServlet" onsubmit="return checkit();">
		<div class="content">
		<font color="red">${requestScope.change}</font>
<input type="hidden" name="flag" value="doAdd">
			<table class="box">
				<tr>
					<td class="field">供应商名称：</td>
					<td><input type="text" name="proName" id="textfield2" value="${requestScope.proInfo.name}" class="text"/> <font color="red">*</font></td>
				</tr>
			<tr>
					<td class="field">供应商描述：</td>
					<td><textarea name="proDesc" id="textarea" cols="45" rows="5">${requestScope.proInfo.desc}</textarea></td>
				</tr>
				<tr>
					<td class="field">供应商联系：</td>
					<td><input type="text" name="contact" id="textfield2" value="${requestScope.proInfo.contact}" class="text"/></td>
				</tr>
				<tr>
					<td class="field">供应商电话：</td>
					<td><input type="text" name="phone" id="textfield2" value="${requestScope.proInfo.phone}" class="text"/></td>
				</tr>
				<tr>
					<td class="field">供应商传真：</td>
					<td><input type="text" name="fax" id="textfield2" value="${requestScope.proInfo.fax}" class="text"/></td>
				</tr>
				<tr>
					<td class="field">供应商地址：</td>
					<td><input type="text" name="address" id="textfield2" value="${requestScope.proInfo.address}" class="text"/></td>
				</tr>
			</table>
		</div>
		<div class="buttons">
			<input type="submit" name="button" id="button" value="提交" class="input-button"/> 
			<input type="button" name="button" id="button" onclick="window.location.href='ViewServlet';" value="返回" class="input-button"/> 
		</div>
	</form>
</div>
</body>
</html>
