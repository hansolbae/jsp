<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String uid = request.getParameter("uid");
	
	// 데이터베이스 정보
	final String HOST = "jdbc:mysql://192.168.0.161:3306/bhs";
	final String USER = "bhs";
	final String PASS = "1234";
	
	Connection conn = null;
	PreparedStatement psmt = null;

	try {
		// 1단계 - JDBC 드라이버 로드
		Class.forName("com.mysql.jdbc.Driver");
		
		// 2단계 - 데이터베이스 접속
		conn = DriverManager.getConnection(HOST, USER, PASS);
		
		// 3단계 - SQL 실행객체 생성
		psmt = conn.prepareStatement("DELETE FROM `MEMBER` WHERE `uid`=?;");
		psmt.setString(1, uid);
		
		// 4단계 - SQL 실행
		psmt.executeUpdate();
		
		// 5단계 - 결과셋처리(SELECT일 경우)
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		
		// 6단계 - 데이터베이스 종료
		psmt.close();
		conn.close();
	}
		
	// 삭제 후 다시 목록으로 이동
	response.sendRedirect("14-3.jsp");
		
%>