package com.yun.apr243ucd.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UCDMain2 {
	public static void main(String[] args) {
		// 본인이 무슨요일에 태어났나
		try {
		String s = "1997-09-16"; // 특정시간날짜
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date bdd = sdf.parse(s);
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("E");
			String yoil= sdf2.format(bdd);
			System.out.println(yoil);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("-----------");
		
		// 몇 살(한국나이 - 연도만)
		String bd2 ="19750301"; // 연도만 추출
		String y = bd2.substring(0,4);
		System.out.println(y);
		int birthYear = Integer.parseInt(y);
		
		Date now = new Date();
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy");
		String cy = sdf3.format(now);
		int curYear = Integer.parseInt(cy);
		
		int age = curYear - birthYear + 1;
		System.out.println(age);
		
	}
}
