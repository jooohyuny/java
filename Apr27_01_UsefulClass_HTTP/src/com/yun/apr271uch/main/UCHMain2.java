package com.yun.apr271uch.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// 위도 : 37.5511694
// 경도 : 126.9882266

// 49e0d7e69e28489a3f6cbf82a6f9503b
public class UCHMain2 {
	public static void main(String[] args) {
		HttpsURLConnection huc = null;
		Scanner k = new Scanner(System.in);
		BufferedWriter bw = null;
		try {
			FileOutputStream fos = new FileOutputStream("c:/yun/openweather.csv",true);
			bw = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"));
			
			System.out.println("뭐 : ");
			String what = k.next();
			what = URLEncoder.encode(what, "utf-8");

			URL u = new URL(
					"https://dapi.kakao.com/v2/local/search/keyword.json?y=37.5511694&x=126.9882266&radius=3000&query="
							+ what);
			huc = (HttpsURLConnection) u.openConnection();
			huc.addRequestProperty("Authorization", "KakaoAK 49e0d7e69e28489a3f6cbf82a6f9503b");

			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			// BufferedReader br = new BufferedReader(isr);
			// System.out.println(br.readLine());

			JSONParser jp = new JSONParser();
			JSONObject locData = (JSONObject) jp.parse(isr); 
			JSONArray locs = (JSONArray) locData.get("documents");

			System.out.println(locs.size());
			JSONObject l = null;
			for (int i = 0; i < locs.size() +1; i++) {
				l = (JSONObject) locs.get(i);
				System.out.println(l.get("distance")+",");
				System.out.println(l.get("phone")+",");
				System.out.println(l.get("place_name")+",");
				System.out.println(l.get("road_address_name")+ "\r\n");
				System.out.println("--------------");
			}
//			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		k.close();
		huc.disconnect();
	}
}
