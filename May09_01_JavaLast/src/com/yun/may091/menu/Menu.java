package com.yun.may091.menu;

public class Menu {
	private int no;
	private String name;
	private int price;
	private String rsName;
	public Menu() {
		// TODO Auto-generated constructor stub
	}
	public Menu(int no, String name, int price, String rsName) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.rsName = rsName;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
	public String getRsName() {
		return rsName;
	}
	public void setRsName(String rsName) {
		this.rsName = rsName;
	}
	
	
}
