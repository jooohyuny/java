package com.yun.apr211oa.avengers;

//	abstract(추상)

//	Avengers : 실체가 없는 추상적인 개념일뿐
//	abstract 클래스 : 객체를 못만드는 클래스
//		abstract메소드를 하나라도 갖고 있으면

//	abstract 메소드 : 미구현된 메소드
//		하위클래스에서 !!반드시!! 오버라이딩을 해야된다.
public abstract class Avengers {
	private String name;
	private int age;
	
	public Avengers() {
		// TODO Auto-generated constructor stub
	}

	public Avengers(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	//	왜 void? : 출력하고 끝, 뭐 나오는게 없으니까
	//	왜 () : 필요한 재료가 없으니까
	public void printInfo() {
		System.out.println(name);
		System.out.println(age);
	}
	//	모든 어벤져스들이 공격하기 기능이 있어서 상속하려고 했는데
	// 여기에 막상 뭐라 써야할지...
	public abstract void attack();
}