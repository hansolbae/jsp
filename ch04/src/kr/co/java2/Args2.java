package kr.co.java2;

public class Args2 {

	int x2;
	
	
	public void add(int x2) {
		this.x2 = x2 + 50;
	}
	
	public void add(int[] arr2) {
		arr2[0]++;
	}
	
	public void add(Args2 arg2) {
		arg2.x2 = arg2.x2 + 40;
	}
	
	public Args2 addNew(Args2 arg2) {
		
		arg2 = new Args2();
		
		return arg2;
	}
}
