package com.yun.apr271uch.bus;


import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class BusData {
	public static void main(String[] args) {
		HttpURLConnection huc = null;
		BufferedWriter bw = null;
		try {
			String year = "2015";
			FileOutputStream fos = new FileOutputStream("c:/yun/busdata" + year + ".csv", true);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
			bw = new BufferedWriter(osw);

			for (int m = 1; m < 13; m++) {
				for (int d = 1; d < 32; d++) {
					for (int start = 1; start < 40002; start += 1000) {
						String ss = String.format("%d/%d/%s%02d%02d", start, start + 999, year, m, d);
						String s =	"http://openapi.seoul.go.kr:8088/575a4655496b636839386f58586542/JSON/CardBusStatisticsServiceNew/"
										+ ss;
						huc = (HttpURLConnection) new URL(s).openConnection();
						InputStream is = huc.getInputStream();
						InputStreamReader isr = new InputStreamReader(is, "utf-8");

						JSONParser jp = new JSONParser();
						JSONObject busData = (JSONObject) jp.parse(isr);
						JSONObject cbssn = (JSONObject) busData.get("CardBusStatisticsServiceNew");
						if (cbssn != null) {
							JSONArray row = (JSONArray) cbssn.get("row");
							JSONObject station = null;
							for (int i = 0; i < row.size(); i++) {
								station = (JSONObject) row.get(i);
								String use_dt = station.get("USE_DT") + ",";
								bw.write(use_dt.substring(0, 4) + "," + use_dt.substring(4, 6) + "," + use_dt.substring(6, 8) + ",");
								bw.write(station.get("BUS_ROUTE_NM") + ","+ station.get("BUS_STA_NM") + ",");
								bw.write(station.get("RIDE_PASGR_NUM").toString().replace(".0", "")); // 175
								bw.write(station.get("ALIGHT_PASGR_NUM").toString().replace(".0", "") + "\r\n"); // 100
								bw.write("----------");
								bw.flush();
							}
						}
						System.out.println(ss);
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
