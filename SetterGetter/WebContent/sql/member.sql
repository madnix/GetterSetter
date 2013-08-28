drop table member;
create table member(
	id varchar2(50) primary key,				-- 아이디				
	section number not null,				-- 구매자 0, 판매자 1
	pwd varchar2(50) not null,				-- 비밀번호
	pwd_q number not null,					-- 비밀번호 확인 질문
	pwd_a varchar2(100) not null,			-- 비밀번호 확인 답변
	name varchar2(10) not null,				-- 이름
	zip1 varchar2(3) not null,				-- 우편번호1
	zip2 varchar2(3) not null,				-- 우편번호2
	addr1 varchar2(100) not null,				-- 주소1
	addr2 varchar2(100) not null,				-- 상세주소
	tel1 number,							-- 전화번호1
	tel2 number,							-- 전화번호2
	tel3 number,							-- 전화번호3
	phone1 number not null,					-- 휴대폰1
	phone2 number not null,					-- 휴대폰2
	phone3 number not null,					-- 휴대폰3
	email1 varchar2(50) not null,			-- 이메일1
	email2 varchar2(50) not null,			-- 이메일2
	birth1 number,							-- 생일1 - 년
	birth2 number,							-- 생일2 - 월
	birth3 number,							-- 생일3 - 일
	wedding1 number,						-- 결혼기념일 - 년
	wedding2 number,						-- 결혼기념일 - 월
	wedding3 number,						-- 결혼기념일 - 일
	wifebirth1 number,						-- 배우자생일 - 년
	wifebirth2 number,						-- 배우자생일 - 월
	wifebirth3 number,						-- 배우자생일 - 일
	location number,						-- 지역
	
	cor varchar2(50),				-- 회사명
	cor_name varchar2(30),			-- 회사대표자이름
	cor_number varchar2(50),		-- 회사 사업자번호
	cor_zip1 varchar2(3),			-- 회사주소 우편번호1
	cor_zip2 varchar2(3),			-- 회사주소 우편번호2
	cor_addr1 varchar2(100),			-- 회사주소 주소1
	cor_addr2 varchar2(1000),			-- 회사주소 상세주소
	cor_tel1 number,				-- 회사 전화번호1
	cor_tel2 number,				-- 회사 전화번호2
	cor_tel3 number,				-- 회사 전화번호3
	cor_fax1 number,				-- 회사 팩스1
	cor_fax2 number,				-- 회사 팩스2
	cor_fax3 number,				-- 회사 팩스3
	cor_mail1 varchar2(50),			-- 회사 메일
	cor_mail2 varchar2(50)			-- 회사 메일
);

drop table member;
select * from member;
update MEMBER set name='김정엽' where id='madnix'
insert into member(id, section, pwd, pwd_q, pwd_a, name, zip1, zip2, addr1, addr2, phone1, phone2, phone3, email1, email2)
values('madnix', 1, '12345', 2, 'a', 'a', '123', '123', '매가더짱구', '매가더짱구', '010', '1234', '1234', 'alex_madnix', 'naver.com');
