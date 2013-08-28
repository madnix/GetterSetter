package controller.Admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberBean;
import model.OrderBean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.AdminDao;

@Controller
public class AdminUtilController {

	private AdminDao adminService;

	public void setAdminService(AdminDao adminService) {
		this.adminService = adminService;
	}
	
	private final static int pageSize = 5;			
	private final static int pageGroupSize = 5;
	
//	구매자 제품 구매 상세정보
	@RequestMapping(value="cuserdetaillistok.do",method=RequestMethod.GET)
	public ModelAndView cuserdetaillistok(HttpServletResponse response,HttpServletRequest request, HttpSession session) throws IOException, SQLException{
		
		String cuserid = request.getParameter("user_id");
		String id = (String) session.getAttribute("adminid");
		String pageNum = request.getParameter("pageNum");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		MemberBean usermassage = this.adminService.getAllUserList(cuserid);
		
		if(id == null){
			out.println("<script>");
			out.println("alert('로그인 하세요')");
			out.println("location='login.do'");
			out.println("</script>");
			return null;
		} 
		
		if(pageNum == null){
			pageNum = "1";
		}
		
		int currentPage = 0;
		try {
			currentPage = Integer.parseInt(pageNum);
		} catch (NumberFormatException e) {
			currentPage = 1;
		}
		int startRow = (currentPage - 1) * pageSize + 1;	
		int endRow = currentPage * pageSize; 	
		int count = 0;
		int number = 0;

		count = this.adminService.getAllProCont3(cuserid);
		List<OrderBean>allproduct = null;
		
		if(count > 0){
			if(endRow > count)
				endRow = count;
			
			Map<String, Object> pageRow = new HashMap<String, Object>();
			pageRow.put("startRow", startRow);
			pageRow.put("endRow", endRow);
			pageRow.put("id", cuserid);
			allproduct = this.adminService.getAllProductlist3(pageRow);
			
		}else{
			allproduct = null;
		}
		
		number = count - (currentPage - 1) * pageSize;		
		
		int pageGroupCount = count / (pageSize * pageGroupSize) + (count % (pageSize * pageGroupSize) == 0 ? 0 : 1);
		int numPageGroup = (int)Math.ceil((double)currentPage / pageGroupSize);
		
		request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow", new Integer(endRow));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("number", new Integer(number));
		request.setAttribute("pageGroupSize", new Integer(pageGroupSize));
		request.setAttribute("numPageGroup", new Integer(numPageGroup));
		request.setAttribute("pageGroupCount", new Integer(pageGroupCount));
		
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("usermassage",usermassage);
		mav.addObject("allproduct",allproduct);
		mav.setViewName("Admin/cuserdetaillistok");
		return mav;
	}
	
//	제품 구매 신청 결제확인
	@RequestMapping(value="checkoutdetailok.do",method=RequestMethod.GET)
	public void checkoutdetailok (HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException, SQLException{
		
		String id = (String) session.getAttribute("adminid");
		String cart_no = request.getParameter("cart_no");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(id == null){
			out.println("<script>");
			out.println("alert('로그인 하세요')");
			out.println("location='login.do'");
			out.println("</script>");
		}  else{
			this.adminService.updateDealCheck(cart_no);
			response.sendRedirect("admincuser.do");
		}
	}
	
//	관리자 회원 강제 탈퉤
	@RequestMapping(value="outmember.do",method=RequestMethod.GET)
	public void outmember(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, SQLException{
		
		String id = (String) session.getAttribute("adminid");
		String user_id = request.getParameter("user_id");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(id == null){
			out.println("<script>");
			out.println("alert('로그인 하세요')");
			out.println("location='login.do'");
			out.println("</script>");
		}  else{
			this.adminService.deleteMember(user_id);
			this.adminService.deleteOrder(user_id);
			
			response.sendRedirect("admincuser.do");
		}
		
	}
	
//	googluck
	@RequestMapping(value="insertproductok.do",method=RequestMethod.GET)
	public void insertproductok(HttpServletRequest request,HttpServletResponse response, HttpSession session) throws IOException, SQLException{

		String id = (String) session.getAttribute("adminid");
		String pro_id = request.getParameter("pro_id");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		if(id == null){
			out.println("<script>");
			out.println("alert('로그인 하세요')");
			out.println("location='login.do'");
			out.println("</script>");
		}  else {
			this.adminService.insertproductok(pro_id);
			
			response.sendRedirect("admincuser.do");
		}

	}
	
	@RequestMapping(value="receptproduct.do",method=RequestMethod.POST)
	public void receptproduct(HttpServletRequest request,HttpServletResponse response, HttpSession session) throws IOException, SQLException{

		String id = (String) session.getAttribute("adminid");
		String pro_id = request.getParameter("pro_id");
		String adminreply = request.getParameter("adminreply").trim();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		if(id == null){
			out.println("<script>");
			out.println("alert('로그인 하세요')");
			out.println("location='login.do'");
			out.println("</script>");
		} else{
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("pro_id", pro_id);
			map.put("adminreply", adminreply);
			this.adminService.receptproduct(map);
			
			response.sendRedirect("admincuser.do");
		}
	}
	
	@RequestMapping(value="deletesomedate.do",method=RequestMethod.GET)
	public void deletesomedate(HttpServletRequest request,HttpServletResponse response, HttpSession session) throws IOException, SQLException{

		String id = (String) session.getAttribute("adminid");
		String order_no = request.getParameter("order_no");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(id == null){
			out.println("<script>");
			out.println("alert('로그인 하세요')");
			out.println("location='login.do'");
			out.println("</script>");
		} else {
			this.adminService.deletesomedate(order_no);
			
			response.sendRedirect("admincuser.do");
		}
	}
	
}
