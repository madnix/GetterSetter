package controller.Admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberBean;
import model.OrderBean;
import model.ProductInsertBean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.AdminDao;

@Controller
public class AdminDetailController {

	private AdminDao adminService;

	public void setAdminService(AdminDao adminService) {
		this.adminService = adminService;
	}
	
	private final static int pageSize = 5;			
	private final static int pageGroupSize = 5;
	
//	관리자 내부 판매자 상세정보 및 등록제품 확인
	@RequestMapping(value="puserdetaillist.do",method=RequestMethod.GET)
	public ModelAndView puserdetaillist(HttpServletRequest request,HttpServletResponse response, HttpSession session) throws IOException, SQLException{
		
		String id = (String) session.getAttribute("adminid");
		String puserid = request.getParameter("user_id");
		String pageNum = request.getParameter("pageNum");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(id == null){
			out.println("<script>");
			out.println("alert('로그인 하세요')");
			out.println("location='login.do'");
			out.println("</script>");
			return null;
		} 
		
		MemberBean usermassage = this.adminService.getAllUserList(puserid);
		
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

		count = this.adminService.getAllProductCont(puserid);
		List<ProductInsertBean>allproduct = new ArrayList<ProductInsertBean>();
		
		if(count > 0){
			if(endRow > count)
				endRow = count;
			
			Map<String, Object> pageRow = new HashMap<String, Object>();
			pageRow.put("startRow", startRow);
			pageRow.put("endRow", endRow);
			pageRow.put("id", puserid);
			allproduct = this.adminService.getAllProductlist(pageRow);
			
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
		mav.setViewName("Admin/puserdetaillist");
		return mav;
	}
	
//	관리자 내부 구매자 상세보기 및 구매정보
	@RequestMapping(value="cuserdetaillist.do",method=RequestMethod.GET)
	public ModelAndView cuserdetaillist(HttpServletRequest request,HttpServletResponse response, HttpSession session) throws IOException, SQLException{
		
		String id = (String) session.getAttribute("adminid");
		String cuserid = request.getParameter("user_id");
		String pageNum = request.getParameter("pageNum");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(id == null){
			out.println("<script>");
			out.println("alert('로그인 하세요')");
			out.println("location='admin.do'");
			out.println("</script>");
			return null;
		}
		
		MemberBean usermassage = this.adminService.getAllUserList(cuserid);
		
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

		count = this.adminService.getAllProductCont2(cuserid);
		List<OrderBean>allproduct = null;
		
		if(count > 0){
			if(endRow > count)
				endRow = count;
			
			Map<String, Object> pageRow = new HashMap<String, Object>();
			pageRow.put("startRow", startRow);
			pageRow.put("endRow", endRow);
			pageRow.put("id", cuserid);
			allproduct = this.adminService.getAllProductlist2(pageRow);
			
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
	
//	등록 제품 상세보기
	@RequestMapping(value="productlistok.do",method=RequestMethod.GET)
	public ModelAndView productlistok(HttpServletRequest request,HttpServletResponse response, HttpSession session) throws SQLException, IOException{
	
		String pro_id = request.getParameter("pro_id");
		String pageNum = request.getParameter("pageNum");
		
		ProductInsertBean productMassage = this.adminService.getprolist(pro_id);
		
		String id = (String) session.getAttribute("adminid");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
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

		count = this.adminService.getProListokCont(pro_id);
		List<OrderBean>prolist = null;
		
		if(count > 0){
			if(endRow > count)
				endRow = count;
			
			Map<String, Object> pageRow = new HashMap<String, Object>();
			pageRow.put("startRow", startRow);
			pageRow.put("endRow", endRow);
			pageRow.put("id", pro_id);
			prolist = this.adminService.getProListOk(pageRow);
			
		}else{
			prolist = null;
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
		mav.addObject("productMassage",productMassage);
		mav.addObject("prolist",prolist);
		mav.setViewName("Admin/productlistok");
		return mav;
	}
	
	@RequestMapping(value="productlistok2.do",method=RequestMethod.GET)
	public ModelAndView productlistok2(HttpServletRequest request,HttpServletResponse response, HttpSession session) throws SQLException, IOException{
	
		String pro_id = request.getParameter("pro_id");
		String pageNum = request.getParameter("pageNum");
		
		ProductInsertBean productMassage = this.adminService.getprolist(pro_id);
		
		String id = (String) session.getAttribute("adminid");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
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

		count = this.adminService.getProListokCont2(pro_id);
		List<OrderBean>prolist = null;
		
		if(count > 0){
			if(endRow > count)
				endRow = count;
			
			Map<String, Object> pageRow = new HashMap<String, Object>();
			pageRow.put("startRow", startRow);
			pageRow.put("endRow", endRow);
			pageRow.put("id", pro_id);
			prolist = this.adminService.getProListOk2(pageRow);
			
		}else{
			prolist = null;
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
		mav.addObject("productMassage",productMassage);
		mav.addObject("prolist",prolist);
		mav.setViewName("Admin/productlistok2");
		return mav;
	}
	
//	관리자 제품 등록 신청 상세보기
	@RequestMapping(value="receptionlistdetail.do",method=RequestMethod.GET)
	public ModelAndView receptionlistdetail(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, SQLException{
		
		String pro_id = request.getParameter("pro_id");
		String id = (String) session.getAttribute("adminid");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(id == null){
			out.println("<script>");
			out.println("alert('로그인 하세요')");
			out.println("location='login.do'");
			out.println("</script>");
			return null;
		} 
		
		ProductInsertBean productMassage = this.adminService.getprolist(pro_id);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("productMassage",productMassage);
		mav.setViewName("Admin/receptiondetailList");
		return mav;
	}
	
//	관리자 제품 구매 신청 상세보기
	@RequestMapping(value="checkoutlistdetail.do",method=RequestMethod.GET)
	public ModelAndView checkoutlistdetail(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, SQLException{
		
		String pro_id = request.getParameter("pro_id");
		String cart_no = request.getParameter("cart_no");
		String id = (String) session.getAttribute("adminid");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(id == null){
			out.println("<script>");
			out.println("alert('로그인 하세요')");
			out.println("location='login.do'");
			out.println("</script>");
			return null;
		} 
		OrderBean ProductRegistration = this.adminService.getProductRegistration(cart_no);
		ProductInsertBean productMassage = this.adminService.getprolist(pro_id);
	
		ModelAndView mav = new ModelAndView();
		mav.addObject("productMassage",productMassage);
		mav.addObject("ProductRegistration",ProductRegistration);
		mav.setViewName("Admin/checkoutdetailList");
		return mav;
	}
	
//	관리자 제품/구매 상세보기 
	@RequestMapping(value="productdetailepage.do",method=RequestMethod.GET)
	public ModelAndView productdetailepage(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, SQLException{
		
		String pro_id = request.getParameter("pro_id");
		String order_no = request.getParameter("order_no");
		String id = (String) session.getAttribute("adminid");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(id == null){
			out.println("<script>");
			out.println("alert('로그인 하세요')");
			out.println("location='login.do'");
			out.println("</script>");
			return null;
		} 
		
		ProductInsertBean productMassage = this.adminService.getProductMethod(pro_id);
		OrderBean order = this.adminService.getOrderMethod(order_no);
	
		ModelAndView mav = new ModelAndView();
		mav.addObject("productMassage",productMassage);
		mav.addObject("order",order);
		mav.setViewName("Admin/productdetailepage");
		return mav;
	}
}
