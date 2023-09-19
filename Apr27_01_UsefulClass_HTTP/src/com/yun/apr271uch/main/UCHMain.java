package com.yun.apr271uch.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// 데이터를 주고받는데
// A(주고) -> B(받는데)
// B의 입장에서 받은거 써먹으려면 파싱
// A랑 B사이의 통일된 형식이 필요할거고
// XML : 데이터를 HTML형식으로 표현
// JSON : 데이터를 Javascript형식으로 표현
//		요즘 JSON이 주력, XML은 구하기도 힘들다

// XML시스템의 원래 주인
//		AJAX : Javascript에서 XML파싱
//		Java에서 XML파싱

// 	https://api.openweathermap.org/data/2.5/weather?appid = 키값&q = 도시명&units=metric&lang=kr
//	baff8f3c6cbc28a4024e336599de28c4  // openweather api키값

//	https://api.openweathermap.org/data/2.5/weather?appid=baff8f3c6cbc28a4024e336599de28c4&q=seoul&units=metric&lang=kr
public class UCHMain {
	public static void main(String[] args) {
		HttpURLConnection huc = null;
		BufferedWriter bw = null;
		try {
			FileOutputStream fos = new FileOutputStream("c:/yun/openweather.csv",true);
			bw = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"));
			
			String s = "https://api.openweathermap.org/data/2.5/weather?appid=baff8f3c6cbc28a4024e336599de28c4&q=seoul&units=metric";
			URL u = new URL(s);
			huc = (HttpURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is,"utf-8");
			// BufferedReader br = new BufferedReader(isr);
			// System.out.println(br.readLine());
			// JSON파싱 : Java에는 없음 -> 전세계의 누군가는 만들어놨고 -> 친숙한거 하나 소개

			JSONParser jp= new JSONParser();
			JSONObject jo = (JSONObject) jp.parse(isr); // 전체 다 불러오기 - object(객체)- 왠만하면 대부분
			// JSONArray ja = (JSONArray) jp.parse(isr); // 배열
			JSONArray ja = (JSONArray) jo.get("weather");
			JSONObject w = (JSONObject) ja.get(0);
			JSONObject m = (JSONObject) jo.get("main");

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy,MM,dd,HH,");
			String when = sdf.format(new Date());
			bw.write(when);
			bw.write(w.get("description")+",");
			bw.write(m.get("temp")+",");
			bw.write(m.get("humidity")+"\r\n");
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		huc.disconnect();
		try {
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
