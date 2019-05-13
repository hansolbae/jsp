<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>6-2</title>
</head>
<body>
	<h3>2.500에러 발생</h3>
	
	<%
		// null이기 때문에 호출(toString) 불가능
		// String str = "홍길동"; 입력 시 결과 출력
		String str = null;
		String result = str.toString();
	%>
	<p>
		결과 : <%= result %>
	</p>
</body>
</html>