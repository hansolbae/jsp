<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 스크립트페이지가 아닌 선언문 -->
<%!
	// 모든 페이지(jsp)의 공통의 전역변수로 정의
	// 상수를 사용하므로 final
	// final은 일반적으로 대문자 사용
	final String HOST = "mysql:jdbc:192.168.0.111:3306/abcd";
	final String USER = "abcd";
	final String PASS = "1234";
%>