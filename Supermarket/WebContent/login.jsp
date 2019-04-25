<%@ page language="java" contentType="text/html; charset=gbk"
	pageEncoding="gbk"%>
	<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+
	request.getServerName()+":"+
	request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<link type="text/css" rel="stylesheet" href="css/style.css" />
<title>超市账单管理系统登陆</title>
<script type="text/javascript" src="jquery-3.3.1/jquery-3.3.1.js"></script>
<style type="text/css">
<!--
.STYLE1 {
	font-size: 36px;
	font-weight: bold;
}
-->
</style>
<script type="text/javascript">
	function check(obj) {
		var username = document.getElementById("username");
		var password = document.getElementById("password");
		if (username.value == "" || password.value == "") {
			alert("用户名或者密码不能为空！");
			username.focus();
			return false;
		}
		return true;
	}
	//登陆后退出清空session中之后倒退不i会出现先前登陆账户
	$(function() {
		if (window.history && window.history.pushState) {
			$(window).on('popstate', function() {
				window.history.pushState('forward', null, '#');
				window.history.forward(1);
			});
		}
		window.history.pushState('forward', null, '#'); //在IE中必须得有这两行
		window.history.forward(1);
	})
</script>
</head>
<body class="blue-style">
	<div id="login">
		<div class="icon"></div>
		<div class="login-box">
			<form id="form1" action="login" method="post"
				onsubmit="check(this)">
				<dl>
					<dt>用户名：</dt>
					<dd>
						<input type="text" name="username" id="username"
							class="input-text" />
					</dd>
					<dt>密 码：</dt>
					<dd>
						<input type="password" name="password" id="password"
							class="input-text" />
					</dd>
				</dl>
				<div class="buttons">
					<input type="submit" name="submit" value="登录系统"
						class="input-button" /> <input type="reset" name="reset"
						value="重　　填" class="input-button" /><br /> <font color="red">${requestScope.error}</font>
				</div>
			</form>

		</div>
	</div>
</body>
</html>