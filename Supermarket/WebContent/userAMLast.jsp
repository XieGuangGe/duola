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
	var username = document.form1.username;
	var age = document.form1.age;
	var mobile = document.form1.mobile;
	if(username.value=="")
	{
		alert("�������û�����");
		username.focus();
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
	if(confirm("ȷ���޸ģ�"))
		return true;
	else
		return false;
}
</script>
</head>
<body>
<div class="main">
	<div class="optitle clearfix">
		<div class="title">�û�����&gt;&gt;</div>
	</div>
	<form id="form1" name="form1" method="post" action="UpdateSucServlet" onsubmit="return checkit();">
<input type="hidden" name="flag" value="modify">
		<div class="content">
			<table class="box">
			<tr>
					<td class="field">�û���ţ�</td>
					<td><input type="hidden" name="userId" value="${requestScope.userInfo.id}"><input type="text" name="id" disabled="disabled" class="text" id="textfield"  value="${requestScope.userInfo.id}"/></td>
				</tr>
				<tr>
					<td class="field">�û����ƣ�</td>
					<td><input type="text" name="username" class="text" id="textfield2"  value="${requestScope.userInfo.username}"/></td>
				</tr>
				<tr>
					<td class="field">�û��Ա�</td>
					<td><select name="sex" id="select"  class="text">
     <c:choose>
     <c:when test="${requestScope.userInfo.sex==0}">
     <option value="0" selected="selected">Ů</option>
    <option value="1">��</option>
     </c:when>
     <c:otherwise>
     <option value="0" >Ů</option>
    <option value="1" selected="selected">��</option>
     </c:otherwise>
     </c:choose>
  </select></td>
				</tr>
				<tr>
					<td class="field">�û����䣺</td>
					<td><input type="text" name="age" id="textfield2" class="text"  value="${requestScope.userInfo.age}"/> </td>
				</tr>
				<tr>
					<td class="field">�û��绰��</td>
					<td><input type="text" name="mobile" id="textfield2" class="text"  value="${requestScope.userInfo.mobile}"/> </td>
				</tr>
				<tr>
					<td class="field">�û���ַ��</td>
					<td><textarea name="address" id="textarea" cols="45" rows="5" class="text" > ${requestScope.userInfo.address}</textarea></td>
				</tr>
				
				<c:if test="${sessionScope.user.common==1&&sessionScope.user.supers==1}">
				<tr>
					<td class="field">�û�Ȩ�ޣ�</td>
					<td><c:choose>
				  <c:when test="${requestScope.userInfo.common==1&&requestScope.userInfo.supers==1}">
				<input type="radio" name="auth" id="auth" value="2" checked="checked"  /> ����Ա
				  </c:when>
				  <c:when test="${requestScope.userInfo.common==1}">
				  <input type="radio" name="auth" id="auth" value="0" checked="checked"  />��ͨ�û�
				  <input type="radio" name="auth" id="auth" value="1"  />����
				  </c:when>
				  <c:when test="${requestScope.userInfo.supers==1}">
				  <input type="radio" name="auth" id="auth" value="0"   />��ͨ�û�
				  <input type="radio" name="auth" id="auth" value="1" checked="checked" />����
				  </c:when>
				  </c:choose>
				  </td></tr>
			</c:if>	
			
			<c:if test="${sessionScope.user.common==1&&sessionScope.user.supers==0}">
				<tr>
					<td class="field">�û�Ȩ�ޣ�</td>
					<td><c:choose>
				  <c:when test="${requestScope.userInfo.common==1}">
				  <input type="radio" name="auth" id="auth" value="0" checked="checked"  />��ͨ�û�
				  </c:when>
				  </c:choose>
				  </td></tr>
			</c:if>	
			
			<c:if test="${sessionScope.user.common==0&&sessionScope.user.supers==1}">
				<tr>
					<td class="field">�û�Ȩ�ޣ�</td>
					<td><c:choose>
				  <c:when test="${requestScope.userInfo.common==1}">
				  <input type="radio" name="auth" id="auth" value="1"  />����
				  </c:when>
				  </c:choose>
				  </td></tr>
			</c:if>	
			</table>
		</div>
		<div class="buttons">
			<input type="button" name="button" id="button" class="input-button" onclick="window.location='PersonServlet?id=${requestScope.userInfo.id}&flag=mod'" value="����" /> <input type="submit" class="input-button" name="button" id="button" value="�ύ" /> 
		</div>
	</form>
</div>
</body>
</html>
    