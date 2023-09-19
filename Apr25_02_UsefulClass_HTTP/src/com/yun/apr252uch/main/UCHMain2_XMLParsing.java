package com.yun.apr252uch.main;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

// 데이터를 주고 받을 때 약속된 형식이 필요할 것 
// XML : 데이터를 HTML형식을 빌려서 표현해놓은 것
// JSON : 데이터를 JavaScript형식을 빌려서 표현해놓은 것

// parsing : 쓸데없는 부분 걷어내고 원하는 형태로 가공

// DOM(Document Object Model)객체
//		<태그명 속성명 = "값" 속성명 = "값"> 	: 시작태그
//		텍스트							: 텍스트
//		</태그명>							: 종료태그
public class UCHMain2_XMLParsing {
	
	
	public static void main(String[] args) {
		HttpsURLConnection huc = null;
		try {
			String s = "https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4215061500";
			URL u = new URL(s);
			// HttpURLConnection = (HttpURLConnection)u.openConnection();
			huc = (HttpsURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
//			InputStreamReader isr = new InputStreamReader(is,"utf-8");
//			BufferedReader br = new BufferedReader(isr);
//			
//			String line = null;
//			while ((line = br.readLine()) != null) {
//				System.out.println(line);
//			}
			
			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();
			// xpp.setInput(isr);
			xpp.setInput(is,"utf-8"); 
			// 위에 부분을 지워야 작동한다. 위에서 데이터를 다 꺼내서 출력하면
			// 작동이 안되기 때문에 둘중 하나만 선택
			//------------------------------------------------------------------
			
			// 1) body영역에서 출력을 원하는 시작태그 종료태그 사이에 있는 텍스트를 추출해낸다.
			// 2) body 내부의 데이터에 태그는 같고 시간에 따라 다르기 때문에 반복 실행을 한다.
			// 3) 이후 출력된 텍스트의 값을 printf를 통해 정리한다.
			int what = xpp.getEventType(); // 지금 빨아낸게 셋 중에 무엇인지
			String ar[] = new String[3];
			while (what != XmlPullParser.END_DOCUMENT) {
				if (what == XmlPullParser.START_TAG) {
					if (xpp.getName().equals("hour")) {
						xpp.next();
						 ar[0] = xpp.getText();
					} else if (xpp.getName().equals("temp")) {
						xpp.next();
						ar[1] = xpp.getText();
					}
					//System.out.println(xpp.getName());
				} else if(what == XmlPullParser.TEXT) {
					 //System.out.println(xpp.getText());
				} else if (what == XmlPullParser.END_TAG) {
					 //System.out.println(xpp.getName());
				} System.out.println(ar[0]);
					
				// 지금 빨아낸거 처리
				xpp.next();
				what = xpp.getEventType();
			} // 끝까지 반복하면서 확인하기
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		huc.disconnect(); // 마무으리
	}
}

// XML파싱 : Java에 기본적으로 없음
// 전세계의 수많은 개발자가 XML파싱기능 만들어놨을것
// 그 중에 하나를 소개 - 여러가지가 많은
// kxml : 안드로이드에 내장
// mvnrepository.com 에서 찾기










