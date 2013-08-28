create table post(
	seq integer not null,
	zipcode char(7) null,
	sido varchar2(30) null,
	gugun varchar2(30) null,
	dong varchar2(40) null,
	ri varchar2(50) null,
	st_bunji varchar2(1000) null,
	ed_bunji varchar2(30) null
);

drop table post;
select * from post;


select *
from post
where ri like '%양서리%';