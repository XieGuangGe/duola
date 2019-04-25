<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<link type="text/css" rel="stylesheet" href="css/style.css" />
<title>Insert title here</title>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>账单添加功能</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript">
function checkit()
{
	//判断是否是数字的正则表达式

	var p1 = "^\\d+$";
	var billid = document.form1.billId;
	var name = document.form1.productName;
	var money = document.form1.money;
	var counts = document.form1.counts;

	if(money.value=="")
	{
		alert("请输入交易金额");
		money.focus();
		return false;
	}
	else
	{
		var pattern = new RegExp(p1);
		if(!pattern.test(money.value))
		{
			alert("交易金额请输入大于等于零的数字");
			money.value="";
			money.focus();
			return false;
		}
	}
	if(counts.value=="")
	{
		alert("请输入交易数量");
		counts.focus();
		return false;
	}
	else
	{
		var pattern = new RegExp(p1);
		if(!pattern.test(counts.value))
		{
			alert("交易数量请输入大于等于零的数字");
			counts.value="";
			counts.focus();
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
		<div class="title">账单管理&gt;&gt;</div>
	</div>
	<form id="form1" name="form1" method="post" action="BillAdd">
	<font color="red">${requestScope.change}</font><BR/>
<input type="hidden" name="flag" value="doAdd">
		<div class="content">
			<table class="box">
				
				<tr>
					<td class="field">交易金额：</td>
					<td><input type="text" name="bill.bill_money" id="textfield"  class="text"/> <font color="red">*</font></td>
				</tr>
				
				<tr>
					<td class="field">交易单位：</td>
					<td><input type="text" name="bill.unit" id="textfield" class="text"/> <font color="red">*</font></td>
				</tr>
				<tr>
					<td class="field">交易数量：</td>
					<td><input type="text" name="bill.counts"  id="textfield" class="text"/> <font color="red">*</font></td>
				</tr>
				<tr>
					<td class="field">商品名称：</td>
					<td><input type="text" name="bill.product_name" class="text" id="textfield2"  class="text" value="${requestScope.billInfo.productName}"/></td>
				</tr>
				
				<tr>
					<td class="field">商品描述：</td>
					<td><textarea name="bill.product_desc" class="text" id="textarea" cols="45" rows="5" >${requestScope.billInfo.productDesc}</textarea></td>
				</tr>
				
				<tr>
					<td class="field">所属供应商：</td>
					<td><select name="bill.peovider_id">
    <c:forEach items="${supplierlist}" var="pro">
    <option value="${pro.id}">${pro.pro_name}</option>
    </c:forEach>
    </select></td>
				</tr>
				
				<tr>
					<td class="field">是否付款：</td>
					<td><select name="bill.isPay">
      <option value="1">是</option>
      <option value="0">否</option>
    </select></td>
				</tr>
			</table>
		</div>
		<div class="buttons">
			<input type="submit" name="button" id="button" value="提交" class="input-button" onclick="return checkit();" /> 
			<input type="button" name="button" id="button" onclick="window.location='billViewServlect';"   value="返回" class="input-button" /> 
		</div>
	</form>
</div>
</body>
</html>