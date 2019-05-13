package kr.co.java2;

/*
 * 날짜 : 2019/05/03
 * 이름 : 배한솔
 * 내용 : Heap 메모리 실습하기
 */
public class HeapTest {
	
	public static void main(String[] args) {
			
		Args arg = new Args();
		arg.x = 100;
		
		int[] arr = {1, 2, 3};
		
		arg.add(arg.x);
		System.out.println("arg.x = " + arg.x);
		
		arg.add(arg);
		System.out.println("arg.x = " + arg.x);
		
		arg.addNew(arg);
		System.out.println("arg.x = " + arg.x);
		/*
		arg = arg.addNew(arg);
		System.out.println("arg.x = " + arg.x); ────── ②
		결과 : 0
		*/
		
		arg.add(arr);
		System.out.println("arr[0] = " + arr[0]);
		
	}
}
