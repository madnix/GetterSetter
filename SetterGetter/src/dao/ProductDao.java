package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import model.MemberBean;
import model.OrderBean;
import model.ProductInsertBean;
import utils.SqlMapLocator;

/*import model.ProductOutputBean;*/

public class ProductDao {
	private OrderBean orderBean;

	public OrderBean getOrderBean() {
		return orderBean;
	}

	public void setOrderBean(OrderBean orderBean) {
		this.orderBean = orderBean;
	}

	/* ================== 물품등록 ===================== */
	public void insertProduct(ProductInsertBean pib) throws Exception {
		SqlMapLocator.getMapper().insert("insertproduct", pib);
	}

	/* ================ 물품등록 신청 ================== */
	@SuppressWarnings("unchecked")
	public List<ProductInsertBean> getProductInsertList(String id)
			throws SQLException {
		return SqlMapLocator.getMapper().queryForList(
				"resultproductinsertlist", id);
	}

	/* ===================== 등록물품 상세보기 ======================== */
	@SuppressWarnings("unchecked")
	public List<ProductInsertBean> getProductInsertDetailList(String id)
			throws SQLException {
		return SqlMapLocator.getMapper().queryForList("resultProdctDetail", id);
	}

	/* ================== 임시리스트 ========================= */
	@SuppressWarnings("unchecked")
	public List<ProductInsertBean> getList() throws SQLException {
		return SqlMapLocator.getMapper().queryForList("resultList");
	}

	/* ================== 아이디로 회원정보 반납 ============== */
	@SuppressWarnings("unchecked")
	public List<MemberBean> getUserListMethod(String id) throws Exception {
		return SqlMapLocator.getMapper().queryForList("getUserList", id);
	}

	/* ================ 조회수 증가 ==================== */
	public void updateHit(String id) throws SQLException {
		SqlMapLocator.getMapper().update("updateHit", id);
	}

	/* ====================== 상세정보 ===================== */
	@SuppressWarnings("unchecked")
	public List<ProductInsertBean> getProductDetail(String id)
			throws SQLException {
		return SqlMapLocator.getMapper().queryForList("resultProdctDetail", id);
	}

	/* ======================== 구매자 구매신청 관리자 확인 ============================= */
	@SuppressWarnings("unchecked")
	public List<ProductInsertBean> getProductDetailOk(String id)
			throws Exception {
		return SqlMapLocator.getMapper().queryForList("resultProductDetailOk",
				id);
	}

	/* ======================= 구매신청시 수량감소 ========================== */
	public void updateProCount(Map resultList) throws SQLException {
		SqlMapLocator.getMapper().update("updateprocount", resultList);
	}

	/* ======================= 거래성공시 거래수 증가 ====================== */
	public void updateProNum(String pro_id) throws SQLException {
		SqlMapLocator.getMapper().update("updatepronum", pro_id);
	}

	/* ======================== 거래성공시 유러레벌 수정 ==================== */
	public void updateUserLevel(String pro_out_id) throws SQLException {
		SqlMapLocator.getMapper().update("updateuserlevel", pro_out_id);
	}

	/* 해당 종류에 해당하는 제품 갯수 */
	public int getTotalCnt(String species) throws SQLException {
		return (Integer) SqlMapLocator.getMapper().queryForObject(
				"getTotalCnt", species);
	}

	/* 해당 종류에 해당하는 제품 리스트 */
	public List<ProductInsertBean> getProductInfo(Map<String, Object> pageRow)
			throws SQLException {
		return SqlMapLocator.getMapper()
				.queryForList("getProductInfo", pageRow);
	}

	/* 해당 아이디 값에 해당하는 제품 세부 정보 */
	public ProductInsertBean getDetailInfo(String pro_id) throws SQLException {
		return (ProductInsertBean) SqlMapLocator.getMapper().queryForObject(
				"getDetailInfo", pro_id);
	}

	/* 메인화면에서 최근에 들어온 제품 정보 가져오기 (최근날짜에 조회수 높은 순) */
	public List<ProductInsertBean> getRecentlyProduct() throws SQLException {
		return SqlMapLocator.getMapper().queryForList("getRecentlyProduct");
	}

	/* ===================== 제품 목록 보기 카운트 ================= */
	public int getTotalCont(String id) throws SQLException {
		return (Integer) SqlMapLocator.getMapper().queryForObject(
				"getTotalCont", id);
	}

	/* ===================== 제품 목록 보기 페이징 ================= */
	@SuppressWarnings("unchecked")
	public List<ProductInsertBean> selectPage(Map<String, Object> pageRow)
			throws SQLException {
		return SqlMapLocator.getMapper().queryForList("selectpage", pageRow);
	}

	/* ==================== 제품 구매 확인 카운트 ================= */
	public int getCountForInput(String id) throws SQLException {
		return (Integer) SqlMapLocator.getMapper().queryForObject(
				"getcountforinput", id);
	}

	/* ====================== 제품 구매 확인 페이징 =============== */
	@SuppressWarnings("unchecked")
	public List<ProductInsertBean> getProductOutputList(
			Map<String, Object> pageRow) throws SQLException {
		return SqlMapLocator.getMapper().queryForList("productoutputlist",
				pageRow);
	}

	/* ======================== 제품 등록 날짜 반납 ================ */
	@SuppressWarnings("unchecked")
	public List<ProductInsertBean> getDate(String id) throws SQLException {
		return SqlMapLocator.getMapper().queryForList("getTime", id);
	}

	/* ======================== 3일후 =============================== */
	public void updateProductLevel(Map<String, Object> updateOutput)
			throws SQLException {
		SqlMapLocator.getMapper().update("updateproductlevel", updateOutput);
	}

	/* ====================== 제품 등록 실패 카운트 =========================== */
	public int getCountForProduct(String id) throws SQLException {
		return (Integer) SqlMapLocator.getMapper().queryForObject(
				"resultcountforproduct", id);
	}

	/* ======================= 제품등록 실패 페이징 ==================== */
	@SuppressWarnings("unchecked")
	public List<ProductInsertBean> getProductList(Map<String, Object> pageRow)
			throws SQLException {
		return SqlMapLocator.getMapper().queryForList("resultproductlist",
				pageRow);
	}

	/* ========================= 유저 정보 반납 ======================== */
	public MemberBean getUserMethod(String id) throws SQLException {
		return (MemberBean) SqlMapLocator.getMapper().queryForObject(
				"getMemberInfo", id);
	}

	/* ========================= 제품구매 정보 반납 ==================== */
	public OrderBean getOrderDate(String car_no) throws SQLException {
		return (OrderBean) SqlMapLocator.getMapper().queryForObject(
				"resultorderdate", car_no);
	}

	/* ======================== 제품 정보 반납 ========================= */
	public ProductInsertBean getProductMethod(String pro_id)
			throws SQLException {
		return (ProductInsertBean) SqlMapLocator.getMapper().queryForObject(
				"resutlproductmethod", pro_id);
	}

	/* ====================== 구매자 구매신청 ======================== */
	public void insertProductOrder(OrderBean ob) throws SQLException {
		SqlMapLocator.getMapper().insert("insertproductorder", ob);
	}

	/* ================================ 거래성공시 구매제품 업데이트 ================= */
	public void updateOrder_deal_check(String car_no) throws SQLException {
		SqlMapLocator.getMapper().update("updateorderok", car_no);
	}

	/* ================ 거래성공시 제품 업데이트 ================= */
	public void updateProduct_Ok(Map<String, Object> map) throws SQLException {
		SqlMapLocator.getMapper().update("updateproductok", map);
	}

	/* =================== =================== */
	public void deleteproductok(String pro_id) throws SQLException {
		SqlMapLocator.getMapper().update("deleteproductok", pro_id);
	}

	@SuppressWarnings("unchecked")
	public List<OrderBean> getUserDate(String pro_id) throws SQLException {
		return SqlMapLocator.getMapper().queryForList("resultusermassage",
				pro_id);
	}

	public void updateProLevel(String pro_id) throws SQLException {
		SqlMapLocator.getMapper().update("updateprolevel", pro_id);
	}

	public List<ProductInsertBean> getBestProduct() throws SQLException {
		// TODO Auto-generated method stub
		return SqlMapLocator.getMapper().queryForList("bestProduct");
	}

}
