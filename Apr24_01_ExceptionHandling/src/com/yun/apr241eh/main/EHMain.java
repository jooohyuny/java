package com.yun.apr241eh.main;

import java.util.Scanner;

import com.yun.apr241eh.calculator.Calculator;

public class EHMain {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.println("소총가격 : ");
		int x = k.nextInt();

		System.out.println("수량 : ");
		int y = k.nextInt();
		
		System.out.println("-------");
		// System.out.println(Calculator.divide(x, y));
		
		try {
			System.out.println(Calculator.divide2(x, y));
		} catch (Exception e) {
			System.out.println("나누기 0 ? 그건안됨");
		}
		
	}
}
