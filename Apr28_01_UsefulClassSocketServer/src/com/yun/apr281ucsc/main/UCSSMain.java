package com.yun.apr281ucsc.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextArea;

// 폰끼리 전화하려면
//		전화번호가 필요
//		통신서비스만 가능

// 컴끼리 통신하려면
//		IP주소가 필요(전화번호같은거)
//		port번호가 필요(???)

//		시작 - cmd - ipconfig
//		이더넷 어댑터쪽의 IPv4 주소 확인 : 195.168.9.41
//		192.168.0.29

public class UCSSMain {
	public static void main(String[] args) {
		ServerSocket ss = null;
		Scanner k = new Scanner(System.in);
		try {
			ss = new ServerSocket(1667); // 1667번 포트로 소켓서비스 시작
			System.out.println("서버 시작");
			System.out.println("접속 기다리는 중");

			Socket s = ss.accept(); // 기다리고 있다가 누가 접속하면 연결
			System.out.println("서 : 누가 접속함");
			
			InputStream is = s.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			
			OutputStream os = s.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os, "utf-8");
			BufferedWriter bw = new BufferedWriter(osw);
			
			new Thread() {
				public void run() {
					JFrame jf = new JFrame();
					JTextArea jta = new JTextArea();
					jf.add(jta);
					jf.setSize(300,500);
					jf.setVisible(true);
					while (true) {
						try {
							jta.append(br.readLine()+"\r\n");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				};
			}.start();
			while (true) {
				System.out.println(br.readLine());
				
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
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}