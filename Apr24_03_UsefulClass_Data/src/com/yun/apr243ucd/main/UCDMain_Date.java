package com.yun.apr243ucd.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Date : Java초창기에 만들어진(2000년대를 생각하지 않던)
//		세월이 가고, 기술도 발전
//		어떤 기능이 더이상 못쓰게 됨
//		-> 없애고 새 기능을 만들든지, 업그레이드 시키든지

// deprecated : 현재 버전에서는 괜찮은데
//				다음 버전에 없어져도 토 달지마라
//				유예기간을 주는거

public class UCDMain_Date {
	public static void main(String[] args) {
		Date now = new Date(); // 현재시간날짜
		System.out.println(now);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String y = sdf.format(now);
		System.out.println(y);

		// String -> Date
		try {
			String s = "2023-03-01"; // 특정시간날짜
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
			Date d = sdf2.parse(s);
			System.out.println(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
//		System.out.println(now.getYear()); // 연도
//		System.out.println(now.getMonth()); // 월
//		System.out.println(now.getDay()); // 일
	}
}
