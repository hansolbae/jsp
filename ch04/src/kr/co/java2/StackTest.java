package kr.co.java2;

/*
 * 날짜 : 2019/05/03
 * 이름 : 배한솔
 * 내용 : Stack 메모리 실습하기
 */
public class StackTest {
	
	public static void main(String[] args) {
		
		int result = 0;
		int begin  = 1;
		int end	   = 10;
		
		// 'public static int sum'에서의 'static' 대신 쓸 수 있는 방법
		/* StackTest st = new StackTest();
		   st.sum(begin, end); */
		
		result = sum(begin, end);
		
		System.out.println("result : " + result);
		
	}
	
	public static int sum(int start, int end) {
		
		int sum = 0;
		
		for(int k=start; k<=end; k++) {
			sum += k;
		}
		
		return sum;
	}

}
