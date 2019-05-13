<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String code = request.getParameter("code");
	String viewPageURI = null;
	
	if(code.equals("A")) {
		viewPageURI = "/p185.jsp";
	} else if (code.equals("B")) {
		viewPageURI = "/p185-b.jsp";
	} else if (code.equals("C")) {
		viewPageURI = "/p185-c.jsp";
	}
%>
	<jsp:forward page="<%= viewPageURI %>" />