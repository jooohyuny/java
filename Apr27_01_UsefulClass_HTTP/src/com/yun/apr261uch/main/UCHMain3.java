package com.yun.apr261uch.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class UCHMain3 {
	public static void main(String[] args) {
		// 연결했으면 끊어야 하는데(사실은 안끊어도 되지만 (세션이라는 개념때문에))
		// 중간에 try부분에서 할 일이 많아서 구조상 안닫힐수있으니 일단 무조건 실행이 될테니 바깥에 둔거임
		HttpURLConnection huc = null; // ? 변수명을 지정하는건 내마음이니까
		BufferedWriter bw = null;
		try {
			FileOutputStream fos = new FileOutputStream("c:/yun/subwayData.csv", true);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
			bw = new BufferedWriter(osw);
			// http://openapi.seoul.go.kr:8088/575a4655496b636839386f58586542/xml/RealtimeCityAir/1/25/
			// 서울시 미세먼지농도
			// http://openapi.seoul.go.kr:8088/575a4655496b636839386f58586542/xml/CardSubwayStatsNew/1/5/20151101

			// 단순 for문
			// 20150101 ~20221231, 없는 날짜는 파싱때 ...
			for (int y = 2015; y < 2023; y++) {
				for (int m = 1; m < 13; m++) {
					for (int d = 1; d < 31; d++) {
						String date = String.format("%d%02d%02d", y,m,d);
						String s = "http://openapi.seoul.go.kr:8088/575a4655496b636839386f58586542/xml/CardSubwayStatsNew/1/610/"
								+ date;
						URL u = new URL(s);
						huc = (HttpURLConnection) u.openConnection();
						InputStream is = huc.getInputStream();
						// inputstream은 1바이트여서 작업하기 불편하니까
						// 왜 isr을 만들고 있나 => 위에 InputStream은 글자단위로 작업하기 불편해서
						InputStreamReader isr = new InputStreamReader(is, "utf-8");
						BufferedReader br = new BufferedReader(isr);

						XmlPullParser xpp = XmlPullParserFactory.newInstance().newPullParser();
						xpp.setInput(is, "utf-8");

						int type = xpp.getEventType();
						String tagName = null;
						String when = null; // 날짜를 나눠서 할 수도 있음
						while (type != XmlPullParser.END_DOCUMENT) {
							if (type == XmlPullParser.START_TAG) {
								tagName = xpp.getName();
							} else if (type == XmlPullParser.TEXT) {
								if (tagName.equals("USE_DT")) {
									when = xpp.getText();
									bw.write(when.substring(0, 4) + ",");
									bw.write(when.substring(4, 6) + ",");
									bw.write(when.substring(6, 8) + ",");
									// bw.write(xpp.getText() + ",");
								} else if (tagName.equals("LINE_NUM")) {
									bw.write(xpp.getText() + ",");
								} else if (tagName.equals("SUB_STA_NM")) {
									bw.write(xpp.getText() + ",");
								} else if (tagName.equals("RIDE_PASGR_NUM")) {
									bw.write(xpp.getText() + ",");
								} else if (tagName.equals("ALIGHT_PASGR_NUM")) {
									bw.write(xpp.getText() + "\r\n");
								}
							} else if (type == XmlPullParser.END_TAG) {
								tagName = "";
							}
							xpp.next();
							type = xpp.getEventType();
						}

					}
				}
			}
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
