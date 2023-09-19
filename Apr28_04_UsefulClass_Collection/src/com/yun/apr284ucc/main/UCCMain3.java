package com.yun.apr284ucc.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

import com.yun.apr284ucc.subway.StationInfo;

// 2015/01/01 ~ 2022/12/31까지 서울 지하철 운행정보
// 가장 이용객수(탄 + 내린)가 많았던 건
//		언제 몇호선 무슨역
//		=> 순서개념

// 1) subway.csv에 있는거 콘솔출력 - o
// 2) 뜯기 - 
// 3) 객체만들기 - 
public class UCCMain3 {
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			FileInputStream fis = new FileInputStream("c:/yun/subwayData.csv");
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			br = new BufferedReader(isr);

			String line = null;
			StationInfo ssi = null;
			// 총 데이터수를 몰라서, 배열을 못만들겠
			// StationInfo[] ssis = new StationInfo[????];

			ArrayList<StationInfo> ssis = new ArrayList<>();

			while ((line = br.readLine()) != null) {
				ssi = new StationInfo(line);
				ssis.add(ssi);
			}
			
			ssis.sort(new Comparator<StationInfo>() {
				@Override
				public int compare(StationInfo o1, StationInfo o2) {
					Integer o1Sum = o1.getRide() + o1.getAlight();
					Integer o2Sum = o2.getRide() + o2.getAlight();
					return o2Sum.compareTo(o1Sum);
				}
			});
			ssis.get(0).printInfo();
			// ssis.get(1).printInfo();
			// ssis.get(2).printInfo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
