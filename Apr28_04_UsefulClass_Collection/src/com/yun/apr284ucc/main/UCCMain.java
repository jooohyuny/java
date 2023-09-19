package com.yun.apr284ucc.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

// []
//		만들때 사이즈 고정
//			만들깨 사이즈 모르면?
//			사이즈 변경 불가
//		인덱스 기반 -> 뭔 의미인지...
//		자료형 섞을 수 없음
//		=> 간단히 써먹을때나 쓰지, 본격적 데이터들을 표현하기 어렵

// Collection
//		자료형 섞어서 넣을 수 있는데, 그게 딱히...
//		객체만 넣을 수 있음
//		List계열	: 가변사이즈 배열
// 		Set계열	: 
//		Map계열 	:

// <클래스명> : generic
//		그 자료형만 쓸수있게 강제
public class UCCMain {
	public static void main(String[] args) {
		ArrayList al = new ArrayList<>();
		al.add(10); // 추가?
		al.add(5005);
		al.add("ㅋ"); // 섞기?

		System.out.println(al.get(0));
		System.out.println(al.size());

		System.out.println("-----------------");
		ArrayList<Integer> al2 = new ArrayList<>();
		al2.add(30);
		al2.add(432);
		al2.add(1); // 뒤에 추가
		al2.add(0, 999); // 위치 지정해서 추가하기
		al2.add(2, 111); // 바꾸기
		al2.remove(3); // 지우기

		Comparator<Integer> c = new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2); // 오름차순
				// return o2.compareTo(o1);
			}
		};

		for (int i = 0; i < al2.size(); i++) {
			System.out.println(al2.get(i));
		}
		System.out.println("-----------------");
		for (Integer integer : al2) {
			System.out.println(integer);
		}

	}
}
