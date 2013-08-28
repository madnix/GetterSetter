package controller.product;

import java.io.File;
import java.util.Calendar;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.OrderBean;
import model.ProductInsertBean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.ProductDao;
/*import model.ProductOutputBean;*/

@Controller
public class ProductInsertController {

	private ProductDao productService;

	public void setProductService(ProductDao productService) {
		this.productService = productService;
	}

	/* 惑前殿废 */
	@RequestMapping(value = "product_insert.do", method = RequestMethod.GET)
	public ModelAndView product_insert(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ModelAndView modelandviw = new ModelAndView();
		modelandviw.setViewName("product_insert");
		return modelandviw;
	}

	@RequestMapping(value = "product_insert.do", method = RequestMethod.POST)
	public void product_insert_ok(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ProductInsertBean pib = new ProductInsertBean();

		response.setContentType("text/html;charset=UTF-8");

		String saveFolder = "C:/oraclejava/MVC workspace/SetterGetter/WebContent/Upload";

		int fileSize = 5 * 800 * 600;
		MultipartRequest multi = new MultipartRequest(request, saveFolder,
				fileSize, "utf-8", new DefaultFileRenamePolicy());

		String user_id = multi.getParameter("user_id").trim();
		String pro_title = multi.getParameter("pro_title").trim();
		File pro_listImg = multi.getFile("listImg");
		File pro_detailTopImg = multi.getFile("detailTopImg");
		File pro_detaileImg = multi.getFile("detaileImg");
		String pro_cont = multi.getParameter("pro_cont").replaceAll("\n",
				"<br>");
		String species_id = multi.getParameter("species_id").trim();
		int pro_count = Integer
				.parseInt(multi.getParameter("pro_count").trim());
		int pro_price = Integer
				.parseInt(multi.getParameter("pro_price").trim());
		int user_price = Integer.parseInt(multi.getParameter("user_price")
				.trim());
		String pro_status = multi.getParameter("pro_status").trim();
		String pro_origin = multi.getParameter("pro_origin").trim();
		String pro_make = multi.getParameter("pro_make").trim();
		String pro_as = multi.getParameter("pro_as").trim();
		String pro_brand = multi.getParameter("pro_brand").trim();
		String pro_receipt = multi.getParameter("pro_receipt").trim();
		String pro_banknum = multi.getParameter("pro_banknum").trim();
		String pro_bank = multi.getParameter("pro_bank").trim();

		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);

		if(pro_listImg != null){
			
			String homeDir = saveFolder+"/"+year+"-"+month+"-"+day;
			File path = new File(homeDir);
			if(!path.exists()) path.mkdir();
			
			Random r = new Random();
			int random = r.nextInt(10000000);
			
			int listImgIndex = pro_listImg.getName().lastIndexOf(".");
			int detailTopImgIndex = pro_detailTopImg.getName().lastIndexOf(".");
			int detailImgIndex = pro_detaileImg.getName().lastIndexOf(".");
			String listImgFileExtension = pro_listImg.getName().substring(listImgIndex+1);
			String detailTopImgFileExtension = pro_detailTopImg.getName().substring(detailTopImgIndex+1);
			String detailImgFileExtension = pro_detaileImg.getName().substring(detailImgIndex+1);
			
			String lisImgRefileName = user_id+"-listimg-"+year+"-"+month+"-"+day+"-"+random+"."+listImgFileExtension;
			String detailTopImgefileName = user_id+"-detailTopImg-"+year+"-"+month+"-"+day+"-"+random+"."+detailTopImgFileExtension;
			String detailImgFefileName = user_id+"-detailImg-"+year+"-"+month+"-"+day+"-"+random+"."+detailImgFileExtension;
			
			String listImgFileDBName = "/" + year + "-" + month + "-" + day + "/"+lisImgRefileName;
			String detailTopImgFileDBName = "/" + year + "-" + month + "-" + day + "/"+detailTopImgefileName;
			String detailImgFileDBName = "/" + year + "-" + month + "-" + day + "/"+detailImgFefileName;
			
			pro_listImg.renameTo(new File(homeDir+"/"+lisImgRefileName));
			pro_detailTopImg.renameTo(new File(homeDir+"/"+detailTopImgefileName));
			pro_detaileImg.renameTo(new File(homeDir+"/"+detailImgFefileName));

			pib.setPro_listImg(listImgFileDBName);
			pib.setPro_detailTopImg(detailTopImgFileDBName);
			pib.setPro_detailImg(detailImgFileDBName);
		} 
		
		pib.setUser_id(user_id);
		pib.setPro_title(pro_title);
		pib.setPro_cont(pro_cont);
		pib.setSpecies_id(species_id);
		pib.setPro_count(pro_count);
		pib.setPro_price(pro_price);
		pib.setUser_price(user_price);
		pib.setPro_status(pro_status);
		pib.setPro_origin(pro_origin);
		pib.setPro_make(pro_make);
		pib.setPro_as(pro_as);
		pib.setPro_brand(pro_brand);
		pib.setPro_receipt(pro_receipt);
		pib.setPro_banknum(pro_banknum);
		pib.setPro_bank(pro_bank);
		
		this.productService.insertProduct(pib); 
		response.sendRedirect("seller_mypage.do");
	}
	
	/* 力前 备概脚没 */
	@RequestMapping(value = "product_order_insert.do", method = RequestMethod.POST)
	public ModelAndView product_view_ok(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws Exception {

		String cuser_id = (String) session.getAttribute("id");
		String pro_bankname = request.getParameter("bankname");
		String pro_bank = request.getParameter("bank");		
		String receiver_name = request.getParameter("recevier_name").trim();
		String zip1 = request.getParameter("zip1").trim();
		String zip2 = request.getParameter("zip2").trim();
		String tel1 = request.getParameter("tel1").trim();
		String tel2 = request.getParameter("tel2").trim();
		String tel3 = request.getParameter("tel3").trim();
		String addr1 = request.getParameter("addr1").trim();
		String addr2 = request.getParameter("addr2").trim();
		String recevier_help = request.getParameter("recevier_help").trim();
		
		OrderBean orderBean = this.productService.getOrderBean();
		OrderBean ob = new OrderBean();

		ob.setProduct_name(orderBean.getProduct_name());
		ob.setProduct_listImg(orderBean.getProduct_listImg());
		ob.setProduct_id(orderBean.getProduct_id());
		ob.setProduct_price(orderBean.getProduct_price());
		ob.setProduct_count(orderBean.getProduct_count());
		ob.setCustomer_id(orderBean.getCustomer_id());
		ob.setSeller_user(orderBean.getCustomer_id());
		ob.setCustomer_id(cuser_id);
		ob.setBuyer_name(pro_bankname);
		ob.setBuyer_bank(pro_bank);
		ob.setRecevier_name(receiver_name);
		ob.setRecevier_zip1(zip1);
		ob.setRecevier_zip2(zip2);
		ob.setRecevier_tel1(tel1);
		ob.setRecevier_tel2(tel2);
		ob.setRecevier_tel3(tel3);
		ob.setRecevier_addr1(addr1);
		ob.setRecevier_addr2(addr2);
		ob.setRecevier_help(recevier_help);
		
		this.productService.insertProductOrder(ob);

		response.sendRedirect("main.do");
		return null;
	}

}
