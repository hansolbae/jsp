<%@page import="java.util.List"%>
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
	
	String pg  = request.getParameter("pg");	// list.jsp에서 전달받은 파라미터 값 → list.jsp로 다시 전달
	String seq = request.getParameter("seq");	// list.jsp에서 전달받은 seq값
	
	
	BoardService service = BoardService.getInstance();	// 싱글톤 객체(객체 생성 불가능)
	
	service.updateHit(seq);	// 리턴할 필요x
	BoardBean bb = service.viewBoard(seq);	// 리턴
	
	// 댓글 리스트 가져오기
	List<BoardBean> commentList = service.commentList(seq);	// 리턴, ArrayList→List : 자바의 다형성(=객체간의 결합도를 느슨하게 함)
	
	
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
							if(bb.getFile() == 1){	// 첨부파일이 있으면 출력, 없으면 출력x
						%>
							<tr>
								<td>첨부파일</td>
								<td>
									<a href="./proc/download.jsp?seq=<%= bb.getSeq() %>&oldName=<%= bb.getOldName() %>&newName=<%= bb.getNewName() %>"><%= bb.getOldName() %></a>
									<span><%= bb.getDownload() %>회 다운로드</span>
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
						<a onclick="return confirm('정말로 삭제하시겠습니까?')" href="./proc/delete.jsp?pg=<%= pg %>&seq=<%= bb.getSeq() %>" class="cancel del">삭제</a>
						<a href="#" class="cancel mod">수정</a>
						<a href="./list.jsp?pg=<%= pg %>" class="cancel">목록</a><!-- 파라미터값 다시 전달 -->
					</div>
				</form>
			</div><!-- view 끝 -->
			
			<!-- 댓글리스트 -->
			<style>
				.comments > .comment:nth-of-type(1) {
					display: none;	/* 보이지 않도록 처리 */
				}
			</style>
			<section class="comments">
				<h3>댓글목록</h3>
				<div class="comment"><!-- 가짜 commentView : 출력x(style 지정) -->
					<span>
						<span class="nick">닉네임</span>
						<span class="rdate">날짜</span>
					</span>
					<textarea>내용</textarea>
					<div>
						<a href="#" class="del">삭제</a>
						<a href="#" class="mod">수정</a>
					</div>
				</div>
				
				<!-- 댓글갯수만큼 생성된 댓글 객체(=BoardBean)를 ArrayList로 출력 -->
				<%
					for(BoardBean comment :commentList){	// comment = 댓글고유번호(seq)
				%>
					<div class="comment"><!-- 댓글이 있을 때 출력, commentList 갯수만큼 생성됨 -->
						<span>
							<span class="nick"><%= comment.getNick() %></span>
							<span class="rdate"><%= comment.getRdate().substring(2, 10) %></span>
						</span>
						<textarea><%= comment.getContent() %></textarea>
						<div>
							<a href="./proc/commentDelete.jsp?seq=<%= comment.getSeq() %>&parent=<%= seq %>&pg=<%= pg %>" class="del">삭제</a>
							<a href="#" class="mod">수정</a>
						</div>
					</div>
				<%
					}
				
					if(commentList.size() == 0){
				%>
				<p class="empty"><!-- 댓글이 없을 때 출력 -->등록된 댓글이 없습니다.</p>
				<%
					}
				%>
				
			</section>
			
			<!-- 댓글쓰기 -->
			<section class="comment_write">
				<h3>댓글쓰기</h3>
				<div>
					<form action="#" method="post">
						<input type="hidden" name="parent" value=<%= bb.getSeq() %> /><!-- 부모글번호(seq) : 보일필요가 없으므로 hidden -->
						<textarea name="comment" rows="5"></textarea>
						<div class="btns">
							<a href="#" class="cancel">취소</a>
							<input type="submit" class="submit" value="작성완료" />
						</div>
					</form>
					<script><!-- script 위치는 관계없음 -->
					
						/*$(function(){
							var message = $('.btns .calcel del');
							message.confirm("정말로 삭제하시겠습니까?");
							if(message == true){
								alert("삭제되었습니다.");
							}else{
								return false;
							}
						});*/
					
						$(function(){
							
							var comments = $('.comments');
							var btnSubmit = $('.comment_write .submit'); // comment_write 하위의 submit클래스(선택자)
							
							btnSubmit.click(function(){	// 클릭 이벤트 함수(사용多)
								var commentView = $('.comments > .comment:nth-of-type(1)');
								var textarea  = $('.comment_write textarea'); // comment_write 하위의 textarea
								var parent    = $('.comment_write input[name=parent]').val();
								var content   = textarea.val(); // val=value(데이터)
								
								if(content == ""){ // 댓글 내용이 없다면
									alert('댓글 내용을 입력하세요.');
									textarea.focus();
								}else{
									var jsonData = {parent:parent, content:content};
									
									$.ajax({
										url: './proc/commentWrite.jsp',
										type: 'post',	// url에서 파라미터 값을 따로 지정하게 되면 get방식 사용
										dataType: 'json',
										data: jsonData,
										success: function(result){	// result={content:~~, nick:000, rdate:00-00-00}
											var commentNew = commentView.clone();	// 객체 복사
										
											commentNew.find('.nick').text(result.nick);
											commentNew.find('.rdate').text(result.rdate);
											commentNew.find('textarea').text(result.content);
											
											comments.append(commentNew);
											
											textarea.val('');
											
											// empty 문구삭제(댓글 입력 시 '등록된 댓글이 없습니다' 문구 삭제)
											var empty = $('.empty');
											
											if(empty.is(':visible')){
												empty.remove();
											}
										}										
									});	
								}
								
								return false;  // 폼전송 취소(페이지 이동x)
								
							});
						});
					</script>
				</div>
			</section>
		</div><!-- board 끝 -->
	</body>

</html>
