package com.yun.may081jp.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import juhyun.yun.db.manager.YunDBManager;

// 이름 :
// 삭제성공
public class DeleteMain {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		Connection con = null;
		PreparedStatement pstmt = null; 
		try {
			con = YunDBManager.connect("jdbc:oracle:thin:@195.168.9.85:1521:xe", "yun", "yun");
			
			System.out.println("이름 : ");
			String n = k.next();
			
			// Java에서 %가 사용되는건
			// %s, %d, %f
			// 그래서 %를 '%'로 묶고 ||을 사용한다.
			
			// sql(미완성)
			String del = "delete from may08_gift\r\n" 
					+ "where g_name like '%'||?||'%'";
			// 총괄객체
			pstmt = con.prepareStatement(del);

			// sql완성
			pstmt.setString(1, n);
			
			
			// 실행, 결과처리
			if (pstmt.executeUpdate() == 1) {
				System.out.println("성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		YunDBManager.close(con, pstmt, null);
		k.close();
	}
}
