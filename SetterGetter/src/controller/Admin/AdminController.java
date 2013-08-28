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
import model.ProductInsertBean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.AdminDao;

@Controller
public class AdminController {

	private AdminDao adminService;

	public void setAdminService(AdminDao adminService) {
		this.adminService = adminService;
	}
	
	/* 판매자 리스트 */
	private final static int pageSize = 10;			
	private final static int pageGroupSize = 5;
	@RequestMapping(value="adminpuser.do",method=RequestMethod.GET)
	public ModelAndView adminpuser(HttpServletRequest request , HttpServletResponse response,HttpSession session) throws SQLException, IOException{
		
		String pageNum = request.getParameter("pageNum");
		
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

		count = this.adminService.getAdminTotalCont();
		List<MemberBean> puserList = new ArrayList<MemberBean>();
		
		if(count > 0){
			if(endRow > count)
				endRow = count;
			
			Map<String, Object> pageRow = new HashMap<String, Object>();
			pageRow.put("startRow", startRow);
			pageRow.put("endRow", endRow);
			puserList = this.adminService.selectAdminPage(pageRow);
			
		}else{
			puserList = null;
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
		mav.addObject("puserList",puserList);
		mav.setViewName("Admin/adminpuserlist");
		return mav;
	}
	
	/* 구매자 리스트 */
	@RequestMapping(value="admincuser.do",method=RequestMethod.GET)
	public ModelAndView admincuser(HttpServletRequest request , HttpServletResponse response,HttpSession session) throws SQLException, IOException{
		
		String pageNum = request.getParameter("pageNum");
		
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

		count = this.adminService.getAdminTotalCont2();
		List<MemberBean> cuserList = new ArrayList<MemberBean>();
		
		if(count > 0){
			if(endRow > count)
				endRow = count;
			
			Map<String, Object> pageRow = new HashMap<String, Object>();
			pageRow.put("startRow", startRow);
			pageRow.put("endRow", endRow);
			cuserList = this.adminService.selectAdminPage2(pageRow);
			
		}else{
			cuserList = null;
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
		mav.addObject("cuserList",cuserList);
		mav.setViewName("Admin/admincuserlist");
		return mav;
	}
	
	/* 제품리스트 */
	@RequestMapping(value="prolist.do",method=RequestMethod.GET)
	public ModelAndView prolist(HttpServletRequest request , HttpServletResponse response,HttpSession session) throws SQLException, IOException{
		
		String pageNum = request.getParameter("pageNum");
		
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

		count = this.adminService.getProCont();
		List<ProductInsertBean>proList = new ArrayList<ProductInsertBean>();
		
		if(count > 0){
			if(endRow > count)
				endRow = count;
			
			Map<String, Object> pageRow = new HashMap<String, Object>();
			pageRow.put("startRow", startRow);
			pageRow.put("endRow", endRow);
			proList = this.adminService.getProListMethod(pageRow);
			
		}else{
			proList = null;
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
		mav.addObject("proList",proList);
		mav.setViewName("Admin/proList");
		return mav;
	}
	
	/* 제품리스트 */
	@RequestMapping(value="rbox.do",method=RequestMethod.GET)
	public ModelAndView receptionbox(HttpServletRequest request , HttpServletResponse response,HttpSession session) throws SQLException, IOException{
		
		String pageNum = request.getParameter("pageNum");
		
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

		count = this.adminService.getRboxCont();
		List<ProductInsertBean>receptionList = new ArrayList<ProductInsertBean>();
		
		if(count > 0){
			if(endRow > count)
				endRow = count;
			
			Map<String, Object> pageRow = new HashMap<String, Object>();
			pageRow.put("startRow", startRow);
			pageRow.put("endRow", endRow);
			receptionList = this.adminService.getReceptionListMethod(pageRow);
			
		}else{
			receptionList = null;
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
		mav.addObject("receptionList",receptionList);
		mav.setViewName("Admin/receptionlist");
		return mav;
	}
	
	/* 제품리스트 */
	@RequestMapping(value="checkout.do",method=RequestMethod.GET)
	public ModelAndView checkout(HttpServletRequest request , HttpServletResponse response,HttpSession session) throws SQLException, IOException{
		
		String pageNum = request.getParameter("pageNum");
		
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

		count = this.adminService.getCheckOutCont();
		List<ProductInsertBean>receptionList = new ArrayList<ProductInsertBean>();
		
		if(count > 0){
			if(endRow > count)
				endRow = count;
			
			Map<String, Object> pageRow = new HashMap<String, Object>();
			pageRow.put("startRow", startRow);
			pageRow.put("endRow", endRow);
			receptionList = this.adminService.getCheckOutListMethod(pageRow);
			
		}else{
			receptionList = null;
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
		mav.addObject("receptionList",receptionList);
		mav.setViewName("Admin/chekcoutlist");
		return mav;
	}
}
