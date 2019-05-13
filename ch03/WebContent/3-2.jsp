<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>3-2</title>
</head>
<body>
	<h3>2.parameter 수신</h3>
	<%
		String uid  = request.getParameter("uid");
		String pass = request.getParameter("pass");
	%>
	
	<p>
		입력 아이디 : <%= uid %><br />
		입력 비밀번호 : <%= pass %>
	</p>
</body>
</html>