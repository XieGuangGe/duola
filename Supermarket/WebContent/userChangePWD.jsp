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
		var oldpassword = document.form1.oldpassword;
		var password = document.form1.password;
		var password1 = document.form1.password1;
		if (oldpassword.value == "") {
			alert("������ɵ�����");
			oldpassword.focus();
			return false;
		}
		if (password.value == "") {
			alert("�������µ�����");
			password.focus();
			return false;
		}
		if (password1.value == "") {
			alert("������ȷ������");
			password1.focus();
			return false;
		}
		if (password1.value != password.value) {
			alert("�����������벻ͬ");
			password1.value = "";
			password.value = "";
			password.focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<div class="main">
		<div class="optitle clearfix">
			<div class="title">�˵�����&gt;&gt;</div>
		</div>

		<form id="form1" name="form1" method="post" action="ChangePswd"
			onsubmit="return checkit();">
			<input type="hidden" name="flag" value="userChangePWD"> <input
				type="hidden" name="userId" value="${requestScope.id}">
			<div class="content">
				<table class="box">
					<font color='red'>${requestScope.change}</font>
					<tr>
						<td class="field">�ɵ����룺</td>
						<td><input type="password" name="oldpassword" class="text"
							id="textfield2" /></td>
							<input type="hidden" name="repswd" value="${requestScope.user.password }"/>
							<input type="hidden" name="id" value="${requestScope.user.id }"/>
							
					</tr>
					<tr>
						<td class="field">�µ����룺</td>
						<td><input type="password" name="password" class="text"
							id="textfield2" /></td>
					</tr>
					<tr>
						<td class="field">ȷ�����룺</td>
						<td><input type="password" name="password1" class="text"
							id="textfield2" /></td>
					</tr>
				</table>
			</div>
			<div class="buttons">
				<input type="submit" name="button" id="button" value="�޸�����"
					class="input-button" /> <input type="button" name="button"
					id="button" class="input-button"
					onclick="window.location='UserStudentServlet?id=${requestScope.id}&flag=mod'"
					value="����" />
			</div>
		</form>
	</div>
</body>
</html>
