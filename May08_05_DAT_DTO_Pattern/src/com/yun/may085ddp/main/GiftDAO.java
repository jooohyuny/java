package com.yun.may085ddp.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import juhyun.yun.db.manager.YunDBManager;

// MVC패턴
// DB에 연관된 작업을 하는 M을 DAO
// Data Access Object

// MVC중에서 M 부분이다. - back-end개발자

// try-catch는 사수가 담당할 C쪽에 있는게 맞는데
//		1) MVC패턴 -> M의 결과가 V까지 가야
//		2) DB안되면 어차피 아무것도 안되는거 -> 대응방법이 어쩌고? 의미가 없다는 것 
public class GiftDAO {
	public static String reg(Gift g) {
		Connection con = null;
		PreparedStatement pstmt = null; 
		try {
			con = YunDBManager.connect("jdbc:oracle:thin:@195.168.9.85:1521:xe", "yun", "yun");
			
			String sql = "insert into may08_gift values(?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, g.getName()); 
			pstmt.setInt(2, g.getPrice());
			// insert는 1되거나 exception 둘 중에 하나 뿐인데
			// 근데 그걸 자바가 아나
			if (pstmt.executeUpdate() == 1) {
				return "성공";
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "실패";
		}finally {
			YunDBManager.close(con, pstmt, null);
		}
	}
}
