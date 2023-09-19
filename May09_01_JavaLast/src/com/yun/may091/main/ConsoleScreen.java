package com.yun.may091.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.yun.may091.menu.Menu;
import com.yun.may091.restaurant.Restaurant;
// V  -> 실전에서는 자바를 거의 못하는 사람도 작업할 수 있도록 간단하게 작업하는 것
//		웹디자이너의 html
//		웹디자이너가 String -> Date ??? 
public class ConsoleScreen {
	private Scanner inputSystem; 
	
	public ConsoleScreen() {
		inputSystem = new Scanner(System.in);
	}
	
	public int showMainMenu() {
		System.out.println("1) 식당등록");
		System.out.println("2) 메뉴등록");
		System.out.println("3) 식당조회");
		System.out.println("4) 메뉴조회");
		System.out.println("...");
		System.out.println("10) 종료");
		System.out.println("----------");
		System.out.println("뭐 : ");
		return inputSystem.nextInt();
	}

	public int  showGetPageNoMenu(int pageNo) {
		System.out.print("페이지(1~ " + pageNo + ") : ");
		return inputSystem.nextInt();
	}
	
	public Restaurant showRegRestaurantMenu() {
		System.out.print("이름 : ");
		String n = inputSystem.next();
		
		System.out.print("시작일 : ");
		String s = inputSystem.next();
		
		System.out.print("주소 : ");
		String a = inputSystem.next();
		return new Restaurant(n, null, a, s);
	}
	
	public Menu showRegMenuMenu() {
		System.out.print("메뉴명 : ");
		String n = inputSystem.next();
		
		System.out.print("가격 : ");
		int p = inputSystem.nextInt();
		
		System.out.print("판매식당명 : ");
		String rn = inputSystem.next();
		
		return new Menu(0, n, p, rn);
		//				0, n, p, rn ???? 
	}
	
		
	public void printResult(String result) {
		System.out.println(result);
		System.out.println("---------------");
	}
	

	public void printMenus(ArrayList<Menu> menus) {
		for (Menu menu : menus) {
			System.out.println(menu.getNo());
			System.out.println(menu.getName());
			System.out.println(menu.getPrice());
			System.out.println(menu.getRsName());
			System.out.println("-------------------");
		}
	}
	
	public void printReastaurant(ArrayList<Restaurant> reastaurants) {
		for (Restaurant reastaurant : reastaurants) {
			System.out.println(reastaurant.getName());
			System.out.println(reastaurant.getAddr());
			System.out.println(reastaurant.getOpen());
			System.out.println("-------------------");
		}
	}
	
	public void bye() {
		inputSystem.close();
	}
}
