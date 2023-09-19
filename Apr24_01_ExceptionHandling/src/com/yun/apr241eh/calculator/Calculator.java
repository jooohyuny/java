package com.yun.apr241eh.calculator;

// 예외처리
//		y에 0은 들어가면 안됨(수학이론)
//		개발자가 대비는 해 둬야
//		챙겨두자 - .jar

//	main은 개발팀장
// 클래스를 작업하게 될 신입개발자
//		1번 -> 직접 처리 -> 책임지나? X
//		=> 대응은 개발팀장이 하는게 맞지

//		프로젝트가 달라지면 대응방법도 달라져야 할텐데
//		그러므로 실전에서는 2번을 사용한다
public class Calculator {
//	1) 직접 처리 : try - catch - finally
	public static int divide(int x, int y) {
		try {
			return x/y;
		} catch (Exception e) {
			System.out.println("나누기 0이 어딨냐");
			return - 999;
		} finally {
			System.out.println("어쨌든 계산 끝");
		}
	}
	
//	2) 미루기 : throws
//	divide2를 수행하다가 ArithmeticException이 발생하면
//	divide2를 호출한쪽에서 처리해야한다.
	public static int divide2(int x, int y) throws ArithmeticException{
		return x/y;
	}
}
