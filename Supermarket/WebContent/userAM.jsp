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
function doit(flag)
{
	var id = document.form1.userId.value;
	if(flag=="del")
	{
		if(confirm("ȷ��ɾ����"))
			window.location = "DeleteUserServlet?id="+id+"&flag=del";
	}
	else if(flag=="mod")
	{
			window.location = "UpdateUserServlet?id="+id+"&flag=userLast";
	}else if(flag=="chp")
	{
		window.location = "PswdIdNameServlet?id="+id+"&flag=userPWD";
	}else if(flag=="re")
	{
		window.location = "PswdIdNameServlet?id="+id+"&flag=recodePWD";
	}
}
</script>
</head>
<body>
<c:choose>
<c:when test="${requestScope.operate=='changepassword'}">
<script>alert("�û������޸ĳɹ���")</script>
</c:when>
<c:when test="${requestScope.operate=='modified'}">
<script>alert("�û������޸ĳɹ���")</script>
</c:when>
<c:when test="${requestScope.operate=='re'}">
<script>alert("�������óɹ���")
window.location = "user.do";
</script>
</c:when>
</c:choose>

<div class="main">
	<div class="optitle clearfix">
		<div class="title">�û�����&gt;&gt;</div>
	</div>
	<form id="form1" name="form1" method="post" action="user.do" >
<input type="hidden" name="flag" value="modify">
		<div class="content">
			<table class="box">
			<tr>
					<td class="field">�û���ţ�</td>
					<td><input type="hidden" name="userId" value="${requestScope.user.id}"><input type="text" name="id" class="text" id="textfield" disabled="disabled" value="${requestScope.user.id}"/></td>
				</tr>
				<tr>
					<td class="field">�û����ƣ�</td>
					<td><input type="text" name="username" class="text" id="textfield2" disabled="disabled" value="${requestScope.user.username}"/></td>
				</tr>
				<tr>
					<td class="field">�û��Ա�</td>
					<td><select name="sex" id="select" disabled="disabled" class="text">
     <c:choose>
     <c:when test="${requestScope.user.sex==0}">
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
					<td><input type="text" name="age" id="textfield2" class="text" disabled="disabled" value="${requestScope.user.age}"/> </td>
				</tr>
				<tr>
					<td class="field">�û��绰��</td>
					<td><input type="text" name="mobile" id="textfield2" class="text" disabled="disabled" value="${requestScope.user.mobile}"/> </td>
				</tr>
				<tr>
					<td class="field">�û���ַ��</td>
					<td><textarea name="address" id="textarea" cols="45" rows="5" class="text" disabled="disabled"> ${requestScope.user.address}</textarea></td>
				</tr>
				
				<c:if test="${requestScope.user.common==1&&requestScope.user.supers==1}">
				<tr>
					<td class="field">�û�Ȩ�ޣ�</td>
					<td><c:choose>
				  <c:when test="${requestScope.user.common==1&&requestScope.user.supers==1}">
				 ����Ա
				  </c:when>
				  <c:when test="${requestScope.user.common==1}">
				  <input type="radio" name="auth" id="auth" value="0" checked="checked"  disabled="disabled"/>��ͨ�û�
				  <input type="radio" name="auth" id="auth" value="1"  disabled="disabled"/>����
				  </c:when>
				  <c:when test="${requestScope.user.supers==1}">
				  <input type="radio" name="auth" id="auth" value="0"   disabled="disabled"/>��ͨ�û�
				  <input type="radio" name="auth" id="auth" value="1" checked="checked" disabled="disabled"/>����
				  </c:when>
				  </c:choose>
				  </td></tr>
			</c:if>	
			
			
			<c:if test="${requestScope.user.common==1&&requestScope.user.supers==0}">
				<tr>
					<td class="field">�û�Ȩ�ޣ�</td>
					<td><c:choose>
				  <c:when test="${requestScope.user.common==1}">
				  <input type="radio" name="auth" id="auth" value="0" checked="checked"  disabled="disabled"/>��ͨ�û�
				  </c:when>
				  </c:choose>
				  </td></tr>
			</c:if>	
			
			<c:if test="${requestScope.user.common==0&&requestScope.user.supers==1}">
				<tr>
					<td class="field">�û�Ȩ�ޣ�</td>
					<td><c:choose>
				  <c:when test="${requestScope.user.supers==1}">
				  <input type="radio" name="auth" id="auth" value="0"   disabled="disabled"/>��ͨ�û�
				  <input type="radio" name="auth" id="auth" value="1" checked="checked" disabled="disabled"/>����
				  </c:when>
				  </c:choose>
				  </td></tr>
			</c:if>	
			</table>
		</div>
		<div class="buttons">
			<input type="button" name="button" id="button" class="input-button" onclick="window.location='UserStudentServlet';" value="����" /> <input type="button" name="button" id="button" value="�޸�" class="input-button" onclick="doit('mod');"/> 
			<c:if test="${sessionScope.user.common==1&&sessionScope.user.supers==1}"><input type="button" name="button" id="button" value="ɾ��" class="input-button" onclick="doit('del');"/>
			<input type="button" name="button" id="button" value="��������" class="input-button" onclick="doit('re');"/>  
			</c:if> 
			<c:if test="${sessionScope.user.common==0||sessionScope.user.supers==0}">
			<input type="button" name="button" id="button" value="�޸�����" class="input-button" onclick="doit('chp');"/>  
			</c:if> 
		</div>
	</form>
</div>

</body>
</html>
