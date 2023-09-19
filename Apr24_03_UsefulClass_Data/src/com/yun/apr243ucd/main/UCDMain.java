package com.yun.apr243ucd.main;

import java.util.Scanner;
import java.util.StringTokenizer;

// 숫자(x,y,z,...) : 
// -------------------
// 합계

// 1) 숫자만 쓴다치고 합계
// 2) 글자들어온거 처리

public class UCDMain {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		
		System.out.println("숫자(x,y,z,....) : ");
		// ,도 쓸거고 글자도 넣을거고
		// int는 안되지 않겠어요
		// throws를 써야된다.
		String data = k.next();
		
		// 이거는 비정형데이터방식
		StringTokenizer st = new StringTokenizer(data, ",");
		int hab = 0;
		while (st.hasMoreTokens()) {
			try {
				hab += Integer.parseInt(st.nextToken()); // 문자를 숫자형으로 변환시킴 
			} catch (Exception e) {
			}
		} 
		System.out.println(hab);
		
		// 이거는 정형데이터방식
//		String[] data2 = data.split(",");
//		int hab = 0;
//		for(String s : data2) {
//			try {
//				hab += Integer.parseInt(s); // 문자를 숫자형으로 변환시킴 
//			} catch (Exception e) {
//			}
//		} 
//		System.out.println(hab);

		
//		int x = k.nextInt();
//		System.out.println(" 숫자 : ");
//		int y = k.nextInt();
//		System.out.println(" 숫자 : ");
//		int z = k.nextInt();
//		
//		System.out.println(" 문자 : ");
//		String s = k.next();
//		Integer ss = Integer.parseInt(s);
//		int sss = ss.intValue();
//		System.out.println(" 문자 : ");
//		String s2 = k.next();
//		Integer s22 = Integer.parseInt(s2);
//		int s222 = s22.intValue();
//		System.out.println("합계 : ");
//		System.out.println(x+y+z+sss+s22);
		
		System.out.println("--------------");
		
	}
}
