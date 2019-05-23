<%@page import="org.json.simple.JSONObject"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String content = request.getParameter("content");
	
	// JSON 데이터 생성
	JSONObject json = new JSONObject();
	json.put("content", content);
	
	out.print(json);	
%>