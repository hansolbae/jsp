<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>3-3</title>
</head>
<body>
	<h3>3.회원가입 parameter 수신</h3>
	
	<%	
		// POST 방식으로 데이터를 전송했을 때 데이터를 디코딩해야 한글이 깨지지 않음
		// cf) GET vs POST 차이 : 교재 p80
		request.setCharacterEncoding("UTF-8");
	
		String name		  = request.getParameter("name");
		String gender	  = request.getParameter("gender");
		String[] hobbies  = request.getParameterValues("hobby");
		String addr  	  = request.getParameter("addr"); 
		
	%>
	
	<p>
		이름 : <%= name %><br />
		성별 : <%= gender %><br />
		취미 :
		<%
			for(String hobby : hobbies){
				out.print(hobby+", ");
			}
		%><br />
		지역 : <%= addr %>
	</p>
</body>
</html>