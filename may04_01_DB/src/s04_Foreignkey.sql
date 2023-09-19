-- 회원
--		id
--		pw
--		이름
-----------------
-- sns
--		번호
--		글쓴이id
--		내용

-- 1. 없는 id로 글 안써졌으면...
-- 2. 탈퇴하면 그 사람이 한 거 다 지우자
--		그거 좀 자동으로 됐으면...
-- -> foreign key(외래키)
create table may04_member(
	m_id	varchar2(15 char) primary key,
	m_pw 	varchar2(15 char) not null,
	m_name	varchar2(10 char) not null
);

-- constraint 제약조건명
--		foreign key(필드명)
--		references 테이블명(필드명)
--		on delete cascade
drop table may04_sns cascade constraint purge;

create table may04_sns(
	s_no		number(4) primary key,
	s_writer 	varchar2(15 char) not null,
	s_txt		varchar2(50 char) not null,
	constraint sns_writer
		foreign key(s_writer)
		references may04_member(m_id)
		on delete cascade		
);
create sequence may04_sns_seq;
----------------------------------------------------
-- 회원가입
insert into may04_member
values('hong','1234','홍길동');
-- 그 사람이 글 하나 작성
insert into may04_sns
values(may04_sns_seq.nextval,'hong','ㅋㅋㅋㅋㅋㅋㅋㅋㅋ');

insert into may04_sns
values(may04_sns_seq.nextval,'kim','ㅋㅋㅋㅋㅋㅋㅋㅋㅋ');

-- hong탈퇴
delete from may04_member where m_id = 'hong';

select * from may04_member;
select * from may04_sns;

-----------------------------------------














