<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// '14-1.jsp에서 method="post"'를 넣으면 인코딩을 해주어야 한다.	
	request.setCharacterEncoding("UTF-8");

	String uid  = request.getParameter("uid");
	String name = request.getParameter("name");
	String hp   = request.getParameter("hp");
	String pos  = request.getParameter("pos");
	String dep  = request.getParameter("dep");
	
	// 데이터베이스 정보
	final String HOST = "jdbc:mysql://192.168.0.161:3306/bhs";
	final String USER = "bhs";
	final String PASS = "1234";

	// 선언(Connection conn;)만 하는 것보다 null로 초기화해주는 것이 좋다.
	Connection conn = null;
	PreparedStatement psmt = null;
	
	try {
		// 1단계 - JDBC 드라이버 로드
		Class.forName("com.mysql.jdbc.Driver");
		
		// 2단계 - 데이터베이스 접속
		conn = DriverManager.getConnection(HOST, USER, PASS);
		
		// 3단계 - SQL 실행객체 생성 및 데이터 맵핑
		// Statement stmt = conn.createStatement();
		psmt = conn.prepareStatement("INSERT INTO `MEMBER` SET uid=?, name=?, hp=?, pos=?, dep=?, rdate=NOW();");
		psmt.setString(1, uid);
		psmt.setString(2, name);
		psmt.setString(3, hp);
		psmt.setString(4, pos);
		psmt.setInt(5, Integer.parseInt(dep));
		
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
	
	// 데이터 입력 후 다시 목록화면으로 이동
	response.sendRedirect("14-3.jsp");
	
%>