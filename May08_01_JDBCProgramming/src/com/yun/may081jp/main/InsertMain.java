package com.yun.may081jp.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertMain {
	public static void main(String[] args) {
		Connection con = null;
		Scanner k = new Scanner(System.in);
		PreparedStatement pstmt = null; // DB관련 작업을 다 해주는 총괄매너져 객체
		try {
			// 연결(실패할수도)
			String addr = "jdbc:oracle:thin:@195.168.9.85:1521:xe";
			con = DriverManager.getConnection(addr, "yun", "yun");
			
			// 데이터확보
			System.out.println("이름 : ");
			String n = k.next();
			System.out.println("가격 : ");
			int p = k.nextInt();
			
			// SQL(미완성)
			//		값 들어갈 자리에 ?(따옴표 빼고)
			//		SQL자체에 있는 ;빼고
			String sql = "insert into may08_gift values(?,?)";
			
			// SQL완성, 전송, 결과처리를 다 해주는 총괄매니저 객체 => PreparedStatement 
			pstmt = con.prepareStatement(sql);
			
			// SQL완성(? 채우기)
			pstmt.setString(1, n); // pstmt.setXXX(번호, 값);
			pstmt.setInt(2, p);
			
			// 서버로 전송, 실행, 결과받기
			int row = pstmt.executeUpdate();
			
			if (row == 1) {
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
