package controller.login;

import java.io.PrintWriter;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberBean;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.MemberDao;

@Controller
public class LoginController {

	private MemberDao memberService;

	// private MimeNotiFier mimeNotiFier;
	public void setMemberService(MemberDao memberService) {
		this.memberService = memberService;
	}

	private JavaMailSender mailSender;

	public JavaMailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	// private IMimeNotifier mimeNotiFier;

	/* =================== �α��� �ϱ� =================== */
	@RequestMapping(value = "login.do", method = RequestMethod.GET)
	public ModelAndView login() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");

		return modelAndView;
	}

	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		ModelAndView modelAndView = new ModelAndView();

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("id").trim();
		String pwd = request.getParameter("pwd").trim();
		
		if(id.equals("admin") || pwd.equals("admin")){
			session.setAttribute("adminid", id);
			response.sendRedirect("adminpuser.do");
		}

		MemberBean memberBean = new MemberBean();
		memberBean.setId(id);
		memberBean.setPwd(pwd);

		MemberBean user = this.memberService.getLoginCheck(id);

		if (user == null) {
			out.println("<script>");
			out.println("alert('���̵� �����ʽ��ϴ�')");
			out.println("history.back()");
			out.println("</script>");
		} else if (user.getPwd().equals(pwd) == false) {
			System.out.println("USER1 =" + user);
			System.out.println("PWD =" + pwd);
			out.println("<script>");
			out.println("alert('�н����尡 Ʋ�Ƚ��ϴ�')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			
			session.setAttribute("id", id); // id ������ session ����
			MemberBean InfoMember = new MemberBean();
			InfoMember = this.memberService.getMemberInfo(id);
			session.setAttribute("section", InfoMember.getSection());	// section ������  session ����
			
			
			if(InfoMember.getSection().equals("4")){
				out.println("<script>");
				out.println("alert('Ż�� �� ���̵� �Դϴ�.')");
				out.println("history.back()");
				out.println("</script>");
			}else{
				out.println("<script>");
				out.println("alert('�α��εǾ����ϴ�.')");
				out.println("location='main.do'");
				out.println("</script>");
			}
		}
		return null;
	}
	
	@RequestMapping(value = "logout.do", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletResponse response, HttpSession session) throws Exception {

		ModelAndView modelAndView = new ModelAndView();
		response.setContentType("text/html;charset=utf-8");
		
		modelAndView.setViewName("logout");
		return modelAndView;
	}

	/* =================== ���̵� ã�� =================== */
	@RequestMapping(value = "searchid.do", method = RequestMethod.GET)
	public ModelAndView searchid() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("searchid");

		return modelAndView;
	}

	// public void setMimeNotiFier(IMimeNotifier mimeNotiFier) {
	// this.mimeNotiFier = mimeNotiFier;
	// }

	@RequestMapping(value = "searchid.do", method = RequestMethod.POST)
	public ModelAndView searchid(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ModelAndView modelAndView = new ModelAndView();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name").trim();
		String email = request.getParameter("email").trim();

		MemberBean memberBean = new MemberBean();

		memberBean.setName(name);
		memberBean.setEmail1(email);

		int num = email.indexOf("@");
		String email1 = email.substring(0, num);
		String email2 = email.substring(num + 1, email.length());
		MemberBean user = this.memberService.serchId(email1, email2);
		System.out.println("email1 = " + email1 + "email2 =" + email2);

		String u_mail1 = user.getEmail1();
		String u_email2 = user.getEmail2();
		String u_emails = u_mail1 + "@" + u_email2;

		if (user == null) {
			out.println("<script>");
			out.println("alert('��ϵ� �̸����� �����ϴ�.')");
			out.println("histroy.back()");
			out.println("</srcipt>");
		} else if (user.getName().equals(name) == false) {
			out.println("<script>");
			out.println("alert('�ش� �̸��� �����ϴ�.')");
			out.println("history.back()");
			out.println("</script>");
		} else {

			// MimeNotiFier mimeNotiFier = new MimeNotiFier();
			// mimeNotiFier.sendEmailNotif();

			// boolean result = this.mimeNotiFier.sendEmailNotif();
			try {
				MimeMessage message = this.mailSender.createMimeMessage();
				MimeMessageHelper helper = new MimeMessageHelper(message, true,
						"euc-kr");
				helper.setFrom(new InternetAddress(u_emails));
				helper.setTo(new InternetAddress(u_emails));
				helper.setSubject("�ȳ��ϼ��� settergetter�Դϴ�. ȸ������ ��û�Ͻ� ���̵��Դϴ�.");
				String htmlContent = "�ȳ��ϼ��� " + user.getName() + "��" + "<br/>"
						+ "ȸ������ ���̵�� [" + user.getId() + "] �Դϴ�.";
				helper.setText(htmlContent, true);
				mailSender.send(message);

				out.println("<script>");
				out.println("alert('���̵� �ش� �̸��Ϸ� �����Ͽ����ϴ�.')");
				out.println("location='main.do'");
				out.println("</script>");
				// System.out.println("���Ϻ����� ����");
			} catch (Exception e) {

				e.printStackTrace();
				// System.out.println("���Ϻ����� ����");
			}

			// System.out.println("���Ϻ����� ��� =" + result);

		}

		return null;
	}

/* =================== ��й�ȣ ã�� ���� =================== */
	@RequestMapping(value = "searchpwd.do", method = RequestMethod.GET)
	public ModelAndView searchpwd() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("searchpwd");

		return modelAndView;
	}
	
	
	@RequestMapping(value="searchpwd.do", method=RequestMethod.POST)
	public ModelAndView searchpwd(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		ModelAndView modelAndView = new ModelAndView();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");				// form ���� �Է��� ���� ����.
		String name = request.getParameter("name");
		String pwd_q = request.getParameter("pwd_q");
		String pwd_a = request.getParameter("pwd_a");
		
		
		MemberBean member = new MemberBean();
		member = this.memberService.getMemberInfo(id);		// DB�� ���̵� �´� �ʵ尡 �ִ��� �˻�
		
		if(member == null){		// ���̵� �ִ��� Ȯ�� ����
			out.println("<script>");
			out.println("alert('�Է��Ͻ� ���̵� �������� �ʽ��ϴ�.')");
			out.println("history.back()");
			out.println("</script>");
		}else if(member != null){
			if(!member.getName().equals(name)){
				out.println("<script>");
				out.println("alert('�Է��Ͻ� �̸��� ��ġ���� �ʽ��ϴ�.')");
				out.println("history.back()");
				out.println("</script>");
			}else if(!member.getPwd_q().equals(pwd_q) || !member.getPwd_a().equals(pwd_a)){
				out.println("<script>");
				out.println("alert('ȸ������ �� �ۼ��ߴ� ������ �亯�� ��ġ���� �ʽ��ϴ�.')");
				out.println("history.back()");
				out.println("</script>");
			}else{
				SimpleMailMessage msg = new SimpleMailMessage();		// ���Ϻ�����
				String email = member.getEmail1() + "@" + member.getEmail2();	// ������ �̸���
				msg.setFrom("settergetter1234@gmail.com");
				msg.setTo(email);
				msg.setSubject("SetterGetter ��ι�ȣ �ȳ���");
				msg.setText("����� ��й�ȣ�� [" + member.getPwd() + "] �Դϴ�.");
				this.mailSender.send(msg);
				
				out.println("<script>");
				out.println("alert('��й�ȣ�� E-MAIL�� ���������ϴ�.')");
				out.println("location='login.do'");
				out.println("</script>");		
			}
		}
		return null;
	}
	
/* =================== ��й�ȣ ã�� �� =================== */
}




