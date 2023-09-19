package com.yun.may021ucc.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;

import com.yun.may021ucc.cafe.Cafe;

// Collection
//		List계열	: 가변사이즈 배열
//		Set계열	: 중복자동제거, 순서?
//		Map계열	: ?

public class UCCMain {
	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<>();
		hs.add("ㅋ");
		hs.add("ㅎ");
		hs.add("ㄷㄷ");
		hs.add("ㅇ");
		hs.add("ㅋ");
		hs.add("ㅎ");
		hs.add("ㄱ");
		hs.add("ㄴ");
		hs.add("ㄴㄴ");
		System.out.println(hs.size()); // 중복자동제거
		// Set -> List
		ArrayList<String> al = new ArrayList<>(hs);
		for (String string : al) {
			System.out.println(string);
		}

		System.out.println("-----------");
		// 아메리카노, 3000원 커피

		HashSet<Cafe> coffee = new HashSet<>();
		coffee.add(new Cafe("아아", 3000));
		coffee.add(new Cafe("아아", 3000));
		coffee.add(new Cafe("아아", 3000));

		Cafe c = new Cafe("라떼", 4000);
		coffee.add(c);
		coffee.add(c);
		coffee.add(c);
		System.out.println(coffee.size());

		System.out.println("-----------");
		// 중복이 있는
		// 기본형급 (int, double, String ...) List
		// 의 중복 제거하려면
		ArrayList<Integer> al2 = new ArrayList<>();
		al2.add(10);
		al2.add(20);
		al2.add(30);
		al2.add(30);
		al2.add(421);
		al2.add(10);
		al2.add(10);
		al2.add(105);
		al2.add(60);
		// List -> Set
		HashSet<Integer> hs2 = new HashSet<>(al2);
		al2 = new ArrayList<>(hs2);
		for (Integer integer : hs2) {
			System.out.println(integer);
		}
		System.out.println("-----------");
		// 로또번호자동생성기
		// 1 ~ 45랜덤한 숫자 6개, 오름차순 정렬해서

		Random r = new Random();
		// int[] lotto = new int[6];
		HashSet<Integer> lotto = new HashSet<>();
		while (true) {
			lotto.add(r.nextInt(45) + 1);
			if (lotto.size() == 6) {
				break;
			}
		}
		ArrayList<Integer> lotto2 = new ArrayList<>(lotto);
		lotto2.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});
		for (Integer l : lotto2) {
			System.out.println(l);
		}

	}
}

















