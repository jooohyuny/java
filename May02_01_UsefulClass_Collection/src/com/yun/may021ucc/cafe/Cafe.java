package com.yun.may021ucc.cafe;

public class Cafe {
	private String name;
	private int price;
	
	public Cafe() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public Cafe(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}




	public void printInfo() {
		System.out.println(name);
		System.out.println(price);
	}
}
