package com.yun.apr216eh.main;

import java.util.Scanner;

import com.yun.apr216eh.calculator.Calculator;

public class EHMain2 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.println("x : ");
		int x = k.nextInt();

		System.out.println("y : ");
		int y = k.nextInt();

		System.out.println("-------");
		
		System.out.println(Calculator.divide(x, y));
	}
}
