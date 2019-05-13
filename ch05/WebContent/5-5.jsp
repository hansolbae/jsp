<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>5-5</title>
</head>
<body>
	<h3>5.내장객체 영역 name값 확인</h3>
	
	<%
		/* = Object obj1 = pageContext.getAttribute("name");
		     String pName = (String) obj1; */
		String pName = (String)pageContext.getAttribute("name");
		String rName = (String)request.getAttribute("name");
		String sName = (String)session.getAttribute("name");
		String aName = (String)application.getAttribute("name");
	%>
	
	<p>
		pageContext 값 : <%= pName %><br />
		request 값 : <%= rName %><br />
		Session 값 : <%= sName %><br />
		application 값 : <%= aName %><br />
	</p>
	
</body>
</html>