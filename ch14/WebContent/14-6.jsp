<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 전송파라미터 디코딩
	request.setCharacterEncoding("UTF-8");
	
	// 수정데이터 수신
	String uid  = request.getParameter("uid");
	String name = request.getParameter("name");
	String hp   = request.getParameter("hp");
	String pos  = request.getParameter("pos");
	String dep  = request.getParameter("dep");
	
	// 데이터베이스 정보
	final String HOST = "jdbc:mysql://192.168.0.161:3306/bhs";
	final String USER = "bhs";
	final String PASS = "1234";

	Connection conn = null;
	Statement stmt = null;
	
	try {
		// 1단계 - JDBC 드라이버 로드
		Class.forName("com.mysql.jdbc.Driver");
		
		// 2단계 - 데이터베이스 접속
		conn = DriverManager.getConnection(HOST, USER, PASS);
		
		// 3단계 - SQL 실행객체 생성
		stmt = conn.createStatement();
		
		// 4단계 - SQL 실행
		String sql = "UPDATE `MEMBER` SET ";
			   sql += "name='"+name+"',";
			   sql += "hp='"+hp+"',";
			   sql += "pos='"+pos+"',";
			   sql += "dep="+dep+" ";
			   sql += "WHERE `uid`='"+uid+"';";
			   
		stmt.executeUpdate(sql);

		// 5단계 - 결과셋처리(SELECT일 경우)
	} catch(Exception e) {
		e.printStackTrace();
	} finally {	
		// 6단계 - 데이터베이스 종료
		stmt.close();
		conn.close();
	}
	
	// 수정완료 후 목록으로 이동
	response.sendRedirect("14-3.jsp");
%>