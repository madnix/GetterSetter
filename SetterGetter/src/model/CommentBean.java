package model;

public class CommentBean {

	private int no; // ��� ����
	private int product_id; // �ش� ��ǰ ��ȣ
	private String comment_id; // �α����� �������� �������� ȸ�����̵�
	private int comment_section; // �α����� �������� �Ϲ�,�Ǹ���,������ ���� ��ȣ
	private String comment_name; // �ۼ����̸�(ȸ���̸�)
	private String comment_cont; // �Խ��� ����
	private int comment_secret; // ����, ������� ����
	private int comment_select_no; // ������ ��� ��ȣ
	private int comment_level; // ��� ����
	private int comment_no; // ��� ��ȣ
	private int product_appraisal; // �� ��
	private String comment_date; // ������ �ð�

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getComment_date() {
		return comment_date;
	}

	public void setComment_date(String comment_date) {
		this.comment_date = comment_date;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getProduct_appraisal() {
		return product_appraisal;
	}

	public void setProduct_appraisal(int product_appraisal) {
		this.product_appraisal = product_appraisal;
	}

	public int getComment_no() {
		return comment_no;
	}

	public void setComment_no(int comment_no) {
		this.comment_no = comment_no;
	}

	public String getComment_id() {
		return comment_id;
	}

	public void setComment_id(String comment_id) {
		this.comment_id = comment_id;
	}

	public int getComment_section() {
		return comment_section;
	}

	public void setComment_section(int comment_section) {
		this.comment_section = comment_section;
	}

	public String getComment_name() {
		return comment_name;
	}

	public void setComment_name(String comment_name) {
		this.comment_name = comment_name;
	}

	public String getComment_cont() {
		return comment_cont;
	}

	public void setComment_cont(String comment_cont) {
		this.comment_cont = comment_cont;
	}

	public int getComment_secret() {
		return comment_secret;
	}

	public void setComment_secret(int comment_secret) {
		this.comment_secret = comment_secret;
	}

	public int getComment_select_no() {
		return comment_select_no;
	}

	public void setComment_select_no(int comment_select_no) {
		this.comment_select_no = comment_select_no;
	}

	public int getComment_level() {
		return comment_level;
	}

	public void setComment_level(int comment_level) {
		this.comment_level = comment_level;
	}

}
