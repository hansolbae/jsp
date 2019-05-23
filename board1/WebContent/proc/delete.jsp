<!-- 글삭제 : 처리페이지 -->
<%@page import="kr.co.board1.config.SQL"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.co.board1.config.DBConfig"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String seq = request.getParameter("seq");
	String pg  = request.getParameter("pg");
	
	// 1단계, 2단계
	Connection conn = DBConfig.getConnection(); 
	
	// 3단계
	PreparedStatement psmt = conn.prepareStatement(SQL.DELETE_BOARD);
	psmt.setString(1, seq);
	
	// 4단계
	psmt.executeUpdate();
	
	// 5단계 - 결과셋 처리(SELECT일 경우)
	
	// 6단계 - 데이터베이스 종료
	psmt.close();
	conn.close();
	
	// 글목록 화면 이동
	response.sendRedirect("../list.jsp?pg="+pg);

%>