<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8"); // 문자셋 지정(post방식이 아니라서 하지 않아도 되지만, 습관 들여놓기)

	String email = request.getParameter("email");
	
	// 데이터베이스 정보
	final String HOST = "jdbc:mysql://192.168.0.161:3306/bhs";
	final String USER = "bhs";
	final String PASS = "1234";
		
	// 1단계
	Class.forName("com.mysql.jdbc.Driver");
	
	// 2단계
	Connection conn = DriverManager.getConnection(HOST, USER, PASS);
	
	// 3단계
	Statement stmt = conn.createStatement();
	
	// 4단계
	ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM `JSP_USER` WHERE email='"+email+"';");
	
	// 5단계
	int count = 0; // 초기화
	
	if(rs.next()){
		count = rs.getInt(1);
	}
	
	// 6단계
	rs.close();
	stmt.close();
	conn.close();
	
	// JSON 데이터생성 및 전송
	// String json = "{'result': 1}"; → 문자열로 받아도 되지만, 라이브러리를 이용하여 사용한다.
	JSONObject json = new JSONObject();
	json.put("result", count);
	
	out.print(json);
%>