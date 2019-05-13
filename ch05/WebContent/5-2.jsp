<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>5-2</title>
</head>
<body>
	<h3>2.pageContext 내장객체</h3>
	<%
		ServletRequest  req  = pageContext.getRequest();
		ServletResponse resp = pageContext.getResponse();
	
		String name = request.getParameter("name");
		String age = request.getParameter("age");
	
	
		// 프로젝트 내에서 다른 페이지 요청(네이버 요청 불가능) : redirect와의 차이점
		// pageContext.forward("./5-1.jsp");
	%>
	<p>
		이름 : <%= name %><br />
		나이 : <%= age %>
	</p>
</body>
</html>