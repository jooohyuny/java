package com.yun.apr214os.planet;

import com.yun.apr214os.human.Human;

public class Planet {
	private String name;
	private int size;
	private boolean visible;
	
	
	public Planet() {
		// TODO Auto-generated constructor stub
	}
	public Planet(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public void add(Human h ) {
		System.out.printf("%s이 %s에 등록됨\n",h.getName(),name);
		
	}
	
	
}
