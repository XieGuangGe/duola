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
<title>�˵���ӹ���</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript">
function checkit()
{
	//�ж��Ƿ������ֵ�������ʽ

	var p1 = "^\\d+$";
	var billid = document.form1.billId;
	var name = document.form1.productName;
	var money = document.form1.money;
	var counts = document.form1.counts;

	if(money.value=="")
	{
		alert("�����뽻�׽��");
		money.focus();
		return false;
	}
	else
	{
		var pattern = new RegExp(p1);
		if(!pattern.test(money.value))
		{
			alert("���׽����������ڵ����������");
			money.value="";
			money.focus();
			return false;
		}
	}
	if(counts.value=="")
	{
		alert("�����뽻������");
		counts.focus();
		return false;
	}
	else
	{
		var pattern = new RegExp(p1);
		if(!pattern.test(counts.value))
		{
			alert("����������������ڵ����������");
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
		<div class="title">�˵�����&gt;&gt;</div>
	</div>
	<form id="form1" name="form1" method="post" action="BillAdd">
	<font color="red">${requestScope.change}</font><BR/>
<input type="hidden" name="flag" value="doAdd">
		<div class="content">
			<table class="box">
				
				<tr>
					<td class="field">���׽�</td>
					<td><input type="text" name="bill.bill_money" id="textfield"  class="text"/> <font color="red">*</font></td>
				</tr>
				
				<tr>
					<td class="field">���׵�λ��</td>
					<td><input type="text" name="bill.unit" id="textfield" class="text"/> <font color="red">*</font></td>
				</tr>
				<tr>
					<td class="field">����������</td>
					<td><input type="text" name="bill.counts"  id="textfield" class="text"/> <font color="red">*</font></td>
				</tr>
				<tr>
					<td class="field">��Ʒ���ƣ�</td>
					<td><input type="text" name="bill.product_name" class="text" id="textfield2"  class="text" value="${requestScope.billInfo.productName}"/></td>
				</tr>
				
				<tr>
					<td class="field">��Ʒ������</td>
					<td><textarea name="bill.product_desc" class="text" id="textarea" cols="45" rows="5" >${requestScope.billInfo.productDesc}</textarea></td>
				</tr>
				
				<tr>
					<td class="field">������Ӧ�̣�</td>
					<td><select name="bill.peovider_id">
    <c:forEach items="${supplierlist}" var="pro">
    <option value="${pro.id}">${pro.pro_name}</option>
    </c:forEach>
    </select></td>
				</tr>
				
				<tr>
					<td class="field">�Ƿ񸶿</td>
					<td><select name="bill.isPay">
      <option value="1">��</option>
      <option value="0">��</option>
    </select></td>
				</tr>
			</table>
		</div>
		<div class="buttons">
			<input type="submit" name="button" id="button" value="�ύ" class="input-button" onclick="return checkit();" /> 
			<input type="button" name="button" id="button" onclick="window.location='billViewServlect';"   value="����" class="input-button" /> 
		</div>
	</form>
</div>
</body>
</html>