-- 학원 주위 밥집 관리 프로그램

-- 한솥도시락종로관철동점, 2000/01/01에 생긴, 종로 12길10
-- 메뉴 : 빅치킨마요, 가격 : 4300원

-- 샤오바오우육면, 2002/02/02에 생긴, 삼일대로 17길 15
-- 메뉴 : 우육면, 가격 : 9500원
create table may09_rs(
	r_name varchar2(20 char) primary key,
	r_open date not null, 
	r_addr varchar2(20 char) not null
);

create table may09_menu(
	m_no number(3) primary key,
	m_name varchar2(10 char) not null,
	m_price number(5) not null,
	m_r_name varchar2(20 char)not null,	
	constraint may09_rs_menu
		foreign key(m_r_name)
		references may09_rs(r_name)
		on delete cascade
);
create sequence may09_menu_seq;

insert into may09_rs values('한솥도시락종로관철동점',to_date('20000101','YYYYMMDD'),'종로 12길10');
insert into may09_rs values('샤오바오우육면',to_date('20020202','YYYYMMDD'),'삼일대로17길 15');
insert into may09_rs values('광화문미진',to_date('19990509','YYYYMMDD'),'청진동 146');
----------------------------------------------------------------
insert into may09_menu values(may09_menu_seq.nextval,'빅치킨마요',4300,'한솥도시락종로관철동점');
insert into may09_menu values(may09_menu_seq.nextval,'돈까스덮밥',5500,'한솥도시락종로관철동점');
insert into may09_menu values(may09_menu_seq.nextval,'새우튀김덮밥',5200,'한솥도시락종로관철동점');
insert into may09_menu values(may09_menu_seq.nextval,'동백',7000,'한솥도시락종로관철동점');
insert into may09_menu values(may09_menu_seq.nextval,'매화',8000,'한솥도시락종로관철동점');
insert into may09_menu values(may09_menu_seq.nextval,'고기고기도시락',7500,'한솥도시락종로관철동점');

insert into may09_menu values(may09_menu_seq.nextval,'우육면',9500,'샤오바오우육면');
insert into may09_menu values(may09_menu_seq.nextval,'특우육면',10500,'샤오바오우육면');
insert into may09_menu values(may09_menu_seq.nextval,'샤오롱바오',6000,'샤오바오우육면');
insert into may09_menu values(may09_menu_seq.nextval,'꿔바로우',12000,'샤오바오우육면');

insert into may09_menu values(may09_menu_seq.nextval,'판모밀',12000,'광화문미진');
insert into may09_menu values(may09_menu_seq.nextval,'수육정식',15000,'광화문미진');
insert into may09_menu values(may09_menu_seq.nextval,'모밀정식',17000,'광화문미진');

---------------------------------------------------------------------------



select * from may09_rs
select * from may09_menu

select *
from may09_menu
order by m_r_name, m_name;

-- 여태 했던 작업 DB서버에 실제 반영
commit

-- 여태했던거 취소
rollback

select count(*)
from may09_menu;

--6번부터 10번까지
select *
from(
	select rownum as rn, m_no, m_name, m_price, m_r_name
	from (
		select *
		from may09_menu
		order by m_r_name, m_name
	)
)
where rn >=6 and rn<=10;


select *
from(
	select rownum as rn, r_name, r_open, r_addr
	from (
		select *
		from may09_restaurant
		order by r_name
	)
)
where rn >=3 and rn<=5;





