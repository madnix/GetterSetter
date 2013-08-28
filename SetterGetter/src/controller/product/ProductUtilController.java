package controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.OrderBean;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.ProductDao;

public class ProductUtilController {

	private ProductDao productService;

	public void setProductService(ProductDao productService) {
		this.productService = productService;
	}
	
//	판매자 삭제 관리
	@RequestMapping(value="delelteproductok.do",method=RequestMethod.GET)
	public void delelteproductok (HttpServletRequest request,HttpServletResponse response,HttpSession session) throws SQLException, IOException{
		
		String id = (String) session.getAttribute("id");
		String pro_id = request.getParameter("pro_id").trim();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(id == null){
			out.println("<script>");
			out.println("alert('로그인 하세요')");
			out.println("location='login.do'");
			out.println("</script>");
		}else{
			this.productService.deleteproductok(pro_id);
			
			response.sendRedirect("product_delete_list.do");
		}

	}
	
	/* 판매자 삭제 신청 결과 유무 */
	@RequestMapping(value="product_application_delete.do",method=RequestMethod.GET)
	public void product_application_delete(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws SQLException, IOException{
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String id = (String) session.getAttribute("id");
		
		String pro_id = request.getParameter("id").trim();
		
		if(id == null){
			out.println("<script>");
			out.println("alert('로그인 하세요')");
			out.println("location='login.do'");
			out.println("</script>");
		}else {
			List<OrderBean> dateList = this.productService.getUserDate(pro_id);

			if(dateList.size() > 0){
				out.println("<script>");
				out.println("alert('삭제실패 거래중인 물품 입니다')");
				out.println("history.back()");
				out.println("</script>");
			}else {
				this.productService.updateProLevel(pro_id);			
				out.println("<script>");
				out.println("alert('삭제성공 했습니다')");
				out.println("location='product_insert_list.do'");
				out.println("</script>");
			}
		}
	}
	
//	판매자 제품 구매 확인
	@RequestMapping(value="buyer_product_detail_ok.do",method=RequestMethod.POST)
	public void buyer_product_detail_ok(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws SQLException, IOException{
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String id = (String) session.getAttribute("id");
		String car_no = request.getParameter("order_no");
		String pro_id = request.getParameter("pro_id");
		String pro_count = request.getParameter("pro_count");
		
		if(id == null){
			out.println("<script>");
			out.println("alert('로그인 하세요')");
			out.println("location='login.do'");
			out.println("</script>");
		}
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("pro_id", pro_id);
		map.put("pro_count", pro_count);

		this.productService.updateOrder_deal_check(car_no);
		this.productService.updateProduct_Ok(map);
		response.sendRedirect("main.do");
	}
}
