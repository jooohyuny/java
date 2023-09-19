-- 데이터 읽기 : R
select 필드명, 필드명 as 별칭, 연산자, 통계함수...
from 테이블명
where 조건식;

--전체 메뉴명, 가격
select m_name, m_price 
from MAY03_MENU;

--전체 식당 이름, 위치
select r_name, r_addr 
from MAY03_restaurant;

--프랜차이즈 전체의 메뉴 평균
select avg(m_price) 
from MAY03_MENU;

--식당 수
select count(r_name) 
from MAY03_restaurant;

--최연장자 사장님 이름
select c_name, c_birth, c_home 
from MAY03_CEO1
where c_birth =(
	select min(c_birth) 
	from MAY03_CEO1
);

-- 테이블 수 가장 적은 매장
select r_addr 
from MAY03_REStaurant 
where r_table = (
	select min(r_table) 
	from MAY03_REStaurant
);

--밥 시리즈 평균가
select avg(m_price) 
from MAY03_MENU 
where m_name like '%밥%';
-------------------------------------------------
--subquery
--      where절에 통계함수 못쓰니
--      테이블여러개 엮을때
--      subquery의 결과는 하나만 나와야함
--종각에서 먹을 수 있는 메뉴명 가격
select m_name, m_price 
from MAY03_MENU 
where m_r_no in (
	select r_no 
	from may03_restaurant 
	where r_addr ='종각'
);
---------------------
-- 밥이 먹고 싶으면 어디로 가야?
-- 안쪽을 먼저쓰는게 더 편하다
select r_addr
from MAY03_RESTAURANT
where r_no in (
	select m_r_no  -- 공통부분
	from may03_menu
	where m_name like '%밥%' 
);
-- 제일 싼 메뉴 파는 매장명, 위치
select r_name,r_addr
from MAY03_RESTAURANT
where r_no in (
	select m_r_no
	from may03_menu
	where m_price = (
		select min(m_price)
		from may03_menu
	)
);
-- 최연장자 사장님이 운영하는 매장명, 지점명, 위치
select r_name, r_jijum,r_addr
from MAY03_RESTAURANT
where r_no in (
	select r_r_no
	from may03_run
	where r_c_no in (
		select c_no
		from may03_ceo1
		where c_birth = (
			select min(c_birth)
			from may03_ceo1
		)
	)
);	
-- 우동시리즈 파는 사장님 이름
select c_name
from MAY03_CEO1
where c_no = (
	select r_c_no
	from may03_run
	where r_r_no in (
		select m_r_no
		from may03_menu
		where m_name like '%우동%'
	)
);

-- 최연장자 사장님네 메뉴 평균가
select avg(m_price)
from MAY03_MENU
where m_r_no in(
	select r_r_no
	from MAY03_RUN
	where r_c_no in(
		select c_no
		from may03_ceo1
		where c_birth = (
			select min(c_birth)
			from may03_ceo1
		)
	)
);

-- join
-- 전체 매장명, 위치, 메뉴명, 가격
select *
from may03_restaurant, may03_menu
where r_no = m_r_no;
-- 전체 사장이름, 식당명, 위치
select c_name,r_name,r_addr
from may03_ceo1, may03_restaurant, may03_run
where c_no = r_c_no and r_r_no = may03_restaurant.r_no;

-- 최연장자 사장님이 운영하는 식당명, 위치
select r_name, r_addr
from MAY03_RESTAURANT,may03_ceo1,may03_run
where c_no = r_c_no and r_r_no = MAY03_RESTAURANT.r_no
	and c_birth = (
		select min(c_birth)
		from may03_ceo1
	);
--subquery : HDD에 130MB -> RAM에 5MB
-- join : HDD에 130MB -> RAM에 1.3GB???
-- join은 자제를...

-- 테이블 수 가장 많은 식당에서 파는 메뉴명, 가격 - subquery
select m_name,m_price
from may03_menu
where m_r_no in ( 
	select r_no
	from may03_restaurant
	where r_table = (
		select max(r_table)
		from MAY03_RESTAURANT
	)
);
	
-- 평균가보다 비싼 메뉴명, 가격, 식당명 - join
select m_name, m_price,r_name
from MAY03_RESTAURANT,may03_menu
where r_no = m_r_no and m_price > (
	select avg(m_price)
	from may03_menu
);




















