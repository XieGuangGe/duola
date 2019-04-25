<%@ page language="java" contentType="text/html; charset=gbk"
	pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>超市账单管理系统</title>
</head>

<frameset rows="100,*" cols="*" frameborder="no" border="0"
	framespacing="0">
	<frame src="topFrame.jsp" name="topFrame" scrolling="No"
		noresize="noresize" id="topFrame" />
	<frameset cols="200,*" frameborder="no" border="0" framespacing="0">
		<frame src="leftFrame.jsp" name="leftFrame" scrolling="No"
			noresize="noresize" id="leftFrame" title="leftFrame" />
		<frame src="mainFrame.jsp" name="mainFrame" id="mainFrame"
			title="leftFrame" />
	</frameset>
</frameset>

<noframes>
	<body>
	</body>
</noframes>
</html>
