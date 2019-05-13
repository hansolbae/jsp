<!-- jsp파일을 선언하는 선언문이므로 반드시 입력 -->
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!-- 브라우저 화면에 출력할 HTML태그가 없음 -->
<%	
	// 1단계 - 파라미터 수신
	String uid  = request.getParameter("uid");
	String pass = request.getParameter("pass");
	
	// 2단계 - 데이터베이스 처리(생략)
	
	// 3단계 - 회원일치 여부 확인
	// ★★★ 'if(uid == "abcd" && pass == "1234")'는 틀린 표현(문자열 비교가 아님) ★★★
	if(uid.equals("abcd") && pass.equals("1234")) {
		// 회원이 맞는 경우
		
		// 세션에 회원정보 저장
		session.setAttribute("uid", uid);
		session.setAttribute("pass", pass);
		
		// 리다이렉트('./' : 현재 디렉토리를 의미, 생략 가능)
		response.sendRedirect("./loginOk.jsp");
		
	} else {
		// 회원이 아닐 경우
		response.sendRedirect("./login.jsp?result=fail");
		
	}
	
%>