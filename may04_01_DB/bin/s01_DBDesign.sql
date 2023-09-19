-- 과자
-- 수원에 있는 오리온, 직원 100명
-- 초코파이 5000원, 500.5g
drop table may04_snack cascade constraint purge;

create table may04_company(
	c_name	varchar2(10 char) primary key,
	c_addr	varchar2(10 char) not null,
	c_emp number(6) not null
);

create sequence may04_snack_seq;
create table may04_snack(
	s_no number(2) primary key,
	s_name	varchar2(10 char) not null,
	s_price number(6) not null,
	s_weight number (5,1) not null,
	s_c_name varchar2(10 char) not null
);
create table may04_ceo(
	c_no number(2) primary key,
	c_name	varchar2(10 char) not null,
	c_birth date not null
);
--------------------------------------------------
insert into may04_company
values('오리온','수원',100);
insert into may04_company
values('크라운','성남',90);
insert into may04_company
values('농심','포천',190);

-------------------------------------
insert into may04_snack
values(may04_snack_seq.nextval,'초코파이',5000,500.5,'오리온');
insert into may04_snack
values(may04_snack_seq.nextval,'새콤달콤딸기',500,50.1,'크라운');
insert into may04_snack
values(may04_snack_seq.nextval,'새콤달콤포도',500,50.2,'크라운');
insert into may04_snack
values(may04_snack_seq.nextval,'새콤달콤레몬',700,45.3,'크라운');
insert into may04_snack
values(may04_snack_seq.nextval,'새콤달콤소다',600,48.6,'크라운');
insert into may04_snack
values(may04_snack_seq.nextval,'초코파이녹차',5700,450.5,'오리온');
insert into may04_snack
values(may04_snack_seq.nextval,'포카칩',2000,120.3,'농심');
insert into may04_snack
values(may04_snack_seq.nextval,'포테토칩',2100,130.5,'농심');

insert into may04_snack
values(may04_snack_seq.nextval,'스윙칩',3600,230.5,'오리온');
insert into may04_snack
values(may04_snack_seq.nextval,'허니버터칩',8000,330.4,'크라운');
insert into may04_snack
values(may04_snack_seq.nextval,'오레오',1900,130.3,'농심');
insert into may04_snack
values(may04_snack_seq.nextval,'하리보',2700,10.9,'오리온');
insert into may04_snack
values(may04_snack_seq.nextval,'포스틱',3900,230.8,'크라운');
insert into may04_snack
values(may04_snack_seq.nextval,'하리보골드',3300,30.5,'농심');
insert into may04_snack
values(may04_snack_seq.nextval,'초코칩',6800,810.9,'오리온');
insert into may04_snack
values(may04_snack_seq.nextval,'초코칩쿠키',5100,710.9,'크라운');
insert into may04_snack
values(may04_snack_seq.nextval,'초코칩쿠키',6100,210.9,'농심');

select * from may04_company;
select * from may04_snack;
