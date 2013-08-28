package controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ProductInsertBean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.ProductDao;

@Controller
public class ProductListController {

	private ProductDao productService;

	public void setProductService(ProductDao productService) {
		this.productService = productService;
	}
	
	private final static int pageSize = 12;
	private final static int pageGroupSize = 5;
	
	/* 상품 리스트 */
	@RequestMapping(value = "product_list.do", method = RequestMethod.GET)
	public ModelAndView product_list(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		ModelAndView modelAndView = new ModelAndView();
		
		String id = (String) session.getAttribute("id");
		int species = Integer.parseInt(request.getParameter("species_id"));		// 넘어온 종류
		
		String species_id="";
		switch (species) {
		case 1:
			species_id = "의류";
			break;
		case 2:
			species_id = "패션잡화";
			break;
		case 3:
			species_id = "식품";
			break;
		case 4:
			species_id = "생활";
			break;
		case 5:
			species_id = "가전";
			break;
		}
		
		
		/* 페이징 시작 */
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null){
			pageNum = "1";
		}
		
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1;	// 한 페이지의 시작글 번호
		int endRow = currentPage * pageSize; 	// 한 페이지의 마지막 글 번호
		int count = 0;
		int number = 0;
		
		List<ProductInsertBean> productList = new ArrayList<ProductInsertBean>();
	
//		count = 1000;
		count = this.productService.getTotalCnt(species_id);		// 전체 제품의 수
		
		if(count > 0){
			if(endRow > count)
				endRow = count;
			
			Map<String, Object> pageRow = new HashMap<String, Object>();
			pageRow.put("species", species_id);		// 제품 종류
			pageRow.put("startRow", startRow);
			pageRow.put("endRow", endRow);
//			articleList = this.BoardService.select(startRow, endRow);		// 현재 페이지에 해당하는 글 목록
			productList = this.productService.getProductInfo(pageRow);		
			
		}else{
			productList = null;
		}
		
		number = count - (currentPage - 1) * pageSize;		// 글목록에 표시할 글번호
		
		// 페이지그룹의 갯수
		// ex) pageGroupSize가 3일 경우 '[1][2][3]'가 pageGroupCount 개 만큼 있다.
		int pageGroupCount = count / (pageSize * pageGroupSize) + (count % (pageSize * pageGroupSize) == 0 ? 0 : 1);
		// 페이지 그룹 번호
		// ex) pageGroupSize가 3일 경우 '[1][2][3]'의 페이지그룹번호는 1이고 '[2][3][4]'의 페이지그룹번호는 2이다.
		int numPageGroup = (int)Math.ceil((double)currentPage / pageGroupSize);
		
		
		// 해당 뷰에서 사용할 속성
		request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow", new Integer(endRow));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("number", new Integer(number));
		request.setAttribute("pageGroupSize", new Integer(pageGroupSize));
		request.setAttribute("numPageGroup", new Integer(numPageGroup));
		request.setAttribute("pageGroupCount", new Integer(pageGroupCount));
		request.setAttribute("species", species);		// 해당 제품 번호
		request.setAttribute("productList", productList);		// 해당 제품 리스트
		session.setAttribute("id", id);		// id 세션 값 유지
			
		modelAndView.setViewName("product_list");
		return modelAndView;
	}
	
//	판매자 제품등록 목록보기
	private final static int pageSize2 = 10;
	@RequestMapping(value = "product_insert_list.do", method = RequestMethod.GET)
	public ModelAndView product_insert_list(HttpServletRequest request,
			HttpServletResponse response , HttpSession session) throws SQLException, IOException {
		String id = (String) session.getAttribute("id");
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

		if(pageNum == null){
			pageNum = "1";
		}

		int currentPage = 0;
		try {
			currentPage = Integer.parseInt(pageNum);
		} catch (NumberFormatException e) {
			currentPage = 1;
		}
		int startRow = (currentPage - 1) * pageSize2 + 1;	
		int endRow = currentPage * pageSize2; 	
		int count = 0;
		int number = 0;

		count = this.productService.getTotalCont(id);
		List<ProductInsertBean> articleList = new ArrayList<ProductInsertBean>();

		if(count > 0){
			if(endRow > count)
				endRow = count;

			Map<String, Object> pageRow = new HashMap<String, Object>();
			pageRow.put("startRow", startRow);
			pageRow.put("endRow", endRow);
			pageRow.put("user_id", id);
			articleList = this.productService.selectPage(pageRow);

		}else{
			articleList = null;
		}

		number = count - (currentPage - 1) * pageSize2;		

		int pageGroupCount = count / (pageSize2 * pageGroupSize) + (count % (pageSize2 * pageGroupSize) == 0 ? 0 : 1);
		int numPageGroup = (int)Math.ceil((double)currentPage / pageGroupSize);

		request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow", new Integer(endRow));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("pageSize", new Integer(pageSize2));
		request.setAttribute("number", new Integer(number));
		request.setAttribute("pageGroupSize", new Integer(pageGroupSize));
		request.setAttribute("numPageGroup", new Integer(numPageGroup));
		request.setAttribute("pageGroupCount", new Integer(pageGroupCount));

		ModelAndView mav = new ModelAndView();
		mav.addObject("insertList", articleList);
		mav.setViewName("product_insert_list");
		return mav;
	}

//	판매자 제품 구매 목록
	@RequestMapping(value="buyer_product_list.do",method=RequestMethod.GET)
	public ModelAndView buyer_product_list(HttpServletRequest request,HttpServletResponse response , HttpSession session) throws IOException, SQLException{

		String pageNum = request.getParameter("pageNum");
		String id = (String) session.getAttribute("id");
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
		int startRow = (currentPage - 1) * pageSize2 + 1;	
		int endRow = currentPage * pageSize2; 	
		int count = 0;
		int number = 0;

		count = this.productService.getCountForInput(id);
		List<ProductInsertBean> detailList = new ArrayList<ProductInsertBean>();

		if(count > 0){
			if(endRow > count)
				endRow = count;

			Map<String, Object> pageRow = new HashMap<String, Object>();
			pageRow.put("startRow", startRow);
			pageRow.put("endRow", endRow);
			pageRow.put("puser_id", id);
			detailList = this.productService.getProductOutputList(pageRow);

		}else{
			detailList = null;
		}

		number = count - (currentPage - 1) * pageSize2;		

		int pageGroupCount = count / (pageSize2 * pageGroupSize) + (count % (pageSize2 * pageGroupSize) == 0 ? 0 : 1);
		int numPageGroup = (int)Math.ceil((double)currentPage / pageGroupSize);

		request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow", new Integer(endRow));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("pageSize", new Integer(pageSize2));
		request.setAttribute("number", new Integer(number));
		request.setAttribute("pageGroupSize", new Integer(pageGroupSize));
		request.setAttribute("numPageGroup", new Integer(numPageGroup));
		request.setAttribute("pageGroupCount", new Integer(pageGroupCount));

		ModelAndView mav = new ModelAndView();
		mav.addObject("detailList", detailList);
		mav.setViewName("buyer_product_list");
		return mav;
	}
	
//	판매자 등록실패 리스트
	@RequestMapping(value="product_delete_list.do",method=RequestMethod.GET)
	public ModelAndView product_delete(HttpServletRequest request,HttpServletResponse response , HttpSession session) throws IOException, SQLException{

		String pageNum = request.getParameter("pageNum");
		String id = (String) session.getAttribute("id");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(id == null){
			out.println("<script>");
			out.println("alert('로그인 하세요')");
			out.println("location='login.do'");
			out.println("</script>");
			return null;
		}else{
			if(pageNum == null){
				pageNum = "1";
			}
			
			int currentPage = 0;
			try {
				currentPage = Integer.parseInt(pageNum);
			} catch (NumberFormatException e) {
				currentPage = 1;
			}
			int startRow = (currentPage - 1) * pageSize2 + 1;	
			int endRow = currentPage * pageSize2; 	
			int count = 0;
			int number = 0;
			
			count = this.productService.getCountForProduct(id);

			List<ProductInsertBean> deletepageing = new ArrayList<ProductInsertBean>();
			
			if(count > 0){
				if(endRow > count)
					endRow = count;
				
				Map<String, Object> pageRow = new HashMap<String, Object>();
				pageRow.put("startRow", startRow);
				pageRow.put("endRow", endRow);
				pageRow.put("user_id", id);
				deletepageing = this.productService.getProductList(pageRow);
				
			}else{
				deletepageing = null;
			}
			
			number = count - (currentPage - 1) * pageSize2;		
			
			int pageGroupCount = count / (pageSize2 * pageGroupSize) + (count % (pageSize2 * pageGroupSize) == 0 ? 0 : 1);
			int numPageGroup = (int)Math.ceil((double)currentPage / pageGroupSize);
			
			request.setAttribute("currentPage", new Integer(currentPage));
			request.setAttribute("startRow", new Integer(startRow));
			request.setAttribute("endRow", new Integer(endRow));
			request.setAttribute("count", new Integer(count));
			request.setAttribute("pageSize", new Integer(pageSize2));
			request.setAttribute("number", new Integer(number));
			request.setAttribute("pageGroupSize", new Integer(pageGroupSize));
			request.setAttribute("numPageGroup", new Integer(numPageGroup));
			request.setAttribute("pageGroupCount", new Integer(pageGroupCount));

			ModelAndView mav = new ModelAndView();
			mav.addObject("deletepageing", deletepageing);
			mav.setViewName("product_delete_list");
			return mav;
		}
	}
}
