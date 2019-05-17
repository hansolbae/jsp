<%@page import="kr.co.board1.bean.UserBean"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	
	UserBean ub = (UserBean) session.getAttribute("user");
	
	if(ub == null) {
		// 로그인화면 포워딩
		// 로그인 안 했을 떄
		pageContext.forward("./user/login.jsp");
	} else {
		// 로그인 했을 때
		pageContext.forward("./list.jsp");
	}
%>