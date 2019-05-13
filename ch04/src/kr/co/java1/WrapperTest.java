package kr.co.java1;

/*
 * 날짜 : 2019/05/02
 * 이름 : 배한솔
 * 내용 : wrapper 클래스 실습하기
 */

public class WrapperTest {
	
	public static void main(String[] args) {
		
		// 기본타입 변수
		boolean var1 = true;
		int		var2 = 10;
		long	var3 = 1000L;
		char	var4 = 'A';
		double	var5 = 1.2345;
		
		// 기본타입 → String
		String s1 = String.valueOf(var1);
		String s2 = String.valueOf(var2);
		String s3 = String.valueOf(var3);
		String s4 = "" + var4;
		String s5 = "" + var5;
		
		System.out.println("s1 : " + s1);
		System.out.println("s2 : " + s2);
		System.out.println("s3 : " + s3);
		System.out.println("s4 : " + s4);
		System.out.println("s5 : " + s5);
		
		// Wrapper 클래스
		Boolean wp1 = new Boolean(true);
		Integer wp2 = new Integer(10);
		Long	wp3 = new Long(1000);
		Double	wp4 = new Double(1.2345);
		
		// Wrapper → String
		String st1 = wp1.toString();
		String st2 = wp2.toString();
		String st3 = wp3.toString();
		String st4 = wp4.toString();
		
		System.out.println("st1 : " + st1);
		System.out.println("st2 : " + st2);
		System.out.println("st3 : " + st3);
		System.out.println("st4 : " + st4);
		
		// Wrapper 활용 I (String → 기본타입) : 'new ~ " 생략 가능 및 생략된 형태
		String str1 = new String("false");
		String str2 = "100";
		String str3 = "1.234567";
		
		boolean r1 = Boolean.parseBoolean(str1);
		int		r2 = Integer.parseInt(str2);
		double	r3 = Double.parseDouble(str3);
		
		System.out.println("r1 : " + r1);
		System.out.println("r2 : " + r2);
		System.out.println("r3 : " + r3);
		
		// Wrapper 활용 II (String → Wrapper)
		Boolean w1 = Boolean.valueOf(str1);
		Integer w2 = Integer.valueOf(str2);
		Double	w3 = Double.valueOf(str3);
		
		System.out.println("w1 : " + w1);
		System.out.println("w2 : " + w2);
		System.out.println("w3 : " + w3);
		
		// auto-boxing : 'new ~ " 생략 가능 및 생략된 형태
		Boolean box1 = new Boolean(true);
		Integer box2 = 100;
		Double	box3 = 1.123;
		
		
		// auto-unboxing
		boolean ubx1 = box1;
		int		ubx2 = box2;
		double	ubx3 = box3;
		
		System.out.println("ubx1 : " + ubx1);
		System.out.println("ubx2 : " + ubx2);
		System.out.println("ubx3 : " + ubx3);
		
		
	}

}
