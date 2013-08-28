package controller.order;

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

import dao.CartDao;
import dao.MemberDao;
import dao.ProductDao;

@Controller
public class CartController {

	private MemberDao MemberService;

	public void setMemberService(MemberDao memberService) {
		MemberService = memberService;
	}

	private ProductDao productService;

	public void setProductService(ProductDao productService) {
		this.productService = productService;
	}

	private CartDao CartService; 

	public void setCartService(CartDao cartService) {
		CartService = cartService;
	}

	// -----------------------------
	// 장바구니 페이지 get 방식 요청
	// -----------------------------
	@RequestMapping(value = "cart.do", method = RequestMethod.GET)
	public ModelAndView cart(HttpServletResponse response,
			HttpServletRequest request, HttpSession session)
			throws IOException, SQLException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		ModelAndView modelAndView = new ModelAndView();

		String id = (String) session.getAttribute("id");
		MemberBean memberBean = this.MemberService.getMemberInfo(id); // id에
																		// 해당하는
																		// section(구매자/판매자)
																		// 값
		// 로그인이 유지 되지 않았을 경우
		if (id == null) {
			out.println("<script>");
			out.println("alert('로그인을 해주세요.')");
			out.println("location.href='login.do'");
			out.println("</script>");
		} else if (memberBean.getSection().equals("1")) { // 판매자일 경우
			out.println("<script>");
			out.println("alert('구매자 사용자만 이용가능합니다.')");
			out.println("history.back()");
			out.println("</script>");
		} else if (id != null && memberBean.getSection().equals("0")) { // 구매자일
																		// 경우
			List<OrderBean> usercart_list = new ArrayList<OrderBean>();
			usercart_list = this.CartService.getUserCartInfo(id); // id 에 맞는
																	// 장바구니 정보
																	// 가져옴

			int id_count = this.CartService.getUserCartTotal(id); // 장바구니에 담겨져있는
																	
//			System.out.println("장바구니 물품 갯수 get =" + id_count);		// 갯수
			int sum = 0;
			for(OrderBean bean : usercart_list){
				sum += (bean.getProduct_count() * bean.getProduct_price());
			}

			modelAndView.setViewName("cart_view");
			modelAndView.addObject("usercart_list", usercart_list);
			modelAndView.addObject("id_count", id_count);
			modelAndView.addObject("sum", sum);		// 총 금액
			return modelAndView;
		}

		return null;
	}

	// ---------------------
	// 카트에 해당 물품 담기
	// ---------------------
	@RequestMapping(value = "cart.do", method = RequestMethod.POST)
	public ModelAndView cart(HttpServletRequest request,
			HttpServletResponse response, HttpSession session)
			throws IOException, SQLException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=utf-8");

		String id = (String) session.getAttribute("id"); // 구매자 id
		String pro_id = request.getParameter("pro_id"); // 제품 id

		MemberBean memberBean = this.MemberService.getMemberInfo(id); // id에
																		// 해당하는
																		// section(구매자/판매자)
																		// 값

		// System.out.println("아이디값 : " + id);
		// System.out.println("제품번호값 : " + pro_id);
		// System.out.println("SECTION 값 : " + memberBean.getSection());

		// 로그인이 유지 되지 않았을 경우
		if (id == null) {
			out.println("<script>");
			out.println("alert('로그인을 해주세요.')");
			out.println("location.href='login.do'");
			out.println("</script>");
		} else if (memberBean.getSection().equals("1")) { // 판매자일 경우
			out.println("<script>");
			out.println("alert('구매자 사용자만 이용가능합니다.')");
			out.println("history.back()");
			out.println("</script>");
		} else if (id != null && memberBean.getSection().equals("0")) { // 구매자일
																		// 경우

			ProductInsertBean product_bean = this.productService
					.getDetailInfo(pro_id); // 물품 아이디 정보
			MemberBean member_bean = this.MemberService.getMemberInfo(id); // 회원
																			// 아이디
																			// 정보

			OrderBean order_bean = new OrderBean();
			order_bean.setCustomer_id(member_bean.getId()); // 사용자 아이디
			order_bean.setProduct_id(product_bean.getPro_id()); // 물품 아이디
			order_bean.setProduct_listImg(product_bean.getPro_listImg()); // 물품
																			// 이미지
			order_bean.setProduct_name(product_bean.getPro_title()); // 물품 이름
			order_bean.setProduct_price(product_bean.getUser_price()); // 물품 가격
			int count = Integer.parseInt(request.getParameter("count")); // 물품수량
			order_bean.setProduct_count(count); // 물품수량
			order_bean.setSeller_user(product_bean.getUser_id());	// 판매자 아이디
			order_bean.setBuy_and_cart("N");

			/* 저장할 때 중복된 물품이 있을 경우 */
			int result = 0;
			result = this.CartService.checkCartInfo(order_bean); // 중복물품 있을 시 :
																	// 1, 없을 시 :
																	// 0 반환

			System.out.println("result 값 : " + result);

			if (result > 0) {
				this.CartService.addCartProduct(order_bean); // 물품 수량만 수정

			} else if (result == 0) {
				this.CartService.insertCartInfo(order_bean); // 장바구니 정보 DB에 저장.
			}
			/* */

			int id_count = this.CartService.getUserCartTotal(id); // 장바구니에 담겨져있는

			System.out.println("장바구니 물품 갯수 post =" + id_count);			// 갯수

			List<OrderBean> usercart_list = new ArrayList<OrderBean>();
			usercart_list = this.CartService.getUserCartInfo(id); // id 에 맞는
																	// 장바구니 정보
																	// 가져옴

//			for (OrderBean bean : usercart_list) {
//				System.out.println("번호 : " + bean.getOrder_no() + "id : "
//						+ bean.getCustomer_id() + "물품이름 : "
//						+ bean.getProduct_name());
//			}
			int sum = 0;
			for(OrderBean bean : usercart_list){
				sum += (bean.getProduct_count() * bean.getProduct_price());
			}
				
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("usercart_list", usercart_list);
			modelAndView.addObject("id_count", id_count);
			modelAndView.addObject("sum", sum);		// 총 금액
			modelAndView.setViewName("cart_view");

			return modelAndView;

		}
		return null;
	}

	// ------------------
	// 장바구니 물품 삭제
	// ------------------
	@RequestMapping(value = "cart_delete.do", method = RequestMethod.GET)
	public ModelAndView cart_delete(HttpServletRequest request,
			HttpServletResponse response, HttpSession session)
			throws IOException, SQLException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String id = (String) session.getAttribute("id");
		int order_no = Integer.parseInt(request.getParameter("order_no"));

		// System.out.println("id = " + id + " cart_no = " + cart_no);

		if (id == null) {
			out.println("<script>");
			out.println("alert('아이디 유지시간이 만료되었습니다. 로그인해주세요.')");
			out.println("location.href='login.do'");
			out.println("</script>");
		} else {

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			map.put("order_no", order_no);
			int result = this.CartService.cartOneDelete(map);

			if (result > 0) {
				out.println("<script>");
				out.println("alert('선택하신 물품이 삭제되었습니다.')");
				out.println("location.href='cart.do'");
				out.println("</script>");
			}
		}
		return null;
	}

	// -----------------------
	// 장바구니 물품 수량 변경
	// -----------------------
	@RequestMapping(value = "cart_countmodify.do", method = RequestMethod.GET)
	public ModelAndView cart_countmodify(HttpServletRequest request,
			HttpServletResponse response, HttpSession session)
			throws IOException, SQLException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String id = (String) session.getAttribute("id");

		if (id == null) {
			out.println("<script>");
			out.println("alert('아이디 유지시간이 만료되었습니다. 로그인해주세요.')");
			out.println("location.href='login.do'");
			out.println("</script>");
		} else if (id != null) {
			int order_no = Integer.parseInt(request.getParameter("order_no"));
			int product_count = Integer.parseInt(request
					.getParameter("product_count"));

			// System.out.println("해당 물품 신청 수량 : " +
			// cart_bean.getProduct_count());

			// 장바구니에 있는 물품 정보
			OrderBean cart_bean = new OrderBean();
			cart_bean = this.CartService.getCartProductInfo(order_no);

			System.out.println("해당 물품 신청 수량 : " + product_count);
			String pro_id = "" + cart_bean.getProduct_id(); // 해당 물품의
															// 아이디값(ProductInsertBean에서
															// 물품에 대한 모든 정보)

			// 물품에 대한 정보를 가져옴
			ProductInsertBean p_bean = new ProductInsertBean();
			p_bean = this.productService.getDetailInfo(pro_id);

			// System.out.println("해당 물품의 남은 수량 : " + p_bean.getPro_count());

			if (product_count > p_bean.getPro_count()) { // 신청 수량이 재고량보다 클 경우
				out.println("<script>");
				out.println("alert('현재 신청 가능한 최대 수량은 " + p_bean.getPro_count()
						+ "개 입니다.')");
				out.println("history.back()");
				out.println("</script>");
			} else if (product_count <= p_bean.getPro_count()) { // 재고가 같거나 더 많을
																	// 경우
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("order_no", order_no);
				map.put("product_count", product_count);
				int result = this.CartService.CartCountModify(map); // 신청 물량 수정

				if (result > 0) {
					out.println("<script>");
					out.println("alert('수정되었습니다. 장바구니로 이동합니다.')");
					out.println("location.href='cart.do'");
					out.println("</script>");
				} else {
					out.println("<script>");
					out.println("alert('오류가 발생했습니다. 다시 시도해주세요.')");
					out.println("history.back()");
					out.println("</script>");
				}
			}
		}

		return null;
	}

	// ------------------
	// 장바구니 선택물품 삭제
	// ------------------
	@RequestMapping(value = "cart_selectdelete.do", method = RequestMethod.POST)
	public ModelAndView cart_selectdelete(HttpServletRequest request,
			HttpServletResponse response, HttpSession session)
			throws IOException, SQLException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=utf-8");

		String id = (String) session.getAttribute("id");

		if (id == null) {
			out.println("<script>");
			out.println("alert('아이디 유지시간이 만료되었습니다. 로그인해주세요.')");
			out.println("location.href='login.do'");
			out.println("</script>");
		} else {

			String kkValue = request.getParameter("kkValue"); // ex) 형식 :
																// 키/키/키/키
			System.out.println("넘어온 문자열 값 : " + kkValue);

			String temp[] = {};
			for (int i = 0; i < kkValue.length(); i++) { // 키값을 배열에 저장
				temp = kkValue.split("/");
			}
			// System.out.println("사이즈 ::: "+temp.length);

			int result = 0;
			Map<String, Object> map = null;
			for (int i = 0; i < temp.length; i++) {
				map = new HashMap<String, Object>();
				map.put("id", id);
				map.put("order_no", temp[i]);
				result += this.CartService.cartOneDelete(map); // 각 키값에 대해 삭제
				map.clear();
			}

			if (result > 0) {
				out.println("<script>");
				out.println("alert('삭제되었습니다. 장바구니로 이동합니다.')");
				out.println("location.href='cart.do'");
				out.println("</script>");
			} else {
				out.println("<script>");
				out.println("alert('오류가 발생했습니다. 다시 시도해주세요.')");
				out.println("history.back()");
				out.println("</script>");
			}
		}

		return null;
	}

}
