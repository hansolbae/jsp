<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>5-1</title>
</head>
<body>
	<h3>1.out 내장객체</h3>
	<%
		out.println("<ul>");
		out.println("<li>서울</li>");
		out.println("<li>대전</li>");
		out.println("<li>대구</li>");
		out.println("<li>부산</li>");
		out.println("<li>광주</li>");
		out.println("</ul>");
	%>
	<% //파라미터 값 수동 설정 %>
	<a href="./5-2.jsp?name=홍길동&age=17">5-2 이동</a>
</body>
</html>