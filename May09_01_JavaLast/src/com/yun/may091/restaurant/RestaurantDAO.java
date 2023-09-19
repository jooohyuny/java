package com.yun.may091.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



import juhyun.yun.db.manager.YunDBManager;
// DAO는 
public class RestaurantDAO {
	private int allRestaurantCount;
	private int restaurantPerPage;
	// 2. 내부에서 하나 만들어 놓고
	private static final RestaurantDAO RDAO = new RestaurantDAO(); 
	
	// 1. menu와 똑같이 객체 외부에서 못만들게 private로 잠구고
	private RestaurantDAO() {
		restaurantPerPage = 5;
	}
	
	// 3. 그 하나 만들어 놓은 2번을 외부에서 쓸 수 있게 만들어주고
	public void name() {
		
	}
	
	
	
	
	public int getAllRestaurantCount() {
		return allRestaurantCount;
	}

	public void setAllRestaurantCount(int allRestaurantCount) {
		this.allRestaurantCount = allRestaurantCount;
	}

	public int getRestaurantPerPage() {
		return restaurantPerPage;
	}

	public void setRestaurantPerPage(int restaurantPerPage) {
		this.restaurantPerPage = restaurantPerPage;
	}

	public static RestaurantDAO getRdao() {
		return RDAO;
	}

	//	---------------------------------------------------
	public void setAllRestaurantCount() {
		Connection con = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		try {
			con = YunDBManager.connect("jdbc:oracle:thin:@195.168.9.85:1521:xe", "yun", "yun");
			
			String sql = "select count(*) from may09_restaurant";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			allRestaurantCount = rs.getInt("count(*)");
			System.out.println(allRestaurantCount);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			YunDBManager.close(con, pstmt, rs);
		}
	}
//	---------------------------------------------------
	public int getAllPageCount() {
		int pageCount = (int)Math.ceil(allRestaurantCount/ (double) restaurantPerPage);
		System.out.println(pageCount);
		return pageCount; 
	}
//	---------------------------------------------------
	public String reg(Restaurant r) {
		Connection con = null;
		PreparedStatement pstmt = null; 
		try {
			con = YunDBManager.connect("jdbc:oracle:thin:@195.168.9.85:1521:xe", "yun", "yun");
			
			String sql = "insert into may09_rs  "
					+"values(?,to_date(?,'YYYYMMDD'),?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, r.getName());
			pstmt.setString(2, r.getStart2());
			pstmt.setString(3, r.getAddr()); 
			
			// insert는 1되거나 exception 둘 중에 하나 뿐인데
			// 근데 그걸 자바가 아나
			if (pstmt.executeUpdate() == 1) {
				allRestaurantCount++;
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
//	---------------------------------------------------
 	// java.util.Date : 일반 <-
	// java.sql.Date : DB작업때는
	//		1) MyBatis에서 java.util.Date씀
	//		2) java.util.Date <-> java.sql.Date : 자동변환된다
	
	// Java + DB
	//		JDBC -> ConnectionPool -> MyBatis
	
	// Spring + MyBatis로 웹사이트
//	---------------------------------------------------
	public ArrayList<Restaurant> get(int pageNo) {
		Connection con = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		try {
			con = YunDBManager.connect("jdbc:oracle:thin:@195.168.9.85:1521:xe", "yun", "yun");
			
			int start = (pageNo -1 )* restaurantPerPage +1 ;
			int end = restaurantPerPage * pageNo;
			
			String sql = "select * "
					+ "from( "
					+ "	select rownum as rn, r_name, r_open, r_addr "
					+ "	from ( "
					+ "		select * "
					+ "		from may09_restaurant "
					+ "		order by r_name "
					+ "	) "
					+ ") "
					+ "where rn >=? and rn<=?; "
					+ "";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			ArrayList<Restaurant> reastaurants = new ArrayList<>();
			Restaurant r = null;
			while (rs.next()) {
				r = new Restaurant();
				r.setName(rs.getString("r_name"));
				r.setAddr(rs.getString("r_addr"));
				r.setOpen(rs.getDate("r_open"));
				reastaurants.add(r);
			}
			return reastaurants;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			YunDBManager.close(con, pstmt, null);
		}

	}
}