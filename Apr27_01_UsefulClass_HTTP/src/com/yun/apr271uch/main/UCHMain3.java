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

// http://openapi.seoul.go.kr:8088/575a4655496b636839386f58586542/JSON/CardBusStatisticsServiceNew/1/5/20151101/

// 2015/01/01 ~ 2022/12/31
//		2015,01,01,100번(하계동~용산구청),명륜3가,성대입구,108,103
//		...

// 지하철 : 하루에 600개 한번에 나왔는데
// 버스 : 하루에 40100개 한번에 안나와서, 1000개씩 끊어야한다

public class UCHMain3 {
	public static void main(String[] args) {
		HttpURLConnection huc = null;
		BufferedWriter bw = null;
		try {
			String year = "2015";
			FileOutputStream fos = new FileOutputStream("c:/yun/bus" + year + ".csv", true);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
			bw = new BufferedWriter(osw);

			for (int m = 1; m < 13; m++) {
				for (int d = 1; d < 32; d++) {
					String date = String.format("2015%02d%02d", m, d);
					URL u = new URL(
							"http://openapi.seoul.go.kr:8088/575a4655496b636839386f58586542/JSON/CardBusStatisticsServiceNew/3001/4000/"
									+ date);
					huc = (HttpURLConnection) u.openConnection();
					InputStream is = huc.getInputStream();
					InputStreamReader isr = new InputStreamReader(is, "utf-8");
					// BufferedReader br = new BufferedReader(isr);
					// System.out.println(br.readLine());

					JSONParser jp = new JSONParser();
					JSONObject busData = (JSONObject) jp.parse(isr);
					JSONObject cbssn = (JSONObject) busData.get("CardBusStatisticsServiceNew");
					JSONArray row = (JSONArray) cbssn.get("row");
					JSONObject station = null;
					// ? -> String
					// 1) 공통적인 형변환 스타일
					// String use_dt = (String) station.get("USE_DT");
					// 2) toString() 메소드 활용
					// String use_dt = station.get("USE_DT").toString();
					// 3) + 연산자 활용
					// String use_dt = station.get("USE_DT") +",";
					for (int i = 0; i < row.size(); i++) {
						station = (JSONObject) row.get(i);
						String use_dt = station.get("USE_DT") + ",";
//				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//				Date use_dt2 = sdf.parse(use_dt);
//				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy,MM,dd");
//				String use_dt3 = 
						bw.write(use_dt.substring(0, 4) + "," + use_dt.substring(4, 6) + ","
								+ use_dt.substring(6, 8) + ",");
						bw.write(station.get("BUS_ROUTE_NM") + ",");
						bw.write(station.get("BUS_STA_NM") + ",");

						// 글자로 생각하고 toString 메소드 활용하여 출력
						bw.write(station.get("RIDE_PASGR_NUM").toString().replace(".0","")); // 175

						// 이거는 내방법
//						double ride_parsg_num = (double) station.get("RIDE_PASGR_NUM");
//						System.out.printf("%.0f,\r\n", ride_parsg_num);

						// 글자로 생각하고 toString 메소드 활용하여 출력
						bw.write(station.get("ALIGHT_PASGR_NUM").toString().replace(".0", "") + "\r\n"); // 100
//				double alight_pasgr_num = (double) station.get("ALIGHT_PASGR_NUM");
//				System.out.printf("%.0f,\r\n",alight_pasgr_num);
						bw.write("----------");
						bw.flush();
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
