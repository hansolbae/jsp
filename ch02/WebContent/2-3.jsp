<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>2-3</title>
</head>
<body>
	<h3>3.반복문</h3>
	<%
		int sum = 0;
	
		for(int k = 1; k <= 10; k++){
			sum += k;
		}
	
	%>
	<p>1부터 10까지 합 : <%= sum %></p>
	
	
	<h4>별삼각형 출력</h4>
	<%
		for(int a=10; a>=1; a--){
			
			for(int b=1; b<=a; b++){
				out.print("☆");
			}
			out.print("<br/>");
		}
	
	%>
	<%
		for(int a=1; a<=10; a++){
			
			for(int b=1; b<=a; b++){
				out.print("☆");
			}
			out.print("<br/>");
		}
	
	%>
	
	<h4>구구단</h4>
	<table border="1">
		<tr>
		<%
			for(int i=2; i<=9; i++){
		%>
			<td><%= i %>단</td>
		<%
			}
		%>
		</tr>
		<%
			for(int a=1; a<=9; a++){
		%>
		<tr>
			<%
				for(int b=2; b<=9; b++){
					int c = b * a;
			%>
				<td><%= b %> X <%= a %> = <%= c %></td>
			<%
				}
			%>
		</tr>
		<%
			}
		%>
	
	</table>
	
	
</body>
</html>