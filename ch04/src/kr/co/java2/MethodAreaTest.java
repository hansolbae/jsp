package kr.co.java2;

/*
 * 날짜 : 2019/05/03
 * 이름 : 배한솔
 * 내용 : Method Area 메모리 실습하기
 */
public class MethodAreaTest {

	public static void main(String[] args) {
		
		Increase ic1 = new Increase();
		Increase ic2 = new Increase();
		Increase ic3 = new Increase();
		
		// 객체를 통해 참조할 수 있다.
		ic1.num1 = 2;
		
		// 클래스 변수 : ic1과 같은 객체 생성을 하지 않아도 된다.(∵ static)
		Increase.num2 = 2;
		
		// 클래스 메서드 : 객체 생성을 하지 않아도 된다.
		Increase.add();
		
	}
}
