select * from may02_snack;
----------------------------------
-- 옵션
--		not null : 데이터를 안넣지 못하게
--		primary key : not null + 중복데이터 못넣게
--			어떤 데이터의 대표값
--			나중에 검색할때 정확한 데이터를 찾을 수 있음
--			-> 어떤 테이블에는 PK가 꼭 있도록 만들자
-----------------------------------------
-- 데이터 만들기 : C
insert into 테이블명(필드명, 필드명, ...)
values(값,값, ...);

insert into MAY02_SNACK(s_price, s_name)
values(500,'새콤달콤');

-- 값이 0이면 계산이 되는데
-- 값이 없으면 계산불가능
insert into MAY02_SNACK(s_name)
values('빼빼로');

insert into may02_snack values('새우깡',4000);
----------------------------------------------------
create table may03_coffee(
	c_name	varchar2(10 char) primary key,
	c_price number(5) not null
	
);

insert into may03_coffee(c_name)
values('아메리카노');

insert into may03_coffee values('아메리카노',4000);
-- insert into may03_coffee values('아메리카노',5000);
insert into may03_coffee values('라떼',5000);
insert into may03_coffee values('녹차라떼',5000);

select * from may03_coffee;

--------------------------------------------
-- 테이블 수정 - 실전에는 없는 작업
--		SQL이 알고싶으면 찾아보면 있기는 한데
--------------------------------------------
-- 테이블 삭제
drop table 테이블명 cascade constraint purge;
drop table may03_student cascade constraint purge;
drop table may03_snack cascade constraint purge;
--------------------------------------------
-- 이름/나이/국/영/수 중에 PK로 쓸만한게 없어서
-- 번호 필드를 추가해서 PK로
-- -> 번호는 자동으로 올라갔으면...(Java때 팩토리패턴)
-- MySQL/MariaDB에는 autoincrement옵션이 있는데
--------------------------------------------
-- 시퀀스 만들기
create sequence 시퀀스명;
create sequence may03_student_seq;
-- 시퀀스 사용(insert때)
시퀀스명.nextval
--------------------------------------------
create table may03_student(
	s_no number(2) primary key,
	s_name varchar2(10 char) not null,
	s_age number(3) not null,
	s_kor number(3) not null,
	s_eng number(3) not null,
	s_mat number(3) not null
);

insert into may03_student 
values(may03_student_seq.nextval,'홍길동',20,100,90,90);

insert into may03_student 
values(may03_student_seq.nextval,'홍길동',20,10,0,90);

insert into may03_student 
values(may03_student_seq.nextval,'김길동',23,0,100,90);

insert into may03_student 
values(may03_student_seq.nextval,'김길동',231353125,0,100,90);

insert into may03_student 
values(may03_student_seq.nextval,'최길동',23,20,10,70);

insert into may03_student 
values(may03_student_seq.nextval,'권길동',26,70,60,50);

insert into may03_student 
values(may03_student_seq.nextval,'이길동',27,30,90,20);

insert into may03_student 
values(may03_student_seq.nextval,'박길동',29,90,40,70);

insert into may03_student 
values(may03_student_seq.nextval,'조길동',24,85,100,80);

select * from may03_student;
----------------------------------------------------
create table may03_snack(
	s_no number(2) primary key,
	s_name varchar2(10 char) not null,
	s_price number(4) not null,
	s_weight number(4,1) not null,
	s_exp date not null
);
--create sequence may03_snack_seq;
-- 날짜/시간
--	sysdate : 현재시간날짜

--		1) Java/Python에서 Date객체
--		2) to_date('날짜','패턴') : 글자 -> 날짜
-- YYYY : 년
-- MM : 월
-- DD : 일
-- AM/PM
-- HH : 12시간제
-- HH24 : 24시간제
-- MI : 분
-- SS : 초

insert into may03_snack
values(may03_snack_seq.nextval,'초코파이',6000,500.1,sysdate);
insert into may03_snack
values(may03_snack_seq.nextval,'초코파이',5500,550.1,to_date('20230601','YYYYMMDD'));
insert into may03_snack
values(may03_snack_seq.nextval,'초코칩',2900,400.4,to_date('20230711','YYYYMMDD'));
insert into may03_snack
values(may03_snack_seq.nextval,'새콤달콤',500,50.7,to_date('20240216','YYYYMMDD'));
insert into may03_snack
values(may03_snack_seq.nextval,'포카칩',2000,100.3,to_date('20231021','YYYYMMDD'));
insert into may03_snack
values(may03_snack_seq.nextval,'오징어땅콩',3000,150.8,to_date('20230912','YYYYMMDD'));
insert into may03_snack
values(may03_snack_seq.nextval,'포스틱',6300,420.8,to_date('20230520012030','YYYYMMDDHHMISSPM'));
select *from may03_snack;
drop sequence 시퀀스명
-- SQL로 CRUD
테이블만들기
테이블삭제
시퀀스만들기
시퀀스 삭제
C













