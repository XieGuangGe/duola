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
	function doit(flag) {
		var id = document.form1.proId.value;
		if (flag == "del") {
			if (confirm("ȷ��ɾ����"))
				window.location = "ProDeleteServlet?id=" + id + "&flag=del";
		}
		if (flag == "mod") {
			window.location = "UpdateServlet?id=" + id + "&flag=del";
		}
	}
</script>
</head>
<body>
	<c:choose>
		<c:when test="${requestScope.operate=='del'}">`
<script>
	alert("ɾ���ɹ���")
</script>
		</c:when>
		<c:when test="${requestScope.operate=='mod'}">
			<script>
				alert("�����޸ĳɹ���")
			</script>
		</c:when>
	</c:choose>

	<div class="main">
		<div class="optitle clearfix">
			<div class="title">��Ӧ�̹���&gt;&gt;</div>
		</div>
		<form id="form1" name="form1" method="post" action="provider.do">
			<input type="hidden" name="flag" value="modify">
			<div class="content">
				<table class="box">
					<tr>
						<td class="field">��Ӧ�̱�ţ�</td>
						<td><input type="hidden" name="proId"
							value="${requestScope.sss.id}"><input type="text"
							class="text" name="id" id="textfield" disabled="disabled"
							value="${sss.id}" /></td>
					</tr>
					<tr>
						<td class="field">��Ӧ�����ƣ�</td>
						<td><input type="text" name="proName" id="textfield2"
							class="text" value="${sss.pro_name}" disabled="disabled" /></td>
					</tr>
					<tr>
						<td class="field">��Ӧ��������</td>
						<td><textarea name="proDesc" id="textarea" cols="45" rows="5"
								class="text" disabled="disabled">${sss.pro_desc}</textarea></td>
					</tr>
					<tr>
						<td class="field">��Ӧ����ϵ��</td>
						<td><input type="text" name="contact" id="textfield2"
							disabled="disabled" class="text" value="${sss.pro_contact}" /></td>
					</tr>
					<tr>
						<td class="field">��Ӧ�̵绰��</td>
						<td><input type="text" name="phone" id="textfield2"
							disabled="disabled" class="text" value="${sss.pro_phone}" /></td>
					</tr>
					<tr>
						<td class="field">��Ӧ�̴��棺</td>
						<td><input type="text" name="fax" id="textfield2"
							disabled="disabled" class="text" value="${sss.pro_fax}" /></td>
					</tr>
					<tr>
						<td class="field">��Ӧ�̵�ַ��</td>
						<td><input type="text" name="address" id="textfield2"
							class="text" disabled="disabled" value="${sss.pro_address}" /></td>
					</tr>
				</table>
			</div>
			<c:if test="${sessionScope.user.supers==sessionScope.user.supers}">
				<div class="buttons">
					<input type="button" name="button" id="button"
						onclick="window.location='StudentServlet';" value="����"
						class="input-button" /> <input type="button" name="button"
						id="button" value="�޸�" onclick="doit('mod');" class="input-button" />
					<input type="button" name="button" id="button" value="ɾ��"
						onclick="doit('del');" class="input-button" />
				</div>
			</c:if>
		</form>
	</div>
</body>
</html>