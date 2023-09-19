package com.yun.may083mp.main;

// pattern programming
//		singleton
//		factory
//		MVC

//	파일 하나를 한명이 끝까지 작업해야 일이 편함
//	프로젝트에는 다양한 직업군이 참여하고
//	MVC패턴
//		파일을 나누자
//		어떤 파일이 하나 있으면 M/V/C 중에 하나의 역할만
//			Model : 비즈니스로직(실제 계산하고...) 핵심적인 역할
//			View : 사용자한테 보여짐, 입력받고 출력하기
//			Controller : 흐름제어

//	Controller 
//		싱황판단해서 M이 필요하면 M, V가 필요하면 V를 호출하는 역할
//		프로그램 전체의 시작점
//		PL급 back-end개발자
public class C {
	public static void main(String[] args) {
		int n = V.getNo();
		String s = M.judge(n);
		V.print(s);
	}
}
