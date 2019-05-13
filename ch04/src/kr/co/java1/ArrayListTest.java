package kr.co.java1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 * 날짜 : 2019/05/02
 * 이름 : 배한솔
 * 내용 : Collection ArrayList 실습하기
 */
public class ArrayListTest {
	
	public static void main(String[] args) {
		
		List<Integer> list1 = new ArrayList<Integer>();
		
		// 원소 추가
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);
		
		// 첫번째 원소 '1' 제거
		list1.remove(0);
		
		// 리스트 원소 갯수
		System.out.println("list1 전체 사이즈 : " + list1.size());
		
		// 리스트 원소 추출
		System.out.println("list1 1번째 원소 : " + list1.get(0));
		System.out.println("list1 2번째 원소 : " + list1.get(1));
		System.out.println("list1 3번째 원소 : " + list1.get(2));
		
		
		List<String> list2 = new ArrayList<String>();
		
		list2.add("서울");
		list2.add("대전");
		list2.add("대구");
		list2.add("부산");
		list2.add("광주");
		
		for(String city : list2) {
			System.out.println("list2 원소 : " + city);
		}
		
		/*
		for(int i=0; i<list2.size(); i++) {
			System.out.println("list2 " + (i+1) + "번째 원소 : " + list2.get(i));
		}
		*/
		
		/*
		System.out.println("list2 1번째 원소 : " + list2.get(0));		
		System.out.println("list2 2번째 원소 : " + list2.get(1));		
		System.out.println("list2 3번째 원소 : " + list2.get(2));		
		System.out.println("list2 4번째 원소 : " + list2.get(3));		
		System.out.println("list2 5번째 원소 : " + list2.get(4));
		*/
		
		
		List<Apple> list3 = new ArrayList<Apple>();
		
		list3.add(new Apple("한국", 5000));
		list3.add(new Apple("중국", 2000));
		list3.add(new Apple("일본", 4000));
		list3.add(new Apple("미국", 3000));
		list3.add(1, new Apple("호주", 3500));
		
		System.out.println("3번째 사과는 " + list3.get(4).getCountry() + "입니다.");

	}

}
