package com.yun.apr2002oam.item;
//	패키지를 항상 따로 만들고 디폴트패키지를 사용하지말자

//	패키지의 이름은 소속과 같이 정의하고 쓰자

//	패키지먕 생략가능한 경우
//	-Java의 기본패키지 소속(java.lang)
//	-같은패키지 소속
//	-import했다면

//	access modifier(접근제어자, 접근지정자,...)
//	멤버들 외부에서 접근여부
//	접근제어자
//	public				: 다
//	protected			: 같은패키지 or 다른패키지지만 상속관계
//	(default, friendly)	: 같은패키지에서만
//	private				: 내부에서만 사용가능 /외부에서 접근불가
// 	protected가 사실상 default와 같게 작동함
public class Mouse {
	public String name;
	int price;
	String maker;
	int dpi;

	public Mouse() {
		// TODO Auto-generated constructor stub
	}

	public Mouse(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	public void show() {
		System.out.println(name);
		System.out.println(price);
	}
}
