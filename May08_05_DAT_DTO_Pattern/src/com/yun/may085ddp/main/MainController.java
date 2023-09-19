package com.yun.may085ddp.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import juhyun.yun.db.manager.YunDBManager;

// DAO/DTO패턴

// 수 많은 DB메이커들마다 연결방식이 다 달라서
//  
// 어차피 DB랑 연결/끊고는 매번 하는거고
// 라이브러리로 만들어놨고 : YunDBManager_v_1.0.jar

// PL급
public class MainController {
	public static void main(String[] args) {
		ConsoleScreen cs = new ConsoleScreen();
		Gift g = cs.getInput();
		String result = GiftDAO.reg(g);
		cs.print(result);
		cs.destroy();
	}
}
