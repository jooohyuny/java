package com.yun.apr205ofp.main;

import java.util.Random;

import com.yun.apr205ofp.monster.Monster;
import com.yun.apr205ofp.monster.Summoner;

//	게임
//		오크
//			x,y
//			공격하기 - x,y에서 주먹질
//		트롤
//			x,y
//			공격하기 - x,y에서 칼질 
//		해골
//			x,y
//			공격하기 - x,y에서 화살
//	랜덤 위치에서 랜덤한 놈이 공격하게 설정하기 
public class OMain2 {
	public static void main(String[] args) throws InterruptedException {
		Summoner s = new Summoner();
		Monster m;
		for (int i = 0; i < 10; i++) {
			m = s.summon();
			m.attack();
			Thread.sleep(1000);
		}

	}
}
