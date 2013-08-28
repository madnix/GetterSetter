package controller.edit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberBean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.MemberDao;

@Controller
public class EditController {
	private MemberDao memberService;
	public void setMemberService(MemberDao memberService) {
		this.memberService = memberService;
	}

/* ========================== 구매자 회원정보 수정 시작 ========================== */
	@RequestMapping(value="buyer_edit.do", method=RequestMethod.GET)
	public ModelAndView buyer_edit(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, SQLException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ModelAndView modelAndView = new ModelAndView();

		String id = (String) session.getAttribute("id");		// session id 값 
		if(id == null){		// 로그인 유지 X
			out.println("<script>");
			out.println("alert('로그인정보를 잃었습니다.')");
			out.println("location='login.do'");
			out.println("</script>");
		}else{	// 로그인 유지 O
			MemberBean bean = new MemberBean();
			bean = this.memberService.getMemberInfo(id);
			
			session.setAttribute("id", id);
			modelAndView.addObject("bean", bean);		// 로그인 ID 회원정보를 넘겨줌
			modelAndView.setViewName("buyer_edit");		// 구매자회원수정창 호출
			return modelAndView;
		}
		
		return null;
	}
	
	@RequestMapping(value="buyeredit_ok.do", method=RequestMethod.POST)
	public ModelAndView buyer_edit_ok(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, SQLException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ModelAndView modelAndView = new ModelAndView();
		
		String session_id = (String) session.getAttribute("id");
		MemberBean beforBean = this.memberService.getMemberInfo(session_id);	// 기존 DB의 회원 정보
		
		String id = request.getParameter("id");						String section = request.getParameter("section");
		String p_check = request.getParameter("p_check");	String pwd = request.getParameter("pwd");					String pwd_q = request.getParameter("pwd_q");
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
	
		MemberBean afterBean = new MemberBean();
		afterBean.setId(id);					afterBean.setSection(section);			afterBean.setPwd(pwd);
		afterBean.setPwd_q(pwd_q);				afterBean.setPwd_a(pwd_a);				afterBean.setName(name);
		afterBean.setZip1(zip1);				afterBean.setZip2(zip2);				afterBean.setAddr1(addr1);
		afterBean.setAddr2(addr2);				afterBean.setTel1(tel1);				afterBean.setTel2(tel2);
		afterBean.setTel3(tel3);				afterBean.setPhone1(phone1);			afterBean.setPhone2(phone2);
		afterBean.setPhone3(phone3);			afterBean.setEmail1(email1);			afterBean.setEmail2(email2);
		afterBean.setBirth1(birth1);			afterBean.setBirth2(birth2);			afterBean.setBirth3(birth3);
		afterBean.setWedding1(wedding1);		afterBean.setWedding2(wedding2);		afterBean.setWedding3(wedding3);
		afterBean.setWifebirth1(wifebirth1);	afterBean.setWifebirth2(wifebirth2);	afterBean.setWifebirth3(wifebirth3);
		afterBean.setLocation(location);

		if( session_id == null ){
			out.println("<script>");
			out.println("alert('로그인 정보를 잃었습니다.')");
			out.println("location='login.do'");
			out.println("</script>");
		}else if(!p_check.equals(beforBean.getPwd())){
			out.println("<script>");
			out.println("alert('기존 비밀번호가 일치하지 않습니다.')");
			out.println("history.back()");
			out.println("</script>");
		}else{
			int result = 0;
			result = this.memberService.editBuyerMember(afterBean);
			if(result == 0){
				out.println("<script>");
				out.println("alert('수정되지 않았습니다.')");
				out.println("history.back()");
				out.println("</script>");
			}else if( result == 1){
				out.println("<script>");
				out.println("alert('수정되었습니다.')");
				out.println("location='buyer_mypage.do'");
				out.println("</script>");
			}
		}
		return null;
	}
/* ========================== 구매자 회원정보 수정 끝 ========================== */
	
	
	
/* ========================== 구매자 회원정보 수정 시작 ========================== */
	@RequestMapping(value="seller_edit.do", method=RequestMethod.GET)
	public ModelAndView seller_edit(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, SQLException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ModelAndView modelAndView = new ModelAndView();

		String id = (String) session.getAttribute("id");		// session id 값 
		if(id == null){		// 로그인 유지 X
			out.println("<script>");
			out.println("alert('로그인정보를 잃었습니다.')");
			out.println("location='login.do'");
			out.println("</script>");
		}else{	// 로그인 유지 O
			MemberBean bean = new MemberBean();
			bean = this.memberService.getMemberInfo(id);
			
			session.setAttribute("id", id);
			modelAndView.addObject("bean", bean);		// 로그인 ID 회원정보를 넘겨줌
			modelAndView.setViewName("seller_edit");		// 구매자회원수정창 호출
			return modelAndView;
		}
		return null;
	}
	
	@RequestMapping(value="selleredit_ok.do", method=RequestMethod.POST)
	public ModelAndView seller_edit_ok(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, SQLException {
		ModelAndView modelAndView = new ModelAndView();
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String session_id = (String) session.getAttribute("id");
		MemberBean beforBean = this.memberService.getMemberInfo(session_id);	// 기존 DB의 회원 정보

		String id = request.getParameter("id");						String section = request.getParameter("section");
		String p_check = request.getParameter("p_check");			String pwd = request.getParameter("pwd");					String pwd_q = request.getParameter("pwd_q");
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

		MemberBean afterBean = new MemberBean();
		afterBean.setId(id);					afterBean.setSection(section);			afterBean.setPwd(pwd);
		afterBean.setPwd_q(pwd_q);				afterBean.setPwd_a(pwd_a);				afterBean.setName(name);
		afterBean.setZip1(zip1);				afterBean.setZip2(zip2);				afterBean.setAddr1(addr1);
		afterBean.setAddr2(addr2);				afterBean.setTel1(tel1);				afterBean.setTel2(tel2);
		afterBean.setTel3(tel3);				afterBean.setPhone1(phone1);			afterBean.setPhone2(phone2);
		afterBean.setPhone3(phone3);			afterBean.setEmail1(email1);			afterBean.setEmail2(email2);
		afterBean.setBirth1(birth1);			afterBean.setBirth2(birth2);			afterBean.setBirth3(birth3);
		afterBean.setWedding1(wedding1);		afterBean.setWedding2(wedding2);		afterBean.setWedding3(wedding3);
		afterBean.setWifebirth1(wifebirth1);	afterBean.setWifebirth2(wifebirth2);	afterBean.setWifebirth3(wifebirth3);
		afterBean.setLocation(location);
		afterBean.setCor(cor);					afterBean.setCor_name(cor_name);		afterBean.setCor_number(cor_number);
		afterBean.setCor_zip1(cor_zip1);		afterBean.setCor_zip2(cor_zip2);		afterBean.setCor_addr1(cor_addr1);
		afterBean.setCor_addr2(cor_addr2);		afterBean.setCor_tel1(cor_tel1);		afterBean.setCor_tel2(cor_tel2);
		afterBean.setCor_tel3(cor_tel3);		afterBean.setCor_fax1(cor_fax1);		afterBean.setCor_fax2(cor_fax2);
		afterBean.setCor_fax3(cor_fax3);		afterBean.setCor_mail1(cor_mail1);		afterBean.setCor_mail2(cor_mail2);

		if( session_id == null ){
			out.println("<script>");
			out.println("alert('로그인 정보를 잃었습니다.')");
			out.println("location='login.do'");
			out.println("</script>");
		}else if(!p_check.equals(beforBean.getPwd())){
			out.println("<script>");
			out.println("alert('기존 비밀번호가 일치하지 않습니다.')");
			out.println("history.back()");
			out.println("</script>");
		}else{
			int result = 0;
			result = this.memberService.editSellerMember(afterBean);
			if(result == 0){
				out.println("<script>");
				out.println("alert('수정되지 않았습니다.')");
				out.println("history.back()");
				out.println("</script>");
			}else if( result == 1){
				out.println("<script>");
				out.println("alert('수정되었습니다.')");
				out.println("location='seller_mypage.do'");
				out.println("</script>");
			}
		}
				
		return null;
	}
/* ========================== 구매자 회원정보 수정 끝 ========================== */
}
