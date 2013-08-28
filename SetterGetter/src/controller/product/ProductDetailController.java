package controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CommentBean;
import model.MemberBean;
import model.OrderBean;
import model.ProductInsertBean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.CommentDao;
import dao.MemberDao;
import dao.ProductDao;

@Controller
public class ProductDetailController {

	private ProductDao productService;
	private CommentDao commentService;
	private MemberDao memberService;

	public void setMemberService(MemberDao memberService) {
		this.memberService = memberService;
	}

	public void setProductService(ProductDao productService) {
		this.productService = productService;
	}
	
	public void setCommentService(CommentDao commentService) {
		this.commentService = commentService;
	}
	/* ==============  페이징 관련  ============== */
	private final static int pageSize = 10;			// 한 페이지 당 보여줄 글 갯수
	private final static int pageGroupSize = 5;		// 페이지그룹안의 페이지 갯수
													// ex) [이전] 1 2 3 4 5 [다음]  일 경우 페이지 갯수는 5	
	
	/* 상품 상세보기 */
	@RequestMapping(value = "product_view.do", method = RequestMethod.GET)
	public ModelAndView product_view(HttpServletRequest request, HttpServletResponse respons, HttpSession session) throws Exception {
		
		String id = (String) session.getAttribute("id");	// 아이디 세션 값
		String pro_id = request.getParameter("pro_id");		// 해당 품목 id 값
		
		this.productService.updateHit(pro_id);			// 제품 조회수 증가	
		
		ProductInsertBean pro_bean = new ProductInsertBean();
		pro_bean = this.productService.getDetailInfo(pro_id);	// 제품에 대한 정보
		

		/* ===== 댓글달기 ===== */
		String no = request.getParameter("pageNum");
		if (no == null){
			no = "1";
		}
		
		int pageNum = Integer.parseInt(no);				// 현재 페이징유지 위한 번호
		int startRow = (pageNum - 1) * pageSize + 1;	// 한 페이지의 시작글 번호
		int endRow = pageNum * pageSize; 	// 한 페이지의 마지막 글 번호
		int count = 0;						// 총게시물 수 
		int number = 0;			// 총게시물 수 에서 해당 페이징의 마지막 게시물 수
		
		MemberBean infoName = new MemberBean();
		infoName = (MemberBean)this.memberService.getName(id);	// 회원이름 불러오기위한 메서드
		
		count = this.commentService.getTotalCnt(pro_id);	// 총게시물수 파악 DB
	
		List<CommentBean> commentList = new ArrayList<CommentBean>();  
		//DB 에서 게시판 내용을 가져 와 CommentBean 타입으로 가져온다.

		if(count > 0){
			if(endRow > count)
				endRow = count;
			
			Map<String, Object> pageRow = new HashMap<String, Object>();
			
				pageRow.put("startRow", startRow);
				pageRow.put("endRow", endRow);
				pageRow.put("pro_id", pro_id);
			
				commentList = this.commentService.commentListGet(pageRow);		// 현재 페이지에 해당하는 글 목록

		}else{
			commentList = null;
		}
		
		number = count - (pageNum - 1) * pageSize;		// 글목록에 표시할 글번호
		
		// 페이지 그룹의 갯수
		// ex) pageGroupSize 가 3일 경우 '[1][2][3]'가 pageGroupCount 개 만큼 있다.
		int pageGroupCount = count / (pageSize * pageGroupSize) + (count % (pageSize * pageGroupSize) == 0 ? 0 : 1);
		
		// 페이지그룹 번호
		// ex) pageGroupSize가 3일 경우 '[1][2][3]'의 페이지 그룹번호는 1이고 '[2][3][4]' 의 페이지그룹번호는 2이다.
		int numPageGroup = (int)Math.ceil((double)pageNum / pageGroupSize);
		
		// 오늘 날자 불러오기 위한 함수
		SimpleDateFormat day = new SimpleDateFormat("yyyy-MM-dd"); //yyyy-MM-dd HH:mm:ss 년-월-일-시간-분-초 출력 
		Date toDay = new Date(); 
		String nowDay = day.format(toDay);
		
					// 해당 뷰에서 사용할 속성
					request.setAttribute("startRow", new Integer(startRow));
					request.setAttribute("endRow", new Integer(endRow));
					request.setAttribute("count", new Integer(count));
					request.setAttribute("pageSize", new Integer(pageSize));
					request.setAttribute("number", new Integer(number));
					request.setAttribute("pageGroupSize", new Integer(pageGroupSize));
					request.setAttribute("numPageGroup", new Integer(numPageGroup));
					request.setAttribute("pageGroupCount", new Integer(pageGroupCount));
					request.setAttribute("pageNum", new Integer(pageNum));
					request.setAttribute("commentList", commentList);
					request.setAttribute("infoName", infoName);
					request.setAttribute("toDay", nowDay);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pro_bean", pro_bean);
		modelAndView.addObject("pro_id", pro_id);
		modelAndView.setViewName("product_view");
		session.setAttribute("id", id);

		return modelAndView;
	}
	
	/* 제품구매 */
	@RequestMapping(value = "product_view.do", method = RequestMethod.POST)
	public ModelAndView product_view_ok(HttpServletRequest request, HttpServletResponse respons, HttpSession session) throws Exception {
		respons.setContentType("text/html;charset=UTF-8");
		PrintWriter out = respons.getWriter();
		
		String id = (String) session.getAttribute("id");	
		String pro_id = request.getParameter("pro_id");
		int pro_count;
		
		try {
			pro_count = Integer.parseInt(request.getParameter("count"));
		} catch (Exception e) {
			pro_count = 0;
		}
		
		MemberBean user_bean = this.productService.getUserMethod(id); 
		ProductInsertBean pro_bean = this.productService.getDetailInfo(pro_id);	
		
		if(id == null){
			out.println("<script>");
			out.println("alert('로그인 하세요')");
			out.println("location='login.do'");
			out.println("</script>");
			return null;
		} else if(user_bean.getSection().equals("1")) {
			out.println("<script>");
			out.println("alert('구매자만 구매가능 합니다')");
			out.println("history.back()");
			out.println("</script>");
			return null;
		}
		
		OrderBean ob = new OrderBean();
		ob.setProduct_name(pro_bean.getPro_title());
		ob.setProduct_listImg(pro_bean.getPro_listImg());
		ob.setProduct_id(pro_bean.getPro_id());
		ob.setProduct_price(pro_bean.getPro_price());
		ob.setProduct_count(pro_count);
		ob.setCustomer_id(id);
		ob.setSeller_user(pro_bean.getUser_id());
		this.productService.setOrderBean(ob);
		
		List<Object> prolist = new ArrayList<Object>();
		prolist.add(ob);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("userlist", user_bean);
		mav.addObject("prolist", prolist);
		mav.addObject("cart_order_type", 2);		// 장바구니에서 주문 1, 바로직접구매 2
		mav.setViewName("product_view_ok");
		return mav;
	}
	
//	판매자 등록제품 상세정보
	@RequestMapping(value="product_insert_detail.do",method=RequestMethod.GET)
	public ModelAndView product_insert_detail(HttpServletRequest request,HttpServletResponse response , HttpSession session) throws IOException, SQLException{
		
		String id = (String) session.getAttribute("id");
		String pro_id = request.getParameter("id").trim();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		if(id == null){
			out.println("<script>");
			out.println("alert('로그인 하세요')");
			out.println("location='login.do'");
			out.println("</script>");
			return null;
		}else {
			
			List<ProductInsertBean> userlist = this.productService.getProductDetail(pro_id);
			ModelAndView mav = new ModelAndView();
			mav.addObject("userlist",userlist);
			mav.setViewName("product_insert_detail");
			return mav;
		}
	}

//	판매자 구매제품 상세정보
	@RequestMapping(value="buyer_product_detail.do",method=RequestMethod.GET)
	public ModelAndView buyer_product_detail(HttpServletRequest request,HttpServletResponse response , HttpSession session) throws IOException, SQLException{
		
		String id = (String) session.getAttribute("id");
		String pro_id = request.getParameter("pro_id").trim();
		String car_no = request.getParameter("car_no").trim();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		if(id == null){
			out.println("<script>");
			out.println("alert('로그인 하세요')");
			out.println("location='login.do'");
			out.println("</script>");
			return null;
		}
		
		OrderBean ob = this.productService.getOrderDate(car_no);
		ProductInsertBean pib = this.productService.getProductMethod(pro_id);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pro_bean",pib);
		mav.addObject("order_bean",ob);
		mav.setViewName("buyer_product_detail");
		return mav;
	}
	
//	�Ǹ��� ����Ȯ��
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
	
	/* 판매자 등록 신청 실패시 상세보기 */
	@RequestMapping(value="product_delete_detail.do",method=RequestMethod.GET)
	public ModelAndView product_delete_detail(HttpServletRequest request,HttpServletResponse response , HttpSession session) throws IOException, SQLException{

		String id = (String) session.getAttribute("id");
		String pro_id = request.getParameter("id").trim();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		if(id == null){
			out.println("<script>");
			out.println("alert('로그인 하세요')");
			out.println("location='login.do'");
			out.println("</script>");
			return null;
		}

		List<ProductInsertBean> userlist = this.productService.getProductDetail(pro_id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("userlist",userlist);
		mav.setViewName("product_delete_detail");
		return mav;
	}
	
	/* 평점 등록 */
	@RequestMapping(value = "product_comment.do", method = RequestMethod.POST)
	public ModelAndView product_comment(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws IOException, SQLException {
		ModelAndView modelAndView = new ModelAndView();
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		int pro_id = Integer.parseInt((String)request.getParameter("pro_id"));
		int pageNum = 0;
		if(request.getParameter("pageNum") == null){
			pageNum = 1;
			System.out.println("pageNum null : " + pageNum);
		}else{
			pageNum = Integer.parseInt((String)request.getParameter("pageNum"));
		}
		
		if((String) session.getAttribute("id") == null){
				out.println("<script>");
				out.println("alert('로그인하세요.')");
				out.println("location.href='login.do?pageNum=" + pageNum + "&pro_id=" + pro_id +"'");
				out.println("</script>");
				return null;
		}

		
		System.out.println("pageNum : " + pageNum);
		
		String id = (String) session.getAttribute("id");				int section = Integer.parseInt((String)session.getAttribute("section"));
		String name = request.getParameter("name").trim();				String cont = request.getParameter("cont").trim();
		int secret= Integer.parseInt((String)request.getParameter("secret"));
		int product_appraisal = Integer.parseInt((String)request.getParameter("appraisal"));	// 고객 평가
		int comment_select_no = 0;	// comment_select_no 답글 할때 필요한 번호 고유번호 sequence 번호와 같으면 됨. 
		int comment_level = 0; 		// 댓글 깊이
		int comment_no = 0; 		// 댓글 번호
		
		CommentBean commentBean = new CommentBean();
		
		commentBean.setProduct_id(pro_id);						commentBean.setComment_id(id);
		commentBean.setComment_section(section);				commentBean.setComment_name(name);
		commentBean.setComment_cont(cont);						commentBean.setComment_secret(secret); 	
		commentBean.setComment_select_no(comment_select_no);	commentBean.setComment_level(comment_level);
		commentBean.setComment_no(comment_no);					commentBean.setProduct_appraisal(product_appraisal);
		
		String commentList = request.getParameter("commentList");
		
		MemberBean infoName = new MemberBean();
		infoName = (MemberBean)this.memberService.getName(id);	// 회원이름 불러오기위한 메서드
		
		String org_name = infoName.getName();
		if(org_name.equals(name)==false){
			out.println("<script>");
			out.println("alert('이름이 다릅니다 다시입력하세요.')");
			out.println("history.back()");
			out.println("</script>");
			return null;
		}
		
		if(commentList.equals(null) == false){
//			int create_sequence = this.commentService.createSequence(commentBean);	// 상풍명에 해당하는 sequence 생성
		}
		
		int commentSave = this.commentService.insertComment(commentBean);
		
		if(commentSave == 1){
			out.println("<script>");
			out.println("alert('입력되었습니다.')");
			out.println("location.href='product_view.do?pageNum=" + pageNum + "&pro_id=" + pro_id +"'");
			out.println("</script>");
			return null;
		}
		
		return modelAndView;
	}
	/* 댓글 삭제 */
	@RequestMapping(value = "product_comment_del.do", method = RequestMethod.POST)
	public ModelAndView product_del(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws IOException, SQLException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		int pro_id = Integer.parseInt((String)request.getParameter("pro_id"));
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));	// 페이징 숫자 페이지 번호
		int no = Integer.parseInt(request.getParameter("no"));
		
		CommentBean comment_del = new CommentBean();

		comment_del.setNo(no);			comment_del.setProduct_id(pro_id);
		
		int comment_del_check = this.commentService.commentDel(comment_del);	// 삭제 메서드
		System.out.println("comment_del_check : " + comment_del_check);
		if(comment_del_check == 1){
			out.println("<script>");
			out.println("alert('삭제 되었습니다.')");
			out.println("location.href='product_view.do?pageNum=" + pageNum + "&pro_id=" + pro_id +"'");
			out.println("</script>");
			return null;
		}
		
		return null;
	}
	
}
