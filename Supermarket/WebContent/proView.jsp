<%@ page language="java" contentType="text/html; charset=gbk"
	pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript">
function doit(flag,id)
{
	if(flag=="del")
	{
		if(confirm("ȷ��ɾ����")!=true)
			return;
	}
	window.location = "provider.do?id="+id+"&flag="+flag;
}

</script>
</head>
<body>
	<c:choose>
		<c:when test="${requestScope.operate=='add'}">
			<script>alert("��ӳɹ���")</script>
		</c:when>
		<c:when test="${requestScope.operate=='del'}">
			<script>alert("ɾ���ɹ���")</script>
		</c:when>
		<c:when test="${requestScope.operate=='have'}">
			<script>alert("�ж��������ɾ����")</script>
		</c:when>
	</c:choose>
	<div class="menu">
		<table>
			<tr>
				<td><form method="post" action="StudentServlet">
						<input type="hidden" name="flag" value="search"> ��Ӧ�����ƣ�<input
							type="text" name="providerName" class="input-text"
							value="${sessionScope.namess }">
						&nbsp;&nbsp;&nbsp;&nbsp;��Ӧ��������<input type="text"
							name="providerDesc" class="input-text"
							value="${sessionScope.descs }">&nbsp;&nbsp;&nbsp;&nbsp;<input
							type="submit" value="�� �� �� ѯ">
					</form></td>
			</tr>
		</table>
	</div>
	<div class="main">
		<div class="optitle clearfix">
			<em><input type="button" value="�������" class="input-button"
				onclick="window.location='proAdd.jsp?flag=add'"></em>
			<div class="title">��Ӧ�̹���&gt;&gt;</div>
		</div>
		<div class="content">
			<table class="list">
				<tr>
					<td width="70" height="29"><div align="center" class="STYLE1">���</div></td>
					<td width="80"><div align="center" class="STYLE1">��Ӧ������</div></td>
					<td width="100"><div align="center" class="STYLE1">��Ӧ������</div></td>
					<td width="100"><div align="center" class="STYLE1">��ϵ��</div></td>
					<td width="100"><div align="center" class="STYLE1">�绰</div></td>
					<td width="100"><div align="center" class="STYLE1">��ַ</div></td>
				</tr>
				<c:forEach items="${requestScope.pb.beanList}" var="proList">
					<tr>
						<td height="23"><span class="STYLE1"><a
								href="HuoquServlet?id=${proList.id}"
								onclick="doit('mod',${proList.id})">${proList.id}</a></span></td>
						<td><span class="STYLE1">${proList.pro_name}</span></td>
						<td><span class="STYLE1">${proList.pro_desc}</span></td>
						<td><span class="STYLE1">${proList.pro_contact}</span></td>
						<td><span class="STYLE1">${proList.pro_phone}</span></td>
						<td><span class="STYLE1">${proList.pro_address}</span></td>
					</tr>
				</c:forEach>

			</table>
			<!-- ��ҳ -->
			<center>
				��${requestScope.pb.pc }ҳ/��${requestScope.pb.tp}ҳ <a
					href="StudentServlet?method=query&pc=1&providerName=${requestScope.namess}&providerDesc=${requestScope.descs}">��ҳ</a>
				<c:if test="${requestScope.pb.pc>1 }">
					<a href="StudentServlet?method=query&pc=${requestScope.pb.pc-1}&providerName=${requestScope.namess}&providerDesc=${requestScope.descs}">��һҳ</a>
				</c:if>
				<c:if test="${requestScope.pb.pc < requestScope.pb.tp}">
					<a href="StudentServlet?method=query&pc=${requestScope.pb.pc+1}&providerName=${requestScope.namess}&providerDesc=${requestScope.descs}">��һҳ</a>
				</c:if>

				<a href="StudentServlet?method=query&pc=${requestScope.pb.tp }&providerName=${requestScope.namess}&providerDesc=${requestScope.descs}">βҳ</a>
			</center>
		</div>
	</div>
</body>
</html>