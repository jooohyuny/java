package com.yun.apr205ofp.soldesk;
//멤버변수
//없다 -> 객체는 필요없음 : static메소드 기반
//있다 -> 객체가 필요하기는 함
//	only one : singleton
//	여러개	:
//			대량으로 필요한데 자동화된 : factory패턴
//			그건 아님 : 평소대로
public class Student {
	private int no;
	private String name;
	private int age;

	//	com.회사명.프로그램명.주제
	//	1) 생성자를 protected/default로
	//		-> 다른 패키지에서 못만들게
	//		-> main에서 못만들게
	//		-> 다른 프로그램에서 못만들게
	//		-> 다른 회사에서 못만들게
	protected Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(int no, String name, int age) {
		super();
		this.no = no;
		this.name = name;
		this.age = age;
	}



	public void printInfo() {
		System.out.print(no);
		System.out.print(name);
		System.out.print(age);
	}
}
