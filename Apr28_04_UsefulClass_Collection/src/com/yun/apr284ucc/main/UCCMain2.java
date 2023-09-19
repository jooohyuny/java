package com.yun.apr284ucc.main;

import java.util.ArrayList;
import java.util.Comparator;

import com.yun.apr284ucc.student.Student;

public class UCCMain2 {
	public static void main(String[] args) {
		Student s = new Student("홍길동", 100, 90, 80);
		
		ArrayList<Student> students = new ArrayList<>();
		students.add(s);
		students.add(new Student("김길동", 30, 55, 90));
		students.add(new Student("권길동", 70, 65, 40));
		students.add(new Student("이길동", 94, 88, 100));
		students.add(new Student("박길동", 62, 85, 61));
		students.add(new Student("최길동", 37, 59, 20));
		
		System.out.println(students.get(0).getKor());
		
		// 학생 총 몇명
		System.out.println(students.size());
		
		// 두번째 학생 수학점수 0점으로 수정
		students.get(1).setMat(0);
		
		// 이름 가나다순 정렬
		Comparator<Student> c = new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				String o1Name = o1.getName();
				String o2Name = o2.getName();
				return o1Name.compareTo(o2Name);
			}
		};
		
		// 전체 학생 정보출력
		for (Student student : students) {
			student.printInfo();
		}
		
		// 1등 학생 정보출력 (성적순 정렬, 첫번째 학생 출력)
		students.sort(new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				Integer o1Sum = o1.getKor() + o1.getEng() + o1.getMat();
				Integer o2Sum = o2.getKor() + o2.getEng() + o2.getMat();
				return o2Sum.compareTo(o1Sum);
			}
		});
		
		students.get(0).printInfo();
		
		
		
		
		
		//	int[][] score = {{100,90,80},{10,30,22}};
		//	System.out.println(score[0][1]);
	}
}

















