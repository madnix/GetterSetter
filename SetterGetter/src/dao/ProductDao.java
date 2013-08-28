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

	/* ================== ��ǰ��� ===================== */
	public void insertProduct(ProductInsertBean pib) throws Exception {
		SqlMapLocator.getMapper().insert("insertproduct", pib);
	}

	/* ================ ��ǰ��� ��û ================== */
	@SuppressWarnings("unchecked")
	public List<ProductInsertBean> getProductInsertList(String id)
			throws SQLException {
		return SqlMapLocator.getMapper().queryForList(
				"resultproductinsertlist", id);
	}

	/* ===================== ��Ϲ�ǰ �󼼺��� ======================== */
	@SuppressWarnings("unchecked")
	public List<ProductInsertBean> getProductInsertDetailList(String id)
			throws SQLException {
		return SqlMapLocator.getMapper().queryForList("resultProdctDetail", id);
	}

	/* ================== �ӽø���Ʈ ========================= */
	@SuppressWarnings("unchecked")
	public List<ProductInsertBean> getList() throws SQLException {
		return SqlMapLocator.getMapper().queryForList("resultList");
	}

	/* ================== ���̵�� ȸ������ �ݳ� ============== */
	@SuppressWarnings("unchecked")
	public List<MemberBean> getUserListMethod(String id) throws Exception {
		return SqlMapLocator.getMapper().queryForList("getUserList", id);
	}

	/* ================ ��ȸ�� ���� ==================== */
	public void updateHit(String id) throws SQLException {
		SqlMapLocator.getMapper().update("updateHit", id);
	}

	/* ====================== ������ ===================== */
	@SuppressWarnings("unchecked")
	public List<ProductInsertBean> getProductDetail(String id)
			throws SQLException {
		return SqlMapLocator.getMapper().queryForList("resultProdctDetail", id);
	}

	/* ======================== ������ ���Ž�û ������ Ȯ�� ============================= */
	@SuppressWarnings("unchecked")
	public List<ProductInsertBean> getProductDetailOk(String id)
			throws Exception {
		return SqlMapLocator.getMapper().queryForList("resultProductDetailOk",
				id);
	}

	/* ======================= ���Ž�û�� �������� ========================== */
	public void updateProCount(Map resultList) throws SQLException {
		SqlMapLocator.getMapper().update("updateprocount", resultList);
	}

	/* ======================= �ŷ������� �ŷ��� ���� ====================== */
	public void updateProNum(String pro_id) throws SQLException {
		SqlMapLocator.getMapper().update("updatepronum", pro_id);
	}

	/* ======================== �ŷ������� �������� ���� ==================== */
	public void updateUserLevel(String pro_out_id) throws SQLException {
		SqlMapLocator.getMapper().update("updateuserlevel", pro_out_id);
	}

	/* �ش� ������ �ش��ϴ� ��ǰ ���� */
	public int getTotalCnt(String species) throws SQLException {
		return (Integer) SqlMapLocator.getMapper().queryForObject(
				"getTotalCnt", species);
	}

	/* �ش� ������ �ش��ϴ� ��ǰ ����Ʈ */
	public List<ProductInsertBean> getProductInfo(Map<String, Object> pageRow)
			throws SQLException {
		return SqlMapLocator.getMapper()
				.queryForList("getProductInfo", pageRow);
	}

	/* �ش� ���̵� ���� �ش��ϴ� ��ǰ ���� ���� */
	public ProductInsertBean getDetailInfo(String pro_id) throws SQLException {
		return (ProductInsertBean) SqlMapLocator.getMapper().queryForObject(
				"getDetailInfo", pro_id);
	}

	/* ����ȭ�鿡�� �ֱٿ� ���� ��ǰ ���� �������� (�ֱٳ�¥�� ��ȸ�� ���� ��) */
	public List<ProductInsertBean> getRecentlyProduct() throws SQLException {
		return SqlMapLocator.getMapper().queryForList("getRecentlyProduct");
	}

	/* ===================== ��ǰ ��� ���� ī��Ʈ ================= */
	public int getTotalCont(String id) throws SQLException {
		return (Integer) SqlMapLocator.getMapper().queryForObject(
				"getTotalCont", id);
	}

	/* ===================== ��ǰ ��� ���� ����¡ ================= */
	@SuppressWarnings("unchecked")
	public List<ProductInsertBean> selectPage(Map<String, Object> pageRow)
			throws SQLException {
		return SqlMapLocator.getMapper().queryForList("selectpage", pageRow);
	}

	/* ==================== ��ǰ ���� Ȯ�� ī��Ʈ ================= */
	public int getCountForInput(String id) throws SQLException {
		return (Integer) SqlMapLocator.getMapper().queryForObject(
				"getcountforinput", id);
	}

	/* ====================== ��ǰ ���� Ȯ�� ����¡ =============== */
	@SuppressWarnings("unchecked")
	public List<ProductInsertBean> getProductOutputList(
			Map<String, Object> pageRow) throws SQLException {
		return SqlMapLocator.getMapper().queryForList("productoutputlist",
				pageRow);
	}

	/* ======================== ��ǰ ��� ��¥ �ݳ� ================ */
	@SuppressWarnings("unchecked")
	public List<ProductInsertBean> getDate(String id) throws SQLException {
		return SqlMapLocator.getMapper().queryForList("getTime", id);
	}

	/* ======================== 3���� =============================== */
	public void updateProductLevel(Map<String, Object> updateOutput)
			throws SQLException {
		SqlMapLocator.getMapper().update("updateproductlevel", updateOutput);
	}

	/* ====================== ��ǰ ��� ���� ī��Ʈ =========================== */
	public int getCountForProduct(String id) throws SQLException {
		return (Integer) SqlMapLocator.getMapper().queryForObject(
				"resultcountforproduct", id);
	}

	/* ======================= ��ǰ��� ���� ����¡ ==================== */
	@SuppressWarnings("unchecked")
	public List<ProductInsertBean> getProductList(Map<String, Object> pageRow)
			throws SQLException {
		return SqlMapLocator.getMapper().queryForList("resultproductlist",
				pageRow);
	}

	/* ========================= ���� ���� �ݳ� ======================== */
	public MemberBean getUserMethod(String id) throws SQLException {
		return (MemberBean) SqlMapLocator.getMapper().queryForObject(
				"getMemberInfo", id);
	}

	/* ========================= ��ǰ���� ���� �ݳ� ==================== */
	public OrderBean getOrderDate(String car_no) throws SQLException {
		return (OrderBean) SqlMapLocator.getMapper().queryForObject(
				"resultorderdate", car_no);
	}

	/* ======================== ��ǰ ���� �ݳ� ========================= */
	public ProductInsertBean getProductMethod(String pro_id)
			throws SQLException {
		return (ProductInsertBean) SqlMapLocator.getMapper().queryForObject(
				"resutlproductmethod", pro_id);
	}

	/* ====================== ������ ���Ž�û ======================== */
	public void insertProductOrder(OrderBean ob) throws SQLException {
		SqlMapLocator.getMapper().insert("insertproductorder", ob);
	}

	/* ================================ �ŷ������� ������ǰ ������Ʈ ================= */
	public void updateOrder_deal_check(String car_no) throws SQLException {
		SqlMapLocator.getMapper().update("updateorderok", car_no);
	}

	/* ================ �ŷ������� ��ǰ ������Ʈ ================= */
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
