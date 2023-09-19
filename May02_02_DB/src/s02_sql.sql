-- DBA과정 -> x
-- DBP과정 -> 기본적인 DB사용법
-- -> DB랑 연동된 프로그램 개발
------------------------------
-- OracleDB환경에서 SQL을 수업
-- 지금 배운 SQL, MySQL, MariaDB, ...에서도 됨
-- 90%이상 같음
------------------------------
-- SQL(Structured Query Language)
--		DB를 제어하는 컴퓨터 언어
--		DB메이커는 다양한데 다들 SQL을 사용함
-- 		조건문/반복문/변수 없고 답이 정해져 있고 
--		CRUD(데이터를 Create Read Update Delete)가 목표
-- 		대소문자 구별 X -> 대문자로 인식
------------------------------
-- 테이블 
-- 열(column),	field
-- 행(row),		record,		data
------------------------------ 
-- 테이블 만들기
create table 테이블명(
	열제목 자료형 [옵션],
	필드영 자료형 [옵션],
	...
);
----------------------------------
-- 옵션
--		not null : 데이터를 안넣지 못하게
--		primary key : not null + 중복데이터 못넣게
----------------------------------
-- 용량 
--		OracleDB에서 	영어1글자 = 1byte
--					한글1글자 = 3bytes
--		5 		: 5bytes
--		5 char 	: 5글자(사실은 15bytes...)
----------------------------------
-- 자료형 
-- 글자
--		char(용량) : 무조건 그 용량만큼 저장
--			char(5 char) -> 'ㅋㅋㅋ'저장하면
--							'ㅋㅋㅋ  '을 저장함
--			빈칸들어가니 용량낭비
--			데이터들 자릿수가 정해져있는 상황에 사용(주민번호,폰번호)
--		varchar2(용량) : 용량조절해서 저장
--			varchar2(5 char) -> 'ㅎㅎㅎ' 저장하면
--								'ㅎㅎㅎ'을 저장함
--			용량조절하느라 느림
--			일반적으로 많이 사용
-- 숫자
--		number(용량)
--			number(5) : 5자리 정수(99999까지 가능)
--			number(5, 3) : 전체5자리, 소수점이하 3자리 실수(99.999)
-- 날짜/시간
--		date
create table may02_snack(
	s_name varchar2(10 char),
	s_price	number(5)
);
-----------------------------------------
-- 데이터 만들기 : C
insert into 테이블명(필드명, 필드명, ...)
values(값,값, ...);

insert into may02_snack(s_name,s_price)
values('초코파이',5000);
-------------------------------------
-- 데이터 읽기 : R
select * from 테이블명;
select * from may02_snack;

create table may02_student(
	s_name varchar2(5 char),
	s_height number(4,1),
	s_weight number(4,1)
);




