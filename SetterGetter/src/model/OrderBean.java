package model;

public class OrderBean {
	private int order_no; // sequence
	private String customer_id; // 구매자 id
	private int product_id; // 물품 등록번호
	private String product_listImg; // 물품 리스트이미지
	private String product_name; // 물품 이름
	private int product_price; // 물품 소비자 판매가격
	private int product_count; // 물품 주문 수량

	private String seller_user; // 판매자 id
	private String buyer_name; // 입금자명
	private String buyer_bank; // 거래은행
	private String buyer_banknumber; // 계좌번호

	private String recevier_name; // 수취인이름
	private String recevier_addr1; // 주소1
	private String recevier_addr2; // 주소2
	private String recevier_zip1; // 우편번호1
	private String recevier_zip2; // 우편번호2
	private String recevier_tel1; // 전화번호1
	private String recevier_tel2; // 전화번호2
	private String recevier_tel3; // 전화번호3
	private String recevier_help; // 배송시요청사항

	private String recevier_cartdate; // 장바구니 담은 날짜
	private String recevier_buydate; // 구매한 날짜
	private String deal_check; // 판매자 거래확인 // 구매신청 :0 거래성공 :3
	private String buy_and_cart; // 판매 유무 // 거래완료:Y 장바구니:N

	public int getOrder_no() {
		return order_no;
	}

	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_listImg() {
		return product_listImg;
	}

	public void setProduct_listImg(String product_listImg) {
		this.product_listImg = product_listImg;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public int getProduct_count() {
		return product_count;
	}

	public void setProduct_count(int product_count) {
		this.product_count = product_count;
	}

	public String getSeller_user() {
		return seller_user;
	}

	public void setSeller_user(String seller_user) {
		this.seller_user = seller_user;
	}

	public String getBuyer_name() {
		return buyer_name;
	}

	public void setBuyer_name(String buyer_name) {
		this.buyer_name = buyer_name;
	}

	public String getBuyer_bank() {
		return buyer_bank;
	}

	public void setBuyer_bank(String buyer_bank) {
		this.buyer_bank = buyer_bank;
	}

	public String getBuyer_banknumber() {
		return buyer_banknumber;
	}

	public void setBuyer_banknumber(String buyer_banknumber) {
		this.buyer_banknumber = buyer_banknumber;
	}

	public String getRecevier_name() {
		return recevier_name;
	}

	public void setRecevier_name(String recevier_name) {
		this.recevier_name = recevier_name;
	}

	public String getRecevier_addr1() {
		return recevier_addr1;
	}

	public void setRecevier_addr1(String recevier_addr1) {
		this.recevier_addr1 = recevier_addr1;
	}

	public String getRecevier_addr2() {
		return recevier_addr2;
	}

	public void setRecevier_addr2(String recevier_addr2) {
		this.recevier_addr2 = recevier_addr2;
	}

	public String getRecevier_zip1() {
		return recevier_zip1;
	}

	public void setRecevier_zip1(String recevier_zip1) {
		this.recevier_zip1 = recevier_zip1;
	}

	public String getRecevier_zip2() {
		return recevier_zip2;
	}

	public void setRecevier_zip2(String recevier_zip2) {
		this.recevier_zip2 = recevier_zip2;
	}

	public String getRecevier_tel1() {
		return recevier_tel1;
	}

	public void setRecevier_tel1(String recevier_tel1) {
		this.recevier_tel1 = recevier_tel1;
	}

	public String getRecevier_tel2() {
		return recevier_tel2;
	}

	public void setRecevier_tel2(String recevier_tel2) {
		this.recevier_tel2 = recevier_tel2;
	}

	public String getRecevier_tel3() {
		return recevier_tel3;
	}

	public void setRecevier_tel3(String recevier_tel3) {
		this.recevier_tel3 = recevier_tel3;
	}

	public String getRecevier_help() {
		return recevier_help;
	}

	public void setRecevier_help(String recevier_help) {
		this.recevier_help = recevier_help;
	}

	public String getRecevier_cartdate() {
		return recevier_cartdate;
	}

	public void setRecevier_cartdate(String recevier_cartdate) {
		this.recevier_cartdate = recevier_cartdate;
	}

	public String getRecevier_buydate() {
		return recevier_buydate.substring(0, 19);
	}

	public void setRecevier_buydate(String recevier_buydate) {
		this.recevier_buydate = recevier_buydate;
	}

	public String getDeal_check() {
		return deal_check;
	}

	public void setDeal_check(String deal_check) {
		this.deal_check = deal_check;
	}

	public String getBuy_and_cart() {
		return buy_and_cart;
	}

	public void setBuy_and_cart(String buy_and_cart) {
		this.buy_and_cart = buy_and_cart;
	}

}
