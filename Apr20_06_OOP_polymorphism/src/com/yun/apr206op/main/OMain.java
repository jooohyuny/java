package com.yun.apr206op.main;

import com.yun.apr206op.hero.Hero;
import com.yun.apr206op.hero.Hulk;
import com.yun.apr206op.hero.Human;
import com.yun.apr206op.hero.IronMan;
//	polymorphism(다형성)
//		그 언어가 dynamic loading을 해야 사용가능
//		변수를 만들때는 상위타입
//		실제로 객체 만들어 넣을때 하위타입
//		=> 실제 정체는 하위타입

//		static loading : 변수 자료형따라서 최종 정체가 정해지는
//		dynamic loading : 실제로 만들어넣은 객체 따라서 최종 정체가 정해지는
//		대부분 dynamic loading 쪽이다
public class OMain {
	public static void main(String[] args) {
		Hero h = new IronMan();
		// h.print();
		
		// IronMan i = new IronMan(); // o 
		// IronMan i2 = new Hulk(); // x
		// Hero h = new IronMan(); // o
		// IronMan i3 = new Hero(null, 0); // x
		
		IronMan i = new IronMan("토니",40,"자비스");
		Hulk hk = new Hulk("베너", 30, 77);
		// 위에 애들을 관리 => 배열
		Hero[] aa = {i,hk};
		for (Hero aaa : aa) {
			aaa.print();
			System.out.println("-------");
		} // 위에 aaa왜 썼는지 모르겠음
		Human human = new Human();
		human.helpMe(h);
	}
}
