package com.yun.may085ddp.main;

// ArrayList 정렬
// HTTP통신 요청헤더
// 모르는건 이전에 수업한거 찾아서 할 수 있도록

// View가 DTO, Model이 DAO
// 기본 데이터 기록을 해놓는 부분을 
public class Gift {
	private String name;
	private int price;
	
	public Gift() {
		// TODO Auto-generated constructor stub
	}

	public Gift(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
