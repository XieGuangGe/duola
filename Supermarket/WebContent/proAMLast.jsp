<%@ page language="java" contentType="text/html; charset=gbk"
	pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>Insert title here</title>
<head>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript">
	function checkit() {
		//判断是否是数字的正则表达式
		var p1 = "^\\d+$";
		var proName = document.form1.proName;
		if (proName.value == "") {
			alert("请输入供应商名称");
			proName.focus();
			return false;
		}
		if (confirm("确认修改？"))
			return true;
		else
			return false;
	}
</script>
</head>
<body>
	<div class="main">
		<div class="optitle clearfix">
			<div class="title">供应商管理&gt;&gt;</div>
		</div>
		<form id="form1" name="form1" method="post" action="ModifyServlet"
			onsubmit="checkit();">
			<input type="hidden" name="flag" value="modify">
			<div class="content">
				<table class="box">
					<tr>
						<td class="field">供应商编号：</td>
						<td><input type="hidden" name="proId"
							value="${requestScope.proInfo.id}"><input type="text"
							class="text" name="id" id="textfield" disabled="disabled"
							value="${requestScope.proInfo.id}" /></td>
					</tr>
					<tr>
						<td class="field">供应商名称：</td>
						<td><input type="text" name="proName" id="textfield2"
							class="text" value="${requestScope.proInfo.pro_name}" /></td>
					</tr>
					<tr>
						<td class="field">供应商描述：</td>
						<td><textarea name="proDesc" id="textarea" cols="45" rows="5"
								class="text">${requestScope.proInfo.pro_desc}</textarea></td>
					</tr>
					<tr>
						<td class="field">供应商联系：</td>
						<td><input type="text" name="contact" id="textfield2"
							class="text" value="${requestScope.proInfo.pro_contact}" /></td>
					</tr>
					<tr>
						<td class="field">供应商电话：</td>
						<td><input type="text" name="phone" id="textfield2"
							class="text" value="${requestScope.proInfo.pro_phone}" /></td>
					</tr>
					<tr>
						<td class="field">供应商传真：</td>
						<td><input type="text" name="fax" id="textfield2"
							class="text" value="${requestScope.proInfo.pro_fax}" /></td>
					</tr>
					<tr>
						<td class="field">供应商地址：</td>
						<td><input type="text" name="address" id="textfield2"
							class="text" value="${requestScope.proInfo.pro_address}" /></td>
					</tr>
				</table>
			</div>
			<div class="buttons">
				<input type="button" name="button" id="button"
					onclick="window.location.href='StudentServlet'"
					value="返回" class="input-button" /> <input type="submit"
					name="button" id="button" value="提交" class="input-button" />
			</div>
		</form>
	</div>
</body>
</html>