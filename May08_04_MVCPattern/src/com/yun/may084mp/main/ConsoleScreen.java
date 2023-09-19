package com.yun.may084mp.main;

import java.util.Scanner;

public class ConsoleScreen {
	// System.in : 콘솔 -> 프로그램 InputStream
	// Scanner : InputStream서포터
	private Scanner inputSystem; 
	
	public ConsoleScreen() {
		inputSystem = new Scanner(System.in);
	}
	
	public int getX() {
		System.out.print("x : ");
		return inputSystem.nextInt();
	}
	public int getY() {
		System.out.print("y : ");
		return inputSystem.nextInt();
	}
	public void print(CalcResult cr) {
		System.out.println(cr.getHab());
		System.out.println(cr.getCha());
		System.out.println(cr.getGob());
		System.out.println(cr.getMoks());
	}
	
	public void destroy() {
		inputSystem.close();
	}
}
