-- RDBMS(Relational DBMS)계열
-- 		OracleDB, MySQL, MariaDB ...
--
--		테이블간의 관계를 중심으로 풀어나가는
-- NoSQL계열
--		MongoDB, ElasticsearchDB ...
------------------------------------------
-- DB디자인
-- 1) 한 데이터에는 하나의 정보만
-- 2) 주제별로 테이블을 나누기
-- 3) 테이블 옵션(PK, not null)
-- 4) 테이블간의 관계 파악

-- 식당프랜차이즈
-- 홍길동, 1999-01-01생, 수원에 사는데 : 사장님
-- 김밥천국, 종로점, 종각역, 10테이블 : 매장
-- 야채김밥, 5000원 : 메뉴
drop table may03_menu cascade constraint purge;

create sequence may03_restaurant_seq;
create table may03_ceo1(
	c_no number(2) primary key,
	c_name varchar2(10 char) not null,
	c_birth date not null,
	c_home varchar2(10 char) not null
);

create table may03_restaurant(
	r_no number(2) primary key,
	r_name varchar2(10 char) not null,
	r_jijum varchar2(10 char) not null,
	r_addr varchar2(10 char) not null,
	r_table number(3) not null
);

create table may03_run(
	r_no number(2) primary key,
	r_c_no number(2) not null,
	r_r_no number(2) not null
);

create table may03_menu(
	m_no number(2) primary key,
	m_name varchar2(10 char) not null,
	m_price number(6) not null,
	m_r_no  number(2) not null
);

---------------------------------------------
insert into may03_ceo1
values(may03_restaurant_seq.nextval,'홍길동',to_date('19990101','YYYYMMDD'),'수원');

insert into may03_ceo1
values(may03_restaurant_seq.nextval,'김길동',to_date('19980303','YYYYMMDD'),'안양');

insert into may03_ceo1
values(may03_restaurant_seq.nextval,'이길동',to_date('19991205','YYYYMMDD'),'광명');

insert into may03_ceo1
values(may03_restaurant_seq.nextval,'장길동',to_date('20020526','YYYYMMDD'),'강서');

insert into may03_ceo1
values(may03_restaurant_seq.nextval,'최길동',to_date('19900209','YYYYMMDD'),'마포');

insert into may03_ceo1
values(may03_restaurant_seq.nextval,'권길동',to_date('19880408','YYYYMMDD'),'종로');

insert into may03_ceo1
values(may03_restaurant_seq.nextval,'박길동',to_date('19960125','YYYYMMDD'),'시흥');

insert into may03_ceo1
values(may03_restaurant_seq.nextval,'조길동',to_date('20010203','YYYYMMDD'),'강북');

select * from may03_ceo1;

---------------------------------------------
insert into may03_restaurant
values(may03_restaurant_seq.nextval,'김천','종로','종각',10);
insert into may03_restaurant
values(may03_restaurant_seq.nextval,'우동천국','강남','강남',20);
insert into may03_restaurant
values(may03_restaurant_seq.nextval,'튀김천국','강서','강서',30);
insert into may03_restaurant
values(may03_restaurant_seq.nextval,'제육천국','마포','마포',25);
insert into may03_restaurant
values(may03_restaurant_seq.nextval,'치킨천국','안양','안양',60);
insert into may03_restaurant
values(may03_restaurant_seq.nextval,'주원이네','광명','광명',80);
insert into may03_restaurant
values(may03_restaurant_seq.nextval,'피자나라','홍대','홍대',30);

select *from may03_restaurant;

---------------------------------------------
insert into may03_menu
values(may03_restaurant_seq.nextval,'야채김밥',4000,59);
insert into may03_menu
values(may03_restaurant_seq.nextval,'제육김밥',5000,62);
insert into may03_menu
values(may03_restaurant_seq.nextval,'튀김우동',5500,60);
insert into may03_menu
values(may03_restaurant_seq.nextval,'돈까스김밥',6000,59);
insert into may03_menu
values(may03_restaurant_seq.nextval,'고기국수',5500,64);
insert into may03_menu
values(may03_restaurant_seq.nextval,'야채우동',5500,60);
insert into may03_menu
values(may03_restaurant_seq.nextval,'양념치킨',5500,63);
insert into may03_menu
values(may03_restaurant_seq.nextval,'불고기덮밥',5500,62);
insert into may03_menu
values(may03_restaurant_seq.nextval,'제육덮밥',5500,62);
insert into may03_menu
values(may03_restaurant_seq.nextval,'후라이드치킨',5500,61);
insert into may03_menu
values(may03_restaurant_seq.nextval,'떡볶이',5500,65);
insert into may03_menu
values(may03_restaurant_seq.nextval,'포테이토피자',5500,65);

select*from MAY03_MENU;
----------------------------------------------------------------
insert into may03_run values(may03_restaurant_seq.nextval,51,59);
insert into may03_run values(may03_restaurant_seq.nextval,52,60);
insert into may03_run values(may03_restaurant_seq.nextval,53,61);
insert into may03_run values(may03_restaurant_seq.nextval,54,62);
insert into may03_run values(may03_restaurant_seq.nextval,55,63);
insert into may03_run values(may03_restaurant_seq.nextval,56,64);
insert into may03_run values(may03_restaurant_seq.nextval,57,65);
insert into may03_run values(may03_restaurant_seq.nextval,58,59);

select*from MAY03_run;
------------------------------------------------------------------------------
-- 1차 설정 끝 














