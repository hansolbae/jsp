<%@page import="ch13.Clock"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>현재시간 출력</title>
</head>
<body>
	<h3>현재시간은 <%= new Clock().now() %>입니다.</h3>
	
</body>
</html>