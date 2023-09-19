package com.yun.apr214os.human;

import com.yun.apr214os.hero.Hero;

public class Human {
	private String name;
	private Hero hero;
	
	public Human() {
	}
	public Human(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void jjim(Hero h) {
		hero = h;
	}

	public void helpMe() {
		hero.attack();
	}
}
