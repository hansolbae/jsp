<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>9-2</title>
</head>
<body>
	<h3>2.쿠키확인</h3>
	
	<h4>클라이언트로부터 전송된 쿠키 출력</h4>
	<%
		Cookie[] cookies = request.getCookies();
	
		for(Cookie cookie : cookies){
			String name  = cookie.getName();
			String value = cookie.getValue();
	%>
	
			<p>
				이름  : <%= name %><br />
				값	: <%= value %>
			</p>
			
	<%
		}
	%>
</body>
</html>