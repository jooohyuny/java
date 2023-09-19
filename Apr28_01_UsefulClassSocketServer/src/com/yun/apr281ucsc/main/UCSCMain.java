package com.yun.apr281ucsc.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class UCSCMain {
	public static void main(String[] args) {
		Socket s = null;
		Scanner k = new Scanner(System.in);
		try {
			s = new Socket("192.168.0.29", 1234);
			System.out.println("클 : 접속성공");

			OutputStream os = s.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os, "utf-8");
			BufferedWriter bw = new BufferedWriter(osw);

			InputStream is = s.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			
			while (true) {
				System.out.println("뭐:");
				String msg = k.next();
				bw.write(msg + "\r\n");
				bw.flush();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		k.close();
		try {
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
