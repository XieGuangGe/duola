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
	//�ж��Ƿ������ֵ�������ʽ
	var p1 = "^\\d+$";
	var userId = document.form1.userId;
	var username = document.form1.username;
	var password = document.form1.password;
	var password1 = document.form1.password1;
	var age = document.form1.age;
	var mobile = document.form1.mobile;
	if(username.value=="")
	{
		alert("�������û�����");
		username.focus();
		return false;
	}
	if(password.value=="")
	{
		alert("����������");
		password.focus();
		return false;
	}
	if(password1.value=="")
	{
		alert("������ȷ������");
		password1.focus();
		return false;
	}
	if(password.value!=password1.value)
	{
		alert("�����������벻ͬ");
		password1.focus();
		return false;
	}
	if(age.value=="")
	{
		alert("����������");
		age.focus();
		return false;
	}
	else
	{
		var pattern = new RegExp(p1);
		if(!pattern.test(age.value))
		{
			alert("��������������");
			age.value="";
			age.focus();
			return false;
		}
	}
	if(mobile.value=="")
	{
		alert("������绰");
		mobile.focus();
		return false;
	}
	else
	{
		var pattern = new RegExp(p1);
		if(!pattern.test(mobile.value))
		{
			alert("��������������");
			mobile.value="";
			mobile.focus();
			return false;
		}
	}
	return true;
}
</script>
</head>
<body>
<div class="main">
	<div class="optitle clearfix">
		<div class="title">�û�����&gt;&gt;</div>
	</div>
	<form id="form1" name="form1" method="post" action="UserAddServlet" onsubmit="return checkit();">
<input type="hidden" name="flag" value="doAdd">
		<div class="content">
			<table class="box"><font color="red">${requestScope.change}</font>
			<tr>
					<td class="field">�û����ƣ�</td>
					<td><input type="text" name="username" class="text" id="textfield2" /> <font color="red">*</font></td>
				</tr>
				<tr>
					<td class="field">�û����룺</td>
					<td><input type="password" name="password" class="text" id="textfield2" /> <font color="red">*</font></td>
				</tr>
			<tr>
					<td class="field">ȷ�����룺</td>
					<td><input type="password" name="password1" class="text"/> <font color="red">*</font></td>
				</tr>
				<tr>
					<td class="field">�û��Ա�</td>
					<td><select name="sex" id="select">
    <option value="0">Ů</option>
    <option value="1">��</option>
  </select></td>
				</tr>
				<tr>
					<td class="field">�û����䣺</td>
					<td><input type="text" name="age" class="text" id="textfield2"/> <font color="red">*</font></td>
				</tr>
				<tr>
					<td class="field">�û��绰��</td>
					<td><input type="text" name="mobile" class="text" id="textfield2"/> <font color="red">*</font></td>
				</tr>
				<tr>
					<td class="field">�û���ַ��</td>
					<td><textarea name="address" id="textarea" class="text" cols="45" rows="5"></textarea></td>
				</tr>
				<tr>
					<td class="field">�û�Ȩ�ޣ�</td>
					<td><input type="radio" name="auth" id="auth" value="0" checked="checked"/>��ͨ�û�
					<input type="radio" name="auth" id="auth" value="1" />����</td>
				</tr>
			</table>
		</div>
		<div class="buttons">
			<input type="submit" name="button" id="button" value="�����ύ" class="input-button"/>
			  <input type="button" name="button" id="button" onclick="window.location='UserStudentServlet';" value="����" class="input-button"/> 
		</div>
	</form>
</div>
</body>
</html>
