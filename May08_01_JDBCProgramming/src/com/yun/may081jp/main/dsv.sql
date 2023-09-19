-- 확인용 메모장
create table may08_gift(
	g_name varchar2(10 char) primary key,
	g_price number(5) not null
);

insert into may08_gift values('카네이션',5000);
insert into may08_gift values('손편지',99999);
insert into may08_gift values('식사권',80000);


select * from may08_gift;
select * from may08_gift;