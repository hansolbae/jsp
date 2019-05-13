<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>5-3</title>
</head>
<body>
	<h3>3.application 내장객체</h3>
	<p>
		서버정소 : <%= application.getServerInfo() %><br />
		서버규약(메이저) : <%= application.getMajorVersion() %><br />
		서버규약(마이너) : <%= application.getMinorVersion() %>
	</p>
</body>
</html>