package model;

public class BoardBean {

	private String board_id; // ȸ�� ���̵�
	private int board_section; // 0 �Ϲ�ȸ��, 1 �Ǹ���ȸ��, 3 ������ 
	private int board_no; // �Խ��� ����
	private String board_title; // �Խ��� ����
	private String board_name; // �Խ��� �ۼ���(ȸ���̸�)
	private String board_email1; // �����ּ�
	private String board_email2; // �����ּ� 2
	private String board_cont; // �Խ��� ����
	private String board_pwd; // �Խ��� ���
	private String board_secret; // 0������, 1�������
	private String board_date; // �ۼ� �ð�
	private int comment_total; // ��� ����
	private int reply_select_no; // ������ ��� ��ȣ
	private int reply_level; // ��� ����
	private int reply_seq; // ��� ��ȣ
	private int hit; // ��ȸ��

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
