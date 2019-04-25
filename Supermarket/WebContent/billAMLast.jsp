<%@ page language="java" contentType="text/html; charset=gbk"
	pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>�˵������޸Ĺ���</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<head>

<script type="text/javascript">
	function checkit() {
		//�ж��Ƿ������ֵ�������ʽ
		var p1 = "^\\d+$";
		var name = document.form1.productName;
		var money = document.form1.money;
		var counts = document.form1.counts;
		if (money.value == "") {
			alert("�����뽻�׽��");
			money.focus();
			return false;
		} else {
			var pattern = new RegExp(p1);
			if (!pattern.test(money.value)) {
				alert("���׽����������ڵ����������");
				money.value = "";
				money.focus();
				return false;
			}
		}
		if (counts.value == "") {
			alert("�����뽻������");
			counts.focus();
			return false;
		} else {
			var pattern = new RegExp(p1);
			if (!pattern.test(counts.value)) {
				alert("����������������ڵ����������");
				counts.value = "";
				counts.focus();
				return false;
			}
		}
		if (name.value == "") {
			alert("��������Ʒ����");
			name.focus();
			return false;
		}
		if (confirm("ȷ���޸ģ�"))
			return true;
		else
			return false;
		
	}
</script>
</head>
<body>
	<div class="main">
		<div class="optitle clearfix">
			<div class="title">�˵�����&gt;&gt;</div>
		</div>
		<form id="form1" name="form1" method="post"
			action="UpateServlets" onsubmit=" checkit();">
			<input type="hidden" name="flag" value="modify"> <input
				type="hidden" name="bill.id" value="${bill.id}">
			<div class="content">
				<table class="box">
					<tr>
						<td class="field">�˵���ţ�</td>
						<td><input type="text" name="ids" class="text" id="textfield"
							disabled="disabled" value="${bill.id}" /></td>
					</tr>
					<tr>
						<td class="field">���׽�</td>
						<td><input type="text" name="bill_money" class="text"
							id="textfield" value="${bill.bill_money}" /></td>
					</tr>
					<tr>
						<td class="field">���׵�λ��</td>
						<td><input type="text" name="unit" id="textfield"
							class="text" value="${bill.unit}" /></td>
					</tr>
					<tr>
						<td class="field">����������</td>
						<td><input type="text" name="counts" id="textfield"
							class="text" value="${bill.counts}" /></td>
					</tr>
					<tr>
						<td class="field">��Ʒ���ƣ�</td>
						<td><input type="text" name="product_name" id="textfield2"
							class="text" value="${bill.product_name}" /></td>
					</tr>
					<tr>
						<td class="field">��Ʒ������</td>
						<td><textarea name="product_desc" id="textarea" cols="45"
								rows="5" class="text">${bill.product_desc}</textarea></td>
					</tr>
					<tr>
						<td class="field">�Ƿ񸶿</td>
						<td><select name="isPay">
								<c:if test="${bill.ispay==0}">
									<option value="1">��</option>
									<option value="0">��</option>
								</c:if>
								<c:if test="${bill.ispay!=0}">
									<option value="0">��</option>
									<option value="1">��</option>
								</c:if>
						</select></td>
					</tr>
					<tr>
						<td class="field">������Ӧ�̣�</td>
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
					value="����" /> <input type="submit" name="button" id="button"
					value="�ύ" class="input-button" />
			</div>
		</form>
	</div>
</body>
</html>