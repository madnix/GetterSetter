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

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import utils.SqlMapLocator;

import dao.CartDao;
import dao.MemberDao;
import dao.ProductDao;

public class OrderController {
	

	private MemberDao MemberService;
	private CartDao CartService;
	private ProductDao ProductService;

	public void setMemberService(MemberDao memberService) {		MemberService = memberService;	}
	public void setProductService(ProductDao productService) {		ProductService = productService;	}
	public void setCartService(CartDao cartService) {		CartService = cartService;	}
	
	// ----------------------------
	// 장바구니에서 물품 주문(하나)
	// ----------------------------
	@RequestMapping(value="cart_order.do", method=RequestMethod.GET)
	public ModelAndView cart(HttpServletResponse response,HttpServletRequest request, HttpSession session) throws IOException, SQLException{
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		ModelAndView modelAndView = new ModelAndView();
		
		String id = (String) session.getAttribute("id");
		int order_no = Integer.parseInt(request.getParameter("order_no"));
		
		if (id == null) {
			out.println("<script>");
			out.println("alert('아이디 유지시간이 만료되었습니다. 로그인해주세요.')");
			out.println("location.href='login.do'");
			out.println("</script>");
		}
		
		MemberBean user_bean = this.MemberService.getMemberInfo(id);		// 사용자 정보
		OrderBean order_bean = this.CartService.getCartProductInfo(order_no);	// 장바구니에 있는 물품정보
		
		List<OrderBean> order_list = new ArrayList<OrderBean>();
		order_list.add(order_bean);
		
		modelAndView.addObject("userlist", user_bean);
		modelAndView.addObject("prolist", order_list);
		modelAndView.addObject("cart_order_type", 1);		// 장바구니에서 주문 1, 바로직접구매 2
		modelAndView.addObject("kkValue", order_no);		// 주문 상품 번호
		modelAndView.setViewName("product_view_ok");
		
		return modelAndView;
	}
	
	// ----------------------------
	// 장바구니에서 물품 주문(다수) 
	// ----------------------------
	@RequestMapping(value="cart_selectorder.do", method=RequestMethod.POST)
	public ModelAndView cart_selectorder(HttpServletResponse response,HttpServletRequest request, HttpSession session) throws IOException, SQLException{

		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		ModelAndView modelAndView = new ModelAndView();

		String id = (String) session.getAttribute("id");
		if (id == null) {
			out.println("<script>");
			out.println("alert('아이디 유지시간이 만료되었습니다. 로그인해주세요.')");
			out.println("location.href='login.do'");
			out.println("</script>");
		}else{
			
			String kkValue = request.getParameter("kkValue");
			String temp[] = {};
			temp = kkValue.split("/");		// 해당 장바구니 번호
			
			List<OrderBean> order_list = new ArrayList<OrderBean>();
			OrderBean order_bean = null;
			for(int i=0; i<temp.length; i++){		// 장바구니에서 주문한 물품들에 대한 정보
				int order_no = Integer.parseInt(temp[i]);
				order_bean = this.CartService.getCartProductInfo(order_no);
				order_list.add(order_bean);
			}
			MemberBean user_bean = this.MemberService.getMemberInfo(id);	// 회원 정보
			
			modelAndView.addObject("userlist", user_bean);
			modelAndView.addObject("prolist", order_list);
			modelAndView.addObject("cart_order_type", 1);		// 장바구니에서 주문 1, 바로직접구매 2
			modelAndView.addObject("kkValue", kkValue);			// 제품 장바구니 번호(문자열)
			modelAndView.setViewName("product_view_ok");
			return modelAndView;
		}

		return null;
	}
	
	// --------
	// 구매신청
	// --------
	@RequestMapping(value="order_ask.do", method=RequestMethod.POST)
	public ModelAndView order_ask(HttpServletResponse response,HttpServletRequest request, HttpSession session) throws IOException, SQLException{
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		int result = 0;
		
		String id = (String)session.getAttribute("id");
		
		if (id == null) {
			out.println("<script>");
			out.println("alert('아이디 유지시간이 만료되었습니다. 로그인해주세요.')");
			out.println("location.href='login.do'");
			out.println("</script>");
		}else{
			int cart_order_type = Integer.parseInt(request.getParameter("cart_order_type"));		// 장바구니 1, 바로구매 2
			
			String buyer_name = request.getParameter("bankname").trim();	// 입금자명
			String buyer_bank = request.getParameter("bank").trim();		// 입금자 거래은행
			String buyer_banknumber = request.getParameter("banknumber").trim();	// 입금자 계좌번호
			String recevier_name = request.getParameter("order_name").trim(); // 수취인이름  
			String recevier_addr1 = request.getParameter("order_addr1").trim();; // 주소1   
			String recevier_addr2 = request.getParameter("order_addr2").trim();; // 주소2   
			String recevier_zip1 = request.getParameter("order_zip1").trim();; // 우편번호1  
			String recevier_zip2 = request.getParameter("order_zip2").trim();; // 우편번호2  
			String recevier_tel1 = request.getParameter("order_phone1").trim();; // 전화번호1  
			String recevier_tel2 = request.getParameter("order_phone2").trim();; // 전화번호2  
			String recevier_tel3 = request.getParameter("order_phone3").trim();; // 전화번호3  
			String recevier_help = request.getParameter("order_help").trim();; // 배송시요청사항
			OrderBean orderBean = new OrderBean();
			orderBean.setBuyer_name(buyer_name);	orderBean.setBuyer_bank(buyer_bank);
			orderBean.setBuyer_banknumber(buyer_banknumber);	orderBean.setRecevier_name(recevier_name);
			orderBean.setRecevier_addr1(recevier_addr1);	orderBean.setRecevier_addr2(recevier_addr2);
			orderBean.setRecevier_zip1(recevier_zip1); orderBean.setRecevier_zip2(recevier_zip2);
			orderBean.setRecevier_tel1(recevier_tel1);	orderBean.setRecevier_tel2(recevier_tel2);	orderBean.setRecevier_tel3(recevier_tel3);
			orderBean.setRecevier_help(recevier_help);
			
			

			if(cart_order_type == 1){		// 장바구니에서 주문할 때
				String kkValue = request.getParameter("kkValue");
				String temp[] = {};
				temp = kkValue.split("/");		// 장바구니에서 넘어온 장바구니 제품키값
				
				Map<String, Object> map = null;
				for(int i=0; i<temp.length; i++){
					map = new HashMap<String, Object>();
					map.put("orderBean", orderBean);	
					map.put("order_no", temp[i]);
					result = this.CartService.Order_dealcheck_Edit(map);
					map.clear();
				}
				
				// 장바구니에 있는 물건 buy_and_cart=Y 로 변경
				for(int i=0; i<temp.length; i++){
					this.CartService.changeBuyCart(temp[i]);
				}
				
				
			}else if(cart_order_type == 2){		// 바로구매에서 주문할 때
				String customer_id = id;
				int product_id = Integer.parseInt(request.getParameter("product_id"));
				String product_listImg = request.getParameter("product_listImg");
				String product_name = request.getParameter("product_name");
				int product_price = Integer.parseInt(request.getParameter("product_price"));
				int product_count = Integer.parseInt(request.getParameter("product_count"));
				String seller_user = request.getParameter("seller_user");
System.out.println(seller_user);
				orderBean.setCustomer_id(customer_id);
				orderBean.setSeller_user(seller_user);
				orderBean.setProduct_id(product_id);
				orderBean.setProduct_listImg(product_listImg);
				orderBean.setProduct_name(product_name);
				orderBean.setProduct_price(product_price);
				orderBean.setProduct_count(product_count);
				
				// 바로구매이용해서 물품 구매
				result = this.CartService.InsertOrderProduct(orderBean);				
			}
		}
		
		if(result > 0){
			out.println("<script>");
			out.println("alert('구매신청이 완료되었습니다.')");
			out.println("location.href='order_ask_ok.do'");
			out.println("</script>");
		}else{
			out.println("<script>");
			out.println("alert('구매 중 오류가 발생했습니다. 다시 해주세요.')");
			out.println("history.back()");
			out.println("</script>");
		}
		return null;
	}
	
	
	// ------------
	// 구매신청완료
	// ------------
	@RequestMapping(value="order_ask_ok.do", method=RequestMethod.GET)
	public ModelAndView order_ask_ok(HttpServletResponse response,HttpServletRequest request, HttpSession session) throws IOException, SQLException{
		List<OrderBean> orderList = new ArrayList<OrderBean>();
		String id = (String)session.getAttribute("id");
		
		orderList = this.CartService.getOrderSearchList(id);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("orderList", orderList);
		modelAndView.setViewName("orderSearchList");
		
		return modelAndView;
	}
}












