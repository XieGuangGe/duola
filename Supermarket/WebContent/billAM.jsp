<%@ page language="java" contentType="text/html; charset=gbk"
	pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>账单详情功能</title>
<head>
<script type="text/javascript">
	function doit(flag) {
		var id = document.form1.billId.value;
		if (flag == "del") {
			if (confirm("确认删除吗？"))
				window.location = "DetectServletbill?id=" + id + "&flag=del";
		} else if (flag == "mod") {
			window.location = "SerachUpdatebill?id=" + id + "&flag=billLast";
		}

	}
</script>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
	<c:choose>
		<c:when test="${requestScope.operate=='del'}">`
<script>
	alert("删除成功！");
</script>
		</c:when>
		<c:when test="${requestScope.operate=='modify'}">
			<script>
				alert("数据修改成功！");
			</script>
		</c:when>
	</c:choose>
	<div class="main">
		<div class="optitle clearfix">
			<div class="title">账单管理&gt;&gt;</div>
		</div>
		<form id="form1" name="form1" method="post"
			action="UpdatebillServlet2">
			<input type="hidden" name="billId"
				value="${bill.id}">
			<div class="content">
				<table class="box">
					<tr>
						<td class="field">账单编号：</td>
						<td><input type="text" name="id" id="textfield" class="text"
							disabled="disabled" value="${bill.id}" /></td>
					</tr>
					<tr>
						<td class="field">交易金额：</td>
						<td><input type="text" name="money" id="textfield"
							class="text" disabled="disabled"
							value="${bill.bill_money}" /></td>
					</tr>
					<tr>
						<td class="field">交易单位：</td>
						<td><input type="text" name="unit" id="textfield"
							class="text" disabled="disabled"
							value="${bill.unit}" /></td>
					</tr>
					<tr>
						<td class="field">交易数量：</td>
						<td><input type="text" name="counts" id="textfield"
							class="text" disabled="disabled"
							value="${bill.counts}" /></td>
					</tr>
					<tr>
						<td class="field">商品名称：</td>
						<td><input type="text" name="productName" id="textfield2"
							class="text" disabled="disabled"
							value="${bill.product_name}" /></td>
					</tr>
					<tr>
						<td class="field">商品描述：</td>
						<td><textarea name="productDesc" class="text" id="textarea"
								cols="45" rows="5" disabled="disabled">${bill.product_desc}</textarea></td>
					</tr>
					<tr>
						<td class="field">是否付款：</td>
						<td><select name="isPay" disabled="disabled">
								<c:if test="${bill.ispay==0}}">
									<option value="1">是</option>
									<option value="0">否</option>
								</c:if>
								<c:if test="${bill.ispay!=0}}">
									<option value="0">否</option>
									<option value="1">是</option>
								</c:if>
						</select></td>
					</tr>
					<tr>
						<td class="field">所属供应商：</td>
						<td><select name="provider" disabled="disabled">
								<c:forEach items="${list}" var="pro">
									<c:choose>
										<c:when test="${bill.peovider_id==pro.id}">
											<option value="${pro.id}" selected="selected">${pro.pro_name}</option>
										</c:when>
										<c:otherwise>
											<option value="${pro.id}">${pro.pro_name}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						</select></td>
					</tr>
				</table>
			</div>
			<div class="buttons">
				<input type="button" name="button" id="button"
					onclick="window.location='BillStudent';" value="返回"
					class="input-button" />
			<c:if test="${sessionScope.userInfo.sup==sessionScope.userInfo.sup}">	
					<input type="button" name="button" id="button" value="修改"
						class="input-button" onclick="doit('mod');" />
					<input type="button" name="button" id="button" value="删除"
						class="input-button" onclick="doit('del');" />
				 </c:if> 
			</div>
		</form>
	</div>
</body>
</html>
