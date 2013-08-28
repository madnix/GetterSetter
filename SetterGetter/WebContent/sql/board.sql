drop sequence seq_board;		
drop table board_list;

create table board_list(
	no number(38) primary key			-- 寃뚯떆���쒕쾲
	, id varchar2(50) not null			-- 濡쒓렇�명썑 �몄뀡�쇰줈 媛�졇�ㅻ뒗 �뚯썝 �꾩씠��
	, section number not null			-- 濡쒓렇�명썑 �몄뀡�쇰줈 �쇰컲,�먮ℓ��愿�━��愿�━ 踰덊샇
	, title varchar2(80) not null		-- �쒕ぉ
	, name varchar2(20) not null		-- �묒꽦�먯씠由��뚯썝�대쫫)
	, email1 varchar2(20) not null		-- 硫붿씪二쇱냼
	, email2 varchar2(20) not null		-- 硫붿씪二쇱냼 2
	, cont varchar2(4000) not null		-- 寃뚯떆���댁슜
	, pwd varchar2(20) not null			-- 寃뚯떆��鍮꾨�踰덊샇
	, secret number not null			-- 怨듦컻, 鍮꾧났媛쒓� �ㅼ젙 
	, comment_total number not null		-- �볤� �섎웾
	, reply_select_no number not null	-- �좏깮���듦� 踰덊샇
	, reply_level number not null		-- �듦� �덈꺼
	, reply_seq number not null			-- �듦� 踰덊샇
	, hit number not null				-- 議고쉶��
	, regdate date						-- 湲�����쒓컙
	
);

create sequence seq_board;


insert into board_list values(seq_board.nextval, 'aiden87', 1,  '�쒕ぉ', '�댄샇誘�, 'aiden87', 'naver.com', '�댁슜', '123456', 0, 0, seq_board.nextval, 0, 0, 0, sysdate);
insert into board_list values(seq_board.nextval, 'aiden87', 1,  '�쒕ぉ', '�댄샇誘�, 'aiden87', 'naver.com', '�댁슜', '123456', 1, 0, seq_board.nextval, 0, 0, 0, sysdate);
insert into board_list values(seq_board.nextval, 'aaa', 1, '�쒕ぉ2', '�대쫫2', '硫붿씪1_2', '硫붿씪2_2', '�댁슜2', '123456', 0, 0, seq_board.nextval, 0, 0, 0, sysdate);
insert into board_list values(seq_board.nextval, 'bbb', 0, '�쒕ぉ3', '�대쫫3', '硫붿씪1_3', '硫붿씪2_3', '�댁슜3', '123456', 0, 0, seq_board.nextval, 0, 0, 0, sysdate);
insert into board_list values(seq_board.nextval, 'ccc', 0, '�쒕ぉ4', '�대쫫4', '硫붿씪1_4', '硫붿씪2_4', '�댁슜4', '123456', 1, 0, seq_board.nextval, 0, 0, 0, sysdate);
insert into board_list values(seq_board.nextval, 'ddd', 0, '�쒕ぉ5', '�대쫫5', '硫붿씪1_5', '硫붿씪2_5', '�댁슜5', '123456', 0, 0, seq_board.nextval, 0, 0, 0, sysdate);
insert into board_list values(seq_board.nextval, 'eee', 0, '�쒕ぉ6', '�대쫫6', '硫붿씪1_6', '硫붿씪2_6', '�댁슜6', '123456', 0, 0, seq_board.nextval, 0, 0, 0, sysdate);
insert into board_list values(seq_board.nextval, 'fff', 0, '�쒕ぉ7', '�대쫫7', '硫붿씪1_7', '硫붿씪2_7', '�댁슜7', '123456',0, 0, seq_board.nextval, 0, 0, 0, sysdate);
insert into board_list values(seq_board.nextval, 'ggg', 0, '�쒕ぉ8', '�대쫫8', '硫붿씪1_8', '硫붿씪2_8', '�댁슜8', '123456', '1', 0, seq_board.nextval, 0, 0, 0, sysdate);

select * from board_list;

delete from board_list where no=41;

select count(*)from board_list;
select count(*) as sum from board_list;

update board_list set title='移대늻�섏젙', name='�대쫫�섏젙', email1='硫붿씪�섏젙', email2='硫붿씪2�섏젙', cont='�댁슜�섏젙', pwd='鍮꾨�踰덊샇�섏젙', secret='1' where no=41;
update board_list set title='移대늻�섏젙', name='�대쫫�섏젙', email1='硫붿씪�섏젙', email2='硫붿씪2�섏젙'where no=41;

update board_list set pwd='123456' where no=41;

select * from board_list order by no desc;


select * from board_list;

update board_list set reply_seq = reply_seq + 1 where reply_select_no = 14 and reply_seq > 2

select no, id, section, title, name, email1, email2, cont, pwd, secret, comment_total, reply_select_no, reply_level, reply_seq, hit, regdate 
	from(
		select no, id, section, title, name, email1, email2, cont, pwd, secret, comment_total, reply_select_no, reply_level, reply_seq, hit, regdate, rownum as rnum 
		from (
			select *
			from board_list	order by reply_select_no desc, reply_seq
			)
		)	
	where rnum between #startRow# and #endRow#	

		
alter table board_list modify (title varchar2(80)); --�뚯씠釉��뺣낫 蹂�꼍 荑쇰━臾�

SELECT * FROM board_list WHERE loc like '�좊줈';

select no, id, section, title, name, email1, email2, cont, pwd, secret, comment_total, reply_select_no, reply_level, reply_seq, hit, regdate 
	from(
		select no, id, section, title, name, email1, email2, cont, pwd, secret, comment_total, reply_select_no, reply_level, reply_seq, hit, regdate, rownum as rnum 
		from (
			select *
			from board_list	
			where title like '%wow%'
			order by reply_select_no desc, reply_seq
			)
		)	
		where rnum between 1 and 10 
		
select no, id, section, title, name, email1, email2, cont, pwd, secret, comment_total, reply_select_no, reply_level, reply_seq, hit, regdate 
	from(
		select no, id, section, title, name, email1, email2, cont, pwd, secret, comment_total, reply_select_no, reply_level, reply_seq, hit, regdate, rownum as rnum 
		from (
			select *
			from board_list	order by reply_select_no desc, reply_seq
			)
		)	
		where title like '%#search#%'
		
select count(*) as sum from board_list where title like '%23%'
		
select * from board_list
		where cont like '%��'