package com.yun.may084mp.main;

import com.yun.may084mp.main.ConsoleScreen;

// 프로젝트의 시작점 역할하는 C를 HomeController/MainController
public class HomeController {
	public static void main(String[] args) {
		ConsoleScreen cs = new ConsoleScreen();
		int x = cs.getX();
		int y = cs.getY();
//		Calculator c = new Calculator();
		CalcResult cr = Calculator.Calculate(x, y);
		cs.print(cr);
		cs.destroy();
	}
}
