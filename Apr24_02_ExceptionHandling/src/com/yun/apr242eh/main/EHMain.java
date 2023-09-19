package com.yun.apr242eh.main;

import java.util.Scanner;

import com.yun.apr241eh.calculator.Calculator;

// 위에 동생꺼 끝나고 몇달 뒤
// 회사에서 새 프로젝트 시작

// 그때 챙겨놨던 나누기 기능 쓰면 되니까 불러오기
public class EHMain {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.println("가격 : ");
		int price = k.nextInt();

		System.out.println("수량 : ");
		int quantity = k.nextInt();
		
		System.out.println("-------");
		// 그 때 try - catch - finally로
		// System.out.println(Calculator.divide(price, quantity));
		
		System.out.println("-------");
		// 그 때 throws
		try {
			System.out.println(Calculator.divide2(price, quantity));
		} catch (Exception e) {
			System.out.println("0을 잘못 쓰셨나봅니다.");
		}
	}
}
