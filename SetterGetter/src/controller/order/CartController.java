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
	// ��ٱ��� ������ get ��� ��û
	// -----------------------------
	@RequestMapping(value = "cart.do", method = RequestMethod.GET)
	public ModelAndView cart(HttpServletResponse response,
			HttpServletRequest request, HttpSession session)
			throws IOException, SQLException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		ModelAndView modelAndView = new ModelAndView();

		String id = (String) session.getAttribute("id");
		MemberBean memberBean = this.MemberService.getMemberInfo(id); // id��
																		// �ش��ϴ�
																		// section(������/�Ǹ���)
																		// ��
		// �α����� ���� ���� �ʾ��� ���
		if (id == null) {
			out.println("<script>");
			out.println("alert('�α����� ���ּ���.')");
			out.println("location.href='login.do'");
			out.println("</script>");
		} else if (memberBean.getSection().equals("1")) { // �Ǹ����� ���
			out.println("<script>");
			out.println("alert('������ ����ڸ� �̿밡���մϴ�.')");
			out.println("history.back()");
			out.println("</script>");
		} else if (id != null && memberBean.getSection().equals("0")) { // ��������
																		// ���
			List<OrderBean> usercart_list = new ArrayList<OrderBean>();
			usercart_list = this.CartService.getUserCartInfo(id); // id �� �´�
																	// ��ٱ��� ����
																	// ������

			int id_count = this.CartService.getUserCartTotal(id); // ��ٱ��Ͽ� ������ִ�
																	
//			System.out.println("��ٱ��� ��ǰ ���� get =" + id_count);		// ����
			int sum = 0;
			for(OrderBean bean : usercart_list){
				sum += (bean.getProduct_count() * bean.getProduct_price());
			}

			modelAndView.setViewName("cart_view");
			modelAndView.addObject("usercart_list", usercart_list);
			modelAndView.addObject("id_count", id_count);
			modelAndView.addObject("sum", sum);		// �� �ݾ�
			return modelAndView;
		}

		return null;
	}

	// ---------------------
	// īƮ�� �ش� ��ǰ ���
	// ---------------------
	@RequestMapping(value = "cart.do", method = RequestMethod.POST)
	public ModelAndView cart(HttpServletRequest request,
			HttpServletResponse response, HttpSession session)
			throws IOException, SQLException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=utf-8");

		String id = (String) session.getAttribute("id"); // ������ id
		String pro_id = request.getParameter("pro_id"); // ��ǰ id

		MemberBean memberBean = this.MemberService.getMemberInfo(id); // id��
																		// �ش��ϴ�
																		// section(������/�Ǹ���)
																		// ��

		// System.out.println("���̵� : " + id);
		// System.out.println("��ǰ��ȣ�� : " + pro_id);
		// System.out.println("SECTION �� : " + memberBean.getSection());

		// �α����� ���� ���� �ʾ��� ���
		if (id == null) {
			out.println("<script>");
			out.println("alert('�α����� ���ּ���.')");
			out.println("location.href='login.do'");
			out.println("</script>");
		} else if (memberBean.getSection().equals("1")) { // �Ǹ����� ���
			out.println("<script>");
			out.println("alert('������ ����ڸ� �̿밡���մϴ�.')");
			out.println("history.back()");
			out.println("</script>");
		} else if (id != null && memberBean.getSection().equals("0")) { // ��������
																		// ���

			ProductInsertBean product_bean = this.productService
					.getDetailInfo(pro_id); // ��ǰ ���̵� ����
			MemberBean member_bean = this.MemberService.getMemberInfo(id); // ȸ��
																			// ���̵�
																			// ����

			OrderBean order_bean = new OrderBean();
			order_bean.setCustomer_id(member_bean.getId()); // ����� ���̵�
			order_bean.setProduct_id(product_bean.getPro_id()); // ��ǰ ���̵�
			order_bean.setProduct_listImg(product_bean.getPro_listImg()); // ��ǰ
																			// �̹���
			order_bean.setProduct_name(product_bean.getPro_title()); // ��ǰ �̸�
			order_bean.setProduct_price(product_bean.getUser_price()); // ��ǰ ����
			int count = Integer.parseInt(request.getParameter("count")); // ��ǰ����
			order_bean.setProduct_count(count); // ��ǰ����
			order_bean.setSeller_user(product_bean.getUser_id());	// �Ǹ��� ���̵�
			order_bean.setBuy_and_cart("N");

			/* ������ �� �ߺ��� ��ǰ�� ���� ��� */
			int result = 0;
			result = this.CartService.checkCartInfo(order_bean); // �ߺ���ǰ ���� �� :
																	// 1, ���� �� :
																	// 0 ��ȯ

			System.out.println("result �� : " + result);

			if (result > 0) {
				this.CartService.addCartProduct(order_bean); // ��ǰ ������ ����

			} else if (result == 0) {
				this.CartService.insertCartInfo(order_bean); // ��ٱ��� ���� DB�� ����.
			}
			/* */

			int id_count = this.CartService.getUserCartTotal(id); // ��ٱ��Ͽ� ������ִ�

			System.out.println("��ٱ��� ��ǰ ���� post =" + id_count);			// ����

			List<OrderBean> usercart_list = new ArrayList<OrderBean>();
			usercart_list = this.CartService.getUserCartInfo(id); // id �� �´�
																	// ��ٱ��� ����
																	// ������

//			for (OrderBean bean : usercart_list) {
//				System.out.println("��ȣ : " + bean.getOrder_no() + "id : "
//						+ bean.getCustomer_id() + "��ǰ�̸� : "
//						+ bean.getProduct_name());
//			}
			int sum = 0;
			for(OrderBean bean : usercart_list){
				sum += (bean.getProduct_count() * bean.getProduct_price());
			}
				
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("usercart_list", usercart_list);
			modelAndView.addObject("id_count", id_count);
			modelAndView.addObject("sum", sum);		// �� �ݾ�
			modelAndView.setViewName("cart_view");

			return modelAndView;

		}
		return null;
	}

	// ------------------
	// ��ٱ��� ��ǰ ����
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
			out.println("alert('���̵� �����ð��� ����Ǿ����ϴ�. �α������ּ���.')");
			out.println("location.href='login.do'");
			out.println("</script>");
		} else {

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			map.put("order_no", order_no);
			int result = this.CartService.cartOneDelete(map);

			if (result > 0) {
				out.println("<script>");
				out.println("alert('�����Ͻ� ��ǰ�� �����Ǿ����ϴ�.')");
				out.println("location.href='cart.do'");
				out.println("</script>");
			}
		}
		return null;
	}

	// -----------------------
	// ��ٱ��� ��ǰ ���� ����
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
			out.println("alert('���̵� �����ð��� ����Ǿ����ϴ�. �α������ּ���.')");
			out.println("location.href='login.do'");
			out.println("</script>");
		} else if (id != null) {
			int order_no = Integer.parseInt(request.getParameter("order_no"));
			int product_count = Integer.parseInt(request
					.getParameter("product_count"));

			// System.out.println("�ش� ��ǰ ��û ���� : " +
			// cart_bean.getProduct_count());

			// ��ٱ��Ͽ� �ִ� ��ǰ ����
			OrderBean cart_bean = new OrderBean();
			cart_bean = this.CartService.getCartProductInfo(order_no);

			System.out.println("�ش� ��ǰ ��û ���� : " + product_count);
			String pro_id = "" + cart_bean.getProduct_id(); // �ش� ��ǰ��
															// ���̵�(ProductInsertBean����
															// ��ǰ�� ���� ��� ����)

			// ��ǰ�� ���� ������ ������
			ProductInsertBean p_bean = new ProductInsertBean();
			p_bean = this.productService.getDetailInfo(pro_id);

			// System.out.println("�ش� ��ǰ�� ���� ���� : " + p_bean.getPro_count());

			if (product_count > p_bean.getPro_count()) { // ��û ������ ������� Ŭ ���
				out.println("<script>");
				out.println("alert('���� ��û ������ �ִ� ������ " + p_bean.getPro_count()
						+ "�� �Դϴ�.')");
				out.println("history.back()");
				out.println("</script>");
			} else if (product_count <= p_bean.getPro_count()) { // ��� ���ų� �� ����
																	// ���
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("order_no", order_no);
				map.put("product_count", product_count);
				int result = this.CartService.CartCountModify(map); // ��û ���� ����

				if (result > 0) {
					out.println("<script>");
					out.println("alert('�����Ǿ����ϴ�. ��ٱ��Ϸ� �̵��մϴ�.')");
					out.println("location.href='cart.do'");
					out.println("</script>");
				} else {
					out.println("<script>");
					out.println("alert('������ �߻��߽��ϴ�. �ٽ� �õ����ּ���.')");
					out.println("history.back()");
					out.println("</script>");
				}
			}
		}

		return null;
	}

	// ------------------
	// ��ٱ��� ���ù�ǰ ����
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
			out.println("alert('���̵� �����ð��� ����Ǿ����ϴ�. �α������ּ���.')");
			out.println("location.href='login.do'");
			out.println("</script>");
		} else {

			String kkValue = request.getParameter("kkValue"); // ex) ���� :
																// Ű/Ű/Ű/Ű
			System.out.println("�Ѿ�� ���ڿ� �� : " + kkValue);

			String temp[] = {};
			for (int i = 0; i < kkValue.length(); i++) { // Ű���� �迭�� ����
				temp = kkValue.split("/");
			}
			// System.out.println("������ ::: "+temp.length);

			int result = 0;
			Map<String, Object> map = null;
			for (int i = 0; i < temp.length; i++) {
				map = new HashMap<String, Object>();
				map.put("id", id);
				map.put("order_no", temp[i]);
				result += this.CartService.cartOneDelete(map); // �� Ű���� ���� ����
				map.clear();
			}

			if (result > 0) {
				out.println("<script>");
				out.println("alert('�����Ǿ����ϴ�. ��ٱ��Ϸ� �̵��մϴ�.')");
				out.println("location.href='cart.do'");
				out.println("</script>");
			} else {
				out.println("<script>");
				out.println("alert('������ �߻��߽��ϴ�. �ٽ� �õ����ּ���.')");
				out.println("history.back()");
				out.println("</script>");
			}
		}

		return null;
	}

}
