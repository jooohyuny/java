package com.yun.apr205ofp.monster;

public class Skelleton extends Monster {

	public Skelleton() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Skelleton(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		super.attack();
		System.out.println("화살");
	}
}
