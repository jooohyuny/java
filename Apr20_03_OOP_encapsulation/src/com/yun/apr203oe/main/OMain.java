package com.yun.apr203oe.main;

import java.util.Scanner;

import com.yun.apr203oe.human.Human;

public class OMain {
	public static void main(String[] args) {
		Human h = new Human("홍길동",30);
		h.show();
		System.out.println("---------");
		
		Scanner k  = new Scanner(System.in);
		System.out.print("수정할 나이 : ");
		int a = k.nextInt();
		// h.age = a;
		h.setAge(a);
		System.out.println(h.getAge());
		
		h.show();
	}
}
