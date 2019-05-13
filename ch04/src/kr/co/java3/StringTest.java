package kr.co.java3;

/*
 * 날짜 : 2019/05/03
 * 이름 : 배한솔
 * 내용 : String 실습하기
 */
public class StringTest {

		public static void main(String[] args) {
			
			// 문자
			char c = 'H';
			char[] cArr = {'H', 'e', 'l', 'l', 'o'};
			
			// 문자열(문자+배열) → 배열의 특징인 객체
			String str1 = "Hello";
			String str2 = new String("Hello");
			String str3 = new String("Hello");
			String str4 = "Hello";
			
			// 문자열 비교(주소값 비교)
			if(str1 == str2) {
				System.out.println("str1과 str2의 주소값(참조값)이 같다.");
			} else {
				System.out.println("str1과 str2의 주소값(참조값)이 다르다.");
			}
			
			if(str1 == str4) {
				System.out.println("str1과 str4의 주소값(참조값)이 같다.");
			} else {
				System.out.println("str1과 str4의 주소값(참조값)이 다르다.");
			}
			
			// 문자열 비교
			if(str1.equals(str2)) {
				System.out.println("str1과 str2의 문자열이 같다.");
			} else {
				System.out.println("str1과 str2의 문자열이 다르다.");
			}
			
			// 문자열 멤버메서드
			System.out.println("str 문자열 길이 : " + str1.length());
			
			char c1 = str1.charAt(0); // 배열
			char c2 = str1.charAt(2);
			char c3 = str1.charAt(3);
			
			System.out.println("c1 : " + c1);
			System.out.println("c2 : " + c2);
			System.out.println("c3 : " + c3);
			
			// 문자열 추출
			String v1 = "Hello Korea";
			String v2 = v1.substring(6);
			String v3 = v1.substring(6, 9);
			System.out.println("v2 : " + v2);
			System.out.println("v3 : " + v3);
			
			// index 번호 추출
			int v4 = v1.indexOf("e");			// 앞에서부터 첫 'e'가 몇 번째에 있는가?
			int v5 = v1.lastIndexOf("e");		// 앞에서부터 마지막 'e'가 몇 번째에 있는가?
			System.out.println("v4 : " + v4);
			System.out.println("v5 : " + v5);
			
			// 문자열 바꾸기
			String v6 = v1.replace("Korea", "Busan");
			System.out.println("v6 : " + v6);
		}
}
