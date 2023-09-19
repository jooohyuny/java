package com.yun.apr216eh.calculator;
// 	정상 	: 6 - 7 - 12 - 13 - 8
// 	y에 0 	: 6 - 7(AE) - 9 - 10 - 12 - 13 - 11
public class Calculator {
	public static int divide(int a, int b) {
		try {
			int c = a / b;
			return c;
		} catch (Exception e) {
			System.out.println("나누기 0?");
			return -88;
		} finally {
			System.out.println("ㅋ");
		}
		
	}
	// return이 있기 때문에 finally를 써야된다.
	// try 밖에 써도 출력된다고 생각할 수도 있지만
	// try 안에서 에러가 발생할 경우 밖에 적은 코드는 실행이 안된다
	// 그러므로 finally를 사용한다
	// finally는 return보다 먼저 실행된다
}
