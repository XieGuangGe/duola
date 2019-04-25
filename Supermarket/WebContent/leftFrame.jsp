<%@ page language="java" contentType="text/html; charset=gbk"
	pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>超市账单管理系统</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript">
	function doit(flag) {
		parent.mainFrame.location = flag;
	}
	 function logout() {
		top.location = 'LogoutServlet';
	} 
</script>
</head>

<body class="frame-bd">
	<ul class="left-menu">
		<li><a href="#" onclick="doit('BillStudent')"><img
				src="images/btn_bill.gif" /></a></li>
		<c:choose>
			<c:when test="${sessionScope.user.supers==1}"> 
				<li><a href="#" onclick="doit('StudentServlet')"><img
						src="images/btn_suppliers.gif" /> </a></li>
		 </c:when>
		</c:choose> 
		<li><a href="#" onclick="doit('UserStudent')"><img
				src="images/btn_users.gif" /></a></li>
		<li><a href="#" onclick="logout()"><img
				src="images/btn_exit.gif" /> </a></li>
	</ul>
</body>
</html>