package kr.co.java2;

/*
 * ��¥ : 2019/05/03
 * �̸� : ���Ѽ�
 * ���� : Method Area �޸� �ǽ��ϱ�
 */
public class MethodAreaTest {

	public static void main(String[] args) {
		
		Increase ic1 = new Increase();
		Increase ic2 = new Increase();
		Increase ic3 = new Increase();
		
		// ��ü�� ���� ������ �� �ִ�.
		ic1.num1 = 2;
		
		// Ŭ���� ���� : ic1�� ���� ��ü ������ ���� �ʾƵ� �ȴ�.(�� static)
		Increase.num2 = 2;
		
		// Ŭ���� �޼��� : ��ü ������ ���� �ʾƵ� �ȴ�.
		Increase.add();
		
	}
}
