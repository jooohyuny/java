package com.yun.may082aop.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import juhyun.yun.db.manager.YunDBManager;

public class SelectMain2 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		Connection con = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		try {
			// 연결 -> 기존에 만들었던 AOP를 연결해서 간편하게
			con = YunDBManager.connect("jdbc:oracle:thin:@195.168.9.85:1521:xe", "yun", "yun");
			
			// 데이터확보 - 전체조회이기때문에 확보 x
			System.out.println("이름 : ");
			String n = k.next();
			
			// sql(미완성)
			String sql = "select avg(g_price)\r\n"
					+ "from may08_gift\r\n"
					+ "where g_name like '%'||?||'%'";
			
			// 총괄객체
			pstmt = con.prepareStatement(sql);
			
			// sql완성
			pstmt.setString(1, n);
			
			// 실행,결과처리
			rs = pstmt.executeQuery();
			rs.next(); 
			System.out.println(rs.getDouble("avg(g_price)"));
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 기존에 만들었던 AOP 클래스를 연결해서 간단하게 정리
		YunDBManager.close(con, pstmt, rs);
		k.close();
	}
}
