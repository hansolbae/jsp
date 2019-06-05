/**
 * 날짜 : 2019/05/14
 * 이름 : 배한솔
 * 내용 : 사용자 아이디, 이메일, 닉네임, 휴대폰 중복체크
 */
/*= var doc = $(document);
	doc.ready(function(){}); */
/*= $(document).ready(function(){}); */
$(function(){
	
	// 아이디 필드에 포커스가 빠져나갈 때 실행되는 이벤트 함수
	$('input[name=id]').focusout(function(){  // 속성선택자, focusout()내장함수 사용
		
		var tag = $(this);
		var uid = tag.val();
		
		// AJAX통신(부분통신) 시작 ★★★
		$.ajax({  // jQuery객체의 ajax멤버(함수)
			url: './proc/checkUid.jsp?uid='+uid, // 서버주소
			type: 'get', // 통신타입(post/get)
			dataType: 'json',
			success: function(data){  // data매개변수로 1 또는 0이 들어옴 {'result'<K>:1<V>}
				if(data.result == 1){
					$('.resultId').css('color','red').text('이미 사용 중인 아이디 입니다.');
					tag.focus(); // 사용 중인 아이디일 때, 포커스를 잡아둔다.
				} else {
					$('.resultId').css('color','green').text('사용 가능한 아이디 입니다.');
				}
			}
		});
		
	});

	// 닉네임 중복 체크
	$('input[name=nick]').focusout(function(){
		
		var tag = $(this);
		var nick = tag.val();
		
		$.ajax({
			url: './proc/checkNick.jsp?nick='+nick,
			type: 'get',
			dataType: 'json',
			success: function(data){
				if(data.result == 1){
					$('.resultNick').css('color','red').text('이미 사용 중인 별명 입니다.');
					tag.focus();
				} else {
					$('.resultNick').css('color','green').text('사용 가능한 별명 입니다.');
				}
			}
		});
	});
	
	// 이메일 중복 체크
	$('input[name=email]').focusout(function(){
		
		var tag = $(this);
		var email = tag.val();
		
		$.ajax({
			url: './proc/checkEmail.jsp?email='+email,
			type: 'get',
			dataType: 'json',
			success: function(data){
				if(data.result == 1){
					$('.resultEmail').css('color','red').text('이미 사용 중인 이메일 입니다.');
					tag.focus();
				} else {
					$('.resultEmail').css('color','green').text('사용 가능한 이메일 입니다.');
				}
			}
		});
	});
	
	// 휴대폰 중복 체크
	$('input[name=hp]').focusout(function(){
		
		var tag = $(this);
		var hp = tag.val();
		
		$.ajax({
			url: './proc/checkHp.jsp?hp='+hp,
			type: 'get',
			dataType: 'json',
			success: function(data){
				if(data.result == 1){
					$('.resultHp').css('color','red').text('이미 사용 중인 번호 입니다.');
					tag.focus();
				} else {
					$('.resultHp').css('color','green').text('사용 가능한 번호 입니다.');
				}
			}
		});
	});
});