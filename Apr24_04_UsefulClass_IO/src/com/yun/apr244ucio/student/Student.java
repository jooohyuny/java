package com.yun.apr244ucio.student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Student {
	private String name;
	private Date birth;
	private int kor;
	private int eng;
	private int math;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	// 생일 : 1999-03-01(수)
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd(E)");
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(String line) throws ParseException {
		String[] line2 = line.split(",");
		name = line2[0];
		birth = sdf.parse(line2[1]);
		kor = Integer.parseInt(line2[2]);
		eng = Integer.parseInt(line2[3]);
		math = Integer.parseInt(line2[4]);
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}
	
	public void printInfo() {
		System.out.printf("이름 : %s\n",name);
		System.out.printf("생일 : %s\n",sdf2.format(birth));
		System.out.printf("국어 : %d\n",kor);
		System.out.printf("영어 : %d\n",eng);
		System.out.printf("수학 : %d\n",math);
		double avg = (kor + eng + math)/3.0;
		System.out.printf("평균 : %.1f\n",avg);
		System.out.println("--------------------");
		
		System.out.println();
	
	}
	
}
