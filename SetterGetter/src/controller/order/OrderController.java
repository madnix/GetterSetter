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
	// ��ٱ��Ͽ��� ��ǰ �ֹ�(�ϳ�)
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
			out.println("alert('���̵� �����ð��� ����Ǿ����ϴ�. �α������ּ���.')");
			out.println("location.href='login.do'");
			out.println("</script>");
		}
		
		MemberBean user_bean = this.MemberService.getMemberInfo(id);		// ����� ����
		OrderBean order_bean = this.CartService.getCartProductInfo(order_no);	// ��ٱ��Ͽ� �ִ� ��ǰ����
		
		List<OrderBean> order_list = new ArrayList<OrderBean>();
		order_list.add(order_bean);
		
		modelAndView.addObject("userlist", user_bean);
		modelAndView.addObject("prolist", order_list);
		modelAndView.addObject("cart_order_type", 1);		// ��ٱ��Ͽ��� �ֹ� 1, �ٷ��������� 2
		modelAndView.addObject("kkValue", order_no);		// �ֹ� ��ǰ ��ȣ
		modelAndView.setViewName("product_view_ok");
		
		return modelAndView;
	}
	
	// ----------------------------
	// ��ٱ��Ͽ��� ��ǰ �ֹ�(�ټ�) 
	// ----------------------------
	@RequestMapping(value="cart_selectorder.do", method=RequestMethod.POST)
	public ModelAndView cart_selectorder(HttpServletResponse response,HttpServletRequest request, HttpSession session) throws IOException, SQLException{

		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		ModelAndView modelAndView = new ModelAndView();

		String id = (String) session.getAttribute("id");
		if (id == null) {
			out.println("<script>");
			out.println("alert('���̵� �����ð��� ����Ǿ����ϴ�. �α������ּ���.')");
			out.println("location.href='login.do'");
			out.println("</script>");
		}else{
			
			String kkValue = request.getParameter("kkValue");
			String temp[] = {};
			temp = kkValue.split("/");		// �ش� ��ٱ��� ��ȣ
			
			List<OrderBean> order_list = new ArrayList<OrderBean>();
			OrderBean order_bean = null;
			for(int i=0; i<temp.length; i++){		// ��ٱ��Ͽ��� �ֹ��� ��ǰ�鿡 ���� ����
				int order_no = Integer.parseInt(temp[i]);
				order_bean = this.CartService.getCartProductInfo(order_no);
				order_list.add(order_bean);
			}
			MemberBean user_bean = this.MemberService.getMemberInfo(id);	// ȸ�� ����
			
			modelAndView.addObject("userlist", user_bean);
			modelAndView.addObject("prolist", order_list);
			modelAndView.addObject("cart_order_type", 1);		// ��ٱ��Ͽ��� �ֹ� 1, �ٷ��������� 2
			modelAndView.addObject("kkValue", kkValue);			// ��ǰ ��ٱ��� ��ȣ(���ڿ�)
			modelAndView.setViewName("product_view_ok");
			return modelAndView;
		}

		return null;
	}
	
	// --------
	// ���Ž�û
	// --------
	@RequestMapping(value="order_ask.do", method=RequestMethod.POST)
	public ModelAndView order_ask(HttpServletResponse response,HttpServletRequest request, HttpSession session) throws IOException, SQLException{
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		int result = 0;
		
		String id = (String)session.getAttribute("id");
		
		if (id == null) {
			out.println("<script>");
			out.println("alert('���̵� �����ð��� ����Ǿ����ϴ�. �α������ּ���.')");
			out.println("location.href='login.do'");
			out.println("</script>");
		}else{
			int cart_order_type = Integer.parseInt(request.getParameter("cart_order_type"));		// ��ٱ��� 1, �ٷα��� 2
			
			String buyer_name = request.getParameter("bankname").trim();	// �Ա��ڸ�
			String buyer_bank = request.getParameter("bank").trim();		// �Ա��� �ŷ�����
			String buyer_banknumber = request.getParameter("banknumber").trim();	// �Ա��� ���¹�ȣ
			String recevier_name = request.getParameter("order_name").trim(); // �������̸�  
			String recevier_addr1 = request.getParameter("order_addr1").trim();; // �ּ�1   
			String recevier_addr2 = request.getParameter("order_addr2").trim();; // �ּ�2   
			String recevier_zip1 = request.getParameter("order_zip1").trim();; // �����ȣ1  
			String recevier_zip2 = request.getParameter("order_zip2").trim();; // �����ȣ2  
			String recevier_tel1 = request.getParameter("order_phone1").trim();; // ��ȭ��ȣ1  
			String recevier_tel2 = request.getParameter("order_phone2").trim();; // ��ȭ��ȣ2  
			String recevier_tel3 = request.getParameter("order_phone3").trim();; // ��ȭ��ȣ3  
			String recevier_help = request.getParameter("order_help").trim();; // ��۽ÿ�û����
			OrderBean orderBean = new OrderBean();
			orderBean.setBuyer_name(buyer_name);	orderBean.setBuyer_bank(buyer_bank);
			orderBean.setBuyer_banknumber(buyer_banknumber);	orderBean.setRecevier_name(recevier_name);
			orderBean.setRecevier_addr1(recevier_addr1);	orderBean.setRecevier_addr2(recevier_addr2);
			orderBean.setRecevier_zip1(recevier_zip1); orderBean.setRecevier_zip2(recevier_zip2);
			orderBean.setRecevier_tel1(recevier_tel1);	orderBean.setRecevier_tel2(recevier_tel2);	orderBean.setRecevier_tel3(recevier_tel3);
			orderBean.setRecevier_help(recevier_help);
			
			

			if(cart_order_type == 1){		// ��ٱ��Ͽ��� �ֹ��� ��
				String kkValue = request.getParameter("kkValue");
				String temp[] = {};
				temp = kkValue.split("/");		// ��ٱ��Ͽ��� �Ѿ�� ��ٱ��� ��ǰŰ��
				
				Map<String, Object> map = null;
				for(int i=0; i<temp.length; i++){
					map = new HashMap<String, Object>();
					map.put("orderBean", orderBean);	
					map.put("order_no", temp[i]);
					result = this.CartService.Order_dealcheck_Edit(map);
					map.clear();
				}
				
				// ��ٱ��Ͽ� �ִ� ���� buy_and_cart=Y �� ����
				for(int i=0; i<temp.length; i++){
					this.CartService.changeBuyCart(temp[i]);
				}
				
				
			}else if(cart_order_type == 2){		// �ٷα��ſ��� �ֹ��� ��
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
				
				// �ٷα����̿��ؼ� ��ǰ ����
				result = this.CartService.InsertOrderProduct(orderBean);				
			}
		}
		
		if(result > 0){
			out.println("<script>");
			out.println("alert('���Ž�û�� �Ϸ�Ǿ����ϴ�.')");
			out.println("location.href='order_ask_ok.do'");
			out.println("</script>");
		}else{
			out.println("<script>");
			out.println("alert('���� �� ������ �߻��߽��ϴ�. �ٽ� ���ּ���.')");
			out.println("history.back()");
			out.println("</script>");
		}
		return null;
	}
	
	
	// ------------
	// ���Ž�û�Ϸ�
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












