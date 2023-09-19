package com.yun.apr203oe.menu;

public class Sool extends Menu{
	private double alcohol;
	
	public Sool() {
		//	private걸린거는 상속 안된다? - X
		//	접근제어자 판정기준 : Menu
		//  어쨌든 Sool은 Menu의 외부
		//	System.out.println(name);
		System.out.println(getName());
		//	price = 5000;
		setPrice(5000);
	}

	public Sool(String name, int price, boolean soldout, double alcohol) {
		super(name, price, soldout);
		this.alcohol = alcohol;
	}

	public double getAlcohol() {
		return alcohol;
	}

	public void setAlcohol(int alcohol) {
		this.alcohol = alcohol;
	}
	
	@Override
	public void print() {
		// TODO Auto-generated method stub
		super.print();
		System.out.println(alcohol);
	}
}
