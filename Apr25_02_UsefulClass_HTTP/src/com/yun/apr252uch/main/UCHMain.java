package com.yun.apr252uch.main;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

// HTTP통신
// Java에는 HTTP통신 기능이 없었음

// 1) 이전에 했던 그것이 자바
// 2) 너무 생략이 많이 되어있어서 -> HTTP통신 구조 설명 불가

// HTTP통신
//		HTTP
//		HTTPS

//https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4215061500 // 기상청 RSS서버 주소
public class UCHMain {
	
	
	public static void main(String[] args) {
		HttpsURLConnection huc = null;
		try {
			String s = "https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4215061500";
			URL u = new URL(s);
			// HttpURLConnection = (HttpURLConnection)u.openConnection();
			huc = (HttpsURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is,"utf-8");
			BufferedReader br = new BufferedReader(isr);
			
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		huc.disconnect(); // 마무으리
	}
}











