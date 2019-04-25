<%@ page language="java" contentType="text/html; charset=gbk"
	pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<link type="text/css" rel="stylesheet" href="css/style.css" />
<title>账单总查询</title>
<style type="text/css">
<!--
.STYLE1 {
	font-size: 12px
}
-->
</style>

</head>
<body>
	<div class="menu">
		<c:choose>
			<c:when test="${requestScope.operate=='add'}">
				<script>
					alert("添加成功！");
				</script>
			</c:when>
			<c:when test="${requestScope.operate=='del'}">
				<script>
					alert("删除成功！");
				</script>
			</c:when>
		</c:choose>
		<table>
			<tr>
				<td>
					<form method="post" action="BillStudentServlet">
						<input type="hidden" name="flag" value="search"> 商品名称：<input
							type="text" name="productName" class="input-text">&nbsp;&nbsp;&nbsp;&nbsp;
						是否付款：<select name="query_isPay">
							<option value="-1">请选择</option>
							<option value="1">是</option>
							<option value="0">否</option>
						</select>&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit" value="组 合 查 询">
					</form>
				</td>
			</tr>
		</table>
	</div>
	<div class="main">
		<div class="optitle clearfix">
			<em><input type="button" value="添加数据"
				onclick="window.location='Transitionbill?flag=add'" class="input-button" /></em>
			<div class="title">账单管理&gt;&gt;</div>
		</div>
		<div class="content">
			<table width="800" height="23" border="1" bordercolor="#000000"
				cellpadding="1" class="list">
				<tr>
					<td width="70" height="29"><div align="center" class="STYLE1">账单编号</div></td>
					<td width="80"><div align="center" class="STYLE1">商品名称</div></td>
					<td width="80"><div align="center" class="STYLE1">商品数量</div></td>
					<td width="80"><div align="center" class="STYLE1">交易金额</div></td>
					<td width="100"><div align="center" class="STYLE1">是否付款</div></td>
					<td width="100"><div align="center" class="STYLE1">供应商编号</div></td>
					<td width="100"><div align="center" class="STYLE1">商品描述</div></td>
					<td width="100"><div align="center" class="STYLE1">账单时间
						</div></td>
				</tr>

				<s:iterator var="h" value="#request.list">
					<tr>


						<td><span class="STYLE1"><s:a href="Billid?id=%{#h.id}"><s:property value="#h.id" /></s:a></span></td>
						<td><s:property value="#h.product_name" /></td>
						<td><s:property value="#h.counts" /></td>
						<td><s:property value="#h.bill_money" /></td>
						 <s:if test="#h.ispay==0">
								<td><span class="STYLE1">没有付款</span></td>
							</s:if> <s:if test="#h.ispay!=0">
								<td><span class="STYLE1">已经付款</span></td>
							</s:if> 
						<td><s:property value="#h.peovider_id" /></td>
						<td><s:property value="#h.product_desc" /></td>
						<td><s:property value="#h.bill_time" /></td>

					</tr>
				</s:iterator>


				<%-- <c:forEach items="${requestScope.pb.beanList}" var="bill">
					<tr>
						<td height="23"><span class="STYLE1"><a
								href="DetailsServlet?id=${bill.id}">${bill.id}</a></span></td>
						<td><span class="STYLE1">${bill.product_name}</span></td>
						<td><span class="STYLE1">&nbsp;${bill.counts}</span></td>
						<td><span class="STYLE1">&nbsp;${bill.bill_money}</span></td>
						<c:if test="${bill.ispay==0}">
							<td><span class="STYLE1">没有付款</span></td>
						</c:if>
						<c:if test="${bill.ispay!=0}">
							<td><span class="STYLE1">已经付款</span></td>
						</c:if>
						<td><span class="STYLE1">&nbsp;${bill.peovider_id}</span></td>
						<td><span class="STYLE1">${bill.product_desc}</span></td>
						<td><span class="STYLE1">&nbsp;${bill.bill_time}</span></td>
						<!-- <td><span class="STYLE1"><a href="#" onclick="doit('del',${billList.billId})">删除</a> | <a href="#" onclick="doit('mod',${billList.billId})">修改</a></span></td> -->
					</tr>
				</c:forEach> --%>
			</table>

			<center>
				第${requestScope.pb.pc }页/共${requestScope.pb.tp}页 <a
					href="BillStudentServlet?method=query&pc=1&productName=${requestScope.namess}&query_isPay=${requestScope.ispays}">首页</a>
				<c:if test="${requestScope.pb.pc>1 }">
					<a
						href="BillStudentServlet?method=query&pc=${requestScope.pb.pc-1}&productName=${requestScope.namess}&query_isPay=${requestScope.ispays}">上一页</a>
				</c:if>
				<c:if test="${requestScope.pb.pc < requestScope.pb.tp}">
					<a
						href="BillStudentServlet?method=query&pc=${requestScope.pb.pc+1}&productName=${requestScope.namess}&query_isPay=${requestScope.ispays}">下一页</a>
				</c:if>

				<a
					href="BillStudentServlet?method=query&pc=${requestScope.pb.tp }&productName=${requestScope.namess}&query_isPay=${requestScope.ispays}">尾页</a>
			</center>
		</div>
	</div>
	<s:debug></s:debug>
</body>
</html>