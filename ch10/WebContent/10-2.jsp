<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>10-2</title>
</head>
<body>
	<h3>2.세션확인</h3>
	<%
		String sid  = (String) session.getId();
		String uid  = (String) session.getAttribute("uid");
		String name = (String) session.getAttribute("name");
	%>
	
	<p>
		sid  : <%= sid %><br />
		uid  : <%= uid %><br />
		name : <%= name %>
	</p>
</body>
</html>