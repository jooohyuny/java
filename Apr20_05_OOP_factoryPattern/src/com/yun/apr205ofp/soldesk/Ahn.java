package com.yun.apr205ofp.soldesk;

//	2) 1) Student와 같은 패키지에 해야함
//			같은 패키지에 factory역할을 할 클래스
public class Ahn {

	private int studentCount;
	
	// 3) 같은 객체 만드는 메소드
	public Student talk(String name, int age) {
		studentCount++;
		return new Student(studentCount,name,age);
	}
}
