<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../_head.jsp" %>

<section id="sub" class="croptalk">
    <div><img src="../img/sub_top_tit3.png" alt="CROP TALK"></div>
    <section>
      <aside>
        <img src="../img/sub_aside_cate3_tit.png" alt="농작물이야기"/>
        <ul class="lnb">
          <li class="on"><a href="./story.html">농작물이야기</a></li>
          <li><a href="./grow.html">텃밭가꾸기</a></li>
          <li><a href="./school.html">귀농학교</a></li>
        </ul>
      </aside>
      <article>
        <nav>
          <img src="../img/sub_nav_tit_cate3_tit1.png" alt="농작물이야기"/>
          <p>
            HOME > 농작물이야기 > <span>농작물이야기</span>
          </p>
        </nav>
        <!-- 컨텐츠 내용 시작 -->

<div id="board">
	<h3>글목록</h3>
	<!-- 리스트 -->
	<div class="list">
		<table>
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>글쓴이</td>
				<td>날짜</td>
				<td>조회</td>
			</tr>
						
			<c:forEach var="vo" items="${requestScope.list}">
			<tr>
				<td>${vo.seq}</td>
				<td><a href="${count = count - 1}">${vo.title}</a>&nbsp;[${vo.comment}]</td>
				<td>${vo.nick}</td>
				<td>${vo.rdate.substring(2, 10)}</td>
				<td>${vo.hit}</td>
			</tr>
			</c:forEach>
			
		</table>
	</div>
	<!-- 페이징 -->
	<nav class="paging">
		<span> 
			<a href="#" class="prev">이전</a>
			
			<c:forEach var="i" begin="1" end="${page}">
			<a href="/board2/list.do?pg=${i}" class="num">${i}</a>
			</c:forEach>
			
			<a href="#" class="next">다음</a>
		</span>
	</nav>
	<a href="/farmstory/board/write.do" class="btnWrite">글쓰기</a>
</div>
		
<!-- 컨텐츠 내용 끝 -->
    </article>
  </section>
</section>
		
<%@ include file="../_footer.jsp" %>









