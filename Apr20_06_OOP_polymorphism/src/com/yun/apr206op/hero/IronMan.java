package com.yun.apr206op.hero;

public class IronMan extends Hero {
	private String aiName;

	public IronMan() {
		// TODO Auto-generated constructor stub
	}

	public IronMan(String name, int age, String aiName) {
		super(name, age);
		this.aiName = aiName;
	}

	public String getAiName() {
		return aiName;
	}

	public void setAiName(String aiName) {
		this.aiName = aiName;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		super.print();
		System.out.println(aiName);
	}
}
