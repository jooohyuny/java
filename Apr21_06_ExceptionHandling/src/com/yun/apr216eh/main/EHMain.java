package com.yun.apr216eh.main;

import java.util.Scanner;

// 	error : Java문법에 안맞게 써서
//			기계어로 번역(compile)이 불가능한 상태
//			최종산출물이 못나오겠고
//			개발자 잘못

// 	warning : 지저분한 소스
//			문제없이 최종산출물까지 나오는
//			정리해주는게 좋을 것
//			개발자 잘못

// 	exception : 프로그램에는 문제가 없는데
//				실행중에 외부적인 요인에 의해 제대로 안되는
//				개발자 잘못 - x
//	
public class EHMain {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.println("x : ");
		int x = k.nextInt();

		System.out.println("y : ");
		int y = k.nextInt();
		System.out.println("-------");
		System.out.println(x + y);
		System.out.println(x - y);
		System.out.println(x * y);
// 예외처리
//	1) 직접처리(try - catch - finally)
//		try {
//			// 여기를 일단 실행
//		} catch (예외종류 변수명) {
//			// 그 예외가 발생하면 바로 이쪽으로
//		}
		// 정상 : 40 - 41 - 42
		// y에 0 : 40 - 41(AE 발생) - 44
//		try {
//			System.out.println(x/y);
//			System.out.println("끝");
//		} catch (ArithmeticException e) {
//			System.out.println("나누기 0은 없다");
//		}

		// 정상 : 51 - 52 - 53 - 54
		// y에 0 : 51 - 52(AE) - 56 - 57
		// y에 3 : 51 - 52 - 53 - 54(AIOOBE) - 57 - 58
		// catch를 여러개 쓸 수 있다.
//		try {
//			System.out.println(x / y);
//			int[] ar = { 21, 123, 213 };
//			System.out.println(ar[y]);
//		} catch (ArithmeticException e) {
//			System.out.println("나누기 0은 없다");
//		} catch (ArrayIndexOutOfBoundsException e) {
//			System.out.println("배열에 그거 없음");
//		}
		// Avengers - Ironman
		// Avengers - Hulk
		
		// Exception - Arith
		// Exception - Array
		
		// 다형성을 보여주는 것 Exception을 쓰면서 전체적인 문제를 포함하는 거
		// 개발하면서 상황파악
		try {
			System.out.println(x / y);
			int[] ar = { 21, 123, 213 };
			System.out.println(ar[y]);
		} catch (Exception e) {
			e.printStackTrace(); // 개발하면서 문제상황파악하는 코드
			System.out.println("하여튼 문제 생긴");
		} finally { 
			// finally는 문제발생여부와 상관없이 무조건 출력되는 것
			// return보다 먼저 실행된다
			System.out.println("문제가 생겼든지 말든지 무조건 실행되는 영역");
		}

	}
}
