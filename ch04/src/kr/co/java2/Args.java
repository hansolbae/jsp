package kr.co.java2;

public class Args {

	int x;
	
	public void add(int x) {
		x = x + 50;
	}
	/*
	public void add(int x) {
		this.x = x + 50;
	}
	이렇게 입력하면 결과의 값은 150, 190, 190으로 출력된다.
	*/
	
	public void add(int[] arr) {
		arr[0]++;
	}
	
	public void add(Args arg) {
		arg.x = arg.x + 40;
	}
	
	public void addNew(Args arg) {
		arg = new Args();
	}
	/*
	public Args addNew(Args arg) {
		
		arg = new Args();
		
		return arg;		 ──────── ①
	}
	*/
	
	
}
