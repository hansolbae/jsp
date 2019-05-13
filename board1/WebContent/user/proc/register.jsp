<!-- 처리페이지 -->
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// post방식 → 디코딩(언어셋 지정)
	request.setCharacterEncoding("UTF-8");
	
	// 파라미터 수신
	String id    = request.getParameter("id");
	String pw1   = request.getParameter("pw1");
	String pw2   = request.getParameter("pw2");
	String name  = request.getParameter("name");
	String nick  = request.getParameter("nick");
	String email = request.getParameter("email");
	String hp    = request.getParameter("hp");
	String zip   = request.getParameter("zip");
	String addr1 = request.getParameter("addr1");
	String addr2 = request.getParameter("addr2");
	String regip = request.getRemoteAddr();
	
	// 데이터베이스 정보
	final String HOST = "jdbc:mysql://192.168.0.161:3306/bhs";
	final String USER = "bhs";
	final String PASS = "1234";
		
	Connection conn = null;
	PreparedStatement psmt = null;
	
	// 1단계
	Class.forName("com.mysql.jdbc.Driver");
	
	// 2단계
	conn = DriverManager.getConnection(HOST, USER, PASS);
	
	// 3단계
	String sql = "INSERT INTO `JSP_USER` SET ";
		// sql += "uid='"+id+"',";
		   sql += "uid=?,";
	    // PASSWORD() 내장함수 이용
		   sql += "pass=PASSWORD(?),";
		   sql += "name=?,";
		   sql += "nick=?,";
		   sql += "email=?,";
		   sql += "hp=?,";
		// grade : 디폴트 값(2)이 설정되어 있으므로 생략
		   sql += "zip=?,";
		   sql += "addr1=?,";
		   sql += "addr2=?,";
		   sql += "regip=?,";
		   sql += "rdate=NOW()";
	
	psmt = conn.prepareStatement(sql);
	psmt.setString(1, id);
	psmt.setString(2, pw1);
	psmt.setString(3, name);
	psmt.setString(4, nick);
	psmt.setString(5, email);
	psmt.setString(6, hp);
	psmt.setString(7, zip);
	psmt.setString(8, addr1);
	psmt.setString(9, addr2);
	psmt.setString(10, regip);

	// 4단계
	psmt.executeUpdate();
	
	// 5단계
	// 6단계
	psmt.close();
	conn.close();
	
	// 로그인 화면 이동
	response.sendRedirect("../login.jsp");
%>