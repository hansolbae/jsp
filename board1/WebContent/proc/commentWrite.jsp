<%-- 댓글쓰기 : 처리페이지 --%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="kr.co.board1.bean.UserBean"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="kr.co.board1.config.SQL"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.co.board1.config.DBConfig"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String parent  = request.getParameter("parent");
	String content = request.getParameter("content");
	String regip   = request.getRemoteAddr();
	
	// 현재 로그인 사용자 세션열기
	UserBean ub = (UserBean)session.getAttribute("user");
	
	// 1단계, 2단계
	Connection conn = DBConfig.getConnection(); 
	
	// 3단계
	PreparedStatement psmt = conn.prepareStatement(SQL.INSERT_COMMENT);
	psmt.setString(1, parent);
	psmt.setString(2, content);
	psmt.setString(3, ub.getUid());
	psmt.setString(4, regip);
	
	// 4단계
	psmt.executeUpdate();
	
	// 5단계 - 결과셋 처리(SELECT일 경우)
	// 6단계 - 데이터베이스 종료
	psmt.close();
	conn.close();
	
		
	// JSON 데이터 생성
	Date date = new Date();	 // Date 클래스 이용
	SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");	// MM=월, mm=분(시간)
	String today = sdf.format(date);
	
	JSONObject json = new JSONObject();
	json.put("content", content);
	json.put("nick", ub.getNick());	// 세션에 저장된 UserBean 객체
	json.put("rdate", today);
	
	out.print(json);
	
%>