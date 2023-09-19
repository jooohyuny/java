package com.yun.apr204osp.yjh;
//	객체를 하나만 만들어서 쓰게 해야
//	=> singleton패턴

//	캡슐화
public class YunJuHyun {
	private String name;
	private String address;
	private int age;
	private String school;
	//	2) 내부에서 객체 만들어
	private static final YunJuHyun yjh = new YunJuHyun("윤주현", "마포구", 27, "대학교");
	
	//	1) 생성자시리즈 private -> 외부에서 객체 못만들게
	private YunJuHyun() {
		// TODO Auto-generated constructor stub
	}

	private YunJuHyun(String name, String address, int age, String school) {
		super();
		this.name = name;
		this.address = address;
		this.age = age;
		this.school = school;
	}

	//	3) 2)에서 만든거 외부에서 사용할 수 있게
	public static YunJuHyun getYjh() {
		return yjh;
	}
	
	public void introduce() {
		System.out.println(name);
		System.out.println(address);
		System.out.println(age);
		System.out.println(school);
	}
	
	
	
	
	
}
