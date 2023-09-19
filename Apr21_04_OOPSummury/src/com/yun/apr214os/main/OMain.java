package com.yun.apr214os.main;

import com.yun.apr214os.hero.Ironman;
import com.yun.apr214os.human.Human;
import com.yun.apr214os.planet.Planet;

public class OMain {
	public static void main(String[] args) {
		Planet p = new Planet("지구");
		p.setSize(100);
		p.setVisible(true);
		
		Human h = new Human("홍길동");
		p.add(h);
		
		// [사수]
		// 영웅들은 공격하기를 반드시 할 줄 알아야
		// 반드시 -> 추상메소드 -> 추상클래스/인중에 골라야
		// 추상클랫는 상속라인을 막으니 -> 영웅 인터페이스 만들자
		Ironman i = new Ironman(); // 영웅인 아이언맨
		i.attack();
		System.out.println("------");
		h.jjim(i); // 저 사람이 자기 전담영웅으로 아이언맨을 찜
		
		h.helpMe();
	}
}
