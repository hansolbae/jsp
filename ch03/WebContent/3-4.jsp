<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>3-4</title>
</head>
<body>
	<h3>4.request 내장객체 멤버</h3>
	<p>
		헤더정보 : <%= request.getHeader("user-Agent") %><br />
		통신규약 : <%= request.getProtocol() %><br />
		서버이름 : <%= request.getServerName() %><br />
		요청주소 : <%= request.getRequestURL() %><br />
		요청경로 : <%= request.getRequestURI() %><br />
		클라이언트 IP : <%= request.getRemoteAddr() %><br />
	</p>
	
</body>
</html>