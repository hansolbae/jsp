<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="/farmstory/js/termsCheck.js"></script>
<%@ include file="../_head.jsp" %>

<div id="terms">
	<section>
		<table>
			<caption>사이트 이용약관</caption>
			<tr>
				<td>
					<textarea readonly>${requestScope.vo.getTerms()}</textarea>
					<div>
						<label><input type="checkbox" name="chk1" />&nbsp;동의합니다.</label>        
					</div>
				</td>
			</tr>
		</table>
	</section>			
	<section>
		<table>
			<caption>개인정보 취급방침</caption>
			<tr>
				<td>
					<textarea readonly>${vo.privacy}</textarea>
					<div>
						<label><input type="checkbox" name="chk2" />&nbsp;동의합니다.</label>        
					</div>
				</td>
			</tr>
		</table>
	</section>
	
	<div>
		<a href="/farmstory/user/login.do" class="btnCancel">취소</a>
		<a href="/farmstory/user/register.do" class="btnNext">다음</a>
	</div>
	
</div>

<%@ include file="../_footer.jsp" %>










