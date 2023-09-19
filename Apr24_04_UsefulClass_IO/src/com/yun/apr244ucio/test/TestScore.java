package com.yun.apr244ucio.test;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class TestScore {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		 
		System.out.println("이름 : ");
		String name = k.next();
		System.out.println("--------------");
		System.out.println(name);
		
		BufferedWriter bw=null;
		try {
			FileOutputStream fos = new FileOutputStream("C:\\yun/file/test_v1.txt",true);
			OutputStreamWriter osw = new OutputStreamWriter(fos,"utf-8");
			bw = new BufferedWriter(osw);
			bw.write(name + "\r\n");
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
}
