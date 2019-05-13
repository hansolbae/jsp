<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String result = request.getParameter("result");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인</title>
	<script>
		// 위의 'result'는 자바, 여기는 자바스크립트 → 즉, 다른 코드이므로 자바의 result 변수 참조해야 한다.
		var result = "<%= result %>";
		
		if(result == "fail") {
			alert("회원이 아닙니다.");
		}
		
	</script>
</head>
<body>
	<h3>로그인</h3>
	
	<form action="./loginProc.jsp">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="uid" /></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="pass" name="pass" /></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="로그인" /></td>
			</tr>
		</table>
	</form>
</body>
</html>