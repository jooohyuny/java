-- 1) 관리자 쪽 기능은 안됨
-- 2) SQL은 가능, SQLPlus라는 프로그램의 명령어는 불가능

-- 여러줄 실행 :  블록지정 -> alt + x 로 실행 / 내가 원하는 부분만 실행
create table student2(
	name char,
	age number
);

-- 한 줄 실행 : 커서 대충 갖다 놓고 -> alt + s
 select * from student2;
 
-- desc student2 -> 이거는 SQLPlus의 명령어여서 안됨
 