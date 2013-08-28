package controller.join;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberBean;
import model.PostBean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.MemberDao;

@Controller
public class JoinController {

	private MemberDao memberService;

	public void setMemberService(MemberDao memberService) {
		this.memberService = memberService;
	}

	/* ������ / �Ǹ��� ȸ������ ���� �� */
	@RequestMapping(value = "join_select.do", method = RequestMethod.GET)
	public ModelAndView join_select() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("join_select");
		return modelAndView;
	}

	/* ������ ȸ������ �� */
	@RequestMapping(value = "join_buy_form.do", method = RequestMethod.GET)
	public ModelAndView join_buy_form() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("join_buy_form");
		return modelAndView;
	}

	/* ������ ȸ������ ���� */
	@RequestMapping(value = "join_buy_form.do", method = RequestMethod.POST)
	public ModelAndView join_buy_from(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView();

		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();

		String id = request.getParameter("id");						String section = request.getParameter("section");
		String pwd = request.getParameter("pwd");					String pwd_q = request.getParameter("pwd_q");
		String pwd_a = request.getParameter("pwd_a");				String name = request.getParameter("name");
		String zip1 = request.getParameter("zip1");					String zip2 = request.getParameter("zip2");
		String addr1 = request.getParameter("addr1");				String addr2 = request.getParameter("addr2");
		String tel1 = request.getParameter("tel1");					String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");					String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");				String phone3 = request.getParameter("phone3");
		String email1 = request.getParameter("email1");				String email2 = request.getParameter("email2");
		String birth1 = request.getParameter("birth1");				String birth2 = request.getParameter("birth2");
		String birth3 = request.getParameter("birth3");				String wedding1 = request.getParameter("wedding1");
		String wedding2 = request.getParameter("wedding2");			String wedding3 = request.getParameter("wedding3");
		String wifebirth1 = request.getParameter("wifebirth1");		String wifebirth2 = request.getParameter("wifebirth2");
		String wifebirth3 = request.getParameter("wifebirth3");		String location = request.getParameter("location");
		
		MemberBean memberBean = new MemberBean();
		memberBean.setId(id);					memberBean.setSection(section);			memberBean.setPwd(pwd);
		memberBean.setPwd_q(pwd_q);				memberBean.setPwd_a(pwd_a);				memberBean.setName(name);
		memberBean.setZip1(zip1);				memberBean.setZip2(zip2);				memberBean.setAddr1(addr1);
		memberBean.setAddr2(addr2);				memberBean.setTel1(tel1);				memberBean.setTel2(tel2);
		memberBean.setTel3(tel3);				memberBean.setPhone1(phone1);			memberBean.setPhone2(phone2);
		memberBean.setPhone3(phone3);			memberBean.setEmail1(email1);			memberBean.setEmail2(email2);
		memberBean.setBirth1(birth1);			memberBean.setBirth2(birth2);			memberBean.setBirth3(birth3);
		memberBean.setWedding1(wedding1);		memberBean.setWedding2(wedding2);		memberBean.setWedding3(wedding3);
		memberBean.setWifebirth1(wifebirth1);	memberBean.setWifebirth2(wifebirth2);	memberBean.setWifebirth3(wifebirth3);
		memberBean.setLocation(location);

		int num = this.memberService.insertMember(memberBean);
		
		if (num == 1) {
			out.println("<script>");
			out.println("alert('���Լ����Ͽ����ϴ�. �α��� �������� �Ѿ�ϴ�.')");
			out.println("location.href='login.do'");
			out.println("</script>");
		}
		// modelAndView.setViewName("login");

		return null;
	}

/* =================== �Ǹ��� ȸ������ ���� =================== */
	@RequestMapping(value = "join_sell_form.do", method = RequestMethod.GET)
	public ModelAndView join_sell_form() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("join_sell_form");
		return modelAndView;
	}
	@RequestMapping(value = "join_sell_form.do", method = RequestMethod.POST)
	public ModelAndView join_sell_form(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView modelAndView = new ModelAndView();
		
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();

		String id = request.getParameter("id");						String section = request.getParameter("section");
		String pwd = request.getParameter("pwd");					String pwd_q = request.getParameter("pwd_q");
		String pwd_a = request.getParameter("pwd_a");				String name = request.getParameter("name");
		String zip1 = request.getParameter("zip1");					String zip2 = request.getParameter("zip2");
		String addr1 = request.getParameter("addr1");				String addr2 = request.getParameter("addr2");
		String tel1 = request.getParameter("tel1");					String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");					String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");				String phone3 = request.getParameter("phone3");
		String email1 = request.getParameter("email1");				String email2 = request.getParameter("email2");
		String birth1 = request.getParameter("birth1");				String birth2 = request.getParameter("birth2");
		String birth3 = request.getParameter("birth3");				String wedding1 = request.getParameter("wedding1");
		String wedding2 = request.getParameter("wedding2");			String wedding3 = request.getParameter("wedding3");
		String wifebirth1 = request.getParameter("wifebirth1");		String wifebirth2 = request.getParameter("wifebirth2");
		String wifebirth3 = request.getParameter("wifebirth3");		String location = request.getParameter("location");
		String cor = request.getParameter("cor");					String cor_name = request.getParameter("cor_name");
		String cor_number = request.getParameter("cor_number");		String cor_zip1 = request.getParameter("cor_zip1");
		String cor_zip2 = request.getParameter("cor_zip2");			String cor_addr1 = request.getParameter("cor_addr1");
		String cor_addr2 = request.getParameter("cor_addr2");		String cor_tel1 = request.getParameter("cor_tel1");
		String cor_tel2 = request.getParameter("cor_tel2");			String cor_tel3 = request.getParameter("cor_tel3");
		String cor_fax1 = request.getParameter("cor_fax1");			String cor_fax2 = request.getParameter("cor_fax2");
		String cor_fax3 = request.getParameter("cor_fax3");			String cor_mail1 = request.getParameter("cor_mail1");
		String cor_mail2 = request.getParameter("cor_mail2");
		
		
		MemberBean memberBean = new MemberBean();
		memberBean.setId(id);					memberBean.setSection(section);			memberBean.setPwd(pwd);
		memberBean.setPwd_q(pwd_q);				memberBean.setPwd_a(pwd_a);				memberBean.setName(name);
		memberBean.setZip1(zip1);				memberBean.setZip2(zip2);				memberBean.setAddr1(addr1);
		memberBean.setAddr2(addr2);				memberBean.setTel1(tel1);				memberBean.setTel2(tel2);
		memberBean.setTel3(tel3);				memberBean.setPhone1(phone1);			memberBean.setPhone2(phone2);
		memberBean.setPhone3(phone3);			memberBean.setEmail1(email1);			memberBean.setEmail2(email2);
		memberBean.setBirth1(birth1);			memberBean.setBirth2(birth2);			memberBean.setBirth3(birth3);
		memberBean.setWedding1(wedding1);		memberBean.setWedding2(wedding2);		memberBean.setWedding3(wedding3);
		memberBean.setWifebirth1(wifebirth1);	memberBean.setWifebirth2(wifebirth2);	memberBean.setWifebirth3(wifebirth3);
		memberBean.setLocation(location);
		memberBean.setCor(cor);					memberBean.setCor_name(cor_name);		memberBean.setCor_number(cor_number);
		memberBean.setCor_zip1(cor_zip1);		memberBean.setCor_zip2(cor_zip2);		memberBean.setCor_addr1(cor_addr1);
		memberBean.setCor_addr2(cor_addr2);			memberBean.setCor_tel1(cor_tel1);		memberBean.setCor_tel2(cor_tel2);
		memberBean.setCor_tel3(cor_tel3);		memberBean.setCor_fax1(cor_fax1);		memberBean.setCor_fax2(cor_fax2);
		memberBean.setCor_fax3(cor_fax3);		memberBean.setCor_mail1(cor_mail1);		memberBean.setCor_mail2(cor_mail2);

		
		
		int num = this.memberService.insertMember2(memberBean);
//		System.out.println("�Ѿ�� �� : " + num);
		
		if (num == 1) {
			out.println("<script>");
			out.println("alert('���Լ����Ͽ����ϴ�. �α��� �������� �Ѿ�ϴ�.')");
			out.println("location.href='login.do'");
			out.println("</script>");
		}
		
		return null;
	}	
	
/* =================== �Ǹ��� ȸ������ �� =================== */
	

/* =================== ���̵� �ߺ�üũ ���� =================== */
	@RequestMapping(value = "idcheck.do", method = RequestMethod.GET)
	public ModelAndView idcheck() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("idcheck");
		return modelAndView;
	}

	@RequestMapping(value = "idcheck.do", method = RequestMethod.POST)
	public ModelAndView idcheck_ok(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView();

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String idcheck = request.getParameter("idcheck").trim();

		String id = this.memberService.idcheckMember(idcheck);

		if (id != null) { // ��ȯ�Ǵ� String ���� ������ ���̵� ������
			out.println("<script>");
			out.println("alert('�̹� ��ϵ� ���̵� �Դϴ�.')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			request.setAttribute("id", idcheck);
			modelAndView.setViewName("idcheck");
			return modelAndView;
		}

		return null;
	}
	/* =================== ���̵� �ߺ�üũ �� =================== */
	
	

	/* =================== �����ȣ �˻� ���� =================== */
	@RequestMapping(value = "zipcode.do", method = RequestMethod.GET)
	public ModelAndView zipcode() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("zipcode");
		return modelAndView;
	}

	@RequestMapping(value = "zipcode.do", method = RequestMethod.POST)
	public ModelAndView zipcode_ok(HttpServletRequest request,
			HttpServletResponse response) throws SQLException {
		ModelAndView modelAndView = new ModelAndView();

		String dong = request.getParameter("dong").trim();
		List<PostBean> list = new ArrayList<PostBean>();

		list = this.memberService.searchZipcode(dong); // PostBean �ڹ� ���� �� Ÿ������
														// ����Ʈ ����

		List<String> zipcodeList = new ArrayList<String>(); // PostBean Ÿ������ ��
															// �ּҰ��� ���ڿ��� �̾� ������
															// String Ÿ���� ����Ʈ
		PostBean postbean = new PostBean();
		for (int i = 0; i < list.size(); i++) {
			postbean = list.get(i); // PostBean Ÿ������ �Ѿ�� ����Ʈ�� PostBean ���� ��
									// �����ؼ� �۾�
			String zipcode = postbean.getZipcode(); // �����ȣ
			String sido = postbean.getSido(); // �õ�
			String gugun = postbean.getGugun(); // ����

			String dong_ = postbean.getDong(); // ��(��, ��, ��)
			String ri = postbean.getRi(); // ��(��, �ǹ���)

			String st_bunji = null; // ���۹���
			if (postbean.getSt_bunji() == null) { // null ���̸� �������� null �� ó��
				st_bunji = " ";
			} else {
				st_bunji = postbean.getSt_bunji();
			}

			String ed_bunji = null; // ������
			if (postbean.getEd_bunji() == null) {
				ed_bunji = " ";
			} else {
				ed_bunji = postbean.getEd_bunji();
			}

			// ��(��,��,��) ��(��,�ǹ���) �� DB�� ����Ǿ� �ִ�. ���� NULL �̸� ���� ������ �����´�.
			String addr1 = "", addr2 = "";
			if (ri == null) {
				addr1 = sido + " " + gugun + " " + dong_ + " " + st_bunji;
				addr2 = sido + " " + gugun + " " + dong_ + " " + st_bunji + " "
						+ ed_bunji;
			} else if (ri != null) {
				addr1 = sido + " " + gugun + " " + dong_ + " " + ri + " "
						+ st_bunji;
				addr2 = sido + " " + gugun + " " + dong_ + " " + ri + " "
						+ st_bunji + " " + ed_bunji;
			}

			// addr1 �� �ּ��Է�â�� �� ���ڿ��̰�, addr2�� �ּ� ���� ����Ʈ�� �� ���ڿ��̴�.
			zipcodeList.add(zipcode + "," + addr1 + "," + addr2);
		}

		request.setAttribute("zipcodeList", zipcodeList); // ���ڿ��� ���� ����Ʈ��
															// zipcode.jsp�� ����
		request.setAttribute("dong", dong);

		modelAndView.setViewName("zipcode");
		return modelAndView;
	}
	/* =================== �����ȣ �˻� �� =================== */
}
