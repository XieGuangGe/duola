<%@ page language="java" contentType="text/html; charset=gbk"
	pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="/struts-tags" prefix="s"%>
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
	window.location = "user.do?id="+id+"&flag="+flag;
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
	</c:choose>
	<div class="menu">
		<table>
			<tr>
				<td><c:if test="${user.supers==1 }"><form method="post" action="UserStudentServlet">
						<input type="hidden" name="flag" value="search" class="input-text">
						�û����ƣ�<input type="text" name="user.username" class="input-text">&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="submit" value="�� ѯ">
					</form></c:if></td>
			</tr>
		</table>
	</div>
	<div class="main">
		<div class="optitle clearfix">
			<c:if
				test="${sessionScope.user.common==1&&sessionScope.user.supers==1}">
				<em><input type="button"
					onclick="window.location='userAdd.jsp?flag=add'" value="�������"
					class="input-button" /></em>
			</c:if>
			<div class="title">�û�����&gt;&gt;</div>
		</div>
		<div class="content">
			<table class="list">
				<tr>
					<td width="70" height="29"><div align="center" class="STYLE1">���</div></td>
					<td width="80"><div align="center" class="STYLE1">�û�����</div></td>
					<td width="100"><div align="center" class="STYLE1">�Ա�</div></td>
					<td width="100"><div align="center" class="STYLE1">����</div></td>
					<td width="150"><div align="center" class="STYLE1">�绰</div></td>
					<td width="150"><div align="center" class="STYLE1">��ַ</div></td>
					<td width="150"><div align="center" class="STYLE1">Ȩ��</div></td>
				</tr>
				
				<s:iterator var="h" value="#request.list">
				<tr>
				    <td><span class="STYLE1"><s:property value="#h.id"/></span></td>
				    <td><span class="STYLE1"><s:property value="#h.username"/></span></td>
				     <s:if test="#h.sex==0">
				    <td><span class="STYLE1">Ů</span></td>
				    </s:if>
				     <s:if test="#h.sex!=0">
				    <td><span class="STYLE1">��</span></td>
				    </s:if>
				    
				    <td><span class="STYLE1"><s:property value="#h.age" /></span></td>
						<td><span class="STYLE1"><s:property value="#h.mobile" /></span></td>
						<td><span class="STYLE1"><s:property value="#h.address" /></span></td>
						<s:if test="(#h.common==1) && (#h.supers==1)">
						        <td><span class="STYLE1">adminȨ��</span></td>
						</s:if>
						<s:else>
					 <td><span class="STYLE1">��ͨȨ��</span></td>
						
						</s:else>
						
				</tr>
				
				
				
				</s:iterator>
			
				
			<%-- 	<c:forEach items="${requestScope.pb.beanList }" var="userList">
					<tr>
						<td height="23"><span class="STYLE1"><a
								href="PersonServlet?id=${userList.id }"
								onclick="doit('mod',${userList.id})">${userList.id}</a></span></td>
						<td><span class="STYLE1"> <c:choose>
									<c:when test="${user.supers==1}">
	    	${userList.username}
	      </c:when>
									<c:otherwise>
										<c:choose>
											<c:when test="${user.username==userList.username}">
    	        ${userList.username}
	          </c:when>
											<c:otherwise>
	          ${userList.username}
	          </c:otherwise>
										</c:choose>
									</c:otherwise>
								</c:choose>
						</span></td>
						<td><span class="STYLE1"> <c:choose>
									<c:when test="${userList.sex==0}">
    	Ů
    </c:when>
									<c:otherwise>
    	��
    </c:otherwise>
								</c:choose>
						</span></td>
						<td><span class="STYLE1">${userList.age}</span></td>
						<td><span class="STYLE1">${userList.mobile}</span></td>
						<td><span class="STYLE1">${userList.address}</span></td>
						<td><span class="STYLE1">&nbsp; <c:choose>
									<c:when test="${(userList.common==1) && (userList.supers==1)}">
    	adminȨ��
    </c:when>
									<c:when test="${userList.common==1}">
    	��ͨԱ��Ȩ��
    </c:when>
									<c:when test="${userList.supers==1}">
    	����Ȩ��
    </c:when>
								</c:choose>
						</span></td>
					</tr>
				</c:forEach> --%>
			</table>
			
			<!-- ��ҳ -->
			<center>
				��${requestScope.pb.pc }ҳ/��${requestScope.pb.tp}ҳ <a
					href="UserStudentServlet?method=query&pc=1&userName=${requestScope.namess}">��ҳ</a>
				<c:if test="${requestScope.pb.pc>1 }">
					<a href="UserStudentServlet?method=query&pc=${requestScope.pb.pc-1}&userName=${requestScope.namess}">��һҳ</a>
				</c:if>
				<c:if test="${requestScope.pb.pc < requestScope.pb.tp}">
					<a href="UserStudentServlet?method=query&pc=${requestScope.pb.pc+1}&userName=${requestScope.namess}">��һҳ</a>
				</c:if>

				<a href="UserStudentServlet?method=query&pc=${requestScope.pb.tp }&userName=${requestScope.namess}">βҳ</a>
			</center>
		</div>
	</div>
</body>
</html>