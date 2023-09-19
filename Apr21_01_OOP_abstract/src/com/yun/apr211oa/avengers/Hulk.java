package com.yun.apr211oa.avengers;

public class Hulk extends Avengers{
	private int pantsSize;
	public Hulk() {
		// TODO Auto-generated constructor stub
	}
	public Hulk(String name, int age, int pantsSize) {
		super(name, age);
		this.pantsSize = pantsSize;
	}
	public int getPantsSize() {
		return pantsSize;
	}
	public void setPantsSize(int pantsSize) {
		this.pantsSize = pantsSize;
	}
	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		super.printInfo();
		System.out.println(pantsSize);
	}
	@Override
	public void attack() {
		System.out.println("주먹질");
	}
}
