<%@page import="kr.co.board1.service.BoardService"%>
<%@page import="kr.co.board1.bean.BoardBean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="kr.co.board1.config.SQL"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.co.board1.config.DBConfig"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String pg 	= request.getParameter("pg");
	String seq 	= request.getParameter("seq");
	
	BoardService service = BoardService.getInstance();
	
	service.updateHit(seq);
	BoardBean bb = service.viewBoard(seq);
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>글보기</title> 
		<link rel="stylesheet" href="./css/style.css" />
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	</head>
	<body>
		<div id="board">
			<h3>글보기</h3>
			<div class="view">
				<form action="#" method="post">
					<table>
						<tr>
							<td>제목</td>
							<td><input type="text" name="subject" value="<%= bb.getTitle() %>" readonly />
							</td>
						</tr>
						
						<%
							if(bb.getFile() == 1){
						%>						
							<tr>
								<td>첨부파일</td>
								<td>
									<a href="#">테스트.hwp</a>
									<span>3회 다운로드</span>
								</td>
							</tr>
						<%
							}
						%>
						
						<tr>
							<td>내용</td>
							<td>
								<textarea name="content" rows="20" readonly><%= bb.getContent() %></textarea>
							</td>
						</tr>
					</table>
					<div class="btns">
						<a href="./proc/delete.jsp?pg=<%= pg %>&seq=<%= bb.getSeq() %>" class="cancel del">삭제</a>
						<a href="#" class="cancel mod">수정</a>
						<a href="./list.jsp?pg=<%= pg %>" class="cancel">목록</a>
					</div>
				</form>
			</div><!-- view 끝 -->
			
			<!-- 댓글리스트 -->
			<section class="comments">
				<h3>댓글목록</h3>
				
				
				<div class="comment">
					<span>
						<span>홍길동</span>
						<span>18-03-01</span>
					</span>
					<textarea>테스트 댓글입니다.</textarea>
					<div>
						<a href="#" class="del">삭제</a>
						<a href="#" class="mod">수정</a>
					</div>
				</div>
				
			
				<p class="empty">
					등록된 댓글이 없습니다.
				</p>
				
			</section>
			
			<!-- 댓글쓰기 -->
			<section class="comment_write">
				<h3>댓글쓰기</h3>
				<div>
					<form action="./proc/commentWrite.jsp" method="post">
						<textarea name="comment" rows="5"></textarea>
						<div class="btns">
							<a href="#" class="cancel">취소</a>
							<input type="submit" class="submit" value="작성완료" />
						</div>
					</form>
					<script>
						$(function(){
							
							var btnSubmit = $('.comment_write .submit');
							
							btnSubmit.click(function(){
								
								var textarea = $('.comment_write textarea');
								var content = textarea.val();
								
								if(content == ""){									
									alert('댓글 내용을 입력하세요.');
									textarea.focus();									
								}else{
									var jsonData = {content:content};
									
									$.ajax({
										url: './proc/commentWrite.jsp',
										type: 'post',
										dataType: 'json',
										data: jsonData,
										success: function(result){
											
											alert(result.content);
										}										
									});		
								}
								
								return false; // 폼전송 취소
								
							});
							
							
						});

					</script>
				</div>
			</section>
		</div><!-- board 끝 -->
	</body>
</html>













