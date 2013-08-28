drop sequence seq_board_comment;		
drop sequence board15;		
drop table board_comment;


create table board_comment(
	no number(38) primary key			-- 댓글 순번
	, product_id number not null		-- 해당 상품 번호
	, id varchar2(50) not null			-- 로그인후 세션으로 가져오는 회원 아이디
	, section number not null			-- 로그인후 세션으로 일반,판매자,관리자 관리 번호
	, name varchar2(20) not null		-- 작성자이름(회원이름)
	, cont varchar2(4000) not null		-- 게시판 내용
	, secret number not null			-- 공개, 비공개글 설정 
	, comment_select_no number 			-- 선택한 댓글 번호
	, comment_level number 				-- 댓글 레벨
	, comment_no number 				-- 댓글 번호
	, product_appraisal number			-- 고객평가
	, regdate date						-- 글저장 시간
);

create sequence seq_board_comment;

select * from board_comment

insert into board_comment values 
(seq_board_comment.nextval, '17', 'aiden87', '0', '이호민', '이쁘네요 별많이~', '0', seq_board_comment.nextval, 0, 0, 4, sysdate);
insert into board_comment values 
(seq_board_comment.nextval, '17', 'aiden87', '0', '이호민', '조금 이쁩니다~', '0', seq_board_comment.nextval, 0, 0, 3, sysdate);
insert into board_comment values 
(seq_board_comment.nextval, '17', 'aiden87', '0', '이호민', '짱이뻐요', '0', seq_board_comment.nextval, 0, 0, 5, sysdate);
insert into board_comment values 
(seq_board_comment.nextval, '17', 'aiden87', '0', '이호민', '속았다....', '0', seq_board_comment.nextval, 0, 0, 1, sysdate);
insert into board_comment values 
(seq_board_comment.nextval, '17', 'aiden87', '0', '이호민', '뭐이런게 다있어', '1', seq_board_comment.nextval, 0, 0, 1, sysdate);

insert into board_comment (no, product_id, id, section, name, cont, secret, comment_select_no, comment_level, comment_no, product_appraisal, regdate) 
 		 values(seq_board_comment.nextval, #product_id#, #comment_id#, #comment_section#, #comment_name#, #comment_cont#, 
 		 	 #comment_secret#, #comment_select_no#, #comment_level#, seq_board_comment.nextval, #product_appraisal#, sysdate)

select count(*) as sum from board_comment where product_id = 17

select no, product_id, id, section, name, cont, secret, comment_select_no, comment_level, comment_no, product_appraisal, regdate 
		from(
			select no, product_id, id, section, name, cont, secret, comment_select_no, comment_level, comment_no, product_appraisal, regdate, rownum as rnum 
			from (
				select *
				from board_comment
				order by no desc
				)
			)	
 		where rnum between 0 and 10	

select * from board_comment order by where product_id=28
 		
delete from 
	(select * from)
	

board_comment where product_id=28, no=2

delete from BOARD_COMMENT where no=2 and product_id=28

delete * from (delete * from board_comment where product_id=28) where no=#board_no#

DELETE FROM board_comment no
WHERE ROWID > ( SELECT MIN(ROWID) FROM  board_comment S WHERE S.KEY1 = A.KEY1 AND S.KEY2 = A.KEY2 )

