package controller.main;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductInsertBean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.ProductDao;

@Controller
public class MainController {

	private ProductDao productService;

	public void setProductService(ProductDao productService) {
		this.productService = productService;
	}

	public List<ProductInsertBean> pro_list = new ArrayList<ProductInsertBean>();

	@RequestMapping(value = "main.do", method = RequestMethod.GET)
	public ModelAndView main(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		pro_list = this.productService.getRecentlyProduct();

		List<ProductInsertBean> pro_best = new ArrayList<ProductInsertBean>();
		pro_best = this.productService.getBestProduct();

		// 현재 가장 잘 팔리는 상품

		ProductInsertBean best_bean0 = pro_best.get(0);
		ProductInsertBean best_bean1 = pro_best.get(1);
		ProductInsertBean best_bean2 = pro_best.get(2);
		ProductInsertBean best_bean3 = pro_best.get(3);
		ProductInsertBean best_bean4 = pro_best.get(4);
		// 현재 들어온 새로운 상품
		ProductInsertBean pro_bean0 = pro_list.get(0);
		ProductInsertBean pro_bean1 = pro_list.get(1);
		ProductInsertBean pro_bean2 = pro_list.get(2);
		ProductInsertBean pro_bean3 = pro_list.get(3);
		ProductInsertBean pro_bean4 = pro_list.get(4);
		ProductInsertBean pro_bean5 = pro_list.get(5);
		ProductInsertBean pro_bean6 = pro_list.get(6);
		ProductInsertBean pro_bean7 = pro_list.get(7);
		ProductInsertBean pro_bean8 = pro_list.get(8);
		ProductInsertBean pro_bean9 = pro_list.get(9);
		ProductInsertBean pro_bean10 = pro_list.get(10);
		ProductInsertBean pro_bean11 = pro_list.get(11);
		ProductInsertBean pro_bean12 = pro_list.get(12);
		ProductInsertBean pro_bean13 = pro_list.get(13);
		ProductInsertBean pro_bean14 = pro_list.get(14);
		ProductInsertBean pro_bean15 = pro_list.get(15);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pro_bean0", pro_bean0);
		modelAndView.addObject("pro_bean1", pro_bean1);
		modelAndView.addObject("pro_bean2", pro_bean2);
		modelAndView.addObject("pro_bean3", pro_bean3);
		modelAndView.addObject("pro_bean4", pro_bean4);
		modelAndView.addObject("pro_bean5", pro_bean5);
		modelAndView.addObject("pro_bean6", pro_bean6);
		modelAndView.addObject("pro_bean7", pro_bean7);
		modelAndView.addObject("pro_bean8", pro_bean8);
		modelAndView.addObject("pro_bean9", pro_bean9);
		modelAndView.addObject("pro_bean10", pro_bean10);
		modelAndView.addObject("pro_bean11", pro_bean11);
		modelAndView.addObject("pro_bean12", pro_bean12);
		modelAndView.addObject("pro_bean13", pro_bean13);
		modelAndView.addObject("pro_bean14", pro_bean14);
		modelAndView.addObject("pro_bean15", pro_bean15);

		modelAndView.addObject("best_bean0", best_bean0);
		modelAndView.addObject("best_bean1", best_bean1);
		modelAndView.addObject("best_bean2", best_bean2);
		modelAndView.addObject("best_bean3", best_bean3);
		modelAndView.addObject("best_bean4", best_bean4);

		modelAndView.setViewName("main");

		return modelAndView;
	}

	/* =============== 구매자 마이페이지 =============== */
	@RequestMapping(value = "buyer_mypage.do", method = RequestMethod.GET)
	public ModelAndView buyer_mypage() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("buyer_mypage");

		return mav;
	}

	/* =============== 판매자 마이페이지 =============== */
	@RequestMapping(value = "seller_mypage.do", method = RequestMethod.GET)
	public ModelAndView seller_mypage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("seller_mypage");
		return mav;
	}
}
