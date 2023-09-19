package com.yun.apr205ofp.main;

import com.yun.apr205ofp.soldesk.Ahn;
import com.yun.apr205ofp.soldesk.Student;

public class OMain {
	public static void main(String[] args) {
				
		Ahn a = new Ahn();
		Student s1 = a.talk("홍", 20);
		s1.printInfo();
		System.out.println("-------");
		Student s2 = a.talk("김", 30);
		s2.printInfo();
		
	}
}
