create table orderProduct(
	order_no number primary key,		-- sequence
	customer_id varchar2(100),		-- 구매자 id
	product_id number,			-- 물품 등록번호
	product_listImg varchar2(1000),		-- 물품 리스트이미지
	product_name varchar2(100),		-- 물품 이름
	product_price number,			-- 물품 소비자 판매가격
	product_count number,			-- 물품 주문 수량
	seller_user varchar2(100),		-- 판매자 id
	
	buyer_name varchar2(100),		-- 입금자명
	buyer_bank varchar2(100),		-- 거래은행
	buyer_banknumber varchar2(100),		-- 계좌번호
	recevier_name varchar2(100),		-- 수취인이름
	recevier_addr1 varchar2(500),		-- 주소1
	recevier_addr2 varchar2(500),		-- 주소2
	recevier_zip1 number(10),		-- 우편번호1
	recevier_zip2 number(10),		-- 우편번호2
	recevier_tel1 number(10),		-- 전화번호1
	recevier_tel2 number(10),		-- 전화번호2
	recevier_tel3 number(10),		-- 전화번호3
	recevier_help varchar2(500),		-- 배송시요청사항
		
	recevier_cartdate date,			-- 장바구니 담은 날짜
	recevier_buydate date,			-- 구매한 날짜
	deal_check number(2),			-- 판매자 거래확인 // 구매신청 :0  거래성공 :1 
	buy_and_cart varchar2(5)		-- 바로구매:Y 장바구니:N 
);
create sequence order_seq increment by 1 start with 1 nocache;
drop sequence order_seq;
drop table orderProduct;
select * from orderProduct;
delete from orderProduct ;

delete from orderProduct;


-- 구매자 판매완료 리스트
select *
from orderProduct
where customer_id='yangchae1' and buy_and_cart='N'