package kr.co.java2;

/*
 * ��¥ : 2019/05/03
 * �̸� : ���Ѽ�
 * ���� : Heap �޸� �ǽ��ϱ�
 */
public class HeapTest2 {
	
	public static void main(String[] args) {
			
		Args2 arg2 = new Args2();
		arg2.x2 = 100;
		
		int[] arr2 = {1, 2, 3};
		
		arg2.add(arg2.x2);
		System.out.println("arg2.x2 = " + arg2.x2);
		
		arg2.add(arg2);
		System.out.println("arg2.x2 = " + arg2.x2);
		
		
		arg2 = arg2.addNew(arg2);
		System.out.println("arg2.x2 = " + arg2.x2);
		
		
		arg2.add(arr2);
		System.out.println("arr2[0] = " + arr2[0]);
		
	}
}
