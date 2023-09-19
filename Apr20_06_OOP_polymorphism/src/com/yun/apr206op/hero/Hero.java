package com.yun.apr206op.hero;

public class Hero {
	private String name;
	private int age;
	
	protected Hero() {
		// TODO Auto-generated constructor stub
	}

	public Hero(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public void print() {
		System.out.println(name);
		System.out.println(age);
	}
}
