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
		if(confirm("确认删除吗？")!=true)
			return;
	}
	window.location = "provider.do?id="+id+"&flag="+flag;
}

</script>
</head>
<body>
	<c:choose>
		<c:when test="${requestScope.operate=='add'}">
			<script>alert("添加成功！")</script>
		</c:when>
		<c:when test="${requestScope.operate=='del'}">
			<script>alert("删除成功！")</script>
		</c:when>
		<c:when test="${requestScope.operate=='have'}">
			<script>alert("有订单项，不能删除！")</script>
		</c:when>
	</c:choose>
	<div class="menu">
		<table>
			<tr>
				<td><form method="post" action="StudentServlet">
						<input type="hidden" name="flag" value="search"> 供应商名称：<input
							type="text" name="providerName" class="input-text"
							value="${sessionScope.namess }">
						&nbsp;&nbsp;&nbsp;&nbsp;供应商描述：<input type="text"
							name="providerDesc" class="input-text"
							value="${sessionScope.descs }">&nbsp;&nbsp;&nbsp;&nbsp;<input
							type="submit" value="组 合 查 询">
					</form></td>
			</tr>
		</table>
	</div>
	<div class="main">
		<div class="optitle clearfix">
			<em><input type="button" value="添加数据" class="input-button"
				onclick="window.location='proAdd.jsp?flag=add'"></em>
			<div class="title">供应商管理&gt;&gt;</div>
		</div>
		<div class="content">
			<table class="list">
				<tr>
					<td width="70" height="29"><div align="center" class="STYLE1">编号</div></td>
					<td width="80"><div align="center" class="STYLE1">供应商名称</div></td>
					<td width="100"><div align="center" class="STYLE1">供应商描述</div></td>
					<td width="100"><div align="center" class="STYLE1">联系人</div></td>
					<td width="100"><div align="center" class="STYLE1">电话</div></td>
					<td width="100"><div align="center" class="STYLE1">地址</div></td>
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
			<!-- 分页 -->
			<center>
				第${requestScope.pb.pc }页/共${requestScope.pb.tp}页 <a
					href="StudentServlet?method=query&pc=1&providerName=${requestScope.namess}&providerDesc=${requestScope.descs}">首页</a>
				<c:if test="${requestScope.pb.pc>1 }">
					<a href="StudentServlet?method=query&pc=${requestScope.pb.pc-1}&providerName=${requestScope.namess}&providerDesc=${requestScope.descs}">上一页</a>
				</c:if>
				<c:if test="${requestScope.pb.pc < requestScope.pb.tp}">
					<a href="StudentServlet?method=query&pc=${requestScope.pb.pc+1}&providerName=${requestScope.namess}&providerDesc=${requestScope.descs}">下一页</a>
				</c:if>

				<a href="StudentServlet?method=query&pc=${requestScope.pb.tp }&providerName=${requestScope.namess}&providerDesc=${requestScope.descs}">尾页</a>
			</center>
		</div>
	</div>
</body>
</html>