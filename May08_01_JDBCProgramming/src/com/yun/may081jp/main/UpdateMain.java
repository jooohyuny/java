package com.yun.may081jp.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

// 이름 : 상품권
// 가격 : -500
public class UpdateMain {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		Connection con = null;
		PreparedStatement pstmt = null; 
		try {
			String addr = "jdbc:oracle:thin:@195.168.9.85:1521:xe";
			con = DriverManager.getConnection(addr, "yun", "yun");
			
			System.out.println("이름 : ");
			String n = k.next();
			System.out.println("가격 : ");
			int p = k.nextInt();
			
			// sql(미완성)
			String udt = "update may08_gift\r\n" 
					+ "set g_price = g_price + ?\r\n"
					+ "where g_name = ?";
			// 총괄객체
			pstmt = con.prepareStatement(udt);

			// sql완성
			pstmt.setInt(1, p);
			pstmt.setString(2, n);
			
			// 실행, 결과처리
			if (pstmt.executeUpdate() == 1) {
				System.out.println("성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {pstmt.close();} catch (Exception e) {}
		try {con.close();} catch (Exception e) {}
		k.close();
	}
}
