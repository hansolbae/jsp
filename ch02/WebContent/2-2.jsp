<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>2-2</title>
</head>
<body>
	<h3>2.조건문</h3>
	<%
		int num1 = 1, num2 = 2, num3 = 3, num4 = 4;
		
		if(num1 > 0){
			out.println("<p>num1이 0보다 크다.</p>");
		}
	
		if(num1 > num2){
	%>
		<p>num1이 num2보다 크다.</p>
	<%
		}else{
	
	%>
		<p>num1이 num2보다 작다.</p>
	<%
		}
	%>
	
	<h4>if ~ else if ~ else</h4>
	<%	if(num1 > num2){ %>
		<i>num1이 num2보다 크다.</i>
	<%	}else if(num2 > num3){ %>
		<i>num2이 num3보다 크다.</i>
	<%	}else if(num3 > num4){ %>
		<i>num3이 num4보다 크다.</i>
	<%	}else{ %>
		<i>num4가 가장 크다.</i>
	<%	} %>
	
	
</body>
</html>