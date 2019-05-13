<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>8-2</title>
</head>
<body>
	<h3>2.useBean 액션태그</h3>
	
	<!--
		useBean 액션태그
		- 전송파라미터를 수신받아 자바빈 객체로 생성
		- 'useBean' 대신 'request.getParameter' 사용을 많이 한다.
	-->
	
	<jsp:useBean id="user" class="kr.co.ch08.UserBean">
		<jsp:setProperty name="user" property="uid" />
		<jsp:setProperty name="user" property="name" />
		<jsp:setProperty name="user" property="gender" />
		<jsp:setProperty name="user" property="hobby" />
		<jsp:setProperty name="user" property="addr" />
	</jsp:useBean>
	
	<p>
		아이디 : <jsp:getProperty name="user" property="uid" /><br />
		이   름 : <%= user.getName() %><br />
		성   별 : <%= user.getGender() %><br />
		취   미 :
		<%
			for(String hobby : user.getHobby()) {
				out.println(hobby + ", ");
			}
		%><br />
		주   소 : <jsp:getProperty name="user" property="addr" />
	</p>
</body>
</html>