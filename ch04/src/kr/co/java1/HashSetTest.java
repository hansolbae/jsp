package kr.co.java1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 * 날짜 : 2019/05/02
 * 이름 : 배한솔
 * 내용 : Collection HashSet 실습하기
 */
public class HashSetTest {
	
	public static void main(String[] args) {
		
		Set<Integer> set = new HashSet<Integer>();
		
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(5);
		set.add(3);
		
		System.out.println("집합 원소 갯수 : " + set.size());
		
		// 반복하여 원소 출력
		Iterator<Integer> it = set.iterator();
		
		while(it.hasNext()) {
			System.out.println("set 원소 : " + it.next());
		}
	}

}
