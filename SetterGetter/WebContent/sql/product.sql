--물품등록
drop sequence pro_seq;
drop table productinsert;
create sequence pro_seq nocache; -- 물품번호자동생성


create table productinsert(
	pro_id number primary key,    -- 제품 아이디
	user_id varchar2(100) ,	     -- 판매자 아이디
	pro_title varchar2(500) ,    -- 제품 제목 
	pro_listImg varchar2(1000) ,     -- 제품 리스트 이미지
	pro_detailTopImg varchar2(1000) ,      -- 제품 탑이미지
	pro_detailImg varchar2(1000) ,      -- 제품 상세이미지
	pro_cont varchar2(500) ,      -- 제품 내용
	species_id varchar2(100) ,    -- 종류 아이디
	pro_count number ,            -- 제품 개수
	pro_price number ,             -- 제품 가격
	user_price number ,            -- 소비자 가격
	pro_status varchar2(200) ,    -- 제품 상태
	pro_origin varchar2(200) ,     -- 원산지
	pro_make varchar2(200) ,      -- 제조사
	pro_as varchar2(200),         -- 상품 a/s
	pro_brand varchar2(200),      -- 브랜드
	pro_receipt varchar2(200),    -- 영수증
	admin_reply varchar2(500),    -- 관리자 답변
	pro_banknum varchar2(200),    -- 계좌번호
	pro_bank varchar2(200),       -- 거래은행
	pro_num number ,               -- 제품 판매수
	pro_hit number ,               -- 조회수
	pro_level number ,             -- 제품 레벨 판매자가 제품등록 했을 경우 관리자가 확인시 등록성공
	pro_date varchar2(100)         
);
drop sequence pro_seq;
select * from PRODUCTINSERT order by pro_date desc, pro_hit desc;
drop table productinsert;
select * from productinsert where pro_id=24;

create sequence pro_out_seq nocache;

delete from PRODUCTINSERT where pro_id=25;

delete from PRODUCTINSERT;


update productinsert
set pro_level=2;
update productinsert
set user_id='bbbbbb';

create table productoutput(
	pro_out_id number primary key, 
	pro_id varchar2(100) ,      --물품아이디
	puser_id varchar2(100),     -- 구매자 아이디
	cuser_id varchar2(100),     -- 판매자 아이디
	cont varchar2(500),       -- 추가내용
	pro_count varchar2(100),   -- 구매수량
	bankname varchar2(100),    -- 입금자명
	bank varchar2(100),        -- 거래은행
	user_level varchar2(100),   -- 관리자 거래확인 
	regdate varchar2(100)   
);

select productinsert.pro_id, productoutput.pro_count
from productinsert, productoutput
where productinsert.pro_id = productoutput.pro_id

select * from productinsert;
select * from productoutput;

drop table productinsert;
drop table productoutput;
drop sequence pro_seq;
drop sequence pro_out_seq;














--
insert into productinsert values
(pro_seq.nextval,'yangchae2','목넥 풀 집업 가디건', '/2012-10-9/yangchae2-listimg-2012-10-9-555555.jpg', '/2012-10-9/yangchae2-detailTopImg-2012-10-9-555555.jpg', 
'/2012-10-9/yangchae2-detailImg-2012-10-9-555555.JPG', '남성용 7게이지 아크릴/울 목넥 풀집업 가디건', '의류', 999, 49800,
49800, '좋음', '한국', '지오다노', '1년',
'지오다노', '공인영수증', '', '010-8888-8888', '기업은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'yangchae2','목넥 풀 집업 풀오버', '/2012-10-9/yangchae2-listimg-2012-10-9-555556.jpg', '/2012-10-9/yangchae2-detailTopImg-2012-10-9-555556.jpg', 
'/2012-10-9/yangchae2-detailImg-2012-10-9-555556.JPG', '남성용 7게이지 아크릴/울 목넥 하프집업 풀오버', '의류', 999, 39800,
49800, '좋음', '한국', '지오다노', '1년',
'지오다노', '공인영수증', '', '010-8888-8888', '기업은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'yangchae2','타슬란 후드 자켓(아웃도어)', '/2012-10-9/yangchae2-listimg-2012-10-9-555557.jpg', '/2012-10-9/yangchae2-detailTopImg-2012-10-9-555557.jpg', 
'/2012-10-9/yangchae2-detailImg-2012-10-9-555557.JPG', '업데이트중입니다.', '의류', 999, 158000,
158000, '좋음', '한국', '지오다노', '1년',
'지오다노', '공인영수증', '', '010-8888-8888', '기업은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'yangchae2','목넥 패딩 밀리터리 자켓', '/2012-10-9/yangchae2-listimg-2012-10-9-555558.jpg', '/2012-10-9/yangchae2-detailTopImg-2012-10-9-555558.jpg', 
'/2012-10-9/yangchae2-detailImg-2012-10-9-555558.JPG', '코튼/나일론 목넥 패딩 밀리터리 자켓', '의류', 999, 158000,
158000, '좋음', '한국', '지오다노', '1년',
'지오다노', '공인영수증', '', '010-8888-8888', '기업은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'yangchae2','울터치 후드 베스트(아웃도어)', '/2012-10-9/yangchae2-listimg-2012-10-9-555559.jpg', '/2012-10-9/yangchae2-detailTopImg-2012-10-9-555559.jpg', 
'/2012-10-9/yangchae2-detailImg-2012-10-9-555559.JPG', '폴리/나일론 후드 패딩 베스트', '의류', 999, 108000,
158000, '좋음', '한국', '지오다노', '1년',
'지오다노', '공인영수증', '', '010-8888-8888', '기업은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'yangchae2','울터치 목넥 베스트(아웃도어)', '/2012-10-9/yangchae2-listimg-2012-10-9-555560.jpg', '/2012-10-9/yangchae2-detailTopImg-2012-10-9-555560.jpg', 
'/2012-10-9/yangchae2-detailImg-2012-10-9-555560.JPG', '폴리/나일론 소재의 목넥 패딩 베스트', '의류', 999, 108000,
158000, '좋음', '한국', '지오다노', '1년',
'지오다노', '공인영수증', '', '010-8888-8888', '기업은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'yangchae2','립 목넥 7게이지 풀집 가디건', '/2012-10-9/yangchae2-listimg-2012-10-9-555561.jpg', '/2012-10-9/yangchae2-detailTopImg-2012-10-9-555561.jpg', 
'/2012-10-9/yangchae2-detailImg-2012-10-9-555561.JPG', '폴리/나일론 소재의 목넥 패딩 베스트', '의류', 999, 79800,
158000, '좋음', '한국', '지오다노', '1년',
'지오다노', '공인영수증', '', '010-8888-8888', '기업은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'yangchae2','[주말특가]테리 후드 풀오버', '/2012-10-9/yangchae2-listimg-2012-10-9-555562.jpg', '/2012-10-9/yangchae2-detailTopImg-2012-10-9-555562.jpg', 
'/2012-10-9/yangchae2-detailImg-2012-10-9-555562.JPG', '기본 컬러로 구성된 언브러시드 테리 후드 풀오버', '의류', 999, 39800,
29000, '좋음', '한국', '지오다노', '1년',
'지오다노', '공인영수증', '', '010-8888-8888', '기업은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'yangchae2','브이넥 3게이지 긴팔 버튼 가디건', '/2012-10-9/yangchae2-listimg-2012-10-9-555563.jpg', '/2012-10-9/yangchae2-detailTopImg-2012-10-9-555563.jpg', 
'/2012-10-9/yangchae2-detailImg-2012-10-9-555563.JPG', '아크릴/나일론 3게이지 버튼 가디건', '의류', 999, 69800,
29000, '좋음', '한국', '지오다노', '1년',
'지오다노', '공인영수증', '', '010-8888-8888', '기업은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'yangchae2','[주말특가]타슬란 후드 패딩 자켓', '/2012-10-9/yangchae2-listimg-2012-10-9-555564.jpg', '/2012-10-9/yangchae2-detailTopImg-2012-10-9-555564.jpg', 
'/2012-10-9/yangchae2-detailImg-2012-10-9-555564.JPG', '나일론 타슬란 후드 패딩 프로모션 자켓', '의류', 999, 59800,
53820, '좋음', '한국', '지오다노', '1년',
'지오다노', '공인영수증', '', '010-8888-8888', '기업은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'yangchae2','코튼 데님 긴팔 셔츠', '/2012-10-9/yangchae2-listimg-2012-10-9-555565.jpg', '/2012-10-9/yangchae2-detailTopImg-2012-10-9-555565.jpg', 
'/2012-10-9/yangchae2-detailImg-2012-10-9-555565.JPG', '남성용 데님 셔츠', '의류', 999, 59800,
59800, '좋음', '한국', '지오다노', '1년',
'지오다노', '공인영수증', '', '010-8888-8888', '기업은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'yangchae2','슬림 스트레치 데님', '/2012-10-9/yangchae2-listimg-2012-10-9-555566.jpg', '/2012-10-9/yangchae2-detailTopImg-2012-10-9-555566.jpg', 
'/2012-10-9/yangchae2-detailImg-2012-10-9-555566.JPG', '슬림핏 스트레치 데님', '의류', 999, 89800,
35000, '좋음', '한국', '지오다노', '1년',
'지오다노', '공인영수증', '', '010-8888-8888', '기업은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'yangchae2','데님 부츠컷 진', '/2012-10-9/yangchae2-listimg-2012-10-9-555567.jpg', '/2012-10-9/yangchae2-detailTopImg-2012-10-9-555567.jpg', 
'/2012-10-9/yangchae2-detailImg-2012-10-9-555567.JPG', '다양한 워싱으로 전개되는 슬림 부츠컷 스타일의 데님', '의류', 999, 89800,
30000, '좋음', '한국', '지오다노', '1년',
'지오다노', '공인영수증', '', '010-8888-8888', '기업은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'yangchae2','여 코튼 데님 긴팔 셔츠', '/2012-10-9/yangchae2-listimg-2012-10-9-555568.jpg', '/2012-10-9/yangchae2-detailTopImg-2012-10-9-555568.jpg', 
'/2012-10-9/yangchae2-detailImg-2012-10-9-555568.JPG', '여성용 데님 셔츠', '의류', 999, 59800,
59800, '좋음', '한국', '지오다노', '1년',
'지오다노', '공인영수증', '', '010-8888-8888', '기업은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'yangchae2','여 7게이지 크루넥 풀오버', '/2012-10-9/yangchae2-listimg-2012-10-9-555569.jpg', '/2012-10-9/yangchae2-detailTopImg-2012-10-9-555569.jpg', 
'/2012-10-9/yangchae2-detailImg-2012-10-9-555569.JPG', '여 아크릴/울 7게이지 크루넥 긴팔 풀오버', '의류', 999, 44800,
44800, '좋음', '한국', '지오다노', '1년',
'지오다노', '공인영수증', '', '010-8888-8888', '기업은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'yangchae2','여 테리 후드 풀오버', '/2012-10-9/yangchae2-listimg-2012-10-9-555570.jpg', '/2012-10-9/yangchae2-detailTopImg-2012-10-9-555570.jpg', 
'/2012-10-9/yangchae2-detailImg-2012-10-9-555570.JPG', '여성 언브러시드 테리 후드 풀오버', '의류', 999, 39800,
29800, '좋음', '한국', '지오다노', '1년',
'지오다노', '공인영수증', '', '010-8888-8888', '기업은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'yangchae2','여 브이넥 솔리드 티', '/2012-10-9/yangchae2-listimg-2012-10-9-555571.jpg', '/2012-10-9/yangchae2-detailTopImg-2012-10-9-555571.jpg', 
'/2012-10-9/yangchae2-detailImg-2012-10-9-555571.JPG', '여성 언브러시드 테리 후드 풀오버', '의류', 999, 16800,
15000, '좋음', '한국', '지오다노', '1년',
'지오다노', '공인영수증', '', '010-8888-8888', '기업은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'yangchae2','여 3게이지 크루넥 긴팔 포켓 풀오버', '/2012-10-9/yangchae2-listimg-2012-10-9-555572.jpg', '/2012-10-9/yangchae2-detailTopImg-2012-10-9-555572.jpg', 
'/2012-10-9/yangchae2-detailImg-2012-10-9-555572.JPG', '여 아크릴/울 3게이지 크루넥 긴팔 포켓 풀오버', '의류', 999, 79800,
79800, '좋음', '한국', '지오다노', '1년',
'지오다노', '공인영수증', '', '010-8888-8888', '기업은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'yangchae2','여 데님 긴팔 포켓 셔츠', '/2012-10-9/yangchae2-listimg-2012-10-9-555573.jpg', '/2012-10-9/yangchae2-detailTopImg-2012-10-9-555573.jpg', 
'/2012-10-9/yangchae2-detailImg-2012-10-9-555573.JPG', '여성 코튼 데님 긴팔 포켓 셔츠', '의류', 999, 69800,
69800, '좋음', '한국', '지오다노', '1년',
'지오다노', '공인영수증', '', '010-8888-8888', '기업은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'yangchae2','여 5게이지 후드 긴팔 롱 포켓 가디건', '/2012-10-9/yangchae2-listimg-2012-10-9-555574.jpg', '/2012-10-9/yangchae2-detailTopImg-2012-10-9-555574.jpg', 
'/2012-10-9/yangchae2-detailImg-2012-10-9-555574.JPG', '여 아크릴 5gg 롱 후드 가디건', '의류', 999, 128000,
128000, '좋음', '한국', '지오다노', '1년',
'지오다노', '공인영수증', '', '010-8888-8888', '기업은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'yangchae2','여 보드넥 롱거 긴팔 티', '/2012-10-9/yangchae2-listimg-2012-10-9-555575.jpg', '/2012-10-9/yangchae2-detailTopImg-2012-10-9-555575.jpg', 
'/2012-10-9/yangchae2-detailImg-2012-10-9-555575.JPG', '여성 폴리 레이온 보트넥 롱거 티', '의류', 999, 29800,
29800, '좋음', '한국', '지오다노', '1년',
'지오다노', '공인영수증', '', '010-8888-8888', '기업은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'yangchae2','여 립 보트넥 긴팔 롱 스트라이프 티', '/2012-10-9/yangchae2-listimg-2012-10-9-555576.jpg', '/2012-10-9/yangchae2-detailTopImg-2012-10-9-555576.jpg', 
'/2012-10-9/yangchae2-detailImg-2012-10-9-555576.JPG', '여성 폴리 레이온 보트넥 롱거 티', '의류', 999, 34800,
34800, '좋음', '한국', '지오다노', '1년',
'지오다노', '공인영수증', '', '010-8888-8888', '기업은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'yangchae2','여 후드 롱랭스 밀리터리 자켓', '/2012-10-9/yangchae2-listimg-2012-10-9-555577.jpg', '/2012-10-9/yangchae2-detailTopImg-2012-10-9-555577.jpg', 
'/2012-10-9/yangchae2-detailImg-2012-10-9-555577.JPG', '여성용 후드 롱랭스 밀리터리 자켓', '의류', 999, 99800,
79000, '좋음', '한국', '지오다노', '1년',
'지오다노', '공인영수증', '', '010-8888-8888', '기업은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'yangchae2','여 슬림 롱 스커트', '/2012-10-9/yangchae2-listimg-2012-10-9-555578.jpg', '/2012-10-9/yangchae2-detailTopImg-2012-10-9-555578.jpg', 
'/2012-10-9/yangchae2-detailImg-2012-10-9-555578.JPG', '여성용 롱슬림 스커트', '의류', 999, 22800,
22800, '좋음', '한국', '지오다노', '1년',
'지오다노', '공인영수증', '', '010-8888-8888', '기업은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'yangchae2','여 목넥 라글란슬리브 밀리터리 패딩 자켓', '/2012-10-9/yangchae2-listimg-2012-10-9-555579.jpg', '/2012-10-9/yangchae2-detailTopImg-2012-10-9-555579.jpg', 
'/2012-10-9/yangchae2-detailImg-2012-10-9-555579.JPG', '여 코튼 목넥 라글란 슬리브 밀리터리 패딩 자켓', '의류', 999, 148000,
148000, '좋음', '한국', '지오다노', '1년',
'지오다노', '공인영수증', '', '010-8888-8888', '기업은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'yangchae2','여 12게이지 브이넥 가디건', '/2012-10-9/yangchae2-listimg-2012-10-9-555580.jpg', '/2012-10-9/yangchae2-detailTopImg-2012-10-9-555580.jpg', 
'/2012-10-9/yangchae2-detailImg-2012-10-9-555580.JPG', '여 아크릴/나일론/울 12게이지 버튼 가디건', '의류', 999, 49800,
49800, '좋음', '한국', '지오다노', '1년',
'지오다노', '공인영수증', '', '010-8888-8888', '기업은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'yangchae2','여 코튼 포플린 롱 시어 셔츠', '/2012-10-9/yangchae2-listimg-2012-10-9-555581.jpg', '/2012-10-9/yangchae2-detailTopImg-2012-10-9-555581.jpg', 
'/2012-10-9/yangchae2-detailImg-2012-10-9-555581.JPG', '면소재의 여성용 셔츠', '의류', 999, 48900,
25000, '좋음', '한국', '지오다노', '1년',
'지오다노', '공인영수증', '', '010-8888-8888', '기업은행',
0, 0, 0, sysdate);


-- 생활
insert into productinsert values
(pro_seq.nextval,'aaaaa','프렌치 레드파인 데스크', '/2012-10-11/f_list_01.jpg', '/2012-10-11/f_view_01.jpg', 
'/2012-10-11/f_detail_01.jpg', '상세페이지 참고', '생활', 100, 298000,
298000, '새상품', '한국', '디노데크', '1년',
'디노데크', '현금영수증', '', '1234567890', '우리은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'aaaaa','스윙책꽃이', '/2012-10-11/f_list_02.jpg', '/2012-10-11/f_view_02.jpg', 
'/2012-10-11/f_detail_02.jpg', '상세페이지 참고', '생활', 100, 335000,
335000, '새상품', '한국', '서랍키즈', '1년',
'서랍키즈', '현금영수증', '', '1234567890', '우리은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'aaaaa','메리미 거실장', '/2012-10-11/f_list_03.jpg', '/2012-10-11/f_view_03.jpg', 
'/2012-10-11/f_detail_03.jpg', '상세페이지 참고', '생활', 100, 89000,
89000, '새상품', '한국', '마루이', '1년',
'Moi', '현금영수증', '', '1234567890', '우리은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'aaaaa','메리미 사이드 서랍장', '/2012-10-11/f_list_04.jpg', '/2012-10-11/f_view_04.jpg', 
'/2012-10-11/f_detail_04.jpg', '상세페이지 참고', '생활', 100, 59000,
59000, '새상품', '한국', '마루이', '1년',
'Moi', '현금영수증', '', '1234567890', '우리은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'aaaaa','메리미 소파 테이블', '/2012-10-11/f_list_05.jpg', '/2012-10-11/f_view_05.jpg', 
'/2012-10-11/f_detail_05.jpg', '상세페이지 참고', '생활', 100, 99000,
99000, '새상품', '한국', '마루이', '1년',
'Moi', '현금영수증', '', '1234567890', '우리은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'aaaaa','메리미 3단 서랍장', '/2012-10-11/f_list_06.jpg', '/2012-10-11/f_view_06.jpg', 
'/2012-10-11/f_detail_06.jpg', '상세페이지 참고', '생활', 100, 119000,
119000, '새상품', '한국', '마루이', '1년',
'Moi', '현금영수증', '', '1234567890', '우리은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'aaaaa','메리미 5단 서랍장', '/2012-10-11/f_list_07.jpg', '/2012-10-11/f_view_07.jpg', 
'/2012-10-11/f_detail_07.jpg', '상세페이지 참고', '생활', 100, 139000,
139000, '새상품', '한국', '마루이', '1년',
'Moi', '현금영수증', '', '1234567890', '우리은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'aaaaa','메리미 와이드 서랍장', '/2012-10-11/f_list_08.jpg', '/2012-10-11/f_view_08.jpg', 
'/2012-10-11/f_detail_08.jpg', '상세페이지 참고', '생활', 100, 169000,
169000, '새상품', '한국', '마루이', '1년',
'Moi', '현금영수증', '', '1234567890', '우리은행',
0, 0, 0, sysdate);


insert into productinsert values
(pro_seq.nextval,'aaaaa','메리미 원형 거울', '/2012-10-11/f_list_09.jpg', '/2012-10-11/f_view_09.jpg', 
'/2012-10-11/f_detail_09.jpg', '상세페이지 참고', '생활', 100, 39000,
39000, '새상품', '한국', '마루이', '1년',
'Moi', '현금영수증', '', '1234567890', '우리은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'aaaaa','거실장 사이드테이블SET', '/2012-10-11/f_list_10.jpg', '/2012-10-11/f_view_10.jpg', 
'/2012-10-11/f_detail_10.jpg', '상세페이지 참고', '생활', 100, 130000,
130000, '새상품', '한국', '마루이', '1년',
'Moi', '현금영수증', '', '1234567890', '우리은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'aaaaa','메리미 책장', '/2012-10-11/f_list_11.jpg', '/2012-10-11/f_view_11.jpg', 
'/2012-10-11/f_detail_11.jpg', '상세페이지 참고', '생활', 100, 149000,
149000, '새상품', '한국', '마루이', '1년',
'Moi', '현금영수증', '', '1234567890', '우리은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'aaaaa','메리미 책상1인용', '/2012-10-11/f_list_12.jpg', '/2012-10-11/f_view_12.jpg', 
'/2012-10-11/f_detail_12.jpg', '상세페이지 참고', '생활', 100, 199000,
199000, '새상품', '한국', '마루이', '1년',
'Moi', '현금영수증', '', '1234567890', '우리은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'aaaaa','서랍형 책상1인용', '/2012-10-11/f_list_13.jpg', '/2012-10-11/f_view_13.jpg', 
'/2012-10-11/f_detail_13.jpg', '상세페이지 참고', '생활', 100, 199000,
199000, '새상품', '한국', '마루이', '1년',
'Moi', '현금영수증', '', '1234567890', '우리은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'aaaaa','서랍형 책상2인용', '/2012-10-11/f_list_14.jpg', '/2012-10-11/f_view_14.jpg', 
'/2012-10-11/f_detail_14.jpg', '상세페이지 참고', '생활', 100, 279000,
279000, '새상품', '한국', '마루이', '1년',
'Moi', '현금영수증', '', '1234567890', '우리은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'aaaaa','메리미 3단 책상서랍', '/2012-10-11/f_list_15.jpg', '/2012-10-11/f_view_15.jpg', 
'/2012-10-11/f_detail_15.jpg', '상세페이지 참고', '생활', 100, 119000,
119000, '새상품', '한국', '마루이', '1년',
'Moi', '현금영수증', '', '1234567890', '우리은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'aaaaa','2단 책장+책상세트', '/2012-10-11/f_list_16.jpg', '/2012-10-11/f_view_16.jpg', 
'/2012-10-11/f_detail_16.jpg', '상세페이지 참고', '생활', 100, 209000,
209000, '새상품', '한국', '마루이', '1년',
'Moi', '현금영수증', '', '1234567890', '우리은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'aaaaa','메리미 2단 책장', '/2012-10-11/f_list_17.jpg', '/2012-10-11/f_view_17.jpg', 
'/2012-10-11/f_detail_17.jpg', '상세페이지 참고', '생활', 100, 119000,
119000, '새상품', '한국', '마루이', '1년',
'Moi', '현금영수증', '', '1234567890', '우리은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'aaaaa','메리미 자석보드판', '/2012-10-11/f_list_18.jpg', '/2012-10-11/f_view_18.jpg', 
'/2012-10-11/f_detail_18.jpg', '상세페이지 참고', '생활', 100, 71100,
71100, '새상품', '한국', '마루이', '1년',
'Moi', '현금영수증', '', '1234567890', '우리은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'aaaaa','미스티 부케POP', '/2012-10-11/f_list_19.jpg', '/2012-10-11/f_view_19.jpg', 
'/2012-10-11/f_detail_19.jpg', '상세페이지 참고', '생활', 100, 33440,
3344, '새상품', '일본', '미스티에코', '1년',
'미쿠니', '현금영수증', '', '1234567890', '우리은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'aaaaa','샤니 스탠드', '/2012-10-11/f_list_20.jpg', '/2012-10-11/f_view_20.jpg', 
'/2012-10-11/f_detail_20.jpg', '상세페이지 참고', '생활', 100, 18550,
1855, '새상품', '중국', '샛별하우스', '1년',
'샛별하우스', '현금영수증', '', '1234567890', '우리은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'aaaaa','로윈사각 도트시계', '/2012-10-11/f_list_21.jpg', '/2012-10-11/f_view_21.jpg', 
'/2012-10-11/f_detail_21.jpg', '상세페이지 참고', '생활', 100, 10080,
1008, '새상품', '중국', '풍경있는집', '1년',
'풍경있는집', '현금영수증', '', '1234567890', '우리은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'aaaaa','실리콘 쥬스병 4종 SET', '/2012-10-11/f_list_22.jpg', '/2012-10-11/f_view_22.jpg', 
'/2012-10-11/f_detail_22.jpg', '상세페이지 참고', '생활', 100, 27000,
2700, '새상품', '한국', '빅풋', '1년',
'빅풋', '현금영수증', '', '1234567890', '우리은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'aaaaa','블랙스퀘어 우산꽂이', '/2012-10-11/f_list_23.jpg', '/2012-10-11/f_view_23.jpg', 
'/2012-10-11/f_detail_23.jpg', '상세페이지 참고', '생활', 100, 30400,
3040, '새상품', '중국', '이모셔널', '1년',
'이모션', '현금영수증', '', '1234567890', '우리은행',
0, 0, 0, sysdate);

insert into productinsert values
(pro_seq.nextval,'aaaaa','비덕 14cm 캔디박스', '/2012-10-11/f_list_24.jpg', '/2012-10-11/f_view_24.jpg', 
'/2012-10-11/f_detail_24.jpg', '상세페이지 참고', '생활', 100, 14850,
1485, '새상품', '중국', 'semk', '1년',
'semk', '현금영수증', '', '1234567890', '우리은행',
0, 0, 0, sysdate);


update PRODUCTINSERT set pro_date='12/10/13' where pro_id=30;

select pro_id, pro_title, pro_listImg, user_price, pro_hit, pro_date
from (	select pro_id, pro_title, pro_listImg, user_price,pro_hit,pro_date, rownum as rnum 
		from productinsert 
		order by pro_date desc, pro_hit asc
	)
where 0 < rownum and rownum <= 4 ;

select * from PRODUCTINSERT;
