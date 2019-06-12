/**
 * 회원약관 동의체크 구현
 */
$(document).ready(function(){
	
	// 다음 버튼 클릭했을 때, 클릭 이벤트 함수 구현
	$('.btnNext').click(function(){  // function(){}=핸들러
		
		var chk1 = $('input[name=chk1]').is(':checked'); // checkbox checked 여부
		var chk2 = $('input[name=chk2]').is(':checked');
		
		if(!chk1){ // 사이트 이용약관 동의 체크가 체크 되지 않았을 때
			alert('사이트 이용약관에 동의 체크를 해주세요.');
			
			// a태그의 링크이동 취소
			return false;
		}else if(!chk2){  // 개인정보 취급방침 동의 체크가 체크 되지 않았을 때
			alert('개인정보 취급방침 동의 체크를 해주세요.');
			
			// a태그의 링크이동 취소
			return false;
		}else{  // 동의체크가 체크 되었을 때
			// a태그의 링크이동
			return true;
		}
	});
});
		