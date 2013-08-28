package model;

public class BoardBean {

	private String board_id; // 회원 아이디
	private int board_section; // 0 일반회원, 1 판매자회원, 3 관리자 
	private int board_no; // 게시판 순번
	private String board_title; // 게시판 제목
	private String board_name; // 게시판 작성자(회원이름)
	private String board_email1; // 메일주소
	private String board_email2; // 메일주소 2
	private String board_cont; // 게시판 내용
	private String board_pwd; // 게시판 비번
	private String board_secret; // 0공개글, 1비공개글
	private String board_date; // 작성 시간
	private int comment_total; // 댓글 수량
	private int reply_select_no; // 선택한 답글 번호
	private int reply_level; // 답글 순번
	private int reply_seq; // 답글 번호
	private int hit; // 조회수

	public int getReply_level() {
		return reply_level;
	}

	public void setReply_level(int reply_level) {
		this.reply_level = reply_level;
	}

	public int getReply_select_no() {
		return reply_select_no;
	}

	public void setReply_select_no(int reply_select_no) {
		this.reply_select_no = reply_select_no;
	}

	public int getReply_seq() {
		return reply_seq;
	}

	public void setReply_seq(int reply_seq) {
		this.reply_seq = reply_seq;
	}

	public int getcomment_total() {
		return comment_total;
	}

	public void setcomment_total(int comment_total) {
		this.comment_total = comment_total;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getBoard_id() {
		return board_id;
	}

	public void setBoard_id(String board_id) {
		this.board_id = board_id;
	}

	public int getBoard_section() {
		return board_section;
	}

	public void setBoard_section(int board_section) {
		this.board_section = board_section;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_name() {
		return board_name;
	}

	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}

	public String getBoard_email1() {
		return board_email1;
	}

	public void setBoard_email1(String board_email1) {
		this.board_email1 = board_email1;
	}

	public String getBoard_email2() {
		return board_email2;
	}

	public void setBoard_email2(String board_email2) {
		this.board_email2 = board_email2;
	}

	public String getBoard_cont() {
		return board_cont;
	}

	public void setBoard_cont(String board_cont) {
		this.board_cont = board_cont;
	}

	public String getBoard_pwd() {
		return board_pwd;
	}

	public void setBoard_pwd(String board_pwd) {
		this.board_pwd = board_pwd;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public String getBoard_date() {
		return board_date;
	}

	public void setBoard_date(String board_date) {
		this.board_date = board_date;
	}

	public String getBoard_secret() {
		return board_secret;
	}

	public void setBoard_secret(String board_secret) {
		this.board_secret = board_secret;
	}

}
