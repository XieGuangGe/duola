<%@ page language="java" contentType="text/html; charset=gbk"
	pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>账单详情修改功能</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<head>

<script type="text/javascript">
	function checkit() {
		//判断是否是数字的正则表达式
		var p1 = "^\\d+$";
		var name = document.form1.productName;
		var money = document.form1.money;
		var counts = document.form1.counts;
		if (money.value == "") {
			alert("请输入交易金额");
			money.focus();
			return false;
		} else {
			var pattern = new RegExp(p1);
			if (!pattern.test(money.value)) {
				alert("交易金额请输入大于等于零的数字");
				money.value = "";
				money.focus();
				return false;
			}
		}
		if (counts.value == "") {
			alert("请输入交易数量");
			counts.focus();
			return false;
		} else {
			var pattern = new RegExp(p1);
			if (!pattern.test(counts.value)) {
				alert("交易数量请输入大于等于零的数字");
				counts.value = "";
				counts.focus();
				return false;
			}
		}
		if (name.value == "") {
			alert("请输入商品名称");
			name.focus();
			return false;
		}
		if (confirm("确认修改？"))
			return true;
		else
			return false;
		
	}
</script>
</head>
<body>
	<div class="main">
		<div class="optitle clearfix">
			<div class="title">账单管理&gt;&gt;</div>
		</div>
		<form id="form1" name="form1" method="post"
			action="UpateServlets" onsubmit=" checkit();">
			<input type="hidden" name="flag" value="modify"> <input
				type="hidden" name="bill.id" value="${bill.id}">
			<div class="content">
				<table class="box">
					<tr>
						<td class="field">账单编号：</td>
						<td><input type="text" name="ids" class="text" id="textfield"
							disabled="disabled" value="${bill.id}" /></td>
					</tr>
					<tr>
						<td class="field">交易金额：</td>
						<td><input type="text" name="bill_money" class="text"
							id="textfield" value="${bill.bill_money}" /></td>
					</tr>
					<tr>
						<td class="field">交易单位：</td>
						<td><input type="text" name="unit" id="textfield"
							class="text" value="${bill.unit}" /></td>
					</tr>
					<tr>
						<td class="field">交易数量：</td>
						<td><input type="text" name="counts" id="textfield"
							class="text" value="${bill.counts}" /></td>
					</tr>
					<tr>
						<td class="field">商品名称：</td>
						<td><input type="text" name="product_name" id="textfield2"
							class="text" value="${bill.product_name}" /></td>
					</tr>
					<tr>
						<td class="field">商品描述：</td>
						<td><textarea name="product_desc" id="textarea" cols="45"
								rows="5" class="text">${bill.product_desc}</textarea></td>
					</tr>
					<tr>
						<td class="field">是否付款：</td>
						<td><select name="isPay">
								<c:if test="${bill.ispay==0}">
									<option value="1">是</option>
									<option value="0">否</option>
								</c:if>
								<c:if test="${bill.ispay!=0}">
									<option value="0">否</option>
									<option value="1">是</option>
								</c:if>
						</select></td>
					</tr>
					<tr>
						<td class="field">所属供应商：</td>
						<td><select name="peovider_id">
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
				<input type="button" name="button" id="button" class="input-button"
					onclick="window.location='Billid?id=${bill.id}&flag=mod'"
					value="返回" /> <input type="submit" name="button" id="button"
					value="提交" class="input-button" />
			</div>
		</form>
	</div>
</body>
</html>