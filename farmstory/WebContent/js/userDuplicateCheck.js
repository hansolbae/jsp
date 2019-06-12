// 아이디 중복체크
$(function(){
	
	$('input[name=id]').focusout(function(){
		
		var tag = $(this);
		var uid = tag.val();
		
		// AJAX통신(부분통신) 시작
		$.ajax({
			url: '../user/uidCheck.do?uid='+uid,
			type: 'get',
			dataType: 'json',
			success: function(data){
				if(data.cnt == 1){
					$('.resultId').css('color','red').text('이미 사용 중인 아이디 입니다.');
					tag.focus();
				} else {
					$('.resultId').css('color','green').text('사용 가능한 아이디 입니다.');
				}
			}
		});
		
	});

});