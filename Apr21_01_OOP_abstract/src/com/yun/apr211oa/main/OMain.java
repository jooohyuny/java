package com.yun.apr211oa.main;

import com.yun.apr211oa.avengers.Avengers;
import com.yun.apr211oa.avengers.Hulk;
import com.yun.apr211oa.avengers.Ironman;

//	어벤져스 게임 -> 뽑기 -> 캐릭터가 나오는
public class OMain {
	public static void main(String[] args) {
		//	Java는 객체를 만들면서 클래스 만드는게 가능
		//	클래스명이 없는 Avengers의 하위클래스
		//	anonymous inner class
		Avengers a = new Avengers() {
			@Override
			public void attack() {
			}
		};
		a.attack();
		
		
		Ironman i = new Ironman("토니", 40, "자비스");
		i.printInfo();
		i.attack();
		i.eat();
		i.fly();
		System.out.println("------------");

		Hulk h = new Hulk("베너", 30, 99);
		h.printInfo();
		h.attack();
		System.out.println("------------");
	}
}
