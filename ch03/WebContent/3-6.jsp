<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>3-6</title>
</head>
<body>
	<h3>6.response 내장객체</h3>
	<h1>3-6.jsp 페이지 입니다.</h1>
	
	<%
		// 페이지를 다시 요청
		// cf) 교재 p93
		response.sendRedirect("./3-1.jsp");
	%>

</body>
</html>