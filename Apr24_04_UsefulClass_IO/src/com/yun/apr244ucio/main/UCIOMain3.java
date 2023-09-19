package com.yun.apr244ucio.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.yun.apr244ucio.student.Student;

//	1) 그 csv읽어서 콘솔출력
//	2) 분리시키고
//		spilt
//		StringTokenizer
//	3) 학생객체로
//	4)
//		이름 : 홍길동
//		생일 : 1999-03-01(수)
//		국어 : 100
//		수학 : 70
//		영어 : 80
//		평균 : 90.0
//		-----------------

//-----------------------------전처리
//	5) 1등학생 정보출력
//		학생들이 있어야하고
public class UCIOMain3 {
	public static void main(String[] args) {
		
		BufferedReader br = null;
		try {
			FileInputStream fis = new FileInputStream("C:\\yun/file/student.csv");
			InputStreamReader isr = new InputStreamReader(fis,"utf-8");
			br = new BufferedReader(isr);
			
			String line = null;
			Student s = null;
			// Student[] students = new Student[갯수];
			// 배열 : 만들때 사이즈 고정
			//		바꾸지도 못하는데 
			//		사이즈를 모르면?
			//		=> 배열을 당장 못써먹음
			// Student[] students = new Student[?????];
			while ((line = br.readLine()) != null) {
				// System.out.println(line.replace(",", "\n")); // 이렇게 해도 됨
				// System.out.println(line); // 라인별로 출력하는거
				s = new Student(line);
				s.printInfo();
//				for (String string : line2) {
//					System.out.println(string);
//				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
