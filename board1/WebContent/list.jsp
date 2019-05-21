<%@page import="kr.co.board1.service.BoardService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.board1.bean.BoardBean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="kr.co.board1.config.SQL"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.co.board1.config.DBConfig"%>
<%@page import="kr.co.board1.bean.UserBean"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	UserBean ub = (UserBean) session.getAttribute("user");
	String nick = null;
	 
	List<BoardBean> list = new ArrayList<>();	// List<BoardBean> list : 선언, list = new ArrayList<>(); : 생성
	int totalPage = 0;
	int listCount = 0;
	int[] groupStartEnd = new int[2];	// 배열 생성
	
	if(ub == null){		// 세션에 저장되어 있는 사용자 정보가 없음
		// 로그인을 안 했을 때(로그인 하도록 돌려보냄)
		response.sendRedirect("./user/login.jsp?result=101");
	}else{				// 세션에 저장되어 있는 사용자 정보가 있음
		// 로그인을 했을 때
		nick = ub.getNick();
		
		request.setCharacterEncoding("UTF-8");
		String pg = request.getParameter("pg");
		
		BoardService bs = BoardService.getInstance();	// service는 private이므로 참조 불가 → getInstance() 라는 메서드를 만들어 호출
	
		int total = bs.getTotalBoard();
		totalPage = bs.getTotalPage(total);
		
		int start = bs.getStartForLimit(pg);
		list = bs.getBoardList(start);
		
		// 목록 출력용 번호
		listCount = bs.getListStartCount(total, start);	// 메서드를 만들어 호출하는 것은 모듈을 만들어 코드를 응집시킬 수 있는 효과가 있음
		
		// 목록 페이지 그룹 번호
		groupStartEnd = bs.getPageGroupStartEnd(pg, totalPage);	// 리턴해야 html에서 사용가능함
		
	}
	
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>글목록</title> 
		<link rel="stylesheet" href="./css/style.css" />
	</head>
	<body>
		<div id="board">
			<h3>글목록</h3>
			<!-- 리스트 -->
			<div class="list">
				<p class="logout"><%= nick %>님! 반갑습니다. <a href="/board1/user/proc/logout.jsp">[로그아웃]</a><p>
				<table>
					<tr>
						<td>번호</td>
						<td>제목</td>
						<td>글쓴이</td>
						<td>날짜</td>
						<td>조회</td>
					</tr>
				
					<% for(BoardBean bb : list){ %>
					<tr>
						<td><%= listCount-- %></td>
						<td><a href="#"><%= bb.getTitle() %></a>&nbsp;[<%= bb.getComment() %>]</td>
						<td><%= bb.getNick() %></td>
						<td><%= bb.getRdate().substring(2, 10) %></td>
						<td><%= bb.getHit() %></td>
					</tr>
					<% } %>
					
				</table>
			</div>
			<!-- 페이징 -->
			<nav class="paging">
				<span> 
				<a href="./list.jsp?pg=<%= groupStartEnd[0] - 1 %>" class="prev">이전</a>.
				
				<% for(int i=groupStartEnd[0]; i<=groupStartEnd[1]; i++) { %>	<!-- 배열의 첫번째, 두번째 사용 -->
				<a href="./list.jsp?pg=<%= i %>" class="num"><%= i %></a> <!-- 파라미터 번호로 페이지 번호 전달 -->
				<% } %>
				
				<a href="./list.jsp?pg=<%= groupStartEnd[1] + 1 %>" class="next">다음</a>
				</span>
			</nav>
			<a href="/board1/write.jsp" class="btnWrite">글쓰기</a>
		</div>
	</body>

</html>


