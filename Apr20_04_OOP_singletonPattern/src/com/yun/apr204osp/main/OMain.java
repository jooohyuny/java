package com.yun.apr204osp.main;

import java.util.Calendar;

import com.yun.apr204osp.yjh.TV903;
import com.yun.apr204osp.yjh.YunJuHyun;

public class OMain {
	public static void main(String[] args) {
		//	본인을 만ㄷ든다니///
		YunJuHyun yjh = YunJuHyun.getYjh();
		yjh.introduce(); // 입력값
		System.out.println(yjh); // 주소값
		System.out.println("--------");
		
		//	강의실에 있는 TV
		TV903 t = TV903.getTv();
		t.showInfo();
		
		Calendar c = Calendar.getInstance();
	}
}
