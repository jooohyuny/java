package com.yun.apr203oe.main;

import com.yun.apr203oe.menu.Menu;
import com.yun.apr203oe.menu.Sool;
import com.yun.apr203oe.menu.WaterPurifier;

public class OMain2 {
	public static void main(String[] args) {
		Menu m = new Menu("제육덮밥",6000,	false);
		// m.price = 7000;
		m.setPrice(7000); 
		// System.out.println(m.name);
		System.out.println(m.getName()); 
		System.out.println(m.isSoldOut());
		m.print();
		System.out.println("---------");
		// 위니아123, 50만원, 얼음 나오는 정수기
		WaterPurifier wp = new WaterPurifier("위니아123", 500000, true);
		wp.print();
		
		System.out.println("---------");
		// 처음처럼, 4000원, 12도 술
		Sool s = new Sool("처음처럼",4000,false,12);
		s.print();
		System.out.println("---------");
		
		
	}
}
