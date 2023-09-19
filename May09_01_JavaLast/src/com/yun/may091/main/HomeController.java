package com.yun.may091.main;

import java.util.ArrayList;

import com.yun.may091.menu.Menu;
import com.yun.may091.menu.MenuDAO;
import com.yun.may091.restaurant.Restaurant;
import com.yun.may091.restaurant.RestaurantDAO;

// 1. 식당등록
// 2. 메뉴등록
// ...
// 10. 종료
//-------------------
// 뭐 : 
public class HomeController {
	public static void main(String[] args) {
		MenuDAO.getMdao().setAllMenuCount(); // 처음 한번만 세기
		
		ConsoleScreen cs = new ConsoleScreen();
		Restaurant r = null;
		Menu m = null;
		String result = null;
		int menu = 0;
		ArrayList<Menu> menus = null;
		ArrayList<Restaurant> reastaurants = null;
		int pageCount = 0;
		int pageNo = 0;
		while (true) {
			menu = cs.showMainMenu();
			if(menu == 10) {
				break;
			} else if (menu == 1) {
				r = cs.showRegRestaurantMenu();
				result = RestaurantDAO.getRdao().reg(r);
				cs.printResult(result);
			} else if (menu ==2) {
				// 식당명 보여주고
				m = cs.showRegMenuMenu();
				result = MenuDAO.getMdao().reg(m);
				cs.printResult(result);
			} else if(menu ==3) {
				pageCount = RestaurantDAO.getRdao().getAllPageCount();
				pageNo = cs.showGetPageNoMenu(pageCount);
				reastaurants = RestaurantDAO.getRdao().get(pageNo);
				cs.printReastaurant(reastaurants);
			} else if (menu == 4) {
				pageCount = MenuDAO.getMdao().getAllPageCount();
				pageNo = cs.showGetPageNoMenu(pageCount);
				
				menus = MenuDAO.getMdao().get(pageNo);
				cs.printMenus(menus);
			}
		}
		cs.bye();
	}
}
